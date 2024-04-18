package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C1643f {
    static void m6197a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0542b.m1962a(parcel, 2, groundOverlayOptions.od(), false);
        C0542b.m1964a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0542b.m1959a(parcel, 4, groundOverlayOptions.getWidth());
        C0542b.m1959a(parcel, 5, groundOverlayOptions.getHeight());
        C0542b.m1964a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0542b.m1959a(parcel, 7, groundOverlayOptions.getBearing());
        C0542b.m1959a(parcel, 8, groundOverlayOptions.getZIndex());
        C0542b.m1971a(parcel, 9, groundOverlayOptions.isVisible());
        C0542b.m1959a(parcel, 10, groundOverlayOptions.getTransparency());
        C0542b.m1959a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0542b.m1959a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0542b.m1956H(parcel, H);
    }
}
