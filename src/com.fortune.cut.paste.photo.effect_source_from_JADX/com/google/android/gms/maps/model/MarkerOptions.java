package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.maps.internal.aa;

public final class MarkerOptions implements SafeParcelable {
    public static final C1683k CREATOR;
    private final int CK;
    private String OH;
    private boolean alY;
    private LatLng alt;
    private float amg;
    private float amh;
    private String amp;
    private BitmapDescriptor amq;
    private boolean amr;
    private boolean ams;
    private float amt;
    private float amu;
    private float amv;
    private float mAlpha;

    static {
        CREATOR = new C1683k();
    }

    public MarkerOptions() {
        this.amg = 0.5f;
        this.amh = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.alY = true;
        this.ams = false;
        this.amt = 0.0f;
        this.amu = 0.5f;
        this.amv = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.CK = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.amg = 0.5f;
        this.amh = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.alY = true;
        this.ams = false;
        this.amt = 0.0f;
        this.amu = 0.5f;
        this.amv = 0.0f;
        this.mAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.CK = i;
        this.alt = latLng;
        this.OH = str;
        this.amp = str2;
        this.amq = iBinder == null ? null : new BitmapDescriptor(C0754a.ap(iBinder));
        this.amg = f;
        this.amh = f2;
        this.amr = z;
        this.alY = z2;
        this.ams = z3;
        this.amt = f3;
        this.amu = f4;
        this.amv = f5;
        this.mAlpha = f6;
    }

    public final MarkerOptions alpha(float f) {
        this.mAlpha = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f2) {
        this.amg = f;
        this.amh = f2;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final MarkerOptions draggable(boolean z) {
        this.amr = z;
        return this;
    }

    public final MarkerOptions flat(boolean z) {
        this.ams = z;
        return this;
    }

    public final float getAlpha() {
        return this.mAlpha;
    }

    public final float getAnchorU() {
        return this.amg;
    }

    public final float getAnchorV() {
        return this.amh;
    }

    public final BitmapDescriptor getIcon() {
        return this.amq;
    }

    public final float getInfoWindowAnchorU() {
        return this.amu;
    }

    public final float getInfoWindowAnchorV() {
        return this.amv;
    }

    public final LatLng getPosition() {
        return this.alt;
    }

    public final float getRotation() {
        return this.amt;
    }

    public final String getSnippet() {
        return this.amp;
    }

    public final String getTitle() {
        return this.OH;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.amq = bitmapDescriptor;
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float f, float f2) {
        this.amu = f;
        this.amv = f2;
        return this;
    }

    public final boolean isDraggable() {
        return this.amr;
    }

    public final boolean isFlat() {
        return this.ams;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    final IBinder oe() {
        return this.amq == null ? null : this.amq.nA().asBinder();
    }

    public final MarkerOptions position(LatLng latLng) {
        this.alt = latLng;
        return this;
    }

    public final MarkerOptions rotation(float f) {
        this.amt = f;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.amp = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.OH = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1684l.m6235a(this, parcel, i);
        } else {
            C1683k.m6234a(this, parcel, i);
        }
    }
}
