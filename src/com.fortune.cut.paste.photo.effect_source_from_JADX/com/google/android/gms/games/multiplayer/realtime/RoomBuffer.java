package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C0527g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4045f(int i, int i2) {
        return m4046l(i, i2);
    }

    protected final String ha() {
        return "external_match_id";
    }

    protected final Room m4046l(int i, int i2) {
        return new RoomRef(this.JG, i, i2);
    }
}
