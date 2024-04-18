package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class hz implements AppIndexApi, ht {

    /* renamed from: com.google.android.gms.internal.hz.b */
    private static abstract class C1195b<T extends Result> extends C0435a<T, hx> {
        public C1195b(GoogleApiClient googleApiClient) {
            super(hc.CG, googleApiClient);
        }

        protected abstract void m4900a(hu huVar) throws RemoteException;

        protected final void m4901a(hx hxVar) throws RemoteException {
            m4900a(hxVar.fH());
        }
    }

    /* renamed from: com.google.android.gms.internal.hz.c */
    private static abstract class C1196c<T extends Result> extends C1195b<Status> {
        C1196c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status m4902b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m4903c(Status status) {
            return m4902b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.hz.1 */
    class C11971 extends C1196c<Status> {
        final /* synthetic */ String DB;
        final /* synthetic */ hr[] DC;
        final /* synthetic */ hz DD;

        C11971(hz hzVar, GoogleApiClient googleApiClient, String str, hr[] hrVarArr) {
            this.DD = hzVar;
            this.DB = str;
            this.DC = hrVarArr;
            super(googleApiClient);
        }

        protected void m4904a(hu huVar) throws RemoteException {
            huVar.m4871a(new C1199d(this), this.DB, this.DC);
        }
    }

    /* renamed from: com.google.android.gms.internal.hz.a */
    private static final class C1198a implements ActionResult {
        private hz DE;
        private PendingResult<Status> DF;
        private Action DG;
        private String DH;

        C1198a(hz hzVar, PendingResult<Status> pendingResult, Action action, String str) {
            this.DE = hzVar;
            this.DF = pendingResult;
            this.DG = action;
            this.DH = str;
        }

        public final PendingResult<Status> end(GoogleApiClient googleApiClient) {
            String packageName = ((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName();
            hr a = hy.m4897a(this.DG, this.DH, System.currentTimeMillis(), packageName, 3);
            return this.DE.m4909a(googleApiClient, a);
        }

        public final PendingResult<Status> getPendingResult() {
            return this.DF;
        }
    }

    /* renamed from: com.google.android.gms.internal.hz.d */
    private static final class C1199d extends hw<Status> {
        public C1199d(C0433b<Status> c0433b) {
            super(c0433b);
        }

        public final void m4905a(Status status) {
            this.DA.m1609b(status);
        }
    }

    public static Intent m4906a(String str, Uri uri) {
        m4907b(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private static void m4907b(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void m4908c(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                m4907b(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public final PendingResult<Status> m4909a(GoogleApiClient googleApiClient, hr... hrVarArr) {
        return googleApiClient.m1804a(new C11971(this, googleApiClient, ((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName(), hrVarArr));
    }

    public final ActionResult action(GoogleApiClient googleApiClient, Action action) {
        String packageName = ((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName();
        return new C1198a(this, m4909a(googleApiClient, hy.m4897a(action, String.valueOf(System.currentTimeMillis()), r2, packageName, 0)), action, String.valueOf(System.currentTimeMillis()));
    }

    public final PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list) {
        String packageName = ((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName();
        m4908c(list);
        return m4909a(googleApiClient, new hr(packageName, intent, str, uri, null, (List) list));
    }

    public final PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list) {
        String packageName = ((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName();
        m4907b(packageName, uri);
        return view(googleApiClient, activity, m4906a(packageName, uri), str, uri2, (List) list);
    }

    public final PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        hr hrVar = new hr(hr.m4860a(((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName(), intent), System.currentTimeMillis(), 3);
        return m4909a(googleApiClient, hrVar);
    }

    public final PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, m4906a(((hx) googleApiClient.m1803a(hc.CG)).getContext().getPackageName(), uri));
    }
}
