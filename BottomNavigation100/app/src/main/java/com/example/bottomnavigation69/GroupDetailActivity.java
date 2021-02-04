package com.example.bottomnavigation69;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class GroupDetailActivity extends AppCompatActivity {
    public static final String EXTRA_GROUP_ID = "groupId";
    public static final String EXTRA_GROUP_ID1 = "groupId";
    public static final String EXTRA_GROUP_ID2 = "groupId";
    private  Button btn_grwvw;
    private  Button btn_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);


        //피자 ID를 이용해 TextView와 ImageView에 데이터를 채워요.
        int groupId = (Integer)getIntent().getExtras().get(EXTRA_GROUP_ID);
        String groupName = GroupData.classes[groupId].getName();
        TextView textView = (TextView)findViewById(R.id.group_text);
        textView.setText(groupName);
        int groupId1 = (Integer)getIntent().getExtras().get(EXTRA_GROUP_ID1);
        String groupZip = GroupData.classes[groupId].getZip();
        TextView textView1 = (TextView)findViewById(R.id.group_text1);
        textView1.setText(groupZip);
        int groupId2 = (Integer)getIntent().getExtras().get(EXTRA_GROUP_ID2);
        String groupDate = GroupData.classes[groupId].getDate();
        TextView textView2 = (TextView)findViewById(R.id.group_text2);
        textView2.setText(groupDate);

        int groupImage = GroupData.classes[groupId].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.group_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, groupImage));
        imageView.setContentDescription(groupName);

        btn_grwvw = findViewById(R.id.btn_grwvw);
        btn_grwvw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupDetailActivity.this,GroupWebViewActivity.class);
                startActivity(intent);
            }
        });
        btn_map = findViewById(R.id.btn_map);
        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupDetailActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
