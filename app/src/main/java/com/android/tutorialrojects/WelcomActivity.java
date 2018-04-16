package com.android.tutorialrojects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.android.tutorialrojects.util.ToolKits;

/**
 * Created by freed on 2018/4/16.
 */

public class WelcomActivity extends Activity {
    private  Handler handler;
    public static final String IS_FIRST="is_frist";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {

                if(ToolKits.fetchBooble(WelcomActivity.this,IS_FIRST,false)){
                    startActivity(new Intent(WelcomActivity.this,WhatNewActivity.class));
                    ToolKits.putBoolean(WelcomActivity.this,IS_FIRST,true);
                }else {
                    startActivity(new Intent(WelcomActivity.this,MainActivity.class));
                }
            }
        };
        handler.sendEmptyMessageDelayed(0,3000);
    }
}
