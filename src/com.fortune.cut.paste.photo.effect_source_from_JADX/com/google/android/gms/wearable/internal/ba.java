package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.af.C1910a;
import com.google.android.gms.wearable.internal.ag.C1913b;
import com.google.android.gms.wearable.internal.ag.C1914c;
import com.google.android.gms.wearable.internal.ag.C1915d;
import com.google.android.gms.wearable.internal.az.C1928b;
import com.google.android.gms.wearable.internal.az.C1929c;
import com.google.android.gms.wearable.internal.az.C1930d;
import com.google.android.gms.wearable.internal.az.C1931e;
import com.google.android.gms.wearable.internal.az.C1932f;
import com.google.android.gms.wearable.internal.az.C1933g;
import com.google.android.gms.wearable.internal.az.C1935i;
import com.google.android.gms.wearable.internal.az.C1936j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ba extends jl<af> {
    private final ExecutorService asJ;
    private final ag<DataListener> ayg;
    private final ag<MessageListener> ayh;
    private final ag<NodeListener> ayi;

    /* renamed from: com.google.android.gms.wearable.internal.ba.1 */
    class C19381 implements Callable<Boolean> {
        final /* synthetic */ byte[] DU;
        final /* synthetic */ ParcelFileDescriptor ayj;
        final /* synthetic */ ba ayk;

        C19381(ba baVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.ayk = baVar;
            this.ayj = parcelFileDescriptor;
            this.DU = bArr;
        }

        public /* synthetic */ Object call() throws Exception {
            return rr();
        }

        public java.lang.Boolean rr() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00ab in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r5 = this;
            r1 = 3;
            r0 = "WearableClient";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x001f;
        L_0x0009:
            r0 = "WearableClient";
            r1 = new java.lang.StringBuilder;
            r2 = "processAssets: writing data to FD : ";
            r1.<init>(r2);
            r2 = r5.ayj;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x001f:
            r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
            r0 = r5.ayj;
            r1.<init>(r0);
            r0 = r5.DU;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r1.write(r0);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r1.flush();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = 3;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            if (r0 == 0) goto L_0x004d;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
        L_0x0037:
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r3 = r5.ayj;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
        L_0x004d:
            r0 = 1;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00dc }
            r3 = 3;	 Catch:{ IOException -> 0x00dc }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00dc }
            if (r2 == 0) goto L_0x0071;	 Catch:{ IOException -> 0x00dc }
        L_0x005b:
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00dc }
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00dc }
            r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00dc }
            r3.<init>(r4);	 Catch:{ IOException -> 0x00dc }
            r4 = r5.ayj;	 Catch:{ IOException -> 0x00dc }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00dc }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00dc }
            android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00dc }
        L_0x0071:
            r1.close();	 Catch:{ IOException -> 0x00dc }
        L_0x0074:
            return r0;
        L_0x0075:
            r0 = move-exception;
            r0 = "WearableClient";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r3 = r5.ayj;	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = r2.append(r3);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r2 = r2.toString();	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0075, all -> 0x00b4 }
            r0 = "WearableClient";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x00ab;
        L_0x0095:
            r0 = "WearableClient";
            r2 = new java.lang.StringBuilder;
            r3 = "processAssets: closing: ";
            r2.<init>(r3);
            r3 = r5.ayj;
            r2 = r2.append(r3);
            r2 = r2.toString();
            android.util.Log.d(r0, r2);
        L_0x00ab:
            r1.close();
        L_0x00ae:
            r0 = 0;
            r0 = java.lang.Boolean.valueOf(r0);
            goto L_0x0074;
        L_0x00b4:
            r0 = move-exception;
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00d8 }
            r3 = 3;	 Catch:{ IOException -> 0x00d8 }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00d8 }
            if (r2 == 0) goto L_0x00d4;	 Catch:{ IOException -> 0x00d8 }
        L_0x00be:
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00d8 }
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00d8 }
            r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00d8 }
            r3.<init>(r4);	 Catch:{ IOException -> 0x00d8 }
            r4 = r5.ayj;	 Catch:{ IOException -> 0x00d8 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00d8 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00d8 }
            android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00d8 }
        L_0x00d4:
            r1.close();	 Catch:{ IOException -> 0x00d8 }
        L_0x00d7:
            throw r0;
        L_0x00d8:
            r1 = move-exception;
            goto L_0x00d7;
        L_0x00da:
            r0 = move-exception;
            goto L_0x00ae;
        L_0x00dc:
            r1 = move-exception;
            goto L_0x0074;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ba.1.rr():java.lang.Boolean");
        }
    }

    public ba(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.asJ = Executors.newCachedThreadPool();
        this.ayg = new C1913b();
        this.ayh = new C1914c();
        this.ayi = new C1915d();
    }

    private FutureTask<Boolean> m6977a(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        return new FutureTask(new C19381(this, parcelFileDescriptor, bArr));
    }

    protected void m6978a(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.ayg.ca(iBinder);
            this.ayh.ca(iBinder);
            this.ayi.ca(iBinder);
        }
        super.m2258a(i, iBinder, bundle);
    }

    public void m6979a(C0433b<DataItemResult> c0433b, Uri uri) throws RemoteException {
        ((af) hw()).m6876a(new C1930d(c0433b), uri);
    }

    public void m6980a(C0433b<GetFdForAssetResult> c0433b, Asset asset) throws RemoteException {
        ((af) hw()).m6877a(new C1932f(c0433b), asset);
    }

    public void m6981a(C0433b<Status> c0433b, DataListener dataListener) throws RemoteException {
        this.ayg.m6926a(this, c0433b, dataListener);
    }

    public void m6982a(C0433b<Status> c0433b, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayg.m6927a(this, c0433b, dataListener, intentFilterArr);
    }

    public void m6983a(C0433b<GetFdForAssetResult> c0433b, DataItemAsset dataItemAsset) throws RemoteException {
        m6980a((C0433b) c0433b, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void m6984a(C0433b<Status> c0433b, MessageListener messageListener) throws RemoteException {
        this.ayh.m6926a(this, c0433b, messageListener);
    }

    public void m6985a(C0433b<Status> c0433b, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayh.m6927a(this, c0433b, messageListener, intentFilterArr);
    }

    public void m6986a(C0433b<Status> c0433b, NodeListener nodeListener) throws RemoteException, RemoteException {
        this.ayi.m6927a(this, c0433b, nodeListener, null);
    }

    public void m6987a(C0433b<DataItemResult> c0433b, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest k = PutDataRequest.m6820k(putDataRequest.getUri());
        k.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                k.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    k.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable a = m6977a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.asJ.submit(a);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((af) hw()).m6878a(new C1935i(c0433b, arrayList), k);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    public void m6988a(C0433b<SendMessageResult> c0433b, String str, String str2, byte[] bArr) throws RemoteException {
        ((af) hw()).m6883a(new C1936j(c0433b), str, str2, bArr);
    }

    protected void m6989a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5140e(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public void m6990b(C0433b<DataItemBuffer> c0433b, Uri uri) throws RemoteException {
        ((af) hw()).m6885b(new C1931e(c0433b), uri);
    }

    public void m6991b(C0433b<Status> c0433b, NodeListener nodeListener) throws RemoteException {
        this.ayi.m6926a(this, c0433b, nodeListener);
    }

    protected String bK() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void m6992c(C0433b<DeleteDataItemsResult> c0433b, Uri uri) throws RemoteException {
        ((af) hw()).m6889c(new C1928b(c0433b), uri);
    }

    protected af cb(IBinder iBinder) {
        return C1910a.bZ(iBinder);
    }

    public void disconnect() {
        this.ayg.m6928b(this);
        this.ayh.m6928b(this);
        this.ayi.m6928b(this);
        super.disconnect();
    }

    protected /* synthetic */ IInterface m6993l(IBinder iBinder) {
        return cb(iBinder);
    }

    public void m6994n(C0433b<DataItemBuffer> c0433b) throws RemoteException {
        ((af) hw()).m6884b(new C1931e(c0433b));
    }

    public void m6995o(C0433b<GetLocalNodeResult> c0433b) throws RemoteException {
        ((af) hw()).m6888c(new C1933g(c0433b));
    }

    public void m6996p(C0433b<GetConnectedNodesResult> c0433b) throws RemoteException {
        ((af) hw()).m6891d(new C1929c(c0433b));
    }
}
