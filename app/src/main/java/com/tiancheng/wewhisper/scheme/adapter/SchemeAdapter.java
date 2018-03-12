package com.tiancheng.wewhisper.scheme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.scheme.data.entity.SchemeData;


import java.util.List;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class SchemeAdapter extends RecyclerView.Adapter {

    private OnItemClickListener mOnItemClickListener;
    private Context mContext = null;
    private List<SchemeData> dataList = null;

    public SchemeAdapter(Context mContext, List<SchemeData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_scheme, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).no.setText(dataList.get(position).getNo());
        ((ViewHolder)holder).doctor.setText(dataList.get(position).getDoctor());
        ((ViewHolder)holder).disease.setText(dataList.get(position).getDisease());
        ((ViewHolder)holder).date.setText(dataList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView no;
        TextView doctor;
        TextView disease;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            no = (TextView) itemView.findViewById(R.id.no_item_scheme);
            doctor = (TextView) itemView.findViewById(R.id.doctor_item_scheme);
            disease = (TextView)itemView.findViewById(R.id.disease_item_scheme);
            date = (TextView)itemView.findViewById(R.id.date_item_scheme);
        }
    }

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }
}
