package com.storm.mylibrary.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PermissionUtil {

    public static OnPermissionListener listener;

    public static void checkAndRequest(Context context, String[] permissions, OnPermissionListener listener) {
        PermissionUtil.listener = listener;
        ArrayList<String> ps = new ArrayList<String>();

        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permissions[i]
            ) != PackageManager.PERMISSION_GRANTED){
                ps.add(permissions[i]);
            }
        }


        if (ps.size()!=0){
            String[] denied = new String[ps.size()];
            for (int i = 0; i <ps.size() ; i++) {
                denied[i] = ps.get(i);
            }
            Intent intent = new Intent(context,PermissionActivity.class);
            intent.putExtra("permission",denied);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else {
            listener.granted();
        }
    }

    public interface OnPermissionListener{
        void granted();
        void denied(String[] permission);
    }
}