package com.storm.template.module.item;

import com.storm.mylibrary.base.BaseItemViewModel;
import com.storm.mylibrary.bean.ObservableString;
import com.storm.mylibrary.command.BindingAction;
import com.storm.mylibrary.command.BindingCommand;
import com.storm.mylibrary.utils.TUtil;

public class ItemItemViewModel extends BaseItemViewModel<ItemViewModel> {

    public ObservableString mposition = new ObservableString("");

    public BindingCommand switchClickCommand = new BindingCommand<Void>(new BindingAction() {
        @Override
        public void call() {
            TUtil.getInstance().s("这是第" + mposition.get());
        }
    });

    public ItemItemViewModel(ItemViewModel viewModel, int position) {
        super(viewModel);
        mposition.set("这是第 " + position + " 条");
    }
}
