package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public final class C1649a implements SafeParcelable {
    public static final C1650b CREATOR;
    private final int CK;
    private byte amJ;
    private Bundle amK;
    private Bitmap amL;

    static {
        CREATOR = new C1650b();
    }

    C1649a(int i, byte b, Bundle bundle, Bitmap bitmap) {
        this.CK = i;
        this.amJ = b;
        this.amK = bundle;
        this.amL = bitmap;
    }

    public final int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.amL;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final byte oh() {
        return this.amJ;
    }

    public final Bundle oi() {
        return this.amK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1650b.m6201a(this, parcel, i);
    }
}
