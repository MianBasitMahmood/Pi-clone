package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class ny implements SafeParcelable {
    public static final nz CREATOR;
    public static final long ahz;
    final int CK;
    private final long agr;
    private final nu ahA;
    private final int mPriority;

    static {
        CREATOR = new nz();
        ahz = TimeUnit.HOURS.toMillis(1);
    }

    public ny(int i, nu nuVar, long j, int i2) {
        this.CK = i;
        this.ahA = nuVar;
        this.agr = j;
        this.mPriority = i2;
    }

    public final int describeContents() {
        nz nzVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ny)) {
            return false;
        }
        ny nyVar = (ny) obj;
        return jv.equal(this.ahA, nyVar.ahA) && this.agr == nyVar.agr && this.mPriority == nyVar.mPriority;
    }

    public final long getInterval() {
        return this.agr;
    }

    public final int getPriority() {
        return this.mPriority;
    }

    public final int hashCode() {
        return jv.hashCode(this.ahA, Long.valueOf(this.agr), Integer.valueOf(this.mPriority));
    }

    public final nu nt() {
        return this.ahA;
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("filter", this.ahA).m5211a("interval", Long.valueOf(this.agr)).m5211a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        nz nzVar = CREATOR;
        nz.m5684a(this, parcel, i);
    }
}
