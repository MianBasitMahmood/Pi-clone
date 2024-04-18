package com.chartboost.sdk.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class dh<T> {
    final int f846a;
    private Queue<T> f847b;

    protected abstract T m1253b();

    public dh(int i) {
        this.f847b = new ConcurrentLinkedQueue();
        this.f846a = i;
    }

    protected boolean m1252a(T t) {
        return true;
    }

    public T m1255c() {
        T poll = this.f847b.poll();
        return poll != null ? poll : m1253b();
    }

    public void m1254b(T t) {
        if (m1252a(t) && this.f847b.size() <= this.f846a) {
            this.f847b.add(t);
        }
    }
}
