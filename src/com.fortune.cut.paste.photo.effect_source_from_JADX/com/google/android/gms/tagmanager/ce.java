package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce {
    private static ce asm;
    private volatile String aqm;
    private volatile C1770a asn;
    private volatile String aso;
    private volatile String asp;

    /* renamed from: com.google.android.gms.tagmanager.ce.a */
    enum C1770a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    ce() {
        clear();
    }

    private String cK(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m6508j(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static ce qa() {
        ce ceVar;
        synchronized (ce.class) {
            if (asm == null) {
                asm = new ce();
            }
            ceVar = asm;
        }
        return ceVar;
    }

    void clear() {
        this.asn = C1770a.NONE;
        this.aso = null;
        this.aqm = null;
        this.asp = null;
    }

    String getContainerId() {
        return this.aqm;
    }

    synchronized boolean m6509i(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bh.m6460V("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.asn = C1770a.CONTAINER_DEBUG;
                    } else {
                        this.asn = C1770a.CONTAINER;
                    }
                    this.asp = m6508j(uri);
                    if (this.asn == C1770a.CONTAINER || this.asn == C1770a.CONTAINER_DEBUG) {
                        this.aso = "/r?" + this.asp;
                    }
                    this.aqm = cK(this.asp);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bh.m6461W("Invalid preview uri: " + decode);
                        z = false;
                    } else if (cK(uri.getQuery()).equals(this.aqm)) {
                        bh.m6460V("Exit preview mode for container: " + this.aqm);
                        this.asn = C1770a.NONE;
                        this.aso = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    C1770a qb() {
        return this.asn;
    }

    String qc() {
        return this.aso;
    }
}
