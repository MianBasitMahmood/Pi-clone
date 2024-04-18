package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.fy.C1160a;

@ey
/* renamed from: com.google.android.gms.internal.v */
public class C1497v {
    private C1495a mk;
    private boolean ml;
    private boolean mm;

    /* renamed from: com.google.android.gms.internal.v.a */
    public interface C1495a {
        void m6067e(String str);
    }

    @ey
    /* renamed from: com.google.android.gms.internal.v.b */
    public static class C1496b implements C1495a {
        private final C1160a mn;
        private final gu mo;

        public C1496b(C1160a c1160a, gu guVar) {
            this.mn = c1160a;
            this.mo = guVar;
        }

        public void m6068e(String str) {
            gr.m4769S("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.mn == null || this.mn.vK == null || TextUtils.isEmpty(this.mn.vK.ub))) {
                builder.appendQueryParameter("debugDialog", this.mn.vK.ub);
            }
            gi.m4738c(this.mo.getContext(), this.mo.dG().wS, builder.toString());
        }
    }

    public C1497v() {
        boolean z = false;
        Bundle bN = ga.bN();
        if (bN != null && bN.getBoolean("gads:block_autoclicks", false)) {
            z = true;
        }
        this.mm = z;
    }

    public C1497v(boolean z) {
        this.mm = z;
    }

    public void m6069a(C1495a c1495a) {
        this.mk = c1495a;
    }

    public void av() {
        this.ml = true;
    }

    public boolean az() {
        return !this.mm || this.ml;
    }

    public void m6070d(String str) {
        gr.m4769S("Action was blocked because no click was detected.");
        if (this.mk != null) {
            this.mk.m6067e(str);
        }
    }
}
