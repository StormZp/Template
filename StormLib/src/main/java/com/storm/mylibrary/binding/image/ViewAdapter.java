package com.storm.mylibrary.binding.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public final class ViewAdapter {

    @BindingAdapter(value = {"resDraw","resAnim"},requireAll = false)
    public static void setAnimation(ImageView imageView,int resDraw,int resAnim){
        Bitmap  bitmap = BitmapFactory.decodeResource(imageView.getResources(), resDraw);
//        layayoutParams = imageView.getLayoutParams();
        Matrix matrix = new Matrix();
        matrix.setScale(1, 1);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        imageView.setImageBitmap(resizedBitmap);
        Animation animation = (AnimationSet) AnimationUtils.loadAnimation(imageView.getContext(), resAnim);
        imageView.setAnimation(animation);
        animation.setInterpolator(new LinearInterpolator());
    }

    @BindingAdapter(value = {"src"})
    public static void setRes(ImageView imageView,int src){
        imageView.setImageResource(src);
    }
}
