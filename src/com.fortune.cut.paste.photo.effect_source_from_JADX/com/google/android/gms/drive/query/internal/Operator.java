package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR;
    public static final Operator SA;
    public static final Operator SB;
    public static final Operator SC;
    public static final Operator SD;
    public static final Operator SE;
    public static final Operator Sw;
    public static final Operator Sx;
    public static final Operator Sy;
    public static final Operator Sz;
    final int CK;
    final String mTag;

    static {
        CREATOR = new C0684l();
        Sw = new Operator("=");
        Sx = new Operator("<");
        Sy = new Operator("<=");
        Sz = new Operator(">");
        SA = new Operator(">=");
        SB = new Operator("and");
        SC = new Operator("or");
        SD = new Operator("not");
        SE = new Operator("contains");
    }

    Operator(int i, String str) {
        this.CK = i;
        this.mTag = str;
    }

    private Operator(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0684l.m2434a(this, parcel, i);
    }
}
