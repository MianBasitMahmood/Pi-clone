package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class aw implements SafeParcelable {
    public static final Creator<aw> CREATOR;
    public final long ayc;
    public final List<an> aye;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new ax();
    }

    aw(int i, int i2, long j, List<an> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.ayc = j;
        this.aye = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ax.m6968a(this, parcel, i);
    }
}
