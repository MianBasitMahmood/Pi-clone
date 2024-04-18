package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1955h;

public class DataEventBuffer extends C0527g<DataEvent> implements Result {
    private final Status Eb;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object m6808f(int i, int i2) {
        return m6809q(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    protected DataEvent m6809q(int i, int i2) {
        return new C1955h(this.JG, i, i2);
    }
}
