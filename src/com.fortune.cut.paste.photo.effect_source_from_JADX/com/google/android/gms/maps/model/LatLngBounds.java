package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class LatLngBounds implements SafeParcelable {
    public static final C1644g CREATOR;
    private final int CK;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double amk;
        private double aml;
        private double amm;
        private double amn;

        public Builder() {
            this.amk = Double.POSITIVE_INFINITY;
            this.aml = Double.NEGATIVE_INFINITY;
            this.amm = Double.NaN;
            this.amn = Double.NaN;
        }

        private boolean m6182d(double d) {
            return this.amm <= this.amn ? this.amm <= d && d <= this.amn : this.amm <= d || d <= this.amn;
        }

        public final LatLngBounds build() {
            jx.m5217a(!Double.isNaN(this.amm), "no included points");
            return new LatLngBounds(new LatLng(this.amk, this.amm), new LatLng(this.aml, this.amn));
        }

        public final Builder include(LatLng latLng) {
            this.amk = Math.min(this.amk, latLng.latitude);
            this.aml = Math.max(this.aml, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.amm)) {
                this.amm = d;
            } else {
                if (!m6182d(d)) {
                    if (LatLngBounds.m6183b(this.amm, d) < LatLngBounds.m6184c(this.amn, d)) {
                        this.amm = d;
                    }
                }
                return this;
            }
            this.amn = d;
            return this;
        }
    }

    static {
        CREATOR = new C1644g();
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        jx.m5219b((Object) latLng, (Object) "null southwest");
        jx.m5219b((Object) latLng2, (Object) "null northeast");
        jx.m5222b(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.CK = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private static double m6183b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double m6184c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean m6185c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean m6187d(double d) {
        return this.southwest.longitude <= this.northeast.longitude ? this.southwest.longitude <= d && d <= this.northeast.longitude : this.southwest.longitude <= d || d <= this.northeast.longitude;
    }

    public final boolean contains(LatLng latLng) {
        return m6185c(latLng.latitude) && m6187d(latLng.longitude);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.southwest, this.northeast);
    }

    public final LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (m6187d(d3)) {
            d3 = d2;
            d2 = d;
        } else if (m6183b(d2, d3) < m6184c(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("southwest", this.southwest).m5211a("northeast", this.northeast).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1645h.m6199a(this, parcel, i);
        } else {
            C1644g.m6198a(this, parcel, i);
        }
    }
}
