package com.mocha.hellocordova.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.mocha.hellocordova.R;
import com.mocha.hellocordova.adapter.MoudleAdapter;

import com.mocha.hellocordova.cunstomView.ListViewForScrollView;
import com.mocha.hellocordova.pojo.ItemMoudle;

import java.util.ArrayList;
import java.util.List;

public class TotleMoudle extends Fragment {
    private List<ItemMoudle> myBeanList = new ArrayList<>();//用来存放数据的数组
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.total_moudle, container,false);
        ListViewForScrollView listView = view.findViewById(R.id.totalMoudle);
        init();
        MoudleAdapter adapter = new MoudleAdapter(view.getContext(),R.layout.moudle_list_item,myBeanList);

        listView.setAdapter(adapter);
        ScrollView sv = view.findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),"你点击了"+i+"按钮",Toast.LENGTH_SHORT).show();
                Checkable ck = view.findViewById(R.id.headcheck);
                if(ck.isChecked()){
                    ck.setChecked(false);
                }else {
                    ck.setChecked(true);
                }
            }
        });

        return view;
    }
    private void init(){//初始化数据
        ItemMoudle bean1 = new ItemMoudle("aa",R.mipmap.ic_launcher);
        myBeanList.add(bean1);

        ItemMoudle bean2 = new ItemMoudle("ss",R.mipmap.ic_launcher);
        myBeanList.add(bean2);

        ItemMoudle bean3 = new ItemMoudle("jj",R.mipmap.ic_launcher);
        myBeanList.add(bean3);

        ItemMoudle bean4 = new ItemMoudle("hh",R.mipmap.ic_launcher);
        myBeanList.add(bean4);

        ItemMoudle bean5 = new ItemMoudle("dd",R.mipmap.ic_launcher);
        myBeanList.add(bean5);

        ItemMoudle bean6 = new ItemMoudle("cc",R.mipmap.ic_launcher);
        myBeanList.add(bean6);

        ItemMoudle bean7 = new ItemMoudle("bb",R.mipmap.ic_launcher);
        myBeanList.add(bean7);
        ItemMoudle bean8 = new ItemMoudle("jj",R.mipmap.ic_launcher);
        myBeanList.add(bean8);
        ItemMoudle bean9 = new ItemMoudle("kk",R.mipmap.ic_launcher);
        myBeanList.add(bean9);
    }



}
