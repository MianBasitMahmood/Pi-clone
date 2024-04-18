package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C1682j {
    static void m6233a(LatLng latLng, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, latLng.getVersionCode());
        C0542b.m1958a(parcel, 2, latLng.latitude);
        C0542b.m1958a(parcel, 3, latLng.longitude);
        C0542b.m1956H(parcel, H);
    }
}
