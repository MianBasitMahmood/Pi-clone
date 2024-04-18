package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR;
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int CK;
    private final long LW;
    private final long TO;
    private final Session TQ;
    private final int TZ;
    private final List<DataSet> Ua;
    private final int Ub;
    private boolean Uc;

    static {
        CREATOR = new C0769d();
    }

    Bucket(int i, long j, long j2, Session session, int i2, List<DataSet> list, int i3, boolean z) {
        this.Uc = false;
        this.CK = i;
        this.LW = j;
        this.TO = j2;
        this.TQ = session;
        this.TZ = i2;
        this.Ua = list;
        this.Ub = i3;
        this.Uc = z;
    }

    public Bucket(RawBucket rawBucket, List<DataSource> list, List<DataType> list2) {
        this(TYPE_SESSION, rawBucket.LW, rawBucket.TO, rawBucket.TQ, rawBucket.UI, m2606a(rawBucket.Ua, list, list2), rawBucket.Ub, rawBucket.Uc);
    }

    private static List<DataSet> m2606a(List<RawDataSet> list, List<DataSource> list2, List<DataType> list3) {
        List<DataSet> arrayList = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            arrayList.add(new DataSet(dataSet, list2, list3));
        }
        return arrayList;
    }

    private boolean m2607a(Bucket bucket) {
        return this.LW == bucket.LW && this.TO == bucket.TO && this.TZ == bucket.TZ && jv.equal(this.Ua, bucket.Ua) && this.Ub == bucket.Ub && this.Uc == bucket.Uc;
    }

    public static String cJ(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return FitnessActivities.UNKNOWN;
            case TYPE_TIME /*1*/:
                return "time";
            case TYPE_SESSION /*2*/:
                return "session";
            case TYPE_ACTIVITY_TYPE /*3*/:
                return "type";
            case TYPE_ACTIVITY_SEGMENT /*4*/:
                return "segment";
            default:
                return "bug";
        }
    }

    public boolean m2608b(Bucket bucket) {
        return this.LW == bucket.LW && this.TO == bucket.TO && this.TZ == bucket.TZ && this.Ub == bucket.Ub;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && m2607a((Bucket) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.TZ);
    }

    public int getBucketType() {
        return this.Ub;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.Ua) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.Ua;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.TQ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_ACTIVITY_SEGMENT];
        objArr[0] = Long.valueOf(this.LW);
        objArr[TYPE_TIME] = Long.valueOf(this.TO);
        objArr[TYPE_SESSION] = Integer.valueOf(this.TZ);
        objArr[TYPE_ACTIVITY_TYPE] = Integer.valueOf(this.Ub);
        return jv.hashCode(objArr);
    }

    public int jm() {
        return this.TZ;
    }

    public boolean jn() {
        if (this.Uc) {
            return true;
        }
        for (DataSet jn : this.Ua) {
            if (jn.jn()) {
                return true;
            }
        }
        return false;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("startTime", Long.valueOf(this.LW)).m5211a("endTime", Long.valueOf(this.TO)).m5211a("activity", Integer.valueOf(this.TZ)).m5211a("dataSets", this.Ua).m5211a("bucketType", cJ(this.Ub)).m5211a("serverHasMoreData", Boolean.valueOf(this.Uc)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0769d.m2655a(this, parcel, i);
    }
}
