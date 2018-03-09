package com.tiancheng.wewhisper.community.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.community.data.entity.CommunityData;
import com.tiancheng.wewhisper.tools.widgets.UpImageView;

import java.util.List;

import static com.tiancheng.wewhisper.util.ImageUtil.getRequestOptions1;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class CommunityAdapter extends RecyclerView.Adapter {

    private Context mContext = null;
    private List<CommunityData> dataList = null;

    public CommunityAdapter(Context mContext, List<CommunityData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_community, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(dataList.get(position).getAvatar()).apply(getRequestOptions1()).into(((ViewHolder)holder).avatar);
        ((ViewHolder)holder).name.setText(dataList.get(position).getName());
        ((ViewHolder)holder).title.setText(dataList.get(position).getTitle());
        ((ViewHolder)holder).content.setText(dataList.get(position).getContent());
        ((ViewHolder)holder).numComment.setText(dataList.get(position).getNumComment());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        UpImageView avatar;
        TextView title;
        TextView name;
        TextView content;
        TextView numComment;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (UpImageView)itemView.findViewById(R.id.item_community_avatar);
            title = (TextView) itemView.findViewById(R.id.item_community_title);
            name = (TextView)itemView.findViewById(R.id.item_community_name);
            content = (TextView)itemView.findViewById(R.id.item_community_content);
            numComment = (TextView)itemView.findViewById(R.id.item_community_num_comment);
        }
    }

}
