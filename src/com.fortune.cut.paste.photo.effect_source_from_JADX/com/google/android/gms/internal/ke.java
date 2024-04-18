package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kf.C1269a;

public final class ke implements kd {

    /* renamed from: com.google.android.gms.internal.ke.1 */
    class C12701 extends C1269a {
        final /* synthetic */ ke Nv;

        C12701(ke keVar, GoogleApiClient googleApiClient) {
            this.Nv = keVar;
            super(googleApiClient);
        }

        protected void m5249a(kg kgVar) throws RemoteException {
            ((ki) kgVar.hw()).m5254a(new C1271a(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.ke.a */
    private static class C1271a extends kb {
        private final C0433b<Status> Ea;

        public C1271a(C0433b<Status> c0433b) {
            this.Ea = c0433b;
        }

        public void aI(int i) throws RemoteException {
            this.Ea.m1609b(new Status(i));
        }
    }

    public final PendingResult<Status> m5250c(GoogleApiClient googleApiClient) {
        return new C12701(this, googleApiClient).gE();
    }
}
