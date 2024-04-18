package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR;
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;

    /* renamed from: com.google.android.gms.fitness.data.Subscription.a */
    public static class C0765a {
        private DataType TM;
        private DataSource TN;
        private long UQ;
        private int UR;

        public C0765a() {
            this.UQ = -1;
            this.UR = 2;
        }

        public C0765a m2648b(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public C0765a m2649b(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public Subscription jK() {
            boolean z = false;
            boolean z2 = (this.TN == null && this.TM == null) ? false : true;
            jx.m5217a(z2, "Must call setDataSource() or setDataType()");
            if (this.TM == null || this.TN == null || this.TM.equals(this.TN.getDataType())) {
                z = true;
            }
            jx.m5217a(z, "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    static {
        CREATOR = new C0788s();
    }

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.CK = i;
        this.TN = dataSource;
        this.TM = dataType;
        this.UQ = j;
        this.UR = i2;
    }

    private Subscription(C0765a c0765a) {
        this.CK = 1;
        this.TM = c0765a.TM;
        this.TN = c0765a.TN;
        this.UQ = c0765a.UQ;
        this.UR = c0765a.UR;
    }

    private boolean m2650a(Subscription subscription) {
        return jv.equal(this.TN, subscription.TN) && jv.equal(this.TM, subscription.TM) && this.UQ == subscription.UQ && this.UR == subscription.UR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && m2650a((Subscription) obj));
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
        return jv.hashCode(this.TN, this.TN, Long.valueOf(this.UQ), Integer.valueOf(this.UR));
    }

    public long jI() {
        return this.UQ;
    }

    public DataType jJ() {
        return this.TM == null ? this.TN.getDataType() : this.TM;
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.TN == null ? this.TM.getName() : this.TN.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("dataSource", this.TN).m5211a("dataType", this.TM).m5211a("samplingIntervalMicros", Long.valueOf(this.UQ)).m5211a("accuracyMode", Integer.valueOf(this.UR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0788s.m2674a(this, parcel, i);
    }
}
