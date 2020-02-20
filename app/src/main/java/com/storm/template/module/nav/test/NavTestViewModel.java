package com.storm.template.module.nav.test;

import com.storm.mylibrary.bean.ObservableString;
import com.storm.mylibrary.command.BindingAction;
import com.storm.mylibrary.command.BindingCommand;
import com.storm.template.R;
import com.storm.template.base.BaseViewModel;

public class NavTestViewModel extends BaseViewModel {
    public ObservableString title = new ObservableString("页面3333333333333333333333333");
    public BindingCommand page2 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startNav(R.id.action_navTestFragment_to_navTest2Fragment);
        }
    });

    @Override
    protected void initData() {

    }
}
