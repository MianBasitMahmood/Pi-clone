package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final C1642e CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private final int CK;
    private float alQ;
    private float alX;
    private boolean alY;
    private BitmapDescriptor ama;
    private LatLng amb;
    private float amc;
    private float amd;
    private LatLngBounds ame;
    private float amf;
    private float amg;
    private float amh;

    static {
        CREATOR = new C1642e();
    }

    public GroundOverlayOptions() {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = i;
        this.ama = new BitmapDescriptor(C0754a.ap(iBinder));
        this.amb = latLng;
        this.amc = f;
        this.amd = f2;
        this.ame = latLngBounds;
        this.alQ = f3;
        this.alX = f4;
        this.alY = z;
        this.amf = f5;
        this.amg = f6;
        this.amh = f7;
    }

    private GroundOverlayOptions m6181a(LatLng latLng, float f, float f2) {
        this.amb = latLng;
        this.amc = f;
        this.amd = f2;
        return this;
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.amg = f;
        this.amh = f2;
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.alQ = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final float getAnchorU() {
        return this.amg;
    }

    public final float getAnchorV() {
        return this.amh;
    }

    public final float getBearing() {
        return this.alQ;
    }

    public final LatLngBounds getBounds() {
        return this.ame;
    }

    public final float getHeight() {
        return this.amd;
    }

    public final BitmapDescriptor getImage() {
        return this.ama;
    }

    public final LatLng getLocation() {
        return this.amb;
    }

    public final float getTransparency() {
        return this.amf;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final float getWidth() {
        return this.amc;
    }

    public final float getZIndex() {
        return this.alX;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.ama = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    final IBinder od() {
        return this.ama.nA().asBinder();
    }

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        jx.m5217a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.m5221b(latLng != null, (Object) "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        jx.m5221b(z, (Object) "Width must be non-negative");
        return m6181a(latLng, f, NO_DIMENSION);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        jx.m5217a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.m5221b(latLng != null, (Object) "Location must be specified");
        jx.m5221b(f >= 0.0f, (Object) "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        jx.m5221b(z, (Object) "Height must be non-negative");
        return m6181a(latLng, f, f2);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        jx.m5217a(this.amb == null, "Position has already been set using position: " + this.amb);
        this.ame = latLngBounds;
        return this;
    }

    public final GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= TextTrackStyle.DEFAULT_FONT_SCALE;
        jx.m5221b(z, (Object) "Transparency must be in the range [0..1]");
        this.amf = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1643f.m6197a(this, parcel, i);
        } else {
            C1642e.m6196a(this, parcel, i);
        }
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.alX = f;
        return this;
    }
}
