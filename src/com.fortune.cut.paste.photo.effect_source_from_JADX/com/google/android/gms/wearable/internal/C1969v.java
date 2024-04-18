package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.v */
public class C1969v implements SafeParcelable {
    public static final Creator<C1969v> CREATOR;
    public final List<al> axL;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new C1970w();
    }

    C1969v(int i, int i2, List<al> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axL = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1970w.m7041a(this, parcel, i);
    }
}
