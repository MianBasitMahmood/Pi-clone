package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
public final class ft {
    private int mOrientation;
    private String pD;
    private String uJ;
    private String uK;
    private List<String> uL;
    private String uM;
    private String uN;
    private List<String> uO;
    private long uP;
    private boolean uQ;
    private final long uR;
    private long uS;
    private boolean uT;
    private boolean uU;
    private boolean uV;
    private boolean uW;
    private List<String> uo;

    public ft() {
        this.uP = -1;
        this.uQ = false;
        this.uR = -1;
        this.uS = -1;
        this.mOrientation = -1;
        this.uT = false;
        this.uU = false;
        this.uV = false;
        this.uW = true;
    }

    static String m4649a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long m4650b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                gr.m4773W("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    static List<String> m4651c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private boolean m4652d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void m4653f(Map<String, List<String>> map) {
        this.uJ = m4649a(map, "X-Afma-Ad-Size");
    }

    private void m4654g(Map<String, List<String>> map) {
        List c = m4651c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.uL = c;
        }
    }

    private void m4655h(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.uM = (String) list.get(0);
        }
    }

    private void m4656i(Map<String, List<String>> map) {
        List c = m4651c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.uO = c;
        }
    }

    private void m4657j(Map<String, List<String>> map) {
        long b = m4650b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.uP = b;
        }
    }

    private void m4658k(Map<String, List<String>> map) {
        this.uN = m4649a(map, "X-Afma-ActiveView");
    }

    private void m4659l(Map<String, List<String>> map) {
        this.uU |= m4652d(map, "X-Afma-Native");
    }

    private void m4660m(Map<String, List<String>> map) {
        this.uT |= m4652d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void m4661n(Map<String, List<String>> map) {
        this.uQ |= m4652d(map, "X-Afma-Mediation");
    }

    private void m4662o(Map<String, List<String>> map) {
        List c = m4651c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.uo = c;
        }
    }

    private void m4663p(Map<String, List<String>> map) {
        long b = m4650b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.uS = b;
        }
    }

    private void m4664q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = gi.dv();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = gi.du();
            }
        }
    }

    private void m4665r(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.uV = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m4666s(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.uW = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    public final void m4667a(String str, Map<String, List<String>> map, String str2) {
        this.uK = str;
        this.pD = str2;
        m4668e(map);
    }

    public final void m4668e(Map<String, List<String>> map) {
        m4653f(map);
        m4654g(map);
        m4655h(map);
        m4656i((Map) map);
        m4657j(map);
        m4661n(map);
        m4662o(map);
        m4663p(map);
        m4664q(map);
        m4658k(map);
        m4665r(map);
        m4660m(map);
        m4659l(map);
        m4666s(map);
    }

    public final fj m4669i(long j) {
        return new fj(this.uK, this.pD, this.uL, this.uO, this.uP, this.uQ, -1, this.uo, this.uS, this.mOrientation, this.uJ, j, this.uM, this.uN, this.uT, this.uU, this.uV, this.uW);
    }
}
