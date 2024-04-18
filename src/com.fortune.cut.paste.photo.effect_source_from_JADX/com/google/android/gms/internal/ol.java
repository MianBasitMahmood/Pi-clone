package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.oj.C1401a;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class ol implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.ol.c */
    private static abstract class C1404c<R extends Result> extends C0435a<R, om> {
        protected C1404c(GoogleApiClient googleApiClient) {
            super(Panorama.DQ, googleApiClient);
        }

        protected abstract void m5703a(Context context, ok okVar) throws RemoteException;

        protected final void m5705a(om omVar) throws RemoteException {
            m5703a(omVar.getContext(), (ok) omVar.hw());
        }
    }

    /* renamed from: com.google.android.gms.internal.ol.a */
    private static abstract class C1405a extends C1404c<PanoramaResult> {
        public C1405a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult ay(Status status) {
            return new on(status, null);
        }

        protected /* synthetic */ Result m5706c(Status status) {
            return ay(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ol.1 */
    class C14061 extends C1405a {
        final /* synthetic */ Uri amO;
        final /* synthetic */ ol amP;

        C14061(ol olVar, GoogleApiClient googleApiClient, Uri uri) {
            this.amP = olVar;
            this.amO = uri;
            super(googleApiClient);
        }

        protected void m5707a(Context context, ok okVar) throws RemoteException {
            okVar.m5701a(new C1409b(this), this.amO, null, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.ol.2 */
    class C14072 extends C1405a {
        final /* synthetic */ Uri amO;
        final /* synthetic */ ol amP;

        C14072(ol olVar, GoogleApiClient googleApiClient, Uri uri) {
            this.amP = olVar;
            this.amO = uri;
            super(googleApiClient);
        }

        protected void m5708a(Context context, ok okVar) throws RemoteException {
            ol.m5712a(context, okVar, new C1409b(this), this.amO, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.ol.3 */
    static class C14083 extends C1401a {
        final /* synthetic */ Uri amO;
        final /* synthetic */ oj amQ;
        final /* synthetic */ Context nf;

        C14083(Context context, Uri uri, oj ojVar) {
            this.nf = context;
            this.amO = uri;
            this.amQ = ojVar;
        }

        public final void m5709a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
            this.nf.revokeUriPermission(this.amO, 1);
            this.amQ.m5699a(i, bundle, i2, intent);
        }
    }

    /* renamed from: com.google.android.gms.internal.ol.b */
    private static final class C1409b extends C1401a {
        private final C0433b<PanoramaResult> Ea;

        public C1409b(C0433b<PanoramaResult> c0433b) {
            this.Ea = c0433b;
        }

        public final void m5710a(int i, Bundle bundle, int i2, Intent intent) {
            this.Ea.m1609b(new on(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static void m5711a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void m5712a(Context context, ok okVar, oj ojVar, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            okVar.m5701a(new C14083(context, uri, ojVar), uri, bundle, true);
        } catch (RemoteException e) {
            context.revokeUriPermission(uri, 1);
            throw e;
        } catch (RuntimeException e2) {
            context.revokeUriPermission(uri, 1);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.m1804a(new C14061(this, googleApiClient, uri));
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.m1804a(new C14072(this, googleApiClient, uri));
    }
}
