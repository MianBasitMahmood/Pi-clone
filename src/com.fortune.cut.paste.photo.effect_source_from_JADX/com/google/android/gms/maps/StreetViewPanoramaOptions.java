package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1602a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final C1582c CREATOR;
    private final int CK;
    private Boolean akG;
    private Boolean akM;
    private StreetViewPanoramaCamera alr;
    private String als;
    private LatLng alt;
    private Integer alu;
    private Boolean alv;
    private Boolean alw;
    private Boolean alx;

    static {
        CREATOR = new C1582c();
    }

    public StreetViewPanoramaOptions() {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = i;
        this.alr = streetViewPanoramaCamera;
        this.alt = latLng;
        this.alu = num;
        this.als = str;
        this.alv = C1602a.m6140a(b);
        this.akM = C1602a.m6140a(b2);
        this.alw = C1602a.m6140a(b3);
        this.alx = C1602a.m6140a(b4);
        this.akG = C1602a.m6140a(b5);
    }

    public final int describeContents() {
        return 0;
    }

    public final Boolean getPanningGesturesEnabled() {
        return this.alw;
    }

    public final String getPanoramaId() {
        return this.als;
    }

    public final LatLng getPosition() {
        return this.alt;
    }

    public final Integer getRadius() {
        return this.alu;
    }

    public final Boolean getStreetNamesEnabled() {
        return this.alx;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.alr;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.akG;
    }

    public final Boolean getUserNavigationEnabled() {
        return this.alv;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.akM;
    }

    final byte nE() {
        return C1602a.m6141c(this.akG);
    }

    final byte nI() {
        return C1602a.m6141c(this.akM);
    }

    final byte nS() {
        return C1602a.m6141c(this.alv);
    }

    final byte nT() {
        return C1602a.m6141c(this.alw);
    }

    final byte nU() {
        return C1602a.m6141c(this.alx);
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.alw = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.alr = streetViewPanoramaCamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String str) {
        this.als = str;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng) {
        this.alt = latLng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.alt = latLng;
        this.alu = num;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.alx = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.akG = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.alv = Boolean.valueOf(z);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1582c.m6139a(this, parcel, i);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.akM = Boolean.valueOf(z);
        return this;
    }
}
