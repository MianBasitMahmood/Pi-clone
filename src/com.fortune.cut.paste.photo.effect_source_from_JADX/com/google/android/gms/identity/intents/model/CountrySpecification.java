package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR;
    private final int CK;
    String vk;

    static {
        CREATOR = new C0995a();
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
        C0995a.m4106a(this, parcel, i);
    }
}
