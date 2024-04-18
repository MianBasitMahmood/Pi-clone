package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0776k;
import com.google.android.gms.fitness.data.C0776k.C0778a;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.request.o */
public class C0825o implements SafeParcelable {
    public static final Creator<C0825o> CREATOR;
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;
    private C0776k VW;
    int VX;
    int VY;
    private final long VZ;
    private final long Wa;
    private final List<LocationRequest> Wb;
    private final long Wc;
    private final List Wd;
    private final PendingIntent mPendingIntent;

    static {
        CREATOR = new C0826p();
    }

    C0825o(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4) {
        this.CK = i;
        this.TN = dataSource;
        this.TM = dataType;
        this.VW = iBinder == null ? null : C0778a.aq(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.UQ = j;
        this.Wa = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.VZ = j2;
        this.Wb = list;
        this.mPendingIntent = pendingIntent;
        this.UR = i4;
        this.Wd = Collections.emptyList();
        this.Wc = j4;
    }

    private C0825o(DataSource dataSource, DataType dataType, C0776k c0776k, PendingIntent pendingIntent, long j, long j2, long j3, int i, List list, List list2, long j4) {
        this.CK = 4;
        this.TN = dataSource;
        this.TM = dataType;
        this.VW = c0776k;
        this.mPendingIntent = pendingIntent;
        this.UQ = j;
        this.Wa = j2;
        this.VZ = j3;
        this.UR = i;
        this.Wb = list;
        this.Wd = list2;
        this.Wc = j4;
    }

    public C0825o(SensorRequest sensorRequest, C0776k c0776k, PendingIntent pendingIntent) {
        C0776k c0776k2 = c0776k;
        PendingIntent pendingIntent2 = pendingIntent;
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), c0776k2, pendingIntent2, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.kh());
    }

    private boolean m2765a(C0825o c0825o) {
        return jv.equal(this.TN, c0825o.TN) && jv.equal(this.TM, c0825o.TM) && this.UQ == c0825o.UQ && this.Wa == c0825o.Wa && this.VZ == c0825o.VZ && this.UR == c0825o.UR && jv.equal(this.Wb, c0825o.Wb);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof C0825o) && m2765a((C0825o) obj));
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

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TN, this.TM, this.VW, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.Wb);
    }

    public long jI() {
        return this.UQ;
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    public long kc() {
        return this.Wa;
    }

    public long kd() {
        return this.VZ;
    }

    public List<LocationRequest> ke() {
        return this.Wb;
    }

    public long kf() {
        return this.Wc;
    }

    IBinder kg() {
        return this.VW == null ? null : this.VW.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.TM, this.TN, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0826p.m2766a(this, parcel, i);
    }
}
