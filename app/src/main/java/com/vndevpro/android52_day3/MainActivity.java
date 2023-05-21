package com.vndevpro.android52_day3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        ButterKnife.bind(this);


        boolean isLogin = getSharedPreferences("LOGIN", MODE_PRIVATE).getBoolean("LOGIN_STATE", false);
        if (isLogin) {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).addToBackStack("ADD").commit();
        } else {
            loginFragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, loginFragment).addToBackStack("ADD").commit();
        }
    }

    LoginFragment loginFragment;

}