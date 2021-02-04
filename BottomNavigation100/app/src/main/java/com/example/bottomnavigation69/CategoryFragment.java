package com.example.bottomnavigation69;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import static com.example.bottomnavigation69.R.id.btn_1;

public class CategoryFragment extends Fragment {

    private MainActivity mainActivity;
    private Button btn_1   = null;
    private Button btn_2   = null;

    //한번에 한 아이템만 넘기기
    SnapHelper snapHelper = new PagerSnapHelper();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, null);

        btn_1 = view.findViewById(R.id.btn_1);
        btn_2 = view.findViewById(R.id.btn_2);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, CategoryWebViewActivity.class);
                startActivity(intent);
            }
        });
        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }
}
