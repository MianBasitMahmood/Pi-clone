package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C0677d implements Creator<FilterHolder> {
    static void m2427a(FilterHolder filterHolder, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, filterHolder.Sl, i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.CK);
        C0542b.m1964a(parcel, 2, filterHolder.Sm, i, false);
        C0542b.m1964a(parcel, 3, filterHolder.Sn, i, false);
        C0542b.m1964a(parcel, 4, filterHolder.So, i, false);
        C0542b.m1964a(parcel, 5, filterHolder.Sp, i, false);
        C0542b.m1964a(parcel, 6, filterHolder.Sq, i, false);
        C0542b.m1964a(parcel, 7, filterHolder.Sr, i, false);
        C0542b.m1956H(parcel, H);
    }

    public FilterHolder aV(Parcel parcel) {
        HasFilter hasFilter = null;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    comparisonFilter = (ComparisonFilter) C0541a.m1922a(parcel, F, ComparisonFilter.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) C0541a.m1922a(parcel, F, FieldOnlyFilter.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    logicalFilter = (LogicalFilter) C0541a.m1922a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    notFilter = (NotFilter) C0541a.m1922a(parcel, F, NotFilter.CREATOR);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    inFilter = (InFilter) C0541a.m1922a(parcel, F, InFilter.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    matchAllFilter = (MatchAllFilter) C0541a.m1922a(parcel, F, MatchAllFilter.CREATOR);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    hasFilter = (HasFilter) C0541a.m1922a(parcel, F, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public FilterHolder[] ck(int i) {
        return new FilterHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return aV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return ck(i);
    }
}
