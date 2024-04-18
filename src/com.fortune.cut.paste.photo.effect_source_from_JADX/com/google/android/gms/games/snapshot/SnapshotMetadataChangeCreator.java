package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.C0522a;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void m4090a(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1968a(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataChangeEntity.getVersionCode());
        C0542b.m1967a(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        C0542b.m1964a(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        C0542b.m1964a(parcel, 5, snapshotMetadataChangeEntity.mT(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public SnapshotMetadataChangeEntity cE(Parcel parcel) {
        Uri uri = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        C0522a c0522a = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    l = C0541a.m1936j(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    c0522a = (C0522a) C0541a.m1922a(parcel, F, C0522a.CREATOR);
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
            return new SnapshotMetadataChangeEntity(i, str, l, c0522a, uri);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return cE(parcel);
    }

    public SnapshotMetadataChangeEntity[] er(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return er(i);
    }
}
