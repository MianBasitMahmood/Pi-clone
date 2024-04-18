package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final List<BleDevice> Wq;

    static {
        CREATOR = new C0841a();
    }

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.CK = i;
        this.Wq = Collections.unmodifiableList(list);
        this.Eb = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.CK = 3;
        this.Wq = Collections.unmodifiableList(list);
        this.Eb = status;
    }

    public static BleDevicesResult m2781C(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean m2782b(BleDevicesResult bleDevicesResult) {
        return this.Eb.equals(bleDevicesResult.Eb) && jv.equal(this.Wq, bleDevicesResult.Wq);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && m2782b((BleDevicesResult) obj));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.Wq;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.Wq) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.Wq);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("bleDevices", this.Wq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0841a.m2798a(this, parcel, i);
    }
}
