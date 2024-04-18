package com.google.android.gms.fitness.data;

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
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.d */
public class C0769d implements Creator<Bucket> {
    static void m2655a(Bucket bucket, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1960a(parcel, 1, bucket.jo());
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, bucket.getVersionCode());
        C0542b.m1960a(parcel, 2, bucket.jp());
        C0542b.m1964a(parcel, 3, bucket.getSession(), i, false);
        C0542b.m1980c(parcel, 4, bucket.jm());
        C0542b.m1981c(parcel, 5, bucket.getDataSets(), false);
        C0542b.m1980c(parcel, 6, bucket.getBucketType());
        C0542b.m1971a(parcel, 7, bucket.jn());
        C0542b.m1956H(parcel, H);
    }

    public Bucket bs(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = C0541a.m1920G(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
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
                    session = (Session) C0541a.m1922a(parcel, F, Session.CREATOR);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    list = C0541a.m1928c(parcel, F, DataSet.CREATOR);
                    break;
                case Error.OTHER /*6*/:
                    i = C0541a.m1933g(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    z = C0541a.m1929c(parcel, F);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                default:
                    C0541a.m1926b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public Bucket[] cK(int i) {
        return new Bucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return cK(i);
    }
}
