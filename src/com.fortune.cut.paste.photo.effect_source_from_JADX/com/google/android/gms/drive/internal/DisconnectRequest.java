package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DisconnectRequest implements SafeParcelable {
    public static final Creator<DisconnectRequest> CREATOR;
    final int CK;

    static {
        CREATOR = new C0590o();
    }

    public DisconnectRequest() {
        this(1);
    }

    DisconnectRequest(int i) {
        this.CK = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0590o.m2211a(this, parcel, i);
    }
}
