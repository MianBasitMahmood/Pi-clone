package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR;
    final int CK;
    final Contents Pr;
    final Boolean Pt;

    static {
        CREATOR = new C0582g();
    }

    CloseContentsRequest(int i, Contents contents, Boolean bool) {
        this.CK = i;
        this.Pr = contents;
        this.Pt = bool;
    }

    public CloseContentsRequest(Contents contents, boolean z) {
        this(1, contents, Boolean.valueOf(z));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0582g.m2202a(this, parcel, i);
    }
}
