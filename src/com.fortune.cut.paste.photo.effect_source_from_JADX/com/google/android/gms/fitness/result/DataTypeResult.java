package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final DataType TM;

    static {
        CREATOR = new C0844d();
    }

    DataTypeResult(int i, Status status, DataType dataType) {
        this.CK = i;
        this.Eb = status;
        this.TM = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.CK = 2;
        this.Eb = status;
        this.TM = dataType;
    }

    public static DataTypeResult m2790E(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean m2791b(DataTypeResult dataTypeResult) {
        return this.Eb.equals(dataTypeResult.Eb) && jv.equal(this.TM, dataTypeResult.TM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && m2791b((DataTypeResult) obj));
    }

    public DataType getDataType() {
        return this.TM;
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.TM);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("dataType", this.TM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0844d.m2801a(this, parcel, i);
    }
}
