package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public static final class Builder {
        int adW;
        final RoomUpdateListener aeh;
        RoomStatusUpdateListener aei;
        RealTimeMessageReceivedListener aej;
        String aek;
        ArrayList<String> ael;
        Bundle aem;
        boolean aen;

        private Builder(RoomUpdateListener roomUpdateListener) {
            this.aek = null;
            this.adW = -1;
            this.ael = new ArrayList();
            this.aen = false;
            this.aeh = (RoomUpdateListener) jx.m5219b((Object) roomUpdateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public final Builder addPlayersToInvite(ArrayList<String> arrayList) {
            jx.m5223i(arrayList);
            this.ael.addAll(arrayList);
            return this;
        }

        public final Builder addPlayersToInvite(String... strArr) {
            jx.m5223i(strArr);
            this.ael.addAll(Arrays.asList(strArr));
            return this;
        }

        public final RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.aem = bundle;
            return this;
        }

        public final Builder setInvitationIdToAccept(String str) {
            jx.m5223i(str);
            this.aek = str;
            return this;
        }

        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.aej = realTimeMessageReceivedListener;
            return this;
        }

        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.aei = roomStatusUpdateListener;
            return this;
        }

        @Deprecated
        public final Builder setSocketCommunicationEnabled(boolean z) {
            this.aen = z;
            return this;
        }

        public final Builder setVariant(int i) {
            boolean z = i == -1 || i > 0;
            jx.m5221b(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.adW = i;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(null);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();

    @Deprecated
    public abstract boolean isSocketEnabled();
}
