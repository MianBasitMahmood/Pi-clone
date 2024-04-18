package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0786q;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final List<Session> VI;
    private final List<C0786q> Wv;

    static {
        CREATOR = new C0846f();
    }

    SessionReadResult(int i, List<Session> list, List<C0786q> list2, Status status) {
        this.CK = i;
        this.VI = list;
        this.Wv = Collections.unmodifiableList(list2);
        this.Eb = status;
    }

    public SessionReadResult(List<Session> list, List<C0786q> list2, Status status) {
        this.CK = 3;
        this.VI = list;
        this.Wv = Collections.unmodifiableList(list2);
        this.Eb = status;
    }

    public static SessionReadResult m2794G(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean m2795b(SessionReadResult sessionReadResult) {
        return this.Eb.equals(sessionReadResult.Eb) && jv.equal(this.VI, sessionReadResult.VI) && jv.equal(this.Wv, sessionReadResult.Wv);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && m2795b((SessionReadResult) obj));
    }

    public List<DataSet> getDataSet(Session session) {
        jx.m5222b(this.VI.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (C0786q c0786q : this.Wv) {
            if (jv.equal(session, c0786q.getSession())) {
                arrayList.add(c0786q.jH());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        jx.m5222b(this.VI.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (C0786q c0786q : this.Wv) {
            if (jv.equal(session, c0786q.getSession()) && dataType.equals(c0786q.jH().getDataType())) {
                arrayList.add(c0786q.jH());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.VI;
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.VI, this.Wv);
    }

    public List<C0786q> kv() {
        return this.Wv;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("sessions", this.VI).m5211a("sessionDataSets", this.Wv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0846f.m2803a(this, parcel, i);
    }
}
