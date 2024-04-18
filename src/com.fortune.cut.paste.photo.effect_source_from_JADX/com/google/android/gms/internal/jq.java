package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.DataEvent;

public interface jq extends IInterface {

    /* renamed from: com.google.android.gms.internal.jq.a */
    public static abstract class C1243a extends Binder implements jq {
        public C1243a() {
            attachInterface(this, "com.google.android.gms.common.internal.IAccountAccessor");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case DataEvent.TYPE_DELETED /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    Account hk = hk();
                    parcel2.writeNoException();
                    if (hk != null) {
                        parcel2.writeInt(1);
                        hk.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IAccountAccessor");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Account hk() throws RemoteException;
}
