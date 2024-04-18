package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR;
    final int CK;
    final long QL;
    final long QM;

    static {
        CREATOR = new an();
    }

    OnDownloadProgressResponse(int i, long j, long j2) {
        this.CK = i;
        this.QL = j;
        this.QM = j2;
    }

    public int describeContents() {
        return 0;
    }

    public long iO() {
        return this.QL;
    }

    public long iP() {
        return this.QM;
    }

    public void writeToParcel(Parcel parcel, int i) {
        an.m2161a(this, parcel, i);
    }
}
