package com.storm.template.module.sdialog;

import androidx.lifecycle.MutableLiveData;

import com.storm.mylibrary.command.BindingAction;
import com.storm.mylibrary.command.BindingCommand;
import com.storm.template.base.BaseViewModel;

public class SdialogViewModel extends BaseViewModel {
    public MutableLiveData<Integer> showDialog = new MutableLiveData<>();

    @Override
    protected void initData() {

    }

    public BindingCommand click1 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            showDialog.postValue(0);
        }
    });
    public void showDialog(int position){
        showDialog.postValue(position);
    }
}

