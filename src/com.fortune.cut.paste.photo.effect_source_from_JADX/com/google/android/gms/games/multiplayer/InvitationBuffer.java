package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C0527g<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4032f(int i, int i2) {
        return m4033k(i, i2);
    }

    protected final String ha() {
        return "external_invitation_id";
    }

    protected final Invitation m4033k(int i, int i2) {
        return new InvitationRef(this.JG, i, i2);
    }
}
