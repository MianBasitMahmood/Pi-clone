package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR;
    private final int CK;
    String vk;

    static {
        CREATOR = new C1846c();
    }

    CountrySpecification(int i, String str) {
        this.CK = i;
        this.vk = str;
    }

    public CountrySpecification(String str) {
        this.CK = 1;
        this.vk = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.vk;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1846c.m6712a(this, parcel, i);
    }
}
