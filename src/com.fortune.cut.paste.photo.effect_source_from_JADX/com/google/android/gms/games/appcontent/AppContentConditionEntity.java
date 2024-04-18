package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR;
    private final int CK;
    private final String XT;
    private final String XU;
    private final String XV;
    private final Bundle XW;

    static {
        CREATOR = new AppContentConditionEntityCreator();
    }

    AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.CK = i;
        this.XT = str;
        this.XU = str2;
        this.XV = str3;
        this.XW = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.CK = 1;
        this.XT = appContentCondition.kT();
        this.XU = appContentCondition.kT();
        this.XV = appContentCondition.kV();
        this.XW = appContentCondition.kW();
    }

    static int m2852a(AppContentCondition appContentCondition) {
        return jv.hashCode(appContentCondition.kT(), appContentCondition.kU(), appContentCondition.kV(), appContentCondition.kW());
    }

    static boolean m2853a(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return jv.equal(appContentCondition2.kT(), appContentCondition.kT()) && jv.equal(appContentCondition2.kU(), appContentCondition.kU()) && jv.equal(appContentCondition2.kV(), appContentCondition.kV()) && jv.equal(appContentCondition2.kW(), appContentCondition.kW());
    }

    static String m2854b(AppContentCondition appContentCondition) {
        return jv.m5212h(appContentCondition).m5211a("DefaultValue", appContentCondition.kT()).m5211a("ExpectedValue", appContentCondition.kU()).m5211a("Predicate", appContentCondition.kV()).m5211a("PredicateParameters", appContentCondition.kW()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2853a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kX();
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2852a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String kT() {
        return this.XT;
    }

    public final String kU() {
        return this.XU;
    }

    public final String kV() {
        return this.XV;
    }

    public final Bundle kW() {
        return this.XW;
    }

    public final AppContentCondition kX() {
        return this;
    }

    public final String toString() {
        return m2854b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppContentConditionEntityCreator.m2855a(this, parcel, i);
    }
}
