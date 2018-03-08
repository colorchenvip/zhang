package com.colorchen.zhang;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by color on 2018/2/26 19:07.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
