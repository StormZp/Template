package com.storm.template.module.main;

import com.storm.mylibrary.base.BaseViewModel;
import com.storm.mylibrary.command.BindingAction;
import com.storm.mylibrary.command.BindingCommand;
import com.storm.template.module.empty.EmptyActivity;
import com.storm.template.module.nav.NavActivity;
import com.storm.template.module.viewpage.ViewPagerActivityActivity;

public class MainViewModel extends BaseViewModel {
    public BindingCommand emptyActivityCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(EmptyActivity.class);
        }
    });
     public BindingCommand  viewPagerActivityCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity( ViewPagerActivityActivity.class);
        }
    });
  public BindingCommand  navActivityCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity( NavActivity.class);
        }
    });

}
