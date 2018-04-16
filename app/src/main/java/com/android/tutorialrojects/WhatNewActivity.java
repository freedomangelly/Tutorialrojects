package com.android.tutorialrojects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.tutorialrojects.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freed on 2018/4/16.
 */

public class WhatNewActivity extends Activity {

    private ViewPager pager;
    private Button btnStart;
    private GuideAdapter guideAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_new);
        setupView();
        List<View> list=new ArrayList<View>();
        ImageView img1=new ImageView(this);
        img1.setImageResource(R.drawable.guide_1);
        list.add(img1);
        ImageView img2=new ImageView(this);
        img2.setImageResource(R.drawable.guide_2);
        list.add(img2);
        ImageView img3=new ImageView(this);
        img3.setImageResource(R.drawable.guide_3);
        list.add(img3);

        guideAdapter=new GuideAdapter(list);
        pager.setAdapter(guideAdapter);

//        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    btnStart.setVisibility(View.VISIBLE);
                }else {
                    btnStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupView() {
        pager=findViewById(R.id.view_pager);
        btnStart=findViewById(R.id.start_btn);
    }



    public void doClick(View v){
        switch (v.getId()){
            case R.id.start_btn:
                startActivity(new Intent(WhatNewActivity.this,MainActivity.class));
                break;
        }
    }
}
