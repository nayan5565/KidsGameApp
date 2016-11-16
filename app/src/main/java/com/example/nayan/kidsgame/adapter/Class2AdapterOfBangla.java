package com.example.nayan.kidsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.utils.NLogic;
import com.example.nayan.kidsgame.model.MContents;

import java.util.ArrayList;

/**
 * Created by NAYAN on 10/2/2016.
 */

public class Class2AdapterOfBangla extends RecyclerView.Adapter<Class2AdapterOfBangla.MyViewHolder> {
    private Context context;
    private ArrayList<MContents> mContentses;
    private MContents mContents;
    private NLogic nLogic;
    private LayoutInflater layoutInflater;

    public Class2AdapterOfBangla(Context context) {
        this.context = context;
        mContentses = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);

    }

    public void setData(ArrayList<MContents> mContentses) {
        this.mContentses = mContentses;

        Log.e("log", "setdata:" + mContentses.size());
        nLogic = NLogic.getInstance(context);
        nLogic.callData(mContentses, this);

        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.image_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mContents=mContentses.get(position);
        holder.txtContent.setText(mContents.getTxt());
        holder.txtContent.setTextColor(0xffff00ff);

    }

    @Override
    public int getItemCount() {
        return mContentses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtContent = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContents=mContentses.get(getAdapterPosition());
                    nLogic.imageClick(mContents,getAdapterPosition(),mContentses.size());
                }
            });
        }
    }
}
