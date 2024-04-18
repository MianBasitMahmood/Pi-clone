package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR;
    public static final Status KA;
    public static final Status Kw;
    public static final Status Kx;
    public static final Status Ky;
    public static final Status Kz;
    private final int CK;
    private final int Iv;
    private final String KB;
    private final PendingIntent mPendingIntent;

    static {
        Kw = new Status(0);
        Kx = new Status(14);
        Ky = new Status(8);
        Kz = new Status(15);
        KA = new Status(16);
        CREATOR = new StatusCreator();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.CK = i;
        this.Iv = i2;
        this.KB = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String gt() {
        return this.KB != null ? this.KB : CommonStatusCodes.getStatusCodeString(this.Iv);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.CK == status.CK && this.Iv == status.Iv && jv.equal(this.KB, status.KB) && jv.equal(this.mPendingIntent, status.mPendingIntent);
    }

    final PendingIntent gP() {
        return this.mPendingIntent;
    }

    @Deprecated
    public final ConnectionResult gQ() {
        return new ConnectionResult(this.Iv, this.mPendingIntent);
    }

    public final PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.Iv;
    }

    public final String getStatusMessage() {
        return this.KB;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), Integer.valueOf(this.Iv), this.KB, this.mPendingIntent);
    }

    public final boolean isCanceled() {
        return this.Iv == 16;
    }

    public final boolean isInterrupted() {
        return this.Iv == 14;
    }

    public final boolean isSuccess() {
        return this.Iv <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("statusCode", gt()).m5211a("resolution", this.mPendingIntent).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        StatusCreator.m1808a(this, parcel, i);
    }
}
