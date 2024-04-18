package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final AccountChangeEventsResponseCreator CREATOR;
    final int Ef;
    final List<AccountChangeEvent> mp;

    static {
        CREATOR = new AccountChangeEventsResponseCreator();
    }

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.Ef = i;
        this.mp = (List) jx.m5223i(list);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> list) {
        this.Ef = 1;
        this.mp = (List) jx.m5223i(list);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.mp;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AccountChangeEventsResponseCreator.m1657a(this, parcel, i);
    }
}
