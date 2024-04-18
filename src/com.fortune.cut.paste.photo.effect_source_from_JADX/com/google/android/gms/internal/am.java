package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@ey
public class am implements ActivityLifecycleCallbacks {
    private Context mContext;
    private final Object mH;
    private Activity nB;

    public am(Application application, Activity activity) {
        this.mH = new Object();
        application.registerActivityLifecycleCallbacks(this);
        setActivity(activity);
        this.mContext = application.getApplicationContext();
    }

    private void setActivity(Activity activity) {
        synchronized (this.mH) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.nB = activity;
            }
        }
    }

    public Activity getActivity() {
        return this.nB;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.mH) {
            if (this.nB == null) {
                return;
            }
            if (this.nB.equals(activity)) {
                this.nB = null;
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        setActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setActivity(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
