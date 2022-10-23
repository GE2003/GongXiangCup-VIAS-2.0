package com.example.Base;

import android.content.Context;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.shiyue.R;
import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment extends Fragment {
    private FrameLayout mBaseContainer;
    private View mSuccessView;
    private View mLoadingview;
    private View mErrorView;
    private View mEmptyView;
    private  State currentState=State.SUCCESS;
    private Unbinder unbinder;
    public enum State{
        NONE,LOADING,SUCCESS,ERROR,EMPTY,FAVLOADING,HISLOADING
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.base_layout, container, false);
       mBaseContainer= rootView.findViewById(R.id.base_layout_container);
        getFragmentContext(BaseFragment.this.getActivity());
        LoadStatesView(inflater,container);
        unbinder= ButterKnife.bind(this,rootView);
        initView(rootView);
        LoadData();
        setOnClickListener();
        return rootView;
    }

   public void initView(View rootView){};

    private void   LoadStatesView(LayoutInflater inflater,ViewGroup container){
        //Loading的view
        mLoadingview = loadLoadingview(inflater, container);
        mBaseContainer.addView(mLoadingview);
        //加载成功的界面
        mSuccessView = loadSuccessView(inflater, container);
        mBaseContainer.addView(mSuccessView);
        //错误页面
        mErrorView = loadErrorView(inflater, container);
        mBaseContainer.addView(mErrorView);
        setUpState(State.SUCCESS);
    }
    protected  View loadSuccessView(LayoutInflater inflater, ViewGroup container){
        int resID =getResId();
        return  inflater.inflate(resID,container,false);
    }
    private View loadErrorView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_error,container,false);
    }

    private View loadLoadingview(LayoutInflater inflater, ViewGroup container) {

        return   inflater.inflate(R.layout.fragment_loading,container,false);
    }
    public void setUpState(State currentState) {
        this.currentState=currentState;
        mSuccessView.setVisibility(currentState==State.SUCCESS?View.VISIBLE:View.GONE);
        mLoadingview.setVisibility(currentState==State.LOADING?View.VISIBLE:View.GONE);
        mErrorView.setVisibility(currentState==State.ERROR?View.VISIBLE:View.GONE);
    }
    protected abstract int getResId();
    protected abstract void LoadData();
    protected abstract void getFragmentContext(Context context);
    protected abstract void setOnClickListener();
}
