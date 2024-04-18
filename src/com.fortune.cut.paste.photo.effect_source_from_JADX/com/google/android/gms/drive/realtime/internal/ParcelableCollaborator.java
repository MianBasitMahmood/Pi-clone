package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR;
    final int CK;
    final String OS;
    final boolean SH;
    final boolean SI;
    final String SJ;
    final String SK;
    final String SL;
    final String vZ;

    static {
        CREATOR = new C0736p();
    }

    ParcelableCollaborator(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.CK = i;
        this.SH = z;
        this.SI = z2;
        this.vZ = str;
        this.SJ = str2;
        this.OS = str3;
        this.SK = str4;
        this.SL = str5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.vZ.equals(((ParcelableCollaborator) obj).vZ);
    }

    public int hashCode() {
        return this.vZ.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.SH + ", isAnonymous=" + this.SI + ", sessionId=" + this.vZ + ", userId=" + this.SJ + ", displayName=" + this.OS + ", color=" + this.SK + ", photoUrl=" + this.SL + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0736p.m2567a(this, parcel, i);
    }
}
