package com.storm.mylibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public final class TUtil {
    private Handler handler = new Handler(Looper.getMainLooper());
    private Toast toast = null;
    private Context context;
    private Object synObj = new Object();
    private  static TUtil instance;

    public static TUtil getInstance() {
        if (instance == null)
            synchronized (TUtil.class) {
                if (instance == null) {
                    instance = new TUtil(Utils.getContext());
                }
            }
        return instance;
    }

    private TUtil(Context ctx) {
        context = ctx;
    }

    /**
     * Toast发送消息，默认Toast.LENGTH_SHORT
     *
     * @param msg
     */
    public void s(final String msg) {
        show(context, msg, Toast.LENGTH_SHORT);
    }

    /**
     * Toast发送消息，默认Toast.LENGTH_SHORT
     *
     * @param msg
     */
    public void s(final int msg) {
        show(context, msg, Toast.LENGTH_SHORT);
    }

    /**
     * Toast发送消息，默认Toast.LENGTH_LONG
     *
     * @param msg
     */
    public void l(final String msg) {
        show(context, msg, Toast.LENGTH_LONG);
    }


    /**
     * Toast发送消息
     *
     * @param act
     * @param msg
     * @param len
     */
    private void show(final Context act, final String msg,
                      final int len) {
        new Thread(new Runnable() {
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        synchronized (synObj) {
                            if (toast != null) {
                                toast.setText(msg);
                                toast.setDuration(len);
                            } else {
                                toast = Toast.makeText(act, msg, len);
                            }
                            toast.show();
                        }
                    }
                });
            }
        }).start();
    }

    /**
     * Toast发送消息
     *
     * @param act
     * @param msg
     * @param len
     */
    private void show(final Context act, final int msg,
                      final int len) {
        new Thread(new Runnable() {
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        synchronized (synObj) {
                            if (toast != null) {
                                toast.setText(msg);
                                toast.setDuration(len);
                            } else {
                                toast = Toast.makeText(act, msg, len);
                            }
                            toast.show();
                        }
                    }
                });
            }
        }).start();
    }

}
