package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0752d;
import com.google.android.gms.dynamic.C0752d.C0754a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface IProjectionDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.IProjectionDelegate.a */
    public static abstract class C1593a extends Binder implements IProjectionDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IProjectionDelegate.a.a */
        private static class C1592a implements IProjectionDelegate {
            private IBinder le;

            C1592a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public LatLng fromScreenLocation(C0752d c0752d) throws RemoteException {
                LatLng latLng = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    obtain.writeStrongBinder(c0752d != null ? c0752d.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        latLng = LatLng.CREATOR.de(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return latLng;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLng fromScreenLocation2(C1632y c1632y) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (c1632y != null) {
                        obtain.writeInt(1);
                        c1632y.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    LatLng de = obtain2.readInt() != 0 ? LatLng.CREATOR.de(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return de;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public VisibleRegion getVisibleRegion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    VisibleRegion visibleRegion = obtain2.readInt() != 0 ? VisibleRegion.CREATOR.m6249do(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return visibleRegion;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0752d toScreenLocation(LatLng latLng) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0752d ap = C0754a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1632y toScreenLocation2(LatLng latLng) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C1632y cZ = obtain2.readInt() != 0 ? C1632y.CREATOR.cZ(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return cZ;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IProjectionDelegate bp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IProjectionDelegate)) ? new C1592a(iBinder) : (IProjectionDelegate) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            LatLng latLng = null;
            LatLng fromScreenLocation;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    fromScreenLocation = fromScreenLocation(C0754a.ap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (fromScreenLocation != null) {
                        parcel2.writeInt(1);
                        fromScreenLocation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    C0752d toScreenLocation = toScreenLocation(parcel.readInt() != 0 ? LatLng.CREATOR.de(parcel) : null);
                    parcel2.writeNoException();
                    if (toScreenLocation != null) {
                        asBinder = toScreenLocation.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    VisibleRegion visibleRegion = getVisibleRegion();
                    parcel2.writeNoException();
                    if (visibleRegion != null) {
                        parcel2.writeInt(1);
                        visibleRegion.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    C1632y cZ;
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (parcel.readInt() != 0) {
                        cZ = C1632y.CREATOR.cZ(parcel);
                    }
                    fromScreenLocation = fromScreenLocation2(cZ);
                    parcel2.writeNoException();
                    if (fromScreenLocation != null) {
                        parcel2.writeInt(1);
                        fromScreenLocation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (parcel.readInt() != 0) {
                        latLng = LatLng.CREATOR.de(parcel);
                    }
                    C1632y toScreenLocation2 = toScreenLocation2(latLng);
                    parcel2.writeNoException();
                    if (toScreenLocation2 != null) {
                        parcel2.writeInt(1);
                        toScreenLocation2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    LatLng fromScreenLocation(C0752d c0752d) throws RemoteException;

    LatLng fromScreenLocation2(C1632y c1632y) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    C0752d toScreenLocation(LatLng latLng) throws RemoteException;

    C1632y toScreenLocation2(LatLng latLng) throws RemoteException;
}
