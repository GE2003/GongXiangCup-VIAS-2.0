package com.example.View.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Beans.CommentMsg;
import com.example.Beans.NewsMsg;
import com.example.shiyue.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NewsCommentAdapter extends RecyclerView.Adapter<NewsCommentAdapter.InnerHolder> {
    List<CommentMsg> data= new ArrayList<>();
    @NonNull
    @NotNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull InnerHolder holder, int position) {
        CommentMsg commentMsg = data.get(position);
        holder.setData(commentMsg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setDATA(List<CommentMsg> records) {
        //这里是接收fragment传进来的数据
        data.clear();
        data.addAll(records);
        notifyDataSetChanged();
    }
    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView like;
        private final TextView text;

        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.comment_name);
            like = itemView.findViewById(R.id.comment_like);
            text = itemView.findViewById(R.id.comment_text);
        }
        public  void setData(CommentMsg news) {
            //传入数据给每个item的控件
            name.setText(news.name);
            like.setText(news.like);
            text.setText(news.text);
        }
    }
}
