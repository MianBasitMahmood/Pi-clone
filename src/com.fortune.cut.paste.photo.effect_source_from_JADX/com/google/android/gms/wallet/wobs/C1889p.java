package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.p */
public final class C1889p implements SafeParcelable {
    public static final Creator<C1889p> CREATOR;
    private final int CK;
    String awT;
    C1885l awX;
    C1887n awY;
    C1887n awZ;
    String tU;

    static {
        CREATOR = new C1890q();
    }

    C1889p() {
        this.CK = 1;
    }

    C1889p(int i, String str, String str2, C1885l c1885l, C1887n c1887n, C1887n c1887n2) {
        this.CK = i;
        this.awT = str;
        this.tU = str2;
        this.awX = c1885l;
        this.awY = c1887n;
        this.awZ = c1887n2;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1890q.m6807a(this, parcel, i);
    }
}
