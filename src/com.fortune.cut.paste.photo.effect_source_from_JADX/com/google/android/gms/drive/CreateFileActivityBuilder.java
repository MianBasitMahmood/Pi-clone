package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0584i;
import com.google.android.gms.drive.internal.C0618s;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final C0584i Ol;
    private DriveContents Om;
    private boolean On;

    public CreateFileActivityBuilder() {
        this.Ol = new C0584i(0);
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        jx.m5219b(Boolean.valueOf(this.On), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        boolean z = googleApiClient.m1805a(Drive.SCOPE_FILE) || googleApiClient.m1805a(Drive.Oo);
        jx.m5221b(z, (Object) "The apiClient must have suitable scope to create files");
        if (this.Om != null) {
            lh.m5328a(this.Om.getParcelFileDescriptor());
            this.Om.is();
        }
        return this.Ol.build(googleApiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.Ol.m2204a(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String str) {
        this.Ol.bl(str);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.Ol.bq(1);
        } else if (!(driveContents instanceof C0618s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.Ol.bq(driveContents.ir().getRequestId());
            this.Om = driveContents;
        }
        this.On = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.Ol.m2205a(metadataChangeSet);
        return this;
    }
}
