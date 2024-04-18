package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m2834a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, playerLevel.getLevelNumber());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevel.getVersionCode());
        C0542b.m1960a(parcel, 2, playerLevel.getMinXp());
        C0542b.m1960a(parcel, 3, playerLevel.getMaxXp());
        C0542b.m1956H(parcel, H);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int G = C0541a.m1920G(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevel[] newArray(int i) {
        return new PlayerLevel[i];
    }
}
