package com.storm.template.module.empty;

import android.util.Log;

import com.storm.template.base.BaseViewModel;

public class EmptyViewModel extends BaseViewModel {

    public EmptyViewModel( ) {
        Log.e("Storm","我拿到了对象");
    }

    @Override
    protected void initData() {

    }
}

