package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.List;

public interface oq extends IInterface {

    /* renamed from: com.google.android.gms.internal.oq.a */
    public static abstract class C1412a extends Binder implements oq {

        /* renamed from: com.google.android.gms.internal.oq.a.a */
        private static class C1411a implements oq {
            private IBinder le;

            C1411a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m5725a(String str, ov ovVar, or orVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (orVar != null) {
                        obtain.writeInt(1);
                        orVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5726a(String str, ov ovVar, List<or> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5727a(String str, ov ovVar, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static oq bI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof oq)) ? new C1411a(iBinder) : (oq) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ov ovVar = null;
            String readString;
            switch (i) {
                case DataEvent.TYPE_DELETED /*2*/:
                    or dt;
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString2 = parcel.readString();
                    ov du = parcel.readInt() != 0 ? ov.CREATOR.du(parcel) : null;
                    if (parcel.readInt() != 0) {
                        dt = or.CREATOR.dt(parcel);
                    }
                    m5722a(readString2, du, dt);
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        ovVar = ov.CREATOR.du(parcel);
                    }
                    m5723a(readString, ovVar, parcel.createTypedArrayList(or.CREATOR));
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        ovVar = ov.CREATOR.du(parcel);
                    }
                    m5724a(readString, ovVar, parcel.createByteArray());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5722a(String str, ov ovVar, or orVar) throws RemoteException;

    void m5723a(String str, ov ovVar, List<or> list) throws RemoteException;

    void m5724a(String str, ov ovVar, byte[] bArr) throws RemoteException;
}
