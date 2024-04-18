package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nd implements SafeParcelable {
    public static final ne CREATOR;
    private final int CK;
    public final String packageName;
    public final int uid;

    static {
        CREATOR = new ne();
    }

    nd(int i, int i2, String str) {
        this.CK = i;
        this.uid = i2;
        this.packageName = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof nd)) {
            return false;
        }
        nd ndVar = (nd) obj;
        return ndVar.uid == this.uid && jv.equal(ndVar.packageName, this.packageName);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public void writeToParcel(Parcel parcel, int i) {
        ne.m5546a(this, parcel, i);
    }
}
