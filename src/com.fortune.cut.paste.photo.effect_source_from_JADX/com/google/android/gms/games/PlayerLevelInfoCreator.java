package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m2835a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1960a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevelInfo.getVersionCode());
        C0542b.m1960a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        C0542b.m1964a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        C0542b.m1964a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    playerLevel2 = (PlayerLevel) C0541a.m1922a(parcel, F, PlayerLevel.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    playerLevel = (PlayerLevel) C0541a.m1922a(parcel, F, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevelInfo[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }
}
