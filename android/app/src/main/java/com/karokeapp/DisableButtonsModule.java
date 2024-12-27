package com.karokeapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.widget.Toast;
import android.view.View;

public class DisableButtonsModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    // Constructor to initialize the React Application Context
    public DisableButtonsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "DisableButtonsModule";
    }

    // Method to disable hardware buttons
    public void disableButtons() {
    new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
            Activity activity = getCurrentActivity();
            if (activity != null) {
                final View decorView = activity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                );

                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                // Reapply flags on user interaction
                decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        decorView.setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        );
                    }
                });

                Toast.makeText(getReactApplicationContext(), "Buttons disabled", Toast.LENGTH_SHORT).show();
            } else {
                // Log.e("DisableButtonsModule", "Current Activity is null");
            }
        }
    });
}


    // Method to enable hardware buttons (reverse of disable)


}
