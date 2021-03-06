package com.tiancheng.wewhisper.manager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.community.data.entity.CommunityData;
import com.tiancheng.wewhisper.manager.data.entity.IconData;
import com.tiancheng.wewhisper.tools.widgets.UpImageView;

import java.util.List;

import static com.tiancheng.wewhisper.util.ImageUtil.getRequestOptions1;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class IconBarAdapter extends RecyclerView.Adapter {

    private Context mContext = null;
    private List<IconData> dataList = null;

    private OnItemClickListener mOnItemClickListener;

    public IconBarAdapter(Context mContext, List<IconData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_manager_bar, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Glide.with(mContext).load(dataList.get(position).getIcon()).apply(getRequestOptions1()).into(((ViewHolder)holder).icon);
        ((ViewHolder)holder).title.setText(dataList.get(position).getTitle());

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
        ImageView icon;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView)itemView.findViewById(R.id.ic_item_manager_bar);
            title = (TextView) itemView.findViewById(R.id.title_item_manager_bar);
        }
    }

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(IconBarAdapter.OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }

}
