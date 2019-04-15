package com.mocha.hellocordova.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mocha.hellocordova.MainActivity;
import com.mocha.hellocordova.R;
import com.mocha.hellocordova.adapter.NinePartAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyMoudle extends Fragment {
    private Banner banner;
    private View view;

    GridView gridView;
    NinePartAdapter myAdapter;
    ArrayList<HashMap<String, Object>> arrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_moudle, container,false);
        banner=view.findViewById(R.id.banner_home);
        //创建图片集合
        List<String> images = new ArrayList<>();
        images.add("file:///android_asset/www/img/1.png");
        images.add("file:///android_asset/www/img/2.png");
        images.add("file:///android_asset/www/img/3.png");
        List<String> titles = new ArrayList<>();
        titles.add("我是1");
        titles.add("我是2");
        titles.add("我是3");
        banner.setImages(images)//设置图集
                .setDelayTime(3000)//轮播间隔时间
                .setBannerTitles(titles)
                .setBannerAnimation(Transformer.DepthPage)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)//显示圆形指示器和标题（水平显示）
                .setIndicatorGravity(BannerConfig.RIGHT)//指示器居右
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                Toast.makeText(getActivity(),"你点击的是：："+ titles.get(position),Toast.LENGTH_SHORT).show();
                                //ToastUtil.show(getActivity(),"你点击的是：："+position);
                            }
                        }
                )
                .start();

        gridView = view.findViewById(R.id.gridView);
        arrayList = new ArrayList<HashMap<String,Object>>();
        for (int i = 1; i < 10; i++)
             {
                 HashMap<String, Object> hashMap = new HashMap<String, Object>();
                 hashMap.put("image", R.mipmap.moudle);
                 hashMap.put("text", "九宫格"+i);
                 arrayList.add(hashMap);
             }
         myAdapter = new NinePartAdapter(arrayList, view.getContext());
         gridView.setAdapter(myAdapter);
         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                              long arg3) {
                // TODO Auto-generated method stub
                myAdapter.setSelection(arg2);
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                myAdapter.notifyDataSetChanged();
                }
         });
        return view;
    }

    @Override
    public void onResume() {
        banner.stopAutoPlay();
        super.onResume();
    }

    @Override
    public void onPause() {
        banner.stopAutoPlay();
        super.onPause();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

}
