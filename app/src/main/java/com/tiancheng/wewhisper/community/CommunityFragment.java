package com.tiancheng.wewhisper.community;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.community.adapter.CommunityAdapter;

import static com.tiancheng.wewhisper.community.data.source.CommunityDataManager.getCommunityDatas;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {

    private RecyclerView rv;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv = (RecyclerView)view.findViewById(R.id.rv_community);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new CommunityAdapter(getActivity(), getCommunityDatas()));
    }

}
