package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.location.LocationStatusCodes;

public interface IRoomServiceCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IRoomServiceCallbacks {

        private static class Proxy implements IRoomServiceCallbacks {
            private IBinder le;

            Proxy(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m3680a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.le.transact(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3681a(ConnectionInfo connectionInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1022, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3682a(String str, byte[] bArr, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.le.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3683a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aG(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1021, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void m3684b(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bS(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bT(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bU(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bV(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bW(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bX(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1019, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3685c(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.le.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3686c(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.le.transact(1018, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3687c(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3688d(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dX(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(1020, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3689e(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3690f(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3691g(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1017, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3692j(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1026, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.le.transact(1016, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lS() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.le.transact(1023, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1015, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m3693x(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1025, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        public static IRoomServiceCallbacks aH(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ParcelFileDescriptor parcelFileDescriptor = null;
            switch (i) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3671c(parcel.readInt(), parcel.readInt(), parcel.readString());
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3668a(parcel.readString(), parcel.createByteArray(), parcel.readInt());
                    return true;
                case 1003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bS(parcel.readString());
                    return true;
                case 1004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bT(parcel.readString());
                    return true;
                case 1005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bU(parcel.readString());
                    return true;
                case 1006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bV(parcel.readString());
                    return true;
                case 1007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bW(parcel.readString());
                    return true;
                case 1008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3669a(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3670b(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3673c(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3674d(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3675e(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3676f(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PConnected(parcel.readString());
                    return true;
                case 1015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PDisconnected(parcel.readString());
                    return true;
                case 1016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    lR();
                    return true;
                case 1017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3677g(parcel.readString(), parcel.createStringArray());
                    return true;
                case 1018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3672c(parcel.readString(), parcel.createByteArray());
                    return true;
                case 1019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bX(parcel.readString());
                    return true;
                case 1020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    dX(parcel.readInt());
                    return true;
                case 1021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aG(parcel.readStrongBinder());
                    return true;
                case 1022:
                    ConnectionInfo ct;
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        ct = ConnectionInfo.CREATOR.ct(parcel);
                    }
                    m3667a(ct);
                    return true;
                case 1023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    lS();
                    return true;
                case AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT /*1024*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                    }
                    m3666a(parcelFileDescriptor, parcel.readInt());
                    return true;
                case 1025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3679x(parcel.readString(), parcel.readInt());
                    return true;
                case 1026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m3678j(parcel.readString(), parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m3666a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException;

    void m3667a(ConnectionInfo connectionInfo) throws RemoteException;

    void m3668a(String str, byte[] bArr, int i) throws RemoteException;

    void m3669a(String str, String[] strArr) throws RemoteException;

    void aG(IBinder iBinder) throws RemoteException;

    void m3670b(String str, String[] strArr) throws RemoteException;

    void bS(String str) throws RemoteException;

    void bT(String str) throws RemoteException;

    void bU(String str) throws RemoteException;

    void bV(String str) throws RemoteException;

    void bW(String str) throws RemoteException;

    void bX(String str) throws RemoteException;

    void m3671c(int i, int i2, String str) throws RemoteException;

    void m3672c(String str, byte[] bArr) throws RemoteException;

    void m3673c(String str, String[] strArr) throws RemoteException;

    void m3674d(String str, String[] strArr) throws RemoteException;

    void dX(int i) throws RemoteException;

    void m3675e(String str, String[] strArr) throws RemoteException;

    void m3676f(String str, String[] strArr) throws RemoteException;

    void m3677g(String str, String[] strArr) throws RemoteException;

    void m3678j(String str, boolean z) throws RemoteException;

    void lR() throws RemoteException;

    void lS() throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void m3679x(String str, int i) throws RemoteException;
}
