package com.example.bottomnavigation69;

public class Pizza {
    private String name;
    private int imageResourceId;

    public static final Pizza[] pizzas = {
            new Pizza("나가사키", R.drawable.home1),
            new Pizza("강된장", R.drawable.home2),
            new Pizza("양배추 우삼겹 숙주볶음", R.drawable.home3),
            new Pizza("오삼불고기", R.drawable.home4),
    };

    private Pizza(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
