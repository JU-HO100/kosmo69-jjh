package com.example.bottomnavigation69;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private String m_id = null;
    private String m_name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view) {
        EditText et_id = findViewById(R.id.et_id);
        EditText et_pw = findViewById(R.id.et_pw);
        String id = et_id.getText().toString();
        String pw = et_pw.getText().toString();
        Toast.makeText(getApplicationContext(),"이순신님 환영합니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,id);
        intent.putExtra(MainActivity.EXTRA_MESSAGE,pw);
        startActivity(intent);
    }

}