package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.DataEvent;

public interface ih extends IInterface {

    /* renamed from: com.google.android.gms.internal.ih.a */
    public static abstract class C1215a extends Binder implements ih {

        /* renamed from: com.google.android.gms.internal.ih.a.a */
        private static class C1214a implements ih {
            private IBinder le;

            C1214a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m4972a(int i, String str, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m4973a(C1213if c1213if) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (c1213if != null) {
                        obtain.writeInt(1);
                        c1213if.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public C1215a() {
            attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        }

        public static ih m4974K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ih)) ? new C1214a(iBinder) : (ih) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            PendingIntent pendingIntent = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    C1213if t;
                    parcel.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (parcel.readInt() != 0) {
                        t = C1213if.CREATOR.m4969t(parcel);
                    }
                    m4971a(t);
                    parcel2.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel);
                    }
                    m4970a(readInt, readString, pendingIntent);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m4970a(int i, String str, PendingIntent pendingIntent) throws RemoteException;

    void m4971a(C1213if c1213if) throws RemoteException;
}
