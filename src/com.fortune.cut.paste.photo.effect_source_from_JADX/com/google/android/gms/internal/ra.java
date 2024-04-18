package com.google.android.gms.internal;

import android.support.v4.util.TimeUtils;
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
import java.util.Arrays;

public interface ra {

    /* renamed from: com.google.android.gms.internal.ra.a */
    public static final class C1479a extends qq<C1479a> {
        public String[] azr;
        public String[] azs;
        public int[] azt;

        public C1479a() {
            sa();
        }

        public final void m6016a(qp qpVar) throws IOException {
            int i = 0;
            if (this.azr != null && this.azr.length > 0) {
                for (String str : this.azr) {
                    if (str != null) {
                        qpVar.m5970b(1, str);
                    }
                }
            }
            if (this.azs != null && this.azs.length > 0) {
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        qpVar.m5970b(2, str2);
                    }
                }
            }
            if (this.azt != null && this.azt.length > 0) {
                while (i < this.azt.length) {
                    qpVar.m5979t(3, this.azt[i]);
                    i++;
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m6017b(qo qoVar) throws IOException {
            return m6019y(qoVar);
        }

        protected final int m6018c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.m2153c();
            if (this.azr == null || this.azr.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.azr) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.azs != null && this.azs.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 1);
            }
            if (this.azt == null || this.azt.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.azt.length) {
                i2 += qp.gZ(this.azt[i4]);
                i4++;
            }
            return (i + i2) + (this.azt.length * 1);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1479a)) {
                return false;
            }
            C1479a c1479a = (C1479a) obj;
            return (qu.equals(this.azr, c1479a.azr) && qu.equals(this.azs, c1479a.azs) && qu.equals(this.azt, c1479a.azt)) ? m2152a((qq) c1479a) : false;
        }

        public final int hashCode() {
            return ((((((qu.hashCode(this.azr) + 527) * 31) + qu.hashCode(this.azs)) * 31) + qu.hashCode(this.azt)) * 31) + rQ();
        }

        public final C1479a sa() {
            this.azr = qz.azo;
            this.azs = qz.azo;
            this.azt = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1479a m6019y(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        b = qz.m6007b(qoVar, 10);
                        rz = this.azr == null ? 0 : this.azr.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azr = obj;
                        continue;
                    case 18:
                        b = qz.m6007b(qoVar, 18);
                        rz = this.azs == null ? 0 : this.azs.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azs, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azs = obj;
                        continue;
                    case 24:
                        b = qz.m6007b(qoVar, 24);
                        rz = this.azt == null ? 0 : this.azt.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azt, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.azt = obj;
                        continue;
                    case 26:
                        int gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.azt == null ? 0 : this.azt.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.azt, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.azt = obj2;
                        qoVar.gT(gS);
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

    /* renamed from: com.google.android.gms.internal.ra.b */
    public static final class C1480b extends qq<C1480b> {
        public int azu;
        public String azv;
        public String version;

        public C1480b() {
            sb();
        }

        public final void m6020a(qp qpVar) throws IOException {
            if (this.azu != 0) {
                qpVar.m5979t(1, this.azu);
            }
            if (!this.azv.equals("")) {
                qpVar.m5970b(2, this.azv);
            }
            if (!this.version.equals("")) {
                qpVar.m5970b(3, this.version);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m6021b(qo qoVar) throws IOException {
            return m6023z(qoVar);
        }

        protected final int m6022c() {
            int c = super.m2153c();
            if (this.azu != 0) {
                c += qp.m5957v(1, this.azu);
            }
            if (!this.azv.equals("")) {
                c += qp.m5954j(2, this.azv);
            }
            return !this.version.equals("") ? c + qp.m5954j(3, this.version) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1480b)) {
                return false;
            }
            C1480b c1480b = (C1480b) obj;
            if (this.azu != c1480b.azu) {
                return false;
            }
            if (this.azv == null) {
                if (c1480b.azv != null) {
                    return false;
                }
            } else if (!this.azv.equals(c1480b.azv)) {
                return false;
            }
            if (this.version == null) {
                if (c1480b.version != null) {
                    return false;
                }
            } else if (!this.version.equals(c1480b.version)) {
                return false;
            }
            return m2152a((qq) c1480b);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.azv == null ? 0 : this.azv.hashCode()) + ((this.azu + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1480b sb() {
            this.azu = 0;
            this.azv = "";
            this.version = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1480b m6023z(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        rz = qoVar.rC();
                        switch (rz) {
                            case WalletFragmentState.UNKNOWN /*0*/:
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
                            case 18:
                            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                            case 20:
                            case 21:
                            case 22:
                                this.azu = rz;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.azv = qoVar.readString();
                        continue;
                    case 26:
                        this.version = qoVar.readString();
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

    /* renamed from: com.google.android.gms.internal.ra.c */
    public static final class C1481c extends qq<C1481c> {
        public C1482d[] azA;
        public C1480b azB;
        public byte[] azC;
        public byte[] azD;
        public byte[] azE;
        public C1479a azF;
        public String azG;
        public long azH;
        public long azw;
        public int azx;
        public int azy;
        public boolean azz;
        public String tag;

        public C1481c() {
            sc();
        }

        public final C1481c m6024A(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        this.azw = qoVar.rB();
                        continue;
                    case 18:
                        this.tag = qoVar.readString();
                        continue;
                    case 26:
                        int b = qz.m6007b(qoVar, 26);
                        rz = this.azA == null ? 0 : this.azA.length;
                        Object obj = new C1482d[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1482d();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1482d();
                        qoVar.m5933a(obj[rz]);
                        this.azA = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.azC = qoVar.readBytes();
                        continue;
                    case 58:
                        if (this.azF == null) {
                            this.azF = new C1479a();
                        }
                        qoVar.m5933a(this.azF);
                        continue;
                    case 66:
                        this.azD = qoVar.readBytes();
                        continue;
                    case 74:
                        if (this.azB == null) {
                            this.azB = new C1480b();
                        }
                        qoVar.m5933a(this.azB);
                        continue;
                    case 80:
                        this.azz = qoVar.rD();
                        continue;
                    case 88:
                        this.azx = qoVar.rC();
                        continue;
                    case 96:
                        this.azy = qoVar.rC();
                        continue;
                    case 106:
                        this.azE = qoVar.readBytes();
                        continue;
                    case 114:
                        this.azG = qoVar.readString();
                        continue;
                    case 120:
                        this.azH = qoVar.rF();
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

        public final void m6025a(qp qpVar) throws IOException {
            if (this.azw != 0) {
                qpVar.m5969b(1, this.azw);
            }
            if (!this.tag.equals("")) {
                qpVar.m5970b(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        qpVar.m5965a(3, qwVar);
                    }
                }
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                qpVar.m5966a(6, this.azC);
            }
            if (this.azF != null) {
                qpVar.m5965a(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                qpVar.m5966a(8, this.azD);
            }
            if (this.azB != null) {
                qpVar.m5965a(9, this.azB);
            }
            if (this.azz) {
                qpVar.m5971b(10, this.azz);
            }
            if (this.azx != 0) {
                qpVar.m5979t(11, this.azx);
            }
            if (this.azy != 0) {
                qpVar.m5979t(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                qpVar.m5966a(13, this.azE);
            }
            if (!this.azG.equals("")) {
                qpVar.m5970b(14, this.azG);
            }
            if (this.azH != 0) {
                qpVar.m5973c(15, this.azH);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m6026b(qo qoVar) throws IOException {
            return m6024A(qoVar);
        }

        protected final int m6027c() {
            int c = super.m2153c();
            if (this.azw != 0) {
                c += qp.m5948d(1, this.azw);
            }
            if (!this.tag.equals("")) {
                c += qp.m5954j(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                int i = c;
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        i += qp.m5946c(3, qwVar);
                    }
                }
                c = i;
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                c += qp.m5943b(6, this.azC);
            }
            if (this.azF != null) {
                c += qp.m5946c(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                c += qp.m5943b(8, this.azD);
            }
            if (this.azB != null) {
                c += qp.m5946c(9, this.azB);
            }
            if (this.azz) {
                c += qp.m5947c(10, this.azz);
            }
            if (this.azx != 0) {
                c += qp.m5957v(11, this.azx);
            }
            if (this.azy != 0) {
                c += qp.m5957v(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                c += qp.m5943b(13, this.azE);
            }
            if (!this.azG.equals("")) {
                c += qp.m5954j(14, this.azG);
            }
            return this.azH != 0 ? c + qp.m5951e(15, this.azH) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1481c)) {
                return false;
            }
            C1481c c1481c = (C1481c) obj;
            if (this.azw != c1481c.azw) {
                return false;
            }
            if (this.tag == null) {
                if (c1481c.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(c1481c.tag)) {
                return false;
            }
            if (this.azx != c1481c.azx || this.azy != c1481c.azy || this.azz != c1481c.azz || !qu.equals(this.azA, c1481c.azA)) {
                return false;
            }
            if (this.azB == null) {
                if (c1481c.azB != null) {
                    return false;
                }
            } else if (!this.azB.equals(c1481c.azB)) {
                return false;
            }
            if (!Arrays.equals(this.azC, c1481c.azC) || !Arrays.equals(this.azD, c1481c.azD) || !Arrays.equals(this.azE, c1481c.azE)) {
                return false;
            }
            if (this.azF == null) {
                if (c1481c.azF != null) {
                    return false;
                }
            } else if (!this.azF.equals(c1481c.azF)) {
                return false;
            }
            if (this.azG == null) {
                if (c1481c.azG != null) {
                    return false;
                }
            } else if (!this.azG.equals(c1481c.azG)) {
                return false;
            }
            return this.azH == c1481c.azH ? m2152a((qq) c1481c) : false;
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.azF == null ? 0 : this.azF.hashCode()) + (((((((((this.azB == null ? 0 : this.azB.hashCode()) + (((((this.azz ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((int) (this.azw ^ (this.azw >>> 32))) + 527) * 31)) * 31) + this.azx) * 31) + this.azy) * 31)) * 31) + qu.hashCode(this.azA)) * 31)) * 31) + Arrays.hashCode(this.azC)) * 31) + Arrays.hashCode(this.azD)) * 31) + Arrays.hashCode(this.azE)) * 31)) * 31;
            if (this.azG != null) {
                i = this.azG.hashCode();
            }
            return ((((hashCode + i) * 31) + ((int) (this.azH ^ (this.azH >>> 32)))) * 31) + rQ();
        }

        public final C1481c sc() {
            this.azw = 0;
            this.tag = "";
            this.azx = 0;
            this.azy = 0;
            this.azz = false;
            this.azA = C1482d.sd();
            this.azB = null;
            this.azC = qz.azq;
            this.azD = qz.azq;
            this.azE = qz.azq;
            this.azF = null;
            this.azG = "";
            this.azH = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.ra.d */
    public static final class C1482d extends qq<C1482d> {
        private static volatile C1482d[] azI;
        public String fv;
        public String value;

        public C1482d() {
            se();
        }

        public static C1482d[] sd() {
            if (azI == null) {
                synchronized (qu.azg) {
                    if (azI == null) {
                        azI = new C1482d[0];
                    }
                }
            }
            return azI;
        }

        public final C1482d m6028B(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.fv = qoVar.readString();
                        continue;
                    case 18:
                        this.value = qoVar.readString();
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

        public final void m6029a(qp qpVar) throws IOException {
            if (!this.fv.equals("")) {
                qpVar.m5970b(1, this.fv);
            }
            if (!this.value.equals("")) {
                qpVar.m5970b(2, this.value);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m6030b(qo qoVar) throws IOException {
            return m6028B(qoVar);
        }

        protected final int m6031c() {
            int c = super.m2153c();
            if (!this.fv.equals("")) {
                c += qp.m5954j(1, this.fv);
            }
            return !this.value.equals("") ? c + qp.m5954j(2, this.value) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1482d)) {
                return false;
            }
            C1482d c1482d = (C1482d) obj;
            if (this.fv == null) {
                if (c1482d.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(c1482d.fv)) {
                return false;
            }
            if (this.value == null) {
                if (c1482d.value != null) {
                    return false;
                }
            } else if (!this.value.equals(c1482d.value)) {
                return false;
            }
            return m2152a((qq) c1482d);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1482d se() {
            this.fv = "";
            this.value = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
