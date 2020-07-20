package com.example.mobilrental.activity;



import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilrental.R;
import com.example.mobilrental.helper.LoginDataHelper;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button buttonLogin,buttonRegister;
    LoginDataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);
        dataHelper = new LoginDataHelper(this);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();


                if(username.equals("") || username.trim().isEmpty() || password.equals("") || password.trim().isEmpty() ) {
                    Toast.makeText(LoginActivity.this,"Username Password harus diisi",Toast.LENGTH_LONG).show();
                }
                else
                {
// disini perbedaannya yaitu memanggil fungsi autentikasi yang mengembalikan return boolean
//                    jika username dan password yang di inputkan ada pada database maka return true, jika tidak return false;
                    if(dataHelper.autentikasi(username,password)){
// pindah activity mainactivity
                        Intent mIntent = new Intent(LoginActivity.this,
                                MainActivity.class);
//                        memberikan extra data username
                        mIntent.putExtra("username",username);
//                        berpindah activity
                        startActivity(mIntent);
                    }

                    else{
//                        jika tidak terdaftar menampilkan toast "Login Gagal, username belum terdaftar"
                        Toast.makeText(LoginActivity.this,"Login Gagal , username belum terdaftar",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}