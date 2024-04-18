package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer extends DataBuffer<Participant> {
    public final Participant get(int i) {
        return new ParticipantRef(this.JG, i);
    }
}
