package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.d */
public final class C1877d implements SafeParcelable {
    public static final Creator<C1877d> CREATOR;
    private final int CK;
    String awJ;
    String awK;
    ArrayList<C1875b> awL;

    static {
        CREATOR = new C1878e();
    }

    C1877d() {
        this.CK = 1;
        this.awL = la.ie();
    }

    C1877d(int i, String str, String str2, ArrayList<C1875b> arrayList) {
        this.CK = i;
        this.awJ = str;
        this.awK = str2;
        this.awL = arrayList;
    }

    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1878e.m6801a(this, parcel, i);
    }
}
