package com.example.loginrespage;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import jp.tagcast.helper.TGCAdapter;

public class AppInfo extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TGCAdapter tgcAdapter = TGCAdapter.getInstance(getApplicationContext());
        // Đặt khóa API
        tgcAdapter.setApiKey(getString(R.string.tagcast_api_key));
        // Đặt OptimizationMode
        tgcAdapter.setOptimizationMode(true);
        if (checkPermission().size() == 0) {
            // Xử lý ban đầu
            tgcAdapter.prepare();
        }
    }

    public List<String> checkPermission() {
        List<String> permissions = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        return permissions;
    }
}
