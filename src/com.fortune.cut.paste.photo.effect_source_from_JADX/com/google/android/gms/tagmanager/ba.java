package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.tagmanager.cr.C1780a;
import com.google.android.gms.tagmanager.cr.C1782c;
import com.google.android.gms.tagmanager.cr.C1783d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C1782c cI(String str) throws JSONException {
        C1070a n = m6448n(new JSONObject(str));
        C1783d qo = C1782c.qo();
        for (int i = 0; i < n.gx.length; i++) {
            qo.m6534a(C1780a.qk().m6532b(C1022b.INSTANCE_NAME.toString(), n.gx[i]).m6532b(C1022b.FUNCTION.toString(), di.cZ(C1811m.ph())).m6532b(C1811m.pi(), n.gy[i]).qn());
        }
        return qo.qr();
    }

    private static C1070a m6448n(Object obj) throws JSONException {
        return di.m6618u(m6449o(obj));
    }

    static Object m6449o(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m6449o(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
