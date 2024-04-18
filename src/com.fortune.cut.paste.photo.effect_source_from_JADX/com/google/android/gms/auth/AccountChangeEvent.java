package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR;
    final String DZ;
    final int Ef;
    final long Eg;
    final int Eh;
    final int Ei;
    final String Ej;

    static {
        CREATOR = new AccountChangeEventCreator();
    }

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.Ef = i;
        this.Eg = j;
        this.DZ = (String) jx.m5223i(str);
        this.Eh = i2;
        this.Ei = i3;
        this.Ej = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.Ef = 1;
        this.Eg = j;
        this.DZ = (String) jx.m5223i(str);
        this.Eh = i;
        this.Ei = i2;
        this.Ej = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.Ef == accountChangeEvent.Ef && this.Eg == accountChangeEvent.Eg && jv.equal(this.DZ, accountChangeEvent.DZ) && this.Eh == accountChangeEvent.Eh && this.Ei == accountChangeEvent.Ei && jv.equal(this.Ej, accountChangeEvent.Ej);
    }

    public String getAccountName() {
        return this.DZ;
    }

    public String getChangeData() {
        return this.Ej;
    }

    public int getChangeType() {
        return this.Eh;
    }

    public int getEventIndex() {
        return this.Ei;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Ef), Long.valueOf(this.Eg), this.DZ, Integer.valueOf(this.Eh), Integer.valueOf(this.Ei), this.Ej);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.Eh) {
            case DataEvent.TYPE_CHANGED /*1*/:
                str = "ADDED";
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                str = "REMOVED";
                break;
            case WalletFragmentState.PROCESSING /*3*/:
                str = "RENAMED_FROM";
                break;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.DZ + ", changeType = " + str + ", changeData = " + this.Ej + ", eventIndex = " + this.Ei + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        AccountChangeEventCreator.m1655a(this, parcel, i);
    }
}
