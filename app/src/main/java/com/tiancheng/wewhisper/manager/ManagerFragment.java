package com.tiancheng.wewhisper.manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.manager.adapter.IconBarAdapter;
import com.tiancheng.wewhisper.manager.adapter.IconListAdapter;

import static com.tiancheng.wewhisper.manager.data.source.ManagerDataManager.getManagerIconBarDatas;
import static com.tiancheng.wewhisper.manager.data.source.ManagerDataManager.getManagerIconListDatas;
import static com.tiancheng.wewhisper.manager.data.source.ManagerDataManager.getManagerIconListDatas2;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManagerFragment extends Fragment {

    private RecyclerView iconBar;
    private RecyclerView iconList;
    private RecyclerView iconList2;


    public ManagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manager, container, false);
        initView(view);
        setIconBar();
        setIconList();
        setIconList2();
        return view;
    }



    private void initView(View view) {
        iconBar = (RecyclerView)view.findViewById(R.id.rv_mananger_bar);
        iconList = (RecyclerView)view.findViewById(R.id.rv_mananger_list);
        iconList2 = (RecyclerView)view.findViewById(R.id.rv_mananger_list2);
    }

    private void setIconList() {
        iconList.setLayoutManager(new LinearLayoutManager(getActivity()));
        iconList.setAdapter(new IconListAdapter(getActivity(), getManagerIconListDatas()));
        iconList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private void setIconBar() {
        iconBar.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        iconBar.setAdapter(new IconBarAdapter(getActivity(), getManagerIconBarDatas()));
    }

    private void setIconList2() {
        iconList2.setLayoutManager(new LinearLayoutManager(getActivity()));
        iconList2.setAdapter(new IconListAdapter(getActivity(), getManagerIconListDatas2()));
        iconList2.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }



}
