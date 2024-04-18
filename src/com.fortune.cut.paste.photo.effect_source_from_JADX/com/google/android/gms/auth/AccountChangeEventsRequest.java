package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final AccountChangeEventsRequestCreator CREATOR;
    String DZ;
    final int Ef;
    int Ei;

    static {
        CREATOR = new AccountChangeEventsRequestCreator();
    }

    public AccountChangeEventsRequest() {
        this.Ef = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str) {
        this.Ef = i;
        this.Ei = i2;
        this.DZ = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.DZ;
    }

    public int getEventIndex() {
        return this.Ei;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.DZ = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.Ei = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AccountChangeEventsRequestCreator.m1656a(this, parcel, i);
    }
}
