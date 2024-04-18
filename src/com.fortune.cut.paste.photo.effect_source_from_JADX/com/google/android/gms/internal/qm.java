package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.ads.AdSize;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;
import java.util.Arrays;

public final class qm extends qq<qm> {
    public C1474a[] ayq;

    /* renamed from: com.google.android.gms.internal.qm.a */
    public static final class C1474a extends qq<C1474a> {
        private static volatile C1474a[] ayr;
        public C1473a ays;
        public String name;

        /* renamed from: com.google.android.gms.internal.qm.a.a */
        public static final class C1473a extends qq<C1473a> {
            private static volatile C1473a[] ayt;
            public C1472a ayu;
            public int type;

            /* renamed from: com.google.android.gms.internal.qm.a.a.a */
            public static final class C1472a extends qq<C1472a> {
                public int ayA;
                public int ayB;
                public boolean ayC;
                public C1474a[] ayD;
                public C1473a[] ayE;
                public String[] ayF;
                public long[] ayG;
                public float[] ayH;
                public long ayI;
                public byte[] ayv;
                public String ayw;
                public double ayx;
                public float ayy;
                public long ayz;

                public C1472a() {
                    ry();
                }

                public final void m5912a(qp qpVar) throws IOException {
                    int i = 0;
                    if (!Arrays.equals(this.ayv, qz.azq)) {
                        qpVar.m5966a(1, this.ayv);
                    }
                    if (!this.ayw.equals("")) {
                        qpVar.m5970b(2, this.ayw);
                    }
                    if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0d)) {
                        qpVar.m5964a(3, this.ayx);
                    }
                    if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0f)) {
                        qpVar.m5968b(4, this.ayy);
                    }
                    if (this.ayz != 0) {
                        qpVar.m5969b(5, this.ayz);
                    }
                    if (this.ayA != 0) {
                        qpVar.m5979t(6, this.ayA);
                    }
                    if (this.ayB != 0) {
                        qpVar.m5981u(7, this.ayB);
                    }
                    if (this.ayC) {
                        qpVar.m5971b(8, this.ayC);
                    }
                    if (this.ayD != null && this.ayD.length > 0) {
                        for (qw qwVar : this.ayD) {
                            if (qwVar != null) {
                                qpVar.m5965a(9, qwVar);
                            }
                        }
                    }
                    if (this.ayE != null && this.ayE.length > 0) {
                        for (qw qwVar2 : this.ayE) {
                            if (qwVar2 != null) {
                                qpVar.m5965a(10, qwVar2);
                            }
                        }
                    }
                    if (this.ayF != null && this.ayF.length > 0) {
                        for (String str : this.ayF) {
                            if (str != null) {
                                qpVar.m5970b(11, str);
                            }
                        }
                    }
                    if (this.ayG != null && this.ayG.length > 0) {
                        for (long b : this.ayG) {
                            qpVar.m5969b(12, b);
                        }
                    }
                    if (this.ayI != 0) {
                        qpVar.m5969b(13, this.ayI);
                    }
                    if (this.ayH != null && this.ayH.length > 0) {
                        while (i < this.ayH.length) {
                            qpVar.m5968b(14, this.ayH[i]);
                            i++;
                        }
                    }
                    super.m2150a(qpVar);
                }

                public final /* synthetic */ qw m5913b(qo qoVar) throws IOException {
                    return m5915w(qoVar);
                }

                protected final int m5914c() {
                    int i;
                    int i2 = 0;
                    int c = super.m2153c();
                    if (!Arrays.equals(this.ayv, qz.azq)) {
                        c += qp.m5943b(1, this.ayv);
                    }
                    if (!this.ayw.equals("")) {
                        c += qp.m5954j(2, this.ayw);
                    }
                    if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0d)) {
                        c += qp.m5941b(3, this.ayx);
                    }
                    if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0f)) {
                        c += qp.m5945c(4, this.ayy);
                    }
                    if (this.ayz != 0) {
                        c += qp.m5948d(5, this.ayz);
                    }
                    if (this.ayA != 0) {
                        c += qp.m5957v(6, this.ayA);
                    }
                    if (this.ayB != 0) {
                        c += qp.m5958w(7, this.ayB);
                    }
                    if (this.ayC) {
                        c += qp.m5947c(8, this.ayC);
                    }
                    if (this.ayD != null && this.ayD.length > 0) {
                        i = c;
                        for (qw qwVar : this.ayD) {
                            if (qwVar != null) {
                                i += qp.m5946c(9, qwVar);
                            }
                        }
                        c = i;
                    }
                    if (this.ayE != null && this.ayE.length > 0) {
                        i = c;
                        for (qw qwVar2 : this.ayE) {
                            if (qwVar2 != null) {
                                i += qp.m5946c(10, qwVar2);
                            }
                        }
                        c = i;
                    }
                    if (this.ayF != null && this.ayF.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.ayF) {
                            if (str != null) {
                                i4++;
                                i3 += qp.dk(str);
                            }
                        }
                        c = (c + i3) + (i4 * 1);
                    }
                    if (this.ayG != null && this.ayG.length > 0) {
                        i = 0;
                        while (i2 < this.ayG.length) {
                            i += qp.m5936D(this.ayG[i2]);
                            i2++;
                        }
                        c = (c + i) + (this.ayG.length * 1);
                    }
                    if (this.ayI != 0) {
                        c += qp.m5948d(13, this.ayI);
                    }
                    return (this.ayH == null || this.ayH.length <= 0) ? c : (c + (this.ayH.length * 4)) + (this.ayH.length * 1);
                }

                public final boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof C1472a)) {
                        return false;
                    }
                    C1472a c1472a = (C1472a) obj;
                    if (!Arrays.equals(this.ayv, c1472a.ayv)) {
                        return false;
                    }
                    if (this.ayw == null) {
                        if (c1472a.ayw != null) {
                            return false;
                        }
                    } else if (!this.ayw.equals(c1472a.ayw)) {
                        return false;
                    }
                    return (Double.doubleToLongBits(this.ayx) == Double.doubleToLongBits(c1472a.ayx) && Float.floatToIntBits(this.ayy) == Float.floatToIntBits(c1472a.ayy) && this.ayz == c1472a.ayz && this.ayA == c1472a.ayA && this.ayB == c1472a.ayB && this.ayC == c1472a.ayC && qu.equals(this.ayD, c1472a.ayD) && qu.equals(this.ayE, c1472a.ayE) && qu.equals(this.ayF, c1472a.ayF) && qu.equals(this.ayG, c1472a.ayG) && qu.equals(this.ayH, c1472a.ayH) && this.ayI == c1472a.ayI) ? m2152a((qq) c1472a) : false;
                }

                public final int hashCode() {
                    int hashCode = (this.ayw == null ? 0 : this.ayw.hashCode()) + ((Arrays.hashCode(this.ayv) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.ayx);
                    return (((((((((((((((this.ayC ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.ayy)) * 31) + ((int) (this.ayz ^ (this.ayz >>> 32)))) * 31) + this.ayA) * 31) + this.ayB) * 31)) * 31) + qu.hashCode(this.ayD)) * 31) + qu.hashCode(this.ayE)) * 31) + qu.hashCode(this.ayF)) * 31) + qu.hashCode(this.ayG)) * 31) + qu.hashCode(this.ayH)) * 31) + ((int) (this.ayI ^ (this.ayI >>> 32)))) * 31) + rQ();
                }

                public final C1472a ry() {
                    this.ayv = qz.azq;
                    this.ayw = "";
                    this.ayx = 0.0d;
                    this.ayy = 0.0f;
                    this.ayz = 0;
                    this.ayA = 0;
                    this.ayB = 0;
                    this.ayC = false;
                    this.ayD = C1474a.ru();
                    this.ayE = C1473a.rw();
                    this.ayF = qz.azo;
                    this.ayG = qz.azk;
                    this.ayH = qz.azl;
                    this.ayI = 0;
                    this.ayW = null;
                    this.azh = -1;
                    return this;
                }

                public final C1472a m5915w(qo qoVar) throws IOException {
                    while (true) {
                        int rz = qoVar.rz();
                        int b;
                        Object obj;
                        int gS;
                        switch (rz) {
                            case WalletFragmentState.UNKNOWN /*0*/:
                                break;
                            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                                this.ayv = qoVar.readBytes();
                                continue;
                            case 18:
                                this.ayw = qoVar.readString();
                                continue;
                            case 25:
                                this.ayx = qoVar.readDouble();
                                continue;
                            case 37:
                                this.ayy = qoVar.readFloat();
                                continue;
                            case 40:
                                this.ayz = qoVar.rB();
                                continue;
                            case 48:
                                this.ayA = qoVar.rC();
                                continue;
                            case 56:
                                this.ayB = qoVar.rE();
                                continue;
                            case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                                this.ayC = qoVar.rD();
                                continue;
                            case 74:
                                b = qz.m6007b(qoVar, 74);
                                rz = this.ayD == null ? 0 : this.ayD.length;
                                obj = new C1474a[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayD, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = new C1474a();
                                    qoVar.m5933a(obj[rz]);
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = new C1474a();
                                qoVar.m5933a(obj[rz]);
                                this.ayD = obj;
                                continue;
                            case 82:
                                b = qz.m6007b(qoVar, 82);
                                rz = this.ayE == null ? 0 : this.ayE.length;
                                obj = new C1473a[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayE, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = new C1473a();
                                    qoVar.m5933a(obj[rz]);
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = new C1473a();
                                qoVar.m5933a(obj[rz]);
                                this.ayE = obj;
                                continue;
                            case AdSize.LARGE_AD_HEIGHT /*90*/:
                                b = qz.m6007b(qoVar, 90);
                                rz = this.ayF == null ? 0 : this.ayF.length;
                                obj = new String[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayF, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.readString();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.readString();
                                this.ayF = obj;
                                continue;
                            case 96:
                                b = qz.m6007b(qoVar, 96);
                                rz = this.ayG == null ? 0 : this.ayG.length;
                                obj = new long[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayG, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.rB();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.rB();
                                this.ayG = obj;
                                continue;
                            case 98:
                                gS = qoVar.gS(qoVar.rG());
                                b = qoVar.getPosition();
                                rz = 0;
                                while (qoVar.rL() > 0) {
                                    qoVar.rB();
                                    rz++;
                                }
                                qoVar.gU(b);
                                b = this.ayG == null ? 0 : this.ayG.length;
                                Object obj2 = new long[(rz + b)];
                                if (b != 0) {
                                    System.arraycopy(this.ayG, 0, obj2, 0, b);
                                }
                                while (b < obj2.length) {
                                    obj2[b] = qoVar.rB();
                                    b++;
                                }
                                this.ayG = obj2;
                                qoVar.gT(gS);
                                continue;
                            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                                this.ayI = qoVar.rB();
                                continue;
                            case 114:
                                rz = qoVar.rG();
                                b = qoVar.gS(rz);
                                gS = rz / 4;
                                rz = this.ayH == null ? 0 : this.ayH.length;
                                Object obj3 = new float[(gS + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayH, 0, obj3, 0, rz);
                                }
                                while (rz < obj3.length) {
                                    obj3[rz] = qoVar.readFloat();
                                    rz++;
                                }
                                this.ayH = obj3;
                                qoVar.gT(b);
                                continue;
                            case 117:
                                b = qz.m6007b(qoVar, 117);
                                rz = this.ayH == null ? 0 : this.ayH.length;
                                obj = new float[(b + rz)];
                                if (rz != 0) {
                                    System.arraycopy(this.ayH, 0, obj, 0, rz);
                                }
                                while (rz < obj.length - 1) {
                                    obj[rz] = qoVar.readFloat();
                                    qoVar.rz();
                                    rz++;
                                }
                                obj[rz] = qoVar.readFloat();
                                this.ayH = obj;
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
            }

            public C1473a() {
                rx();
            }

            public static C1473a[] rw() {
                if (ayt == null) {
                    synchronized (qu.azg) {
                        if (ayt == null) {
                            ayt = new C1473a[0];
                        }
                    }
                }
                return ayt;
            }

            public final void m5916a(qp qpVar) throws IOException {
                qpVar.m5979t(1, this.type);
                if (this.ayu != null) {
                    qpVar.m5965a(2, this.ayu);
                }
                super.m2150a(qpVar);
            }

            public final /* synthetic */ qw m5917b(qo qoVar) throws IOException {
                return m5919v(qoVar);
            }

            protected final int m5918c() {
                int c = super.m2153c() + qp.m5957v(1, this.type);
                return this.ayu != null ? c + qp.m5946c(2, this.ayu) : c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C1473a)) {
                    return false;
                }
                C1473a c1473a = (C1473a) obj;
                if (this.type != c1473a.type) {
                    return false;
                }
                if (this.ayu == null) {
                    if (c1473a.ayu != null) {
                        return false;
                    }
                } else if (!this.ayu.equals(c1473a.ayu)) {
                    return false;
                }
                return m2152a((qq) c1473a);
            }

            public final int hashCode() {
                return (((this.ayu == null ? 0 : this.ayu.hashCode()) + ((this.type + 527) * 31)) * 31) + rQ();
            }

            public final C1473a rx() {
                this.type = 1;
                this.ayu = null;
                this.ayW = null;
                this.azh = -1;
                return this;
            }

            public final C1473a m5919v(qo qoVar) throws IOException {
                while (true) {
                    int rz = qoVar.rz();
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
                                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                                case C0366R.styleable.MapAttrs_uiZoomGestures /*12*/:
                                case CommonStatusCodes.ERROR /*13*/:
                                case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                                case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                                    this.type = rz;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.ayu == null) {
                                this.ayu = new C1472a();
                            }
                            qoVar.m5933a(this.ayu);
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
        }

        public C1474a() {
            rv();
        }

        public static C1474a[] ru() {
            if (ayr == null) {
                synchronized (qu.azg) {
                    if (ayr == null) {
                        ayr = new C1474a[0];
                    }
                }
            }
            return ayr;
        }

        public final void m5920a(qp qpVar) throws IOException {
            qpVar.m5970b(1, this.name);
            if (this.ays != null) {
                qpVar.m5965a(2, this.ays);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5921b(qo qoVar) throws IOException {
            return m5923u(qoVar);
        }

        protected final int m5922c() {
            int c = super.m2153c() + qp.m5954j(1, this.name);
            return this.ays != null ? c + qp.m5946c(2, this.ays) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1474a)) {
                return false;
            }
            C1474a c1474a = (C1474a) obj;
            if (this.name == null) {
                if (c1474a.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1474a.name)) {
                return false;
            }
            if (this.ays == null) {
                if (c1474a.ays != null) {
                    return false;
                }
            } else if (!this.ays.equals(c1474a.ays)) {
                return false;
            }
            return m2152a((qq) c1474a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.ays != null) {
                i = this.ays.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1474a rv() {
            this.name = "";
            this.ays = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1474a m5923u(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.ays == null) {
                            this.ays = new C1473a();
                        }
                        qoVar.m5933a(this.ays);
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
    }

    public qm() {
        rt();
    }

    public static qm m5924n(byte[] bArr) throws qv {
        return (qm) qw.m2142a(new qm(), bArr);
    }

    public final void m5925a(qp qpVar) throws IOException {
        if (this.ayq != null && this.ayq.length > 0) {
            for (qw qwVar : this.ayq) {
                if (qwVar != null) {
                    qpVar.m5965a(1, qwVar);
                }
            }
        }
        super.m2150a(qpVar);
    }

    public final /* synthetic */ qw m5926b(qo qoVar) throws IOException {
        return m5928t(qoVar);
    }

    protected final int m5927c() {
        int c = super.m2153c();
        if (this.ayq != null && this.ayq.length > 0) {
            for (qw qwVar : this.ayq) {
                if (qwVar != null) {
                    c += qp.m5946c(1, qwVar);
                }
            }
        }
        return c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qm)) {
            return false;
        }
        qm qmVar = (qm) obj;
        return qu.equals(this.ayq, qmVar.ayq) ? m2152a((qq) qmVar) : false;
    }

    public final int hashCode() {
        return ((qu.hashCode(this.ayq) + 527) * 31) + rQ();
    }

    public final qm rt() {
        this.ayq = C1474a.ru();
        this.ayW = null;
        this.azh = -1;
        return this;
    }

    public final qm m5928t(qo qoVar) throws IOException {
        while (true) {
            int rz = qoVar.rz();
            switch (rz) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    break;
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    int b = qz.m6007b(qoVar, 10);
                    rz = this.ayq == null ? 0 : this.ayq.length;
                    Object obj = new C1474a[(b + rz)];
                    if (rz != 0) {
                        System.arraycopy(this.ayq, 0, obj, 0, rz);
                    }
                    while (rz < obj.length - 1) {
                        obj[rz] = new C1474a();
                        qoVar.m5933a(obj[rz]);
                        qoVar.rz();
                        rz++;
                    }
                    obj[rz] = new C1474a();
                    qoVar.m5933a(obj[rz]);
                    this.ayq = obj;
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
}
