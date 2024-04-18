package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR;
    final int CK;
    final List<String> OK;
    final List<String> OL;

    static {
        CREATOR = new C0563f();
    }

    RealtimeDocumentSyncRequest(int i, List<String> list, List<String> list2) {
        this.CK = i;
        this.OK = (List) jx.m5223i(list);
        this.OL = (List) jx.m5223i(list2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0563f.m2023a(this, parcel, i);
    }
}
