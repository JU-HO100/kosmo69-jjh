package com.example.bottomnavigation69;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
PizzaFragment에 리사이클러 뷰를 추가할 겁니다.
사용자가 Pizzas탭을 클릭하면 피자카드가 나타납니다.
 */
public class PizzaFragment extends Fragment {
    public PizzaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //바꾼 레이아웃으로 사용
        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_pizza, container, false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            //피자 이름을 문자열 배열에 추가하고 int배열에 피자 이미지를 추가해요.
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            //int 배열에 피자 이미지를 추가해요.
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }
        //배열을 어댑터로 전달해요.
        CaptionImageAdapter adapter = new CaptionImageAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        //두 열을 가진 그리드에 CardView를 표시할 것이므로 GridLayoutManager를 사용해요.
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        //선형레이아웃 LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //엇갈림그리드 레이아웃 관리자
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        pizzaRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionImageAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return pizzaRecycler;
    }
}
