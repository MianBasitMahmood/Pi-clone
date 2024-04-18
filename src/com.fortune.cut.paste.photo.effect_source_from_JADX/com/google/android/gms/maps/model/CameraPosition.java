package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class CameraPosition implements SafeParcelable {
    public static final C1638a CREATOR;
    private final int CK;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng alN;
        private float alO;
        private float alP;
        private float alQ;

        public Builder(CameraPosition cameraPosition) {
            this.alN = cameraPosition.target;
            this.alO = cameraPosition.zoom;
            this.alP = cameraPosition.tilt;
            this.alQ = cameraPosition.bearing;
        }

        public final Builder bearing(float f) {
            this.alQ = f;
            return this;
        }

        public final CameraPosition build() {
            return new CameraPosition(this.alN, this.alO, this.alP, this.alQ);
        }

        public final Builder target(LatLng latLng) {
            this.alN = latLng;
            return this;
        }

        public final Builder tilt(float f) {
            this.alP = f;
            return this;
        }

        public final Builder zoom(float f) {
            this.alO = f;
            return this;
        }
    }

    static {
        CREATOR = new C1638a();
    }

    CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        jx.m5219b((Object) latLng, (Object) "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        jx.m5221b(z, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.CK = i;
        this.target = latLng;
        this.zoom = f;
        this.tilt = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.bearing = f3 % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0366R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C0366R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C0366R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C0366R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C0366R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C0366R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("target", this.target).m5211a("zoom", Float.valueOf(this.zoom)).m5211a("tilt", Float.valueOf(this.tilt)).m5211a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1639b.m6193a(this, parcel, i);
        } else {
            C1638a.m6192a(this, parcel, i);
        }
    }
}
