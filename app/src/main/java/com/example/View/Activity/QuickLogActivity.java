package com.example.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.shiyue.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticCardView;

public class QuickLogActivity extends AppCompatActivity {
    @BindView(R.id.quick_login_btn)
    public ElasticButton login_btn;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicklog);
        ButterKnife.bind(this);
        login_btn=this.findViewById(R.id.quick_login_btn);
        setOnCLickListener();
    }

    private void setOnCLickListener() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuickLogActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
