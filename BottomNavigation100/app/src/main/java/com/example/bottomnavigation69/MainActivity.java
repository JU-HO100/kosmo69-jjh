package com.example.bottomnavigation69;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "LOGIN";
    MainActivity mainActivity = null;
    //Fragment
    private Fragment categoryFragment;
    private Fragment fragment;
    public FragmentTransaction ft = null;
    private Fragment fragmentzzim;
    private PizzaFragment pizzaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // [ [ 툴바 ] ]
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // [ [ 프래그먼트 ] ]
        fragment = new PizzaFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayout,fragment);
        ft.commitNow();
        fragmentzzim = new ZzimFragment();

        // [ [ 바텀내비게이션 ] ]
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.item_resList:
                        Toast.makeText(getApplicationContext(),"오늘의추천메뉴", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();//프래그먼트 추가
                        removeFragment();//프래그먼트 삭제
                        fragment = new PizzaFragment();
                        ft.add(R.id.frameLayout,fragment);
                        ft.commitNow();
                        return true;
                    case R.id.item_resMake:
                        Toast.makeText(getApplicationContext(),"테마", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();//프래그먼트 추가
                        removeFragment();//프래그먼트 삭제
                        fragment = new CategoryFragment();
                        ft.add(R.id.frameLayout,fragment);
                        ft.commitNow();
                        return true;
                    case R.id.item_logout:
                        Toast.makeText(getApplicationContext(),"쿠킹클래스", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();//프래그먼트 추가
                        removeFragment();//프래그먼트 삭제
                        fragment = new Group();
                        ft.add(R.id.frameLayout,fragment);
                        ft.commitNow();
                        return true;
                }
                if(fragment != null){
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout,fragment);
                    ft.commit();
                    return true;
                }else{
                    startActivity(intent);
                    finish();
                    return true;
                }
            }
        });
    }

    public void removeFragment() {
        for (Fragment fragment: getSupportFragmentManager().getFragments()) {
            if (fragment.isVisible()) {
                ft.remove(fragment).commitNow();
            }
        }
    }

    //버튼처리
    public void onFragmentChange(int index) {
        if (index == 0) {
            //fragment manager 를 이용하여 현재의 fragment를 교체
            //begin transaction를 이용하여 롤백할 수 있도록한다
            //commit를 호출하여 실행
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, pizzaFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.zzin_frag, fragmentzzim).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //메뉴 리소스 파일을 inflate하는 코드 입니다.
        //메뉴 리소스 파일을 자바로 표현한 Menu객체를 생성하고 메뉴 리소스 파일에 포함된 액션을
        //MenuItems로 표현함.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        return super.onCreateOptionsMenu(menu);
    }
    //앱바의 액션을 클릭하면 호출되는 메소드예요.
    /********************************************************************
     *
     * @param item 앱바에서 클릭된 액션임.
     * @return true 클릭한 아이템을 처리했다는 의미
     ********************************************************************/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //액션의 아이디를 얻음.
        switch (item.getItemId()){
            case R.id.action_search:
                //Seach 액션을 클릭하면 OrderActivity를 시작하는 인텐트 임.
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                //클릭한 아이템을 처리했다는 의미로 true를 반환함.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}