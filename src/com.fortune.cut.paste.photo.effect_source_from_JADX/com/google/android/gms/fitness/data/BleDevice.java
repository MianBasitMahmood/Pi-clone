package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.ls;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR;
    private final int CK;
    private final String TW;
    private final List<String> TX;
    private final List<DataType> TY;
    private final String mName;

    static {
        CREATOR = new C0768c();
    }

    BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.CK = i;
        this.TW = str;
        this.mName = str2;
        this.TX = Collections.unmodifiableList(list);
        this.TY = Collections.unmodifiableList(list2);
    }

    private boolean m2605a(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.TW.equals(bleDevice.TW) && ls.m5344a(bleDevice.TX, this.TX) && ls.m5344a(this.TY, bleDevice.TY);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && m2605a((BleDevice) obj));
    }

    public String getAddress() {
        return this.TW;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.TX;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.TW, this.TX, this.TY);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("name", this.mName).m5211a("address", this.TW).m5211a("dataTypes", this.TY).m5211a("supportedProfiles", this.TX).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0768c.m2654a(this, parcel, i);
    }
}
