package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0366R;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface ir extends IInterface {

    /* renamed from: com.google.android.gms.internal.ir.a */
    public static abstract class C1223a extends Binder implements ir {
        public C1223a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            io ioVar = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ad(parcel.readInt());
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    ApplicationMetadata applicationMetadata;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(parcel);
                    }
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m4977a(applicationMetadata, readString, readString2, z);
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ae(parcel.readInt());
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = parcel.readString();
                    double readDouble = parcel.readDouble();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m4978a(readString3, readDouble, z);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m4984j(parcel.readString(), parcel.readString());
                    return true;
                case Error.OTHER /*6*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m4983b(parcel.readString(), parcel.createByteArray());
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ag(parcel.readInt());
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    af(parcel.readInt());
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(parcel.readInt());
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m4980a(parcel.readString(), parcel.readLong(), parcel.readInt());
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m4979a(parcel.readString(), parcel.readLong());
                    return true;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    ij ijVar;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        ijVar = (ij) ij.CREATOR.createFromParcel(parcel);
                    }
                    m4981b(ijVar);
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        ioVar = (io) io.CREATOR.createFromParcel(parcel);
                    }
                    m4982b(ioVar);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m4977a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void m4978a(String str, double d, boolean z) throws RemoteException;

    void m4979a(String str, long j) throws RemoteException;

    void m4980a(String str, long j, int i) throws RemoteException;

    void ad(int i) throws RemoteException;

    void ae(int i) throws RemoteException;

    void af(int i) throws RemoteException;

    void ag(int i) throws RemoteException;

    void m4981b(ij ijVar) throws RemoteException;

    void m4982b(io ioVar) throws RemoteException;

    void m4983b(String str, byte[] bArr) throws RemoteException;

    void m4984j(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
