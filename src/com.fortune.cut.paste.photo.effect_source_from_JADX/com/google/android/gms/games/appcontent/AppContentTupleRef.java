package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

public final class AppContentTupleRef extends C0451d implements AppContentTuple {
    AppContentTupleRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentTupleEntity.m2863a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return ld();
    }

    public final String getName() {
        return getString("tuple_name");
    }

    public final String getValue() {
        return getString("tuple_value");
    }

    public final int hashCode() {
        return AppContentTupleEntity.m2862a(this);
    }

    public final AppContentTuple ld() {
        return new AppContentTupleEntity(this);
    }

    public final String toString() {
        return AppContentTupleEntity.m2864b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentTupleEntity) ld()).writeToParcel(parcel, i);
    }
}
