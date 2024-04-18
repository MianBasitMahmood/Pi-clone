package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR;
    final int CK;
    final MetadataBundle Px;

    static {
        CREATOR = new at();
    }

    OnMetadataResponse(int i, MetadataBundle metadataBundle) {
        this.CK = i;
        this.Px = metadataBundle;
    }

    public int describeContents() {
        return 0;
    }

    public MetadataBundle iU() {
        return this.Px;
    }

    public void writeToParcel(Parcel parcel, int i) {
        at.m2167a(this, parcel, i);
    }
}
