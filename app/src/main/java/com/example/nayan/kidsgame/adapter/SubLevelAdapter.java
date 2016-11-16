package com.example.nayan.kidsgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.activity.Class1Activity;
import com.example.nayan.kidsgame.activity.Class2Activity;
import com.example.nayan.kidsgame.activity.Class3Activity;
import com.example.nayan.kidsgame.activity.GoingToAnotherTextActivity;
import com.example.nayan.kidsgame.activity.MathLevel_1Activity;
import com.example.nayan.kidsgame.model.MLock;
import com.example.nayan.kidsgame.model.MSubLevel;
import com.example.nayan.kidsgame.utils.MyDatabase;

import java.util.ArrayList;

/**
 * Created by NAYAN on 9/29/2016.
 */

public class SubLevelAdapter extends RecyclerView.Adapter<SubLevelAdapter.MyViewHolder> {
    private ArrayList<MSubLevel> mSubLevels;
    private MSubLevel mSubLevel = new MSubLevel();
    private MLock mLock=new MLock();
    private Context context;
    private LayoutInflater inflater;
    private MyDatabase db;
    private int count;
    private int subLevel;

    public SubLevelAdapter(Context context) {
        this.context = context;
        mSubLevels = new ArrayList<>();
        db = new MyDatabase(context);
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MSubLevel> mSubLevels) {
        this.mSubLevels = mSubLevels;

        Log.e("log", "setdata:" + mSubLevels.size());
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_image, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mSubLevel = mSubLevels.get(position);
        holder.txtSubLevel.setText(mSubLevel.getName());
        if (mSubLevel.getUnlockNextLevel()==1) {
            holder.imgLock.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mSubLevels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSubLevel;
        ImageView imgLock;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtSubLevel = (TextView) itemView.findViewById(R.id.txtLevel);
            imgLock = (ImageView) itemView.findViewById(R.id.imgLock);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mSubLevel = mSubLevels.get(getAdapterPosition());
                    count = getAdapterPosition();
                    if (mSubLevel.getLid() == 1 && mSubLevel.getUnlockNextLevel()==1) {
                        Intent intent = new Intent(context, Class1Activity.class);
                        intent.putExtra("subLevel", mSubLevel.getName());
                        intent.putExtra("index", getAdapterPosition());
                        intent.putExtra("parentLevel", mSubLevel.getParentName());
                        context.startActivity(intent);
                    } else if (mSubLevel.getLid() == 2 && mSubLevel.getUnlockNextLevel()==1) {
                        Intent intent = new Intent(context, Class2Activity.class);
                        intent.putExtra("subLevel", mSubLevel.getName());
                        intent.putExtra("index", getAdapterPosition());
                        intent.putExtra("parentLevel", mSubLevel.getParentName());
                        context.startActivity(intent);
                    } else if (mSubLevel.getLid() == 3 && mSubLevel.getUnlockNextLevel()==1) {
                        Intent intent = new Intent(context, Class3Activity.class);
                        intent.putExtra("subLevel", mSubLevel.getName());
                        intent.putExtra("parentLevel", mSubLevel.getParentName());
                        context.startActivity(intent);
                    } else if (mSubLevel.getLid() == 4 && mSubLevel.getUnlockNextLevel()==1) {
                        Intent intent = new Intent(context, MathLevel_1Activity.class);
                        intent.putExtra("subLevel", mSubLevel.getName());
                        intent.putExtra("index", getAdapterPosition());
                        intent.putExtra("parentLevel", mSubLevel.getParentName());
                        context.startActivity(intent);
                    } else if (mSubLevel.getLid() == 5 && mSubLevel.getUnlockNextLevel()==1) {
                        Intent intent = new Intent(context, GoingToAnotherTextActivity.class);
                        intent.putExtra("subLevel", mSubLevel.getName());
                        intent.putExtra("index", getAdapterPosition());
                        intent.putExtra("parentLevel", mSubLevel.getParentName());
                        context.startActivity(intent);
                    }

                }
            });
        }
    }


}
