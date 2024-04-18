package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
/* renamed from: com.google.android.gms.internal.y */
public final class C1499y implements SafeParcelable {
    public static final C1500z CREATOR;
    public final boolean mi;
    public final boolean ms;
    public final int versionCode;

    static {
        CREATOR = new C1500z();
    }

    C1499y(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.mi = z;
        this.ms = z2;
    }

    public C1499y(boolean z, boolean z2) {
        this.versionCode = 1;
        this.mi = z;
        this.ms = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1500z.m6077a(this, parcel, i);
    }
}
