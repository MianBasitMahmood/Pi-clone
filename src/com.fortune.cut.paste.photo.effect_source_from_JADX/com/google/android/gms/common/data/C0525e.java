package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.e */
public class C0525e<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] Lb;
    private final Creator<T> Lc;

    static {
        Lb = new String[]{"data"};
    }

    public C0525e(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.Lc = creator;
    }

    public T at(int i) {
        byte[] f = this.JG.m1869f("data", i, this.JG.au(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.Lc.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int i) {
        return at(i);
    }
}
