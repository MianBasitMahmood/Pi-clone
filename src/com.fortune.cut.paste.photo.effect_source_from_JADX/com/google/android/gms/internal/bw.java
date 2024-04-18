package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface bw extends IInterface {

    /* renamed from: com.google.android.gms.internal.bw.a */
    public static abstract class C1035a extends Binder implements bw {
        public C1035a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            String bB;
            C0752d bC;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    m4269j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    aw();
                    parcel2.writeNoException();
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bB();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bC = bC();
                    parcel2.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case Error.OTHER /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bC = bD();
                    parcel2.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bE();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double bF = bF();
                    parcel2.writeNoException();
                    parcel2.writeDouble(bF);
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bG();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bB = bH();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void aw() throws RemoteException;

    String bB() throws RemoteException;

    C0752d bC() throws RemoteException;

    C0752d bD() throws RemoteException;

    String bE() throws RemoteException;

    double bF() throws RemoteException;

    String bG() throws RemoteException;

    String bH() throws RemoteException;

    String getBody() throws RemoteException;

    void m4269j(int i) throws RemoteException;
}
