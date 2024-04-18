package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@ey
public class ab {
    private final C0999a mu;
    private final Runnable mv;
    private av mw;
    private boolean mx;
    private boolean my;
    private long mz;

    /* renamed from: com.google.android.gms.internal.ab.1 */
    class C09981 implements Runnable {
        private final WeakReference<C1494u> mA;
        final /* synthetic */ C1494u mB;
        final /* synthetic */ ab mC;

        C09981(ab abVar, C1494u c1494u) {
            this.mC = abVar;
            this.mB = c1494u;
            this.mA = new WeakReference(this.mB);
        }

        public void run() {
            this.mC.mx = false;
            C1494u c1494u = (C1494u) this.mA.get();
            if (c1494u != null) {
                c1494u.m6065b(this.mC.mw);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ab.a */
    public static class C0999a {
        private final Handler mHandler;

        public C0999a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public ab(C1494u c1494u) {
        this(c1494u, new C0999a(gq.wR));
    }

    ab(C1494u c1494u, C0999a c0999a) {
        this.mx = false;
        this.my = false;
        this.mz = 0;
        this.mu = c0999a;
        this.mv = new C09981(this, c1494u);
    }

    public void m4112a(av avVar, long j) {
        if (this.mx) {
            gr.m4773W("An ad refresh is already scheduled.");
            return;
        }
        this.mw = avVar;
        this.mx = true;
        this.mz = j;
        if (!this.my) {
            gr.m4771U("Scheduling ad refresh " + j + " milliseconds from now.");
            this.mu.postDelayed(this.mv, j);
        }
    }

    public boolean aD() {
        return this.mx;
    }

    public void m4113c(av avVar) {
        m4112a(avVar, 60000);
    }

    public void cancel() {
        this.mx = false;
        this.mu.removeCallbacks(this.mv);
    }

    public void pause() {
        this.my = true;
        if (this.mx) {
            this.mu.removeCallbacks(this.mv);
        }
    }

    public void resume() {
        this.my = false;
        if (this.mx) {
            this.mx = false;
            m4112a(this.mw, this.mz);
        }
    }
}
