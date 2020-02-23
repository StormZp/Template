package com.storm.template.module.sdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

import androidx.lifecycle.Observer;

import com.storm.mylibrary.utils.AppUtil;
import com.storm.mylibrary.view.SDialog;
import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.base.BaseActivity;
import com.storm.template.databinding.SdialogActivityBinding;

public class SdialogActivity extends BaseActivity<SdialogActivityBinding, SdialogViewModel> {
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.sdialog_activity;
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel.showDialog.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch (integer) {
                    case 0: {//普通样式
                        showNormalDialog();
                    }
                    break;
                    case 1: {//下拉样式
                        showBottomDialog();
                    }
                    break;
                    case 2: {//Edittext样式
                        showEdittextDialog();
                    }
                    break;

                }
            }
        });
    }

    private void showNormalDialog() {
        SDialog sDialog = new SDialog.Builder(this)
                .setTitle("普通样式")
                .setMessage("没有新意")
                .setCancel("取消", new SDialog.OnCancelListener() {
                    @Override
                    public void cancel(SDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .addItem("确认")
                .addItem("隐藏")
                .setItemListener(new SDialog.OnItemClickListener() {
                    @Override
                    public void itemClick(SDialog dialog, int position) {
                        if (position == 0) {
                            toast("是普通样式,我确认过了");
                        } else if (position == 1) {
                            toast("隐藏了没有");
                        }
                        dialog.dismiss();
                    }
                })
                .create();
        sDialog.show();
    }

    private void showBottomDialog() {
        SDialog sDialog = new SDialog.Builder(this)
                .setStyle(SDialog.DialogStyle.bottom)
                .setTitle("下拉样式")
                .setMessage("有点新意")
                .setCancel("取消", new SDialog.OnCancelListener() {
                    @Override
                    public void cancel(SDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .addItem("确认")
                .addItem("隐藏")
                .setItemListener(new SDialog.OnItemClickListener() {
                    @Override
                    public void itemClick(SDialog dialog, int position) {
                        if (position == 0) {
                            toast("是普通样式,我确认过了");
                        } else if (position == 1) {
                            toast("隐藏了没有");
                        }
                        dialog.dismiss();
                    }
                })
                .create();
        sDialog.show();
    }

    private void showEdittextDialog() {
        EditText editText = new EditText(this);
        editText.setHint("我可以填充");
        editText.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        editText.setTextSize(AppUtil.dip2Px(this, 16));
        editText.setGravity(Gravity.CENTER);
        SDialog sDialog = new SDialog.Builder(this)
                .setTitle("普通样式")
                .setInsetContent(editText)
                .setCancel("取消", new SDialog.OnCancelListener() {
                    @Override
                    public void cancel(SDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .addItem("确认")
                .setItemListener(new SDialog.OnItemClickListener() {
                    @Override
                    public void itemClick(SDialog dialog, int position) {
                        if (position == 0) {
                            toast("是普通样式,我确认过了");
                        }
                        dialog.dismiss();
                    }
                })
                .create();
        sDialog.show();
    }
}

