package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR;
    final int CK;
    final Contents PW;
    final boolean QJ;

    static {
        CREATOR = new al();
    }

    OnContentsResponse(int i, Contents contents, boolean z) {
        this.CK = i;
        this.PW = contents;
        this.QJ = z;
    }

    public int describeContents() {
        return 0;
    }

    public Contents iL() {
        return this.PW;
    }

    public boolean iM() {
        return this.QJ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        al.m2159a(this, parcel, i);
    }
}
