package com.vndevpro.android52_day3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvSingUp;

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtPhoneNunber;

    private static final String TAG = "ActivityLifeCycle " + LoginActivity.class.getName();
    public static final int REQUEST_CODE_SIGNUP = 123;
    public static final int REQUEST_CODE_HOME = 122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        initView();
    }

    private void initView() {
        btnLogin = findViewById(R.id.btnLogin);
        tvSingUp = findViewById(R.id.tv_SingUp);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhoneNunber = findViewById(R.id.edtPhoneNumber);

        tvSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//                startActivityForResult(intent, REQUEST_CODE_SIGNUP);
                activityResultLauncher.launch(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                String phone =edtPhoneNunber.getText().toString();

                UserModel userModel = new UserModel();

                userModel.setPhone(phone);

//                intent.putExtra(Constants.USER_NAME, userName);
//                intent.putExtra(Constants.PASSWORDS, passwords);

                intent.putExtra(Constants.USER,userModel);

                Bundle bundle = new Bundle();
                bundle.putString(Constants.PHONE, phone);



                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        Log.d(TAG, "onActivityResult: " + result.getResultCode());
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
                            UserModel userModel = (UserModel) intent.getSerializableExtra(Constants.USER);
                            Log.d(TAG, "onActivityResult: " + userModel.toString());
                            edtPhoneNunber.setText(userModel.getPhone());
                        }
                    });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SIGNUP) {
            if (resultCode == RESULT_OK) {
                UserModel userModel = (UserModel) data.getSerializableExtra(Constants.USER);
                Log.d(TAG, "onActivityResult: " + userModel.toString());
                edtName.setText(userModel.getName());
                edtPassword.setText(userModel.getPassword());
                edtEmail.setText(userModel.getEmail());
                edtPhoneNunber.setText(userModel.getPhone());
            }
            if (resultCode == RESULT_CANCELED) {
                Log.d(TAG, "onActivityResult: User cancel");
            }
        }
        if (requestCode == REQUEST_CODE_HOME) {

        }
    }
}