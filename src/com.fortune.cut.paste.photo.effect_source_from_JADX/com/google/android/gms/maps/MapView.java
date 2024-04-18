package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0738f;
import com.google.android.gms.dynamic.C0747a;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C1549m.C1550a;
import com.google.android.gms.maps.internal.C1631x;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap akS;
    private final C1556b akY;

    /* renamed from: com.google.android.gms.maps.MapView.a */
    static class C1555a implements MapLifecycleDelegate {
        private final ViewGroup akZ;
        private final IMapViewDelegate ala;
        private View alb;

        /* renamed from: com.google.android.gms.maps.MapView.a.1 */
        class C15541 extends C1550a {
            final /* synthetic */ OnMapReadyCallback akU;
            final /* synthetic */ C1555a alc;

            C15541(C1555a c1555a, OnMapReadyCallback onMapReadyCallback) {
                this.alc = c1555a;
                this.akU = onMapReadyCallback;
            }

            public void m6122a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                this.akU.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public C1555a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.ala = (IMapViewDelegate) jx.m5223i(iMapViewDelegate);
            this.akZ = (ViewGroup) jx.m5223i(viewGroup);
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.ala.getMapAsync(new C15541(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapViewDelegate nP() {
            return this.ala;
        }

        public void onCreate(Bundle bundle) {
            try {
                this.ala.onCreate(bundle);
                this.alb = (View) C0755e.m2593f(this.ala.getView());
                this.akZ.removeAllViews();
                this.akZ.addView(this.alb);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ala.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.ala.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ala.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ala.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.ala.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView.b */
    static class C1556b extends C0747a<C1555a> {
        protected C0738f<C1555a> akW;
        private final List<OnMapReadyCallback> akX;
        private final ViewGroup ald;
        private final GoogleMapOptions ale;
        private final Context mContext;

        C1556b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.akX = new ArrayList();
            this.ald = viewGroup;
            this.mContext = context;
            this.ale = googleMapOptions;
        }

        protected void m6123a(C0738f<C1555a> c0738f) {
            this.akW = c0738f;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (je() != null) {
                ((C1555a) je()).getMapAsync(onMapReadyCallback);
            } else {
                this.akX.add(onMapReadyCallback);
            }
        }

        public void nO() {
            if (this.akW != null && je() == null) {
                try {
                    this.akW.m2570a(new C1555a(this.ald, C1631x.m6174S(this.mContext).m6142a(C0755e.m2594k(this.mContext), this.ale)));
                    for (OnMapReadyCallback mapAsync : this.akX) {
                        ((C1555a) je()).getMapAsync(mapAsync);
                    }
                    this.akX.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.akY = new C1556b(this, context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = new C1556b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akY = new C1556b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.akY = new C1556b(this, context, googleMapOptions);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.akS != null) {
            return this.akS;
        }
        this.akY.nO();
        if (this.akY.je() == null) {
            return null;
        }
        try {
            this.akS = new GoogleMap(((C1555a) this.akY.je()).nP().getMap());
            return this.akS;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        jx.aU("getMapAsync() must be called on the main thread");
        this.akY.getMapAsync(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.akY.onCreate(bundle);
        if (this.akY.je() == null) {
            C0747a.m2583b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.akY.onDestroy();
    }

    public final void onLowMemory() {
        this.akY.onLowMemory();
    }

    public final void onPause() {
        this.akY.onPause();
    }

    public final void onResume() {
        this.akY.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.akY.onSaveInstanceState(bundle);
    }
}
