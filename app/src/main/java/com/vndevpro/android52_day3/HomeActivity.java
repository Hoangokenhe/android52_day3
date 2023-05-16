package com.vndevpro.android52_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        tvInfo = findViewById(R.id.tvInfo);
        Intent intent = getIntent();
        String phone = intent.getStringExtra(Constants.PHONE);
        tvInfo.setText(" phone : " + phone);


        UserModel userModel = (UserModel) intent.getSerializableExtra(Constants.USER);
        Log.d(TAG, "initView: " + userModel.toString());

    }
}