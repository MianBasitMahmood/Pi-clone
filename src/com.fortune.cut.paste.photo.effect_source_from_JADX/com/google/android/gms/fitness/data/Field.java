package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR;
    public static final Field FIELD_ACCURACY;
    public static final Field FIELD_ACTIVITY;
    public static final Field FIELD_ALTITUDE;
    public static final Field FIELD_AVERAGE;
    public static final Field FIELD_BPM;
    public static final Field FIELD_CALORIES;
    public static final Field FIELD_CONFIDENCE;
    public static final Field FIELD_DISTANCE;
    public static final Field FIELD_DURATION;
    public static final Field FIELD_HEIGHT;
    public static final Field FIELD_HIGH_LATITUDE;
    public static final Field FIELD_HIGH_LONGITUDE;
    public static final Field FIELD_LATITUDE;
    public static final Field FIELD_LONGITUDE;
    public static final Field FIELD_LOW_LATITUDE;
    public static final Field FIELD_LOW_LONGITUDE;
    public static final Field FIELD_MAX;
    public static final Field FIELD_MIN;
    public static final Field FIELD_NUM_SEGMENTS;
    public static final Field FIELD_REVOLUTIONS;
    public static final Field FIELD_RPM;
    public static final Field FIELD_SPEED;
    public static final Field FIELD_STEPS;
    public static final Field FIELD_WATTS;
    public static final Field FIELD_WEIGHT;
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final Field UA;
    public static final Field UB;
    public static final Field UC;
    public static final Field UD;
    private final int CK;
    private final int UE;
    private final String mName;

    static {
        FIELD_ACTIVITY = bu("activity");
        FIELD_CONFIDENCE = bv("confidence");
        FIELD_STEPS = bu("steps");
        FIELD_DURATION = bu("duration");
        FIELD_BPM = bv("bpm");
        FIELD_LATITUDE = bv("latitude");
        FIELD_LONGITUDE = bv("longitude");
        FIELD_ACCURACY = bv("accuracy");
        FIELD_ALTITUDE = bv("altitude");
        FIELD_DISTANCE = bv("distance");
        FIELD_HEIGHT = bv("height");
        FIELD_WEIGHT = bv("weight");
        FIELD_SPEED = bv("speed");
        FIELD_RPM = bv("rpm");
        FIELD_REVOLUTIONS = bu("revolutions");
        FIELD_CALORIES = bv("calories");
        FIELD_WATTS = bv("watts");
        FIELD_NUM_SEGMENTS = bu("num_segments");
        FIELD_AVERAGE = bv("average");
        FIELD_MAX = bv("max");
        FIELD_MIN = bv("min");
        FIELD_LOW_LATITUDE = bv("low_latitude");
        FIELD_LOW_LONGITUDE = bv("low_longitude");
        FIELD_HIGH_LATITUDE = bv("high_latitude");
        FIELD_HIGH_LONGITUDE = bv("high_longitude");
        UA = bu("edge_type");
        UB = bv("x");
        UC = bv("y");
        UD = bv("z");
        CREATOR = new C0775j();
    }

    Field(int i, String str, int i2) {
        this.CK = i;
        this.mName = (String) jx.m5223i(str);
        this.UE = i2;
    }

    public Field(String str, int i) {
        this(FORMAT_INT32, str, i);
    }

    private boolean m2632a(Field field) {
        return this.mName.equals(field.mName) && this.UE == field.UE;
    }

    private static Field bu(String str) {
        return new Field(str, FORMAT_INT32);
    }

    private static Field bv(String str) {
        return new Field(str, FORMAT_FLOAT);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Field) && m2632a((Field) obj));
    }

    public final int getFormat() {
        return this.UE;
    }

    public final String getName() {
        return this.mName;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return this.mName.hashCode();
    }

    public final String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[FORMAT_FLOAT];
        objArr[0] = this.mName;
        objArr[FORMAT_INT32] = this.UE == FORMAT_INT32 ? "i" : "f";
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0775j.m2661a(this, parcel, i);
    }
}
