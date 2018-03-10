package com.tiancheng.wewhisper.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.test.adapter.TestAdapter;

import static com.tiancheng.wewhisper.test.data.source.TestDataManager.getTestDatas;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {

    private RecyclerView rv;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initView(view);
        setRecyclerView();
        return view;
    }

    private void setRecyclerView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new TestAdapter(getContext(), getTestDatas()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private void initView(View view) {
        rv = (RecyclerView)view.findViewById(R.id.rv_test);
    }

}
