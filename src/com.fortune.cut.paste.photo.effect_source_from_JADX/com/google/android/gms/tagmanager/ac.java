package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class ac extends aj {
    private static final String ID;
    private static final String arp;
    private static final String arq;
    private static final String arr;
    private static final String ars;

    static {
        ID = C0997a.ENCODE.toString();
        arp = C1022b.ARG0.toString();
        arq = C1022b.NO_PADDING.toString();
        arr = C1022b.INPUT_FORMAT.toString();
        ars = C1022b.OUTPUT_FORMAT.toString();
    }

    public ac() {
        super(ID, arp);
    }

    public C1070a m6403B(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(arp);
        if (c1070a == null || c1070a == di.rb()) {
            return di.rb();
        }
        String j = di.m6607j(c1070a);
        c1070a = (C1070a) map.get(arr);
        String j2 = c1070a == null ? "text" : di.m6607j(c1070a);
        c1070a = (C1070a) map.get(ars);
        String j3 = c1070a == null ? "base16" : di.m6607j(c1070a);
        int i = 2;
        c1070a = (C1070a) map.get(arq);
        if (c1070a != null && di.m6611n(c1070a).booleanValue()) {
            i = 3;
        }
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C1808j.co(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m6458T("Encode: unknown input format: " + j2);
                return di.rb();
            }
            if ("base16".equals(j3)) {
                d = C1808j.m6646d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m6458T("Encode: unknown output format: " + j3);
                return di.rb();
            }
            return di.m6618u(d);
        } catch (IllegalArgumentException e) {
            bh.m6458T("Encode: invalid input:");
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
