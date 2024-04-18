package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C1734h implements SafeParcelable {
    public static final C1735i CREATOR;
    private final int CK;
    private final String DZ;
    private final String[] anQ;
    private final String[] anR;
    private final String[] anS;
    private final String anT;
    private final String anU;
    private final String anV;
    private final String anW;
    private final PlusCommonExtras anX;

    static {
        CREATOR = new C1735i();
    }

    C1734h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.CK = i;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = str5;
        this.anX = plusCommonExtras;
    }

    public C1734h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.CK = 1;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = null;
        this.anX = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1734h)) {
            return false;
        }
        C1734h c1734h = (C1734h) obj;
        return this.CK == c1734h.CK && jv.equal(this.DZ, c1734h.DZ) && Arrays.equals(this.anQ, c1734h.anQ) && Arrays.equals(this.anR, c1734h.anR) && Arrays.equals(this.anS, c1734h.anS) && jv.equal(this.anT, c1734h.anT) && jv.equal(this.anU, c1734h.anU) && jv.equal(this.anV, c1734h.anV) && jv.equal(this.anW, c1734h.anW) && jv.equal(this.anX, c1734h.anX);
    }

    public String getAccountName() {
        return this.DZ;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.DZ, this.anQ, this.anR, this.anS, this.anT, this.anU, this.anV, this.anW, this.anX);
    }

    public String[] oA() {
        return this.anR;
    }

    public String[] oB() {
        return this.anS;
    }

    public String oC() {
        return this.anT;
    }

    public String oD() {
        return this.anU;
    }

    public String oE() {
        return this.anV;
    }

    public String oF() {
        return this.anW;
    }

    public PlusCommonExtras oG() {
        return this.anX;
    }

    public Bundle oH() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.anX.m6273q(bundle);
        return bundle;
    }

    public String[] oz() {
        return this.anQ;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("versionCode", Integer.valueOf(this.CK)).m5211a("accountName", this.DZ).m5211a("requestedScopes", this.anQ).m5211a("visibleActivities", this.anR).m5211a("requiredFeatures", this.anS).m5211a("packageNameForAuth", this.anT).m5211a("callingPackageName", this.anU).m5211a("applicationName", this.anV).m5211a("extra", this.anX.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1735i.m6355a(this, parcel, i);
    }
}
