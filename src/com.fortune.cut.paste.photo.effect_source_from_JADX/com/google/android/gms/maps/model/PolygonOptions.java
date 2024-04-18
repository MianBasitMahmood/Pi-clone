package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final C1685m CREATOR;
    private final int CK;
    private float alU;
    private int alV;
    private int alW;
    private float alX;
    private boolean alY;
    private final List<LatLng> amx;
    private final List<List<LatLng>> amy;
    private boolean amz;

    static {
        CREATOR = new C1685m();
    }

    public PolygonOptions() {
        this.alU = 10.0f;
        this.alV = ViewCompat.MEASURED_STATE_MASK;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = 1;
        this.amx = new ArrayList();
        this.amy = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.alU = 10.0f;
        this.alV = ViewCompat.MEASURED_STATE_MASK;
        this.alW = 0;
        this.alX = 0.0f;
        this.alY = true;
        this.amz = false;
        this.CK = i;
        this.amx = list;
        this.amy = list2;
        this.alU = f;
        this.alV = i2;
        this.alW = i3;
        this.alX = f2;
        this.alY = z;
        this.amz = z2;
    }

    public final PolygonOptions add(LatLng latLng) {
        this.amx.add(latLng);
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.amx.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.amx.add(add);
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.amy.add(arrayList);
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final PolygonOptions fillColor(int i) {
        this.alW = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean z) {
        this.amz = z;
        return this;
    }

    public final int getFillColor() {
        return this.alW;
    }

    public final List<List<LatLng>> getHoles() {
        return this.amy;
    }

    public final List<LatLng> getPoints() {
        return this.amx;
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

    public final boolean isGeodesic() {
        return this.amz;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    final List of() {
        return this.amy;
    }

    public final PolygonOptions strokeColor(int i) {
        this.alV = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.alU = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1686n.m6237a(this, parcel, i);
        } else {
            C1685m.m6236a(this, parcel, i);
        }
    }

    public final PolygonOptions zIndex(float f) {
        this.alX = f;
        return this;
    }
}
