package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.wearable.internal.c */
public class C1939c implements Creator<C1937b> {
    static void m7003a(C1937b c1937b, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, c1937b.CK);
        C0542b.m1962a(parcel, 2, c1937b.rm(), false);
        C0542b.m1974a(parcel, 3, c1937b.axw, i, false);
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return eo(parcel);
    }

    public C1937b eo(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    intentFilterArr = (IntentFilter[]) C0541a.m1927b(parcel, F, IntentFilter.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1937b(i, iBinder, intentFilterArr);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public C1937b[] gx(int i) {
        return new C1937b[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return gx(i);
    }
}
