package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;

public final class GameBadgeRef extends C0451d implements GameBadge {
    GameBadgeRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return GameBadgeEntity.m4009a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return mk();
    }

    public final String getDescription() {
        return getString("badge_description");
    }

    public final Uri getIconImageUri() {
        return aR("badge_icon_image_uri");
    }

    public final String getTitle() {
        return getString("badge_title");
    }

    public final int getType() {
        return getInteger("badge_type");
    }

    public final int hashCode() {
        return GameBadgeEntity.m4008a(this);
    }

    public final GameBadge mk() {
        return new GameBadgeEntity(this);
    }

    public final String toString() {
        return GameBadgeEntity.m4010b((GameBadge) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((GameBadgeEntity) mk()).writeToParcel(parcel, i);
    }
}
