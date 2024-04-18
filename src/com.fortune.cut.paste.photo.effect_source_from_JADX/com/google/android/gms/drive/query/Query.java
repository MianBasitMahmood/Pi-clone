package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR;
    final int CK;
    final LogicalFilter RY;
    final String RZ;
    final SortOrder Sa;
    final List<String> Sb;

    public static class Builder {
        private String RZ;
        private SortOrder Sa;
        private List<String> Sb;
        private final List<Filter> Sc;

        public Builder() {
            this.Sc = new ArrayList();
        }

        public Builder(Query query) {
            this.Sc = new ArrayList();
            this.Sc.add(query.getFilter());
            this.RZ = query.getPageToken();
            this.Sa = query.getSortOrder();
            this.Sb = query.jb();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.Sc.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.SB, this.Sc), this.RZ, this.Sa, this.Sb);
        }

        public Builder setPageToken(String str) {
            this.RZ = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.Sa = sortOrder;
            return this;
        }
    }

    static {
        CREATOR = new C0670a();
    }

    Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list) {
        this.CK = i;
        this.RY = logicalFilter;
        this.RZ = str;
        this.Sa = sortOrder;
        this.Sb = list;
    }

    Query(LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list) {
        this(1, logicalFilter, str, sortOrder, list);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.RY;
    }

    public String getPageToken() {
        return this.RZ;
    }

    public SortOrder getSortOrder() {
        return this.Sa;
    }

    public List<String> jb() {
        return this.Sb;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[]{this.RY, this.Sa, this.RZ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0670a.m2398a(this, parcel, i);
    }
}
