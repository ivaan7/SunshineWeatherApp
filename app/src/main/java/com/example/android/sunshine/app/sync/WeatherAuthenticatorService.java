package com.example.android.sunshine.app.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


/**
 * The service which allows the sync adapter framework to access the authenticator.
 */

public class WeatherAuthenticatorService extends Service {
    public WeatherAuthenticatorService() {
    }

    // Instance field that stores the authenticator object
    private WeatherAuthenticator weatherAuthenticator;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        weatherAuthenticator = new WeatherAuthenticator(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return weatherAuthenticator.getIBinder();
    }
}
