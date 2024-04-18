package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae.C1897a;

/* renamed from: com.google.android.gms.wearable.internal.b */
public class C1937b implements SafeParcelable {
    public static final Creator<C1937b> CREATOR;
    final int CK;
    public final ae axv;
    public final IntentFilter[] axw;

    static {
        CREATOR = new C1939c();
    }

    C1937b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.CK = i;
        if (iBinder != null) {
            this.axv = C1897a.bY(iBinder);
        } else {
            this.axv = null;
        }
        this.axw = intentFilterArr;
    }

    public C1937b(bb bbVar) {
        this.CK = 1;
        this.axv = bbVar;
        this.axw = bbVar.rs();
    }

    public int describeContents() {
        return 0;
    }

    IBinder rm() {
        return this.axv == null ? null : this.axv.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1939c.m7003a(this, parcel, i);
    }
}
