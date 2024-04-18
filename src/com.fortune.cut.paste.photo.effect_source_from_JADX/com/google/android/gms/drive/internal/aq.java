package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class aq implements Creator<OnEventResponse> {
    static void m2164a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, onEventResponse.CK);
        C0542b.m1980c(parcel, 2, onEventResponse.Pm);
        C0542b.m1964a(parcel, 3, onEventResponse.QO, i, false);
        C0542b.m1964a(parcel, 5, onEventResponse.QP, i, false);
        C0542b.m1956H(parcel, H);
    }

    public OnEventResponse av(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        ChangeEvent changeEvent = null;
        int i = 0;
        int i2 = 0;
        CompletionEvent completionEvent = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    changeEvent = (ChangeEvent) C0541a.m1922a(parcel, F, ChangeEvent.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    completionEvent = (CompletionEvent) C0541a.m1922a(parcel, F, CompletionEvent.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public OnEventResponse[] bK(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return av(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return bK(i);
    }
}
