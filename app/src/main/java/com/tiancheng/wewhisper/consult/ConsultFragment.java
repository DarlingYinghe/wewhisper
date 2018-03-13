package com.tiancheng.wewhisper.consult;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netease.nim.uikit.api.NimUIKit;
import com.tiancheng.wewhisper.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultFragment extends Fragment {



    public ConsultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consult, container, false);

        return view;
    }


}
