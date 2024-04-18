package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 1, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentActionEntity.m2841a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kK();
    }

    public final Bundle getExtras() {
        return AppContentUtils.m2875d(this.JG, this.XX, "action_data", this.KZ);
    }

    public final String getLabel() {
        return getString("action_label");
    }

    public final String getType() {
        return getString("action_type");
    }

    public final int hashCode() {
        return AppContentActionEntity.m2840a(this);
    }

    public final List<AppContentCondition> kH() {
        return AppContentUtils.m2874c(this.JG, this.XX, "action_conditions", this.KZ);
    }

    public final String kI() {
        return getString("action_content_description");
    }

    public final String kJ() {
        return getString("action_label_style");
    }

    public final AppContentAction kK() {
        return new AppContentActionEntity(this);
    }

    public final String toString() {
        return AppContentActionEntity.m2842b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentActionEntity) kK()).writeToParcel(parcel, i);
    }
}
