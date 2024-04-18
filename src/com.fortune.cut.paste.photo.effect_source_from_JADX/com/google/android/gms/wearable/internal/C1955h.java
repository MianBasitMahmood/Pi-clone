package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.h */
public final class C1955h extends C0451d implements DataEvent {
    private final int Ya;

    public C1955h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public final /* synthetic */ Object freeze() {
        return rn();
    }

    public final DataItem getDataItem() {
        return new C1962o(this.JG, this.KZ, this.Ya);
    }

    public final int getType() {
        return getInteger("event_type");
    }

    public final DataEvent rn() {
        return new C1954g(this);
    }
}
