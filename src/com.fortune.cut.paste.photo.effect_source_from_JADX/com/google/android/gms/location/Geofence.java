package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.nn;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String Zt;
        private int agd;
        private long age;
        private short agf;
        private double agg;
        private double agh;
        private float agi;
        private int agj;
        private int agk;

        public Builder() {
            this.Zt = null;
            this.agd = 0;
            this.age = Long.MIN_VALUE;
            this.agf = (short) -1;
            this.agj = 0;
            this.agk = -1;
        }

        public final Geofence build() {
            if (this.Zt == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.agd == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.agd & Geofence.GEOFENCE_TRANSITION_DWELL) != 0 && this.agk < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.age == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.agf == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.agj >= 0) {
                return new nn(this.Zt, this.agd, (short) 1, this.agg, this.agh, this.agi, this.age, this.agj, this.agk);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public final Builder setCircularRegion(double d, double d2, float f) {
            this.agf = (short) 1;
            this.agg = d;
            this.agh = d2;
            this.agi = f;
            return this;
        }

        public final Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.age = Geofence.NEVER_EXPIRE;
            } else {
                this.age = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public final Builder setLoiteringDelay(int i) {
            this.agk = i;
            return this;
        }

        public final Builder setNotificationResponsiveness(int i) {
            this.agj = i;
            return this;
        }

        public final Builder setRequestId(String str) {
            this.Zt = str;
            return this;
        }

        public final Builder setTransitionTypes(int i) {
            this.agd = i;
            return this;
        }
    }

    String getRequestId();
}
