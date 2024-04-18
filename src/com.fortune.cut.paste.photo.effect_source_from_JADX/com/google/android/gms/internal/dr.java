package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.dynamic.C0755e;

@ey
public final class dr implements SafeParcelable {
    public static final dq CREATOR;
    public final gs lO;
    public final int orientation;
    public final String rH;
    public final C1089do sb;
    public final C1486t sc;
    public final ds sd;
    public final gu se;
    public final cb sf;
    public final String sg;
    public final boolean sh;
    public final String si;
    public final dv sj;
    public final int sk;
    public final ce sl;
    public final String sm;
    public final C1499y sn;
    public final int versionCode;

    static {
        CREATOR = new dq();
    }

    dr(int i, C1089do c1089do, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, gs gsVar, IBinder iBinder6, String str4, C1499y c1499y) {
        this.versionCode = i;
        this.sb = c1089do;
        this.sc = (C1486t) C0755e.m2593f(C0754a.ap(iBinder));
        this.sd = (ds) C0755e.m2593f(C0754a.ap(iBinder2));
        this.se = (gu) C0755e.m2593f(C0754a.ap(iBinder3));
        this.sf = (cb) C0755e.m2593f(C0754a.ap(iBinder4));
        this.sg = str;
        this.sh = z;
        this.si = str2;
        this.sj = (dv) C0755e.m2593f(C0754a.ap(iBinder5));
        this.orientation = i2;
        this.sk = i3;
        this.rH = str3;
        this.lO = gsVar;
        this.sl = (ce) C0755e.m2593f(C0754a.ap(iBinder6));
        this.sm = str4;
        this.sn = c1499y;
    }

    public dr(C1089do c1089do, C1486t c1486t, ds dsVar, dv dvVar, gs gsVar) {
        this.versionCode = 4;
        this.sb = c1089do;
        this.sc = c1486t;
        this.sd = dsVar;
        this.se = null;
        this.sf = null;
        this.sg = null;
        this.sh = false;
        this.si = null;
        this.sj = dvVar;
        this.orientation = -1;
        this.sk = 4;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = null;
        this.sn = null;
    }

    public dr(C1486t c1486t, ds dsVar, cb cbVar, dv dvVar, gu guVar, boolean z, int i, String str, gs gsVar, ce ceVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c1486t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = cbVar;
        this.sg = null;
        this.sh = z;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 3;
        this.rH = str;
        this.lO = gsVar;
        this.sl = ceVar;
        this.sm = null;
        this.sn = null;
    }

    public dr(C1486t c1486t, ds dsVar, cb cbVar, dv dvVar, gu guVar, boolean z, int i, String str, String str2, gs gsVar, ce ceVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c1486t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = cbVar;
        this.sg = str2;
        this.sh = z;
        this.si = str;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 3;
        this.rH = null;
        this.lO = gsVar;
        this.sl = ceVar;
        this.sm = null;
        this.sn = null;
    }

    public dr(C1486t c1486t, ds dsVar, dv dvVar, gu guVar, int i, gs gsVar, String str, C1499y c1499y) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c1486t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = null;
        this.sg = null;
        this.sh = false;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 1;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = str;
        this.sn = c1499y;
    }

    public dr(C1486t c1486t, ds dsVar, dv dvVar, gu guVar, boolean z, int i, gs gsVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c1486t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = null;
        this.sg = null;
        this.sh = z;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 2;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = null;
        this.sn = null;
    }

    public static void m4459a(Intent intent, dr drVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", drVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static dr m4460b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(dr.class.getClassLoader());
            return (dr) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    final IBinder ck() {
        return C0755e.m2594k(this.sc).asBinder();
    }

    final IBinder cl() {
        return C0755e.m2594k(this.sd).asBinder();
    }

    final IBinder cm() {
        return C0755e.m2594k(this.se).asBinder();
    }

    final IBinder cn() {
        return C0755e.m2594k(this.sf).asBinder();
    }

    final IBinder co() {
        return C0755e.m2594k(this.sl).asBinder();
    }

    final IBinder cp() {
        return C0755e.m2594k(this.sj).asBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        dq.m4456a(this, parcel, i);
    }
}
