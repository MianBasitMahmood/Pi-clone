package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.C1494u.C1492b;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@ey
/* renamed from: com.google.android.gms.internal.x */
class C1498x implements C1162g, Runnable {
    private C1492b lB;
    private final List<Object[]> mp;
    private final AtomicReference<C1162g> mq;
    CountDownLatch mr;

    public C1498x(C1492b c1492b) {
        this.mp = new Vector();
        this.mq = new AtomicReference();
        this.mr = new CountDownLatch(1);
        this.lB = c1492b;
        if (gq.dB()) {
            gh.m4714a(this);
        } else {
            run();
        }
    }

    private void aB() {
        if (!this.mp.isEmpty()) {
            for (Object[] objArr : this.mp) {
                if (objArr.length == 1) {
                    ((C1162g) this.mq.get()).m4684a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((C1162g) this.mq.get()).m4683a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    private Context m6071i(Context context) {
        if (!aC()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public String m6072a(Context context) {
        if (aA()) {
            C1162g c1162g = (C1162g) this.mq.get();
            if (c1162g != null) {
                aB();
                return c1162g.m4681a(m6071i(context));
            }
        }
        return "";
    }

    public String m6073a(Context context, String str) {
        if (aA()) {
            C1162g c1162g = (C1162g) this.mq.get();
            if (c1162g != null) {
                aB();
                return c1162g.m4682a(m6071i(context), str);
            }
        }
        return "";
    }

    public void m6074a(int i, int i2, int i3) {
        C1162g c1162g = (C1162g) this.mq.get();
        if (c1162g != null) {
            aB();
            c1162g.m4683a(i, i2, i3);
            return;
        }
        this.mp.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void m6075a(MotionEvent motionEvent) {
        C1162g c1162g = (C1162g) this.mq.get();
        if (c1162g != null) {
            aB();
            c1162g.m4684a(motionEvent);
            return;
        }
        this.mp.add(new Object[]{motionEvent});
    }

    protected void m6076a(C1162g c1162g) {
        this.mq.set(c1162g);
    }

    protected boolean aA() {
        try {
            this.mr.await();
            return true;
        } catch (Throwable e) {
            gr.m4777d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    protected boolean aC() {
        return ga.bN().getBoolean("gads:spam_app_context:enabled", false);
    }

    public void run() {
        try {
            m6076a(C1240j.m5070a(this.lB.lO.wS, m6071i(this.lB.lM)));
        } finally {
            this.mr.countDown();
            this.lB = null;
        }
    }
}
