package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class ab implements Creator<FileUploadPreferencesImpl> {
    static void m2036a(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, fileUploadPreferencesImpl.CK);
        C0542b.m1980c(parcel, 2, fileUploadPreferencesImpl.Qz);
        C0542b.m1980c(parcel, 3, fileUploadPreferencesImpl.QA);
        C0542b.m1971a(parcel, 4, fileUploadPreferencesImpl.QB);
        C0542b.m1956H(parcel, H);
    }

    public FileUploadPreferencesImpl al(Parcel parcel) {
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public FileUploadPreferencesImpl[] bA(int i) {
        return new FileUploadPreferencesImpl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return al(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bA(i);
    }
}
