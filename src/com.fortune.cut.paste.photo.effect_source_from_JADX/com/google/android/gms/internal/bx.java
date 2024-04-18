package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface bx extends IInterface {

    /* renamed from: com.google.android.gms.internal.bx.a */
    public static abstract class C1037a extends Binder implements bx {
        public C1037a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    m4273j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    aw();
                    parcel2.writeNoException();
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bB();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bC = bC();
                    parcel2.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case Error.OTHER /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bC = bI();
                    parcel2.writeNoException();
                    if (bC != null) {
                        iBinder = bC.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bE();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    bB = bJ();
                    parcel2.writeNoException();
                    parcel2.writeString(bB);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void aw() throws RemoteException;

    String bB() throws RemoteException;

    C0752d bC() throws RemoteException;

    String bE() throws RemoteException;

    C0752d bI() throws RemoteException;

    String bJ() throws RemoteException;

    String getBody() throws RemoteException;

    void m4273j(int i) throws RemoteException;
}
