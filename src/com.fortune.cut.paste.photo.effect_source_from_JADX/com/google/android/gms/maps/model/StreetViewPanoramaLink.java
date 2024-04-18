package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final C1690r CREATOR;
    private final int CK;
    public final float bearing;
    public final String panoId;

    static {
        CREATOR = new C1690r();
    }

    StreetViewPanoramaLink(int i, String str, float f) {
        this.CK = i;
        this.panoId = str;
        if (((double) f) <= 0.0d) {
            f = (f % 360.0f) + 360.0f;
        }
        this.bearing = f % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return jv.m5212h(this).m5211a("panoId", this.panoId).m5211a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1690r.m6241a(this, parcel, i);
    }
}
