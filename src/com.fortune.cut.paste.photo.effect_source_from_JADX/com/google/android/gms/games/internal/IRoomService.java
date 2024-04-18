package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.LocationStatusCodes;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder le;

            public void m3658R(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3659a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.le.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3660a(DataHolder dataHolder, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3661a(byte[] bArr, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3662a(byte[] bArr, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void bQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.le.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.le.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3663c(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.le.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.le.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3664v(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3665w(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z = false;
            switch (i) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3651a(parcel.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.aH(parcel.readStrongBinder()));
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lN();
                    return true;
                case 1003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lO();
                    return true;
                case 1004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3655c(parcel.readString(), parcel.readString(), parcel.readString());
                    return true;
                case 1005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lP();
                    return true;
                case 1006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder B = parcel.readInt() != 0 ? DataHolder.CREATOR.m1877B(parcel) : null;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m3652a(B, z);
                    return true;
                case 1007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    lQ();
                    return true;
                case 1008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    m3650R(z);
                    return true;
                case 1009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3653a(parcel.createByteArray(), parcel.readString(), parcel.readInt());
                    return true;
                case 1010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3654a(parcel.createByteArray(), parcel.createStringArray());
                    return true;
                case 1011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3656v(parcel.readString(), parcel.readInt());
                    return true;
                case 1012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m3657w(parcel.readString(), parcel.readInt());
                    return true;
                case 1013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    bQ(parcel.readString());
                    return true;
                case 1014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    bR(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m3650R(boolean z) throws RemoteException;

    void m3651a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException;

    void m3652a(DataHolder dataHolder, boolean z) throws RemoteException;

    void m3653a(byte[] bArr, String str, int i) throws RemoteException;

    void m3654a(byte[] bArr, String[] strArr) throws RemoteException;

    void bQ(String str) throws RemoteException;

    void bR(String str) throws RemoteException;

    void m3655c(String str, String str2, String str3) throws RemoteException;

    void lN() throws RemoteException;

    void lO() throws RemoteException;

    void lP() throws RemoteException;

    void lQ() throws RemoteException;

    void m3656v(String str, int i) throws RemoteException;

    void m3657w(String str, int i) throws RemoteException;
}
