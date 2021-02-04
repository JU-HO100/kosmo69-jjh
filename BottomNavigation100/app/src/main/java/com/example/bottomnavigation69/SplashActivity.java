package com.example.bottomnavigation69;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);

        try {
            Thread.sleep(1500);//대기 초 설정
        }catch (InterruptedException e){
            e.printStackTrace();

        }

        //나중에 이걸풀어야 로그인 화면부터 시작합니다.
        //startActivity(new Intent(this,LoginActivity.class));


        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}