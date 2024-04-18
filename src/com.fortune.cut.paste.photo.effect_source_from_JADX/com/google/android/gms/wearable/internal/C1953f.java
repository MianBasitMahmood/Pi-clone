package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.wearable.internal.f */
public final class C1953f implements DataApi {

    /* renamed from: com.google.android.gms.wearable.internal.f.1 */
    class C19411 extends C1917d<DataItemResult> {
        final /* synthetic */ PutDataRequest axx;
        final /* synthetic */ C1953f axy;

        C19411(C1953f c1953f, GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
            this.axy = c1953f;
            this.axx = putDataRequest;
            super(googleApiClient);
        }

        protected void m7005a(ba baVar) throws RemoteException {
            baVar.m6987a((C0433b) this, this.axx);
        }

        public DataItemResult aE(Status status) {
            return new C1950b(status, null);
        }

        public /* synthetic */ Result m7006c(Status status) {
            return aE(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.2 */
    class C19422 extends C1917d<DataItemResult> {
        final /* synthetic */ Uri amO;
        final /* synthetic */ C1953f axy;

        C19422(C1953f c1953f, GoogleApiClient googleApiClient, Uri uri) {
            this.axy = c1953f;
            this.amO = uri;
            super(googleApiClient);
        }

        protected void m7008a(ba baVar) throws RemoteException {
            baVar.m6979a((C0433b) this, this.amO);
        }

        protected DataItemResult aE(Status status) {
            return new C1950b(status, null);
        }

        protected /* synthetic */ Result m7009c(Status status) {
            return aE(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.3 */
    class C19433 extends C1917d<DataItemBuffer> {
        final /* synthetic */ C1953f axy;

        C19433(C1953f c1953f, GoogleApiClient googleApiClient) {
            this.axy = c1953f;
            super(googleApiClient);
        }

        protected void m7011a(ba baVar) throws RemoteException {
            baVar.m6994n(this);
        }

        protected DataItemBuffer aF(Status status) {
            return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
        }

        protected /* synthetic */ Result m7012c(Status status) {
            return aF(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.4 */
    class C19444 extends C1917d<DataItemBuffer> {
        final /* synthetic */ Uri amO;
        final /* synthetic */ C1953f axy;

        C19444(C1953f c1953f, GoogleApiClient googleApiClient, Uri uri) {
            this.axy = c1953f;
            this.amO = uri;
            super(googleApiClient);
        }

        protected void m7014a(ba baVar) throws RemoteException {
            baVar.m6990b((C0433b) this, this.amO);
        }

        protected DataItemBuffer aF(Status status) {
            return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
        }

        protected /* synthetic */ Result m7015c(Status status) {
            return aF(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.5 */
    class C19455 extends C1917d<DeleteDataItemsResult> {
        final /* synthetic */ Uri amO;
        final /* synthetic */ C1953f axy;

        C19455(C1953f c1953f, GoogleApiClient googleApiClient, Uri uri) {
            this.axy = c1953f;
            this.amO = uri;
            super(googleApiClient);
        }

        protected void m7017a(ba baVar) throws RemoteException {
            baVar.m6992c(this, this.amO);
        }

        protected DeleteDataItemsResult aG(Status status) {
            return new C1951c(status, 0);
        }

        protected /* synthetic */ Result m7018c(Status status) {
            return aG(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.6 */
    class C19466 extends C1917d<GetFdForAssetResult> {
        final /* synthetic */ C1953f axy;
        final /* synthetic */ Asset axz;

        C19466(C1953f c1953f, GoogleApiClient googleApiClient, Asset asset) {
            this.axy = c1953f;
            this.axz = asset;
            super(googleApiClient);
        }

        protected void m7020a(ba baVar) throws RemoteException {
            baVar.m6980a((C0433b) this, this.axz);
        }

        protected GetFdForAssetResult aH(Status status) {
            return new C1952d(status, null);
        }

        protected /* synthetic */ Result m7021c(Status status) {
            return aH(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.7 */
    class C19477 extends C1917d<GetFdForAssetResult> {
        final /* synthetic */ DataItemAsset axA;
        final /* synthetic */ C1953f axy;

        C19477(C1953f c1953f, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
            this.axy = c1953f;
            this.axA = dataItemAsset;
            super(googleApiClient);
        }

        protected void m7023a(ba baVar) throws RemoteException {
            baVar.m6983a((C0433b) this, this.axA);
        }

        protected GetFdForAssetResult aH(Status status) {
            return new C1952d(status, null);
        }

        protected /* synthetic */ Result m7024c(Status status) {
            return aH(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.8 */
    class C19488 extends C1917d<Status> {
        final /* synthetic */ DataListener axB;
        final /* synthetic */ C1953f axy;

        C19488(C1953f c1953f, GoogleApiClient googleApiClient, DataListener dataListener) {
            this.axy = c1953f;
            this.axB = dataListener;
            super(googleApiClient);
        }

        protected void m7026a(ba baVar) throws RemoteException {
            baVar.m6981a((C0433b) this, this.axB);
        }

        public Status m7027b(Status status) {
            return status;
        }

        public /* synthetic */ Result m7028c(Status status) {
            return m7027b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.a */
    private static final class C1949a extends C1917d<Status> {
        private DataListener axC;
        private IntentFilter[] axD;

        private C1949a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axC = dataListener;
            this.axD = intentFilterArr;
        }

        protected final void m7030a(ba baVar) throws RemoteException {
            baVar.m6982a((C0433b) this, this.axC, this.axD);
            this.axC = null;
            this.axD = null;
        }

        public final Status m7031b(Status status) {
            this.axC = null;
            this.axD = null;
            return status;
        }

        public final /* synthetic */ Result m7032c(Status status) {
            return m7031b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.b */
    public static class C1950b implements DataItemResult {
        private final Status Eb;
        private final DataItem axE;

        public C1950b(Status status, DataItem dataItem) {
            this.Eb = status;
            this.axE = dataItem;
        }

        public DataItem getDataItem() {
            return this.axE;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.c */
    public static class C1951c implements DeleteDataItemsResult {
        private final Status Eb;
        private final int axF;

        public C1951c(Status status, int i) {
            this.Eb = status;
            this.axF = i;
        }

        public int getNumDeleted() {
            return this.axF;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f.d */
    public static class C1952d implements GetFdForAssetResult {
        private final Status Eb;
        private volatile InputStream ZO;
        private volatile ParcelFileDescriptor axG;
        private volatile boolean mClosed;

        public C1952d(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.mClosed = false;
            this.Eb = status;
            this.axG = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.axG;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.axG == null) {
                return null;
            } else {
                if (this.ZO == null) {
                    this.ZO = new AutoCloseInputStream(this.axG);
                }
                return this.ZO;
            }
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            if (this.axG != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.ZO != null) {
                        this.ZO.close();
                    } else {
                        this.axG.close();
                    }
                    this.mClosed = true;
                    this.axG = null;
                    this.ZO = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> m7033a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.m1804a(new C1949a(dataListener, intentFilterArr, null));
    }

    private void m7034a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener) {
        return m7033a(googleApiClient, dataListener, null);
    }

    public final PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.m1804a(new C19455(this, googleApiClient, uri));
    }

    public final PendingResult<DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.m1804a(new C19422(this, googleApiClient, uri));
    }

    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C19433(this, googleApiClient));
    }

    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.m1804a(new C19444(this, googleApiClient, uri));
    }

    public final PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset) {
        m7034a(asset);
        return googleApiClient.m1804a(new C19466(this, googleApiClient, asset));
    }

    public final PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        return googleApiClient.m1804a(new C19477(this, googleApiClient, dataItemAsset));
    }

    public final PendingResult<DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        return googleApiClient.m1804a(new C19411(this, googleApiClient, putDataRequest));
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataListener dataListener) {
        return googleApiClient.m1804a(new C19488(this, googleApiClient, dataListener));
    }
}
