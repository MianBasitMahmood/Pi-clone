package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR;
    private final int CK;
    private final String Yi;
    private final int Yj;

    static {
        CREATOR = new ConnectionInfoCreator();
    }

    public ConnectionInfo(int i, String str, int i2) {
        this.CK = i;
        this.Yi = str;
        this.Yj = i2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public String le() {
        return this.Yi;
    }

    public int lf() {
        return this.Yj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.m3004a(this, parcel, i);
    }
}
