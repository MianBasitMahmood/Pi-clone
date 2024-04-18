package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API;
    static final C0490c<ib> DQ;
    private static final C0430b<ib, NoOptions> DR;
    public static final Scope SCOPE_APP_STATE;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C04311 implements C0430b<ib, NoOptions> {
        C04311() {
        }

        public final /* synthetic */ C0489a m1607a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1608b(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public final ib m1608b(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ib(context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.hm(), (String[]) jgVar.ho().toArray(new String[0]));
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C04322 implements StateResult {
        final /* synthetic */ Status DS;

        C04322(Status status) {
            this.DS = status;
        }

        public final StateConflictResult getConflictResult() {
            return null;
        }

        public final StateLoadedResult getLoadedResult() {
            return null;
        }

        public final Status getStatus() {
            return this.DS;
        }

        public final void release() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.a */
    public static abstract class C0436a<R extends Result> extends C0435a<R, ib> {
        public C0436a(GoogleApiClient googleApiClient) {
            super(AppStateManager.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.e */
    private static abstract class C0437e extends C0436a<StateResult> {
        public C0437e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m1626c(Status status) {
            return m1627h(status);
        }

        public StateResult m1627h(Status status) {
            return AppStateManager.m1649d(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C04383 extends C0437e {
        final /* synthetic */ int DT;
        final /* synthetic */ byte[] DU;

        C04383(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.DT = i;
            this.DU = bArr;
            super(googleApiClient);
        }

        protected final void m1629a(ib ibVar) {
            ibVar.m4941a(null, this.DT, this.DU);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C04394 extends C0437e {
        final /* synthetic */ int DT;
        final /* synthetic */ byte[] DU;

        C04394(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.DT = i;
            this.DU = bArr;
            super(googleApiClient);
        }

        protected final void m1631a(ib ibVar) {
            ibVar.m4941a(this, this.DT, this.DU);
        }
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.b */
    private static abstract class C0441b extends C0436a<StateDeletedResult> {
        C0441b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C04425 extends C0441b {
        final /* synthetic */ int DT;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C04401 implements StateDeletedResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C04425 DV;

            C04401(C04425 c04425, Status status) {
                this.DV = c04425;
                this.DS = status;
            }

            public int getStateKey() {
                return this.DV.DT;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        C04425(GoogleApiClient googleApiClient, int i) {
            this.DT = i;
            super(googleApiClient);
        }

        protected final void m1633a(ib ibVar) {
            ibVar.m4939a((C0433b) this, this.DT);
        }

        public final /* synthetic */ Result m1634c(Status status) {
            return m1635f(status);
        }

        public final StateDeletedResult m1635f(Status status) {
            return new C04401(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C04436 extends C0437e {
        final /* synthetic */ int DT;

        C04436(GoogleApiClient googleApiClient, int i) {
            this.DT = i;
            super(googleApiClient);
        }

        protected final void m1637a(ib ibVar) {
            ibVar.m4944b(this, this.DT);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.c */
    private static abstract class C0444c extends C0436a<StateListResult> {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.c.1 */
        class C04491 implements StateListResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C0444c DY;

            C04491(C0444c c0444c, Status status) {
                this.DY = c0444c;
                this.DS = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public C0444c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m1638c(Status status) {
            return m1639g(status);
        }

        public StateListResult m1639g(Status status) {
            return new C04491(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C04457 extends C0444c {
        C04457(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected final void m1641a(ib ibVar) {
            ibVar.m4938a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C04468 extends C0437e {
        final /* synthetic */ int DT;
        final /* synthetic */ String DW;
        final /* synthetic */ byte[] DX;

        C04468(GoogleApiClient googleApiClient, int i, String str, byte[] bArr) {
            this.DT = i;
            this.DW = str;
            this.DX = bArr;
            super(googleApiClient);
        }

        protected final void m1643a(ib ibVar) {
            ibVar.m4940a(this, this.DT, this.DW, this.DX);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.d */
    private static abstract class C0447d extends C0436a<Status> {
        public C0447d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m1644b(Status status) {
            return status;
        }

        public /* synthetic */ Result m1645c(Status status) {
            return m1644b(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C04489 extends C0447d {
        C04489(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected final /* synthetic */ void m1646a(C0489a c0489a) throws RemoteException {
            ((ib) c0489a).m4943b(this);
        }

        protected final void m1647a(ib ibVar) {
            ibVar.m4943b(this);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    static {
        DQ = new C0490c();
        DR = new C04311();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api(DR, DQ, SCOPE_APP_STATE);
    }

    private AppStateManager() {
    }

    public static ib m1648a(GoogleApiClient googleApiClient) {
        boolean z = true;
        jx.m5221b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m5217a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ib ibVar = (ib) googleApiClient.m1803a(DQ);
        if (ibVar == null) {
            z = false;
        }
        jx.m5217a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return ibVar;
    }

    private static StateResult m1649d(Status status) {
        return new C04322(status);
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1806b(new C04425(googleApiClient, i));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m1648a(googleApiClient).fM();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m1648a(googleApiClient).fL();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C04457(googleApiClient));
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1804a(new C04436(googleApiClient, i));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int i, String str, byte[] bArr) {
        return googleApiClient.m1806b(new C04468(googleApiClient, i, str, bArr));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new C04489(googleApiClient));
    }

    public static void update(GoogleApiClient googleApiClient, int i, byte[] bArr) {
        googleApiClient.m1806b(new C04383(googleApiClient, i, bArr));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int i, byte[] bArr) {
        return googleApiClient.m1806b(new C04394(googleApiClient, i, bArr));
    }
}
