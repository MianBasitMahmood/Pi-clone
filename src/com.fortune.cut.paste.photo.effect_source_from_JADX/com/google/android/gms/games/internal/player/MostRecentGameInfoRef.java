package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

public final class MostRecentGameInfoRef extends C0451d implements MostRecentGameInfo {
    private final PlayerColumnNames Xv;

    public MostRecentGameInfoRef(DataHolder dataHolder, int i, PlayerColumnNames playerColumnNames) {
        super(dataHolder, i);
        this.Xv = playerColumnNames;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.m4014a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mC();
    }

    public final int hashCode() {
        return MostRecentGameInfoEntity.m4013a(this);
    }

    public final Uri mA() {
        return aR(this.Xv.adi);
    }

    public final Uri mB() {
        return aR(this.Xv.adj);
    }

    public final MostRecentGameInfo mC() {
        return new MostRecentGameInfoEntity(this);
    }

    public final String mw() {
        return getString(this.Xv.ade);
    }

    public final String mx() {
        return getString(this.Xv.adf);
    }

    public final long my() {
        return getLong(this.Xv.adg);
    }

    public final Uri mz() {
        return aR(this.Xv.adh);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.m4015b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) mC()).writeToParcel(parcel, i);
    }
}
