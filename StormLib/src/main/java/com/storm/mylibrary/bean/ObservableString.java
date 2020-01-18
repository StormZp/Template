package com.storm.mylibrary.bean;

import androidx.databinding.ObservableField;

import com.storm.mylibrary.utils.Utils;

public class ObservableString extends ObservableField<String> {

    public ObservableString(int value) {
        set(Utils.getContext().getResources().getString(value));
    }

    public ObservableString(String value) {
        set(value);
    }

    public ObservableString() {
        set("");
    }

    public void set(int value) {
        super.set(Utils.getContext().getResources().getString(value));
    }
}
