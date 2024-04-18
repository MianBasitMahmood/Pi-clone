package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.b */
public class C0808b implements SafeParcelable {
    public static final Creator<C0808b> CREATOR;
    private final int CK;
    private final String VF;
    private final BleDevice VG;

    static {
        CREATOR = new C0809c();
    }

    C0808b(int i, String str, BleDevice bleDevice) {
        this.CK = i;
        this.VF = str;
        this.VG = bleDevice;
    }

    public C0808b(BleDevice bleDevice) {
        this(2, bleDevice.getAddress(), bleDevice);
    }

    public C0808b(String str) {
        this(2, str, null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.VF;
    }

    int getVersionCode() {
        return this.CK;
    }

    public BleDevice jQ() {
        return this.VG;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.VF, this.VG});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0809c.m2751a(this, parcel, i);
    }
}
