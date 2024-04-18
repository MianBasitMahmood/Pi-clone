package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int adW;
        ArrayList<String> ael;
        Bundle aem;
        int aew;

        private Builder() {
            this.adW = -1;
            this.ael = new ArrayList();
            this.aem = null;
            this.aew = 2;
        }

        public final Builder addInvitedPlayer(String str) {
            jx.m5223i(str);
            this.ael.add(str);
            return this;
        }

        public final Builder addInvitedPlayers(ArrayList<String> arrayList) {
            jx.m5223i(arrayList);
            this.ael.addAll(arrayList);
            return this;
        }

        public final TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.aem = bundle;
            return this;
        }

        public final Builder setVariant(int i) {
            boolean z = i == -1 || i > 0;
            jx.m5221b(z, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.adW = i;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int mO();
}
