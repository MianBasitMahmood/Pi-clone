package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends C0451d implements GameRequest {
    private final int Ya;

    public GameRequestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return GameRequestEntity.m4080a(this, obj);
    }

    public final GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public final long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public final Game getGame() {
        return new GameRef(this.JG, this.KZ);
    }

    public final int getRecipientStatus(String str) {
        for (int i = this.KZ; i < this.KZ + this.Ya; i++) {
            int au = this.JG.au(i);
            if (this.JG.m1865c("recipient_external_player_id", i, au).equals(str)) {
                return this.JG.m1864b("recipient_status", i, au);
            }
        }
        return -1;
    }

    public final List<Player> getRecipients() {
        List arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new PlayerRef(this.JG, this.KZ + i, "recipient_"));
        }
        return arrayList;
    }

    public final String getRequestId() {
        return getString("external_request_id");
    }

    public final Player getSender() {
        return new PlayerRef(this.JG, gW(), "sender_");
    }

    public final int getStatus() {
        return getInteger("status");
    }

    public final int getType() {
        return getInteger("type");
    }

    public final int hashCode() {
        return GameRequestEntity.m4079a(this);
    }

    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public final String toString() {
        return GameRequestEntity.m4082c(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((GameRequestEntity) freeze()).writeToParcel(parcel, i);
    }
}
