package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0542b;

/* renamed from: com.google.android.gms.maps.model.v */
public class C1694v {
    static void m6245a(Tile tile, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, tile.getVersionCode());
        C0542b.m1980c(parcel, 2, tile.width);
        C0542b.m1980c(parcel, 3, tile.height);
        C0542b.m1972a(parcel, 4, tile.data, false);
        C0542b.m1956H(parcel, H);
    }
}
