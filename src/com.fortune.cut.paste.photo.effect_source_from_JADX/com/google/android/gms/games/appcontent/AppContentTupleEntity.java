package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR;
    private final int CK;
    private final String mName;
    private final String mValue;

    static {
        CREATOR = new AppContentTupleEntityCreator();
    }

    AppContentTupleEntity(int i, String str, String str2) {
        this.CK = i;
        this.mName = str;
        this.mValue = str2;
    }

    public AppContentTupleEntity(AppContentTuple appContentTuple) {
        this.CK = 1;
        this.mName = appContentTuple.getName();
        this.mValue = appContentTuple.getValue();
    }

    static int m2862a(AppContentTuple appContentTuple) {
        return jv.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean m2863a(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return jv.equal(appContentTuple2.getName(), appContentTuple.getName()) && jv.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String m2864b(AppContentTuple appContentTuple) {
        return jv.m5212h(appContentTuple).m5211a("Name", appContentTuple.getName()).m5211a("Value", appContentTuple.getValue()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2863a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return ld();
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2862a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final AppContentTuple ld() {
        return this;
    }

    public final String toString() {
        return m2864b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentTupleEntityCreator.m2865a(this, parcel, i);
    }
}
