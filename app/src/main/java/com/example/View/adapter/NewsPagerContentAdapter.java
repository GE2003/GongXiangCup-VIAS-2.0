package com.example.View.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.example.Beans.NewsMsg;
import com.example.shiyue.R;
import com.skydoves.elasticviews.ElasticCardView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NewsPagerContentAdapter extends RecyclerView.Adapter<NewsPagerContentAdapter.InnerHolder> {
public  OnListItemClickListener mItemClickListener=null;
    private static final String TAG = "NewsPagerContentAdapter";
    List<NewsMsg> data  =new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new InnerHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull InnerHolder holder, int position) {
        NewsMsg newsMsg = data.get(position);
        holder.setData(newsMsg);
        holder.elasticCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                   NewsMsg item = data.get(position);
                    mItemClickListener.onItemClick(item);

                }else {
                    Log.d(TAG,"监听器为空");
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public void setDATA(List<NewsMsg> records) {
        //这里是接收fragment传进来的数据
        data.clear();
        data.addAll(records);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @SuppressLint("NonConstantResourceId")
        public TextView News_title_tv;
         @SuppressLint("NonConstantResourceId")
         public ElasticCardView elasticCardView;
         public TextView writer_name;
         public TextView read_num_tv;
         public TextView time_tv;


        public InnerHolder(@NonNull @NotNull View itemView) {
            //利用itemview找到控件
            super(itemView);
            ButterKnife.bind(this,itemView);
            time_tv = itemView.findViewById(R.id.time_tv);
            elasticCardView=itemView.findViewById(R.id.news_card_view);
             writer_name=itemView.findViewById(R.id.writer_name);
             read_num_tv=itemView.findViewById(R.id.read_tv);
             News_title_tv=itemView.findViewById(R.id.news_title);
        }

        public  void setData(NewsMsg news) {
            //传入数据给每个item的控件
               News_title_tv.setText(news.getTitle());
               writer_name.setText(news.writer);
               time_tv.setText(news.getTime());
               read_num_tv.setText(news.read_num);
        }
    }
    public void  setOnListItemClickListener(OnListItemClickListener listener){
        this.mItemClickListener=listener;
    }


        public interface  OnListItemClickListener  {
        void onItemClick(NewsMsg item);
        }
}
