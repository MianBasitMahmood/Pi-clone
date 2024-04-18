package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.internal.y */
public class C1632y implements SafeParcelable {
    public static final C1633z CREATOR;
    private final Point alK;
    private final int versionCode;

    static {
        CREATOR = new C1633z();
    }

    public C1632y(int i, Point point) {
        this.versionCode = i;
        this.alK = point;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1632y)) {
            return false;
        }
        return this.alK.equals(((C1632y) obj).alK);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.alK.hashCode();
    }

    public Point oa() {
        return this.alK;
    }

    public String toString() {
        return this.alK.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1633z.m6179a(this, parcel, i);
    }
}
