package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C1584a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C1589a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C1591a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C1597a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C1599a;
import com.google.android.gms.maps.model.internal.C1655g;
import com.google.android.gms.maps.model.internal.C1655g.C1657a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C1604c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C1606a extends Binder implements C1604c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C1605a implements C1604c {
            private IBinder le;

            C1605a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IMapViewDelegate m6148a(C0752d c0752d, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate aY = C1591a.aY(obtain2.readStrongBinder());
                    return aY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate m6149a(C0752d c0752d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate bt = C1599a.bt(obtain2.readStrongBinder());
                    return bt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m6150a(C0752d c0752d, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void m6151i(C0752d c0752d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m6152j(C0752d c0752d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate aX = C1589a.aX(obtain2.readStrongBinder());
                    return aX;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate m6153k(C0752d c0752d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate bs = C1597a.bs(obtain2.readStrongBinder());
                    return bs;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate nW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate aQ = C1584a.aQ(obtain2.readStrongBinder());
                    return aQ;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1655g nX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C1655g bv = C1657a.bv(obtain2.readStrongBinder());
                    return bv;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C1604c aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1604c)) ? new C1605a(iBinder) : (C1604c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m6145i(C0754a.ap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate j = m6146j(C0754a.ap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (j != null) {
                        iBinder = j.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m6142a(C0754a.ap(parcel.readStrongBinder()), parcel.readInt() != 0 ? GoogleMapOptions.CREATOR.cX(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate nW = nW();
                    parcel2.writeNoException();
                    if (nW != null) {
                        iBinder = nW.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C1655g nX = nX();
                    parcel2.writeNoException();
                    if (nX != null) {
                        iBinder = nX.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Error.OTHER /*6*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m6144a(C0754a.ap(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = m6143a(C0754a.ap(parcel.readStrongBinder()), parcel.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.cY(parcel) : null);
                    parcel2.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate k = m6147k(C0754a.ap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (k != null) {
                        iBinder = k.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IMapViewDelegate m6142a(C0752d c0752d, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate m6143a(C0752d c0752d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void m6144a(C0752d c0752d, int i) throws RemoteException;

    void m6145i(C0752d c0752d) throws RemoteException;

    IMapFragmentDelegate m6146j(C0752d c0752d) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate m6147k(C0752d c0752d) throws RemoteException;

    ICameraUpdateFactoryDelegate nW() throws RemoteException;

    C1655g nX() throws RemoteException;
}
