package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.C0591q.C0598a;
import com.google.android.gms.drive.internal.C0607p.C0592g;
import com.google.android.gms.drive.internal.C0607p.C0603f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.internal.y */
public class C0622y implements DriveResource {
    protected final DriveId Oj;

    /* renamed from: com.google.android.gms.drive.internal.y.d */
    private abstract class C0641d extends C0591q<MetadataResult> {
        final /* synthetic */ C0622y Qt;

        private C0641d(C0622y c0622y, GoogleApiClient googleApiClient) {
            this.Qt = c0622y;
            super(googleApiClient);
        }

        public /* synthetic */ Result m2311c(Status status) {
            return m2312u(status);
        }

        public MetadataResult m2312u(Status status) {
            return new C0648c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.1 */
    class C06421 extends C0641d {
        final /* synthetic */ C0622y Qt;

        C06421(C0622y c0622y, GoogleApiClient googleApiClient) {
            this.Qt = c0622y;
            super(googleApiClient, null);
        }

        protected void m2314a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2054a(new GetMetadataRequest(this.Qt.Oj), new C0647b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.2 */
    class C06432 extends C0592g {
        final /* synthetic */ C0622y Qt;

        C06432(C0622y c0622y, GoogleApiClient googleApiClient) {
            this.Qt = c0622y;
            super(googleApiClient);
        }

        protected void m2316a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2055a(new ListParentsRequest(this.Qt.Oj), new C0646a(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.3 */
    class C06443 extends C0598a {
        final /* synthetic */ C0622y Qt;
        final /* synthetic */ List Qu;

        C06443(C0622y c0622y, GoogleApiClient googleApiClient, List list) {
            this.Qt = c0622y;
            this.Qu = list;
            super(googleApiClient);
        }

        protected void m2318a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2062a(new SetResourceParentsRequest(this.Qt.Oj, this.Qu), new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.4 */
    class C06454 extends C0641d {
        final /* synthetic */ MetadataChangeSet Qi;
        final /* synthetic */ C0622y Qt;

        C06454(C0622y c0622y, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.Qt = c0622y;
            this.Qi = metadataChangeSet;
            super(googleApiClient, null);
        }

        protected void m2320a(C0613r c0613r) throws RemoteException {
            this.Qi.iz().setContext(c0613r.getContext());
            c0613r.iG().m2064a(new UpdateMetadataRequest(this.Qt.Oj, this.Qi.iz()), new C0647b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.a */
    private static class C0646a extends C0577c {
        private final C0433b<MetadataBufferResult> Ea;

        public C0646a(C0433b<MetadataBufferResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2321a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.Ea.m1609b(new C0603f(Status.Kw, new MetadataBuffer(onListParentsResponse.iT(), null), false));
        }

        public void m2322n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0603f(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.b */
    private static class C0647b extends C0577c {
        private final C0433b<MetadataResult> Ea;

        public C0647b(C0433b<MetadataResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2323a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.m1609b(new C0648c(Status.Kw, new C0588m(onMetadataResponse.iU())));
        }

        public void m2324n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0648c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y.c */
    private static class C0648c implements MetadataResult {
        private final Status Eb;
        private final Metadata Qv;

        public C0648c(Status status, Metadata metadata) {
            this.Eb = status;
            this.Qv = metadata;
        }

        public Metadata getMetadata() {
            return this.Qv;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    protected C0622y(DriveId driveId) {
        this.Oj = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((C0613r) googleApiClient.m1803a(Drive.DQ)).m2265a(googleApiClient, this.Oj, 1, changeListener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((C0613r) googleApiClient.m1803a(Drive.DQ)).m2264a(googleApiClient, this.Oj, 1);
    }

    public DriveId getDriveId() {
        return this.Oj;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C06421(this, googleApiClient));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C06432(this, googleApiClient));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((C0613r) googleApiClient.m1803a(Drive.DQ)).m2269b(googleApiClient, this.Oj, 1, changeListener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((C0613r) googleApiClient.m1803a(Drive.DQ)).m2268b(googleApiClient, this.Oj, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (!set.isEmpty()) {
            return googleApiClient.m1806b(new C06443(this, googleApiClient, new ArrayList(set)));
        } else {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        }
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.m1806b(new C06454(this, googleApiClient, metadataChangeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
