package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

/* renamed from: com.google.android.gms.fitness.data.a */
public final class C0766a implements SafeParcelable {
    public static final Creator<C0766a> CREATOR;
    public static final C0766a TT;
    private final int CK;
    private final String CS;
    private final String TU;
    private final String TV;

    static {
        TT = new C0766a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
        CREATOR = new C0767b();
    }

    C0766a(int i, String str, String str2, String str3) {
        this.CK = i;
        this.CS = (String) jx.m5223i(str);
        this.TU = "";
        this.TV = str3;
    }

    public C0766a(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean m2652a(C0766a c0766a) {
        return this.CS.equals(c0766a.CS) && jv.equal(this.TU, c0766a.TU) && jv.equal(this.TV, c0766a.TV);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof C0766a) && m2652a((C0766a) obj));
    }

    public final String getPackageName() {
        return this.CS;
    }

    public final String getVersion() {
        return this.TU;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.CS, this.TU, this.TV);
    }

    public final String jk() {
        return this.TV;
    }

    final C0766a jl() {
        return new C0766a(mg.bw(this.CS), mg.bw(this.TU), mg.bw(this.TV));
    }

    public final String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.CS, this.TU, this.TV});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0767b.m2653a(this, parcel, i);
    }
}
