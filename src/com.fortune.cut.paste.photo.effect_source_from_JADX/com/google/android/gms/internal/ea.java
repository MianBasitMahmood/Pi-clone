package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.dynamic.C0755e;

@ey
public final class ea implements SafeParcelable {
    public static final dz CREATOR;
    public final ek md;
    public final Context sA;
    public final ej sB;
    public final em sz;
    public final int versionCode;

    static {
        CREATOR = new dz();
    }

    ea(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.md = (ek) C0755e.m2593f(C0754a.ap(iBinder));
        this.sz = (em) C0755e.m2593f(C0754a.ap(iBinder2));
        this.sA = (Context) C0755e.m2593f(C0754a.ap(iBinder3));
        this.sB = (ej) C0755e.m2593f(C0754a.ap(iBinder4));
    }

    public ea(Context context, ek ekVar, em emVar, ej ejVar) {
        this.versionCode = 2;
        this.sA = context;
        this.md = ekVar;
        this.sz = emVar;
        this.sB = ejVar;
    }

    public static void m4486a(Intent intent, ea eaVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", eaVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static ea m4487c(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(ea.class.getClassLoader());
            return (ea) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    final IBinder ct() {
        return C0755e.m2594k(this.sB).asBinder();
    }

    final IBinder cu() {
        return C0755e.m2594k(this.md).asBinder();
    }

    final IBinder cv() {
        return C0755e.m2594k(this.sz).asBinder();
    }

    final IBinder cw() {
        return C0755e.m2594k(this.sA).asBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        dz.m4479a(this, parcel, i);
    }
}
