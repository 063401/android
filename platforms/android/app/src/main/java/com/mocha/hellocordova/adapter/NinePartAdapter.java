package com.mocha.hellocordova.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mocha.hellocordova.R;

import java.util.ArrayList;
import java.util.HashMap;

public class NinePartAdapter extends BaseAdapter
 {
         ArrayList<HashMap<String, Object>> arrayList;
         Context context;
         HashMap<String, Object> hashMap;
         View view;
         int selectItem = -1;
         public NinePartAdapter(ArrayList<HashMap<String, Object>> arrayList, Context context) {
             // TODO Auto-generated constructor stub
            this.arrayList = arrayList;
            this.context = context;
         }

        public void setSelection(int position)
         {
            selectItem = position;
         }

         @Override
        public int getCount() {
             // TODO Auto-generated method stub
            if (null == arrayList)
            {
                return 0;
            }
            else
            {
                return arrayList.size();
            }

         }

           @Override
          public Object getItem(int arg0) {
              // TODO Auto-generated method stub
             return arrayList.get(arg0);
          }

         @Override
          public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
         }

         @SuppressWarnings("unchecked")
         @Override
          public View getView(int arg0, View arg1, ViewGroup arg2) {
              // TODO Auto-generated method stub
             view = LayoutInflater.from(context).inflate(R.layout.ninepartlayout, arg2,false);
             ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
             TextView textView = (TextView)view.findViewById(R.id.textView);
             hashMap = (HashMap<String, Object>) getItem(arg0);
             imageView.setImageResource((Integer) hashMap.get("image"));
             textView.setText((CharSequence) hashMap.get("text"));
             //view.setBackgroundColor(Color.GREEN);

             return view;
          }//设置适配器或更新适配器调用

 }


