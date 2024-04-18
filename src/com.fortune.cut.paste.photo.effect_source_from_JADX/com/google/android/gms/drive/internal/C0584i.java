package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0584i {
    private String OH;
    private DriveId OJ;
    protected MetadataChangeSet Pu;
    private Integer Pv;
    private final int Pw;

    public C0584i(int i) {
        this.Pw = i;
    }

    public void m2204a(DriveId driveId) {
        this.OJ = (DriveId) jx.m5223i(driveId);
    }

    public void m2205a(MetadataChangeSet metadataChangeSet) {
        this.Pu = (MetadataChangeSet) jx.m5223i(metadataChangeSet);
    }

    public void bl(String str) {
        this.OH = (String) jx.m5223i(str);
    }

    public void bq(int i) {
        this.Pv = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        jx.m5219b(this.Pu, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        jx.m5217a(googleApiClient.isConnected(), "Client must be connected");
        C0613r c0613r = (C0613r) googleApiClient.m1803a(Drive.DQ);
        this.Pu.iz().setContext(c0613r.getContext());
        try {
            return c0613r.iG().m2039a(new CreateFileIntentSenderRequest(this.Pu.iz(), this.Pv == null ? -1 : this.Pv.intValue(), this.OH, this.OJ, this.Pw));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
