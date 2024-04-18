package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mw;

public final class Address {
    public static final Api<AddressOptions> API;
    static final C0490c<mw> DQ;
    private static final C0430b<mw, AddressOptions> DR;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C09901 implements C0430b<mw, AddressOptions> {
        C09901() {
        }

        public final mw m4100a(Context context, Looper looper, jg jgVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m5221b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new mw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.getAccountName(), addressOptions.theme);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.a */
    private static abstract class C0991a extends C0435a<Status, mw> {
        public C0991a(GoogleApiClient googleApiClient) {
            super(Address.DQ, googleApiClient);
        }

        public Status m4101b(Status status) {
            return status;
        }

        public /* synthetic */ Result m4102c(Status status) {
            return m4101b(status);
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C09922 extends C0991a {
        final /* synthetic */ UserAddressRequest afF;
        final /* synthetic */ int afG;

        C09922(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
            this.afF = userAddressRequest;
            this.afG = i;
            super(googleApiClient);
        }

        protected final void m4104a(mw mwVar) throws RemoteException {
            mwVar.m5527a(this.afF, this.afG);
            m1615b(Status.Kw);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int i) {
            this.theme = i;
        }
    }

    static {
        DQ = new C0490c();
        DR = new C09901();
        API = new Api(DR, DQ, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
        googleApiClient.m1804a(new C09922(googleApiClient, userAddressRequest, i));
    }
}
