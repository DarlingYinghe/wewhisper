package com.tiancheng.wewhisper.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.google.vr.sdk.widgets.video.VrVideoView;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.home.adapter.ExpertAdapter;
import com.tiancheng.wewhisper.main.MainActivity;
import com.tiancheng.wewhisper.manager.adapter.IconBarAdapter;
import com.tiancheng.wewhisper.util.GlideImageLoder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.io.IOException;

import static com.tiancheng.wewhisper.home.data.source.HomeDataManager.getBannerImages;
import static com.tiancheng.wewhisper.home.data.source.HomeDataManager.getExpertDatas;
import static com.tiancheng.wewhisper.home.data.source.HomeDataManager.getHomeIconDatas;


public class HomeFragment extends Fragment {

    /*private VideoView vv;*/
    private Banner banner;
    private RecyclerView rvConsult;
    private RecyclerView rvIcon;
    private TabLayout navBar;
    private ScrollView sv;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        /*vv = view.findViewById(R.id.video_view);*/
        initView(view);
        setBanner();
        setExpertList();
        setIconBar();
        setNavBar();
        return view;
    }

    private void setNavBar() {
        sv.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

            }
        });
    }

    private void setIconBar() {
        rvIcon.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        rvIcon.setAdapter(new IconBarAdapter(getActivity(), getHomeIconDatas()));
    }

    private void setExpertList() {
        rvConsult.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rvConsult.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvConsult.setAdapter(new ExpertAdapter(getActivity(), getExpertDatas()));
    }

    private void setBanner() {
        banner.setImageLoader(new GlideImageLoder());
        banner.setImages(getBannerImages());
        banner.isAutoPlay(true);
        banner.setDelayTime(1500);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }

    private void initView(View view) {
        banner = (Banner)view.findViewById(R.id.home_banner);
        rvConsult = (RecyclerView)view.findViewById(R.id.rv_consult_home);
        rvIcon = (RecyclerView)view.findViewById(R.id.rv_ic_bar_home);
        navBar = (TabLayout)getActivity().findViewById(R.id.nav_bar);
        sv = (ScrollView)view.findViewById(R.id.sv_home);
    }



}
