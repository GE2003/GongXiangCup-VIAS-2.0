package com.example.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.shiyue.R;

public class AboutUsActivity extends AppCompatActivity {
    @BindView(R.id.free_back_btn)
    public ImageView free_back_btn;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        free_back_btn=this.findViewById(R.id.free_back_btn);
        free_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this,FreeBackActivity.class);
                startActivity(intent);
            }
        });
    }
}
