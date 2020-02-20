package com.storm.template.module.nav.test2;

import com.storm.mylibrary.bean.ObservableString;
import com.storm.template.base.BaseViewModel;

public class NavTest2ViewModel extends BaseViewModel {
    public ObservableString title = new ObservableString("页面1");

    @Override
    protected void initData() {

    }
}
