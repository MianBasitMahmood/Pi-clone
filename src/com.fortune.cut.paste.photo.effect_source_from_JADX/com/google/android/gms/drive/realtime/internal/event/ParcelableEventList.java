package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR;
    final int CK;
    final DataHolder Tb;
    final boolean Tc;
    final List<String> Td;
    final List<ParcelableEvent> mp;

    static {
        CREATOR = new C0698c();
    }

    ParcelableEventList(int i, List<ParcelableEvent> list, DataHolder dataHolder, boolean z, List<String> list2) {
        this.CK = i;
        this.mp = list;
        this.Tb = dataHolder;
        this.Tc = z;
        this.Td = list2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0698c.m2451a(this, parcel, i);
    }
}
