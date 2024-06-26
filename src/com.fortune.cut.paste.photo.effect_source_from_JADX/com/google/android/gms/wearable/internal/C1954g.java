package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.g */
public class C1954g implements DataEvent {
    private int Gt;
    private DataItem axE;

    public C1954g(DataEvent dataEvent) {
        this.Gt = dataEvent.getType();
        this.axE = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return rn();
    }

    public DataItem getDataItem() {
        return this.axE;
    }

    public int getType() {
        return this.Gt;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataEvent rn() {
        return this;
    }
}
