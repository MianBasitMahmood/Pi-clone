package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.lx.C1302a;
import com.google.android.gms.internal.md.C1296a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface mu extends IInterface {

    /* renamed from: com.google.android.gms.internal.mu.a */
    public static abstract class C0849a extends Binder implements mu {
        public C0849a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ms msVar = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    mq mqVar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        mqVar = (mq) mq.CREATOR.createFromParcel(parcel);
                    }
                    m2806a(mqVar, C1302a.at(parcel.readStrongBinder()));
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    m2805a(fitnessSensorServiceRequest, C1296a.az(parcel.readStrongBinder()));
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        msVar = (ms) ms.CREATOR.createFromParcel(parcel);
                    }
                    m2807a(msVar, C1296a.az(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m2805a(FitnessSensorServiceRequest fitnessSensorServiceRequest, md mdVar) throws RemoteException;

    void m2806a(mq mqVar, lx lxVar) throws RemoteException;

    void m2807a(ms msVar, md mdVar) throws RemoteException;
}
