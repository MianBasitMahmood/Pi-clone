package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.j */
public class C0818j implements SafeParcelable {
    public static final Creator<C0818j> CREATOR;
    private final int CK;
    private final String mName;

    static {
        CREATOR = new C0819k();
    }

    C0818j(int i, String str) {
        this.CK = i;
        this.mName = str;
    }

    public C0818j(String str) {
        this.CK = 1;
        this.mName = str;
    }

    private boolean m2760a(C0818j c0818j) {
        return jv.equal(this.mName, c0818j.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0818j) && m2760a((C0818j) obj));
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("name", this.mName).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0819k.m2761a(this, parcel, i);
    }
}
