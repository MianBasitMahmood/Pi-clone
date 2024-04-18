package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ns implements SafeParcelable {
    public static final nt CREATOR;
    private final int CK;
    private final int agd;
    private final int ahp;
    private final nu ahq;

    static {
        CREATOR = new nt();
    }

    ns(int i, int i2, int i3, nu nuVar) {
        this.CK = i;
        this.agd = i2;
        this.ahp = i3;
        this.ahq = nuVar;
    }

    public final int describeContents() {
        nt ntVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ns)) {
            return false;
        }
        ns nsVar = (ns) obj;
        return this.agd == nsVar.agd && this.ahp == nsVar.ahp && this.ahq.equals(nsVar.ahq);
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.agd), Integer.valueOf(this.ahp));
    }

    public final int np() {
        return this.agd;
    }

    public final int ns() {
        return this.ahp;
    }

    public final nu nt() {
        return this.ahq;
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("transitionTypes", Integer.valueOf(this.agd)).m5211a("loiteringTimeMillis", Integer.valueOf(this.ahp)).m5211a("placeFilter", this.ahq).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        nt ntVar = CREATOR;
        nt.m5680a(this, parcel, i);
    }
}
