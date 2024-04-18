package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR;
    final int CK;
    final int UJ;
    final int UL;
    final List<RawDataPoint> UM;
    final boolean Uc;

    static {
        CREATOR = new C0784o();
    }

    RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.CK = i;
        this.UJ = i2;
        this.UL = i3;
        this.UM = list;
        this.Uc = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.CK = 2;
        this.UM = dataSet.m2615f(list);
        this.Uc = dataSet.jn();
        this.UJ = C0789t.m2675a(dataSet.getDataSource(), list);
        this.UL = C0789t.m2675a(dataSet.getDataType(), list2);
    }

    private boolean m2635a(RawDataSet rawDataSet) {
        return this.UJ == rawDataSet.UJ && this.UL == rawDataSet.UL && this.Uc == rawDataSet.Uc && jv.equal(this.UM, rawDataSet.UM);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && m2635a((RawDataSet) obj));
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.UJ), Integer.valueOf(this.UL));
    }

    public final String toString() {
        return String.format("RawDataSet{%s@[%s, %s]}", new Object[]{Integer.valueOf(this.UJ), Integer.valueOf(this.UL), this.UM});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0784o.m2670a(this, parcel, i);
    }
}
