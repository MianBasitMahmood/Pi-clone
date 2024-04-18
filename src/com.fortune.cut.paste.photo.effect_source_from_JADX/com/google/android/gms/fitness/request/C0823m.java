package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.m */
public class C0823m implements SafeParcelable {
    public static final Creator<C0823m> CREATOR;
    private final int CK;
    private final DataType TM;

    /* renamed from: com.google.android.gms.fitness.request.m.a */
    public static class C0822a {
        private DataType TM;

        public C0822a m2763c(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public C0823m ka() {
            return new C0823m();
        }
    }

    static {
        CREATOR = new C0824n();
    }

    C0823m(int i, DataType dataType) {
        this.CK = i;
        this.TM = dataType;
    }

    private C0823m(C0822a c0822a) {
        this.CK = 1;
        this.TM = c0822a.TM;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.TM;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0824n.m2764a(this, parcel, i);
    }
}
