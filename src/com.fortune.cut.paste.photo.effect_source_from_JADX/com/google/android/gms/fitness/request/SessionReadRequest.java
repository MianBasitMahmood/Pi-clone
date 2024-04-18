package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR;
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final List<DataSource> VH;
    private final boolean VR;
    private final String Wj;
    private boolean Wk;
    private final List<String> Wl;
    private final String vZ;

    public static class Builder {
        private long LW;
        private long TO;
        private List<DataType> TY;
        private List<DataSource> VH;
        private boolean VR;
        private String Wj;
        private boolean Wk;
        private List<String> Wl;
        private String vZ;

        public Builder() {
            this.LW = 0;
            this.TO = 0;
            this.TY = new ArrayList();
            this.VH = new ArrayList();
            this.Wk = false;
            this.VR = false;
            this.Wl = new ArrayList();
        }

        public SessionReadRequest build() {
            jx.m5222b(this.LW > 0, "Invalid start time: %s", Long.valueOf(this.LW));
            boolean z = this.TO > 0 && this.TO > this.LW;
            jx.m5222b(z, "Invalid end time: %s", Long.valueOf(this.TO));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.VR = true;
            return this;
        }

        public Builder excludePackage(String str) {
            jx.m5219b((Object) str, (Object) "Attempting to use a null package name");
            if (!this.Wl.contains(str)) {
                this.Wl.add(str);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            jx.m5219b((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            jx.m5219b((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.Wk = true;
            return this;
        }

        public Builder setSessionId(String str) {
            this.vZ = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.Wj = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.LW = timeUnit.toMillis(j);
            this.TO = timeUnit.toMillis(j2);
            return this;
        }
    }

    static {
        CREATOR = new C0830t();
    }

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3) {
        this.CK = i;
        this.Wj = str;
        this.vZ = str2;
        this.LW = j;
        this.TO = j2;
        this.TY = Collections.unmodifiableList(list);
        this.VH = Collections.unmodifiableList(list2);
        this.Wk = z;
        this.VR = z2;
        this.Wl = list3;
    }

    private SessionReadRequest(Builder builder) {
        this.CK = 3;
        this.Wj = builder.Wj;
        this.vZ = builder.vZ;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VH = Collections.unmodifiableList(builder.VH);
        this.Wk = builder.Wk;
        this.VR = builder.VR;
        this.Wl = Collections.unmodifiableList(builder.Wl);
    }

    private boolean m2729a(SessionReadRequest sessionReadRequest) {
        return jv.equal(this.Wj, sessionReadRequest.Wj) && this.vZ.equals(sessionReadRequest.vZ) && this.LW == sessionReadRequest.LW && this.TO == sessionReadRequest.TO && jv.equal(this.TY, sessionReadRequest.TY) && jv.equal(this.VH, sessionReadRequest.VH) && this.Wk == sessionReadRequest.Wk && this.Wl.equals(sessionReadRequest.Wl) && this.VR == sessionReadRequest.VR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && m2729a((SessionReadRequest) obj));
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

    public List<String> getExcludedPackages() {
        return this.Wl;
    }

    public String getSessionId() {
        return this.vZ;
    }

    public String getSessionName() {
        return this.Wj;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Wj, this.vZ, Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean includeSessionsFromAllApps() {
        return this.Wk;
    }

    public boolean jV() {
        return this.VR;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public boolean kj() {
        return this.Wk;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("sessionName", this.Wj).m5211a("sessionId", this.vZ).m5211a("startTimeMillis", Long.valueOf(this.LW)).m5211a("endTimeMillis", Long.valueOf(this.TO)).m5211a("dataTypes", this.TY).m5211a("dataSources", this.VH).m5211a("sessionsFromAllApps", Boolean.valueOf(this.Wk)).m5211a("excludedPackages", this.Wl).m5211a("useServer", Boolean.valueOf(this.VR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0830t.m2769a(this, parcel, i);
    }
}
