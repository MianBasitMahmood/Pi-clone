package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends C0451d implements Participant {
    private final PlayerRef aeb;

    public ParticipantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.aeb = new PlayerRef(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return ParticipantEntity.m4041a(this, obj);
    }

    public final Participant freeze() {
        return new ParticipantEntity(this);
    }

    public final int getCapabilities() {
        return getInteger("capabilities");
    }

    public final String getDisplayName() {
        return aS("external_player_id") ? getString("default_display_name") : this.aeb.getDisplayName();
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (aS("external_player_id")) {
            m1654a("default_display_name", charArrayBuffer);
        } else {
            this.aeb.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getHiResImageUri() {
        return aS("external_player_id") ? aR("default_display_hi_res_image_uri") : this.aeb.getHiResImageUri();
    }

    public final String getHiResImageUrl() {
        return aS("external_player_id") ? getString("default_display_hi_res_image_url") : this.aeb.getHiResImageUrl();
    }

    public final Uri getIconImageUri() {
        return aS("external_player_id") ? aR("default_display_image_uri") : this.aeb.getIconImageUri();
    }

    public final String getIconImageUrl() {
        return aS("external_player_id") ? getString("default_display_image_url") : this.aeb.getIconImageUrl();
    }

    public final String getParticipantId() {
        return getString("external_participant_id");
    }

    public final Player getPlayer() {
        return aS("external_player_id") ? null : this.aeb;
    }

    public final ParticipantResult getResult() {
        if (aS("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public final int getStatus() {
        return getInteger("player_status");
    }

    public final int hashCode() {
        return ParticipantEntity.m4040a(this);
    }

    public final boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public final String le() {
        return getString("client_address");
    }

    public final String toString() {
        return ParticipantEntity.m4042b((Participant) this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) freeze()).writeToParcel(parcel, i);
    }
}
