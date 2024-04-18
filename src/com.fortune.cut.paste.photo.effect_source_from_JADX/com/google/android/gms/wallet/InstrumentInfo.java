package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR;
    private final int CK;
    private String auX;
    private String auY;

    static {
        CREATOR = new C1864h();
    }

    InstrumentInfo(int i, String str, String str2) {
        this.CK = i;
        this.auX = str;
        this.auY = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getInstrumentDetails() {
        return this.auY;
    }

    public final String getInstrumentType() {
        return this.auX;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1864h.m6791a(this, parcel, i);
    }
}
