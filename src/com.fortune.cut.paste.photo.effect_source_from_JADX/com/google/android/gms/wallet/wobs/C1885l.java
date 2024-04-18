package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.l */
public final class C1885l implements SafeParcelable {
    public static final Creator<C1885l> CREATOR;
    private final int CK;
    long awU;
    long awV;

    static {
        CREATOR = new C1886m();
    }

    C1885l() {
        this.CK = 1;
    }

    C1885l(int i, long j, long j2) {
        this.CK = i;
        this.awU = j;
        this.awV = j2;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1886m.m6805a(this, parcel, i);
    }
}
