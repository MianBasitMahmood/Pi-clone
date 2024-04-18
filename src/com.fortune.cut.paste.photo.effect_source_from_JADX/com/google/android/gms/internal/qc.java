package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.qe.C1457a;
import com.google.android.gms.internal.qf.C1459a;
import com.google.android.gms.wallet.C1847d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface qc extends IInterface {

    /* renamed from: com.google.android.gms.internal.qc.a */
    public static abstract class C1453a extends Binder implements qc {

        /* renamed from: com.google.android.gms.internal.qc.a.a */
        private static class C1452a implements qc {
            private IBinder le;

            C1452a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m5849a(Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5850a(pw pwVar, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (pwVar != null) {
                        obtain.writeInt(1);
                        pwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5851a(FullWalletRequest fullWalletRequest, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5852a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qe qeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qeVar != null) {
                        iBinder = qeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5853a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5854a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5855a(C1847d c1847d, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c1847d != null) {
                        obtain.writeInt(1);
                        c1847d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5856a(String str, String str2, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void m5857r(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5858s(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static qc bR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qc)) ? new C1452a(iBinder) : (qc) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5843a(parcel.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5841a(parcel.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5846a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5844a(parcel.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5839a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case Error.OTHER /*6*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5845a(parcel.readInt() != 0 ? (C1847d) C1847d.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5842a(parcel.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1457a.bT(parcel.readStrongBinder()));
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5840a(parcel.readInt() != 0 ? (pw) pw.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, C1459a.bU(parcel.readStrongBinder()));
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5847r(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m5848s(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5839a(Bundle bundle, qf qfVar) throws RemoteException;

    void m5840a(pw pwVar, Bundle bundle, qf qfVar) throws RemoteException;

    void m5841a(FullWalletRequest fullWalletRequest, Bundle bundle, qf qfVar) throws RemoteException;

    void m5842a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qe qeVar) throws RemoteException;

    void m5843a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qf qfVar) throws RemoteException;

    void m5844a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void m5845a(C1847d c1847d, Bundle bundle, qf qfVar) throws RemoteException;

    void m5846a(String str, String str2, Bundle bundle, qf qfVar) throws RemoteException;

    void m5847r(Bundle bundle) throws RemoteException;

    void m5848s(Bundle bundle) throws RemoteException;
}
