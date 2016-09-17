package com.github.wusuopu.RNIdle;

import android.app.Activity;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNIdleModule extends ReactContextBaseJavaModule {
    public RNIdleModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNIdle";
    }

    @ReactMethod
    public void disableIdleTimer() {
        setIdleTimerDisabled(true);
    }
    @ReactMethod
    public void enableIdleTimer() {
        setIdleTimerDisabled(false);
    }
    public void setIdleTimerDisabled(final boolean disabled) {
        final Activity activity = this.getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (disabled) {
                        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    } else {
                        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    }
                }
            });
        }
    }
}