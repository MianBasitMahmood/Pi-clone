package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1071d.C1070a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> art;
    private final String aru;

    public aj(String str, String... strArr) {
        this.aru = str;
        this.art = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.art.add(add);
        }
    }

    public abstract C1070a m6399B(Map<String, C1070a> map);

    boolean m6400a(Set<String> set) {
        return set.containsAll(this.art);
    }

    public String pI() {
        return this.aru;
    }

    public Set<String> pJ() {
        return this.art;
    }

    public abstract boolean pe();
}
