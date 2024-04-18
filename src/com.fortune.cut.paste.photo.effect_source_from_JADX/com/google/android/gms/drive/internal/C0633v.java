package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.v */
public class C0633v extends C0622y implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.v.d */
    static abstract class C0625d extends C0591q<DriveFileResult> {
        C0625d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m2284c(Status status) {
            return m2285r(status);
        }

        public DriveFileResult m2285r(Status status) {
            return new C0631c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.1 */
    class C06261 extends C0625d {
        final /* synthetic */ MetadataChangeSet Qi;
        final /* synthetic */ int Qj;
        final /* synthetic */ int Qk;
        final /* synthetic */ ExecutionOptions Ql;
        final /* synthetic */ C0633v Qm;

        C06261(C0633v c0633v, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
            this.Qm = c0633v;
            this.Qi = metadataChangeSet;
            this.Qj = i;
            this.Qk = i2;
            this.Ql = executionOptions;
            super(googleApiClient);
        }

        protected void m2287a(C0613r c0613r) throws RemoteException {
            this.Qi.iz().setContext(c0613r.getContext());
            c0613r.iG().m2049a(new CreateFileRequest(this.Qm.getDriveId(), this.Qi.iz(), this.Qj, this.Qk, this.Ql), new C0629a(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.f */
    static abstract class C0627f extends C0591q<DriveFolderResult> {
        C0627f(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m2288c(Status status) {
            return m2289s(status);
        }

        public DriveFolderResult m2289s(Status status) {
            return new C0632e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.2 */
    class C06282 extends C0627f {
        final /* synthetic */ MetadataChangeSet Qi;
        final /* synthetic */ C0633v Qm;

        C06282(C0633v c0633v, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.Qm = c0633v;
            this.Qi = metadataChangeSet;
            super(googleApiClient);
        }

        protected void m2291a(C0613r c0613r) throws RemoteException {
            this.Qi.iz().setContext(c0613r.getContext());
            c0613r.iG().m2050a(new CreateFolderRequest(this.Qm.getDriveId(), this.Qi.iz()), new C0630b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.a */
    private static class C0629a extends C0577c {
        private final C0433b<DriveFileResult> Ea;

        public C0629a(C0433b<DriveFileResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2292a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.m1609b(new C0631c(Status.Kw, new C0623t(onDriveIdResponse.getDriveId())));
        }

        public void m2293n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0631c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.b */
    private static class C0630b extends C0577c {
        private final C0433b<DriveFolderResult> Ea;

        public C0630b(C0433b<DriveFolderResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m2294a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.m1609b(new C0632e(Status.Kw, new C0633v(onDriveIdResponse.getDriveId())));
        }

        public void m2295n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0632e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.c */
    private static class C0631c implements DriveFileResult {
        private final Status Eb;
        private final DriveFile Qn;

        public C0631c(Status status, DriveFile driveFile) {
            this.Eb = status;
            this.Qn = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Qn;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v.e */
    private static class C0632e implements DriveFolderResult {
        private final Status Eb;
        private final DriveFolder Qo;

        public C0632e(Status status, DriveFolder driveFolder) {
            this.Eb = status;
            this.Qo = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Qo;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public C0633v(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> m2296a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.m1995a(googleApiClient, executionOptions);
        return googleApiClient.m1806b(new C06261(this, googleApiClient, metadataChangeSet, i, i2, executionOptions));
    }

    private PendingResult<DriveFileResult> m2297a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof C0618s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.ir().getRequestId();
            driveContents.is();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return m2296a(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(googleApiClient, metadataChangeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (executionOptions.ix() == 0) {
            return m2297a(googleApiClient, metadataChangeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.m1806b(new C06282(this, googleApiClient, metadataChangeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new C0607p().query(googleApiClient, addFilter.build());
    }
}
