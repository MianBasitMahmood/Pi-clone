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
import com.google.android.gms.maps.internal.C1566u.C1567a;
import com.google.android.gms.maps.internal.C1631x;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama alm;
    private final C1573b aly;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a */
    static class C1572a implements StreetViewLifecycleDelegate {
        private final ViewGroup akZ;
        private View alA;
        private final IStreetViewPanoramaViewDelegate alz;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a.1 */
        class C15711 extends C1567a {
            final /* synthetic */ C1572a alB;
            final /* synthetic */ OnStreetViewPanoramaReadyCallback alo;

            C15711(C1572a c1572a, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.alB = c1572a;
                this.alo = onStreetViewPanoramaReadyCallback;
            }

            public void m6129a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                this.alo.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public C1572a(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.alz = (IStreetViewPanoramaViewDelegate) jx.m5223i(iStreetViewPanoramaViewDelegate);
            this.akZ = (ViewGroup) jx.m5223i(viewGroup);
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.alz.getStreetViewPanoramaAsync(new C15711(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IStreetViewPanoramaViewDelegate nV() {
            return this.alz;
        }

        public void onCreate(Bundle bundle) {
            try {
                this.alz.onCreate(bundle);
                this.alA = (View) C0755e.m2593f(this.alz.getView());
                this.akZ.removeAllViews();
                this.akZ.addView(this.alA);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.alz.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.alz.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.alz.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.alz.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.alz.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.b */
    static class C1573b extends C0747a<C1572a> {
        protected C0738f<C1572a> akW;
        private final StreetViewPanoramaOptions alC;
        private final ViewGroup ald;
        private final List<OnStreetViewPanoramaReadyCallback> alq;
        private final Context mContext;

        C1573b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.alq = new ArrayList();
            this.ald = viewGroup;
            this.mContext = context;
            this.alC = streetViewPanoramaOptions;
        }

        protected void m6130a(C0738f<C1572a> c0738f) {
            this.akW = c0738f;
            nO();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (je() != null) {
                ((C1572a) je()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.alq.add(onStreetViewPanoramaReadyCallback);
            }
        }

        public void nO() {
            if (this.akW != null && je() == null) {
                try {
                    this.akW.m2570a(new C1572a(this.ald, C1631x.m6174S(this.mContext).m6143a(C0755e.m2594k(this.mContext), this.alC)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.alq) {
                        ((C1572a) je()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.alq.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.aly = new C1573b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aly = new C1573b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aly = new C1573b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.aly = new C1573b(this, context, streetViewPanoramaOptions);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.alm != null) {
            return this.alm;
        }
        this.aly.nO();
        if (this.aly.je() == null) {
            return null;
        }
        try {
            this.alm = new StreetViewPanorama(((C1572a) this.aly.je()).nV().getStreetViewPanorama());
            return this.alm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
        this.aly.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.aly.onCreate(bundle);
        if (this.aly.je() == null) {
            C0747a.m2583b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.aly.onDestroy();
    }

    public final void onLowMemory() {
        this.aly.onLowMemory();
    }

    public final void onPause() {
        this.aly.onPause();
    }

    public final void onResume() {
        this.aly.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.aly.onSaveInstanceState(bundle);
    }
}
