package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class oh implements SafeParcelable {
    public static final oi CREATOR;
    public static final oh akf;
    public final String akg;
    public final String akh;
    public final String aki;
    public final String akj;
    public final int versionCode;

    static {
        akf = new oh(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, Locale.ENGLISH, null);
        CREATOR = new oi();
    }

    public oh(int i, String str, String str2, String str3, String str4) {
        this.versionCode = i;
        this.akg = str;
        this.akh = str2;
        this.aki = str3;
        this.akj = str4;
    }

    public oh(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null);
    }

    public int describeContents() {
        oi oiVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof oh)) {
            return false;
        }
        oh ohVar = (oh) obj;
        return this.akh.equals(ohVar.akh) && this.akg.equals(ohVar.akg) && jv.equal(this.aki, ohVar.aki) && jv.equal(this.akj, ohVar.akj);
    }

    public int hashCode() {
        return jv.hashCode(this.akg, this.akh, this.aki);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("clientPackageName", this.akg).m5211a("locale", this.akh).m5211a("accountName", this.aki).m5211a("gCoreClientName", this.akj).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        oi oiVar = CREATOR;
        oi.m5698a(this, parcel, i);
    }
}
