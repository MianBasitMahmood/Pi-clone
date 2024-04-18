package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.fitness.request.C0808b;
import com.google.android.gms.fitness.request.C0813e;
import com.google.android.gms.fitness.request.C0818j;
import com.google.android.gms.fitness.request.C0823m;
import com.google.android.gms.fitness.request.C0825o;
import com.google.android.gms.fitness.request.C0827q;
import com.google.android.gms.fitness.request.C0831u;
import com.google.android.gms.fitness.request.C0835w;
import com.google.android.gms.fitness.request.C0839y;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.lw.C1300a;
import com.google.android.gms.internal.lx.C1302a;
import com.google.android.gms.internal.ly.C1304a;
import com.google.android.gms.internal.ma.C1308a;
import com.google.android.gms.internal.mb.C1310a;
import com.google.android.gms.internal.mc.C1312a;
import com.google.android.gms.internal.md.C1296a;
import com.google.android.gms.internal.mp.C1320a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public interface lz extends IInterface {

    /* renamed from: com.google.android.gms.internal.lz.a */
    public static abstract class C1306a extends Binder implements lz {

        /* renamed from: com.google.android.gms.internal.lz.a.a */
        private static class C1305a implements lz {
            private IBinder le;

            C1305a(IBinder iBinder) {
                this.le = iBinder;
            }

            public void m5384a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(mdVar != null ? mdVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m5385a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lwVar != null) {
                        iBinder = lwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5386a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lxVar != null) {
                        iBinder = lxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5387a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5388a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5389a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mbVar != null) {
                        iBinder = mbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5390a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5391a(aa aaVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (aaVar != null) {
                        obtain.writeInt(1);
                        aaVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(21, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5392a(ad adVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (adVar != null) {
                        obtain.writeInt(1);
                        adVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5393a(af afVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (afVar != null) {
                        obtain.writeInt(1);
                        afVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5394a(ah ahVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5395a(aj ajVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ajVar != null) {
                        obtain.writeInt(1);
                        ajVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5396a(C0808b c0808b, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0808b != null) {
                        obtain.writeInt(1);
                        c0808b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5397a(C0813e c0813e, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0813e != null) {
                        obtain.writeInt(1);
                        c0813e.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5398a(C0818j c0818j, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0818j != null) {
                        obtain.writeInt(1);
                        c0818j.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5399a(C0823m c0823m, ma maVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0823m != null) {
                        obtain.writeInt(1);
                        c0823m.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (maVar != null) {
                        iBinder = maVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5400a(C0825o c0825o, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0825o != null) {
                        obtain.writeInt(1);
                        c0825o.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5401a(C0827q c0827q, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0827q != null) {
                        obtain.writeInt(1);
                        c0827q.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5402a(C0831u c0831u, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0831u != null) {
                        obtain.writeInt(1);
                        c0831u.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5403a(C0835w c0835w, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0835w != null) {
                        obtain.writeInt(1);
                        c0835w.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5404a(C0839y c0839y, mc mcVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0839y != null) {
                        obtain.writeInt(1);
                        c0839y.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mcVar != null) {
                        iBinder = mcVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5405a(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m5406a(mp mpVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mpVar != null) {
                        iBinder = mpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void m5407b(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(23, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static lz av(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lz)) ? new C1305a(iBinder) : (lz) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            aa aaVar = null;
            switch (i) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    DataSourcesRequest dataSourcesRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5362a(dataSourcesRequest, C1302a.at(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case DataEvent.TYPE_DELETED /*2*/:
                    C0825o c0825o;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0825o = (C0825o) C0825o.CREATOR.createFromParcel(parcel);
                    }
                    m5376a(c0825o, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case WalletFragmentState.PROCESSING /*3*/:
                    C0827q c0827q;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0827q = (C0827q) C0827q.CREATOR.createFromParcel(parcel);
                    }
                    m5377a(c0827q, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    af afVar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        afVar = (af) af.CREATOR.createFromParcel(parcel);
                    }
                    m5369a(afVar, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    aj ajVar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        ajVar = (aj) aj.CREATOR.createFromParcel(parcel);
                    }
                    m5371a(ajVar, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case Error.OTHER /*6*/:
                    C0823m c0823m;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0823m = (C0823m) C0823m.CREATOR.createFromParcel(parcel);
                    }
                    m5375a(c0823m, C1308a.aw(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case Error.AVS_DECLINE /*7*/:
                    C0813e c0813e;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0813e = (C0813e) C0813e.CREATOR.createFromParcel(parcel);
                    }
                    m5373a(c0813e, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case Error.FRAUD_DECLINE /*8*/:
                    DataReadRequest dataReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5361a(dataReadRequest, C1300a.as(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                    SessionInsertRequest sessionInsertRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5364a(sessionInsertRequest, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    SessionReadRequest sessionReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5365a(sessionReadRequest, C1310a.ax(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    C0835w c0835w;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0835w = (C0835w) C0835w.CREATOR.createFromParcel(parcel);
                    }
                    m5379a(c0835w, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                    C0839y c0839y;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0839y = (C0839y) C0839y.CREATOR.createFromParcel(parcel);
                    }
                    m5380a(c0839y, C1312a.ay(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case CommonStatusCodes.ERROR /*13*/:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5363a(dataTypeCreateRequest, C1304a.au(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                    C0818j c0818j;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0818j = (C0818j) C0818j.CREATOR.createFromParcel(parcel);
                    }
                    m5374a(c0818j, C1304a.au(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                    StartBleScanRequest startBleScanRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5366a(startBleScanRequest, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    ad adVar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        adVar = (ad) ad.CREATOR.createFromParcel(parcel);
                    }
                    m5368a(adVar, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 17:
                    C0808b c0808b;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0808b = (C0808b) C0808b.CREATOR.createFromParcel(parcel);
                    }
                    m5372a(c0808b, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 18:
                    ah ahVar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        ahVar = (ah) ah.CREATOR.createFromParcel(parcel);
                    }
                    m5370a(ahVar, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    DataDeleteRequest dataDeleteRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(parcel);
                    }
                    m5360a(dataDeleteRequest, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    C0831u c0831u;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        c0831u = (C0831u) C0831u.CREATOR.createFromParcel(parcel);
                    }
                    m5378a(c0831u, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (parcel.readInt() != 0) {
                        aaVar = (aa) aa.CREATOR.createFromParcel(parcel);
                    }
                    m5367a(aaVar, C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    m5381a(C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    m5383b(C1296a.az(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    m5382a(C1320a.aA(parcel.readStrongBinder()), parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m5360a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException;

    void m5361a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException;

    void m5362a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException;

    void m5363a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException;

    void m5364a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException;

    void m5365a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException;

    void m5366a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException;

    void m5367a(aa aaVar, md mdVar, String str) throws RemoteException;

    void m5368a(ad adVar, md mdVar, String str) throws RemoteException;

    void m5369a(af afVar, md mdVar, String str) throws RemoteException;

    void m5370a(ah ahVar, md mdVar, String str) throws RemoteException;

    void m5371a(aj ajVar, md mdVar, String str) throws RemoteException;

    void m5372a(C0808b c0808b, md mdVar, String str) throws RemoteException;

    void m5373a(C0813e c0813e, md mdVar, String str) throws RemoteException;

    void m5374a(C0818j c0818j, ly lyVar, String str) throws RemoteException;

    void m5375a(C0823m c0823m, ma maVar, String str) throws RemoteException;

    void m5376a(C0825o c0825o, md mdVar, String str) throws RemoteException;

    void m5377a(C0827q c0827q, md mdVar, String str) throws RemoteException;

    void m5378a(C0831u c0831u, md mdVar, String str) throws RemoteException;

    void m5379a(C0835w c0835w, md mdVar, String str) throws RemoteException;

    void m5380a(C0839y c0839y, mc mcVar, String str) throws RemoteException;

    void m5381a(md mdVar, String str) throws RemoteException;

    void m5382a(mp mpVar, String str) throws RemoteException;

    void m5383b(md mdVar, String str) throws RemoteException;
}
