package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.C0491a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class me<T extends Result> implements PendingResult<T> {
    private final T UU;

    me(T t) {
        this.UU = t;
    }

    public void m5415a(C0491a c0491a) {
        c0491a.m1791m(this.UU.getStatus());
    }

    public T await() {
        return this.UU;
    }

    public T await(long j, TimeUnit timeUnit) {
        return this.UU;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> resultCallback) {
        resultCallback.onResult(this.UU);
    }

    public void setResultCallback(ResultCallback<T> resultCallback, long j, TimeUnit timeUnit) {
        resultCallback.onResult(this.UU);
    }
}
