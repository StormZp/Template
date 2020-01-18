package com.storm.mylibrary.binding.viewgroup;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;

public final class ViewAdpter {
    @BindingAdapter(value = {"addView", "resDraw"}, requireAll = false)
    public static void addView(ViewGroup viewGroup, int addView, int resDraw) {
        if (addView > viewGroup.getChildCount()) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setImageResource(resDraw);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            int margin = (height - width) / 2;

            int left = (int) (Math.random() * width);
            if (left < 100) {
                left += 50;
            } else if (left + 100 > width) {
                left -= 50;
            }
            params.leftMargin = left;
            params.topMargin = (int) (Math.random() * width + margin);
            viewGroup.addView(imageView, params);
        }
    }
}
