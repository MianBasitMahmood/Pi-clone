package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0525e;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pt;

public final class PersonBuffer extends DataBuffer<Person> {
    private final C0525e<pi> apT;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.gV() == null || !dataHolder.gV().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.apT = null;
        } else {
            this.apT = new C0525e(dataHolder, pi.CREATOR);
        }
    }

    public final Person get(int i) {
        return this.apT != null ? (Person) this.apT.at(i) : new pt(this.JG, i);
    }
}
