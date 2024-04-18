package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate.C1586a;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.m */
public interface C1549m extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.m.a */
    public static abstract class C1550a extends Binder implements C1549m {

        /* renamed from: com.google.android.gms.maps.internal.m.a.a */
        private static class C1620a implements C1549m {
            private IBinder le;

            C1620a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m6164a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    obtain.writeStrongBinder(iGoogleMapDelegate != null ? iGoogleMapDelegate.asBinder() : null);
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

        public C1550a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
        }

        public static C1549m bg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1549m)) ? new C1620a(iBinder) : (C1549m) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    m6118a(C1586a.aT(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m6118a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException;
}
