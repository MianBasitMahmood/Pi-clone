package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ey
public class gk<T> implements Future<T> {
    private final T wF;

    public gk(T t) {
        this.wF = t;
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.wF;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.wF;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
