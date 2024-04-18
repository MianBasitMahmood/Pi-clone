package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.C1145a;
import com.google.android.gms.internal.ff.C1146b;

@ey
public final class fe {

    /* renamed from: com.google.android.gms.internal.fe.a */
    public interface C1137a {
        void m4562a(fj fjVar);
    }

    public static gf m4593a(Context context, fh fhVar, C1137a c1137a) {
        return fhVar.lO.wV ? m4594b(context, fhVar, c1137a) : m4595c(context, fhVar, c1137a);
    }

    private static gf m4594b(Context context, fh fhVar, C1137a c1137a) {
        gr.m4769S("Fetching ad response from local ad request service.");
        gf c1145a = new C1145a(context, fhVar, c1137a);
        c1145a.start();
        return c1145a;
    }

    private static gf m4595c(Context context, fh fhVar, C1137a c1137a) {
        gr.m4769S("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1146b(context, fhVar, c1137a);
        }
        gr.m4773W("Failed to connect to remote ad request service.");
        return null;
    }
}
