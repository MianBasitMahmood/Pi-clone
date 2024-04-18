package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer aes;
    private final TurnBasedMatchBuffer aet;
    private final TurnBasedMatchBuffer aeu;
    private final TurnBasedMatchBuffer aev;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder a = m4056a(bundle, 0);
        if (a != null) {
            this.aes = new InvitationBuffer(a);
        } else {
            this.aes = null;
        }
        a = m4056a(bundle, 1);
        if (a != null) {
            this.aet = new TurnBasedMatchBuffer(a);
        } else {
            this.aet = null;
        }
        a = m4056a(bundle, 2);
        if (a != null) {
            this.aeu = new TurnBasedMatchBuffer(a);
        } else {
            this.aeu = null;
        }
        a = m4056a(bundle, 3);
        if (a != null) {
            this.aev = new TurnBasedMatchBuffer(a);
        } else {
            this.aev = null;
        }
    }

    private static DataHolder m4056a(Bundle bundle, int i) {
        String dZ = TurnBasedMatchTurnStatus.dZ(i);
        return !bundle.containsKey(dZ) ? null : (DataHolder) bundle.getParcelable(dZ);
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.aev;
    }

    public final InvitationBuffer getInvitations() {
        return this.aes;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.aet;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.aeu;
    }

    public final boolean hasData() {
        return (this.aes == null || this.aes.getCount() <= 0) ? (this.aet == null || this.aet.getCount() <= 0) ? (this.aeu == null || this.aeu.getCount() <= 0) ? this.aev != null && this.aev.getCount() > 0 : true : true : true;
    }

    public final void release() {
        if (this.aes != null) {
            this.aes.release();
        }
        if (this.aet != null) {
            this.aet.release();
        }
        if (this.aeu != null) {
            this.aeu.release();
        }
        if (this.aev != null) {
            this.aev.release();
        }
    }
}
