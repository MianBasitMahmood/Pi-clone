package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR;
    private final int CK;
    private final String UO;
    private final Uri WD;
    private final String WO;
    private final PlayerEntity XE;
    private final String Ye;
    private final long Yf;
    private final String Yg;
    private final boolean Yh;
    private final String mName;

    static {
        CREATOR = new EventEntityCreator();
    }

    EventEntity(int i, String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.CK = i;
        this.Ye = str;
        this.mName = str2;
        this.UO = str3;
        this.WD = uri;
        this.WO = str4;
        this.XE = new PlayerEntity(player);
        this.Yf = j;
        this.Yg = str5;
        this.Yh = z;
    }

    public EventEntity(Event event) {
        this.CK = 1;
        this.Ye = event.getEventId();
        this.mName = event.getName();
        this.UO = event.getDescription();
        this.WD = event.getIconImageUri();
        this.WO = event.getIconImageUrl();
        this.XE = (PlayerEntity) event.getPlayer().freeze();
        this.Yf = event.getValue();
        this.Yg = event.getFormattedValue();
        this.Yh = event.isVisible();
    }

    static int m2876a(Event event) {
        return jv.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean m2877a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return jv.equal(event2.getEventId(), event.getEventId()) && jv.equal(event2.getName(), event.getName()) && jv.equal(event2.getDescription(), event.getDescription()) && jv.equal(event2.getIconImageUri(), event.getIconImageUri()) && jv.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && jv.equal(event2.getPlayer(), event.getPlayer()) && jv.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && jv.equal(event2.getFormattedValue(), event.getFormattedValue()) && jv.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String m2878b(Event event) {
        return jv.m5212h(event).m5211a("Id", event.getEventId()).m5211a("Name", event.getName()).m5211a("Description", event.getDescription()).m5211a("IconImageUri", event.getIconImageUri()).m5211a("IconImageUrl", event.getIconImageUrl()).m5211a("Player", event.getPlayer()).m5211a("Value", Long.valueOf(event.getValue())).m5211a("FormattedValue", event.getFormattedValue()).m5211a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m2877a(this, obj);
    }

    public final Event freeze() {
        return this;
    }

    public final String getDescription() {
        return this.UO;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.UO, charArrayBuffer);
    }

    public final String getEventId() {
        return this.Ye;
    }

    public final String getFormattedValue() {
        return this.Yg;
    }

    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.Yg, charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return this.WD;
    }

    public final String getIconImageUrl() {
        return this.WO;
    }

    public final String getName() {
        return this.mName;
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        le.m5324b(this.mName, charArrayBuffer);
    }

    public final Player getPlayer() {
        return this.XE;
    }

    public final long getValue() {
        return this.Yf;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m2876a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isVisible() {
        return this.Yh;
    }

    public final String toString() {
        return m2878b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        EventEntityCreator.m2879a(this, parcel, i);
    }
}
