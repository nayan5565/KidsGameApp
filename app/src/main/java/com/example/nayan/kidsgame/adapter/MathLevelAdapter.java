package com.example.nayan.kidsgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.activity.MathLevel_1Activity;
import com.example.nayan.kidsgame.model.MItem;

import java.util.ArrayList;

/**
 * Created by NAYAN on 10/4/2016.
 */

public class MathLevelAdapter extends RecyclerView.Adapter<MathLevelAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MItem> mItems;
    private MItem mItem;

    public MathLevelAdapter(Context context) {
        this.context = context;
        mItems = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MItem> mItems) {
        this.mItems = mItems;
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
        mItem = mItems.get(position);
        holder.textView.setText(mItem.getItem() + "");

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItem = mItems.get(getAdapterPosition());
                    if (mItem.getTag() == 1) {
                        Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
                        itemView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                MathLevel_1Activity.getInstance().preParedisplay();
                            }
                        }, 2000);
                    }
                }
            });
        }
    }
}
