package com.tiancheng.wewhisper.scheme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.vr.sdk.widgets.video.VrVideoView;
import com.tiancheng.wewhisper.R;

import java.io.IOException;

public class VrVideoActivity extends AppCompatActivity {

    private VrVideoView vrVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr_video);

        initView();
    }

    private void initView() {
        vrVideo = (VrVideoView)findViewById(R.id.vr_video_scheme);
        try {
            vrVideo.loadVideoFromAsset("congo.mp4", new VrVideoView.Options());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
