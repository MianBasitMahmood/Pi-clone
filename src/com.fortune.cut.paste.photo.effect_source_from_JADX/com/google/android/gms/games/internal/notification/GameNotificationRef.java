package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C0451d implements GameNotification {
    GameNotificationRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final long getId() {
        return getLong("_id");
    }

    public final String getText() {
        return getString("text");
    }

    public final String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public final int getType() {
        return getInteger("type");
    }

    public final String mr() {
        return getString("notification_id");
    }

    public final String ms() {
        return getString("ticker");
    }

    public final String mt() {
        return getString("coalesced_text");
    }

    public final boolean mu() {
        return getInteger("acknowledged") > 0;
    }

    public final boolean mv() {
        return getInteger("alert_level") == 0;
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("Id", Long.valueOf(getId())).m5211a("NotificationId", mr()).m5211a("Type", Integer.valueOf(getType())).m5211a("Title", getTitle()).m5211a("Ticker", ms()).m5211a("Text", getText()).m5211a("CoalescedText", mt()).m5211a("isAcknowledged", Boolean.valueOf(mu())).m5211a("isSilent", Boolean.valueOf(mv())).toString();
    }
}
