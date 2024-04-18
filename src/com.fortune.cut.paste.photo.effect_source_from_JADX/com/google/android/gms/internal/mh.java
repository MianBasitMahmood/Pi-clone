package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.C0808b;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.lu.C1295a;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lu.C1298c;
import com.google.android.gms.internal.mp.C1320a;

public class mh implements BleApi {

    /* renamed from: com.google.android.gms.internal.mh.1 */
    class C13141 extends C1298c {
        final /* synthetic */ StartBleScanRequest UW;
        final /* synthetic */ mh UX;

        C13141(mh mhVar, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
            this.UX = mhVar;
            this.UW = startBleScanRequest;
            super(googleApiClient);
        }

        protected void m5419a(lu luVar) throws RemoteException {
            luVar.jM().m5366a(this.UW, new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.2 */
    class C13152 extends C1298c {
        final /* synthetic */ mh UX;
        final /* synthetic */ BleScanCallback UY;

        C13152(mh mhVar, GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
            this.UX = mhVar;
            this.UY = bleScanCallback;
            super(googleApiClient);
        }

        protected void m5421a(lu luVar) throws RemoteException {
            md c1297b = new C1297b(this);
            String packageName = luVar.getContext().getPackageName();
            luVar.jM().m5368a(new ad(this.UY), c1297b, packageName);
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.3 */
    class C13163 extends C1298c {
        final /* synthetic */ mh UX;
        final /* synthetic */ String UZ;

        C13163(mh mhVar, GoogleApiClient googleApiClient, String str) {
            this.UX = mhVar;
            this.UZ = str;
            super(googleApiClient);
        }

        protected void m5423a(lu luVar) throws RemoteException {
            luVar.jM().m5372a(new C0808b(this.UZ), new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.4 */
    class C13174 extends C1298c {
        final /* synthetic */ mh UX;
        final /* synthetic */ BleDevice Va;

        C13174(mh mhVar, GoogleApiClient googleApiClient, BleDevice bleDevice) {
            this.UX = mhVar;
            this.Va = bleDevice;
            super(googleApiClient);
        }

        protected void m5425a(lu luVar) throws RemoteException {
            luVar.jM().m5372a(new C0808b(this.Va), new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.5 */
    class C13185 extends C1298c {
        final /* synthetic */ mh UX;
        final /* synthetic */ String UZ;

        C13185(mh mhVar, GoogleApiClient googleApiClient, String str) {
            this.UX = mhVar;
            this.UZ = str;
            super(googleApiClient);
        }

        protected void m5427a(lu luVar) throws RemoteException {
            luVar.jM().m5370a(new ah(this.UZ), new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.6 */
    class C13196 extends C1295a<BleDevicesResult> {
        final /* synthetic */ mh UX;

        C13196(mh mhVar, GoogleApiClient googleApiClient) {
            this.UX = mhVar;
            super(googleApiClient);
        }

        protected void m5429a(lu luVar) throws RemoteException {
            luVar.jM().m5382a(new C1321a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5430c(Status status) {
            return m5431v(status);
        }

        protected BleDevicesResult m5431v(Status status) {
            return BleDevicesResult.m2781C(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mh.a */
    private static class C1321a extends C1320a {
        private final C0433b<BleDevicesResult> Ea;

        private C1321a(C0433b<BleDevicesResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5433a(BleDevicesResult bleDevicesResult) {
            this.Ea.m1609b(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return googleApiClient.m1806b(new C13174(this, googleApiClient, bleDevice));
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C13163(this, googleApiClient, str));
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C13196(this, googleApiClient));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return googleApiClient.m1804a(new C13141(this, googleApiClient, startBleScanRequest));
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return googleApiClient.m1804a(new C13152(this, googleApiClient, bleScanCallback));
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C13185(this, googleApiClient, str));
    }
}
