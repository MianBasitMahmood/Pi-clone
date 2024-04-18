package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@ey
public final class gh {
    private static final ThreadFactory ww;
    private static final ExecutorService wx;

    /* renamed from: com.google.android.gms.internal.gh.1 */
    static class C11641 implements Callable<Void> {
        final /* synthetic */ Runnable wy;

        C11641(Runnable runnable) {
            this.wy = runnable;
        }

        public final /* synthetic */ Object call() throws Exception {
            return ds();
        }

        public final Void ds() {
            this.wy.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.2 */
    static class C11652 implements Callable<T> {
        final /* synthetic */ Callable wz;

        C11652(Callable callable) {
            this.wz = callable;
        }

        public final T call() throws Exception {
            try {
                Process.setThreadPriority(10);
                return this.wz.call();
            } catch (Throwable e) {
                ga.m4690e(e);
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.3 */
    static class C11663 implements ThreadFactory {
        private final AtomicInteger wA;

        C11663() {
            this.wA = new AtomicInteger(1);
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.wA.getAndIncrement());
        }
    }

    static {
        ww = new C11663();
        wx = Executors.newFixedThreadPool(10, ww);
    }

    public static Future<Void> m4714a(Runnable runnable) {
        return submit(new C11641(runnable));
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        try {
            return wx.submit(new C11652(callable));
        } catch (Throwable e) {
            gr.m4777d("Thread execution is rejected.", e);
            return new gk(null);
        }
    }
}
