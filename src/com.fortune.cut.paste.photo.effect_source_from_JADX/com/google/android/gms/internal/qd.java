package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0748c;
import com.google.android.gms.dynamic.C0748c.C0749a;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.internal.qa.C1449a;
import com.google.android.gms.internal.qb.C1451a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wearable.DataEvent;

public interface qd extends IInterface {

    /* renamed from: com.google.android.gms.internal.qd.a */
    public static abstract class C1455a extends Binder implements qd {

        /* renamed from: com.google.android.gms.internal.qd.a.a */
        private static class C1454a implements qd {
            private IBinder le;

            C1454a(IBinder iBinder) {
                this.le = iBinder;
            }

            public qa m5860a(C0752d c0752d, C0748c c0748c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    obtain.writeStrongBinder(c0748c != null ? c0748c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qbVar != null) {
                        iBinder = qbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    qa bP = C1449a.bP(obtain2.readStrongBinder());
                    return bP;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static qd bS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qd)) ? new C1454a(iBinder) : (qd) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    qa a = m5859a(C0754a.ap(parcel.readStrongBinder()), C0749a.ao(parcel.readStrongBinder()), parcel.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(parcel) : null, C1451a.bQ(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    qa m5859a(C0752d c0752d, C0748c c0748c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException;
}
