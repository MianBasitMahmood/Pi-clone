package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hp.C1190a;

public class hh implements SafeParcelable {
    public static final hi CREATOR;
    public static final int CV;
    private static final hp CW;
    final int CK;
    public final String CX;
    final hp CY;
    public final int CZ;
    public final byte[] Da;

    static {
        CV = Integer.parseInt("-1");
        CREATOR = new hi();
        CW = new C1190a("SsbContext").m4853G(true).at("blob").fG();
    }

    hh(int i, String str, hp hpVar, int i2, byte[] bArr) {
        boolean z = i2 == CV || ho.m4852P(i2) != null;
        jx.m5221b(z, "Invalid section type " + i2);
        this.CK = i;
        this.CX = str;
        this.CY = hpVar;
        this.CZ = i2;
        this.Da = bArr;
        String fE = fE();
        if (fE != null) {
            throw new IllegalArgumentException(fE);
        }
    }

    public hh(String str, hp hpVar) {
        this(1, str, hpVar, CV, null);
    }

    public hh(String str, hp hpVar, String str2) {
        this(1, str, hpVar, ho.as(str2), null);
    }

    public hh(byte[] bArr, hp hpVar) {
        this(1, null, hpVar, CV, bArr);
    }

    public int describeContents() {
        hi hiVar = CREATOR;
        return 0;
    }

    public String fE() {
        return (this.CZ == CV || ho.m4852P(this.CZ) != null) ? (this.CX == null || this.Da == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.CZ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        hi hiVar = CREATOR;
        hi.m4840a(this, parcel, i);
    }
}
