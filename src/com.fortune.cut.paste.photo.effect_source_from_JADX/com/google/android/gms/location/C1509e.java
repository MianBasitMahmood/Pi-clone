package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.location.e */
public class C1509e implements SafeParcelable {
    public static final C1510f CREATOR;
    private final int CK;
    int agw;
    int agx;
    long agy;

    static {
        CREATOR = new C1510f();
    }

    public C1509e(int i, int i2, int i3, long j) {
        this.CK = i;
        this.agw = i2;
        this.agx = i3;
        this.agy = j;
    }

    private String eB(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "STATUS_SUCCESSFUL";
            case DataEvent.TYPE_DELETED /*2*/:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case WalletFragmentState.PROCESSING /*3*/:
                return "STATUS_NO_INFO_IN_DATABASE";
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return "STATUS_INVALID_SCAN";
            case Dimension.UNIT_MM /*5*/:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case Error.OTHER /*6*/:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case Error.AVS_DECLINE /*7*/:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case Error.FRAUD_DECLINE /*8*/:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1509e)) {
            return false;
        }
        C1509e c1509e = (C1509e) obj;
        return this.agw == c1509e.agw && this.agx == c1509e.agx && this.agy == c1509e.agy;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.agw), Integer.valueOf(this.agx), Long.valueOf(this.agy));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(eB(this.agw));
        stringBuilder.append(", wifi status: ").append(eB(this.agx));
        stringBuilder.append(", elapsed realtime ns: ").append(this.agy);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1510f.m6094a(this, parcel, i);
    }
}
