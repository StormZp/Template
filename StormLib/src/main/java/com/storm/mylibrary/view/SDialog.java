package com.storm.mylibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.storm.mylibrary.R;
import com.storm.mylibrary.databinding.SDialogBinding;

import java.util.ArrayList;

public class SDialog extends Dialog {
    private TextView cancelTv;

    public SDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public TextView getCancelTv() {
        return cancelTv;
    }

    public static class Builder {
        private Context context;
        private DialogStyle style;
        private OnItemClickListener itemListener;
        private String title; // 对话框标题
        private String message; // 对话框内容
        private ArrayList<String> items;//条目
        private View insertView;//插入内容
        private String cancel_btnText; // 按钮名称“取消”
        private OnCancelListener cancelListener;
        private int itemColor;
        private int cancelColor;
        private int textSize = 16;
        private int bpPadding = 8;

        public Builder(Context context) {
            this.context = context;
            items = new ArrayList<>();
            style = DialogStyle.center;
            itemColor = context.getResources().getColor(R.color.dialog_item);
            cancelColor = context.getResources().getColor(R.color.dialog_cancel);
        }

        public Builder setStyle(DialogStyle style) {
            this.style = style;
            return this;
        }

        /* 设置对话框信息 */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setInsetContent(View view) {
            this.insertView = view;
            return this;
        }

        /**
         * Set the Dialog message from resource
         *
         * @param title
         * @return
         */
        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        /**
         * Set the Dialog title from resource
         *
         * @param title
         * @return
         */
        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTextSize(int size) {
            this.textSize = size;
            return this;
        }

        public Builder setPadding(int size) {
            this.bpPadding = size;
            return this;
        }


        /**
         * Set the Dialog title from String
         *
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder addItem(String item) {
            items.add(item);
            return this;
        }

        public Builder setItemListener(OnItemClickListener listener) {
            this.itemListener = listener;
            return this;
        }

        public Builder setCancel(String cancel, OnCancelListener cancelListener) {
            cancel_btnText = cancel;
            this.cancelListener = cancelListener;
            return this;
        }

        public Builder setItemColor(int itemColor) {
            this.itemColor = itemColor;
            return this;
        }

        public Builder setCancelColor(int cancelColor) {
            this.cancelColor = cancelColor;
            return this;
        }

        public SDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final SDialog dialog = new SDialog(context,
                    style == DialogStyle.bottom ? R.style.ActionSheetDialogStyle : R.style.CustomProgressDialog);
            SDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.s_dialog, null, false);
            binding.clickLay.setBackgroundResource(style == DialogStyle.bottom ? R.drawable.shape_bottom3 : R.drawable.shape_bottom1);

//            View layout = inflater.inflate(R.layout.s_dialog, null);
//            ScrollView.LayoutParams lp =new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
//            lp.gravity = style == DialogStyle.bottom ? Gravity.BOTTOM : Gravity.CENTER;
//            binding.scorllLay.setLayoutParams(lp);


            dialog.addContentView(binding.getRoot(), new RelativeLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            dialog.getWindow().setGravity(style == DialogStyle.bottom ? Gravity.BOTTOM : Gravity.CENTER);

            if (!TextUtils.isEmpty(title)) {
                binding.title.setText(title);
            }
            if (!TextUtils.isEmpty(message)) {
                binding.message.setText(message);
            } else {
                binding.messageRl.setVisibility(View.GONE);
            }

            //加样式
            if (insertView != null) {
                binding.messageRl.addView(insertView);
            }

            //修改布局
            binding.clickLay.setOrientation(style == DialogStyle.bottom ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL);
//            int padding = AppUtil.dip2Px(context, 8);
//            int size = AppUtil.dip2Px(context, 16);

            if (items != null && items.size() != 0) {
                int itemSize = items.size();
                for (int i = 0; i < itemSize; i++) {
//                    binding.clickLay.addView(addView(items.get(i)));
                    TextView view = new TextView(context);
                    view.setText(items.get(i));
                    int finalI = i;
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (itemListener != null)
                                itemListener.itemClick(dialog, finalI);
                        }
                    });
                    view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                            LayoutParams.MATCH_PARENT, 1));
                    view.setGravity(Gravity.CENTER);
                    view.setTextColor(itemColor);
                    view.setTextSize(this.textSize);
                    view.setBackgroundResource((style == DialogStyle.bottom || i != itemSize - 1) ? R.drawable.select_center_middle : R.drawable.select_center_left);
                    view.setPadding(bpPadding, bpPadding, bpPadding, bpPadding);
                    binding.clickLay.addView(view, 0);
                }
            }
            if (TextUtils.isEmpty(cancel_btnText)) {
                binding.cancelBtn.setVisibility(View.GONE);
            }
            binding.cancelBtn.setText(cancel_btnText);
            binding.cancelBtn.setTextSize(this.textSize);
            binding.cancelBtn.setPadding(bpPadding, bpPadding, bpPadding, bpPadding);
            binding.cancelBtn.setTextColor(cancelColor);
            binding.cancelBtn.setBackgroundResource(style == DialogStyle.bottom ? R.drawable.select_bottom : R.drawable.select_center_right);
            binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cancelListener != null)
                        cancelListener.cancel(dialog);
                }
            });
            dialog.cancelTv = binding.cancelBtn;
            return dialog;
        }
    }


    public interface OnItemClickListener {
        void itemClick(SDialog dialog, int position);
    }

    public interface OnCancelListener {
        void cancel(SDialog dialog);
    }

    public enum DialogStyle {
        bottom, center
    }
}
