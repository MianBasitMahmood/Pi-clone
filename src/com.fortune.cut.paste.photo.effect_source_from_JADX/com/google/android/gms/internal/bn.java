package com.google.android.gms.internal;

import android.os.Bundle;

@ey
public final class bn {
    public static iy<String> ph;
    public static iy<String> pi;
    public static iy<Boolean> pj;
    public static iy<Boolean> pk;
    public static iy<Boolean> pl;
    public static iy<String> pm;
    public static iy<Boolean> pn;
    public static iy<String> po;
    public static iy<Boolean> pp;
    public static iy<Integer> pq;
    public static iy<Integer> pr;
    public static iy<Integer> ps;
    public static iy<Integer> pt;
    public static iy<Integer> pu;
    private static final Bundle pv;
    private static boolean pw;

    static {
        pv = new Bundle();
        pw = false;
        ph = m4259a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
        pi = m4259a("gads:sdk_core_experiment_id", null);
        pj = m4260c("gads:sdk_crash_report_enabled", false);
        pk = m4260c("gads:sdk_crash_report_full_stacktrace", false);
        pl = m4260c("gads:block_autoclicks", false);
        pm = m4259a("gads:block_autoclicks_experiment_id", null);
        pw = true;
        pp = m4260c("gads:enable_content_fetching", false);
        pq = m4258a("gads:content_length_weight", 1);
        pr = m4258a("gads:content_age_weight", 1);
        ps = m4258a("gads:min_content_len", 11);
        pt = m4258a("gads:fingerprint_number", 10);
        pu = m4258a("gads:sleep_sec", 10);
        pn = m4260c("gads:spam_app_context:enabled", false);
        po = m4259a("gads:spam_app_context:experiment_id", null);
    }

    private static iy<Integer> m4258a(String str, int i) {
        pv.putInt(str, i);
        return iy.m5063a(str, Integer.valueOf(i));
    }

    private static iy<String> m4259a(String str, String str2) {
        pv.putString(str, str2);
        return iy.m5065l(str, str2);
    }

    public static Bundle by() {
        return pv;
    }

    private static iy<Boolean> m4260c(String str, boolean z) {
        pv.putBoolean(str, z);
        return iy.m5064h(str, z);
    }
}
