package com.google.android.gms.internal;

@ey
public abstract class gf {
    private final Runnable mv;
    private volatile Thread wu;

    /* renamed from: com.google.android.gms.internal.gf.1 */
    class C11631 implements Runnable {
        final /* synthetic */ gf wv;

        C11631(gf gfVar) {
            this.wv = gfVar;
        }

        public final void run() {
            this.wv.wu = Thread.currentThread();
            this.wv.cx();
        }
    }

    public gf() {
        this.mv = new C11631(this);
    }

    public final void cancel() {
        onStop();
        if (this.wu != null) {
            this.wu.interrupt();
        }
    }

    public abstract void cx();

    public abstract void onStop();

    public final void start() {
        gh.m4714a(this.mv);
    }
}
