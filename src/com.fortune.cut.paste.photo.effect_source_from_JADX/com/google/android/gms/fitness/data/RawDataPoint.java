package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR;
    final int CK;
    final int UJ;
    final int UK;
    final long Ud;
    final long Ue;
    final Value[] Uf;
    final long Uh;
    final long Ui;

    static {
        CREATOR = new C0783n();
    }

    RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.CK = i;
        this.Ud = j;
        this.Ue = j2;
        this.UJ = i2;
        this.UK = i3;
        this.Uh = j3;
        this.Ui = j4;
        this.Uf = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.CK = 4;
        this.Ud = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.Ue = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.Uf = dataPoint.jr();
        this.UJ = C0789t.m2675a(dataPoint.getDataSource(), list);
        this.UK = C0789t.m2675a(dataPoint.getOriginalDataSource(), list);
        this.Uh = dataPoint.js();
        this.Ui = dataPoint.jt();
    }

    private boolean m2634a(RawDataPoint rawDataPoint) {
        return this.Ud == rawDataPoint.Ud && this.Ue == rawDataPoint.Ue && Arrays.equals(this.Uf, rawDataPoint.Uf) && this.UJ == rawDataPoint.UJ && this.UK == rawDataPoint.UK && this.Uh == rawDataPoint.Uh;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && m2634a((RawDataPoint) obj));
    }

    public final int hashCode() {
        return jv.hashCode(Long.valueOf(this.Ud), Long.valueOf(this.Ue));
    }

    public final String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.Uf), Long.valueOf(this.Ue), Long.valueOf(this.Ud), Integer.valueOf(this.UJ), Integer.valueOf(this.UK)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0783n.m2669a(this, parcel, i);
    }
}
