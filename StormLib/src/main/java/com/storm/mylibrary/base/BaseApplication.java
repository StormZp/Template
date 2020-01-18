package com.storm.mylibrary.base;

import android.app.Application;

import com.storm.mylibrary.utils.LanguageUtil;
import com.storm.mylibrary.utils.Utils;

public class BaseApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /*library 启动*/
        Utils.init(this);
        LanguageUtil.initLanguage(this);
    }


}
