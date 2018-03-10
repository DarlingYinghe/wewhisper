package com.tiancheng.wewhisper.community;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.community.adapter.CommunityAdapter;

import static com.tiancheng.wewhisper.community.data.source.CommunityDataManager.getCommunityDatas;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {

    private RecyclerView rv;
    private ImageView icMenu;
    private boolean menuIsShow;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        initView(view);
        setRecyclerView();
        setMenu();
        return view;
    }

    private void setRecyclerView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new CommunityAdapter(getActivity(), getCommunityDatas()));
    }

    private void setMenu() {

        final PopupMenu popupMenu = new PopupMenu(getActivity(), icMenu);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu_community, popupMenu.getMenu());
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
    }

    private void initView(View view) {
        rv = (RecyclerView)view.findViewById(R.id.rv_community);
        icMenu = (ImageView)view.findViewById(R.id.iv_menu_community);
    }

}
