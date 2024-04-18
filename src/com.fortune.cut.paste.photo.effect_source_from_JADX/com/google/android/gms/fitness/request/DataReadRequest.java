package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR;
    public static final int NO_LIMIT = 0;
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final int Ub;
    private final List<DataSource> VH;
    private final List<DataType> VL;
    private final List<DataSource> VM;
    private final long VN;
    private final DataSource VO;
    private final int VP;
    private final boolean VQ;
    private final boolean VR;

    public static class Builder {
        private long LW;
        private long TO;
        private List<DataType> TY;
        private int Ub;
        private List<DataSource> VH;
        private List<DataType> VL;
        private List<DataSource> VM;
        private long VN;
        private DataSource VO;
        private int VP;
        private boolean VQ;
        private boolean VR;

        public Builder() {
            this.TY = new ArrayList();
            this.VH = new ArrayList();
            this.VL = new ArrayList();
            this.VM = new ArrayList();
            this.Ub = 0;
            this.VN = 0;
            this.VP = 0;
            this.VQ = false;
            this.VR = false;
        }

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            jx.m5219b((Object) dataSource, (Object) "Attempting to add a null data source");
            jx.m5217a(!this.VH.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            jx.m5222b(DataType.AGGREGATE_INPUT_TYPES.contains(dataType2), "Unsupported input data type specified for aggregation: %s", dataType2);
            jx.m5222b(DataType.getAggregatesForInput(dataType2).contains(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
            if (!this.VM.contains(dataSource)) {
                this.VM.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            jx.m5219b((Object) dataType, (Object) "Attempting to use a null data type");
            jx.m5217a(!this.TY.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            jx.m5222b(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            jx.m5222b(DataType.getAggregatesForInput(dataType).contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.VL.contains(dataType)) {
                this.VL.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.Ub = 4;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            jx.m5221b(dataSource != null, (Object) "Invalid activity data source specified");
            jx.m5222b(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.VO = dataSource;
            this.Ub = 4;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.Ub = 3;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            jx.m5221b(dataSource != null, (Object) "Invalid activity data source specified");
            jx.m5222b(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.VO = dataSource;
            this.Ub = 3;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.Ub = 2;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            jx.m5222b(this.Ub == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.Ub));
            jx.m5222b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.Ub = 1;
            this.VN = timeUnit.toMillis((long) i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.VH.isEmpty() && this.TY.isEmpty() && this.VM.isEmpty() && this.VL.isEmpty()) ? false : true;
            jx.m5217a(z2, "Must add at least one data source (aggregated or detailed)");
            jx.m5218a(this.LW > 0, "Invalid start time: %s", Long.valueOf(this.LW));
            z2 = this.TO > 0 && this.TO > this.LW;
            jx.m5218a(z2, "Invalid end time: %s", Long.valueOf(this.TO));
            z2 = this.VM.isEmpty() && this.VL.isEmpty();
            if (!(z2 && this.Ub == 0) && (z2 || this.Ub == 0)) {
                z = false;
            }
            jx.m5217a(z, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.VR = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            jx.m5219b((Object) dataSource, (Object) "Attempting to add a null data source");
            jx.m5221b(!this.VM.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            jx.m5219b((Object) dataType, (Object) "Attempting to use a null data type");
            jx.m5217a(!this.VL.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            jx.m5222b(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.VP = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.LW = timeUnit.toMillis(j);
            this.TO = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new C0815g();
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2) {
        this.CK = i;
        this.TY = Collections.unmodifiableList(list);
        this.VH = Collections.unmodifiableList(list2);
        this.LW = j;
        this.TO = j2;
        this.VL = Collections.unmodifiableList(list3);
        this.VM = Collections.unmodifiableList(list4);
        this.Ub = i2;
        this.VN = j3;
        this.VO = dataSource;
        this.VP = i3;
        this.VQ = z;
        this.VR = z2;
    }

    private DataReadRequest(Builder builder) {
        this.CK = 2;
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VH = Collections.unmodifiableList(builder.VH);
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.VL = Collections.unmodifiableList(builder.VL);
        this.VM = Collections.unmodifiableList(builder.VM);
        this.Ub = builder.Ub;
        this.VN = builder.VN;
        this.VO = builder.VO;
        this.VP = builder.VP;
        this.VQ = builder.VQ;
        this.VR = builder.VR;
    }

    private boolean m2697a(DataReadRequest dataReadRequest) {
        return this.TY.equals(dataReadRequest.TY) && this.VH.equals(dataReadRequest.VH) && this.LW == dataReadRequest.LW && this.TO == dataReadRequest.TO && this.Ub == dataReadRequest.Ub && this.VM.equals(dataReadRequest.VM) && this.VL.equals(dataReadRequest.VL) && jv.equal(this.VO, dataReadRequest.VO) && this.VN == dataReadRequest.VN && this.VR == dataReadRequest.VR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && m2697a((DataReadRequest) obj));
    }

    public DataSource getActivityDataSource() {
        return this.VO;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.VM;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.VL;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.VN, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.Ub;
    }

    public List<DataSource> getDataSources() {
        return this.VH;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.VP;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.Ub), Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean jV() {
        return this.VR;
    }

    public boolean jW() {
        return this.VQ;
    }

    public long jX() {
        return this.VN;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.TY.isEmpty()) {
            for (DataType jB : this.TY) {
                stringBuilder.append(jB.jB()).append(" ");
            }
        }
        if (!this.VH.isEmpty()) {
            for (DataSource toDebugString : this.VH) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.Ub != 0) {
            stringBuilder.append("bucket by ").append(Bucket.cJ(this.Ub));
            if (this.VN > 0) {
                stringBuilder.append(" >").append(this.VN).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.VL.isEmpty()) {
            for (DataType jB2 : this.VL) {
                stringBuilder.append(jB2.jB()).append(" ");
            }
        }
        if (!this.VM.isEmpty()) {
            for (DataSource toDebugString2 : this.VM) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.LW), Long.valueOf(this.LW), Long.valueOf(this.TO), Long.valueOf(this.TO)}));
        if (this.VO != null) {
            stringBuilder.append("activities: ").append(this.VO.toDebugString());
        }
        if (this.VR) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0815g.m2757a(this, parcel, i);
    }
}
