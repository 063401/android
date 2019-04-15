package com.mocha.hellocordova.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mocha.hellocordova.R;

public class TitleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * 加载布局文件然后返回view，显示在Activity
         */
        View view = inflater.inflate(R.layout.title, container,false);
        return view;
    }

}
