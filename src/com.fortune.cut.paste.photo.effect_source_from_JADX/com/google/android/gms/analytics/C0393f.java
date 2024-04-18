package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.f */
interface C0393f {
    void dQ();

    void dW();

    LinkedBlockingQueue<Runnable> dX();

    void dY();

    void dispatch();

    Thread getThread();

    void m1537u(Map<String, String> map);
}
