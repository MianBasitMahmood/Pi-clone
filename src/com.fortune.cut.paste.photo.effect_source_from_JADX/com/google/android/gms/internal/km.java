package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C1276b;

public class km implements SafeParcelable {
    public static final kn CREATOR;
    private final int CK;
    private final ko NF;

    static {
        CREATOR = new kn();
    }

    km(int i, ko koVar) {
        this.CK = i;
        this.NF = koVar;
    }

    private km(ko koVar) {
        this.CK = 1;
        this.NF = koVar;
    }

    public static km m5259a(C1276b<?, ?> c1276b) {
        if (c1276b instanceof ko) {
            return new km((ko) c1276b);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        kn knVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    ko hF() {
        return this.NF;
    }

    public C1276b<?, ?> hG() {
        if (this.NF != null) {
            return this.NF;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        kn knVar = CREATOR;
        kn.m5260a(this, parcel, i);
    }
}
