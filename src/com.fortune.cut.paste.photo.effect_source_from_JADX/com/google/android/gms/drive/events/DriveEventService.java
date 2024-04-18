package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.C0634w;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.ag.C0558a;
import com.google.android.gms.wearable.DataEvent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private CountDownLatch Pg;
    C0557a Ph;
    boolean Pi;
    int Pj;
    private final String mName;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.1 */
    class C05561 extends Thread {
        final /* synthetic */ CountDownLatch Pk;
        final /* synthetic */ DriveEventService Pl;

        C05561(DriveEventService driveEventService, CountDownLatch countDownLatch) {
            this.Pl = driveEventService;
            this.Pk = countDownLatch;
        }

        public void run() {
            try {
                Looper.prepare();
                this.Pl.Ph = new C0557a(this.Pl);
                this.Pl.Pi = false;
                this.Pk.countDown();
                C0634w.m2300m("DriveEventService", "Bound and starting loop");
                Looper.loop();
                C0634w.m2300m("DriveEventService", "Finished loop");
                if (this.Pl.Pg != null) {
                    this.Pl.Pg.countDown();
                }
            } catch (Throwable th) {
                if (this.Pl.Pg != null) {
                    this.Pl.Pg.countDown();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.a */
    final class C0557a extends Handler {
        final /* synthetic */ DriveEventService Pl;

        C0557a(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        private Message m2010b(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message iE() {
            return obtainMessage(2);
        }

        public final void handleMessage(Message message) {
            C0634w.m2300m("DriveEventService", "handleMessage message type:" + message.what);
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    this.Pl.m2016a((OnEventResponse) message.obj);
                case DataEvent.TYPE_DELETED /*2*/:
                    getLooper().quit();
                default:
                    C0634w.m2301o("DriveEventService", "Unexpected message type:" + message.what);
            }
        }
    }

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.b */
    final class C0559b extends C0558a {
        final /* synthetic */ DriveEventService Pl;

        C0559b(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        public final void m2013c(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.Pl) {
                C0634w.m2300m("DriveEventService", "onEvent: " + onEventResponse);
                this.Pl.iD();
                if (this.Pl.Ph != null) {
                    this.Pl.Ph.sendMessage(this.Pl.Ph.m2010b(onEventResponse));
                } else {
                    C0634w.m2302p("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.Pi = false;
        this.Pj = -1;
        this.mName = str;
    }

    private void m2016a(OnEventResponse onEventResponse) {
        DriveEvent iQ = onEventResponse.iQ();
        C0634w.m2300m("DriveEventService", "handleEventMessage: " + iQ);
        try {
            switch (iQ.getType()) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    onChange((ChangeEvent) iQ);
                    return;
                case DataEvent.TYPE_DELETED /*2*/:
                    onCompletion((CompletionEvent) iQ);
                    return;
                default:
                    C0634w.m2301o(this.mName, "Unhandled event: " + iQ);
                    return;
            }
        } catch (Throwable e) {
            C0634w.m2298a(this.mName, e, "Error handling event: " + iQ);
        }
        C0634w.m2298a(this.mName, e, "Error handling event: " + iQ);
    }

    private boolean bh(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void iD() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.Pj) {
            if (GooglePlayServicesUtil.m1782b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && bh(callingUid)) {
                this.Pj = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.Ph == null && !this.Pi) {
                this.Pi = true;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.Pg = new CountDownLatch(1);
                new C05561(this, countDownLatch).start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        C0634w.m2302p("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new C0559b(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent changeEvent) {
        C0634w.m2301o(this.mName, "Unhandled change event: " + changeEvent);
    }

    public void onCompletion(CompletionEvent completionEvent) {
        C0634w.m2301o(this.mName, "Unhandled completion event: " + completionEvent);
    }

    public synchronized void onDestroy() {
        C0634w.m2300m("DriveEventService", "onDestroy");
        if (this.Ph != null) {
            this.Ph.sendMessage(this.Ph.iE());
            this.Ph = null;
            try {
                if (!this.Pg.await(5000, TimeUnit.MILLISECONDS)) {
                    C0634w.m2301o("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.Pg = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
