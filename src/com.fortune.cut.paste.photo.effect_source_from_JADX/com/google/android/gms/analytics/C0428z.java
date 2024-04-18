package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0386n.C0384a;

/* renamed from: com.google.android.gms.analytics.z */
class C0428z extends C0386n<aa> {

    /* renamed from: com.google.android.gms.analytics.z.a */
    private static class C0427a implements C0384a<aa> {
        private final aa Bi;

        public C0427a() {
            this.Bi = new aa();
        }

        public void m1601c(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.Bi.Bk = i;
            } else {
                ae.m1488W("int configuration name not recognized:  " + str);
            }
        }

        public void m1602e(String str, String str2) {
        }

        public void m1603e(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.Bi.Bl = z ? 1 : 0;
                return;
            }
            ae.m1488W("bool configuration name not recognized:  " + str);
        }

        public aa eN() {
            return this.Bi;
        }

        public /* synthetic */ C0381m er() {
            return eN();
        }

        public void m1604f(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.Bi.ya = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.Bi.yb = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.Bi.Bj = str2;
            } else {
                ae.m1488W("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0428z(Context context) {
        super(context, new C0427a());
    }
}
