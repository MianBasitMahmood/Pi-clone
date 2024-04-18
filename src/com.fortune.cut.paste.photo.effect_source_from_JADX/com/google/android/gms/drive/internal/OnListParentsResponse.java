package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.C0566i;

public class OnListParentsResponse extends C0566i implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR;
    final int CK;
    final DataHolder QR;

    static {
        CREATOR = new as();
    }

    OnListParentsResponse(int i, DataHolder dataHolder) {
        this.CK = i;
        this.QR = dataHolder;
    }

    protected void m2031I(Parcel parcel, int i) {
        as.m2166a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder iT() {
        return this.QR;
    }
}
