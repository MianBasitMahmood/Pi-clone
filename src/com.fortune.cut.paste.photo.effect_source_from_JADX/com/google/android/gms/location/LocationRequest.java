package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class LocationRequest implements SafeParcelable {
    public static final C1508d CREATOR;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private final int CK;
    boolean Wg;
    long age;
    long agr;
    long ags;
    int agt;
    float agu;
    long agv;
    int mPriority;

    static {
        CREATOR = new C1508d();
    }

    public LocationRequest() {
        this.CK = 1;
        this.mPriority = PRIORITY_BALANCED_POWER_ACCURACY;
        this.agr = 3600000;
        this.ags = 600000;
        this.Wg = false;
        this.age = Long.MAX_VALUE;
        this.agt = Integer.MAX_VALUE;
        this.agu = 0.0f;
        this.agv = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.CK = i;
        this.mPriority = i2;
        this.agr = j;
        this.ags = j2;
        this.Wg = z;
        this.age = j3;
        this.agt = i3;
        this.agu = f;
        this.agv = j4;
    }

    private static void m6087a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void ey(int i) {
        switch (i) {
            case PRIORITY_HIGH_ACCURACY /*100*/:
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String ez(int i) {
        switch (i) {
            case PRIORITY_HIGH_ACCURACY /*100*/:
                return "PRIORITY_HIGH_ACCURACY";
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    private static void m6088v(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.agr == locationRequest.agr && this.ags == locationRequest.ags && this.Wg == locationRequest.Wg && this.age == locationRequest.age && this.agt == locationRequest.agt && this.agu == locationRequest.agu;
    }

    public final long getExpirationTime() {
        return this.age;
    }

    public final long getFastestInterval() {
        return this.ags;
    }

    public final long getInterval() {
        return this.agr;
    }

    public final int getNumUpdates() {
        return this.agt;
    }

    public final int getPriority() {
        return this.mPriority;
    }

    public final float getSmallestDisplacement() {
        return this.agu;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.agr), Long.valueOf(this.ags), Boolean.valueOf(this.Wg), Long.valueOf(this.age), Integer.valueOf(this.agt), Float.valueOf(this.agu));
    }

    public final LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.age = Long.MAX_VALUE;
        } else {
            this.age = elapsedRealtime + j;
        }
        if (this.age < 0) {
            this.age = 0;
        }
        return this;
    }

    public final LocationRequest setExpirationTime(long j) {
        this.age = j;
        if (this.age < 0) {
            this.age = 0;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long j) {
        m6088v(j);
        this.Wg = true;
        this.ags = j;
        return this;
    }

    public final LocationRequest setInterval(long j) {
        m6088v(j);
        this.agr = j;
        if (!this.Wg) {
            this.ags = (long) (((double) this.agr) / 6.0d);
        }
        return this;
    }

    public final LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.agt = i;
        return this;
    }

    public final LocationRequest setPriority(int i) {
        ey(i);
        this.mPriority = i;
        return this;
    }

    public final LocationRequest setSmallestDisplacement(float f) {
        m6087a(f);
        this.agu = f;
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(ez(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.agr + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.ags + "ms");
        if (this.age != Long.MAX_VALUE) {
            long elapsedRealtime = this.age - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.agt != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.agt);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1508d.m6093a(this, parcel, i);
    }
}
