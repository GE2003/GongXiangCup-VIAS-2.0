package com.example.View.Activity;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.Base.BaseFragment;
import com.example.View.Fragment.HomeFragment;
import com.example.View.Fragment.MineFragment;
import com.example.shiyue.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
   @BindView(R.id.bottom_nav)
    public BottomNavigationView navigationView;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView =this.findViewById(R.id.bottom_nav);
        initFragment();
        setOnChangeListener();
    }

    private void setOnChangeListener() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_page:
                        switchFragment(homeFragment);
                        break;
                    case R.id.my_page:
                        switchFragment(mineFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        switchFragment(homeFragment);
    }

    private void switchFragment(BaseFragment target) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction()
                .setCustomAnimations(R.anim.from_right,R.anim.slide_left_out,R.anim.from_right,R.anim.slide_left_out);
        ft.replace(R.id.fragment_container,target);
        ft.commit();
    }
}