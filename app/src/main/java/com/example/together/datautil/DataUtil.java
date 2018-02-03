package com.example.together.datautil;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/2/3.
 */

public class DataUtil {

    public static List<ImageView> getHeaderImage(Context context,int recourseId[]){
        List<ImageView>list=new ArrayList<>();
        for (int i=0;i<recourseId.length;i++){
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(recourseId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(imageView);
        }
        return list;
    }
}
