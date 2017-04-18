package com.example.android.sunshine.app.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class WeatherSyncService extends Service {
    public WeatherSyncService() {
    }

    private static final Object sSyncAdapterLock = new Object();
    private static WeatherSyncAdapter weatherSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("SunshineSyncService", "onCreate - SunshineSyncService");
        synchronized (sSyncAdapterLock) {
            if (weatherSyncAdapter == null) {
                weatherSyncAdapter = new WeatherSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return weatherSyncAdapter.getSyncAdapterBinder();
    }
}