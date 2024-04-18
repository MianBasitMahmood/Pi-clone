package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.C0495b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.id.C1212a;
import com.google.android.gms.internal.jl.C1250e;

public final class ib extends jl<id> {
    private final String DZ;

    /* renamed from: com.google.android.gms.internal.ib.a */
    private static final class C1203a extends ia {
        private final C0433b<StateDeletedResult> Ea;

        public C1203a(C0433b<StateDeletedResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Result holder must not be null");
        }

        public final void m4934e(int i, int i2) {
            this.Ea.m1609b(new C1204b(new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.b */
    private static final class C1204b implements StateDeletedResult {
        private final Status Eb;
        private final int Ec;

        public C1204b(Status status, int i) {
            this.Eb = status;
            this.Ec = i;
        }

        public final int getStateKey() {
            return this.Ec;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.c */
    private static final class C1205c extends ia {
        private final C0433b<StateListResult> Ea;

        public C1205c(C0433b<StateListResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Result holder must not be null");
        }

        public final void m4935a(DataHolder dataHolder) {
            this.Ea.m1609b(new C1206d(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.d */
    private static final class C1206d extends C0495b implements StateListResult {
        private final AppStateBuffer Ed;

        public C1206d(DataHolder dataHolder) {
            super(dataHolder);
            this.Ed = new AppStateBuffer(dataHolder);
        }

        public final AppStateBuffer getStateBuffer() {
            return this.Ed;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.e */
    private static final class C1207e extends ia {
        private final C0433b<StateResult> Ea;

        public C1207e(C0433b<StateResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Result holder must not be null");
        }

        public final void m4936a(int i, DataHolder dataHolder) {
            this.Ea.m1609b(new C1208f(i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.f */
    private static final class C1208f extends C0495b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int Ec;
        private final AppStateBuffer Ed;

        public C1208f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.Ec = i;
            this.Ed = new AppStateBuffer(dataHolder);
        }

        private boolean fN() {
            return this.Eb.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public final StateConflictResult getConflictResult() {
            return fN() ? this : null;
        }

        public final StateLoadedResult getLoadedResult() {
            return fN() ? null : this;
        }

        public final byte[] getLocalData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getLocalData();
        }

        public final String getResolvedVersion() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictVersion();
        }

        public final byte[] getServerData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictData();
        }

        public final int getStateKey() {
            return this.Ec;
        }

        public final void release() {
            this.Ed.release();
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.g */
    private static final class C1209g extends ia {
        private final C0433b<Status> Ea;

        public C1209g(C0433b<Status> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void fK() {
            this.Ea.m1609b(new Status(0));
        }
    }

    public ib(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = (String) jx.m5223i(str);
    }

    protected final id m4937H(IBinder iBinder) {
        return C1212a.m4965J(iBinder);
    }

    public final void m4938a(C0433b<StateListResult> c0433b) {
        try {
            ((id) hw()).m4951a(new C1205c(c0433b));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void m4939a(C0433b<StateDeletedResult> c0433b, int i) {
        try {
            ((id) hw()).m4956b(new C1203a(c0433b), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void m4940a(C0433b<StateResult> c0433b, int i, String str, byte[] bArr) {
        try {
            ((id) hw()).m4953a(new C1207e(c0433b), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void m4941a(C0433b<StateResult> c0433b, int i, byte[] bArr) {
        if (c0433b == null) {
            ic icVar = null;
        } else {
            Object c1207e = new C1207e(c0433b);
        }
        try {
            ((id) hw()).m4954a(icVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected final void m4942a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5127a((js) c1250e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv());
    }

    public final void m4943b(C0433b<Status> c0433b) {
        try {
            ((id) hw()).m4955b(new C1209g(c0433b));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void m4944b(C0433b<StateResult> c0433b, int i) {
        try {
            ((id) hw()).m4952a(new C1207e(c0433b), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected final String bK() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected final String bL() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected final void m4945c(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        jx.m5217a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    public final int fL() {
        try {
            return ((id) hw()).fL();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public final int fM() {
        try {
            return ((id) hw()).fM();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected final /* synthetic */ IInterface m4946l(IBinder iBinder) {
        return m4937H(iBinder);
    }
}
