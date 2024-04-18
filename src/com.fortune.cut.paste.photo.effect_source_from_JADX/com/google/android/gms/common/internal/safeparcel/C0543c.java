package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.internal.safeparcel.c */
public final class C0543c {
    public static <T extends SafeParcelable> T m1983a(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        return byteArrayExtra == null ? null : C0543c.m1984a(byteArrayExtra, creator);
    }

    public static <T extends SafeParcelable> T m1984a(byte[] bArr, Creator<T> creator) {
        jx.m5223i(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public static <T extends SafeParcelable> void m1985a(T t, Intent intent, String str) {
        intent.putExtra(str, C0543c.m1986a(t));
    }

    public static <T extends SafeParcelable> byte[] m1986a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
