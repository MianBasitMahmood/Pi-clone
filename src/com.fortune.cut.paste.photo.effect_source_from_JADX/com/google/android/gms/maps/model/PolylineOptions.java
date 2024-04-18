package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final C1687o CREATOR;
    private final int CK;
    private float alX;
    private boolean alY;
    private float amc;
    private final List<LatLng> amx;
    private boolean amz;
    private int mColor;

    static {
        CREATOR = new C1687o();
    }

    public PolylineOptions() {
        this.amc = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = 1;
        this.amx = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.amc = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = i;
        this.amx = list;
        this.amc = f;
        this.mColor = i2;
        this.alX = f2;
        this.alY = z;
        this.amz = z2;
    }

    public final PolylineOptions add(LatLng latLng) {
        this.amx.add(latLng);
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.amx.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.amx.add(add);
        }
        return this;
    }

    public final PolylineOptions color(int i) {
        this.mColor = i;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.amz = z;
        return this;
    }

    public final int getColor() {
        return this.mColor;
    }

    public final List<LatLng> getPoints() {
        return this.amx;
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

    public final boolean isGeodesic() {
        return this.amz;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    public final PolylineOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final PolylineOptions width(float f) {
        this.amc = f;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1688p.m6239a(this, parcel, i);
        } else {
            C1687o.m6238a(this, parcel, i);
        }
    }

    public final PolylineOptions zIndex(float f) {
        this.alX = f;
        return this;
    }
}
