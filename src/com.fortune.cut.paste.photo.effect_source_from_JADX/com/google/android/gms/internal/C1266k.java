package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.k */
public class C1266k {
    private String kU;
    private String kV;
    private String kW;
    private String[] kX;
    private C1162g kY;

    public C1266k(C1162g c1162g) {
        this.kU = "googleads.g.doubleclick.net";
        this.kV = "/pagead/ads";
        this.kW = "ad.doubleclick.net";
        this.kX = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.kY = c1162g;
    }

    private Uri m5233a(Uri uri, Context context, String str, boolean z) throws C1280l {
        try {
            boolean a = m5239a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C1280l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C1280l("Query parameter already exists: ms");
            }
            String a2 = z ? this.kY.m4682a(context, str) : this.kY.m4681a(context);
            return a ? m5235b(uri, "dc_ms", a2) : m5234a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C1280l("Provided Uri is not in a valid state");
        }
    }

    private Uri m5234a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m5235b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public C1162g m5236C() {
        return this.kY;
    }

    public Uri m5237a(Uri uri, Context context) throws C1280l {
        try {
            return m5233a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C1280l("Provided Uri is not in a valid state");
        }
    }

    public void m5238a(MotionEvent motionEvent) {
        this.kY.m4684a(motionEvent);
    }

    public boolean m5239a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.kW);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m5240b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kX) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
