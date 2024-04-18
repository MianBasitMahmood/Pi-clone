package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public final class C0660e {
    private static Map<String, MetadataField<?>> Rh;

    static {
        Rh = new HashMap();
        C0660e.m2359b(ln.Rj);
        C0660e.m2359b(ln.RJ);
        C0660e.m2359b(ln.RA);
        C0660e.m2359b(ln.RH);
        C0660e.m2359b(ln.RK);
        C0660e.m2359b(ln.Ru);
        C0660e.m2359b(ln.Rv);
        C0660e.m2359b(ln.Rs);
        C0660e.m2359b(ln.Rx);
        C0660e.m2359b(ln.RF);
        C0660e.m2359b(ln.Rk);
        C0660e.m2359b(ln.RC);
        C0660e.m2359b(ln.Rm);
        C0660e.m2359b(ln.Rt);
        C0660e.m2359b(ln.Rn);
        C0660e.m2359b(ln.Ro);
        C0660e.m2359b(ln.Rp);
        C0660e.m2359b(ln.Rz);
        C0660e.m2359b(ln.Rw);
        C0660e.m2359b(ln.RB);
        C0660e.m2359b(ln.RD);
        C0660e.m2359b(ln.RE);
        C0660e.m2359b(ln.RG);
        C0660e.m2359b(ln.RL);
        C0660e.m2359b(ln.RM);
        C0660e.m2359b(ln.Rr);
        C0660e.m2359b(ln.Rq);
        C0660e.m2359b(ln.RI);
        C0660e.m2359b(ln.Ry);
        C0660e.m2359b(ln.Rl);
        C0660e.m2359b(ln.RN);
        C0660e.m2359b(ln.RO);
        C0660e.m2359b(ln.RP);
        C0660e.m2359b(lp.RQ);
        C0660e.m2359b(lp.RS);
        C0660e.m2359b(lp.RT);
        C0660e.m2359b(lp.RU);
        C0660e.m2359b(lp.RR);
        C0660e.m2359b(lr.RW);
        C0660e.m2359b(lr.RX);
    }

    private static void m2359b(MetadataField<?> metadataField) {
        if (Rh.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        Rh.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> bm(String str) {
        return (MetadataField) Rh.get(str);
    }

    public static Collection<MetadataField<?>> iY() {
        return Collections.unmodifiableCollection(Rh.values());
    }
}
