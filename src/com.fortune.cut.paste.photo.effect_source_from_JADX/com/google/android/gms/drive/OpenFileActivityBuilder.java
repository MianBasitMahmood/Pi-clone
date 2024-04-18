package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0613r;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.jx;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String OH;
    private String[] OI;
    private DriveId OJ;

    public IntentSender build(GoogleApiClient googleApiClient) {
        jx.m5217a(googleApiClient.isConnected(), "Client must be connected");
        if (this.OI == null) {
            this.OI = new String[0];
        }
        try {
            return ((C0613r) googleApiClient.m1803a(Drive.DQ)).iG().m2040a(new OpenFileIntentSenderRequest(this.OH, this.OI, this.OJ));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.OJ = (DriveId) jx.m5223i(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.OH = (String) jx.m5223i(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        jx.m5221b(strArr != null, (Object) "mimeTypes may not be null");
        this.OI = strArr;
        return this;
    }
}
