package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.internal.eo.C1105a;
import com.google.android.gms.internal.ep.C1113a;

@ey
public final class et extends C0757g<ep> {
    private static final et td;

    /* renamed from: com.google.android.gms.internal.et.a */
    private static final class C1117a extends Exception {
        public C1117a(String str) {
            super(str);
        }
    }

    static {
        td = new et();
    }

    private et() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean m4532c(Activity activity) throws C1117a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C1117a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static eo m4533e(Activity activity) {
        try {
            if (!m4532c(activity)) {
                return td.m4534f(activity);
            }
            gr.m4769S("Using AdOverlay from the client jar.");
            return new ee(activity);
        } catch (C1117a e) {
            gr.m4773W(e.getMessage());
            return null;
        }
    }

    private eo m4534f(Activity activity) {
        try {
            return C1105a.m4502w(((ep) m2595L(activity)).m4525c(C0755e.m2594k(activity)));
        } catch (Throwable e) {
            gr.m4777d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.m4777d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected final ep m4535A(IBinder iBinder) {
        return C1113a.m4527x(iBinder);
    }

    protected final /* synthetic */ Object m4536d(IBinder iBinder) {
        return m4535A(iBinder);
    }
}
