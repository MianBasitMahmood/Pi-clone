package com.google.android.gms.games.event;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class EventBuffer extends DataBuffer<Event> {
    public EventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final Event get(int i) {
        return new EventRef(this.JG, i);
    }
}
