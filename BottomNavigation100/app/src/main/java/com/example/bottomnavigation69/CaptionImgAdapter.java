package com.example.bottomnavigation69;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/*
각 데이터 항목에 어떤 뷰를 사용할지 지정할 때는 ViewHolder를 사용함.
 */
public class CaptionImgAdapter extends RecyclerView.Adapter<CaptionImgAdapter.ViewHolder> {


    //캡션과 이미지 리소스 ID를 저장하는 변수
    private String[] captions = null;
    private String[] captions1 = null;
    private String[] captions2 = null;
    private int[] imageIds;

    private RListener listener;
    interface RListener {
        void onClick(int position);
    }
    public void setListener(RListener listener) {
        this.listener = listener;
    }
    //생성자를 통해 데이터를 어댑터로 전달해요.
    public CaptionImgAdapter(String[] captions, int[] imageIds, String[] captions1, String[] captions2){
        this.captions = captions;
        this.captions1 = captions1;
        this.captions2 = captions2;
        this.imageIds = imageIds;
    }
   /*
    * 리사이클러 뷰는 뷰 홀더를 이용해 주어진 각 항목에 어떤 뷰를 사용할지 결정합니다.
    * 뷰 홀더란 리사이클러 뷰가 표시하려는 뷰를 저장하는 기능
    * 뷰홀더는 뷰뿐 아니라 레이아웃에서의 위치 등 리사이클러 뷰가 사용할 수 있는 정보도 포함합니다.
    */
    public static class ViewHolder extends RecyclerView.ViewHolder{
    /*
    리사이클러 뷰로 CardView를 표시해야 하므로 ViewHolder가 CardView를 포함하도록 지정해요.
    다른 유형의 데이터를 리사이클러 뷰로 표시하려면 여기서 정의해요.
     */
        private CardView cardView = null;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }
    //리사이클러 뷰가 뷰 홀더를 생성할 때 이 메소드를 호출해요.
    @NonNull
    @Override
    public CaptionImgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


    //뷰 홀더를 인스턴스화하는데 필요한 코드를 위 메소드에 추가합니다.
    //뷰 홀더를 인스턴스화하려면 이전 페이지에서 정의한 ViewHolder의 생성자를 호출해야 합니다.
    //ViewHolder의 콘텐트에 어떤 레이아웃을 사용할지 지정해요.
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_captioned_group,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        //CardView의 ImageView와 TextView에 데이터를 채워요.
        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);

        TextView textView1 = cardView.findViewById(R.id.info_zip);
        textView1.setText(captions1[position]);

        TextView textView2 = cardView.findViewById(R.id.info_date);
        textView2.setText(captions2[position]);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
//captions배열의 길이가 리사이클러 뷰의  항목 수와 같아요.
//얼마나 많은 데이터가 있는지도 어댑터에 알려줘야 합니다.
    @Override
    public int getItemCount() {
        return captions.length;
    }
}
