package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C1511n.C1512a;
import com.google.android.gms.maps.internal.C1513o.C1514a;
import com.google.android.gms.maps.internal.C1515h.C1516a;
import com.google.android.gms.maps.internal.C1517d.C1518a;
import com.google.android.gms.maps.internal.C1519g.C1520a;
import com.google.android.gms.maps.internal.C1522q.C1523a;
import com.google.android.gms.maps.internal.C1525p.C1526a;
import com.google.android.gms.maps.internal.C1528k.C1529a;
import com.google.android.gms.maps.internal.C1531v.C1532a;
import com.google.android.gms.maps.internal.C1537f.C1538a;
import com.google.android.gms.maps.internal.C1540j.C1541a;
import com.google.android.gms.maps.internal.C1543l.C1544a;
import com.google.android.gms.maps.internal.C1546b.C1547a;
import com.google.android.gms.maps.internal.C1614i;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C1535a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C1661i;
import com.google.android.gms.maps.model.internal.C1664j;
import com.google.android.gms.maps.model.internal.C1670l;
import com.google.android.gms.maps.model.internal.C1676n;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate akm;
    private UiSettings akn;

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C1512a {
        final /* synthetic */ OnMarkerClickListener akA;
        final /* synthetic */ GoogleMap akp;

        AnonymousClass10(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.akp = googleMap;
            this.akA = onMarkerClickListener;
        }

        public boolean m6097a(C1670l c1670l) {
            return this.akA.onMarkerClick(new Marker(c1670l));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C1514a {
        final /* synthetic */ OnMarkerDragListener akB;
        final /* synthetic */ GoogleMap akp;

        AnonymousClass11(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.akp = googleMap;
            this.akB = onMarkerDragListener;
        }

        public void m6101b(C1670l c1670l) {
            this.akB.onMarkerDragStart(new Marker(c1670l));
        }

        public void m6102c(C1670l c1670l) {
            this.akB.onMarkerDragEnd(new Marker(c1670l));
        }

        public void m6103d(C1670l c1670l) {
            this.akB.onMarkerDrag(new Marker(c1670l));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C1516a {
        final /* synthetic */ OnInfoWindowClickListener akC;
        final /* synthetic */ GoogleMap akp;

        AnonymousClass12(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.akp = googleMap;
            this.akC = onInfoWindowClickListener;
        }

        public void m6105e(C1670l c1670l) {
            this.akC.onInfoWindowClick(new Marker(c1670l));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends C1518a {
        final /* synthetic */ InfoWindowAdapter akD;
        final /* synthetic */ GoogleMap akp;

        AnonymousClass13(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.akp = googleMap;
            this.akD = infoWindowAdapter;
        }

        public C0752d m6108f(C1670l c1670l) {
            return C0755e.m2594k(this.akD.getInfoWindow(new Marker(c1670l)));
        }

        public C0752d m6109g(C1670l c1670l) {
            return C0755e.m2594k(this.akD.getInfoContents(new Marker(c1670l)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C15211 extends C1520a {
        final /* synthetic */ OnIndoorStateChangeListener ako;
        final /* synthetic */ GoogleMap akp;

        C15211(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.akp = googleMap;
            this.ako = onIndoorStateChangeListener;
        }

        public void m6111a(C1664j c1664j) {
            this.ako.onIndoorLevelActivated(new IndoorBuilding(c1664j));
        }

        public void onIndoorBuildingFocused() {
            this.ako.onIndoorBuildingFocused();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C15242 extends C1523a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnMyLocationChangeListener akq;

        C15242(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.akp = googleMap;
            this.akq = onMyLocationChangeListener;
        }

        public void m6114c(Location location) {
            this.akq.onMyLocationChange(location);
        }

        public void m6115g(C0752d c0752d) {
            this.akq.onMyLocationChange((Location) C0755e.m2593f(c0752d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C15273 extends C1526a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnMyLocationButtonClickListener akr;

        C15273(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.akp = googleMap;
            this.akr = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.akr.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C15304 extends C1529a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnMapLoadedCallback aks;

        C15304(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.akp = googleMap;
            this.aks = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.aks.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C15335 extends C1532a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ SnapshotReadyCallback akt;

        C15335(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.akp = googleMap;
            this.akt = snapshotReadyCallback;
        }

        public void m6117h(C0752d c0752d) throws RemoteException {
            this.akt.onSnapshotReady((Bitmap) C0755e.m2593f(c0752d));
        }

        public void onSnapshotReady(Bitmap bitmap) throws RemoteException {
            this.akt.onSnapshotReady(bitmap);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C15366 extends C1535a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ LocationSource aku;

        /* renamed from: com.google.android.gms.maps.GoogleMap.6.1 */
        class C15341 implements OnLocationChangedListener {
            final /* synthetic */ C1614i akv;
            final /* synthetic */ C15366 akw;

            C15341(C15366 c15366, C1614i c1614i) {
                this.akw = c15366;
                this.akv = c1614i;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.akv.m6160d(location);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C15366(GoogleMap googleMap, LocationSource locationSource) {
            this.akp = googleMap;
            this.aku = locationSource;
        }

        public void activate(C1614i c1614i) {
            this.aku.activate(new C15341(this, c1614i));
        }

        public void deactivate() {
            this.aku.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C15397 extends C1538a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnCameraChangeListener akx;

        C15397(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.akp = googleMap;
            this.akx = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            this.akx.onCameraChange(cameraPosition);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C15428 extends C1541a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnMapClickListener aky;

        C15428(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.akp = googleMap;
            this.aky = onMapClickListener;
        }

        public void onMapClick(LatLng latLng) {
            this.aky.onMapClick(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C15459 extends C1544a {
        final /* synthetic */ GoogleMap akp;
        final /* synthetic */ OnMapLongClickListener akz;

        C15459(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.akp = googleMap;
            this.akz = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng latLng) {
            this.akz.onMapLongClick(latLng);
        }
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C1548a extends C1547a {
        private final CancelableCallback akE;

        C1548a(CancelableCallback cancelableCallback) {
            this.akE = cancelableCallback;
        }

        public final void onCancel() {
            this.akE.onCancel();
        }

        public final void onFinish() {
            this.akE.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.akm = (IGoogleMapDelegate) jx.m5223i(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.akm.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            C1661i addGroundOverlay = this.akm.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            C1670l addMarker = this.akm.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.akm.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.akm.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            C1676n addTileOverlay = this.akm.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.akm.animateCamera(cameraUpdate.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.akm.animateCameraWithDurationAndCallback(cameraUpdate.nA(), i, cancelableCallback == null ? null : new C1548a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.akm.animateCameraWithCallback(cameraUpdate.nA(), cancelableCallback == null ? null : new C1548a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.akm.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.akm.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final IndoorBuilding getFocusedBuilding() {
        try {
            C1664j focusedBuilding = this.akm.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.akm.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.akm.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.akm.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.akm.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.akm.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.akn == null) {
                this.akn = new UiSettings(this.akm.getUiSettings());
            }
            return this.akn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.akm.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.akm.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.akm.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.akm.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.akm.moveCamera(cameraUpdate.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    final IGoogleMapDelegate nC() {
        return this.akm;
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.akm.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.akm.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.akm.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.akm.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setInfoWindowAdapter(new AnonymousClass13(this, infoWindowAdapter));
    }

    public final void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.akm.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setLocationSource(new C15366(this, locationSource));
    }

    public final void setMapType(int i) {
        try {
            this.akm.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.akm.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.akm.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnCameraChangeListener(new C15397(this, onCameraChangeListener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.akm.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnIndoorStateChangeListener(new C15211(this, onIndoorStateChangeListener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.akm.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnInfoWindowClickListener(new AnonymousClass12(this, onInfoWindowClickListener));
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.akm.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapClickListener(new C15428(this, onMapClickListener));
    }

    public final void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.akm.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLoadedCallback(new C15304(this, onMapLoadedCallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.akm.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLongClickListener(new C15459(this, onMapLongClickListener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.akm.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerClickListener(new AnonymousClass10(this, onMarkerClickListener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.akm.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerDragListener(new AnonymousClass11(this, onMarkerDragListener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.akm.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationButtonClickListener(new C15273(this, onMyLocationButtonClickListener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.akm.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationChangeListener(new C15242(this, onMyLocationChangeListener));
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.akm.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.akm.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.akm.snapshot(new C15335(this, snapshotReadyCallback), (C0755e) (bitmap != null ? C0755e.m2594k(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.akm.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
