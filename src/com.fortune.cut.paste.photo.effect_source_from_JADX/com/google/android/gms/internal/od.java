package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public class od implements Creator<oc> {
    static void m5689a(oc ocVar, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, ocVar.getName(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, ocVar.CK);
        C0542b.m1964a(parcel, 2, ocVar.nx(), i, false);
        C0542b.m1968a(parcel, 3, ocVar.getAddress(), false);
        C0542b.m1981c(parcel, 4, ocVar.ny(), false);
        C0542b.m1968a(parcel, 5, ocVar.getPhoneNumber(), false);
        C0542b.m1968a(parcel, 6, ocVar.nz(), false);
        C0542b.m1956H(parcel, H);
    }

    public oc cU(Parcel parcel) {
        String str = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    latLng = (LatLng) C0541a.m1922a(parcel, F, LatLng.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1928c(parcel, F, oa.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new oc(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cU(parcel);
    }

    public oc[] eQ(int i) {
        return new oc[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return eQ(i);
    }
}
