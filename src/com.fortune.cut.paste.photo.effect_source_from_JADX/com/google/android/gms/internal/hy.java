package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.hd.C1187a;
import com.google.android.gms.internal.hp.C1190a;
import com.google.android.gms.internal.mv.C1353b;
import com.google.android.gms.internal.mv.C1354c;
import com.google.android.gms.internal.mv.C1355d;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class hy {
    private static hh m4896a(String str, C1354c c1354c) {
        return new hh(qw.m2145f(c1354c), new C1190a(str).m4853G(true).au(str).at("blob").fG());
    }

    public static hr m4897a(Action action, String str, long j, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putAll(action.fI());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent a = hz.m4906a(str2, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        C1187a a2 = hr.m4859a(a, string, parse, string2, null);
        a2.m4833a(m4896a(".private:action", m4898d(action.fI())));
        a2.m4833a(aw(str));
        return new hr(hr.m4860a(str2, a), j, i, null, a2.fD());
    }

    private static hh aw(String str) {
        return new hh(str, new C1190a(".private:actionId").m4853G(true).au(".private:actionId").at("blob").fG());
    }

    static C1354c m4898d(Bundle bundle) {
        C1354c c1354c = new C1354c();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            C1353b c1353b = new C1353b();
            c1353b.name = str;
            c1353b.afz = new C1355d();
            if (obj instanceof String) {
                c1353b.afz.NJ = (String) obj;
            } else if (obj instanceof Bundle) {
                c1353b.afz.afE = m4898d((Bundle) obj);
            } else {
                Log.e("AppDataSearchClient", "Unsupported value: " + obj);
            }
            arrayList.add(c1353b);
        }
        if (bundle.containsKey("type")) {
            c1354c.type = bundle.getString("type");
        }
        c1354c.afA = (C1353b[]) arrayList.toArray(new C1353b[arrayList.size()]);
        return c1354c;
    }
}
