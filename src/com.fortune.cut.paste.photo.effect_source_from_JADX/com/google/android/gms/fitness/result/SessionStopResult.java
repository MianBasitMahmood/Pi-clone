package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Creator<SessionStopResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final List<Session> VI;

    static {
        CREATOR = new C0847g();
    }

    SessionStopResult(int i, Status status, List<Session> list) {
        this.CK = i;
        this.Eb = status;
        this.VI = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List<Session> list) {
        this.CK = 3;
        this.Eb = status;
        this.VI = Collections.unmodifiableList(list);
    }

    public static SessionStopResult m2796H(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean m2797b(SessionStopResult sessionStopResult) {
        return this.Eb.equals(sessionStopResult.Eb) && jv.equal(this.VI, sessionStopResult.VI);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && m2797b((SessionStopResult) obj));
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
        return jv.hashCode(this.Eb, this.VI);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("sessions", this.VI).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0847g.m2804a(this, parcel, i);
    }
}
