package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.C0543c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR;
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final int CK;
    private final long LW;
    private final long TO;
    private final int TZ;
    private final String UN;
    private final String UO;
    private final C0766a Um;
    private final String mName;

    public static class Builder {
        private long LW;
        private long TO;
        private int TZ;
        private String UN;
        private String UO;
        private C0766a Um;
        private String mName;

        public Builder() {
            this.LW = 0;
            this.TO = 0;
            this.mName = null;
            this.TZ = 4;
        }

        public Session build() {
            boolean z = false;
            jx.m5217a(this.LW > 0, "Start time should be specified.");
            if (this.TO == 0 || this.TO > this.LW) {
                z = true;
            }
            jx.m5217a(z, "End time should be later than start time.");
            if (this.UN == null) {
                this.UN = (this.mName == null ? "" : this.mName) + this.LW;
            }
            return new Session();
        }

        public Builder cV(int i) {
            this.TZ = i;
            return this;
        }

        public Builder setActivity(String str) {
            return cV(FitnessActivities.bs(str));
        }

        public Builder setDescription(String str) {
            jx.m5222b(str.length() <= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, "Session description cannot exceed %d characters", Integer.valueOf(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            this.UO = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            jx.m5217a(j >= 0, "End time should be positive.");
            this.TO = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            boolean z = str != null && TextUtils.getTrimmedLength(str) > 0;
            jx.m5216L(z);
            this.UN = str;
            return this;
        }

        public Builder setName(String str) {
            jx.m5222b(str.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            jx.m5217a(j > 0, "Start time should be positive.");
            this.LW = timeUnit.toMillis(j);
            return this;
        }
    }

    static {
        CREATOR = new C0785p();
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, C0766a c0766a) {
        this.CK = i;
        this.LW = j;
        this.TO = j2;
        this.mName = str;
        this.UN = str2;
        this.UO = str3;
        this.TZ = i2;
        this.Um = c0766a;
    }

    private Session(Builder builder) {
        this.CK = 2;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.mName = builder.mName;
        this.UN = builder.UN;
        this.UO = builder.UO;
        this.TZ = builder.TZ;
        this.Um = builder.Um;
    }

    private boolean m2643a(Session session) {
        return this.LW == session.LW && this.TO == session.TO && jv.equal(this.mName, session.mName) && jv.equal(this.UN, session.UN) && jv.equal(this.UO, session.UO) && jv.equal(this.Um, session.Um) && this.TZ == session.TZ;
    }

    public static Session extract(Intent intent) {
        return intent == null ? null : (Session) C0543c.m1983a(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        return new StringBuilder(MIME_TYPE_PREFIX).append(str).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && m2643a((Session) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.TZ);
    }

    public String getAppPackageName() {
        return this.Um == null ? null : this.Um.getPackageName();
    }

    public String getDescription() {
        return this.UO;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.UN;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO), this.UN);
    }

    public boolean isOngoing() {
        return this.TO == 0;
    }

    public int jm() {
        return this.TZ;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public C0766a jx() {
        return this.Um;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("startTime", Long.valueOf(this.LW)).m5211a("endTime", Long.valueOf(this.TO)).m5211a("name", this.mName).m5211a("identifier", this.UN).m5211a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.UO).m5211a("activity", Integer.valueOf(this.TZ)).m5211a("application", this.Um).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0785p.m2671a(this, parcel, i);
    }
}
