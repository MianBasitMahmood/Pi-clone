package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.fitness.request.e */
public class C0813e implements SafeParcelable {
    public static final Creator<C0813e> CREATOR;
    private final int CK;
    private final DataSet UP;

    /* renamed from: com.google.android.gms.fitness.request.e.a */
    public static class C0812a {
        private DataSet UP;

        public C0812a m2754b(DataSet dataSet) {
            this.UP = dataSet;
            return this;
        }

        public C0813e jU() {
            boolean z = true;
            jx.m5217a(this.UP != null, "Must set the data set");
            jx.m5217a(!this.UP.getDataPoints().isEmpty(), "Cannot use an empty data set");
            if (this.UP.getDataSource().jx() == null) {
                z = false;
            }
            jx.m5217a(z, "Must set the app package name for the data source");
            return new C0813e();
        }
    }

    static {
        CREATOR = new C0814f();
    }

    C0813e(int i, DataSet dataSet) {
        this.CK = i;
        this.UP = dataSet;
    }

    private C0813e(C0812a c0812a) {
        this.CK = 1;
        this.UP = c0812a.UP;
    }

    private boolean m2755a(C0813e c0813e) {
        return jv.equal(this.UP, c0813e.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0813e) && m2755a((C0813e) obj));
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0814f.m2756a(this, parcel, i);
    }
}
