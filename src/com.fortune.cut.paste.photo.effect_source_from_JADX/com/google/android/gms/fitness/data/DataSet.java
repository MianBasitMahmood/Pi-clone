package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR;
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private boolean Uc;
    private final List<DataPoint> Uj;
    private final List<DataSource> Uk;

    static {
        CREATOR = new C0771f();
    }

    DataSet(int i, DataSource dataSource, DataType dataType, List<RawDataPoint> list, List<DataSource> list2, boolean z) {
        List singletonList;
        this.Uc = false;
        this.CK = i;
        this.TN = dataSource;
        this.TM = dataType;
        this.Uc = z;
        this.Uj = new ArrayList(list.size());
        if (i < 2) {
            singletonList = Collections.singletonList(dataSource);
        }
        this.Uk = singletonList;
        for (RawDataPoint dataPoint : list) {
            this.Uj.add(new DataPoint(this.Uk, dataPoint));
        }
    }

    private DataSet(DataSource dataSource, DataType dataType) {
        this.Uc = false;
        this.CK = 3;
        this.TN = (DataSource) jx.m5223i(dataSource);
        this.TM = (DataType) jx.m5223i(dataType);
        this.Uj = new ArrayList();
        this.Uk = new ArrayList();
        this.Uk.add(this.TN);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list, List<DataType> list2) {
        this(3, (DataSource) m2612d(list, rawDataSet.UJ), (DataType) m2612d(list2, rawDataSet.UL), rawDataSet.UM, list, rawDataSet.Uc);
    }

    private boolean m2611a(DataSet dataSet) {
        return jv.equal(this.TM, dataSet.TM) && jv.equal(this.TN, dataSet.TN) && jv.equal(this.Uj, dataSet.Uj) && this.Uc == dataSet.Uc;
    }

    public static DataSet create(DataSource dataSource) {
        jx.m5219b((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource, dataSource.getDataType());
    }

    private static <T> T m2612d(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public final void m2613a(Iterable<DataPoint> iterable) {
        for (DataPoint b : iterable) {
            m2614b(b);
        }
    }

    public final void add(DataPoint dataPoint) {
        jx.m5222b(dataPoint.getDataSource().getStreamIdentifier().equals(this.TN.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataPoint.getDataSource(), this.TN);
        jx.m5222b(dataPoint.getDataType().getName().equals(this.TM.getName()), "Conflicting data types found %s vs %s", dataPoint.getDataType(), this.TM);
        jx.m5222b(dataPoint.getTimestamp(TimeUnit.NANOSECONDS) > 0, "Data point does not have the timestamp set: %s", dataPoint);
        jx.m5222b(dataPoint.getStartTime(TimeUnit.NANOSECONDS) <= dataPoint.getEndTime(TimeUnit.NANOSECONDS), "Data point with start time greater than end time found: %s", dataPoint);
        m2614b(dataPoint);
    }

    public final void addAll(Iterable<DataPoint> iterable) {
        for (DataPoint add : iterable) {
            add(add);
        }
    }

    public final void m2614b(DataPoint dataPoint) {
        this.Uj.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.Uk.contains(originalDataSource)) {
            this.Uk.add(originalDataSource);
        }
    }

    public final DataPoint createDataPoint() {
        return DataPoint.create(this.TN);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && m2611a((DataSet) obj));
    }

    final List<RawDataPoint> m2615f(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.Uj.size());
        for (DataPoint rawDataPoint : this.Uj) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public final List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.Uj);
    }

    public final DataSource getDataSource() {
        return this.TN;
    }

    public final DataType getDataType() {
        return this.TM;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.TM, this.TN);
    }

    public final boolean jn() {
        return this.Uc;
    }

    final List<RawDataPoint> jv() {
        return m2615f(this.Uk);
    }

    final List<DataSource> jw() {
        return this.Uk;
    }

    public final String toString() {
        List jv = jv();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.TN.toDebugString();
        if (this.Uj.size() >= 10) {
            jv = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.Uj.size()), jv.subList(0, 5)});
        }
        objArr[1] = jv;
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0771f.m2657a(this, parcel, i);
    }
}
