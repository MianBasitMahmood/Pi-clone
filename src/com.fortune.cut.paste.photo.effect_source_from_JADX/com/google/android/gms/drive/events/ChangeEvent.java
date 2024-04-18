package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR;
    final int CK;
    final int OX;
    final DriveId Oj;

    static {
        CREATOR = new C0560a();
    }

    ChangeEvent(int i, DriveId driveId, int i2) {
        this.CK = i;
        this.Oj = driveId;
        this.OX = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final DriveId getDriveId() {
        return this.Oj;
    }

    public final int getType() {
        return 1;
    }

    public final boolean hasContentChanged() {
        return (this.OX & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.OX & 1) != 0;
    }

    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.Oj, Integer.valueOf(this.OX)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0560a.m2018a(this, parcel, i);
    }
}
