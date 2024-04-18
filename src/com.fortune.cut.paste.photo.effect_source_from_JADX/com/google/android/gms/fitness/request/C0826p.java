package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.p */
public class C0826p implements Creator<C0825o> {
    static void m2766a(C0825o c0825o, Parcel parcel, int i) {
        int H = C0542b.m1955H(parcel);
        C0542b.m1964a(parcel, 1, c0825o.getDataSource(), i, false);
        C0542b.m1980c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0825o.getVersionCode());
        C0542b.m1964a(parcel, 2, c0825o.getDataType(), i, false);
        C0542b.m1962a(parcel, 3, c0825o.kg(), false);
        C0542b.m1980c(parcel, 4, c0825o.VX);
        C0542b.m1980c(parcel, 5, c0825o.VY);
        C0542b.m1960a(parcel, 6, c0825o.jI());
        C0542b.m1960a(parcel, 7, c0825o.kd());
        C0542b.m1964a(parcel, 8, c0825o.kb(), i, false);
        C0542b.m1960a(parcel, 9, c0825o.kc());
        C0542b.m1980c(parcel, 10, c0825o.getAccuracyMode());
        C0542b.m1981c(parcel, 11, c0825o.ke(), false);
        C0542b.m1960a(parcel, 12, c0825o.kf());
        C0542b.m1956H(parcel, H);
    }

    public C0825o bQ(Parcel parcel) {
        int G = C0541a.m1920G(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            switch (C0541a.aH(F)) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    dataSource = (DataSource) C0541a.m1922a(parcel, F, DataSource.CREATOR);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    dataType = (DataType) C0541a.m1922a(parcel, F, DataType.CREATOR);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    iBinder = C0541a.m1942p(parcel, F);
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    i2 = C0541a.m1933g(parcel, F);
                    break;
                case Dimension.UNIT_MM /*5*/:
                    i3 = C0541a.m1933g(parcel, F);
                    break;
                case Error.OTHER /*6*/:
                    j = C0541a.m1935i(parcel, F);
                    break;
                case Error.AVS_DECLINE /*7*/:
                    j2 = C0541a.m1935i(parcel, F);
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    pendingIntent = (PendingIntent) C0541a.m1922a(parcel, F, PendingIntent.CREATOR);
                    break;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    j3 = C0541a.m1935i(parcel, F);
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    i4 = C0541a.m1933g(parcel, F);
                    break;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    list = C0541a.m1928c(parcel, F, LocationRequest.CREATOR);
                    break;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    j4 = C0541a.m1935i(parcel, F);
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
            return new C0825o(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4);
        }
        throw new C0540a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return bQ(parcel);
    }

    public C0825o[] dk(int i) {
        return new C0825o[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return dk(i);
    }
}
