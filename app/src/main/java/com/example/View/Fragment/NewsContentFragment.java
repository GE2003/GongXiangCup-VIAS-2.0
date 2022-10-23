package com.example.View.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Base.BaseFragment;
import com.example.Beans.Category;
import com.example.Beans.NewsMsg;
import com.example.Utils.Constants;
import com.example.View.Activity.ReadingActivity;
import com.example.View.adapter.NewsPagerAdapter;
import com.example.View.adapter.NewsPagerContentAdapter;
import com.example.shiyue.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

public class NewsContentFragment extends BaseFragment implements NewsPagerContentAdapter.OnListItemClickListener {


    public static NewsContentFragment newInstance(Category category){
        NewsContentFragment newsContentFragment = new NewsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ID",category.getId());
        bundle.putString("title",category.getTitle());
        newsContentFragment.setArguments(bundle);
        return newsContentFragment;
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void LoadData() {

    }

    @Override
    public void initView(View rootView) {
        RecyclerView  list = rootView.findViewById(R.id.news_list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsPagerContentAdapter contentAdapter = new NewsPagerContentAdapter();

        contentAdapter.setOnListItemClickListener(this::onItemClick);
        List<NewsMsg> newsMsgList = setData();
        contentAdapter.setDATA(newsMsgList);
        list.setAdapter(contentAdapter);
    }

    public List<NewsMsg> setData(){
        List<NewsMsg> newsMsgs =new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
        NewsMsg newsMsg =new NewsMsg();
            newsMsg.time= Constants.time[i];
            newsMsg.writer=Constants.writter[i];
            newsMsg.title=Constants.title[i];
            newsMsg.read_num=Constants.read_num[i];
            newsMsgs.add(newsMsg);
        }
        System.out.println(newsMsgs.size());
           return newsMsgs;
    }

    @Override
    protected void getFragmentContext(Context context) {

    }

    @Override
    protected void setOnClickListener() {

    }

    @Override
    public void onItemClick(NewsMsg item) {
        Intent intent = new Intent(getActivity(),ReadingActivity.class);
        startActivity(intent);
    }
}
