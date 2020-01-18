package com.storm.mylibrary.permission;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.storm.mylibrary.R;

import java.util.ArrayList;

public class PermissionActivity extends Activity {
    private static final int REQUEST_PERMISSIONS = 876;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        Intent intent = getIntent();
        String[] permission = intent.getStringArrayExtra("permission");
        if (permission != null) {
            ActivityCompat.requestPermissions(
                    this, permission,
                    REQUEST_PERMISSIONS
            );
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS) {
            ArrayList<String> ps = new ArrayList<>();
            if (grantResults != null) {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i]!=PackageManager.PERMISSION_GRANTED){
                        ps.add(permissions[i]);
                    }
                }
                if (ps.size() != 0 && PermissionUtil.listener != null) {
                    String[] denied = new String[ps.size()];
                    for (int i = 0; i < ps.size(); i++) {
                        denied[i] = ps.get(i);
                    }
                    PermissionUtil.listener.denied(denied);
                } else {
                    if (PermissionUtil.listener != null) {
                        PermissionUtil.listener.granted();
                    }
                }
            } else {
                if (PermissionUtil.listener != null) {
                    PermissionUtil.listener.denied(permissions);
                }
            }
            finish();
        }
    }
}
