package com.vndevpro.android52_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtPhoneNunber;
   private TextView tvLogin;

   private Button btnJohnUs;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        initView();
    }

    private void initView() {
        btnJohnUs = findViewById(R.id.btnJoinUs);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhoneNunber = findViewById(R.id.edtPhoneNumber);

        btnJohnUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                String userName = edtName.getText().toString();
                String passwords = edtPassword.getText().toString();
                String phone =edtPhoneNunber.getText().toString();
                String email = edtEmail.getText().toString();

                UserModel userModel = new UserModel();
                userModel.setName(userName);
                userModel.setPassword(passwords);
                userModel.setPhone(phone);
                userModel.setEmail(email);
                intent.putExtra(Constants.USER, userModel);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}