package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.internal.C0607p.C0600a;

class az extends C0577c {
    private final C0433b<DriveContentsResult> Ea;
    private final DownloadProgressListener QU;

    az(C0433b<DriveContentsResult> c0433b, DownloadProgressListener downloadProgressListener) {
        this.Ea = c0433b;
        this.QU = downloadProgressListener;
    }

    public void m2186a(OnContentsResponse onContentsResponse) throws RemoteException {
        this.Ea.m1609b(new C0600a(onContentsResponse.iM() ? new Status(-1) : Status.Kw, new C0618s(onContentsResponse.iL())));
    }

    public void m2187a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.QU != null) {
            this.QU.onProgress(onDownloadProgressResponse.iO(), onDownloadProgressResponse.iP());
        }
    }

    public void m2188n(Status status) throws RemoteException {
        this.Ea.m1609b(new C0600a(status, null));
    }
}
