package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0509d;
import com.google.android.gms.common.api.C0509d.C0493b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.C0607p.C0594b;

/* renamed from: com.google.android.gms.drive.internal.t */
public class C0623t extends C0622y implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.t.1 */
    class C06191 extends C0594b {
        final /* synthetic */ int PG;
        final /* synthetic */ DownloadProgressListener Qc;
        final /* synthetic */ C0623t Qd;

        C06191(C0623t c0623t, GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
            this.Qd = c0623t;
            this.PG = i;
            this.Qc = downloadProgressListener;
            super(googleApiClient);
        }

        protected void m2280a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2057a(new OpenContentsRequest(this.Qd.getDriveId(), this.PG, 0), new az(this, this.Qc));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.t.a */
    private static class C0621a implements DownloadProgressListener {
        private final C0509d<DownloadProgressListener> Qe;

        /* renamed from: com.google.android.gms.drive.internal.t.a.1 */
        class C06201 implements C0493b<DownloadProgressListener> {
            final /* synthetic */ long Qf;
            final /* synthetic */ long Qg;
            final /* synthetic */ C0621a Qh;

            C06201(C0621a c0621a, long j, long j2) {
                this.Qh = c0621a;
                this.Qf = j;
                this.Qg = j2;
            }

            public void m2281a(DownloadProgressListener downloadProgressListener) {
                downloadProgressListener.onProgress(this.Qf, this.Qg);
            }

            public /* synthetic */ void m2282c(Object obj) {
                m2281a((DownloadProgressListener) obj);
            }

            public void gG() {
            }
        }

        public C0621a(C0509d<DownloadProgressListener> c0509d) {
            this.Qe = c0509d;
        }

        public void onProgress(long j, long j2) {
            this.Qe.m1840a(new C06201(this, j, j2));
        }
    }

    public C0623t(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener m2283a(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new C0621a(googleApiClient.m1807d(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
        if (i == DriveFile.MODE_READ_ONLY || i == DriveFile.MODE_WRITE_ONLY || i == DriveFile.MODE_READ_WRITE) {
            return googleApiClient.m1804a(new C06191(this, googleApiClient, i, C0623t.m2283a(googleApiClient, downloadProgressListener)));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
