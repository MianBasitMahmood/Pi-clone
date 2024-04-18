package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ph extends C0451d implements Moment {
    private pf apk;

    public ph(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private pf oK() {
        synchronized (this) {
            if (this.apk == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.apk = pf.CREATOR.dy(obtain);
                obtain.recycle();
            }
        }
        return this.apk;
    }

    public final /* synthetic */ Object freeze() {
        return oJ();
    }

    public final String getId() {
        return oK().getId();
    }

    public final ItemScope getResult() {
        return oK().getResult();
    }

    public final String getStartDate() {
        return oK().getStartDate();
    }

    public final ItemScope getTarget() {
        return oK().getTarget();
    }

    public final String getType() {
        return oK().getType();
    }

    public final boolean hasId() {
        return oK().hasId();
    }

    public final boolean hasResult() {
        return oK().hasResult();
    }

    public final boolean hasStartDate() {
        return oK().hasStartDate();
    }

    public final boolean hasTarget() {
        return oK().hasTarget();
    }

    public final boolean hasType() {
        return oK().hasType();
    }

    public final pf oJ() {
        return oK();
    }
}
