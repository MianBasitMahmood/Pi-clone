package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.b */
public final class C1875b implements SafeParcelable {
    public static final Creator<C1875b> CREATOR;
    private final int CK;
    String label;
    String value;

    static {
        CREATOR = new C1876c();
    }

    C1875b() {
        this.CK = 1;
    }

    C1875b(int i, String str, String str2) {
        this.CK = i;
        this.label = str;
        this.value = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1876c.m6800a(this, parcel, i);
    }
}
