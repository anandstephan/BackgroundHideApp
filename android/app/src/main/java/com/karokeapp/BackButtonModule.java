package com.karokeapp;

import android.app.Activity;
import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BackButtonModule extends ReactContextBaseJavaModule {

    private boolean isBackPressOverridden = false; // Flag to control back press behavior

    public BackButtonModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BackButtonModule";
    }

    @ReactMethod
    public void enableCustomBackPress() {
        isBackPressOverridden = true;
        Activity activity = getCurrentActivity();
        if (activity != null) {
            Toast.makeText(activity, "Custom Back Press Enabled", Toast.LENGTH_SHORT).show();
        }
    }

    @ReactMethod
    public void disableCustomBackPress() {
        isBackPressOverridden = false;
        Activity activity = getCurrentActivity();
        if (activity != null) {
            Toast.makeText(activity, "Custom Back Press Disabled", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isCustomBackPressEnabled() {
        return isBackPressOverridden;
    }
}
