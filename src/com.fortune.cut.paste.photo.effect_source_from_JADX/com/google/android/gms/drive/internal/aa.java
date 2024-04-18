package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.C0555c;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.ag.C0558a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.List;

public class aa extends C0558a {
    private final int Pm;
    private final C0555c Qw;
    private final C0569a Qx;
    private final List<Integer> Qy;

    /* renamed from: com.google.android.gms.drive.internal.aa.a */
    private static class C0569a extends Handler {
        private final Context mContext;

        private C0569a(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        public void m2034a(C0555c c0555c, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(c0555c, driveEvent)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    Pair pair = (Pair) message.obj;
                    C0555c c0555c = (C0555c) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case DataEvent.TYPE_CHANGED /*1*/:
                            ((ChangeListener) c0555c).onChange((ChangeEvent) driveEvent);
                        case DataEvent.TYPE_DELETED /*2*/:
                            ((CompletionListener) c0555c).onCompletion((CompletionEvent) driveEvent);
                        default:
                            C0634w.m2301o("EventCallback", "Unexpected event: " + driveEvent);
                    }
                default:
                    C0634w.m2299e(this.mContext, "EventCallback", "Don't know how to handle this event");
            }
        }
    }

    public aa(Looper looper, Context context, int i, C0555c c0555c) {
        this.Qy = new ArrayList();
        this.Pm = i;
        this.Qw = c0555c;
        this.Qx = new C0569a(context, null);
    }

    public void bw(int i) {
        this.Qy.add(Integer.valueOf(i));
    }

    public boolean bx(int i) {
        return this.Qy.contains(Integer.valueOf(i));
    }

    public void m2035c(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent iQ = onEventResponse.iQ();
        jx.m5215K(this.Pm == iQ.getType());
        jx.m5215K(this.Qy.contains(Integer.valueOf(iQ.getType())));
        this.Qx.m2034a(this.Qw, iQ);
    }
}
