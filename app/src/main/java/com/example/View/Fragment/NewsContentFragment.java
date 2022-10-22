package com.example.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import com.example.Base.BaseFragment;
import com.example.Beans.Category;
import com.example.shiyue.R;

public class NewsContentFragment extends BaseFragment {


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
    protected void getFragmentContext(Context context) {

    }

    @Override
    protected void setOnClickListener() {

    }
}
