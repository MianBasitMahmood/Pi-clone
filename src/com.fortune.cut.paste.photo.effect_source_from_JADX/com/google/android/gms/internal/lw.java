package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.wearable.DataEvent;

public interface lw extends IInterface {

    /* renamed from: com.google.android.gms.internal.lw.a */
    public static abstract class C1300a extends Binder implements lw {

        /* renamed from: com.google.android.gms.internal.lw.a.a */
        private static class C1299a implements lw {
            private IBinder le;

            C1299a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m5355a(DataReadResult dataReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataReadCallback");
                    if (dataReadResult != null) {
                        obtain.writeInt(1);
                        dataReadResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public C1300a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
        }

        public static lw as(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lw)) ? new C1299a(iBinder) : (lw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
                    m5354a(parcel.readInt() != 0 ? (DataReadResult) DataReadResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5354a(DataReadResult dataReadResult) throws RemoteException;
}
