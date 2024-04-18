package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.p */
public class C1688p {
    static void m6239a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, polylineOptions.getVersionCode());
        C0542b.m1981c(parcel, 2, polylineOptions.getPoints(), false);
        C0542b.m1959a(parcel, 3, polylineOptions.getWidth());
        C0542b.m1980c(parcel, 4, polylineOptions.getColor());
        C0542b.m1959a(parcel, 5, polylineOptions.getZIndex());
        C0542b.m1971a(parcel, 6, polylineOptions.isVisible());
        C0542b.m1971a(parcel, 7, polylineOptions.isGeodesic());
        C0542b.m1956H(parcel, H);
    }
}
