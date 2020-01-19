package com.storm.mylibrary.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.annotations.NonNull;

public class BaseItemViewModel <VM extends SuperBaseViewModel> extends ViewModel {
    public VM viewModel;

    public BaseItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
