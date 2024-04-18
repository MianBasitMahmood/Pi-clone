package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.cz.C1069a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@ey
public final class de<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C1069a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> qX;
    private final NETWORK_EXTRAS qY;

    public de(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.qX = mediationAdapter;
        this.qY = network_extras;
    }

    private SERVER_PARAMETERS m4411b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                gr.m4777d("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.qX.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public final void m4412a(C0752d c0752d, av avVar, String str, da daVar) throws RemoteException {
        m4413a(c0752d, avVar, str, null, daVar);
    }

    public final void m4413a(C0752d c0752d, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.m4769S("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).requestInterstitialAd(new df(daVar), (Activity) C0755e.m2593f(c0752d), m4411b(str, avVar.oh, str2), dg.m4419d(avVar), this.qY);
            } catch (Throwable th) {
                gr.m4777d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void m4414a(C0752d c0752d, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
        m4415a(c0752d, ayVar, avVar, str, null, daVar);
    }

    public final void m4415a(C0752d c0752d, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            gr.m4769S("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.qX).requestBannerAd(new df(daVar), (Activity) C0755e.m2593f(c0752d), m4411b(str, avVar.oh, str2), dg.m4418b(ayVar), dg.m4419d(avVar), this.qY);
            } catch (Throwable th) {
                gr.m4777d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        try {
            this.qX.destroy();
        } catch (Throwable th) {
            gr.m4777d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final C0752d getView() throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            try {
                return C0755e.m2594k(((MediationBannerAdapter) this.qX).getBannerView());
            } catch (Throwable th) {
                gr.m4777d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    public final void showInterstitial() throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.m4769S("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).showInterstitial();
            } catch (Throwable th) {
                gr.m4777d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m4773W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
