package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR;
    private final int CK;
    private final int FP;
    private final int Gt;
    private final String Zt;
    private final GameEntity acs;
    private final long adS;
    private final byte[] aeA;
    private final PlayerEntity aeU;
    private final ArrayList<PlayerEntity> aeV;
    private final long aeW;
    private final Bundle aeX;

    static {
        CREATOR = new GameRequestEntityCreator();
    }

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList<PlayerEntity> arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.CK = i;
        this.acs = gameEntity;
        this.aeU = playerEntity;
        this.aeA = bArr;
        this.Zt = str;
        this.aeV = arrayList;
        this.Gt = i2;
        this.adS = j;
        this.aeW = j2;
        this.aeX = bundle;
        this.FP = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.CK = 2;
        this.acs = new GameEntity(gameRequest.getGame());
        this.aeU = new PlayerEntity(gameRequest.getSender());
        this.Zt = gameRequest.getRequestId();
        this.Gt = gameRequest.getType();
        this.adS = gameRequest.getCreationTimestamp();
        this.aeW = gameRequest.getExpirationTimestamp();
        this.FP = gameRequest.getStatus();
        Object data = gameRequest.getData();
        if (data == null) {
            this.aeA = null;
        } else {
            this.aeA = new byte[data.length];
            System.arraycopy(data, 0, this.aeA, 0, data.length);
        }
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.aeV = new ArrayList(size);
        this.aeX = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.aeV.add((PlayerEntity) player);
            this.aeX.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int m4079a(GameRequest gameRequest) {
        return jv.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), m4081b(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean m4080a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return jv.equal(gameRequest2.getGame(), gameRequest.getGame()) && jv.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && jv.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && jv.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(m4081b(gameRequest2), m4081b(gameRequest)) && jv.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && jv.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && jv.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] m4081b(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String m4082c(GameRequest gameRequest) {
        return jv.m5212h(gameRequest).m5211a("Game", gameRequest.getGame()).m5211a("Sender", gameRequest.getSender()).m5211a("Recipients", gameRequest.getRecipients()).m5211a("Data", gameRequest.getData()).m5211a("RequestId", gameRequest.getRequestId()).m5211a("Type", Integer.valueOf(gameRequest.getType())).m5211a("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).m5211a("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4080a(this, obj);
    }

    public final GameRequest freeze() {
        return this;
    }

    public final long getCreationTimestamp() {
        return this.adS;
    }

    public final byte[] getData() {
        return this.aeA;
    }

    public final long getExpirationTimestamp() {
        return this.aeW;
    }

    public final Game getGame() {
        return this.acs;
    }

    public final int getRecipientStatus(String str) {
        return this.aeX.getInt(str, 0);
    }

    public final List<Player> getRecipients() {
        return new ArrayList(this.aeV);
    }

    public final String getRequestId() {
        return this.Zt;
    }

    public final Player getSender() {
        return this.aeU;
    }

    public final int getStatus() {
        return this.FP;
    }

    public final int getType() {
        return this.Gt;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4079a(this);
    }

    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final Bundle mS() {
        return this.aeX;
    }

    public final String toString() {
        return m4082c(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        GameRequestEntityCreator.m4083a(this, parcel, i);
    }
}
