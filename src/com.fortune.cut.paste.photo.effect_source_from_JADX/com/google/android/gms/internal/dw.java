package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.internal.dx.C1094a;
import com.google.android.gms.internal.dy.C1100a;

@ey
public final class dw extends C0757g<dy> {
    private static final dw sy;

    /* renamed from: com.google.android.gms.internal.dw.a */
    private static final class C1097a extends Exception {
        public C1097a(String str) {
            super(str);
        }
    }

    static {
        sy = new dw();
    }

    private dw() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static dx m4470b(Activity activity) {
        try {
            if (!m4471c(activity)) {
                return sy.m4472d(activity);
            }
            gr.m4769S("Using AdOverlay from the client jar.");
            return new dp(activity);
        } catch (C1097a e) {
            gr.m4773W(e.getMessage());
            return null;
        }
    }

    private static boolean m4471c(Activity activity) throws C1097a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C1097a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private dx m4472d(Activity activity) {
        try {
            return C1094a.m4446r(((dy) m2595L(activity)).m4476b(C0755e.m2594k(activity)));
        } catch (Throwable e) {
            gr.m4777d("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            gr.m4777d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected final /* synthetic */ Object m4473d(IBinder iBinder) {
        return m4474q(iBinder);
    }

    protected final dy m4474q(IBinder iBinder) {
        return C1100a.m4478s(iBinder);
    }
}
