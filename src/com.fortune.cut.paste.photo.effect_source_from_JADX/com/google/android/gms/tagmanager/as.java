package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as ary;
    private final LinkedBlockingQueue<Runnable> arx;
    private volatile at arz;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zK;

    /* renamed from: com.google.android.gms.tagmanager.as.1 */
    class C17571 implements Runnable {
        final /* synthetic */ ar arA;
        final /* synthetic */ long arB;
        final /* synthetic */ as arC;
        final /* synthetic */ String wO;

        C17571(as asVar, ar arVar, long j, String str) {
            this.arC = asVar;
            this.arA = arVar;
            this.arB = j;
            this.wO = str;
        }

        public void run() {
            if (this.arC.arz == null) {
                cy qN = cy.qN();
                qN.m6588a(this.arC.mContext, this.arA);
                this.arC.arz = qN.qO();
            }
            this.arC.arz.m6431f(this.arB, this.wO);
        }
    }

    private as(Context context) {
        super("GAThread");
        this.arx = new LinkedBlockingQueue();
        this.zK = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as m6424Z(Context context) {
        if (ary == null) {
            ary = new as(context);
        }
        return ary;
    }

    private String m6428g(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void m6429b(Runnable runnable) {
        this.arx.add(runnable);
    }

    void m6430b(String str, long j) {
        m6429b(new C17571(this, this, j, str));
    }

    public void cE(String str) {
        m6430b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.arx.take();
                if (!this.zK) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m6459U(e.toString());
            } catch (Throwable th) {
                bh.m6458T("Error on Google TagManager Thread: " + m6428g(th));
                bh.m6458T("Google TagManager is shutting down.");
                this.zK = true;
            }
        }
    }
}
