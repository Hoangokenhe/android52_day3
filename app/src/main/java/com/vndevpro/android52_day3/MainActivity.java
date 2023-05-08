package com.vndevpro.android52_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private EditText edtPass;
   private TextView tvHello;

   private Button btn_login;
   private ImageView imgavt;
   private CheckBox cbSaveLogin;
   private RadioGroup rgRender;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPass=findViewById(R.id.edtpass);
        tvHello=findViewById(R.id.tvHello);
        btn_login=findViewById(R.id.btn_Login);
        imgavt=findViewById(R.id.imgavt);
        cbSaveLogin=findViewById(R.id.cbSaveLogin);
        rgRender=findViewById(R.id.rgRender);

        rgRender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        cbSaveLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: "+isChecked);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHello.setText(edtPass.getText().toString());
            }
        });
        btn_login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, ""+edtPass.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(MainActivity.this, ""+edtPass.getText().toString(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "beforeTextChanged: "+s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s);
            }
        });
    }
}