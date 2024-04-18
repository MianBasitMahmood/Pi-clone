package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.internal.aa;

public final class VisibleRegion implements SafeParcelable {
    public static final C1697y CREATOR;
    private final int CK;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    static {
        CREATOR = new C1697y();
    }

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.CK = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("nearLeft", this.nearLeft).m5211a("nearRight", this.nearRight).m5211a("farLeft", this.farLeft).m5211a("farRight", this.farRight).m5211a("latLngBounds", this.latLngBounds).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1698z.m6250a(this, parcel, i);
        } else {
            C1697y.m6248a(this, parcel, i);
        }
    }
}
