package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.internal.C1635o;
import com.google.android.gms.maps.model.internal.C1635o.C1636a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final C1695w CREATOR;
    private final int CK;
    private float alX;
    private boolean alY;
    private C1635o amD;
    private TileProvider amE;
    private boolean amF;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C16341 implements TileProvider {
        private final C1635o amG;
        final /* synthetic */ TileOverlayOptions amH;

        C16341(TileOverlayOptions tileOverlayOptions) {
            this.amH = tileOverlayOptions;
            this.amG = this.amH.amD;
        }

        public Tile getTile(int i, int i2, int i3) {
            try {
                return this.amG.getTile(i, i2, i3);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C16372 extends C1636a {
        final /* synthetic */ TileOverlayOptions amH;
        final /* synthetic */ TileProvider amI;

        C16372(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.amH = tileOverlayOptions;
            this.amI = tileProvider;
        }

        public Tile getTile(int i, int i2, int i3) {
            return this.amI.getTile(i, i2, i3);
        }
    }

    static {
        CREATOR = new C1695w();
    }

    public TileOverlayOptions() {
        this.alY = true;
        this.amF = true;
        this.CK = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.alY = true;
        this.amF = true;
        this.CK = i;
        this.amD = C1636a.bE(iBinder);
        this.amE = this.amD == null ? null : new C16341(this);
        this.alY = z;
        this.alX = f;
        this.amF = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions fadeIn(boolean z) {
        this.amF = z;
        return this;
    }

    public final boolean getFadeIn() {
        return this.amF;
    }

    public final TileProvider getTileProvider() {
        return this.amE;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final float getZIndex() {
        return this.alX;
    }

    public final boolean isVisible() {
        return this.alY;
    }

    final IBinder og() {
        return this.amD.asBinder();
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.amE = tileProvider;
        this.amD = this.amE == null ? null : new C16372(this, tileProvider);
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.alY = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (aa.ob()) {
            C1696x.m6247a(this, parcel, i);
        } else {
            C1695w.m6246a(this, parcel, i);
        }
    }

    public final TileOverlayOptions zIndex(float f) {
        this.alX = f;
        return this;
    }
}
