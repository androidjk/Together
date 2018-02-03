package com.example.together.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.together.MainActivity;

import java.util.List;

/**
 * Created by asus1 on 2018/2/3.
 */

public class MainTopAdapter extends PagerAdapter {
    protected Context context;
    protected List<ImageView>imageViewList;
    public MainTopAdapter(Context context, List<ImageView>list){
        this.context=context;
        this.imageViewList=list;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(imageViewList.get(position % imageViewList.size()));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       container.addView(imageViewList.get(position%imageViewList.size()));
        return imageViewList.get(position%imageViewList.size());
    }


}
