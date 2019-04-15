package com.mocha.hellocordova;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
public class MyApplication extends MultiDexApplication {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        Utils.init(this);
    }

    public static Context getContext(){
        return mContext;
    }

}
