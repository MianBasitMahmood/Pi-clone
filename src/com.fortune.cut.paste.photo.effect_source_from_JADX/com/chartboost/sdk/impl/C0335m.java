package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.chartboost.sdk.impl.m */
public class C0335m {
    private AtomicInteger f926a;
    private final Map<String, Queue<C0182l<?>>> f927b;
    private final Set<C0182l<?>> f928c;
    private final PriorityBlockingQueue<C0182l<?>> f929d;
    private final PriorityBlockingQueue<C0182l<?>> f930e;
    private final C0230b f931f;
    private final C0325f f932g;
    private final C0323o f933h;
    private C0326g[] f934i;
    private C0295c f935j;
    private boolean f936k;

    /* renamed from: com.chartboost.sdk.impl.m.a */
    public interface C0333a {
        boolean m1351a(C0182l<?> c0182l);
    }

    /* renamed from: com.chartboost.sdk.impl.m.1 */
    class C03341 implements C0333a {
        final /* synthetic */ C0335m f924a;
        private final /* synthetic */ Object f925b;

        C03341(C0335m c0335m, Object obj) {
            this.f924a = c0335m;
            this.f925b = obj;
        }

        public boolean m1352a(C0182l<?> c0182l) {
            return c0182l.m546b() == this.f925b;
        }
    }

    public C0335m(C0230b c0230b, C0325f c0325f, int i, C0323o c0323o) {
        this.f926a = new AtomicInteger();
        this.f927b = new HashMap();
        this.f928c = new HashSet();
        this.f929d = new PriorityBlockingQueue();
        this.f930e = new PriorityBlockingQueue();
        this.f936k = false;
        this.f931f = c0230b;
        this.f932g = c0325f;
        this.f934i = new C0326g[i];
        this.f933h = c0323o;
    }

    public C0335m(C0230b c0230b, C0325f c0325f, int i) {
        this(c0230b, c0325f, i, new C0324e(new Handler(Looper.getMainLooper())));
    }

    public C0335m(C0230b c0230b, C0325f c0325f) {
        this(c0230b, c0325f, 4);
    }

    public void m1354a() {
        m1358b();
        this.f935j = new C0295c(this.f929d, this.f930e, this.f931f, this.f933h);
        this.f935j.start();
        m1357a(true);
        for (int i = 0; i < this.f934i.length; i++) {
            C0326g c0326g = new C0326g(this.f930e, this.f932g, this.f931f, this.f933h);
            this.f934i[i] = c0326g;
            c0326g.start();
        }
    }

    public void m1358b() {
        int i = 0;
        m1357a(false);
        if (this.f935j != null) {
            this.f935j.m1183a();
        }
        while (i < this.f934i.length) {
            if (this.f934i[i] != null) {
                this.f934i[i].m1350a();
            }
            i++;
        }
    }

    public int m1360c() {
        return this.f926a.incrementAndGet();
    }

    public void m1355a(C0333a c0333a) {
        synchronized (this.f928c) {
            for (C0182l c0182l : this.f928c) {
                if (c0333a.m1351a(c0182l)) {
                    c0182l.m554g();
                }
            }
        }
    }

    public void m1356a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        m1355a(new C03341(this, obj));
    }

    public <T> C0182l<T> m1353a(C0182l<T> c0182l) {
        c0182l.m540a(this);
        synchronized (this.f928c) {
            this.f928c.add(c0182l);
        }
        c0182l.m538a(m1360c());
        c0182l.m545a("add-to-queue");
        if (c0182l.m565r()) {
            synchronized (this.f927b) {
                String e = c0182l.m552e();
                if (this.f927b.containsKey(e)) {
                    Queue queue = (Queue) this.f927b.get(e);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(c0182l);
                    this.f927b.put(e, queue);
                    if (C0341t.f948b) {
                        C0341t.m1367a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f927b.put(e, null);
                    this.f929d.add(c0182l);
                }
            }
        } else {
            this.f930e.add(c0182l);
        }
        return c0182l;
    }

    void m1359b(C0182l<?> c0182l) {
        synchronized (this.f928c) {
            this.f928c.remove(c0182l);
        }
        if (c0182l.m565r()) {
            synchronized (this.f927b) {
                Queue queue = (Queue) this.f927b.remove(c0182l.m552e());
                if (queue != null) {
                    if (C0341t.f948b) {
                        C0341t.m1367a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f929d.addAll(queue);
                }
            }
        }
    }

    public boolean m1357a(boolean z) {
        this.f936k = z;
        return z;
    }
}
