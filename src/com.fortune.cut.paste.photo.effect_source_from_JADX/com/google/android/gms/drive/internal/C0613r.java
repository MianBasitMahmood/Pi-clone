package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0555c;
import com.google.android.gms.drive.events.C0562d;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.internal.C0591q.C0598a;
import com.google.android.gms.drive.internal.C0607p.C0606j;
import com.google.android.gms.drive.internal.ae.C0571a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0613r extends jl<ae> {
    private final String DZ;
    private final String JK;
    private final Bundle PK;
    private final boolean PL;
    private DriveId PM;
    private DriveId PN;
    final ConnectionCallbacks PO;
    final Map<DriveId, Map<C0555c, aa>> PP;

    /* renamed from: com.google.android.gms.drive.internal.r.1 */
    class C06081 extends C0598a {
        final /* synthetic */ DriveId PQ;
        final /* synthetic */ int PR;
        final /* synthetic */ aa PS;
        final /* synthetic */ C0613r PT;

        C06081(C0613r c0613r, GoogleApiClient googleApiClient, DriveId driveId, int i, aa aaVar) {
            this.PT = c0613r;
            this.PQ = driveId;
            this.PR = i;
            this.PS = aaVar;
            super(googleApiClient);
        }

        protected void m2239a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2042a(new AddEventListenerRequest(this.PQ, this.PR), this.PS, null, new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.2 */
    class C06092 extends C0598a {
        final /* synthetic */ DriveId PQ;
        final /* synthetic */ int PR;
        final /* synthetic */ C0613r PT;
        final /* synthetic */ aa PU;

        C06092(C0613r c0613r, GoogleApiClient googleApiClient, DriveId driveId, int i, aa aaVar) {
            this.PT = c0613r;
            this.PQ = driveId;
            this.PR = i;
            this.PU = aaVar;
            super(googleApiClient);
        }

        protected void m2241a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2059a(new RemoveEventListenerRequest(this.PQ, this.PR), this.PU, null, new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.3 */
    class C06103 extends C0598a {
        final /* synthetic */ DriveId PQ;
        final /* synthetic */ int PR;
        final /* synthetic */ C0613r PT;

        C06103(C0613r c0613r, GoogleApiClient googleApiClient, DriveId driveId, int i) {
            this.PT = c0613r;
            this.PQ = driveId;
            this.PR = i;
            super(googleApiClient);
        }

        protected void m2243a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2042a(new AddEventListenerRequest(this.PQ, this.PR), null, null, new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.4 */
    class C06114 extends C0598a {
        final /* synthetic */ DriveId PQ;
        final /* synthetic */ int PR;
        final /* synthetic */ C0613r PT;

        C06114(C0613r c0613r, GoogleApiClient googleApiClient, DriveId driveId, int i) {
            this.PT = c0613r;
            this.PQ = driveId;
            this.PR = i;
            super(googleApiClient);
        }

        protected void m2245a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2059a(new RemoveEventListenerRequest(this.PQ, this.PR), null, null, new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.5 */
    class C06125 extends C0598a {
        final /* synthetic */ C0613r PT;
        final /* synthetic */ List PV;

        C06125(C0613r c0613r, GoogleApiClient googleApiClient, List list) {
            this.PT = c0613r;
            this.PV = list;
            super(googleApiClient);
        }

        protected void m2247a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2044a(new CancelPendingActionsRequest(this.PV), new bg(this));
        }
    }

    public C0613r(Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.PP = new HashMap();
        this.DZ = (String) jx.m5219b(jgVar.hm(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.JK = jgVar.hq();
        this.PO = connectionCallbacks;
        this.PK = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case WalletFragmentState.UNKNOWN /*0*/:
                this.PL = false;
            case DataEvent.TYPE_CHANGED /*1*/:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.PL = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    protected ae m2263W(IBinder iBinder) {
        return C0571a.m2109X(iBinder);
    }

    PendingResult<Status> m2264a(GoogleApiClient googleApiClient, DriveId driveId, int i) {
        jx.m5221b(C0562d.m2022a(i, driveId), (Object) "id");
        jx.m5217a(isConnected(), "Client must be connected");
        if (this.PL) {
            return googleApiClient.m1806b(new C06103(this, googleApiClient, driveId, i));
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    PendingResult<Status> m2265a(GoogleApiClient googleApiClient, DriveId driveId, int i, C0555c c0555c) {
        PendingResult<Status> c0606j;
        jx.m5221b(C0562d.m2022a(i, driveId), (Object) "id");
        jx.m5219b((Object) c0555c, (Object) "listener");
        jx.m5217a(isConnected(), "Client must be connected");
        synchronized (this.PP) {
            Map map;
            aa aaVar;
            Map map2 = (Map) this.PP.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.PP.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            aa aaVar2 = (aa) map.get(c0555c);
            if (aaVar2 == null) {
                aaVar = new aa(getLooper(), getContext(), i, c0555c);
                map.put(c0555c, aaVar);
            } else if (aaVar2.bx(i)) {
                c0606j = new C0606j(googleApiClient, Status.Kw);
            } else {
                aaVar = aaVar2;
            }
            aaVar.bw(i);
            c0606j = googleApiClient.m1806b(new C06081(this, googleApiClient, driveId, i, aaVar));
        }
        return c0606j;
    }

    protected void m2266a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.PM = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.PN = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.m2258a(i, iBinder, bundle);
    }

    protected void m2267a(jt jtVar, C1250e c1250e) throws RemoteException {
        String packageName = getContext().getPackageName();
        jx.m5223i(c1250e);
        jx.m5223i(packageName);
        jx.m5223i(hv());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.JK)) {
            bundle.putString("proxy_package_name", this.JK);
        }
        bundle.putAll(this.PK);
        jtVar.m5131a((js) c1250e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, hv(), this.DZ, bundle);
    }

    PendingResult<Status> m2268b(GoogleApiClient googleApiClient, DriveId driveId, int i) {
        jx.m5221b(C0562d.m2022a(i, driveId), (Object) "id");
        jx.m5217a(isConnected(), "Client must be connected");
        return googleApiClient.m1806b(new C06114(this, googleApiClient, driveId, i));
    }

    PendingResult<Status> m2269b(GoogleApiClient googleApiClient, DriveId driveId, int i, C0555c c0555c) {
        PendingResult<Status> c0606j;
        jx.m5221b(C0562d.m2022a(i, driveId), (Object) "id");
        jx.m5217a(isConnected(), "Client must be connected");
        jx.m5219b((Object) c0555c, (Object) "listener");
        synchronized (this.PP) {
            Map map = (Map) this.PP.get(driveId);
            if (map == null) {
                c0606j = new C0606j(googleApiClient, Status.Kw);
            } else {
                aa aaVar = (aa) map.remove(c0555c);
                if (aaVar == null) {
                    c0606j = new C0606j(googleApiClient, Status.Kw);
                } else {
                    if (map.isEmpty()) {
                        this.PP.remove(driveId);
                    }
                    c0606j = googleApiClient.m1806b(new C06092(this, googleApiClient, driveId, i, aaVar));
                }
            }
        }
        return c0606j;
    }

    protected String bK() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bL() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        boolean z = true;
        jx.m5216L(list != null);
        if (list.isEmpty()) {
            z = false;
        }
        jx.m5216L(z);
        jx.m5217a(isConnected(), "Client must be connected");
        return googleApiClient.m1806b(new C06125(this, googleApiClient, list));
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((ae) hw()).m2052a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.PP.clear();
    }

    public ae iG() throws DeadObjectException {
        return (ae) hw();
    }

    public DriveId iH() {
        return this.PM;
    }

    public DriveId iI() {
        return this.PN;
    }

    public boolean iJ() {
        return this.PL;
    }

    protected /* synthetic */ IInterface m2270l(IBinder iBinder) {
        return m2263W(iBinder);
    }
}
