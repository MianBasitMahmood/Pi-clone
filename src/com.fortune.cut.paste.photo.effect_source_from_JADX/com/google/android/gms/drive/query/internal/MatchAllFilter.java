package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final C0682j CREATOR;
    final int CK;

    static {
        CREATOR = new C0682j();
    }

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int i) {
        this.CK = i;
    }

    public <F> F m2422a(C0672f<F> c0672f) {
        return c0672f.jd();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0682j.m2432a(this, parcel, i);
    }
}
