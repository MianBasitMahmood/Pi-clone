package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR;
    final int CK;
    final ParcelFileDescriptor LG;
    final int Oi;
    final DriveId Oj;
    final boolean Ok;
    final int ve;

    static {
        CREATOR = new C0550a();
    }

    Contents(int i, ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, DriveId driveId, boolean z) {
        this.CK = i;
        this.LG = parcelFileDescriptor;
        this.ve = i2;
        this.Oi = i3;
        this.Oj = driveId;
        this.Ok = z;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Oj;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.LG.getFileDescriptor());
    }

    public int getMode() {
        return this.Oi;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.LG.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.LG;
    }

    public int getRequestId() {
        return this.ve;
    }

    public boolean ip() {
        return this.Ok;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0550a.m2001a(this, parcel, i);
    }
}
