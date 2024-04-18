package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.p */
public final class C1680p implements SafeParcelable {
    public static final C1681q CREATOR;
    private final int CK;
    private C1649a amN;

    static {
        CREATOR = new C1681q();
    }

    public C1680p() {
        this.CK = 1;
    }

    C1680p(int i, C1649a c1649a) {
        this.CK = i;
        this.amN = c1649a;
    }

    public final int describeContents() {
        return 0;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final C1649a ol() {
        return this.amN;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1681q.m6232a(this, parcel, i);
    }
}
