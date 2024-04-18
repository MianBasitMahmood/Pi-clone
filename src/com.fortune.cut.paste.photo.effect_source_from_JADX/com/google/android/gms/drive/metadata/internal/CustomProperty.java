package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.jx;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR;
    final int CK;
    final CustomPropertyKey Rg;
    final String mValue;

    static {
        CREATOR = new C0658c();
    }

    CustomProperty(int i, CustomPropertyKey customPropertyKey, String str) {
        this.CK = i;
        jx.m5219b((Object) customPropertyKey, (Object) "key");
        this.Rg = customPropertyKey;
        this.mValue = str;
    }

    public CustomProperty(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }

    public CustomPropertyKey iX() {
        return this.Rg;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0658c.m2352a(this, parcel, i);
    }
}
