package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final C1691s CREATOR;
    private final int CK;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    static {
        CREATOR = new C1691s();
    }

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.CK = i;
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this(1, streetViewPanoramaLinkArr, latLng, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("panoId", this.panoId).m5211a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1691s.m6242a(this, parcel, i);
    }
}
