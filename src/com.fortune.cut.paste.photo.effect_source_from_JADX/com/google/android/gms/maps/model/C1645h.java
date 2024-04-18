package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C1645h {
    static void m6199a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, latLngBounds.getVersionCode());
        C0542b.m1964a(parcel, 2, latLngBounds.southwest, i, false);
        C0542b.m1964a(parcel, 3, latLngBounds.northeast, i, false);
        C0542b.m1956H(parcel, H);
    }
}
