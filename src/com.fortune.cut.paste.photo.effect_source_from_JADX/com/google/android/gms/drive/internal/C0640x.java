package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.C0591q.C0598a;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C0640x implements DrivePreferencesApi {

    /* renamed from: com.google.android.gms.drive.internal.x.c */
    private abstract class C0635c extends C0591q<FileUploadPreferencesResult> {
        final /* synthetic */ C0640x Qq;

        public C0635c(C0640x c0640x, GoogleApiClient googleApiClient) {
            this.Qq = c0640x;
            super(googleApiClient);
        }

        protected /* synthetic */ Result m2303c(Status status) {
            return m2304t(status);
        }

        protected FileUploadPreferencesResult m2304t(Status status) {
            return new C0639b(status, null, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x.1 */
    class C06361 extends C0635c {
        final /* synthetic */ C0640x Qq;

        C06361(C0640x c0640x, GoogleApiClient googleApiClient) {
            this.Qq = c0640x;
            super(c0640x, googleApiClient);
        }

        protected void m2306a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2073h(new C0638a(this, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x.2 */
    class C06372 extends C0598a {
        final /* synthetic */ C0640x Qq;
        final /* synthetic */ FileUploadPreferencesImpl Qr;

        C06372(C0640x c0640x, GoogleApiClient googleApiClient, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
            this.Qq = c0640x;
            this.Qr = fileUploadPreferencesImpl;
            super(googleApiClient);
        }

        protected void m2308a(C0613r c0613r) throws RemoteException {
            c0613r.iG().m2061a(new SetFileUploadPreferencesRequest(this.Qr), new bg(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x.a */
    private class C0638a extends C0577c {
        private final C0433b<FileUploadPreferencesResult> Ea;
        final /* synthetic */ C0640x Qq;

        private C0638a(C0640x c0640x, C0433b<FileUploadPreferencesResult> c0433b) {
            this.Qq = c0640x;
            this.Ea = c0433b;
        }

        public void m2309a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.Ea.m1609b(new C0639b(Status.Kw, onDeviceUsagePreferenceResponse.iN(), null));
        }

        public void m2310n(Status status) throws RemoteException {
            this.Ea.m1609b(new C0639b(status, null, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x.b */
    private class C0639b implements FileUploadPreferencesResult {
        private final Status Eb;
        final /* synthetic */ C0640x Qq;
        private final FileUploadPreferences Qs;

        private C0639b(C0640x c0640x, Status status, FileUploadPreferences fileUploadPreferences) {
            this.Qq = c0640x;
            this.Eb = status;
            this.Qs = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.Qs;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C06361(this, googleApiClient));
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            return googleApiClient.m1806b(new C06372(this, googleApiClient, (FileUploadPreferencesImpl) fileUploadPreferences));
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
