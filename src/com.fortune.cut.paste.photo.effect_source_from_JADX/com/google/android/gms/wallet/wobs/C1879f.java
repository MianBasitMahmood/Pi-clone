package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.f */
public final class C1879f implements SafeParcelable {
    public static final Creator<C1879f> CREATOR;
    private final int CK;
    C1885l avm;
    C1880g awM;
    String label;
    String type;

    static {
        CREATOR = new C1882i();
    }

    C1879f() {
        this.CK = 1;
    }

    C1879f(int i, String str, C1880g c1880g, String str2, C1885l c1885l) {
        this.CK = i;
        this.label = str;
        this.awM = c1880g;
        this.type = str2;
        this.avm = c1885l;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1882i.m6803a(this, parcel, i);
    }
}
