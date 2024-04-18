package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C1265a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR;
    private final int CK;
    private final List<DataType> TY;
    private final List<Integer> VS;
    private final boolean VT;

    public static class Builder {
        private boolean VT;
        private DataType[] VU;
        private int[] VV;

        public Builder() {
            this.VU = new DataType[0];
            this.VV = new int[]{0, 1};
            this.VT = false;
        }

        public DataSourcesRequest build() {
            boolean z = true;
            jx.m5217a(this.VU.length > 0, "Must add at least one data type");
            if (this.VV.length <= 0) {
                z = false;
            }
            jx.m5217a(z, "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.VV = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.VU = dataTypeArr;
            return this;
        }
    }

    static {
        CREATOR = new C0816h();
    }

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z) {
        this.CK = i;
        this.TY = list;
        this.VS = list2;
        this.VT = z;
    }

    private DataSourcesRequest(Builder builder) {
        this.CK = 2;
        this.TY = la.m5319b(builder.VU);
        this.VS = Arrays.asList(la.m5318a(builder.VV));
        this.VT = builder.VT;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.TY);
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean jY() {
        return this.VT;
    }

    List<Integer> jZ() {
        return this.VS;
    }

    public String toString() {
        C1265a a = jv.m5212h(this).m5211a("dataTypes", this.TY).m5211a("sourceTypes", this.VS);
        if (this.VT) {
            a.m5211a("includeDbOnlySources", "true");
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0816h.m2758a(this, parcel, i);
    }
}
