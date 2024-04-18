package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ey
public final class ci implements cd {
    private final ce qc;
    private final C1497v qd;

    public ci(ce ceVar, C1497v c1497v) {
        this.qc = ceVar;
        this.qd = c1497v;
    }

    private static boolean m4350b(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m4351c(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return gi.dv();
            }
            if ("l".equalsIgnoreCase(str)) {
                return gi.du();
            }
        }
        return -1;
    }

    public final void m4352a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            gr.m4773W("Action missing from an open GMSG.");
        } else if (this.qd == null || this.qd.az()) {
            gv dD = guVar.dD();
            if ("expand".equalsIgnoreCase(str)) {
                if (guVar.dH()) {
                    gr.m4773W("Cannot expand WebView that is already expanded.");
                } else {
                    dD.m4801a(m4350b(map), m4351c(map));
                }
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                if (str != null) {
                    dD.m4802a(m4350b(map), m4351c(map), str);
                } else {
                    dD.m4803a(m4350b(map), m4351c(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.qc == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.qc.m4346a(str, new ArrayList());
                    return;
                }
                this.qc.m4346a(str, new ArrayList(Arrays.asList(str2.split(" "))));
            } else {
                dD.m4795a(new C1089do((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.qd.m6070d((String) map.get("u"));
        }
    }
}
