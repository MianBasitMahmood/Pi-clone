package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.b */
public class C1581b {
    static void m6138a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, googleMapOptions.getVersionCode());
        C0542b.m1957a(parcel, 2, googleMapOptions.nD());
        C0542b.m1957a(parcel, 3, googleMapOptions.nE());
        C0542b.m1980c(parcel, 4, googleMapOptions.getMapType());
        C0542b.m1964a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0542b.m1957a(parcel, 6, googleMapOptions.nF());
        C0542b.m1957a(parcel, 7, googleMapOptions.nG());
        C0542b.m1957a(parcel, 8, googleMapOptions.nH());
        C0542b.m1957a(parcel, 9, googleMapOptions.nI());
        C0542b.m1957a(parcel, 10, googleMapOptions.nJ());
        C0542b.m1957a(parcel, 11, googleMapOptions.nK());
        C0542b.m1956H(parcel, H);
    }
}
