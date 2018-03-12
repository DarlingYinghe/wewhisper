package com.tiancheng.wewhisper.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.test.adapter.TestAdapter;

import static com.tiancheng.wewhisper.test.data.source.TestDataManager.getTestDatas;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {

    private RecyclerView rv;
   /* private ImageView icMenu;*/

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initView(view);
        setRecyclerView();
        /*setMenu();*/
        return view;
    }

    private void setRecyclerView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new TestAdapter(getContext(), getTestDatas()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private void initView(View view) {
        rv = (RecyclerView)view.findViewById(R.id.rv_test);
       /* icMenu = (ImageView)view.findViewById(R.id.iv_menu_test);*/
    }

    /*private void setMenu() {

        final PopupMenu popupMenu = new PopupMenu(getActivity(), icMenu);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        Menu menu = popupMenu.getMenu();
        menuInflater.inflate(R.menu.menu_test, menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        icMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
    }*/



}
