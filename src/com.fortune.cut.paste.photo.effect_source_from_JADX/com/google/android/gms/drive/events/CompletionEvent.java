package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0634w;
import com.google.android.gms.drive.internal.ah.C0576a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.lh;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int CK;
    final String DZ;
    final int FP;
    final ParcelFileDescriptor OY;
    final ParcelFileDescriptor OZ;
    final DriveId Oj;
    final MetadataBundle Pa;
    final List<String> Pb;
    final IBinder Pc;
    private boolean Pd;
    private boolean Pe;
    private boolean Pf;

    static {
        CREATOR = new C0561b();
    }

    CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.Pd = false;
        this.Pe = false;
        this.Pf = false;
        this.CK = i;
        this.Oj = driveId;
        this.DZ = str;
        this.OY = parcelFileDescriptor;
        this.OZ = parcelFileDescriptor2;
        this.Pa = metadataBundle;
        this.Pb = list;
        this.FP = i2;
        this.Pc = iBinder;
    }

    private void m2007M(boolean z) {
        iC();
        this.Pf = true;
        lh.m5328a(this.OY);
        lh.m5328a(this.OZ);
        if (this.Pc == null) {
            C0634w.m2302p("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            C0576a.aa(this.Pc).m2138M(z);
        } catch (RemoteException e) {
            C0634w.m2302p("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    private void iC() {
        if (this.Pf) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void dismiss() {
        m2007M(false);
    }

    public final String getAccountName() {
        iC();
        return this.DZ;
    }

    public final InputStream getBaseContentsInputStream() {
        iC();
        if (this.OY == null) {
            return null;
        }
        if (this.Pd) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.Pd = true;
        return new FileInputStream(this.OY.getFileDescriptor());
    }

    public final DriveId getDriveId() {
        iC();
        return this.Oj;
    }

    public final InputStream getModifiedContentsInputStream() {
        iC();
        if (this.OZ == null) {
            return null;
        }
        if (this.Pe) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.Pe = true;
        return new FileInputStream(this.OZ.getFileDescriptor());
    }

    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        iC();
        return this.Pa != null ? new MetadataChangeSet(this.Pa) : null;
    }

    public final int getStatus() {
        iC();
        return this.FP;
    }

    public final List<String> getTrackingTags() {
        iC();
        return new ArrayList(this.Pb);
    }

    public final int getType() {
        return STATUS_CONFLICT;
    }

    public final void snooze() {
        m2007M(true);
    }

    public final String toString() {
        String str = this.Pb == null ? "<null>" : "'" + TextUtils.join("','", this.Pb) + "'";
        Object[] objArr = new Object[STATUS_CANCELED];
        objArr[0] = this.Oj;
        objArr[STATUS_FAILURE] = Integer.valueOf(this.FP);
        objArr[STATUS_CONFLICT] = str;
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0561b.m2020a(this, parcel, i);
    }
}
