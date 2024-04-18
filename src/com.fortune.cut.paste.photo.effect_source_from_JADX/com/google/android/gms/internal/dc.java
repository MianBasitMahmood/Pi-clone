package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C0368a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.cz.C1069a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@ey
public final class dc extends C1069a {
    private final MediationAdapter qV;

    public dc(MediationAdapter mediationAdapter) {
        this.qV = mediationAdapter;
    }

    private Bundle m4406a(String str, int i, String str2) throws RemoteException {
        gr.m4773W("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.qV instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            gr.m4777d("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void m4407a(C0752d c0752d, av avVar, String str, da daVar) throws RemoteException {
        m4408a(c0752d, avVar, str, null, daVar);
    }

    public final void m4408a(C0752d c0752d, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qV instanceof MediationInterstitialAdapter) {
            gr.m4769S("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.qV;
                mediationInterstitialAdapter.requestInterstitialAd((Context) C0755e.m2593f(c0752d), new dd(daVar), m4406a(str, avVar.oh, str2), new db(new Date(avVar.od), avVar.oe, avVar.of != null ? new HashSet(avVar.of) : null, avVar.ol, avVar.og, avVar.oh), avVar.on != null ? avVar.on.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                gr.m4777d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void m4409a(C0752d c0752d, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
        m4410a(c0752d, ayVar, avVar, str, null, daVar);
    }

    public final void m4410a(C0752d c0752d, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        Bundle bundle = null;
        if (this.qV instanceof MediationBannerAdapter) {
            gr.m4769S("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.qV;
                db dbVar = new db(new Date(avVar.od), avVar.oe, avVar.of != null ? new HashSet(avVar.of) : null, avVar.ol, avVar.og, avVar.oh);
                if (avVar.on != null) {
                    bundle = avVar.on.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) C0755e.m2593f(c0752d), new dd(daVar), m4406a(str, avVar.oh, str2), C0368a.m1438a(ayVar.width, ayVar.height, ayVar.op), dbVar, bundle);
            } catch (Throwable th) {
                gr.m4777d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationBannerAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        try {
            this.qV.onDestroy();
        } catch (Throwable th) {
            gr.m4777d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final C0752d getView() throws RemoteException {
        if (this.qV instanceof MediationBannerAdapter) {
            try {
                return C0755e.m2594k(((MediationBannerAdapter) this.qV).getBannerView());
            } catch (Throwable th) {
                gr.m4777d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationBannerAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        try {
            this.qV.onPause();
        } catch (Throwable th) {
            gr.m4777d("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void resume() throws RemoteException {
        try {
            this.qV.onResume();
        } catch (Throwable th) {
            gr.m4777d("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.qV instanceof MediationInterstitialAdapter) {
            gr.m4769S("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qV).showInterstitial();
            } catch (Throwable th) {
                gr.m4777d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
