package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1602a;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final C1580a CREATOR;
    private final int CK;
    private Boolean akF;
    private Boolean akG;
    private int akH;
    private CameraPosition akI;
    private Boolean akJ;
    private Boolean akK;
    private Boolean akL;
    private Boolean akM;
    private Boolean akN;
    private Boolean akO;
    private Boolean akP;
    private Boolean akQ;

    static {
        CREATOR = new C1580a();
    }

    public GoogleMapOptions() {
        this.akH = -1;
        this.CK = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
        this.akH = -1;
        this.CK = i;
        this.akF = C1602a.m6140a(b);
        this.akG = C1602a.m6140a(b2);
        this.akH = i2;
        this.akI = cameraPosition;
        this.akJ = C1602a.m6140a(b3);
        this.akK = C1602a.m6140a(b4);
        this.akL = C1602a.m6140a(b5);
        this.akM = C1602a.m6140a(b6);
        this.akN = C1602a.m6140a(b7);
        this.akO = C1602a.m6140a(b8);
        this.akP = C1602a.m6140a(b9);
        this.akQ = C1602a.m6140a(b10);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0366R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0366R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0366R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0366R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public final GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.akI = cameraPosition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean z) {
        this.akK = Boolean.valueOf(z);
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final CameraPosition getCamera() {
        return this.akI;
    }

    public final Boolean getCompassEnabled() {
        return this.akK;
    }

    public final Boolean getLiteMode() {
        return this.akP;
    }

    public final Boolean getMapToolbarEnabled() {
        return this.akQ;
    }

    public final int getMapType() {
        return this.akH;
    }

    public final Boolean getRotateGesturesEnabled() {
        return this.akO;
    }

    public final Boolean getScrollGesturesEnabled() {
        return this.akL;
    }

    public final Boolean getTiltGesturesEnabled() {
        return this.akN;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.akG;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final Boolean getZOrderOnTop() {
        return this.akF;
    }

    public final Boolean getZoomControlsEnabled() {
        return this.akJ;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.akM;
    }

    public final GoogleMapOptions liteMode(boolean z) {
        this.akP = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.akQ = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapType(int i) {
        this.akH = i;
        return this;
    }

    final byte nD() {
        return C1602a.m6141c(this.akF);
    }

    final byte nE() {
        return C1602a.m6141c(this.akG);
    }

    final byte nF() {
        return C1602a.m6141c(this.akJ);
    }

    final byte nG() {
        return C1602a.m6141c(this.akK);
    }

    final byte nH() {
        return C1602a.m6141c(this.akL);
    }

    final byte nI() {
        return C1602a.m6141c(this.akM);
    }

    final byte nJ() {
        return C1602a.m6141c(this.akN);
    }

    final byte nK() {
        return C1602a.m6141c(this.akO);
    }

    final byte nL() {
        return C1602a.m6141c(this.akP);
    }

    final byte nM() {
        return C1602a.m6141c(this.akQ);
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.akO = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.akL = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.akN = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.akG = Boolean.valueOf(z);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1581b.m6138a(this, parcel, i);
        } else {
            C1580a.m6137a(this, parcel, i);
        }
    }

    public final GoogleMapOptions zOrderOnTop(boolean z) {
        this.akF = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.akJ = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.akM = Boolean.valueOf(z);
        return this;
    }
}
