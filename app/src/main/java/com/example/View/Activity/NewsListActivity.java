package com.example.View.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.Beans.Category;
import com.example.Utils.Constants;
import com.example.Utils.ScaleTransitionPagerTitleView;
import com.example.View.adapter.NewsPagerAdapter;
import com.example.shiyue.R;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsListActivity extends AppCompatActivity {
    private static final String TAG = "NewsListActivity";
    @BindView(R.id.news_indicator)
    public MagicIndicator magicIndicator;
    @BindView(R.id.view_pager_fr)
    public ViewPager viewPager;
    public NewsPagerAdapter newsPagerAdapter = new NewsPagerAdapter(getSupportFragmentManager());
    public FragmentContainerHelper fragmentContainerHelper ;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_newslist);
      viewPager =this.findViewById(R.id.view_pager_fr);
        viewPager.setAdapter(newsPagerAdapter);
      magicIndicator=this.findViewById(R.id.news_indicator);
        LoadData();
        viewPager.setOffscreenPageLimit(0);
        newsPagerAdapter =new NewsPagerAdapter(getSupportFragmentManager());
        fragmentContainerHelper  = new FragmentContainerHelper(magicIndicator);
        initIndicator();
    }

    private void initIndicator() {

        magicIndicator.setBackgroundColor(Color.WHITE);

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setScrollPivotX(0.8f);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {

                return Constants.Category.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(Constants.Category[index]);
                simplePagerTitleView.setTextSize(30);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.btn_blue));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG,"index-----"+index);
                        viewPager.setCurrentItem(index);
                        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                magicIndicator.onPageScrolled(position,positionOffset,positionOffsetPixels);

                            }

                            @Override
                            public void onPageSelected(int position) {
                                 magicIndicator.onPageSelected(position);
                             //这个是重点
                                 fragmentContainerHelper.handlePageSelected(position);
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {
                                  magicIndicator.onPageScrollStateChanged(state);
                            }
                        });
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(3.9f));
                indicator.setYOffset(UIUtil.dip2px(context, 49));
                indicator.setLineHeight(UIUtil.dip2px(context, 5));
                indicator.setLineHeight(UIUtil.dip2px(context,3));
                indicator.setColors(getResources().getColor(R.color.btn_blue));

                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    private void LoadData() {
        List<Category> data = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(-1,"推荐");
        map.put(0,"热门");
        map.put(1,"社会");
        map.put(2,"科技");
        map.put(3,"房产");
        map.put(4,"财经");
        map.put(5,"时尚");
        map.put(6,"游戏");
        map.put(7,"体育");
        map.put(8,"时政");
        map.put(9,"教育");
        map.put(10,"娱乐");
        for (int i = -1; i <=10; i++) {
            Category category = new Category();
            category.setId(i);
            category.setTitle(map.get(i));
            data.add(category);
        }
      newsPagerAdapter.setCategories(data);
    }

    private void setEvent() {


    }
}
