package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class aj implements SafeParcelable {
    public static final Creator<aj> CREATOR;
    private final int CK;
    private final DataType TM;
    private final DataSource TN;

    /* renamed from: com.google.android.gms.fitness.request.aj.a */
    public static class C0807a {
        private DataType TM;
        private DataSource TN;

        public C0807a m2747d(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        public C0807a m2748d(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public aj kq() {
            if (this.TM == null || this.TN == null) {
                return new aj();
            }
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
        }
    }

    static {
        CREATOR = new ak();
    }

    aj(int i, DataType dataType, DataSource dataSource) {
        this.CK = i;
        this.TM = dataType;
        this.TN = dataSource;
    }

    private aj(C0807a c0807a) {
        this.CK = 1;
        this.TM = c0807a.TM;
        this.TN = c0807a.TN;
    }

    private boolean m2749a(aj ajVar) {
        return jv.equal(this.TN, ajVar.TN) && jv.equal(this.TM, ajVar.TM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof aj) && m2749a((aj) obj));
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
        return jv.hashCode(this.TN, this.TM);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ak.m2750a(this, parcel, i);
    }
}
