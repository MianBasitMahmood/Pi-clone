package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object ack;
    private Handler acl;
    private boolean acm;
    private HashMap<String, AtomicInteger> acn;
    private int aco;

    /* renamed from: com.google.android.gms.games.internal.events.EventIncrementCache.1 */
    class C09831 implements Runnable {
        final /* synthetic */ EventIncrementCache acp;

        C09831(EventIncrementCache eventIncrementCache) {
            this.acp = eventIncrementCache;
        }

        public void run() {
            this.acp.lX();
        }
    }

    public EventIncrementCache(Looper looper, int i) {
        this.ack = new Object();
        this.acl = new Handler(looper);
        this.acn = new HashMap();
        this.aco = i;
    }

    private void lX() {
        synchronized (this.ack) {
            this.acm = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.ack) {
            for (Entry entry : this.acn.entrySet()) {
                m3023r((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.acn.clear();
        }
    }

    protected abstract void m3023r(String str, int i);

    public void m3024y(String str, int i) {
        synchronized (this.ack) {
            if (!this.acm) {
                this.acm = true;
                this.acl.postDelayed(new C09831(this), (long) this.aco);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.acn.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.acn.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
