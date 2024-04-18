package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe implements SafeParcelable {
    public static final of CREATOR;
    public static final oe akb;
    public static final oe akc;
    public static final Set<oe> akd;
    final int CK;
    final int ake;
    final String vc;

    static {
        akb = m5690A("test_type", 1);
        akc = m5690A("labeled_place", 6);
        akd = Collections.unmodifiableSet(new HashSet(Arrays.asList(new oe[]{akb, akc})));
        CREATOR = new of();
    }

    oe(int i, String str, int i2) {
        jx.bb(str);
        this.CK = i;
        this.vc = str;
        this.ake = i2;
    }

    private static oe m5690A(String str, int i) {
        return new oe(0, str, i);
    }

    public final int describeContents() {
        of ofVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oe)) {
            return false;
        }
        oe oeVar = (oe) obj;
        return this.vc.equals(oeVar.vc) && this.ake == oeVar.ake;
    }

    public final int hashCode() {
        return this.vc.hashCode();
    }

    public final String toString() {
        return this.vc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        of ofVar = CREATOR;
        of.m5691a(this, parcel, i);
    }
}
