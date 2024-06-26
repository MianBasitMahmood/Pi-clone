package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.cy.C1066a;
import java.util.Map;

@ey
public final class cx extends C1066a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> qT;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> cz m4385z(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, cx.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new de(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.qT.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new dc((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                gr.m4773W("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            gr.m4773W("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void m4386d(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.qT = map;
    }

    public final cz m4387x(String str) throws RemoteException {
        return m4385z(str);
    }

    public final boolean m4388y(String str) throws RemoteException {
        boolean z = false;
        try {
            z = CustomEvent.class.isAssignableFrom(Class.forName(str, false, cx.class.getClassLoader()));
        } catch (Throwable th) {
            gr.m4773W("Could not load custom event implementation class: " + str + ", assuming old implementation.");
        }
        return z;
    }
}
