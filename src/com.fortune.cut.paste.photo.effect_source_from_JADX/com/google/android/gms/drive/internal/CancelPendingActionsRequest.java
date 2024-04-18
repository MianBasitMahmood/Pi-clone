package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Creator<CancelPendingActionsRequest> CREATOR;
    final int CK;
    final List<String> Pb;

    static {
        CREATOR = new C0579d();
    }

    CancelPendingActionsRequest(int i, List<String> list) {
        this.CK = i;
        this.Pb = list;
    }

    public CancelPendingActionsRequest(List<String> list) {
        this(1, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0579d.m2199a(this, parcel, i);
    }
}
