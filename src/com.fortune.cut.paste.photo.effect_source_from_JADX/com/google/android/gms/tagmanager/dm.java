package com.google.android.gms.tagmanager;

import com.google.android.gms.C0366R;
import com.google.android.gms.internal.C1071d.C1070a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dm {
    private static bz<C1070a> m6637a(bz<C1070a> bzVar) {
        try {
            return new bz(di.m6618u(dg(di.m6607j((C1070a) bzVar.getObject()))), bzVar.pX());
        } catch (Throwable e) {
            bh.m6462b("Escape URI: unsupported encoding", e);
            return bzVar;
        }
    }

    private static bz<C1070a> m6638a(bz<C1070a> bzVar, int i) {
        if (m6640q((C1070a) bzVar.getObject())) {
            switch (i) {
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    return m6637a(bzVar);
                default:
                    bh.m6458T("Unsupported Value Escaping: " + i);
                    return bzVar;
            }
        }
        bh.m6458T("Escaping can only be applied to strings.");
        return bzVar;
    }

    static bz<C1070a> m6639a(bz<C1070a> bzVar, int... iArr) {
        bz a;
        for (int a2 : iArr) {
            a = m6638a(a, a2);
        }
        return a;
    }

    static String dg(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m6640q(C1070a c1070a) {
        return di.m6612o(c1070a) instanceof String;
    }
}
