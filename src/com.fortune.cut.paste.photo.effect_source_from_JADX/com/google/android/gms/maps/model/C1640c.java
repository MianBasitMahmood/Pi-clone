package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.model.c */
public class C1640c implements Creator<CircleOptions> {
    static void m6194a(CircleOptions circleOptions, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, circleOptions.getVersionCode());
        C0542b.m1964a(parcel, 2, circleOptions.getCenter(), i, false);
        C0542b.m1958a(parcel, 3, circleOptions.getRadius());
        C0542b.m1959a(parcel, 4, circleOptions.getStrokeWidth());
        C0542b.m1980c(parcel, 5, circleOptions.getStrokeColor());
        C0542b.m1980c(parcel, 6, circleOptions.getFillColor());
        C0542b.m1959a(parcel, 7, circleOptions.getZIndex());
        C0542b.m1971a(parcel, 8, circleOptions.isVisible());
        C0542b.m1956H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return db(parcel);
    }

    public CircleOptions db(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    d = C0541a.m1939m(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    f2 = C0541a.m1938l(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public CircleOptions[] eX(int i) {
        return new CircleOptions[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eX(i);
    }
}
