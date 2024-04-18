package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1962o;

public class DataItemBuffer extends C0527g<DataItem> implements Result {
    private final Status Eb;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object m6810f(int i, int i2) {
        return m6811r(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    protected DataItem m6811r(int i, int i2) {
        return new C1962o(this.JG, i, i2);
    }
}
