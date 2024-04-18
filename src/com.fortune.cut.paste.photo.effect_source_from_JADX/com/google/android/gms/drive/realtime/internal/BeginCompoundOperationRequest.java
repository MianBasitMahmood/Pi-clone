package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR;
    final int CK;
    final boolean SF;
    final boolean SG;
    final String mName;

    static {
        CREATOR = new C0685a();
    }

    BeginCompoundOperationRequest(int i, boolean z, String str, boolean z2) {
        this.CK = i;
        this.SF = z;
        this.mName = str;
        this.SG = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0685a.m2435a(this, parcel, i);
    }
}
