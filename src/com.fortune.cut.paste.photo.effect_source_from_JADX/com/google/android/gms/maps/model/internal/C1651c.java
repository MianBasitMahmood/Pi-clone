package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.c */
public final class C1651c implements SafeParcelable {
    public static final C1652d CREATOR;
    private final int CK;
    private Bundle amK;
    private int type;

    static {
        CREATOR = new C1652d();
    }

    C1651c(int i, int i2, Bundle bundle) {
        this.CK = i;
        this.type = i2;
        this.amK = bundle;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final Bundle oi() {
        return this.amK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1652d.m6202a(this, parcel, i);
    }
}
