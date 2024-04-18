package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0426y.C0425a;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.analytics.v */
class C0410v extends aj {
    private static final Object yT;
    private static C0410v zf;
    private Context mContext;
    private Handler mHandler;
    private C0383d yU;
    private volatile C0393f yV;
    private int yW;
    private boolean yX;
    private boolean yY;
    private String yZ;
    private boolean yt;
    private boolean za;
    private boolean zb;
    private C0392e zc;
    private C0407u zd;
    private boolean ze;

    /* renamed from: com.google.android.gms.analytics.v.1 */
    class C04081 implements C0392e {
        final /* synthetic */ C0410v zg;

        C04081(C0410v c0410v) {
            this.zg = c0410v;
        }

        public void m1564B(boolean z) {
            this.zg.m1571a(z, this.zg.za);
        }
    }

    /* renamed from: com.google.android.gms.analytics.v.2 */
    class C04092 implements Callback {
        final /* synthetic */ C0410v zg;

        C04092(C0410v c0410v) {
            this.zg = c0410v;
        }

        public boolean handleMessage(Message message) {
            if (1 == message.what && C0410v.yT.equals(message.obj)) {
                C0426y.eK().m1599D(true);
                this.zg.dispatchLocalHits();
                C0426y.eK().m1599D(false);
                if (this.zg.yW > 0 && !this.zg.ze) {
                    this.zg.mHandler.sendMessageDelayed(this.zg.mHandler.obtainMessage(1, C0410v.yT), (long) (this.zg.yW * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    static {
        yT = new Object();
    }

    private C0410v() {
        this.yW = 1800;
        this.yX = true;
        this.za = true;
        this.zb = true;
        this.zc = new C04081(this);
        this.ze = false;
        this.yt = false;
    }

    public static C0410v eu() {
        if (zf == null) {
            zf = new C0410v();
        }
        return zf;
    }

    private void ev() {
        this.zd = new C0407u(this);
        this.zd.m1563z(this.mContext);
    }

    private void ew() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C04092(this));
        if (this.yW > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (this.yW * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m1569C(boolean z) {
        m1571a(this.ze, z);
    }

    synchronized void m1570a(Context context, C0393f c0393f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.yV == null) {
                this.yV = c0393f;
                if (this.yX) {
                    dispatchLocalHits();
                    this.yX = false;
                }
                if (this.yY) {
                    dW();
                    this.yY = false;
                }
            }
        }
    }

    synchronized void m1571a(boolean z, boolean z2) {
        if (!(this.ze == z && this.za == z2)) {
            if (z || !z2) {
                if (this.yW > 0) {
                    this.mHandler.removeMessages(1, yT);
                }
            }
            if (!z && z2 && this.yW > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (this.yW * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder stringBuilder = new StringBuilder("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            ae.m1487V(stringBuilder.append(str).toString());
            this.ze = z;
            this.za = z2;
        }
    }

    void dW() {
        if (this.yV == null) {
            ae.m1487V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.yY = true;
            return;
        }
        C0426y.eK().m1600a(C0425a.SET_FORCE_LOCAL_DISPATCH);
        this.yV.dW();
    }

    synchronized void dispatchLocalHits() {
        if (this.yV == null) {
            ae.m1487V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.yX = true;
        } else {
            C0426y.eK().m1600a(C0425a.DISPATCH);
            this.yV.dispatch();
        }
    }

    synchronized C0383d ex() {
        if (this.yU == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.yU = new ag(this.zc, this.mContext, new C0400j());
            this.yU.setDryRun(this.yt);
            if (this.yZ != null) {
                this.yU.dV().ad(this.yZ);
                this.yZ = null;
            }
        }
        if (this.mHandler == null) {
            ew();
        }
        if (this.zd == null && this.zb) {
            ev();
        }
        return this.yU;
    }

    synchronized void ey() {
        if (!this.ze && this.za && this.yW > 0) {
            this.mHandler.removeMessages(1, yT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yT));
        }
    }

    synchronized void setLocalDispatchPeriod(int i) {
        if (this.mHandler == null) {
            ae.m1487V("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.yW = i;
        } else {
            C0426y.eK().m1600a(C0425a.SET_DISPATCH_PERIOD);
            if (!this.ze && this.za && this.yW > 0) {
                this.mHandler.removeMessages(1, yT);
            }
            this.yW = i;
            if (i > 0 && !this.ze && this.za) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (i * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }
}
