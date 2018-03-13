package com.tiancheng.wewhisper.circle.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.circle.data.entity.CircleData;

import java.util.List;

import static com.tiancheng.wewhisper.util.ImageUtil.getRequestOptions1;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class CircleAdapter extends RecyclerView.Adapter {

    private Context mContext = null;
    private List<CircleData> dataList = null;



    public CircleAdapter(Context mContext, List<CircleData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_circle, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(dataList.get(position).getAvatar()).apply(getRequestOptions1()).into(((ViewHolder)holder).avatar);
        ((ViewHolder)holder).name.setText(dataList.get(position).getName());
        ((ViewHolder)holder).info.setText(dataList.get(position).getInfo());
        ((ViewHolder)holder).followNum.setText(dataList.get(position).getFollowNumes());
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
        TextView followNum;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.avatar_item_circle);
            name = (TextView) itemView.findViewById(R.id.name_item_circle);
            info = (TextView)itemView.findViewById(R.id.info_item_circle);
            followNum = (TextView)itemView.findViewById(R.id.follow_num_item_circle);
        }
    }


}
