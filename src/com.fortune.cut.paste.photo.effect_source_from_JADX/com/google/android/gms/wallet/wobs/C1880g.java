package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.g */
public final class C1880g implements SafeParcelable {
    public static final Creator<C1880g> CREATOR;
    private final int CK;
    int awN;
    String awO;
    double awP;
    String awQ;
    long awR;
    int awS;

    static {
        CREATOR = new C1881h();
    }

    C1880g() {
        this.CK = 1;
        this.awS = -1;
        this.awN = -1;
        this.awP = -1.0d;
    }

    C1880g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.CK = i;
        this.awN = i2;
        this.awO = str;
        this.awP = d;
        this.awQ = str2;
        this.awR = j;
        this.awS = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1881h.m6802a(this, parcel, i);
    }
}
