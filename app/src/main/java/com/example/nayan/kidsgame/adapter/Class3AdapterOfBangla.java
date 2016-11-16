package com.example.nayan.kidsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.utils.NLogic;
import com.example.nayan.kidsgame.utils.Utils;

import java.util.ArrayList;

/**
 * Created by NAYAN on 10/1/2016.
 */

public class Class3AdapterOfBangla extends RecyclerView.Adapter<Class3AdapterOfBangla.MyViewHolder> {
    private ArrayList<MContents> textArrayList;

    private MContents mContents = new MContents();
    private Context context;
    private LayoutInflater inflater;
    private NLogic nLogic;

    public Class3AdapterOfBangla(Context context) {
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mContents = textArrayList.get(position);
        if (mContents.getClick() == Utils.IMAGE_ON) {
            if (mContents.getTxt() == null || mContents.getTxt().equals("")) {
                holder.txtContents.setText(mContents.getSen());
            } else {
                holder.txtContents.setText(mContents.getTxt());
            }
        } else {
            holder.txtContents.setText(" ");
        }
        holder.txtContents.setTextColor(0xffff00ff);
        holder.txtContents.setTextSize(20);
    }

    @Override
    public int getItemCount() {
        return textArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtContents;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtContents = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContents = textArrayList.get(getAdapterPosition());
//                    nLogic.textClick(mContents);
//                    if (mContents.getTxt() == null || mContents.getTxt().equals("")) {
////                        Toast.makeText(context, mContents.getSen(), Toast.LENGTH_SHORT).show();
//                    } else {
////                        Toast.makeText(context, mContents.getTxt(), Toast.LENGTH_SHORT).show();
//                    }

                    nLogic.imageClick(mContents, getAdapterPosition(), textArrayList.size());
                }
            });
        }
    }
}
