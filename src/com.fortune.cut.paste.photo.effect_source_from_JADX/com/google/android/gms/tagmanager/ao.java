package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID;
    private static final String arp;
    private static final String arr;
    private static final String arv;

    static {
        ID = C0997a.HASH.toString();
        arp = C1022b.ARG0.toString();
        arv = C1022b.ALGORITHM.toString();
        arr = C1022b.INPUT_FORMAT.toString();
    }

    public ao() {
        super(ID, arp);
    }

    private byte[] m6421d(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public C1070a m6422B(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(arp);
        if (c1070a == null || c1070a == di.rb()) {
            return di.rb();
        }
        byte[] bytes;
        String j = di.m6607j(c1070a);
        c1070a = (C1070a) map.get(arv);
        String j2 = c1070a == null ? "MD5" : di.m6607j(c1070a);
        c1070a = (C1070a) map.get(arr);
        String j3 = c1070a == null ? "text" : di.m6607j(c1070a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C1808j.co(j);
        } else {
            bh.m6458T("Hash: unknown input format: " + j3);
            return di.rb();
        }
        try {
            return di.m6618u(C1808j.m6646d(m6421d(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m6458T("Hash: unknown algorithm: " + j2);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
