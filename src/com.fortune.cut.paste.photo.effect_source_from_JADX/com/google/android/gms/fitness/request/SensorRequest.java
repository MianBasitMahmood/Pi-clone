package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;
    private final long VZ;
    private final long Wa;
    private final LocationRequest We;
    private final long Wf;

    public static class Builder {
        private DataType TM;
        private DataSource TN;
        private long UQ;
        private int UR;
        private long VZ;
        private long Wa;
        private long Wf;
        private boolean Wg;

        public Builder() {
            this.UQ = -1;
            this.Wa = 0;
            this.VZ = 0;
            this.Wg = false;
            this.UR = SensorRequest.ACCURACY_MODE_DEFAULT;
            this.Wf = Long.MAX_VALUE;
        }

        public SensorRequest build() {
            boolean z = false;
            boolean z2 = (this.TN == null && this.TM == null) ? false : true;
            jx.m5217a(z2, "Must call setDataSource() or setDataType()");
            if (this.TM == null || this.TN == null || this.TM.equals(this.TN.getDataType())) {
                z = true;
            }
            jx.m5217a(z, "Specified data type is incompatible with specified data source");
            return new SensorRequest();
        }

        public Builder setAccuracyMode(int i) {
            this.UR = SensorRequest.dl(i);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public Builder setFastestRate(int i, TimeUnit timeUnit) {
            jx.m5221b(i >= 0, (Object) "Cannot use a negative interval");
            this.Wg = true;
            this.Wa = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setMaxDeliveryLatency(int i, TimeUnit timeUnit) {
            jx.m5221b(i >= 0, (Object) "Cannot use a negative delivery interval");
            this.VZ = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setSamplingRate(long j, TimeUnit timeUnit) {
            jx.m5221b(j >= 0, (Object) "Cannot use a negative sampling interval");
            this.UQ = timeUnit.toMicros(j);
            if (!this.Wg) {
                this.Wa = this.UQ / 2;
            }
            return this;
        }

        public Builder setTimeout(long j, TimeUnit timeUnit) {
            boolean z = true;
            boolean z2 = j > 0;
            Object[] objArr = new Object[SensorRequest.ACCURACY_MODE_LOW];
            objArr[0] = Long.valueOf(j);
            jx.m5222b(z2, "Invalid time out value specified: %d", objArr);
            if (timeUnit == null) {
                z = false;
            }
            jx.m5221b(z, (Object) "Invalid time unit specified");
            this.Wf = timeUnit.toMicros(j);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.We = locationRequest;
        this.UQ = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.Wa = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.VZ = this.UQ;
        this.TM = dataSource.getDataType();
        this.UR = m2711a(locationRequest);
        this.TN = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.Wf = Long.MAX_VALUE;
        } else {
            this.Wf = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.TN = builder.TN;
        this.TM = builder.TM;
        this.UQ = builder.UQ;
        this.Wa = builder.Wa;
        this.VZ = builder.VZ;
        this.UR = builder.UR;
        this.We = null;
        this.Wf = builder.Wf;
    }

    private static int m2711a(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                return ACCURACY_MODE_HIGH;
            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                return ACCURACY_MODE_LOW;
            default:
                return ACCURACY_MODE_DEFAULT;
        }
    }

    private boolean m2712a(SensorRequest sensorRequest) {
        return jv.equal(this.TN, sensorRequest.TN) && jv.equal(this.TM, sensorRequest.TM) && this.UQ == sensorRequest.UQ && this.Wa == sensorRequest.Wa && this.VZ == sensorRequest.VZ && this.UR == sensorRequest.UR && jv.equal(this.We, sensorRequest.We) && this.Wf == sensorRequest.Wf;
    }

    public static int dl(int i) {
        switch (i) {
            case ACCURACY_MODE_LOW /*1*/:
            case ACCURACY_MODE_HIGH /*3*/:
                return i;
            default:
                return ACCURACY_MODE_DEFAULT;
        }
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRequest) && m2712a((SensorRequest) obj));
    }

    public int getAccuracyMode() {
        return this.UR;
    }

    public DataSource getDataSource() {
        return this.TN;
    }

    public DataType getDataType() {
        return this.TM;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.Wa, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.VZ, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.UQ, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return jv.hashCode(this.TN, this.TM, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.We, Long.valueOf(this.Wf));
    }

    public long kh() {
        return this.Wf;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("dataSource", this.TN).m5211a("dataType", this.TM).m5211a("samplingRateMicros", Long.valueOf(this.UQ)).m5211a("deliveryLatencyMicros", Long.valueOf(this.VZ)).m5211a("timeOutMicros", Long.valueOf(this.Wf)).toString();
    }
}
