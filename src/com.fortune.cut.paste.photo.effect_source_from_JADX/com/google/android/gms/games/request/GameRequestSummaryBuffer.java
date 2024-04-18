package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;

public final class GameRequestSummaryBuffer extends DataBuffer<GameRequestSummary> {
    public final GameRequestSummary ep(int i) {
        return new GameRequestSummaryRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return ep(i);
    }
}
