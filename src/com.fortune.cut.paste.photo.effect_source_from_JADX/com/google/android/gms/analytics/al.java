package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0386n.C0384a;

class al extends C0386n<am> {

    /* renamed from: com.google.android.gms.analytics.al.a */
    private static class C0385a implements C0384a<am> {
        private final am Cu;

        public C0385a() {
            this.Cu = new am();
        }

        public void m1514c(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.Cu.Cx = i;
            } else {
                ae.m1488W("int configuration name not recognized:  " + str);
            }
        }

        public void m1515e(String str, String str2) {
            this.Cu.CB.put(str, str2);
        }

        public void m1516e(String str, boolean z) {
            int i = 1;
            am amVar;
            if ("ga_autoActivityTracking".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.Cy = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.Cz = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.CA = i;
            } else {
                ae.m1488W("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C0381m er() {
            return fs();
        }

        public void m1517f(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.Cu.Cv = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.Cu.Cw = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    ae.m1485T("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                ae.m1488W("string configuration name not recognized:  " + str);
            }
        }

        public am fs() {
            return this.Cu;
        }
    }

    public al(Context context) {
        super(context, new C0385a());
    }
}
