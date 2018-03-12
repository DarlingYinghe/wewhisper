package com.tiancheng.wewhisper.scheme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.scheme.adapter.SchemeAdapter;

import static com.tiancheng.wewhisper.scheme.data.source.SchemeDataManager.getSchemeDatas;

public class SchemeActivity extends AppCompatActivity {

    private RecyclerView schemeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        initView();
        setSchemeList();
    }

    private void setSchemeList() {
        schemeList.setLayoutManager(new LinearLayoutManager(this));
        SchemeAdapter schemeAdapter = new SchemeAdapter(this, getSchemeDatas());
        schemeAdapter.setOnItemClickListener(new SchemeAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(SchemeActivity.this, VrVideoActivity.class));
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        schemeList.setAdapter(schemeAdapter);
    }

    private void initView() {
        schemeList = (RecyclerView)findViewById(R.id.rv_scheme);
    }
}
