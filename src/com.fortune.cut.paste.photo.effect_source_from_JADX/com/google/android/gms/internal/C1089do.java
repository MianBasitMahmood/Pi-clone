package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
/* renamed from: com.google.android.gms.internal.do */
public final class C1089do implements SafeParcelable {
    public static final dn CREATOR;
    public final String mimeType;
    public final String packageName;
    public final String rG;
    public final String rH;
    public final String rI;
    public final String rJ;
    public final String rK;
    public final int versionCode;

    static {
        CREATOR = new dn();
    }

    public C1089do(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.rG = str;
        this.rH = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.rI = str5;
        this.rJ = str6;
        this.rK = str7;
    }

    public C1089do(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        dn.m4441a(this, parcel, i);
    }
}
