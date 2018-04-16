package com.android.tutorialrojects.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by freed on 2018/4/16.
 */

public class ToolKits {

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences("com.android.tutorialrojects",Context.MODE_PRIVATE);
    }

    public static void putBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPreferences=getSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public static boolean fetchBooble(Context context,String key,boolean defaultValue){
        return getSharedPreferences(context).getBoolean(key,defaultValue);
    }
}
