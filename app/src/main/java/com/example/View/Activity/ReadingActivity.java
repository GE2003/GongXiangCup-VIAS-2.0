package com.example.View.Activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Beans.CommentMsg;
import com.example.View.adapter.NewsCommentAdapter;
import com.example.shiyue.R;

import java.util.ArrayList;
import java.util.List;

public class ReadingActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        initview();
        loadData();
    }

    private void loadData() {
        NewsCommentAdapter commentAdapter = new NewsCommentAdapter();
        List<CommentMsg> commentMsgs = new ArrayList<>();


        for (int i = 0; i <13 ; i++) {
            CommentMsg commentMsg = new CommentMsg();
            commentMsg.like ="1212";
            commentMsg.name="GE";
            commentMsg.text="Cpp天下无敌";
            commentMsgs.add(commentMsg);
        }
        commentAdapter.setDATA(commentMsgs);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(commentAdapter);
    }

    private void initview() {
        list = this.findViewById(R.id.comment_list);
    }
}
