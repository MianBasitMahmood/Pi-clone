package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0776k;
import com.google.android.gms.fitness.data.C0776k.C0778a;

/* renamed from: com.google.android.gms.fitness.request.q */
public class C0827q implements SafeParcelable {
    public static final Creator<C0827q> CREATOR;
    private final int CK;
    private final C0776k VW;
    private final PendingIntent mPendingIntent;

    static {
        CREATOR = new C0828r();
    }

    C0827q(int i, IBinder iBinder, PendingIntent pendingIntent) {
        this.CK = i;
        this.VW = iBinder == null ? null : C0778a.aq(iBinder);
        this.mPendingIntent = pendingIntent;
    }

    public C0827q(C0776k c0776k, PendingIntent pendingIntent) {
        this.CK = 2;
        this.VW = c0776k;
        this.mPendingIntent = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    IBinder kg() {
        return this.VW == null ? null : this.VW.asBinder();
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.VW});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0828r.m2767a(this, parcel, i);
    }
}
