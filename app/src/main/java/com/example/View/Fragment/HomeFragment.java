package com.example.View.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.Base.BaseFragment;
import com.example.Base.BaseFragmentDirections;
import com.example.View.Activity.NewsActivity;
import com.example.View.Activity.SearchActivity;
import com.example.View.Activity.SettingActivity;
import com.example.shiyue.R;
import com.skydoves.elasticviews.ElasticCardView;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends BaseFragment {
    public ElasticCardView news_btn;
    private NavController controller;
    private NavDirections nav2SettingDirections;
    private ElasticCardView search_btn;
    private ElasticCardView setting_btn;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void initView(View rootView) {
        news_btn=rootView.findViewById(R.id.news_btn);
        search_btn = rootView.findViewById(R.id.search_btn);
        setting_btn = rootView.findViewById(R.id.setting_btn);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void LoadData() {

    }

    @Override
    protected void getFragmentContext(Context context) {

    }

    @Override
    protected void setOnClickListener() {
            news_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    startActivity(intent);
                }
            });
            search_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Go2Activity(SearchActivity.class);
                }
            });
            setting_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Go2Activity(SettingActivity.class);
                }
            });


    }
    protected void  changeFragment(Fragment targetFragment){

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.from_right,R.anim.slide_left_out,R.anim.from_right,R.anim.slide_left_out)
                .replace(R.id.base_layout_container,targetFragment,null)
                .addToBackStack(null)
                .commit();
/*        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.main_page_container, targetFragment,null)
                .addToBackStack(null)
                .commit();*/
    }
    public void Go2Activity(Class target){
        Intent intent=new Intent(getActivity(),target);
        startActivity(intent);
    }
}
