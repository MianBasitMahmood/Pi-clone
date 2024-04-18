package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.C1251f;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class jn implements Callback {
    private static final Object Nd;
    private static jn Ne;
    private final HashMap<String, C1256a> Nf;
    private final Handler mHandler;
    private final Context mO;

    /* renamed from: com.google.android.gms.internal.jn.a */
    final class C1256a {
        private final String Ng;
        private final C1255a Nh;
        private final HashSet<C1251f> Ni;
        private boolean Nj;
        private IBinder Nk;
        private ComponentName Nl;
        final /* synthetic */ jn Nm;
        private int mState;

        /* renamed from: com.google.android.gms.internal.jn.a.a */
        public class C1255a implements ServiceConnection {
            final /* synthetic */ C1256a Nn;

            public C1255a(C1256a c1256a) {
                this.Nn = c1256a;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = iBinder;
                    this.Nn.Nl = componentName;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((C1251f) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    this.Nn.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = null;
                    this.Nn.Nl = componentName;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((C1251f) it.next()).onServiceDisconnected(componentName);
                    }
                    this.Nn.mState = 2;
                }
            }
        }

        public C1256a(jn jnVar, String str) {
            this.Nm = jnVar;
            this.Ng = str;
            this.Nh = new C1255a(this);
            this.Ni = new HashSet();
            this.mState = 2;
        }

        public final void m5103a(C1251f c1251f) {
            this.Ni.add(c1251f);
        }

        public final void m5104b(C1251f c1251f) {
            this.Ni.remove(c1251f);
        }

        public final boolean m5105c(C1251f c1251f) {
            return this.Ni.contains(c1251f);
        }

        public final IBinder getBinder() {
            return this.Nk;
        }

        public final ComponentName getComponentName() {
            return this.Nl;
        }

        public final int getState() {
            return this.mState;
        }

        public final void hA() {
            this.Nj = this.Nm.mO.bindService(new Intent(this.Ng).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), this.Nh, 129);
            if (this.Nj) {
                this.mState = 3;
            } else {
                this.Nm.mO.unbindService(this.Nh);
            }
        }

        public final void hB() {
            this.Nm.mO.unbindService(this.Nh);
            this.Nj = false;
            this.mState = 2;
        }

        public final String hC() {
            return this.Ng;
        }

        public final boolean hD() {
            return this.Ni.isEmpty();
        }

        public final boolean isBound() {
            return this.Nj;
        }
    }

    static {
        Nd = new Object();
    }

    private jn(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.Nf = new HashMap();
        this.mO = context.getApplicationContext();
    }

    public static jn m5106J(Context context) {
        synchronized (Nd) {
            if (Ne == null) {
                Ne = new jn(context.getApplicationContext());
            }
        }
        return Ne;
    }

    public final boolean m5109a(String str, C1251f c1251f) {
        boolean isBound;
        synchronized (this.Nf) {
            C1256a c1256a = (C1256a) this.Nf.get(str);
            if (c1256a != null) {
                this.mHandler.removeMessages(0, c1256a);
                if (!c1256a.m5105c(c1251f)) {
                    c1256a.m5103a((C1251f) c1251f);
                    switch (c1256a.getState()) {
                        case DataEvent.TYPE_CHANGED /*1*/:
                            c1251f.onServiceConnected(c1256a.getComponentName(), c1256a.getBinder());
                            break;
                        case DataEvent.TYPE_DELETED /*2*/:
                            c1256a.hA();
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c1256a = new C1256a(this, str);
            c1256a.m5103a((C1251f) c1251f);
            c1256a.hA();
            this.Nf.put(str, c1256a);
            isBound = c1256a.isBound();
        }
        return isBound;
    }

    public final void m5110b(String str, C1251f c1251f) {
        synchronized (this.Nf) {
            C1256a c1256a = (C1256a) this.Nf.get(str);
            if (c1256a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c1256a.m5105c(c1251f)) {
                c1256a.m5104b(c1251f);
                if (c1256a.hD()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c1256a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case WalletFragmentState.UNKNOWN /*0*/:
                C1256a c1256a = (C1256a) message.obj;
                synchronized (this.Nf) {
                    if (c1256a.hD()) {
                        c1256a.hB();
                        this.Nf.remove(c1256a.hC());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
