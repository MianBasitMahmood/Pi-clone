package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 4, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentConditionEntity.m2853a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kX();
    }

    public final int hashCode() {
        return AppContentConditionEntity.m2852a(this);
    }

    public final String kT() {
        return getString("condition_default_value");
    }

    public final String kU() {
        return getString("condition_expected_value");
    }

    public final String kV() {
        return getString("condition_predicate");
    }

    public final Bundle kW() {
        return AppContentUtils.m2875d(this.JG, this.XX, "condition_predicate_parameters", this.KZ);
    }

    public final AppContentCondition kX() {
        return new AppContentConditionEntity(this);
    }

    public final String toString() {
        return AppContentConditionEntity.m2854b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentConditionEntity) kX()).writeToParcel(parcel, i);
    }
}
