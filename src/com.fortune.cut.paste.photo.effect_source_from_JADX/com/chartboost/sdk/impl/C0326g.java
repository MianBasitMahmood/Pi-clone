package com.chartboost.sdk.impl;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.chartboost.sdk.impl.g */
public class C0326g extends Thread {
    private final BlockingQueue<C0182l<?>> f907a;
    private final C0325f f908b;
    private final C0230b f909c;
    private final C0323o f910d;
    private volatile boolean f911e;

    public C0326g(BlockingQueue<C0182l<?>> blockingQueue, C0325f c0325f, C0230b c0230b, C0323o c0323o) {
        this.f911e = false;
        this.f907a = blockingQueue;
        this.f908b = c0325f;
        this.f909c = c0230b;
        this.f910d = c0323o;
    }

    public void m1350a() {
        this.f911e = true;
        interrupt();
    }

    @TargetApi(14)
    private void m1348a(C0182l<?> c0182l) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(c0182l.m550c());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                C0182l c0182l = (C0182l) this.f907a.take();
                try {
                    c0182l.m545a("network-queue-take");
                    if (c0182l.m555h()) {
                        c0182l.m549b("network-discard-cancelled");
                    } else {
                        m1348a(c0182l);
                        C0328i a = this.f908b.m1347a(c0182l);
                        c0182l.m545a("network-http-complete");
                        if (a.f915d && c0182l.m570w()) {
                            c0182l.m549b("not-modified");
                        } else {
                            C0336n a2 = c0182l.m543a(a);
                            c0182l.m545a("network-parse-complete");
                            if (c0182l.m565r() && a2.f938b != null) {
                                this.f909c.m924a(c0182l.m552e(), a2.f938b);
                                c0182l.m545a("network-cache-written");
                            }
                            c0182l.m569v();
                            this.f910d.m1341a(c0182l, a2);
                        }
                    }
                } catch (C0178s e) {
                    m1349a(c0182l, e);
                } catch (Throwable e2) {
                    C0341t.m1368a(e2, "Unhandled exception %s", e2.toString());
                    this.f910d.m1343a(c0182l, new C0178s(e2));
                }
            } catch (InterruptedException e3) {
                if (this.f911e) {
                    return;
                }
            }
        }
    }

    private void m1349a(C0182l<?> c0182l, C0178s c0178s) {
        this.f910d.m1343a((C0182l) c0182l, c0182l.m544a(c0178s));
    }
}
