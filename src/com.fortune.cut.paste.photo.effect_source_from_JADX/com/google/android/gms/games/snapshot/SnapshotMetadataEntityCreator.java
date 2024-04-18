package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m4094a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataEntity.getVersionCode());
        C0542b.m1964a(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        C0542b.m1968a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        C0542b.m1964a(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        C0542b.m1968a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        C0542b.m1968a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        C0542b.m1968a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        C0542b.m1960a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        C0542b.m1960a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        C0542b.m1959a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        C0542b.m1968a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        C0542b.m1971a(parcel, 13, snapshotMetadataEntity.hasChangePending());
        C0542b.m1956H(parcel, H);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    gameEntity = (GameEntity) C0541a.m1922a(parcel, F, GameEntity.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    playerEntity = (PlayerEntity) C0541a.m1922a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    uri = (Uri) C0541a.m1922a(parcel, F, Uri.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    f = C0541a.m1938l(parcel, F);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    str5 = C0541a.m1941o(parcel, F);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    z = C0541a.m1929c(parcel, F);
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
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int i) {
        return new SnapshotMetadataEntity[i];
    }
}
