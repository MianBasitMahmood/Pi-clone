package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends aj {
    private static final String ID;
    private static final String asw;
    private static final String asx;
    private static final String asy;
    private static final String asz;

    static {
        ID = C0997a.REGEX_GROUP.toString();
        asw = C1022b.ARG0.toString();
        asx = C1022b.ARG1.toString();
        asy = C1022b.IGNORE_CASE.toString();
        asz = C1022b.GROUP.toString();
    }

    public ch() {
        super(ID, asw, asx);
    }

    public C1070a m6511B(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(asw);
        C1070a c1070a2 = (C1070a) map.get(asx);
        if (c1070a == null || c1070a == di.rb() || c1070a2 == null || c1070a2 == di.rb()) {
            return di.rb();
        }
        int i = 64;
        if (di.m6611n((C1070a) map.get(asy)).booleanValue()) {
            i = 66;
        }
        C1070a c1070a3 = (C1070a) map.get(asz);
        int intValue;
        if (c1070a3 != null) {
            Long l = di.m6609l(c1070a3);
            if (l == di.qW()) {
                return di.rb();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return di.rb();
            }
        }
        intValue = 1;
        try {
            CharSequence j = di.m6607j(c1070a);
            Object obj = null;
            Matcher matcher = Pattern.compile(di.m6607j(c1070a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? di.rb() : di.m6618u(obj);
        } catch (PatternSyntaxException e) {
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
