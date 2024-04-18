package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0738f;
import com.google.android.gms.dynamic.C0747a;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C1549m.C1550a;
import com.google.android.gms.maps.internal.C1630w;
import com.google.android.gms.maps.internal.C1631x;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private GoogleMap akS;
    private final C1576b alD;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.a */
    static class C1575a implements MapLifecycleDelegate {
        private final Fragment Mx;
        private final IMapFragmentDelegate akT;

        /* renamed from: com.google.android.gms.maps.SupportMapFragment.a.1 */
        class C15741 extends C1550a {
            final /* synthetic */ OnMapReadyCallback akU;
            final /* synthetic */ C1575a alE;

            C15741(C1575a c1575a, OnMapReadyCallback onMapReadyCallback) {
                this.alE = c1575a;
                this.akU = onMapReadyCallback;
            }

            public void m6131a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                this.akU.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public C1575a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.akT = (IMapFragmentDelegate) jx.m5223i(iMapFragmentDelegate);
            this.Mx = (Fragment) jx.m5223i(fragment);
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.akT.getMapAsync(new C15741(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapFragmentDelegate nN() {
            return this.akT;
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Mx.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C1630w.m6173a(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.akT.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C0755e.m2593f(this.akT.onCreateView(C0755e.m2594k(layoutInflater), C0755e.m2594k(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.akT.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.akT.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.akT.onInflate(C0755e.m2594k(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.akT.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.akT.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.akT.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.akT.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.b */
    static class C1576b extends C0747a<C1575a> {
        private final Fragment Mx;
        protected C0738f<C1575a> akW;
        private final List<OnMapReadyCallback> akX;
        private Activity nB;

        C1576b(Fragment fragment) {
            this.akX = new ArrayList();
            this.Mx = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        protected void m6133a(C0738f<C1575a> c0738f) {
            this.akW = c0738f;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (je() != null) {
                ((C1575a) je()).getMapAsync(onMapReadyCallback);
            } else {
                this.akX.add(onMapReadyCallback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.m2570a(new C1575a(this.Mx, C1631x.m6174S(this.nB).m6146j(C0755e.m2594k(this.nB))));
                    for (OnMapReadyCallback mapAsync : this.akX) {
                        ((C1575a) je()).getMapAsync(mapAsync);
                    }
                    this.akX.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public SupportMapFragment() {
        this.alD = new C1576b(this);
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate nN = nN();
        if (nN == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = nN.getMap();
            if (map == null) {
                return null;
            }
            if (this.akS == null || this.akS.nC().asBinder() != map.asBinder()) {
                this.akS = new GoogleMap(map);
            }
            return this.akS;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        jx.aU("getMapAsync must be called on the main thread.");
        this.alD.getMapAsync(onMapReadyCallback);
    }

    protected IMapFragmentDelegate nN() {
        this.alD.nO();
        return this.alD.je() == null ? null : ((C1575a) this.alD.je()).nN();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.alD.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.alD.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.alD.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.alD.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.alD.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.alD.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.alD.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.alD.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.alD.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.alD.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.alD.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
