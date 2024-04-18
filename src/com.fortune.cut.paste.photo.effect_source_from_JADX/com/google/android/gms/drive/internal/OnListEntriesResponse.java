package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.C0566i;

public class OnListEntriesResponse extends C0566i implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR;
    final int CK;
    final boolean PJ;
    final DataHolder QQ;

    static {
        CREATOR = new ar();
    }

    OnListEntriesResponse(int i, DataHolder dataHolder, boolean z) {
        this.CK = i;
        this.QQ = dataHolder;
        this.PJ = z;
    }

    protected void m2030I(Parcel parcel, int i) {
        ar.m2165a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder iR() {
        return this.QQ;
    }

    public boolean iS() {
        return this.PJ;
    }
}
