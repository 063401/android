package com.mocha.hellocordova.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mocha.hellocordova.R;
import com.mocha.hellocordova.pojo.ItemMoudle;

import java.util.List;

public class MoudleAdapter extends ArrayAdapter {

    private final int ImageId;
    private String radiotext;
    Context context;
    public MoudleAdapter(Context context, int headImage, List<ItemMoudle> obj){
        super(context,headImage,obj);
        this.context = context;
        ImageId = headImage;//这个是传入我们自己定义的界面

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemMoudle myBean = (ItemMoudle) getItem(position);
        View view = LayoutInflater.from(context).inflate(ImageId,parent,false);//这个是实例化一个我们自己写的界面Item
        LinearLayout linearLayout = view.findViewById(R.id.ll_view);
        ImageView headImage = view.findViewById(R.id.headimage);
        TextView headText = view.findViewById(R.id.headtext);
        CheckBox radio = view.findViewById(R.id.headcheck);
        headImage.setImageResource(myBean.getImageID());
        headText.setText(myBean.getText());

        linearLayout.setOnClickListener(new View.OnClickListener() {//检查哪一项被点击了
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"你点击了第"+position+"项"+"你选择"+headText.getText()+"当前checkbox为"+radio.isChecked(),Toast.LENGTH_SHORT).show();
                if(radio.isChecked()){
                    radio.setChecked(false);
                }else{
                    radio.setChecked(true);
                }
            }
        });
        return view;
    }
}

