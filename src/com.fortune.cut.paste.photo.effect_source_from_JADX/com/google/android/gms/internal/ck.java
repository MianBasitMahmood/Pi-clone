package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public final class ck {

    /* renamed from: com.google.android.gms.internal.ck.a */
    public static final class C1058a implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH;
        private final C1059b qe;
        private final cl qf;

        public C1058a(Context context, C1059b c1059b) {
            this(context, c1059b, false);
        }

        C1058a(Context context, C1059b c1059b, boolean z) {
            this.mH = new Object();
            this.qe = c1059b;
            this.qf = new cl(context, this, this, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (!z) {
                this.qf.connect();
            }
        }

        public final void onConnected(Bundle bundle) {
            Bundle bN;
            Bundle by = bn.by();
            synchronized (this.mH) {
                try {
                    cm bM = this.qf.bM();
                    bN = bM != null ? bM.bN() : by;
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                } catch (Throwable e) {
                    gr.m4777d("Error when get Gservice values", e);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable e2) {
                    gr.m4777d("Error when get Gservice values", e2);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable th) {
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                }
            }
            this.qe.m4355a(bN);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            this.qe.m4355a(bn.by());
        }

        public final void onConnectionSuspended(int i) {
            gr.m4769S("Disconnected from remote ad request service.");
        }
    }

    /* renamed from: com.google.android.gms.internal.ck.b */
    public interface C1059b {
        void m4355a(Bundle bundle);
    }

    public static void m4356a(Context context, C1059b c1059b) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            c1059b.m4355a(bn.by());
        } else {
            C1058a c1058a = new C1058a(context, c1059b);
        }
    }
}
