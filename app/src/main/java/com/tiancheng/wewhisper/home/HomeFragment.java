package com.tiancheng.wewhisper.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.google.vr.sdk.widgets.video.VrVideoView;
import com.tiancheng.wewhisper.R;

import java.io.IOException;


public class HomeFragment extends Fragment {

    private VideoView vv;

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
        vv = view.findViewById(R.id.video_view);

        return view;
    }

}
