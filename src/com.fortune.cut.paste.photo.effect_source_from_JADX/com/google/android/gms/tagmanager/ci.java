package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ci extends dd {
    private static final String ID;
    private static final String asy;

    static {
        ID = C0997a.REGEX.toString();
        asy = C1022b.IGNORE_CASE.toString();
    }

    public ci() {
        super(ID);
    }

    protected boolean m6512a(String str, String str2, Map<String, C1070a> map) {
        try {
            return Pattern.compile(str2, di.m6611n((C1070a) map.get(asy)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
