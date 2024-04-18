package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.l */
public class C1684l {
    static void m6235a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, markerOptions.getVersionCode());
        C0542b.m1964a(parcel, 2, markerOptions.getPosition(), i, false);
        C0542b.m1968a(parcel, 3, markerOptions.getTitle(), false);
        C0542b.m1968a(parcel, 4, markerOptions.getSnippet(), false);
        C0542b.m1962a(parcel, 5, markerOptions.oe(), false);
        C0542b.m1959a(parcel, 6, markerOptions.getAnchorU());
        C0542b.m1959a(parcel, 7, markerOptions.getAnchorV());
        C0542b.m1971a(parcel, 8, markerOptions.isDraggable());
        C0542b.m1971a(parcel, 9, markerOptions.isVisible());
        C0542b.m1956H(parcel, H);
    }
}
