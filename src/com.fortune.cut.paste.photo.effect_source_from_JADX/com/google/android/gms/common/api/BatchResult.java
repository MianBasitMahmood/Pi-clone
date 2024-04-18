package com.google.android.gms.common.api;

import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status Eb;
    private final PendingResult<?>[] JC;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.Eb = status;
        this.JC = pendingResultArr;
    }

    public final Status getStatus() {
        return this.Eb;
    }

    public final <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        jx.m5221b(batchResultToken.mId < this.JC.length, (Object) "The result token does not belong to this batch");
        return this.JC[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
