package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.drive.i */
public abstract class C0566i implements Parcelable {
    private volatile transient boolean OW;

    public C0566i() {
        this.OW = false;
    }

    protected abstract void m2029I(Parcel parcel, int i);

    public final boolean iB() {
        return this.OW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        jx.m5215K(!iB());
        this.OW = true;
        m2029I(parcel, i);
    }
}
