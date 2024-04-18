package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0488a implements ServiceConnection {
    boolean Is;
    private final BlockingQueue<IBinder> It;

    public C0488a() {
        this.Is = false;
        this.It = new LinkedBlockingQueue();
    }

    public IBinder gs() throws InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.Is) {
            throw new IllegalStateException();
        } else {
            this.Is = true;
            return (IBinder) this.It.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.It.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
