package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.fy.C1160a;

@ey
public final class fc {

    /* renamed from: com.google.android.gms.internal.fc.a */
    public interface C1139a {
        void m4581a(fy fyVar);
    }

    public static gf m4582a(Context context, C1494u c1494u, C1160a c1160a, gu guVar, cy cyVar, C1139a c1139a) {
        gf fmVar;
        if (c1160a.vK.ug) {
            fmVar = new fm(context, c1494u, new ai(), c1160a, c1139a);
        } else {
            fmVar = new fd(context, c1160a, guVar, cyVar, c1139a);
        }
        fmVar.start();
        return fmVar;
    }
}
