package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0543c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class PlusCommonExtras implements SafeParcelable {
    public static final C1732f CREATOR;
    public static String TAG;
    private final int CK;
    private String anN;
    private String anO;

    static {
        TAG = "PlusCommonExtras";
        CREATOR = new C1732f();
    }

    public PlusCommonExtras() {
        this.CK = 1;
        this.anN = "";
        this.anO = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.CK = i;
        this.anN = str;
        this.anO = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.CK == plusCommonExtras.CK && jv.equal(this.anN, plusCommonExtras.anN) && jv.equal(this.anO, plusCommonExtras.anO);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.anN, this.anO);
    }

    public String ox() {
        return this.anN;
    }

    public String oy() {
        return this.anO;
    }

    public void m6273q(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", C0543c.m1986a(this));
    }

    public String toString() {
        return jv.m5212h(this).m5211a("versionCode", Integer.valueOf(this.CK)).m5211a("Gpsrc", this.anN).m5211a("ClientCallingPackage", this.anO).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1732f.m6352a(this, parcel, i);
    }
}
