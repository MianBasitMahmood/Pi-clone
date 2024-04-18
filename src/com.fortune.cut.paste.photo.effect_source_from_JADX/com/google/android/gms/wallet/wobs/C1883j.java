package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.j */
public final class C1883j implements SafeParcelable {
    public static final Creator<C1883j> CREATOR;
    private final int CK;
    String awT;
    String tU;

    static {
        CREATOR = new C1884k();
    }

    C1883j() {
        this.CK = 1;
    }

    C1883j(int i, String str, String str2) {
        this.CK = i;
        this.awT = str;
        this.tU = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1884k.m6804a(this, parcel, i);
    }
}
