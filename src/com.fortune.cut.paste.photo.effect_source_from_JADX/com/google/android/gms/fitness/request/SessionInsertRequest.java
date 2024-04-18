package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR;
    private final int CK;
    private final Session TQ;
    private final List<DataSet> Ua;
    private final List<DataPoint> Wh;

    public static class Builder {
        private Session TQ;
        private List<DataSet> Ua;
        private List<DataPoint> Wh;
        private List<DataSource> Wi;

        public Builder() {
            this.Ua = new ArrayList();
            this.Wh = new ArrayList();
            this.Wi = new ArrayList();
        }

        private void m2716d(DataPoint dataPoint) {
            m2718f(dataPoint);
            m2717e(dataPoint);
        }

        private void m2717e(DataPoint dataPoint) {
            long startTime = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = lt.m5345a(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = startTime2 >= startTime && endTime2 <= endTime;
                jx.m5218a(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void m2718f(DataPoint dataPoint) {
            long startTime = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = lt.m5345a(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = timestamp >= startTime && timestamp <= endTime;
                jx.m5218a(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void ki() {
            for (DataSet dataPoints : this.Ua) {
                for (DataPoint d : dataPoints.getDataPoints()) {
                    m2716d(d);
                }
            }
            for (DataPoint d2 : this.Wh) {
                m2716d(d2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            jx.m5221b(dataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTime = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            boolean z = startTime > 0 && dataPoint.getEndTime(TimeUnit.NANOSECONDS) > startTime;
            jx.m5222b(z, "Aggregate data point should have valid start and end times: %s", dataPoint);
            DataSource dataSource = dataPoint.getDataSource();
            jx.m5218a(!this.Wi.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.Wi.add(dataSource);
            this.Wh.add(dataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            jx.m5221b(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            jx.m5218a(!this.Wi.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            jx.m5221b(z, (Object) "No data points specified in the input data set.");
            this.Wi.add(dataSource);
            this.Ua.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            jx.m5217a(this.TQ != null, "Must specify a valid session.");
            if (this.TQ.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            jx.m5217a(z, "Must specify a valid end time, cannot insert a continuing session.");
            ki();
            return new SessionInsertRequest();
        }

        public Builder setSession(Session session) {
            this.TQ = session;
            return this;
        }
    }

    static {
        CREATOR = new C0829s();
    }

    SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2) {
        this.CK = i;
        this.TQ = session;
        this.Ua = Collections.unmodifiableList(list);
        this.Wh = Collections.unmodifiableList(list2);
    }

    private SessionInsertRequest(Builder builder) {
        this.CK = 1;
        this.TQ = builder.TQ;
        this.Ua = Collections.unmodifiableList(builder.Ua);
        this.Wh = Collections.unmodifiableList(builder.Wh);
    }

    private boolean m2719a(SessionInsertRequest sessionInsertRequest) {
        return jv.equal(this.TQ, sessionInsertRequest.TQ) && jv.equal(this.Ua, sessionInsertRequest.Ua) && jv.equal(this.Wh, sessionInsertRequest.Wh);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && m2719a((SessionInsertRequest) obj));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.Wh;
    }

    public List<DataSet> getDataSets() {
        return this.Ua;
    }

    public Session getSession() {
        return this.TQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ, this.Ua, this.Wh);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("session", this.TQ).m5211a("dataSets", this.Ua).m5211a("aggregateDataPoints", this.Wh).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0829s.m2768a(this, parcel, i);
    }
}
