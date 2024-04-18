package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C0527g<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4077f(int i, int i2) {
        return m4078o(i, i2);
    }

    protected final String ha() {
        return "external_request_id";
    }

    protected final GameRequest m4078o(int i, int i2) {
        return new GameRequestRef(this.JG, i, i2);
    }
}
