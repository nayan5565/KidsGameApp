package com.example.nayan.kidsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.utils.NLogic;

import java.util.ArrayList;

/**
 * Created by NAYAN on 8/20/2016.
 */
public class Class1AdapterOfBangla extends RecyclerView.Adapter<Class1AdapterOfBangla.MyViewholder> {

    private ArrayList<MContents> textArrayList;

    private MContents mContents = new MContents();
    private Context context;
    private LayoutInflater inflater;
    private NLogic nLogic;
   private Animation animation;
    private int subLevelType;


    public Class1AdapterOfBangla(Context context) {
        this.context = context;

        textArrayList = new ArrayList<>();


        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MContents> textArraylist) {
        this.textArrayList = textArraylist;

        Log.e("log", "setdata:" + textArraylist.size());
        nLogic = NLogic.getInstance(context);
        nLogic.callData(textArraylist, this);

        notifyDataSetChanged();
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_row, parent, false);
        MyViewholder viewholder = new MyViewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        mContents = textArrayList.get(position);
        holder.txtContents.setText(mContents.getTxt());
        holder.txtContents.setTextColor(0xffff00ff);

        /*if (levels.getImageOpen()==1){
           //holder.img.setImageResource();
            //MyAnimation.rotation(holder.img,false);
            Glide.with(context).load(SubLevelActivity.IMAGE_URL+levels.getImage())
                    .into(holder.img);*/

//        if (mContents.getImageOpen() == 1) {
//            Bitmap bitmap= BitmapFactory.decodeFile(LevelActivity.getPath(mContents.getImages()));
//            holder.img.setImageBitmap(bitmap);
//        } else {
//            holder.img.setImageResource(R.drawable.place);
//            //holder.img.setVisibility(View.INVISIBLE);
//        }


    }

    @Override
    public int getItemCount() {
        return textArrayList.size();
    }


    class MyViewholder extends RecyclerView.ViewHolder {
        TextView txtContents;

        public MyViewholder(final View itemView) {
            super(itemView);
            txtContents = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContents=textArrayList.get(getAdapterPosition());
//                    nLogic.textClick(mContents);
//                    Toast.makeText(context,mContents.getTxt(), Toast.LENGTH_SHORT).show();
                    nLogic.textClick(mContents,textArrayList.size());
                }
            });
//            img.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    animation = AnimationUtils.loadAnimation(context,R.anim.card_flip_left_out);
//                    img.startAnimation(animation);
//                   // MyAnimation.rotation(img,false);
//                }
//            });
//
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("position", "is" + getAdapterPosition());
//                    mContents = textArrayList.get(getAdapterPosition());
//
////
//                    //MyAnimation.rotation(itemView,false);
//                    Log.e("ADA","pres ID: "+ mContents.getPresentId());
//                    nLogic.imageClick(mContents, getAdapterPosition(), textArrayList.size());
//                }
//            });
        }


    }

}
