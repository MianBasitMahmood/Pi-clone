package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.DataEvent;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR;
    private final int CK;
    private final int UE;
    private boolean US;
    private float UT;

    static {
        CREATOR = new C0790u();
    }

    Value(int i) {
        this(1, i, false, 0.0f);
    }

    Value(int i, int i2, boolean z, float f) {
        this.CK = i;
        this.UE = i2;
        this.US = z;
        this.UT = f;
    }

    private boolean m2651a(Value value) {
        if (this.UE != value.UE || this.US != value.US) {
            return false;
        }
        switch (this.UE) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return asInt() == value.asInt();
            case DataEvent.TYPE_DELETED /*2*/:
                return asFloat() == value.asFloat();
            default:
                return this.UT == value.UT;
        }
    }

    public final String asActivity() {
        try {
            return FitnessActivities.getName(asInt());
        } catch (IllegalArgumentException e) {
            return FitnessActivities.UNKNOWN;
        }
    }

    public final float asFloat() {
        jx.m5217a(this.UE == 2, "Value is not in float format");
        return this.UT;
    }

    public final int asInt() {
        boolean z = true;
        if (this.UE != 1) {
            z = false;
        }
        jx.m5217a(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.UT);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && m2651a((Value) obj));
    }

    public final int getFormat() {
        return this.UE;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(Float.valueOf(this.UT), Integer.valueOf(this.UE), Boolean.valueOf(this.US));
    }

    public final boolean isSet() {
        return this.US;
    }

    final float jL() {
        return this.UT;
    }

    public final void setActivity(String str) {
        setInt(FitnessActivities.bs(str));
    }

    public final void setFloat(float f) {
        jx.m5217a(this.UE == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.US = true;
        this.UT = f;
    }

    public final void setInt(int i) {
        jx.m5217a(this.UE == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.US = true;
        this.UT = Float.intBitsToFloat(i);
    }

    public final String toString() {
        if (!this.US) {
            return "unset";
        }
        switch (this.UE) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return Integer.toString(asInt());
            case DataEvent.TYPE_DELETED /*2*/:
                return Float.toString(asFloat());
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0790u.m2676a(this, parcel, i);
    }
}
