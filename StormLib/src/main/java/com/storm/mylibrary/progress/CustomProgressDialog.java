package com.storm.mylibrary.progress;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.storm.mylibrary.R;


public class CustomProgressDialog extends Dialog {

    public CustomProgressDialog(Context context, String msg) {
        this(context, true, R.style.CustomProgressDialog, msg);
    }

    public CustomProgressDialog(Context context, boolean flag, int theme, String msg) {
        super(context, theme);
        this.setContentView(R.layout.dialog_loading);
        setCanceledOnTouchOutside(false);
        this.setCancelable(flag);
        this.getWindow().getAttributes().gravity = Gravity.CENTER;
        TextView tvMsg = (TextView) this.findViewById(R.id.tv);

        if (!TextUtils.isEmpty(msg) && tvMsg != null) {
            tvMsg.setText(msg);
            tvMsg.setVisibility(View.VISIBLE);
        } else {
            tvMsg.setVisibility(View.GONE);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (CustomProgressDialog.this.isShowing()){
                    CustomProgressDialog.this.dismiss();
                }
            }
        },5000);

    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return true;
        return super.onKeyDown(keyCode, event);
    }
}
