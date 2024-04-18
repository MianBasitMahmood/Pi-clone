package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C1825s extends aj {
    private static final String ID;
    private static final String aqO;
    private static final String aqf;
    private final C1738a aqP;

    /* renamed from: com.google.android.gms.tagmanager.s.a */
    public interface C1738a {
        Object m6359b(String str, Map<String, Object> map);
    }

    static {
        ID = C0997a.FUNCTION_CALL.toString();
        aqO = C1022b.FUNCTION_CALL_NAME.toString();
        aqf = C1022b.ADDITIONAL_PARAMS.toString();
    }

    public C1825s(C1738a c1738a) {
        super(ID, aqO);
        this.aqP = c1738a;
    }

    public C1070a m6675B(Map<String, C1070a> map) {
        String j = di.m6607j((C1070a) map.get(aqO));
        Map hashMap = new HashMap();
        C1070a c1070a = (C1070a) map.get(aqf);
        if (c1070a != null) {
            Object o = di.m6612o(c1070a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m6461W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.rb();
            }
        }
        try {
            return di.m6618u(this.aqP.m6359b(j, hashMap));
        } catch (Exception e) {
            bh.m6461W("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return false;
    }
}
