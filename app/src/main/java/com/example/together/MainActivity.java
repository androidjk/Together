package com.example.together;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.together.adapter.MainTopAdapter;
import com.example.together.datautil.DataUtil;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPager main_top;
    public static final boolean STOP = false;
    static int image[]={R.drawable.header_pic_ad1,R.drawable.header_pic_ad2,R.drawable.edit_bg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_top=(ViewPager)findViewById(R.id.viewpager_main_top);
        MainTopAdapter mainTopAdapter=new MainTopAdapter(this,DataUtil.getHeaderImage(this,image) );
        main_top.setAdapter(mainTopAdapter);
        //开启新线程，每两秒更新一次
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!STOP){
                    SystemClock.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            main_top.setCurrentItem(main_top.getCurrentItem()+1);
                        }
                    });
                }
            }
        }).start();
        main_top.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

}
