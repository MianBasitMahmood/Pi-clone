package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR;
    private final int CK;
    private final ArrayList<GameRequestEntity> adk;

    static {
        CREATOR = new GameRequestClusterCreator();
    }

    GameRequestCluster(int i, ArrayList<GameRequestEntity> arrayList) {
        this.CK = i;
        this.adk = arrayList;
        mp();
    }

    private void mp() {
        je.m5079K(!this.adk.isEmpty());
        GameRequest gameRequest = (GameRequest) this.adk.get(0);
        int size = this.adk.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.adk.get(i);
            je.m5080a(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            je.m5080a(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.adk.size() != this.adk.size()) {
            return false;
        }
        int size = this.adk.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.adk.get(i)).equals((GameRequest) gameRequestCluster.adk.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final GameRequest freeze() {
        return this;
    }

    public final long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getRecipientStatus(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final /* synthetic */ List getRecipients() {
        return mE();
    }

    public final String getRequestId() {
        return ((GameRequestEntity) this.adk.get(0)).getRequestId();
    }

    public final Player getSender() {
        return ((GameRequestEntity) this.adk.get(0)).getSender();
    }

    public final int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getType() {
        return ((GameRequestEntity) this.adk.get(0)).getType();
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.adk.toArray());
    }

    public final boolean isConsumed(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final boolean isDataValid() {
        return true;
    }

    public final ArrayList<GameRequest> mD() {
        return new ArrayList(this.adk);
    }

    public final ArrayList<Player> mE() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        GameRequestClusterCreator.m4017a(this, parcel, i);
    }
}
