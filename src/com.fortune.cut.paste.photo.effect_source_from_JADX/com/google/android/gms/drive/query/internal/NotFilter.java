package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR;
    final int CK;
    final FilterHolder Sv;

    static {
        CREATOR = new C0683k();
    }

    NotFilter(int i, FilterHolder filterHolder) {
        this.CK = i;
        this.Sv = filterHolder;
    }

    public NotFilter(Filter filter) {
        this(1, new FilterHolder(filter));
    }

    public <T> T m2423a(C0672f<T> c0672f) {
        return c0672f.m2405j(this.Sv.getFilter().m2397a(c0672f));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0683k.m2433a(this, parcel, i);
    }
}
