package com.example.nayan.kidsgame.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.activity.SubLevelActivity;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.model.MLock;
import com.example.nayan.kidsgame.model.MSubLevel;
import com.example.nayan.kidsgame.utils.Global;
import com.example.nayan.kidsgame.utils.MyDatabase;
import com.example.nayan.kidsgame.utils.NLogic;

import java.util.ArrayList;

/**
 * Created by NAYAN on 8/3/2016.
 */
public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.MyViewholder> {


    private ArrayList<MContents> textArrayList;

    private MContents mContents = new MContents();
    private Context context;
    private LayoutInflater inflater;
    private NLogic nLogic;
    private Animation animation;
    private int subLevelType;
    private int index;
    private Paint paint;
    Path path;
    private Canvas canvas;


    public LevelAdapter(Context context) {
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


//        holder.txtLevel.setTextColor(0xffff00ff);
//        if (mLevel.getBestpoint() == 100) {
//            holder.txtLevelStar.setText(getIntToStar(3));
////            holder.imgStar.setImageResource(R.drawable.star);
//        } else if (mLevel.getBestpoint() == 75) {
//            holder.txtLevelStar.setText(getIntToStar(2));
////            holder.imgStar.setImageResource(R.drawable.star2);
//        } else if (mLevel.getBestpoint() == 50) {
//            holder.txtLevelStar.setText(getIntToStar(1));
////            holder.imgStar.setImageResource(R.drawable.star_icon);
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
                    mContents = textArrayList.get(getAdapterPosition());
                    index = getAdapterPosition();
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_text);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    final TextView txtText = (TextView) dialog.findViewById(R.id.txtText);
                    ImageView btnForward = (ImageView) dialog.findViewById(R.id.btnForward);
                    ImageView btnBackward = (ImageView) dialog.findViewById(R.id.btnPrev);
                    btnForward.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index++;

                            if (index >= textArrayList.size()) {
                                final Dialog dialog1 = new Dialog(context);
                                paint=new Paint(Paint.ANTI_ALIAS_FLAG);
                                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog1.setContentView(R.layout.level_clear);
                                TextView textView=(TextView)dialog1.findViewById(R.id.txtClear);
//                                paint.setStyle(Paint.Style.FILL_AND_STROKE);
//                                path=new Path();
//                                RectF oval = new RectF(50,100,200,250);
//                                path.addArc(oval, -180, 200);
//                                canvas=new Canvas();
//                                canvas.drawTextOnPath("bangladesh",path,0,20,paint);
//                                textView.draw(canvas);
                                ImageView imgMenu = (ImageView) dialog1.findViewById(R.id.imgMenu);
                                ImageView imgReload = (ImageView) dialog1.findViewById(R.id.imgReload);
                                ImageView imgForward = (ImageView) dialog1.findViewById(R.id.imgForward);
                                imgReload.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                dialog1.show();
                                index = 0;
                                dialog.dismiss();
                                MSubLevel mSubLevel= SubLevelActivity.mSubLevels.get(Global.INDEX_POSISION+1);
                                MLock mLock=new MLock();
                                mLock.setId(mSubLevel.getLid());
                                mLock.setUnlockNextLevel(1);
                                MyDatabase db=new MyDatabase(context);
                                db.addLockData(mLock);
                                return;
                            } else {
                                txtText.setText(textArrayList.get(index).getTxt());

                            }

//                            GoingToAnotherTextActivity.getInstance().changeText(txtText);

                        }
                    });
                    btnBackward.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index--;
                            if (index == -1) {
                                Toast.makeText(context, "completed", Toast.LENGTH_SHORT).show();
                                index = 0;
                                dialog.dismiss();
                                return;
                            } else {
                                txtText.setText(textArrayList.get(index).getTxt());

                            }
                        }
                    });
                    txtText.setText(mContents.getTxt());
                    dialog.show();
                }
            });
        }


    }

}
