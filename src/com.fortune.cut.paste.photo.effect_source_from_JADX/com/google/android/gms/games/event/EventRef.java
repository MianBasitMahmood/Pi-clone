package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.plus.PlusShare;

public final class EventRef extends C0451d implements Event {
    EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return EventEntity.m2877a(this, obj);
    }

    public final Event freeze() {
        return new EventEntity(this);
    }

    public final String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        m1654a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, charArrayBuffer);
    }

    public final String getEventId() {
        return getString("external_event_id");
    }

    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        m1654a("formatted_value", charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return aR("icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("icon_image_url");
    }

    public final String getName() {
        return getString("name");
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        m1654a("name", charArrayBuffer);
    }

    public final Player getPlayer() {
        return new PlayerRef(this.JG, this.KZ);
    }

    public final long getValue() {
        return getLong("value");
    }

    public final int hashCode() {
        return EventEntity.m2876a(this);
    }

    public final boolean isVisible() {
        return getBoolean("visibility");
    }

    public final String toString() {
        return EventEntity.m2878b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((EventEntity) freeze()).writeToParcel(parcel, i);
    }
}
