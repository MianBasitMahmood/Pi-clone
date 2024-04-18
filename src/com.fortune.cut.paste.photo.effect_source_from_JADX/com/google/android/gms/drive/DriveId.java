package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C0634w;
import com.google.android.gms.drive.internal.ak;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR;
    final int CK;
    final String Ot;
    final long Ou;
    final long Ov;
    private volatile String Ow;

    static {
        CREATOR = new C0552c();
    }

    DriveId(int i, String str, long j, long j2) {
        boolean z = false;
        this.Ow = null;
        this.CK = i;
        this.Ot = str;
        jx.m5216L(!"".equals(str));
        if (!(str == null && j == -1)) {
            z = true;
        }
        jx.m5216L(z);
        this.Ou = j;
        this.Ov = j2;
    }

    public DriveId(String str, long j, long j2) {
        this(1, str, j, j2);
    }

    public static DriveId bi(String str) {
        jx.m5223i(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String str) {
        jx.m5221b(str.startsWith("DriveId:"), "Invalid DriveId: " + str);
        return m1994f(Base64.decode(str.substring(8), 10));
    }

    static DriveId m1994f(byte[] bArr) {
        try {
            ak g = ak.m2154g(bArr);
            return new DriveId(g.versionCode, "".equals(g.QG) ? null : g.QG, g.QH, g.QI);
        } catch (qv e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.Ow == null) {
            this.Ow = "DriveId:" + Base64.encodeToString(iu(), 10);
        }
        return this.Ow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.Ov == this.Ov) {
            return (driveId.Ou == -1 && this.Ou == -1) ? driveId.Ot.equals(this.Ot) : driveId.Ou == this.Ou;
        } else {
            C0634w.m2301o("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }
    }

    public String getResourceId() {
        return this.Ot;
    }

    public int hashCode() {
        return this.Ou == -1 ? this.Ot.hashCode() : (String.valueOf(this.Ov) + String.valueOf(this.Ou)).hashCode();
    }

    final byte[] iu() {
        qw akVar = new ak();
        akVar.versionCode = this.CK;
        akVar.QG = this.Ot == null ? "" : this.Ot;
        akVar.QH = this.Ou;
        akVar.QI = this.Ov;
        return qw.m2145f(akVar);
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0552c.m2003a(this, parcel, i);
    }
}
