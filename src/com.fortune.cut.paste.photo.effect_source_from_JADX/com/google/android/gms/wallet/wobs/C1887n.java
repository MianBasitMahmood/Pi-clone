package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.n */
public final class C1887n implements SafeParcelable {
    public static final Creator<C1887n> CREATOR;
    private final int CK;
    String awW;
    String description;

    static {
        CREATOR = new C1888o();
    }

    C1887n() {
        this.CK = 1;
    }

    C1887n(int i, String str, String str2) {
        this.CK = i;
        this.awW = str;
        this.description = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1888o.m6806a(this, parcel, i);
    }
}
