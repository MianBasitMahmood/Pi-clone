package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0738f;
import com.google.android.gms.dynamic.C0747a;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C1566u.C1567a;
import com.google.android.gms.maps.internal.C1630w;
import com.google.android.gms.maps.internal.C1631x;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
    private final C1570b all;
    private StreetViewPanorama alm;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.a */
    static class C1569a implements StreetViewLifecycleDelegate {
        private final Fragment TG;
        private final IStreetViewPanoramaFragmentDelegate aln;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.a.1 */
        class C15681 extends C1567a {
            final /* synthetic */ OnStreetViewPanoramaReadyCallback alo;
            final /* synthetic */ C1569a alp;

            C15681(C1569a c1569a, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.alp = c1569a;
                this.alo = onStreetViewPanoramaReadyCallback;
            }

            public void m6126a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                this.alo.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public C1569a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.aln = (IStreetViewPanoramaFragmentDelegate) jx.m5223i(iStreetViewPanoramaFragmentDelegate);
            this.TG = (Fragment) jx.m5223i(fragment);
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.aln.getStreetViewPanoramaAsync(new C15681(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IStreetViewPanoramaFragmentDelegate nR() {
            return this.aln;
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.TG.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                C1630w.m6173a(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.aln.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C0755e.m2593f(this.aln.onCreateView(C0755e.m2594k(layoutInflater), C0755e.m2594k(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.aln.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.aln.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.aln.onInflate(C0755e.m2594k(activity), null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.aln.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aln.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aln.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.aln.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.b */
    static class C1570b extends C0747a<C1569a> {
        private final Fragment TG;
        protected C0738f<C1569a> akW;
        private final List<OnStreetViewPanoramaReadyCallback> alq;
        private Activity nB;

        C1570b(Fragment fragment) {
            this.alq = new ArrayList();
            this.TG = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        protected void m6128a(C0738f<C1569a> c0738f) {
            this.akW = c0738f;
            nO();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (je() != null) {
                ((C1569a) je()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.alq.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.m2570a(new C1569a(this.TG, C1631x.m6174S(this.nB).m6147k(C0755e.m2594k(this.nB))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.alq) {
                        ((C1569a) je()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.alq.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public StreetViewPanoramaFragment() {
        this.all = new C1570b(this);
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate nR = nR();
        if (nR == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = nR.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.alm == null || this.alm.nQ().asBinder() != streetViewPanorama.asBinder()) {
                this.alm = new StreetViewPanorama(streetViewPanorama);
            }
            return this.alm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
        this.all.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    protected IStreetViewPanoramaFragmentDelegate nR() {
        this.all.nO();
        return this.all.je() == null ? null : ((C1569a) this.all.je()).nR();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.all.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.all.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.all.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.all.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.all.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.all.setActivity(activity);
        this.all.onInflate(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.all.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.all.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.all.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.all.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
