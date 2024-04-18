package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.C0543c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR;
    private final int CK;
    private final DataSource TN;
    private long Ud;
    private long Ue;
    private final Value[] Uf;
    private DataSource Ug;
    private long Uh;
    private long Ui;

    static {
        CREATOR = new C0770e();
    }

    DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.CK = i;
        this.TN = dataSource;
        this.Ug = dataSource2;
        this.Ud = j;
        this.Ue = j2;
        this.Uf = valueArr;
        this.Uh = j3;
        this.Ui = j4;
    }

    private DataPoint(DataSource dataSource) {
        this.CK = 4;
        this.TN = (DataSource) jx.m5219b((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.Uf = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.Uf[i] = new Value(format.getFormat());
            i++;
        }
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(4, m2610c(list, rawDataPoint.UJ), rawDataPoint.Ud, rawDataPoint.Ue, rawDataPoint.Uf, m2610c(list, rawDataPoint.UK), rawDataPoint.Uh, rawDataPoint.Ui);
    }

    private boolean m2609a(DataPoint dataPoint) {
        return jv.equal(this.TN, dataPoint.TN) && this.Ud == dataPoint.Ud && this.Ue == dataPoint.Ue && Arrays.equals(this.Uf, dataPoint.Uf) && jv.equal(this.Ug, dataPoint.Ug);
    }

    private static DataSource m2610c(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private void cL(int i) {
        jx.m5222b(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) C0543c.m1983a(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private boolean jq() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataPoint) && m2609a((DataPoint) obj));
    }

    public final DataSource getDataSource() {
        return this.TN;
    }

    public final DataType getDataType() {
        return this.TN.getDataType();
    }

    public final long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.Ud, TimeUnit.NANOSECONDS);
    }

    public final DataSource getOriginalDataSource() {
        return this.Ug;
    }

    public final long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.Ue, TimeUnit.NANOSECONDS);
    }

    public final long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.Ud, TimeUnit.NANOSECONDS);
    }

    public final long getTimestampNanos() {
        return this.Ud;
    }

    public final Value getValue(Field field) {
        return this.Uf[getDataType().indexOf(field)];
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.TN, Long.valueOf(this.Ud), Long.valueOf(this.Ue));
    }

    public final Value[] jr() {
        return this.Uf;
    }

    public final long js() {
        return this.Uh;
    }

    public final long jt() {
        return this.Ui;
    }

    public final long ju() {
        return this.Ue;
    }

    public final DataPoint setFloatValues(float... fArr) {
        cL(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.Uf[i].setFloat(fArr[i]);
        }
        return this;
    }

    public final DataPoint setIntValues(int... iArr) {
        cL(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.Uf[i].setInt(iArr[i]);
        }
        return this;
    }

    public final DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.Ue = timeUnit.toNanos(j);
        this.Ud = timeUnit.toNanos(j2);
        return this;
    }

    public final DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.Ud = timeUnit.toNanos(j);
        if (jq() && lt.m5346a(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.Ud = lt.m5345a(this.Ud, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final String toString() {
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[]{Arrays.toString(this.Uf), Long.valueOf(this.Ue), Long.valueOf(this.Ud), Long.valueOf(this.Uh), Long.valueOf(this.Ui), this.TN, this.Ug});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0770e.m2656a(this, parcel, i);
    }
}
