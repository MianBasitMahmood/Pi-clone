package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR;
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> aga;
    private final int CK;
    int agb;
    int agc;

    /* renamed from: com.google.android.gms.location.DetectedActivity.1 */
    static class C15021 implements Comparator<DetectedActivity> {
        C15021() {
        }

        public final int m6083a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return m6083a((DetectedActivity) obj, (DetectedActivity) obj2);
        }
    }

    static {
        aga = new C15021();
        CREATOR = new DetectedActivityCreator();
    }

    public DetectedActivity(int i, int i2) {
        this.CK = ON_BICYCLE;
        this.agb = i;
        this.agc = i2;
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.CK = i;
        this.agb = i2;
        this.agc = i3;
    }

    private int ev(int i) {
        return i > 9 ? UNKNOWN : i;
    }

    public int describeContents() {
        return IN_VEHICLE;
    }

    public int getConfidence() {
        return this.agc;
    }

    public int getType() {
        return ev(this.agb);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.agc + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.m6084a(this, parcel, i);
    }
}
