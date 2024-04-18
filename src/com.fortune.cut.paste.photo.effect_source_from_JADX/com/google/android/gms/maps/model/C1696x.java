package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.x */
public class C1696x {
    static void m6247a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0542b.m1962a(parcel, 2, tileOverlayOptions.og(), false);
        C0542b.m1971a(parcel, 3, tileOverlayOptions.isVisible());
        C0542b.m1959a(parcel, 4, tileOverlayOptions.getZIndex());
        C0542b.m1956H(parcel, H);
    }
}
