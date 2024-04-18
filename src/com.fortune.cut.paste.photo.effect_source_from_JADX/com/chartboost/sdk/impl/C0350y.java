package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.C0230b.C0229a;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.chartboost.sdk.impl.y */
public class C0350y {
    public static C0229a m1411a(C0328i c0328i) {
        long currentTimeMillis = System.currentTimeMillis();
        Map map = c0328i.f914c;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        Object obj = null;
        String str = (String) map.get("Date");
        if (str != null) {
            j = C0350y.m1410a(str);
        }
        str = (String) map.get("Cache-Control");
        if (str != null) {
            obj = 1;
            String[] split = str.split(",");
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j3 = 0;
                }
            }
        }
        long j4 = j3;
        Object obj2 = obj;
        str = (String) map.get("Expires");
        if (str != null) {
            j2 = C0350y.m1410a(str);
        }
        str = (String) map.get("ETag");
        j3 = obj2 != null ? (j4 * 1000) + currentTimeMillis : (j <= 0 || j2 < j) ? 0 : (j2 - j) + currentTimeMillis;
        C0229a c0229a = new C0229a();
        c0229a.f594a = c0328i.f913b;
        c0229a.f595b = str;
        c0229a.f598e = j3;
        c0229a.f597d = c0229a.f598e;
        c0229a.f596c = j;
        c0229a.f599f = map;
        return c0229a;
    }

    public static long m1410a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }
}
