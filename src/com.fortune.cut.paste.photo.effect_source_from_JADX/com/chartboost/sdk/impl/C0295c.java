package com.chartboost.sdk.impl;

import android.os.Process;
import com.chartboost.sdk.impl.C0230b.C0229a;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.chartboost.sdk.impl.c */
public class C0295c extends Thread {
    private static final boolean f797a;
    private final BlockingQueue<C0182l<?>> f798b;
    private final BlockingQueue<C0182l<?>> f799c;
    private final C0230b f800d;
    private final C0323o f801e;
    private volatile boolean f802f;

    /* renamed from: com.chartboost.sdk.impl.c.1 */
    class C02941 implements Runnable {
        final /* synthetic */ C0295c f795a;
        private final /* synthetic */ C0182l f796b;

        C02941(C0295c c0295c, C0182l c0182l) {
            this.f795a = c0295c;
            this.f796b = c0182l;
        }

        public void run() {
            try {
                this.f795a.f799c.put(this.f796b);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        f797a = C0341t.f948b;
    }

    public C0295c(BlockingQueue<C0182l<?>> blockingQueue, BlockingQueue<C0182l<?>> blockingQueue2, C0230b c0230b, C0323o c0323o) {
        this.f802f = false;
        this.f798b = blockingQueue;
        this.f799c = blockingQueue2;
        this.f800d = c0230b;
        this.f801e = c0323o;
    }

    public void m1183a() {
        this.f802f = true;
        interrupt();
    }

    public void run() {
        if (f797a) {
            C0341t.m1367a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f800d.m923a();
        while (true) {
            try {
                C0182l c0182l = (C0182l) this.f798b.take();
                c0182l.m545a("cache-queue-take");
                if (c0182l.m555h()) {
                    c0182l.m549b("cache-discard-canceled");
                } else {
                    C0229a a = this.f800d.m922a(c0182l.m552e());
                    if (a == null) {
                        c0182l.m545a("cache-miss");
                        this.f799c.put(c0182l);
                    } else if (a.m920a()) {
                        c0182l.m545a("cache-hit-expired");
                        c0182l.m539a(a);
                        this.f799c.put(c0182l);
                    } else {
                        c0182l.m545a("cache-hit");
                        C0336n a2 = c0182l.m543a(new C0328i(a.f594a, a.f599f));
                        c0182l.m545a("cache-hit-parsed");
                        if (a.m921b()) {
                            c0182l.m545a("cache-hit-refresh-needed");
                            c0182l.m539a(a);
                            a2.f940d = true;
                            this.f801e.m1342a(c0182l, a2, new C02941(this, c0182l));
                        } else {
                            this.f801e.m1341a(c0182l, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f802f) {
                    return;
                }
            }
        }
    }
}
