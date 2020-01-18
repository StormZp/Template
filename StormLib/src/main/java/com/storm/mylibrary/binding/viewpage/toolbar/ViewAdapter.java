package com.storm.mylibrary.binding.viewpage.toolbar;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BindingAdapter;

public final class ViewAdapter {
    @BindingAdapter(value = {"title"})
    public static void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
    }

    @BindingAdapter(value = {"title"})
    public static void setToolbar(Toolbar toolbar, int title) {
        toolbar.setTitle(title);
    }

}
