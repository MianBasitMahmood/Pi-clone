package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.u */
public class C0831u implements SafeParcelable {
    public static final Creator<C0831u> CREATOR;
    private final int CK;
    private final PendingIntent mPendingIntent;

    static {
        CREATOR = new C0832v();
    }

    C0831u(int i, PendingIntent pendingIntent) {
        this.CK = i;
        this.mPendingIntent = pendingIntent;
    }

    public C0831u(PendingIntent pendingIntent) {
        this.CK = 3;
        this.mPendingIntent = pendingIntent;
    }

    private boolean m2771a(C0831u c0831u) {
        return jv.equal(this.mPendingIntent, c0831u.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof C0831u) && m2771a((C0831u) obj));
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mPendingIntent);
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0832v.m2772a(this, parcel, i);
    }
}
