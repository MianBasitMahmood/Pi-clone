package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class Tile implements SafeParcelable {
    public static final C1693u CREATOR;
    private final int CK;
    public final byte[] data;
    public final int height;
    public final int width;

    static {
        CREATOR = new C1693u();
    }

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.CK = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1694v.m6245a(this, parcel, i);
        } else {
            C1693u.m6244a(this, parcel, i);
        }
    }
}
