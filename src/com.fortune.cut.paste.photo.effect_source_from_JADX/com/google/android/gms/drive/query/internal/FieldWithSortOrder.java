package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final C0676c CREATOR;
    final int CK;
    final String QY;
    final boolean Sk;

    static {
        CREATOR = new C0676c();
    }

    FieldWithSortOrder(int i, String str, boolean z) {
        this.CK = i;
        this.QY = str;
        this.Sk = z;
    }

    public FieldWithSortOrder(String str, boolean z) {
        this(1, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        String str = "FieldWithSortOrder[%s %s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.QY;
        objArr[1] = this.Sk ? "ASC" : "DESC";
        return String.format(locale, str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0676c.m2426a(this, parcel, i);
    }
}
