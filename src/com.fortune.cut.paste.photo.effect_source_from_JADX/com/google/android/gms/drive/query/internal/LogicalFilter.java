package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR;
    final int CK;
    private List<Filter> Sc;
    final Operator Sh;
    final List<FilterHolder> Su;

    static {
        CREATOR = new C0681i();
    }

    LogicalFilter(int i, Operator operator, List<FilterHolder> list) {
        this.CK = i;
        this.Sh = operator;
        this.Su = list;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... filterArr) {
        this.CK = 1;
        this.Sh = operator;
        this.Su = new ArrayList(filterArr.length + 1);
        this.Su.add(new FilterHolder(filter));
        this.Sc = new ArrayList(filterArr.length + 1);
        this.Sc.add(filter);
        for (Filter filter2 : filterArr) {
            this.Su.add(new FilterHolder(filter2));
            this.Sc.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> iterable) {
        this.CK = 1;
        this.Sh = operator;
        this.Sc = new ArrayList();
        this.Su = new ArrayList();
        for (Filter filter : iterable) {
            this.Sc.add(filter);
            this.Su.add(new FilterHolder(filter));
        }
    }

    public <T> T m2421a(C0672f<T> c0672f) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.Su) {
            arrayList.add(filter.getFilter().m2397a(c0672f));
        }
        return c0672f.m2402b(this.Sh, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0681i.m2431a(this, parcel, i);
    }
}
