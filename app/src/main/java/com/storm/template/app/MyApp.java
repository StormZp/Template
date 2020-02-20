package com.storm.template.app;

import com.storm.mylibrary.base.BaseApplication;
import com.storm.mylibrary.utils.Utils;

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
