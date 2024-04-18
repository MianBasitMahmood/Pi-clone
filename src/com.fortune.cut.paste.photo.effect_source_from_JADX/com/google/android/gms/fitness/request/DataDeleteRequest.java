package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR;
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final List<DataSource> VH;
    private final List<Session> VI;
    private final boolean VJ;
    private final boolean VK;

    public static class Builder {
        private long LW;
        private long TO;
        private List<DataType> TY;
        private List<DataSource> VH;
        private List<Session> VI;
        private boolean VJ;
        private boolean VK;

        public Builder() {
            this.VH = new ArrayList();
            this.TY = new ArrayList();
            this.VI = new ArrayList();
            this.VJ = false;
            this.VK = false;
        }

        private void jT() {
            if (!this.VI.isEmpty()) {
                for (Session session : this.VI) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.LW && session.getEndTime(TimeUnit.MILLISECONDS) <= this.TO;
                    jx.m5218a(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.LW), Long.valueOf(this.TO));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            jx.m5221b(!this.VJ, (Object) "All data is already marked for deletion");
            if (dataSource == null) {
                z = false;
            }
            jx.m5221b(z, (Object) "Must specify a valid data source");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            jx.m5221b(!this.VJ, (Object) "All data is already marked for deletion");
            if (dataType == null) {
                z = false;
            }
            jx.m5221b(z, (Object) "Must specify a valid data type");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            jx.m5221b(!this.VK, (Object) "All sessions already marked for deletion");
            jx.m5221b(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            jx.m5221b(z, (Object) "Must specify a session that has already ended");
            this.VI.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.LW > 0 && this.TO > this.LW;
            jx.m5217a(z2, "Must specify a valid time interval");
            z2 = (!this.VJ && this.VH.isEmpty() && this.TY.isEmpty()) ? false : true;
            boolean z3 = this.VK || !this.VI.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            jx.m5217a(z, "No data or session marked for deletion");
            jT();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            boolean z = this.TY.isEmpty() && this.VH.isEmpty();
            jx.m5222b(z, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", this.VH, this.TY);
            this.VJ = true;
            return this;
        }

        public Builder deleteAllSessions() {
            jx.m5222b(this.VI.isEmpty(), "Specific sessions already added for deletion: %s", this.VI);
            this.VK = true;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            jx.m5222b(j > 0, "Invalid start time :%d", Long.valueOf(j));
            jx.m5222b(j2 > j, "Invalid end time :%d", Long.valueOf(j2));
            this.LW = timeUnit.toMillis(j);
            this.TO = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new C0810d();
    }

    DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2) {
        this.CK = i;
        this.LW = j;
        this.TO = j2;
        this.VH = Collections.unmodifiableList(list);
        this.TY = Collections.unmodifiableList(list2);
        this.VI = list3;
        this.VJ = z;
        this.VK = z2;
    }

    private DataDeleteRequest(Builder builder) {
        this.CK = 1;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.VH = Collections.unmodifiableList(builder.VH);
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VI = Collections.unmodifiableList(builder.VI);
        this.VJ = builder.VJ;
        this.VK = builder.VK;
    }

    private boolean m2684a(DataDeleteRequest dataDeleteRequest) {
        return this.LW == dataDeleteRequest.LW && this.TO == dataDeleteRequest.TO && jv.equal(this.VH, dataDeleteRequest.VH) && jv.equal(this.TY, dataDeleteRequest.TY) && jv.equal(this.VI, dataDeleteRequest.VI) && this.VJ == dataDeleteRequest.VJ && this.VK == dataDeleteRequest.VK;
    }

    public boolean deleteAllData() {
        return this.VJ;
    }

    public boolean deleteAllSessions() {
        return this.VK;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && m2684a((DataDeleteRequest) obj));
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

    public List<Session> getSessions() {
        return this.VI;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean jR() {
        return this.VJ;
    }

    public boolean jS() {
        return this.VK;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("startTimeMillis", Long.valueOf(this.LW)).m5211a("endTimeMillis", Long.valueOf(this.TO)).m5211a("dataSources", this.VH).m5211a("dateTypes", this.TY).m5211a("sessions", this.VI).m5211a("deleteAllData", Boolean.valueOf(this.VJ)).m5211a("deleteAllSessions", Boolean.valueOf(this.VK)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0810d.m2752a(this, parcel, i);
    }
}
