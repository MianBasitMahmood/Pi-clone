package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.ads.AdSize;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C1071d {

    /* renamed from: com.google.android.gms.internal.d.a */
    public static final class C1070a extends qq<C1070a> {
        private static volatile C1070a[] gu;
        public String gA;
        public long gB;
        public boolean gC;
        public C1070a[] gD;
        public int[] gE;
        public boolean gF;
        public String gv;
        public C1070a[] gw;
        public C1070a[] gx;
        public C1070a[] gy;
        public String gz;
        public int type;

        public C1070a() {
            m4405s();
        }

        public static C1070a[] m4400r() {
            if (gu == null) {
                synchronized (qu.azg) {
                    if (gu == null) {
                        gu = new C1070a[0];
                    }
                }
            }
            return gu;
        }

        public final void m4401a(qp qpVar) throws IOException {
            int i = 0;
            qpVar.m5979t(1, this.type);
            if (!this.gv.equals("")) {
                qpVar.m5970b(2, this.gv);
            }
            if (this.gw != null && this.gw.length > 0) {
                for (qw qwVar : this.gw) {
                    if (qwVar != null) {
                        qpVar.m5965a(3, qwVar);
                    }
                }
            }
            if (this.gx != null && this.gx.length > 0) {
                for (qw qwVar2 : this.gx) {
                    if (qwVar2 != null) {
                        qpVar.m5965a(4, qwVar2);
                    }
                }
            }
            if (this.gy != null && this.gy.length > 0) {
                for (qw qwVar22 : this.gy) {
                    if (qwVar22 != null) {
                        qpVar.m5965a(5, qwVar22);
                    }
                }
            }
            if (!this.gz.equals("")) {
                qpVar.m5970b(6, this.gz);
            }
            if (!this.gA.equals("")) {
                qpVar.m5970b(7, this.gA);
            }
            if (this.gB != 0) {
                qpVar.m5969b(8, this.gB);
            }
            if (this.gF) {
                qpVar.m5971b(9, this.gF);
            }
            if (this.gE != null && this.gE.length > 0) {
                for (int t : this.gE) {
                    qpVar.m5979t(10, t);
                }
            }
            if (this.gD != null && this.gD.length > 0) {
                while (i < this.gD.length) {
                    qw qwVar3 = this.gD[i];
                    if (qwVar3 != null) {
                        qpVar.m5965a(11, qwVar3);
                    }
                    i++;
                }
            }
            if (this.gC) {
                qpVar.m5971b(12, this.gC);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4402b(qo qoVar) throws IOException {
            return m4404l(qoVar);
        }

        protected final int m4403c() {
            int i;
            int i2 = 0;
            int c = super.m2153c() + qp.m5957v(1, this.type);
            if (!this.gv.equals("")) {
                c += qp.m5954j(2, this.gv);
            }
            if (this.gw != null && this.gw.length > 0) {
                i = c;
                for (qw qwVar : this.gw) {
                    if (qwVar != null) {
                        i += qp.m5946c(3, qwVar);
                    }
                }
                c = i;
            }
            if (this.gx != null && this.gx.length > 0) {
                i = c;
                for (qw qwVar2 : this.gx) {
                    if (qwVar2 != null) {
                        i += qp.m5946c(4, qwVar2);
                    }
                }
                c = i;
            }
            if (this.gy != null && this.gy.length > 0) {
                i = c;
                for (qw qwVar22 : this.gy) {
                    if (qwVar22 != null) {
                        i += qp.m5946c(5, qwVar22);
                    }
                }
                c = i;
            }
            if (!this.gz.equals("")) {
                c += qp.m5954j(6, this.gz);
            }
            if (!this.gA.equals("")) {
                c += qp.m5954j(7, this.gA);
            }
            if (this.gB != 0) {
                c += qp.m5948d(8, this.gB);
            }
            if (this.gF) {
                c += qp.m5947c(9, this.gF);
            }
            if (this.gE != null && this.gE.length > 0) {
                int i3 = 0;
                for (int gZ : this.gE) {
                    i3 += qp.gZ(gZ);
                }
                c = (c + i3) + (this.gE.length * 1);
            }
            if (this.gD != null && this.gD.length > 0) {
                while (i2 < this.gD.length) {
                    qw qwVar3 = this.gD[i2];
                    if (qwVar3 != null) {
                        c += qp.m5946c(11, qwVar3);
                    }
                    i2++;
                }
            }
            return this.gC ? c + qp.m5947c(12, this.gC) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1070a)) {
                return false;
            }
            C1070a c1070a = (C1070a) obj;
            if (this.type != c1070a.type) {
                return false;
            }
            if (this.gv == null) {
                if (c1070a.gv != null) {
                    return false;
                }
            } else if (!this.gv.equals(c1070a.gv)) {
                return false;
            }
            if (!qu.equals(this.gw, c1070a.gw) || !qu.equals(this.gx, c1070a.gx) || !qu.equals(this.gy, c1070a.gy)) {
                return false;
            }
            if (this.gz == null) {
                if (c1070a.gz != null) {
                    return false;
                }
            } else if (!this.gz.equals(c1070a.gz)) {
                return false;
            }
            if (this.gA == null) {
                if (c1070a.gA != null) {
                    return false;
                }
            } else if (!this.gA.equals(c1070a.gA)) {
                return false;
            }
            return (this.gB == c1070a.gB && this.gC == c1070a.gC && qu.equals(this.gD, c1070a.gD) && qu.equals(this.gE, c1070a.gE) && this.gF == c1070a.gF) ? m2152a((qq) c1070a) : false;
        }

        public final int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.gz == null ? 0 : this.gz.hashCode()) + (((((((((this.gv == null ? 0 : this.gv.hashCode()) + ((this.type + 527) * 31)) * 31) + qu.hashCode(this.gw)) * 31) + qu.hashCode(this.gx)) * 31) + qu.hashCode(this.gy)) * 31)) * 31;
            if (this.gA != null) {
                i2 = this.gA.hashCode();
            }
            hashCode = ((((((this.gC ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.gB ^ (this.gB >>> 32)))) * 31)) * 31) + qu.hashCode(this.gD)) * 31) + qu.hashCode(this.gE)) * 31;
            if (!this.gF) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1070a m4404l(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int i;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        rz = qoVar.rC();
                        switch (rz) {
                            case DataEvent.TYPE_CHANGED /*1*/:
                            case DataEvent.TYPE_DELETED /*2*/:
                            case WalletFragmentState.PROCESSING /*3*/:
                            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                            case Dimension.UNIT_MM /*5*/:
                            case Error.OTHER /*6*/:
                            case Error.AVS_DECLINE /*7*/:
                            case Error.FRAUD_DECLINE /*8*/:
                                this.type = rz;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.gv = qoVar.readString();
                        continue;
                    case 26:
                        b = qz.m6007b(qoVar, 26);
                        rz = this.gw == null ? 0 : this.gw.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gw, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.gw = obj;
                        continue;
                    case 34:
                        b = qz.m6007b(qoVar, 34);
                        rz = this.gx == null ? 0 : this.gx.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gx, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.gx = obj;
                        continue;
                    case 42:
                        b = qz.m6007b(qoVar, 42);
                        rz = this.gy == null ? 0 : this.gy.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gy, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.gy = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.gz = qoVar.readString();
                        continue;
                    case 58:
                        this.gA = qoVar.readString();
                        continue;
                    case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                        this.gB = qoVar.rB();
                        continue;
                    case 72:
                        this.gF = qoVar.rD();
                        continue;
                    case 80:
                        int b2 = qz.m6007b(qoVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                qoVar.rz();
                            }
                            int rC = qoVar.rC();
                            switch (rC) {
                                case DataEvent.TYPE_CHANGED /*1*/:
                                case DataEvent.TYPE_DELETED /*2*/:
                                case WalletFragmentState.PROCESSING /*3*/:
                                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                                case Dimension.UNIT_MM /*5*/:
                                case Error.OTHER /*6*/:
                                case Error.AVS_DECLINE /*7*/:
                                case Error.FRAUD_DECLINE /*8*/:
                                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case CommonStatusCodes.ERROR /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                case 17:
                                    rz = b + 1;
                                    obj2[b] = rC;
                                    break;
                                default:
                                    rz = b;
                                    break;
                            }
                            i++;
                            b = rz;
                        }
                        if (b != 0) {
                            rz = this.gE == null ? 0 : this.gE.length;
                            if (rz != 0 || b != obj2.length) {
                                Object obj3 = new int[(rz + b)];
                                if (rz != 0) {
                                    System.arraycopy(this.gE, 0, obj3, 0, rz);
                                }
                                System.arraycopy(obj2, 0, obj3, rz, b);
                                this.gE = obj3;
                                break;
                            }
                            this.gE = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            switch (qoVar.rC()) {
                                case DataEvent.TYPE_CHANGED /*1*/:
                                case DataEvent.TYPE_DELETED /*2*/:
                                case WalletFragmentState.PROCESSING /*3*/:
                                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                                case Dimension.UNIT_MM /*5*/:
                                case Error.OTHER /*6*/:
                                case Error.AVS_DECLINE /*7*/:
                                case Error.FRAUD_DECLINE /*8*/:
                                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case CommonStatusCodes.ERROR /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                case 17:
                                    rz++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (rz != 0) {
                            qoVar.gU(b);
                            b = this.gE == null ? 0 : this.gE.length;
                            Object obj4 = new int[(rz + b)];
                            if (b != 0) {
                                System.arraycopy(this.gE, 0, obj4, 0, b);
                            }
                            while (qoVar.rL() > 0) {
                                int rC2 = qoVar.rC();
                                switch (rC2) {
                                    case DataEvent.TYPE_CHANGED /*1*/:
                                    case DataEvent.TYPE_DELETED /*2*/:
                                    case WalletFragmentState.PROCESSING /*3*/:
                                    case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                                    case Dimension.UNIT_MM /*5*/:
                                    case Error.OTHER /*6*/:
                                    case Error.AVS_DECLINE /*7*/:
                                    case Error.FRAUD_DECLINE /*8*/:
                                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                                    case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                                    case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                    case CommonStatusCodes.ERROR /*13*/:
                                    case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                    case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                                    case 17:
                                        rz = b + 1;
                                        obj4[b] = rC2;
                                        b = rz;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.gE = obj4;
                        }
                        qoVar.gT(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        b = qz.m6007b(qoVar, 90);
                        rz = this.gD == null ? 0 : this.gD.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gD, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.gD = obj;
                        continue;
                    case 96:
                        this.gC = qoVar.rD();
                        continue;
                    default:
                        if (!m2151a(qoVar, rz)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final C1070a m4405s() {
            this.type = 1;
            this.gv = "";
            this.gw = C1070a.m4400r();
            this.gx = C1070a.m4400r();
            this.gy = C1070a.m4400r();
            this.gz = "";
            this.gA = "";
            this.gB = 0;
            this.gC = false;
            this.gD = C1070a.m4400r();
            this.gE = qz.azj;
            this.gF = false;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
