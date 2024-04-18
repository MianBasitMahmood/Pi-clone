package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0591q.C0598a;
import com.google.android.gms.drive.internal.C0607p.C0594b;
import com.google.android.gms.internal.jx;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0618s implements DriveContents {
    private final Contents PW;
    private boolean PX;
    private boolean PY;
    private boolean mClosed;

    /* renamed from: com.google.android.gms.drive.internal.s.1 */
    class C06141 extends C0594b {
        final /* synthetic */ C0618s PZ;

        C06141(C0618s c0618s, GoogleApiClient googleApiClient) {
            this.PZ = c0618s;
            super(googleApiClient);
        }

        protected void m2272a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2057a(new OpenContentsRequest(this.PZ.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.PZ.PW.getRequestId()), new az(this, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.2 */
    class C06152 extends C0598a {
        final /* synthetic */ C0618s PZ;
        final /* synthetic */ MetadataChangeSet Qa;
        final /* synthetic */ ExecutionOptions Qb;

        C06152(C0618s c0618s, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
            this.PZ = c0618s;
            this.Qa = metadataChangeSet;
            this.Qb = executionOptions;
            super(googleApiClient);
        }

        protected void m2274a(C0613r c0613r) throws RemoteException {
            this.Qa.iz().setContext(c0613r.getContext());
            c0613r.iG().m2046a(new CloseContentsAndUpdateMetadataRequest(this.PZ.PW.getDriveId(), this.Qa.iz(), this.PZ.PW, this.Qb), new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.3 */
    class C06163 implements ResultCallback<Status> {
        final /* synthetic */ C0618s PZ;

        C06163(C0618s c0618s) {
            this.PZ = c0618s;
        }

        public void m2275j(Status status) {
            if (status.isSuccess()) {
                C0634w.m2300m("DriveContentsImpl", "Contents discarded");
            } else {
                C0634w.m2302p("DriveContentsImpl", "Error discarding contents");
            }
        }

        public /* synthetic */ void onResult(Result result) {
            m2275j((Status) result);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.s.4 */
    class C06174 extends C0598a {
        final /* synthetic */ C0618s PZ;

        C06174(C0618s c0618s, GoogleApiClient googleApiClient) {
            this.PZ = c0618s;
            super(googleApiClient);
        }

        protected void m2277a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2047a(new CloseContentsRequest(this.PZ.PW, false), new bg(this));
        }
    }

    public C0618s(Contents contents) {
        this.mClosed = false;
        this.PX = false;
        this.PY = false;
        this.PW = (Contents) jx.m5223i(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return commit(googleApiClient, metadataChangeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.PW.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.ba(executionOptions.ix()) || this.PW.ip()) {
            ExecutionOptions.m1995a(googleApiClient, executionOptions);
            if (it()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.OE;
                }
                is();
                return googleApiClient.m1806b(new C06152(this, googleApiClient, metadataChangeSet, executionOptions));
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient googleApiClient) {
        if (it()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        is();
        ((C06174) googleApiClient.m1806b(new C06174(this, googleApiClient))).setResultCallback(new C06163(this));
    }

    public DriveId getDriveId() {
        return this.PW.getDriveId();
    }

    public InputStream getInputStream() {
        if (it()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.PW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.PX) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.PX = true;
            return this.PW.getInputStream();
        }
    }

    public int getMode() {
        return this.PW.getMode();
    }

    public OutputStream getOutputStream() {
        if (it()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.PW.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.PY) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.PY = true;
            return this.PW.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!it()) {
            return this.PW.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public Contents ir() {
        return this.PW;
    }

    public void is() {
        this.mClosed = true;
    }

    public boolean it() {
        return this.mClosed;
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (it()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.PW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            is();
            return googleApiClient.m1804a(new C06141(this, googleApiClient));
        }
    }
}
