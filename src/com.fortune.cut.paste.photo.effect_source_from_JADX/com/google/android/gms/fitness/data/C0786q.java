package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.data.q */
public class C0786q implements SafeParcelable {
    public static final Creator<C0786q> CREATOR;
    final int CK;
    private final Session TQ;
    private final DataSet UP;

    static {
        CREATOR = new C0787r();
    }

    C0786q(int i, Session session, DataSet dataSet) {
        this.CK = i;
        this.TQ = session;
        this.UP = dataSet;
    }

    private boolean m2672a(C0786q c0786q) {
        return jv.equal(this.TQ, c0786q.TQ) && jv.equal(this.UP, c0786q.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0786q) && m2672a((C0786q) obj));
    }

    public Session getSession() {
        return this.TQ;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ, this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("session", this.TQ).m5211a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0787r.m2673a(this, parcel, i);
    }
}
