package com.asura.alog;

import android.app.Application;

import com.asura.alog.utils.ALog;

/**
 * Created by Liuxd on 2017/5/11 15:31.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ALog
        ALog.resetSetting();
    }
}
