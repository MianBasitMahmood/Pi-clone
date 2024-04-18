package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class CircleOptions implements SafeParcelable {
    public static final C1640c CREATOR;
    private final int CK;
    private LatLng alS;
    private double alT;
    private float alU;
    private int alV;
    private int alW;
    private float alX;
    private boolean alY;

    static {
        CREATOR = new C1640c();
    }

    public CircleOptions() {
        this.alS = null;
        this.alT = 0.0d;
        this.alU = 10.0f;
        this.alV = ViewCompat.MEASURED_STATE_MASK;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.CK = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.alS = null;
        this.alT = 0.0d;
        this.alU = 10.0f;
        this.alV = ViewCompat.MEASURED_STATE_MASK;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.CK = i;
        this.alS = latLng;
        this.alT = d;
        this.alU = f;
        this.alV = i2;
        this.alW = i3;
        this.alX = f2;
        this.alY = z;
    }

    public final CircleOptions center(LatLng latLng) {
        this.alS = latLng;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i) {
        this.alW = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.alS;
    }

    public final int getFillColor() {
        return this.alW;
    }

    public final double getRadius() {
        return this.alT;
    }

    public final int getStrokeColor() {
        return this.alV;
    }

    public final float getStrokeWidth() {
        return this.alU;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final float getZIndex() {
        return this.alX;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    public final CircleOptions radius(double d) {
        this.alT = d;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.alV = i;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.alU = f;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1641d.m6195a(this, parcel, i);
        } else {
            C1640c.m6194a(this, parcel, i);
        }
    }

    public final CircleOptions zIndex(float f) {
        this.alX = f;
        return this;
    }
}
