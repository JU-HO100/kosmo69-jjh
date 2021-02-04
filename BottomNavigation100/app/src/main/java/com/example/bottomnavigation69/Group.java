package com.example.bottomnavigation69;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Group extends Fragment {
    Group(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        //바꾼 레이아웃으로 사용
        RecyclerView groupRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_group, container, false);

        String[] groupNames = new String[GroupData.classes.length];
        for (int i = 0; i < groupNames.length; i++) {
            //피자 이름을 문자열 배열에 추가하고 int배열에 피자 이미지를 추가해요.
            groupNames[i] = GroupData.classes[i].getName();
        }
        int[] groupImages = new int[GroupData.classes.length];
        for (int i = 0; i < groupImages.length; i++) {
            //int 배열에 피자 이미지를 추가해요.
            groupImages[i] = GroupData.classes[i].getImageResourceId();
        }

        String[] groupzips = new String[GroupData.classes.length];
        for (int i = 0; i < groupzips.length; i++) {
            //피자 이름을 문자열 배열에 추가하고 int배열에 피자 이미지를 추가해요.
            groupzips[i] = GroupData.classes[i].getZip();
        }

        String[] groupdates = new String[GroupData.classes.length];
        for (int i = 0; i < groupdates.length; i++) {
            //피자 이름을 문자열 배열에 추가하고 int배열에 피자 이미지를 추가해요.
            groupdates[i] = GroupData.classes[i].getDate();
        }

        //배열을 어댑터로 전달해요.
        CaptionImgAdapter Gradapter = new CaptionImgAdapter(groupNames, groupImages, groupzips, groupdates);
        groupRecycler.setAdapter(Gradapter);
        //두 열을 가진 그리드에 CardView를 표시할 것이므로 GridLayoutManager를 사용해요.
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        //선형레이아웃 LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //엇갈림그리드 레이아웃 관리자
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        groupRecycler.setLayoutManager(layoutManager);
        Gradapter.setListener(new CaptionImgAdapter.RListener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), GroupDetailActivity.class);
                intent.putExtra(GroupDetailActivity.EXTRA_GROUP_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return groupRecycler;
    }
}
