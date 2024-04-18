package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.b */
public class C0697b implements Creator<ParcelableEvent> {
    static void m2450a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1980c(parcel, 1, parcelableEvent.CK);
        C0542b.m1968a(parcel, 2, parcelableEvent.vZ, false);
        C0542b.m1968a(parcel, 3, parcelableEvent.SJ, false);
        C0542b.m1979b(parcel, 4, parcelableEvent.SQ, false);
        C0542b.m1971a(parcel, 5, parcelableEvent.SR);
        C0542b.m1968a(parcel, 6, parcelableEvent.SM, false);
        C0542b.m1968a(parcel, 7, parcelableEvent.SS, false);
        C0542b.m1964a(parcel, 8, parcelableEvent.ST, i, false);
        C0542b.m1964a(parcel, 9, parcelableEvent.SU, i, false);
        C0542b.m1964a(parcel, 10, parcelableEvent.SV, i, false);
        C0542b.m1964a(parcel, 11, parcelableEvent.SW, i, false);
        C0542b.m1964a(parcel, 12, parcelableEvent.SX, i, false);
        C0542b.m1964a(parcel, 13, parcelableEvent.SY, i, false);
        C0542b.m1964a(parcel, 14, parcelableEvent.SZ, i, false);
        C0542b.m1964a(parcel, 15, parcelableEvent.Ta, i, false);
        C0542b.m1956H(parcel, H);
    }

    public ParcelableEvent bh(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    str = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    str2 = C0541a.m1941o(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    list = C0541a.m1916C(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    str3 = C0541a.m1941o(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    str4 = C0541a.m1941o(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    textInsertedDetails = (TextInsertedDetails) C0541a.m1922a(parcel, F, TextInsertedDetails.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    textDeletedDetails = (TextDeletedDetails) C0541a.m1922a(parcel, F, TextDeletedDetails.CREATOR);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    valuesAddedDetails = (ValuesAddedDetails) C0541a.m1922a(parcel, F, ValuesAddedDetails.CREATOR);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    valuesRemovedDetails = (ValuesRemovedDetails) C0541a.m1922a(parcel, F, ValuesRemovedDetails.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    valuesSetDetails = (ValuesSetDetails) C0541a.m1922a(parcel, F, ValuesSetDetails.CREATOR);
                    break;
                case CommonStatusCodes.ERROR /*13*/:
                    valueChangedDetails = (ValueChangedDetails) C0541a.m1922a(parcel, F, ValueChangedDetails.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    referenceShiftedDetails = (ReferenceShiftedDetails) C0541a.m1922a(parcel, F, ReferenceShiftedDetails.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    objectChangedDetails = (ObjectChangedDetails) C0541a.m1922a(parcel, F, ObjectChangedDetails.CREATOR);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEvent(i, str, str2, list, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bh(parcel);
    }

    public ParcelableEvent[] cx(int i) {
        return new ParcelableEvent[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cx(i);
    }
}
