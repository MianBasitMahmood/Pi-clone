package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.request.w */
public class C0835w implements SafeParcelable {
    public static final Creator<C0835w> CREATOR;
    private final int CK;
    private final Session TQ;

    /* renamed from: com.google.android.gms.fitness.request.w.a */
    public static class C0834a {
        private Session TQ;

        public C0834a m2774b(Session session) {
            jx.m5221b(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
            this.TQ = session;
            return this;
        }

        public C0835w kk() {
            return new C0835w();
        }
    }

    static {
        CREATOR = new C0836x();
    }

    C0835w(int i, Session session) {
        this.CK = i;
        this.TQ = session;
    }

    private C0835w(C0834a c0834a) {
        this.CK = 1;
        this.TQ = c0834a.TQ;
    }

    private boolean m2775a(C0835w c0835w) {
        return jv.equal(this.TQ, c0835w.TQ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0835w) && m2775a((C0835w) obj));
    }

    public Session getSession() {
        return this.TQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("session", this.TQ).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0836x.m2776a(this, parcel, i);
    }
}
