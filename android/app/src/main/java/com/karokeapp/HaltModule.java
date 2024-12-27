package com.karokeapp;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class HaltModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public HaltModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "HaltModule";
    }

    @ReactMethod
    public void haltApp() {
        // Get the current activity
        Activity activity = getCurrentActivity();
        if (activity == null) {
            return; // No active activity
        }

        // Run on the UI thread
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(() -> {
            try {
                // Make the app unresponsive
                Window window = activity.getWindow();
                window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                // Optional: Disable hardware buttons
                window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @ReactMethod
    public void restoreApp() {
        // Get the current activity
        Activity activity = getCurrentActivity();
        if (activity == null) {
            return; // No active activity
        }

        // Run on the UI thread
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(() -> {
            try {
                // Restore touch and button functionality
                Window window = activity.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
