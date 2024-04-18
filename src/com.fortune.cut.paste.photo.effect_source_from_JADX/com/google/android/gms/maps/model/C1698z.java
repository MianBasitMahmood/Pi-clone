package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.z */
public class C1698z {
    static void m6250a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, visibleRegion.getVersionCode());
        C0542b.m1964a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0542b.m1964a(parcel, 3, visibleRegion.nearRight, i, false);
        C0542b.m1964a(parcel, 4, visibleRegion.farLeft, i, false);
        C0542b.m1964a(parcel, 5, visibleRegion.farRight, i, false);
        C0542b.m1964a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0542b.m1956H(parcel, H);
    }
}
