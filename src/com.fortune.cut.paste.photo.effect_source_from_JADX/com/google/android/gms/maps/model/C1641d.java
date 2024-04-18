package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C1641d {
    static void m6195a(CircleOptions circleOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, circleOptions.getVersionCode());
        C0542b.m1964a(parcel, 2, circleOptions.getCenter(), i, false);
        C0542b.m1958a(parcel, 3, circleOptions.getRadius());
        C0542b.m1959a(parcel, 4, circleOptions.getStrokeWidth());
        C0542b.m1980c(parcel, 5, circleOptions.getStrokeColor());
        C0542b.m1980c(parcel, 6, circleOptions.getFillColor());
        C0542b.m1959a(parcel, 7, circleOptions.getZIndex());
        C0542b.m1971a(parcel, 8, circleOptions.isVisible());
        C0542b.m1956H(parcel, H);
    }
}
