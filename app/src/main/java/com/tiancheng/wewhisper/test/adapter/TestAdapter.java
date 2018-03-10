package com.tiancheng.wewhisper.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.test.data.entity.TestData;
import com.tiancheng.wewhisper.tools.widgets.UpImageView;

import java.util.List;

import static com.tiancheng.wewhisper.util.ImageUtil.getRequestOptions1;

/**
 * Created by 10919 on 2018/3/6/006.
 */

public class TestAdapter extends RecyclerView.Adapter {

    private Context mContext = null;
    private List<TestData> dataList = null;

    public TestAdapter(Context mContext, List<TestData> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_test, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(dataList.get(position).getImg()).apply(getRequestOptions1()).into(((ViewHolder)holder).img);
        ((ViewHolder)holder).title.setText(dataList.get(position).getTitle());
        ((ViewHolder)holder).content.setText(dataList.get(position).getContent());
        ((ViewHolder)holder).num.setText(dataList.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView title;
        TextView content;
        TextView num;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.iv_item_test);
            title = (TextView) itemView.findViewById(R.id.tv_title_item_test);
            content = (TextView)itemView.findViewById(R.id.tv_content_item_test);
            num = (TextView)itemView.findViewById(R.id.tv_num_item_test);
        }
    }

}
