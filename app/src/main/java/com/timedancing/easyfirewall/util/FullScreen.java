package com.timedancing.easyfirewall.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreen {

    /**
     * 隐藏ActionBar和StatusBar
     * @param act
     */
    public static  void hideActionStatusBar(AppCompatActivity act) {
        //set no title bar 需要在setContentView之前调用
        act. requestWindowFeature(Window.FEATURE_NO_TITLE);
        //no status bar
        act.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //特殊情况下
        if (act.getSupportActionBar()!=null) act.getSupportActionBar().hide();
        if (act.getActionBar()!=null) act.getActionBar().hide();
    }


    /**
     * 隐藏 NavigationBar和StatusBar
     * @param act
     */
    public static  void hideBottomStatusBar(AppCompatActivity act) {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = act.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = act.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
