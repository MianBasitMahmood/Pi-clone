package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> acq;

    public EventIncrementManager() {
        this.acq = new AtomicReference();
    }

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.acq.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache lF();

    public void m3005o(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.acq.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = lF();
            if (!this.acq.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.acq.get();
            }
        }
        eventIncrementCache.m3024y(str, i);
    }
}
