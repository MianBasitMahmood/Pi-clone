package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.events.a */
public class C0560a implements Creator<ChangeEvent> {
    static void m2018a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, changeEvent.CK);
        C0542b.m1964a(parcel, 2, changeEvent.Oj, i, false);
        C0542b.m1980c(parcel, 3, changeEvent.OX);
        C0542b.m1956H(parcel, H);
    }

    public ChangeEvent m2019X(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    driveId = (DriveId) C0541a.m1922a(parcel, F, DriveId.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ChangeEvent(i, driveId, i2);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public ChangeEvent[] bf(int i) {
        return new ChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2019X(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bf(i);
    }
}
