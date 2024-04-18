package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR;
    final int CK;
    private final String Kv;

    static {
        CREATOR = new C0510e();
    }

    Scope(int i, String str) {
        jx.m5220b(str, (Object) "scopeUri must not be null or empty");
        this.CK = i;
        this.Kv = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.Kv.equals(((Scope) obj).Kv);
    }

    public final String gO() {
        return this.Kv;
    }

    public final int hashCode() {
        return this.Kv.hashCode();
    }

    public final String toString() {
        return this.Kv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0510e.m1842a(this, parcel, i);
    }
}
