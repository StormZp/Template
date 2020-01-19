package com.storm.template.module.main;

import com.storm.mylibrary.base.BaseViewModel;
import com.storm.mylibrary.command.BindingAction;
import com.storm.mylibrary.command.BindingCommand;
import com.storm.template.module.empty.EmptyActivity;

public class MainViewModel extends BaseViewModel {
    public BindingCommand emptyActivityCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(EmptyActivity.class);
        }
    });
}
