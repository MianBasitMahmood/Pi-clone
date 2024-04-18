package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0485b implements Creator<CastDevice> {
    static void m1762a(CastDevice castDevice, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, castDevice.getVersionCode());
        C0542b.m1968a(parcel, 2, castDevice.getDeviceId(), false);
        C0542b.m1968a(parcel, 3, castDevice.FH, false);
        C0542b.m1968a(parcel, 4, castDevice.getFriendlyName(), false);
        C0542b.m1968a(parcel, 5, castDevice.getModelName(), false);
        C0542b.m1968a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0542b.m1980c(parcel, 7, castDevice.getServicePort());
        C0542b.m1981c(parcel, 8, castDevice.getIcons(), false);
        C0542b.m1980c(parcel, 9, castDevice.getCapabilities());
        C0542b.m1980c(parcel, 10, castDevice.getStatus());
        C0542b.m1956H(parcel, H);
    }

    public CastDevice[] m1763Z(int i) {
        return new CastDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1764v(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1763Z(i);
    }

    public CastDevice m1764v(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = C0541a.m1920G(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    list = C0541a.m1928c(parcel, F, WebImage.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, list, i2, i);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }
}
