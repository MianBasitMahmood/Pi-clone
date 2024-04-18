package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ak implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.ak.1 */
    class C19221 extends C1917d<GetLocalNodeResult> {
        final /* synthetic */ ak axX;

        C19221(ak akVar, GoogleApiClient googleApiClient) {
            this.axX = akVar;
            super(googleApiClient);
        }

        protected void m6950a(ba baVar) throws RemoteException {
            baVar.m6995o(this);
        }

        protected GetLocalNodeResult aJ(Status status) {
            return new C1927c(status, null);
        }

        protected /* synthetic */ Result m6951c(Status status) {
            return aJ(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak.2 */
    class C19232 extends C1917d<GetConnectedNodesResult> {
        final /* synthetic */ ak axX;

        C19232(ak akVar, GoogleApiClient googleApiClient) {
            this.axX = akVar;
            super(googleApiClient);
        }

        protected void m6953a(ba baVar) throws RemoteException {
            baVar.m6996p(this);
        }

        protected GetConnectedNodesResult aK(Status status) {
            return new C1926b(status, null);
        }

        protected /* synthetic */ Result m6954c(Status status) {
            return aK(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak.3 */
    class C19243 extends C1917d<Status> {
        final /* synthetic */ ak axX;
        final /* synthetic */ NodeListener axY;

        C19243(ak akVar, GoogleApiClient googleApiClient, NodeListener nodeListener) {
            this.axX = akVar;
            this.axY = nodeListener;
            super(googleApiClient);
        }

        protected void m6956a(ba baVar) throws RemoteException {
            baVar.m6991b((C0433b) this, this.axY);
        }

        public Status m6957b(Status status) {
            return status;
        }

        public /* synthetic */ Result m6958c(Status status) {
            return m6957b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak.a */
    private static final class C1925a extends C1917d<Status> {
        private NodeListener axZ;

        private C1925a(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.axZ = nodeListener;
        }

        protected final void m6960a(ba baVar) throws RemoteException {
            baVar.m6986a((C0433b) this, this.axZ);
            this.axZ = null;
        }

        public final Status m6961b(Status status) {
            this.axZ = null;
            return status;
        }

        public final /* synthetic */ Result m6962c(Status status) {
            return m6961b(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak.b */
    public static class C1926b implements GetConnectedNodesResult {
        private final Status Eb;
        private final List<Node> aya;

        public C1926b(Status status, List<Node> list) {
            this.Eb = status;
            this.aya = list;
        }

        public List<Node> getNodes() {
            return this.aya;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak.c */
    public static class C1927c implements GetLocalNodeResult {
        private final Status Eb;
        private final Node ayb;

        public C1927c(Status status, Node node) {
            this.Eb = status;
            this.ayb = node;
        }

        public Node getNode() {
            return this.ayb;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, NodeListener nodeListener) {
        return googleApiClient.m1804a(new C1925a(nodeListener, null));
    }

    public final PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C19232(this, googleApiClient));
    }

    public final PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C19221(this, googleApiClient));
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, NodeListener nodeListener) {
        return googleApiClient.m1804a(new C19243(this, googleApiClient, nodeListener));
    }
}
