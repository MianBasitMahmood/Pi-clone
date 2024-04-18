package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.internal.bd.C1026a;
import com.google.android.gms.internal.be.C1028a;

@ey
public final class au extends C0757g<be> {
    private static final au oc;

    static {
        oc = new au();
    }

    private au() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static bd m4191a(Context context, ay ayVar, String str, cx cxVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            bd b = oc.m4192b(context, ayVar, str, cxVar);
            if (b != null) {
                return b;
            }
        }
        gr.m4769S("Using AdManager from the client jar.");
        return new C1494u(context, ayVar, str, cxVar, new gs(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private bd m4192b(Context context, ay ayVar, String str, cx cxVar) {
        try {
            return C1026a.m4222f(((be) m2595L(context)).m4223a(C0755e.m2594k(context), ayVar, str, cxVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            gr.m4777d("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.m4777d("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected final be m4193c(IBinder iBinder) {
        return C1028a.m4225g(iBinder);
    }

    protected final /* synthetic */ Object m4194d(IBinder iBinder) {
        return m4193c(iBinder);
    }
}
