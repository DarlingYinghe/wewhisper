package com.tiancheng.wewhisper.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.circle.data.adapter.CircleAdapter;

import static com.tiancheng.wewhisper.circle.data.source.CircleDataManager.getCircleDatas;

public class CircleActivity extends AppCompatActivity {

    private RecyclerView rvCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        initView();
        setRvCircle();
    }

    private void setRvCircle() {
        rvCircle.setLayoutManager(new LinearLayoutManager(this));
        rvCircle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvCircle.setAdapter(new CircleAdapter(this, getCircleDatas()));
    }

    private void initView() {
        rvCircle = (RecyclerView)findViewById(R.id.rv_circle);
    }
}
