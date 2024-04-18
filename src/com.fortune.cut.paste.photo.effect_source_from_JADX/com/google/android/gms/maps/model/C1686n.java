package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.n */
public class C1686n {
    static void m6237a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, polygonOptions.getVersionCode());
        C0542b.m1981c(parcel, 2, polygonOptions.getPoints(), false);
        C0542b.m1982d(parcel, 3, polygonOptions.of(), false);
        C0542b.m1959a(parcel, 4, polygonOptions.getStrokeWidth());
        C0542b.m1980c(parcel, 5, polygonOptions.getStrokeColor());
        C0542b.m1980c(parcel, 6, polygonOptions.getFillColor());
        C0542b.m1959a(parcel, 7, polygonOptions.getZIndex());
        C0542b.m1971a(parcel, 8, polygonOptions.isVisible());
        C0542b.m1971a(parcel, 9, polygonOptions.isGeodesic());
        C0542b.m1956H(parcel, H);
    }
}
