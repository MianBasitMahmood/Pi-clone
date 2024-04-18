package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.C0801l.C0802a;
import com.google.android.gms.fitness.request.C0803a.C0800a;

public class ad implements SafeParcelable {
    public static final Creator<ad> CREATOR;
    private final int CK;
    private final C0801l Wm;

    static {
        CREATOR = new ae();
    }

    ad(int i, IBinder iBinder) {
        this.CK = i;
        this.Wm = C0802a.aB(iBinder);
    }

    public ad(BleScanCallback bleScanCallback) {
        this.CK = 1;
        this.Wm = C0800a.jP().m2735b(bleScanCallback);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public IBinder km() {
        return this.Wm.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ae.m2739a(this, parcel, i);
    }
}
