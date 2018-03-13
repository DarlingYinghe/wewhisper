package com.tiancheng.wewhisper.consult;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nim.uikit.common.ui.dialog.DialogMaker;
import com.netease.nim.uikit.common.util.log.LogUtil;
import com.netease.nim.uikit.impl.cache.DataCacheManager;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.tiancheng.wewhisper.R;
import com.tiancheng.wewhisper.consult.nim.DemoCache;

public class ConsultMain extends AppCompatActivity implements View.OnClickListener {

    private AbortableFuture<LoginInfo> loginRequest;
    String receid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_main);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    /**
     * 登录事件响应函数
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // 打开单聊界面
                NimUIKit.startP2PSession(this, "hello1");
                break;
            case R.id.button2:
                // 打开单聊界面
                NimUIKit.startP2PSession(this, "hello2");
                break;
            case R.id.button3:// 打开单聊界面
                NimUIKit.startP2PSession(this, "hello3");
                break;
            default:
                break;
        }
    }
}
