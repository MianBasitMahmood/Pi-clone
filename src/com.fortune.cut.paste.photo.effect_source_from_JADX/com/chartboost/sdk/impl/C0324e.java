package com.chartboost.sdk.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.impl.e */
public class C0324e implements C0323o {
    private final Executor f906a;

    /* renamed from: com.chartboost.sdk.impl.e.1 */
    class C03211 implements Executor {
        final /* synthetic */ C0324e f900a;
        private final /* synthetic */ Handler f901b;

        C03211(C0324e c0324e, Handler handler) {
            this.f900a = c0324e;
            this.f901b = handler;
        }

        public void execute(Runnable runnable) {
            this.f901b.post(runnable);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.e.a */
    private class C0322a implements Runnable {
        final /* synthetic */ C0324e f902a;
        private final C0182l f903b;
        private final C0336n f904c;
        private final Runnable f905d;

        public C0322a(C0324e c0324e, C0182l c0182l, C0336n c0336n, Runnable runnable) {
            this.f902a = c0324e;
            this.f903b = c0182l;
            this.f904c = c0336n;
            this.f905d = runnable;
        }

        public void run() {
            if (this.f903b.m555h()) {
                this.f903b.m549b("canceled-at-delivery");
                return;
            }
            if (this.f904c.m1363a()) {
                this.f903b.m548b(this.f904c.f937a);
            } else {
                this.f903b.m547b(this.f904c.f939c);
            }
            if (this.f904c.f940d) {
                this.f903b.m545a("intermediate-response");
            } else {
                this.f903b.m549b("done");
            }
            if (this.f905d != null) {
                this.f905d.run();
            }
        }
    }

    public C0324e(Handler handler) {
        this.f906a = new C03211(this, handler);
    }

    public void m1344a(C0182l<?> c0182l, C0336n<?> c0336n) {
        m1345a(c0182l, c0336n, null);
    }

    public void m1345a(C0182l<?> c0182l, C0336n<?> c0336n, Runnable runnable) {
        c0182l.m569v();
        c0182l.m545a("post-response");
        this.f906a.execute(new C0322a(this, c0182l, c0336n, runnable));
    }

    public void m1346a(C0182l<?> c0182l, C0178s c0178s) {
        c0182l.m545a("post-error");
        this.f906a.execute(new C0322a(this, c0182l, C0336n.m1361a(c0178s), null));
    }
}
