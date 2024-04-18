package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID;

    static {
        ID = C0997a.LANGUAGE.toString();
    }

    public bc() {
        super(ID, new String[0]);
    }

    public C1070a m6452B(Map<String, C1070a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return di.rb();
        }
        String language = locale.getLanguage();
        return language == null ? di.rb() : di.m6618u(language.toLowerCase());
    }

    public boolean pe() {
        return false;
    }
}
