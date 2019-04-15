package com.mocha.hellocordova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.Utils;


public class LoginActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = findViewById(R.id.subBtn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.subBtn:
                Intent intent = new Intent(LoginActivity.this, TabhostActivity.class);
                //startActivity(intent);
                Utils.getApp().startActivity(intent);
        }
    }
}
