package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.jx;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR;
    final int CK;
    final int Oi;

    static {
        CREATOR = new C0583h();
    }

    public CreateContentsRequest(int i) {
        this(1, i);
    }

    CreateContentsRequest(int i, int i2) {
        this.CK = i;
        boolean z = i2 == DriveFile.MODE_WRITE_ONLY || i2 == DriveFile.MODE_READ_WRITE;
        jx.m5221b(z, (Object) "Cannot create a new read-only contents!");
        this.Oi = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0583h.m2203a(this, parcel, i);
    }
}
