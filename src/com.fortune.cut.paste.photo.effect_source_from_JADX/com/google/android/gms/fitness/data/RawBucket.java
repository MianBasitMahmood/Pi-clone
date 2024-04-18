package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR;
    final int CK;
    final long LW;
    final long TO;
    final Session TQ;
    final int UI;
    final List<RawDataSet> Ua;
    final int Ub;
    final boolean Uc;

    static {
        CREATOR = new C0782m();
    }

    RawBucket(int i, long j, long j2, Session session, int i2, List<RawDataSet> list, int i3, boolean z) {
        this.CK = i;
        this.LW = j;
        this.TO = j2;
        this.TQ = session;
        this.UI = i2;
        this.Ua = list;
        this.Ub = i3;
        this.Uc = z;
    }

    public RawBucket(Bucket bucket, List<DataSource> list, List<DataType> list2) {
        this.CK = 2;
        this.LW = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.TO = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.TQ = bucket.getSession();
        this.UI = bucket.jm();
        this.Ub = bucket.getBucketType();
        this.Uc = bucket.jn();
        List<DataSet> dataSets = bucket.getDataSets();
        this.Ua = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.Ua.add(new RawDataSet(rawDataSet, list, list2));
        }
    }

    private boolean m2633a(RawBucket rawBucket) {
        return this.LW == rawBucket.LW && this.TO == rawBucket.TO && this.UI == rawBucket.UI && jv.equal(this.Ua, rawBucket.Ua) && this.Ub == rawBucket.Ub && this.Uc == rawBucket.Uc;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawBucket) && m2633a((RawBucket) obj));
    }

    public final int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO), Integer.valueOf(this.Ub));
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("startTime", Long.valueOf(this.LW)).m5211a("endTime", Long.valueOf(this.TO)).m5211a("activity", Integer.valueOf(this.UI)).m5211a("dataSets", this.Ua).m5211a("bucketType", Integer.valueOf(this.Ub)).m5211a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0782m.m2668a(this, parcel, i);
    }
}
