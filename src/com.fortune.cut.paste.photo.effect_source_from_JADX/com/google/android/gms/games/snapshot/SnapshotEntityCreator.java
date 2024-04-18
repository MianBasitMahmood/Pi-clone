package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m4089a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotEntity.getVersionCode());
        C0542b.m1964a(parcel, 3, snapshotEntity.getSnapshotContents(), i, false);
        C0542b.m1956H(parcel, H);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        SnapshotMetadata snapshotMetadata = null;
        int i = 0;
        SnapshotContentsEntity snapshotContentsEntity = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    snapshotMetadata = (SnapshotMetadataEntity) C0541a.m1922a(parcel, F, SnapshotMetadataEntity.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    snapshotContentsEntity = (SnapshotContentsEntity) C0541a.m1922a(parcel, F, SnapshotContentsEntity.CREATOR);
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
            return new SnapshotEntity(i, snapshotMetadata, snapshotContentsEntity);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SnapshotEntity[] newArray(int i) {
        return new SnapshotEntity[i];
    }
}
