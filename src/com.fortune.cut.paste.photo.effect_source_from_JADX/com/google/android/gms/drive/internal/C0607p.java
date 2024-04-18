package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.C0591q.C0598a;
import com.google.android.gms.drive.query.Query;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.p */
public class C0607p implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.p.g */
    static abstract class C0592g extends C0591q<MetadataBufferResult> {
        C0592g(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m2212c(Status status) {
            return m2213q(status);
        }

        public MetadataBufferResult m2213q(Status status) {
            return new C0603f(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.1 */
    class C05931 extends C0592g {
        final /* synthetic */ Query PE;
        final /* synthetic */ C0607p PF;

        C05931(C0607p c0607p, GoogleApiClient googleApiClient, Query query) {
            this.PF = c0607p;
            this.PE = query;
            super(googleApiClient);
        }

        protected void m2215a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2058a(new QueryRequest(this.PE), new C0605i(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.b */
    static abstract class C0594b extends C0591q<DriveContentsResult> {
        C0594b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m2216c(Status status) {
            return m2217o(status);
        }

        public DriveContentsResult m2217o(Status status) {
            return new C0600a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.2 */
    class C05952 extends C0594b {
        final /* synthetic */ C0607p PF;
        final /* synthetic */ int PG;

        C05952(C0607p c0607p, GoogleApiClient googleApiClient, int i) {
            this.PF = c0607p;
            this.PG = i;
            super(googleApiClient);
        }

        protected void m2219a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2048a(new CreateContentsRequest(this.PG), new C0604h(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.e */
    static abstract class C0596e extends C0591q<DriveIdResult> {
        C0596e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m2220c(Status status) {
            return m2221p(status);
        }

        public DriveIdResult m2221p(Status status) {
            return new C0602d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.3 */
    class C05973 extends C0596e {
        final /* synthetic */ C0607p PF;
        final /* synthetic */ String PH;

        C05973(C0607p c0607p, GoogleApiClient googleApiClient, String str) {
            this.PF = c0607p;
            this.PH = str;
            super(googleApiClient);
        }

        protected void m2223a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2054a(new GetMetadataRequest(DriveId.bi(this.PH)), new C0601c(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.4 */
    class C05994 extends C0598a {
        final /* synthetic */ C0607p PF;

        C05994(C0607p c0607p, GoogleApiClient googleApiClient) {
            this.PF = c0607p;
            super(googleApiClient);
        }

        protected void m2227a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2065a(new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.a */
    static class C0600a implements DriveContentsResult {
        private final Status Eb;
        private final DriveContents Om;

        public C0600a(Status status, DriveContents driveContents) {
            this.Eb = status;
            this.Om = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.Om;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.c */
    static class C0601c extends C0577c {
        private final C0433b<DriveIdResult> Ea;

        public C0601c(C0433b<DriveIdResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2228a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.m1609b(new C0602d(Status.Kw, onDriveIdResponse.getDriveId()));
        }

        public void m2229a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.m1609b(new C0602d(Status.Kw, new C0588m(onMetadataResponse.iU()).getDriveId()));
        }

        public void m2230n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0602d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.d */
    private static class C0602d implements DriveIdResult {
        private final Status Eb;
        private final DriveId Oj;

        public C0602d(Status status, DriveId driveId) {
            this.Eb = status;
            this.Oj = driveId;
        }

        public DriveId getDriveId() {
            return this.Oj;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.f */
    static class C0603f implements MetadataBufferResult {
        private final Status Eb;
        private final MetadataBuffer PI;
        private final boolean PJ;

        public C0603f(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.Eb = status;
            this.PI = metadataBuffer;
            this.PJ = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.PI;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.h */
    private static class C0604h extends C0577c {
        private final C0433b<DriveContentsResult> Ea;

        public C0604h(C0433b<DriveContentsResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2231a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.Ea.m1609b(new C0600a(Status.Kw, new C0618s(onContentsResponse.iL())));
        }

        public void m2232n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0600a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.i */
    private static class C0605i extends C0577c {
        private final C0433b<MetadataBufferResult> Ea;

        public C0605i(C0433b<MetadataBufferResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2233a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.Ea.m1609b(new C0603f(Status.Kw, new MetadataBuffer(onListEntriesResponse.iR(), null), onListEntriesResponse.iS()));
        }

        public void m2234n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0603f(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p.j */
    static class C0606j extends C0598a {
        C0606j(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            m1615b((Result) status);
        }

        protected void m2236a(C0613r c0613r) {
        }
    }

    public PendingResult<DriveContentsResult> m2237a(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1804a(new C05952(this, googleApiClient, i));
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        return ((C0613r) googleApiClient.m1803a(Drive.DQ)).cancelPendingActions(googleApiClient, list);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1804a(new C05973(this, googleApiClient, str));
    }

    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            DriveId iI = ((C0613r) googleApiClient.m1803a(Drive.DQ)).iI();
            return iI != null ? new C0633v(iI) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new C0623t(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new C0633v(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            return new C0633v(((C0613r) googleApiClient.m1803a(Drive.DQ)).iH());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient) {
        return m2237a(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient googleApiClient, Query query) {
        if (query != null) {
            return googleApiClient.m1804a(new C05931(this, googleApiClient, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new C05994(this, googleApiClient));
    }
}
