package com.tiancheng.wewhisper.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.home.data.entity.ExpertData;


import java.util.List;

import static com.tiancheng.wewhisper.util.ImageUtil.getRequestOptions1;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class ExpertAdapter extends RecyclerView.Adapter {

    private Context mContext = null;
    private List<ExpertData> dataList = null;

    private OnItemClickListener mOnItemClickListener;

    public ExpertAdapter(Context mContext, List<ExpertData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_expert, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(dataList.get(position).getAvatar()).apply(getRequestOptions1()).into(((ViewHolder)holder).avatar);
        ((ViewHolder)holder).name.setText(dataList.get(position).getName());
        ((ViewHolder)holder).info.setText(dataList.get(position).getInfo());
        ((ViewHolder)holder).direct.setText(dataList.get(position).getDirect());
        ((ViewHolder)holder).goodNum.setText(dataList.get(position).getGoodNum());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView avatar;
        TextView name;
        TextView info;
        TextView goodNum;
        TextView direct;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.iv_avatar_item_expert);
            name = (TextView) itemView.findViewById(R.id.tv_name_item_expert);
            info = (TextView)itemView.findViewById(R.id.tv_info_item_expert);
            direct = (TextView)itemView.findViewById(R.id.tv_direct_item_expert);
            goodNum = (TextView)itemView.findViewById(R.id.tv_good_num_item_expert);
        }
    }

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(ExpertAdapter.OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }

}
