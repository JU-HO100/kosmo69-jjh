package com.example.bottomnavigation69;

public class GroupData {
    private String name;
    private int imageResourceId;
    private String zip;
    private String date;

    public static final GroupData[] classes = {
            new GroupData("서울식 육수 불고기", R.drawable.cowstake,"서울시 어쩌고 홍대동","2021-2-1"),
            new GroupData("서울식 육수 불고기", R.drawable.conzzz,"서울시 어쩌고 강남역","2021-2-11"),
            new GroupData("서울식 육수 불고기", R.drawable.chadol,"서울시 어쩌고 송파구","2021-2-12"),
            new GroupData("서울식 육수 불고기", R.drawable.diavolo,"서울시 어쩌고 잠실역","2021-3-1"),

    };

    public GroupData(String name, int imageResourceId, String zip, String date) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.zip = zip;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getZip() {
        return zip;
    }

    public String getDate() {
        return date;
    }


}
