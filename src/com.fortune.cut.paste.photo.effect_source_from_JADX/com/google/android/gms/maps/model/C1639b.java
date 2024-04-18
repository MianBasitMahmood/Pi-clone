package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C1639b {
    static void m6193a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, cameraPosition.getVersionCode());
        C0542b.m1964a(parcel, 2, cameraPosition.target, i, false);
        C0542b.m1959a(parcel, 3, cameraPosition.zoom);
        C0542b.m1959a(parcel, 4, cameraPosition.tilt);
        C0542b.m1959a(parcel, 5, cameraPosition.bearing);
        C0542b.m1956H(parcel, H);
    }
}
