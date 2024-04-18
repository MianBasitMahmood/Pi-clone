package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.e */
public final class C1653e implements SafeParcelable {
    public static final C1654f CREATOR;
    private final int CK;
    private C1649a amM;

    static {
        CREATOR = new C1654f();
    }

    public C1653e() {
        this.CK = 1;
    }

    C1653e(int i, C1649a c1649a) {
        this.CK = i;
        this.amM = c1649a;
    }

    public final int describeContents() {
        return 0;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final C1649a oj() {
        return this.amM;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1654f.m6203a(this, parcel, i);
    }
}
