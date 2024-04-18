package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.ads.AdSize;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C1048c {

    /* renamed from: com.google.android.gms.internal.c.a */
    public static final class C1038a extends qq<C1038a> {
        public int fn;
        public int fo;
        public int level;

        public C1038a() {
            m4281b();
        }

        public final C1038a m4279a(qo qoVar) throws IOException {
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
                                this.level = rz;
                                break;
                            default:
                                continue;
                        }
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.fn = qoVar.rC();
                        continue;
                    case 24:
                        this.fo = qoVar.rC();
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

        public final void m4280a(qp qpVar) throws IOException {
            if (this.level != 1) {
                qpVar.m5979t(1, this.level);
            }
            if (this.fn != 0) {
                qpVar.m5979t(2, this.fn);
            }
            if (this.fo != 0) {
                qpVar.m5979t(3, this.fo);
            }
            super.m2150a(qpVar);
        }

        public final C1038a m4281b() {
            this.level = 1;
            this.fn = 0;
            this.fo = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final /* synthetic */ qw m4282b(qo qoVar) throws IOException {
            return m4279a(qoVar);
        }

        protected final int m4283c() {
            int c = super.m2153c();
            if (this.level != 1) {
                c += qp.m5957v(1, this.level);
            }
            if (this.fn != 0) {
                c += qp.m5957v(2, this.fn);
            }
            return this.fo != 0 ? c + qp.m5957v(3, this.fo) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1038a)) {
                return false;
            }
            C1038a c1038a = (C1038a) obj;
            return (this.level == c1038a.level && this.fn == c1038a.fn && this.fo == c1038a.fo) ? m2152a((qq) c1038a) : false;
        }

        public final int hashCode() {
            return ((((((this.level + 527) * 31) + this.fn) * 31) + this.fo) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c.b */
    public static final class C1039b extends qq<C1039b> {
        private static volatile C1039b[] fp;
        public int[] fq;
        public int fr;
        public boolean fs;
        public boolean ft;
        public int name;

        public C1039b() {
            m4289e();
        }

        public static C1039b[] m4284d() {
            if (fp == null) {
                synchronized (qu.azg) {
                    if (fp == null) {
                        fp = new C1039b[0];
                    }
                }
            }
            return fp;
        }

        public final void m4285a(qp qpVar) throws IOException {
            if (this.ft) {
                qpVar.m5971b(1, this.ft);
            }
            qpVar.m5979t(2, this.fr);
            if (this.fq != null && this.fq.length > 0) {
                for (int t : this.fq) {
                    qpVar.m5979t(3, t);
                }
            }
            if (this.name != 0) {
                qpVar.m5979t(4, this.name);
            }
            if (this.fs) {
                qpVar.m5971b(6, this.fs);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4286b(qo qoVar) throws IOException {
            return m4288c(qoVar);
        }

        protected final int m4287c() {
            int i = 0;
            int c = super.m2153c();
            if (this.ft) {
                c += qp.m5947c(1, this.ft);
            }
            int v = qp.m5957v(2, this.fr) + c;
            if (this.fq == null || this.fq.length <= 0) {
                c = v;
            } else {
                for (int gZ : this.fq) {
                    i += qp.gZ(gZ);
                }
                c = (v + i) + (this.fq.length * 1);
            }
            if (this.name != 0) {
                c += qp.m5957v(4, this.name);
            }
            return this.fs ? c + qp.m5947c(6, this.fs) : c;
        }

        public final C1039b m4288c(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        this.ft = qoVar.rD();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.fr = qoVar.rC();
                        continue;
                    case 24:
                        b = qz.m6007b(qoVar, 24);
                        rz = this.fq == null ? 0 : this.fq.length;
                        Object obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fq = obj;
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
                        b = this.fq == null ? 0 : this.fq.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fq = obj2;
                        qoVar.gT(gS);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.name = qoVar.rC();
                        continue;
                    case 48:
                        this.fs = qoVar.rD();
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

        public final C1039b m4289e() {
            this.fq = qz.azj;
            this.fr = 0;
            this.name = 0;
            this.fs = false;
            this.ft = false;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1039b)) {
                return false;
            }
            C1039b c1039b = (C1039b) obj;
            return (qu.equals(this.fq, c1039b.fq) && this.fr == c1039b.fr && this.name == c1039b.name && this.fs == c1039b.fs && this.ft == c1039b.ft) ? m2152a((qq) c1039b) : false;
        }

        public final int hashCode() {
            int i = 1231;
            int hashCode = ((this.fs ? 1231 : 1237) + ((((((qu.hashCode(this.fq) + 527) * 31) + this.fr) * 31) + this.name) * 31)) * 31;
            if (!this.ft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c.c */
    public static final class C1040c extends qq<C1040c> {
        private static volatile C1040c[] fu;
        public String fv;
        public long fw;
        public long fx;
        public boolean fy;
        public long fz;

        public C1040c() {
            m4295g();
        }

        public static C1040c[] m4290f() {
            if (fu == null) {
                synchronized (qu.azg) {
                    if (fu == null) {
                        fu = new C1040c[0];
                    }
                }
            }
            return fu;
        }

        public final void m4291a(qp qpVar) throws IOException {
            if (!this.fv.equals("")) {
                qpVar.m5970b(1, this.fv);
            }
            if (this.fw != 0) {
                qpVar.m5969b(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                qpVar.m5969b(3, this.fx);
            }
            if (this.fy) {
                qpVar.m5971b(4, this.fy);
            }
            if (this.fz != 0) {
                qpVar.m5969b(5, this.fz);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4292b(qo qoVar) throws IOException {
            return m4294d(qoVar);
        }

        protected final int m4293c() {
            int c = super.m2153c();
            if (!this.fv.equals("")) {
                c += qp.m5954j(1, this.fv);
            }
            if (this.fw != 0) {
                c += qp.m5948d(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                c += qp.m5948d(3, this.fx);
            }
            if (this.fy) {
                c += qp.m5947c(4, this.fy);
            }
            return this.fz != 0 ? c + qp.m5948d(5, this.fz) : c;
        }

        public final C1040c m4294d(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.fv = qoVar.readString();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.fw = qoVar.rB();
                        continue;
                    case 24:
                        this.fx = qoVar.rB();
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.fy = qoVar.rD();
                        continue;
                    case 40:
                        this.fz = qoVar.rB();
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

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1040c)) {
                return false;
            }
            C1040c c1040c = (C1040c) obj;
            if (this.fv == null) {
                if (c1040c.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(c1040c.fv)) {
                return false;
            }
            return (this.fw == c1040c.fw && this.fx == c1040c.fx && this.fy == c1040c.fy && this.fz == c1040c.fz) ? m2152a((qq) c1040c) : false;
        }

        public final C1040c m4295g() {
            this.fv = "";
            this.fw = 0;
            this.fx = 2147483647L;
            this.fy = false;
            this.fz = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final int hashCode() {
            return (((((this.fy ? 1231 : 1237) + (((((((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31) + ((int) (this.fw ^ (this.fw >>> 32)))) * 31) + ((int) (this.fx ^ (this.fx >>> 32)))) * 31)) * 31) + ((int) (this.fz ^ (this.fz >>> 32)))) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c.d */
    public static final class C1041d extends qq<C1041d> {
        public C1070a[] fA;
        public C1070a[] fB;
        public C1040c[] fC;

        public C1041d() {
            m4300h();
        }

        public final void m4296a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fA != null && this.fA.length > 0) {
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        qpVar.m5965a(1, qwVar);
                    }
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        qpVar.m5965a(2, qwVar2);
                    }
                }
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i < this.fC.length) {
                    qw qwVar3 = this.fC[i];
                    if (qwVar3 != null) {
                        qpVar.m5965a(3, qwVar3);
                    }
                    i++;
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4297b(qo qoVar) throws IOException {
            return m4299e(qoVar);
        }

        protected final int m4298c() {
            int i;
            int i2 = 0;
            int c = super.m2153c();
            if (this.fA != null && this.fA.length > 0) {
                i = c;
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        i += qp.m5946c(1, qwVar);
                    }
                }
                c = i;
            }
            if (this.fB != null && this.fB.length > 0) {
                i = c;
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        i += qp.m5946c(2, qwVar2);
                    }
                }
                c = i;
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i2 < this.fC.length) {
                    qw qwVar3 = this.fC[i2];
                    if (qwVar3 != null) {
                        c += qp.m5946c(3, qwVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        public final C1041d m4299e(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        b = qz.m6007b(qoVar, 10);
                        rz = this.fA == null ? 0 : this.fA.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.fA = obj;
                        continue;
                    case 18:
                        b = qz.m6007b(qoVar, 18);
                        rz = this.fB == null ? 0 : this.fB.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.fB = obj;
                        continue;
                    case 26:
                        b = qz.m6007b(qoVar, 26);
                        rz = this.fC == null ? 0 : this.fC.length;
                        obj = new C1040c[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fC, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1040c();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1040c();
                        qoVar.m5933a(obj[rz]);
                        this.fC = obj;
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

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1041d)) {
                return false;
            }
            C1041d c1041d = (C1041d) obj;
            return (qu.equals(this.fA, c1041d.fA) && qu.equals(this.fB, c1041d.fB) && qu.equals(this.fC, c1041d.fC)) ? m2152a((qq) c1041d) : false;
        }

        public final C1041d m4300h() {
            this.fA = C1070a.m4400r();
            this.fB = C1070a.m4400r();
            this.fC = C1040c.m4290f();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final int hashCode() {
            return ((((((qu.hashCode(this.fA) + 527) * 31) + qu.hashCode(this.fB)) * 31) + qu.hashCode(this.fC)) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c.e */
    public static final class C1042e extends qq<C1042e> {
        private static volatile C1042e[] fD;
        public int key;
        public int value;

        public C1042e() {
            m4306j();
        }

        public static C1042e[] m4301i() {
            if (fD == null) {
                synchronized (qu.azg) {
                    if (fD == null) {
                        fD = new C1042e[0];
                    }
                }
            }
            return fD;
        }

        public final void m4302a(qp qpVar) throws IOException {
            qpVar.m5979t(1, this.key);
            qpVar.m5979t(2, this.value);
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4303b(qo qoVar) throws IOException {
            return m4305f(qoVar);
        }

        protected final int m4304c() {
            return (super.m2153c() + qp.m5957v(1, this.key)) + qp.m5957v(2, this.value);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1042e)) {
                return false;
            }
            C1042e c1042e = (C1042e) obj;
            return (this.key == c1042e.key && this.value == c1042e.value) ? m2152a((qq) c1042e) : false;
        }

        public final C1042e m4305f(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        this.key = qoVar.rC();
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        this.value = qoVar.rC();
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

        public final int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + rQ();
        }

        public final C1042e m4306j() {
            this.key = 0;
            this.value = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.f */
    public static final class C1043f extends qq<C1043f> {
        public String[] fE;
        public String[] fF;
        public C1070a[] fG;
        public C1042e[] fH;
        public C1039b[] fI;
        public C1039b[] fJ;
        public C1039b[] fK;
        public C1044g[] fL;
        public String fM;
        public String fN;
        public String fO;
        public C1038a fP;
        public float fQ;
        public boolean fR;
        public String[] fS;
        public int fT;
        public String version;

        public C1043f() {
            m4312k();
        }

        public static C1043f m4307a(byte[] bArr) throws qv {
            return (C1043f) qw.m2142a(new C1043f(), bArr);
        }

        public final void m4308a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fF != null && this.fF.length > 0) {
                for (String str : this.fF) {
                    if (str != null) {
                        qpVar.m5970b(1, str);
                    }
                }
            }
            if (this.fG != null && this.fG.length > 0) {
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        qpVar.m5965a(2, qwVar);
                    }
                }
            }
            if (this.fH != null && this.fH.length > 0) {
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        qpVar.m5965a(3, qwVar2);
                    }
                }
            }
            if (this.fI != null && this.fI.length > 0) {
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        qpVar.m5965a(4, qwVar22);
                    }
                }
            }
            if (this.fJ != null && this.fJ.length > 0) {
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        qpVar.m5965a(5, qwVar222);
                    }
                }
            }
            if (this.fK != null && this.fK.length > 0) {
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        qpVar.m5965a(6, qwVar2222);
                    }
                }
            }
            if (this.fL != null && this.fL.length > 0) {
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        qpVar.m5965a(7, qwVar22222);
                    }
                }
            }
            if (!this.fM.equals("")) {
                qpVar.m5970b(9, this.fM);
            }
            if (!this.fN.equals("")) {
                qpVar.m5970b(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                qpVar.m5970b(12, this.fO);
            }
            if (!this.version.equals("")) {
                qpVar.m5970b(13, this.version);
            }
            if (this.fP != null) {
                qpVar.m5965a(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                qpVar.m5968b(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        qpVar.m5970b(16, str2);
                    }
                }
            }
            if (this.fT != 0) {
                qpVar.m5979t(17, this.fT);
            }
            if (this.fR) {
                qpVar.m5971b(18, this.fR);
            }
            if (this.fE != null && this.fE.length > 0) {
                while (i < this.fE.length) {
                    String str3 = this.fE[i];
                    if (str3 != null) {
                        qpVar.m5970b(19, str3);
                    }
                    i++;
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4309b(qo qoVar) throws IOException {
            return m4311g(qoVar);
        }

        protected final int m4310c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.m2153c();
            if (this.fF == null || this.fF.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.fF) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.fG != null && this.fG.length > 0) {
                i2 = i;
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        i2 += qp.m5946c(2, qwVar);
                    }
                }
                i = i2;
            }
            if (this.fH != null && this.fH.length > 0) {
                i2 = i;
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        i2 += qp.m5946c(3, qwVar2);
                    }
                }
                i = i2;
            }
            if (this.fI != null && this.fI.length > 0) {
                i2 = i;
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        i2 += qp.m5946c(4, qwVar22);
                    }
                }
                i = i2;
            }
            if (this.fJ != null && this.fJ.length > 0) {
                i2 = i;
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        i2 += qp.m5946c(5, qwVar222);
                    }
                }
                i = i2;
            }
            if (this.fK != null && this.fK.length > 0) {
                i2 = i;
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        i2 += qp.m5946c(6, qwVar2222);
                    }
                }
                i = i2;
            }
            if (this.fL != null && this.fL.length > 0) {
                i2 = i;
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        i2 += qp.m5946c(7, qwVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fM.equals("")) {
                i += qp.m5954j(9, this.fM);
            }
            if (!this.fN.equals("")) {
                i += qp.m5954j(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                i += qp.m5954j(12, this.fO);
            }
            if (!this.version.equals("")) {
                i += qp.m5954j(13, this.version);
            }
            if (this.fP != null) {
                i += qp.m5946c(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                i += qp.m5945c(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fT != 0) {
                i += qp.m5957v(17, this.fT);
            }
            if (this.fR) {
                i += qp.m5947c(18, this.fR);
            }
            if (this.fE == null || this.fE.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.fE.length) {
                String str3 = this.fE[i4];
                if (str3 != null) {
                    i3++;
                    i2 += qp.dk(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1043f)) {
                return false;
            }
            C1043f c1043f = (C1043f) obj;
            if (!qu.equals(this.fE, c1043f.fE) || !qu.equals(this.fF, c1043f.fF) || !qu.equals(this.fG, c1043f.fG) || !qu.equals(this.fH, c1043f.fH) || !qu.equals(this.fI, c1043f.fI) || !qu.equals(this.fJ, c1043f.fJ) || !qu.equals(this.fK, c1043f.fK) || !qu.equals(this.fL, c1043f.fL)) {
                return false;
            }
            if (this.fM == null) {
                if (c1043f.fM != null) {
                    return false;
                }
            } else if (!this.fM.equals(c1043f.fM)) {
                return false;
            }
            if (this.fN == null) {
                if (c1043f.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(c1043f.fN)) {
                return false;
            }
            if (this.fO == null) {
                if (c1043f.fO != null) {
                    return false;
                }
            } else if (!this.fO.equals(c1043f.fO)) {
                return false;
            }
            if (this.version == null) {
                if (c1043f.version != null) {
                    return false;
                }
            } else if (!this.version.equals(c1043f.version)) {
                return false;
            }
            if (this.fP == null) {
                if (c1043f.fP != null) {
                    return false;
                }
            } else if (!this.fP.equals(c1043f.fP)) {
                return false;
            }
            return (Float.floatToIntBits(this.fQ) == Float.floatToIntBits(c1043f.fQ) && this.fR == c1043f.fR && qu.equals(this.fS, c1043f.fS) && this.fT == c1043f.fT) ? m2152a((qq) c1043f) : false;
        }

        public final C1043f m4311g(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        b = qz.m6007b(qoVar, 10);
                        rz = this.fF == null ? 0 : this.fF.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fF, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fF = obj;
                        continue;
                    case 18:
                        b = qz.m6007b(qoVar, 18);
                        rz = this.fG == null ? 0 : this.fG.length;
                        obj = new C1070a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fG, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1070a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1070a();
                        qoVar.m5933a(obj[rz]);
                        this.fG = obj;
                        continue;
                    case 26:
                        b = qz.m6007b(qoVar, 26);
                        rz = this.fH == null ? 0 : this.fH.length;
                        obj = new C1042e[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fH, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1042e();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1042e();
                        qoVar.m5933a(obj[rz]);
                        this.fH = obj;
                        continue;
                    case 34:
                        b = qz.m6007b(qoVar, 34);
                        rz = this.fI == null ? 0 : this.fI.length;
                        obj = new C1039b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fI, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1039b();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1039b();
                        qoVar.m5933a(obj[rz]);
                        this.fI = obj;
                        continue;
                    case 42:
                        b = qz.m6007b(qoVar, 42);
                        rz = this.fJ == null ? 0 : this.fJ.length;
                        obj = new C1039b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1039b();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1039b();
                        qoVar.m5933a(obj[rz]);
                        this.fJ = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        b = qz.m6007b(qoVar, 50);
                        rz = this.fK == null ? 0 : this.fK.length;
                        obj = new C1039b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fK, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1039b();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1039b();
                        qoVar.m5933a(obj[rz]);
                        this.fK = obj;
                        continue;
                    case 58:
                        b = qz.m6007b(qoVar, 58);
                        rz = this.fL == null ? 0 : this.fL.length;
                        obj = new C1044g[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fL, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1044g();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1044g();
                        qoVar.m5933a(obj[rz]);
                        this.fL = obj;
                        continue;
                    case 74:
                        this.fM = qoVar.readString();
                        continue;
                    case 82:
                        this.fN = qoVar.readString();
                        continue;
                    case 98:
                        this.fO = qoVar.readString();
                        continue;
                    case 106:
                        this.version = qoVar.readString();
                        continue;
                    case 114:
                        if (this.fP == null) {
                            this.fP = new C1038a();
                        }
                        qoVar.m5933a(this.fP);
                        continue;
                    case 125:
                        this.fQ = qoVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        b = qz.m6007b(qoVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        rz = this.fS == null ? 0 : this.fS.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fS, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fS = obj;
                        continue;
                    case 136:
                        this.fT = qoVar.rC();
                        continue;
                    case 144:
                        this.fR = qoVar.rD();
                        continue;
                    case 154:
                        b = qz.m6007b(qoVar, 154);
                        rz = this.fE == null ? 0 : this.fE.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fE, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fE = obj;
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

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.fO == null ? 0 : this.fO.hashCode()) + (((this.fN == null ? 0 : this.fN.hashCode()) + (((this.fM == null ? 0 : this.fM.hashCode()) + ((((((((((((((((qu.hashCode(this.fE) + 527) * 31) + qu.hashCode(this.fF)) * 31) + qu.hashCode(this.fG)) * 31) + qu.hashCode(this.fH)) * 31) + qu.hashCode(this.fI)) * 31) + qu.hashCode(this.fJ)) * 31) + qu.hashCode(this.fK)) * 31) + qu.hashCode(this.fL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.fP != null) {
                i = this.fP.hashCode();
            }
            return (((((((this.fR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.fQ)) * 31)) * 31) + qu.hashCode(this.fS)) * 31) + this.fT) * 31) + rQ();
        }

        public final C1043f m4312k() {
            this.fE = qz.azo;
            this.fF = qz.azo;
            this.fG = C1070a.m4400r();
            this.fH = C1042e.m4301i();
            this.fI = C1039b.m4284d();
            this.fJ = C1039b.m4284d();
            this.fK = C1039b.m4284d();
            this.fL = C1044g.m4313l();
            this.fM = "";
            this.fN = "";
            this.fO = "0";
            this.version = "";
            this.fP = null;
            this.fQ = 0.0f;
            this.fR = false;
            this.fS = qz.azo;
            this.fT = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.g */
    public static final class C1044g extends qq<C1044g> {
        private static volatile C1044g[] fU;
        public int[] fV;
        public int[] fW;
        public int[] fX;
        public int[] fY;
        public int[] fZ;
        public int[] ga;
        public int[] gb;
        public int[] gc;
        public int[] gd;
        public int[] ge;

        public C1044g() {
            m4318m();
        }

        public static C1044g[] m4313l() {
            if (fU == null) {
                synchronized (qu.azg) {
                    if (fU == null) {
                        fU = new C1044g[0];
                    }
                }
            }
            return fU;
        }

        public final void m4314a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fV != null && this.fV.length > 0) {
                for (int t : this.fV) {
                    qpVar.m5979t(1, t);
                }
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int t2 : this.fW) {
                    qpVar.m5979t(2, t2);
                }
            }
            if (this.fX != null && this.fX.length > 0) {
                for (int t22 : this.fX) {
                    qpVar.m5979t(3, t22);
                }
            }
            if (this.fY != null && this.fY.length > 0) {
                for (int t222 : this.fY) {
                    qpVar.m5979t(4, t222);
                }
            }
            if (this.fZ != null && this.fZ.length > 0) {
                for (int t2222 : this.fZ) {
                    qpVar.m5979t(5, t2222);
                }
            }
            if (this.ga != null && this.ga.length > 0) {
                for (int t22222 : this.ga) {
                    qpVar.m5979t(6, t22222);
                }
            }
            if (this.gb != null && this.gb.length > 0) {
                for (int t222222 : this.gb) {
                    qpVar.m5979t(7, t222222);
                }
            }
            if (this.gc != null && this.gc.length > 0) {
                for (int t2222222 : this.gc) {
                    qpVar.m5979t(8, t2222222);
                }
            }
            if (this.gd != null && this.gd.length > 0) {
                for (int t22222222 : this.gd) {
                    qpVar.m5979t(9, t22222222);
                }
            }
            if (this.ge != null && this.ge.length > 0) {
                while (i < this.ge.length) {
                    qpVar.m5979t(10, this.ge[i]);
                    i++;
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4315b(qo qoVar) throws IOException {
            return m4317h(qoVar);
        }

        protected final int m4316c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2153c();
            if (this.fV == null || this.fV.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.fV) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.fV.length * 1);
            }
            if (this.fW != null && this.fW.length > 0) {
                c = 0;
                for (int gZ2 : this.fW) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.fW.length * 1);
            }
            if (this.fX != null && this.fX.length > 0) {
                c = 0;
                for (int gZ22 : this.fX) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.fX.length * 1);
            }
            if (this.fY != null && this.fY.length > 0) {
                c = 0;
                for (int gZ222 : this.fY) {
                    c += qp.gZ(gZ222);
                }
                i = (i + c) + (this.fY.length * 1);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                c = 0;
                for (int gZ2222 : this.fZ) {
                    c += qp.gZ(gZ2222);
                }
                i = (i + c) + (this.fZ.length * 1);
            }
            if (this.ga != null && this.ga.length > 0) {
                c = 0;
                for (int gZ22222 : this.ga) {
                    c += qp.gZ(gZ22222);
                }
                i = (i + c) + (this.ga.length * 1);
            }
            if (this.gb != null && this.gb.length > 0) {
                c = 0;
                for (int gZ222222 : this.gb) {
                    c += qp.gZ(gZ222222);
                }
                i = (i + c) + (this.gb.length * 1);
            }
            if (this.gc != null && this.gc.length > 0) {
                c = 0;
                for (int gZ2222222 : this.gc) {
                    c += qp.gZ(gZ2222222);
                }
                i = (i + c) + (this.gc.length * 1);
            }
            if (this.gd != null && this.gd.length > 0) {
                c = 0;
                for (int gZ22222222 : this.gd) {
                    c += qp.gZ(gZ22222222);
                }
                i = (i + c) + (this.gd.length * 1);
            }
            if (this.ge == null || this.ge.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.ge.length) {
                i2 += qp.gZ(this.ge[i3]);
                i3++;
            }
            return (i + i2) + (this.ge.length * 1);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1044g)) {
                return false;
            }
            C1044g c1044g = (C1044g) obj;
            return (qu.equals(this.fV, c1044g.fV) && qu.equals(this.fW, c1044g.fW) && qu.equals(this.fX, c1044g.fX) && qu.equals(this.fY, c1044g.fY) && qu.equals(this.fZ, c1044g.fZ) && qu.equals(this.ga, c1044g.ga) && qu.equals(this.gb, c1044g.gb) && qu.equals(this.gc, c1044g.gc) && qu.equals(this.gd, c1044g.gd) && qu.equals(this.ge, c1044g.ge)) ? m2152a((qq) c1044g) : false;
        }

        public final C1044g m4317h(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        b = qz.m6007b(qoVar, 8);
                        rz = this.fV == null ? 0 : this.fV.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fV = obj;
                        continue;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fV == null ? 0 : this.fV.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fV, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fV = obj2;
                        qoVar.gT(gS);
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        b = qz.m6007b(qoVar, 16);
                        rz = this.fW == null ? 0 : this.fW.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fW, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fW = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fW == null ? 0 : this.fW.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fW, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fW = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.m6007b(qoVar, 24);
                        rz = this.fX == null ? 0 : this.fX.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fX, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fX = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fX == null ? 0 : this.fX.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fX, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fX = obj2;
                        qoVar.gT(gS);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        b = qz.m6007b(qoVar, 32);
                        rz = this.fY == null ? 0 : this.fY.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fY, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fY = obj;
                        continue;
                    case 34:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fY == null ? 0 : this.fY.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fY, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fY = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 40:
                        b = qz.m6007b(qoVar, 40);
                        rz = this.fZ == null ? 0 : this.fZ.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fZ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fZ = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fZ == null ? 0 : this.fZ.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fZ, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fZ = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        b = qz.m6007b(qoVar, 48);
                        rz = this.ga == null ? 0 : this.ga.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ga, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ga = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ga == null ? 0 : this.ga.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ga, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ga = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 56:
                        b = qz.m6007b(qoVar, 56);
                        rz = this.gb == null ? 0 : this.gb.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gb, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gb = obj;
                        continue;
                    case 58:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gb == null ? 0 : this.gb.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gb = obj2;
                        qoVar.gT(gS);
                        continue;
                    case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /*64*/:
                        b = qz.m6007b(qoVar, 64);
                        rz = this.gc == null ? 0 : this.gc.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gc, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gc = obj;
                        continue;
                    case 66:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gc == null ? 0 : this.gc.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gc, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gc = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 72:
                        b = qz.m6007b(qoVar, 72);
                        rz = this.gd == null ? 0 : this.gd.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gd, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gd = obj;
                        continue;
                    case 74:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gd == null ? 0 : this.gd.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gd, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gd = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 80:
                        b = qz.m6007b(qoVar, 80);
                        rz = this.ge == null ? 0 : this.ge.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ge, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ge = obj;
                        continue;
                    case 82:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ge == null ? 0 : this.ge.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ge, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ge = obj2;
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

        public final int hashCode() {
            return ((((((((((((((((((((qu.hashCode(this.fV) + 527) * 31) + qu.hashCode(this.fW)) * 31) + qu.hashCode(this.fX)) * 31) + qu.hashCode(this.fY)) * 31) + qu.hashCode(this.fZ)) * 31) + qu.hashCode(this.ga)) * 31) + qu.hashCode(this.gb)) * 31) + qu.hashCode(this.gc)) * 31) + qu.hashCode(this.gd)) * 31) + qu.hashCode(this.ge)) * 31) + rQ();
        }

        public final C1044g m4318m() {
            this.fV = qz.azj;
            this.fW = qz.azj;
            this.fX = qz.azj;
            this.fY = qz.azj;
            this.fZ = qz.azj;
            this.ga = qz.azj;
            this.gb = qz.azj;
            this.gc = qz.azj;
            this.gd = qz.azj;
            this.ge = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.h */
    public static final class C1045h extends qq<C1045h> {
        public static final qr<C1070a, C1045h> gf;
        private static final C1045h[] gg;
        public int[] gh;
        public int[] gi;
        public int[] gj;
        public int gk;
        public int[] gl;
        public int gm;
        public int gn;

        static {
            gf = qr.m5983a(11, C1045h.class, 810);
            gg = new C1045h[0];
        }

        public C1045h() {
            m4323n();
        }

        public final void m4319a(qp qpVar) throws IOException {
            int i = 0;
            if (this.gh != null && this.gh.length > 0) {
                for (int t : this.gh) {
                    qpVar.m5979t(1, t);
                }
            }
            if (this.gi != null && this.gi.length > 0) {
                for (int t2 : this.gi) {
                    qpVar.m5979t(2, t2);
                }
            }
            if (this.gj != null && this.gj.length > 0) {
                for (int t22 : this.gj) {
                    qpVar.m5979t(3, t22);
                }
            }
            if (this.gk != 0) {
                qpVar.m5979t(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                while (i < this.gl.length) {
                    qpVar.m5979t(5, this.gl[i]);
                    i++;
                }
            }
            if (this.gm != 0) {
                qpVar.m5979t(6, this.gm);
            }
            if (this.gn != 0) {
                qpVar.m5979t(7, this.gn);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4320b(qo qoVar) throws IOException {
            return m4322i(qoVar);
        }

        protected final int m4321c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2153c();
            if (this.gh == null || this.gh.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.gh) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.gh.length * 1);
            }
            if (this.gi != null && this.gi.length > 0) {
                c = 0;
                for (int gZ2 : this.gi) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.gi.length * 1);
            }
            if (this.gj != null && this.gj.length > 0) {
                c = 0;
                for (int gZ22 : this.gj) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.gj.length * 1);
            }
            if (this.gk != 0) {
                i += qp.m5957v(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                i2 = 0;
                while (i3 < this.gl.length) {
                    i2 += qp.gZ(this.gl[i3]);
                    i3++;
                }
                i = (i + i2) + (this.gl.length * 1);
            }
            if (this.gm != 0) {
                i += qp.m5957v(6, this.gm);
            }
            return this.gn != 0 ? i + qp.m5957v(7, this.gn) : i;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1045h)) {
                return false;
            }
            C1045h c1045h = (C1045h) obj;
            return (qu.equals(this.gh, c1045h.gh) && qu.equals(this.gi, c1045h.gi) && qu.equals(this.gj, c1045h.gj) && this.gk == c1045h.gk && qu.equals(this.gl, c1045h.gl) && this.gm == c1045h.gm && this.gn == c1045h.gn) ? m2152a((qq) c1045h) : false;
        }

        public final int hashCode() {
            return ((((((((((((((qu.hashCode(this.gh) + 527) * 31) + qu.hashCode(this.gi)) * 31) + qu.hashCode(this.gj)) * 31) + this.gk) * 31) + qu.hashCode(this.gl)) * 31) + this.gm) * 31) + this.gn) * 31) + rQ();
        }

        public final C1045h m4322i(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        b = qz.m6007b(qoVar, 8);
                        rz = this.gh == null ? 0 : this.gh.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gh, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gh = obj;
                        continue;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gh == null ? 0 : this.gh.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gh, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gh = obj2;
                        qoVar.gT(gS);
                        continue;
                    case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        b = qz.m6007b(qoVar, 16);
                        rz = this.gi == null ? 0 : this.gi.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gi, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gi = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gi == null ? 0 : this.gi.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gi, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gi = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.m6007b(qoVar, 24);
                        rz = this.gj == null ? 0 : this.gj.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gj, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gj = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gj == null ? 0 : this.gj.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gj, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gj = obj2;
                        qoVar.gT(gS);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.gk = qoVar.rC();
                        continue;
                    case 40:
                        b = qz.m6007b(qoVar, 40);
                        rz = this.gl == null ? 0 : this.gl.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gl, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gl = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gl == null ? 0 : this.gl.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gl, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gl = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        this.gm = qoVar.rC();
                        continue;
                    case 56:
                        this.gn = qoVar.rC();
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

        public final C1045h m4323n() {
            this.gh = qz.azj;
            this.gi = qz.azj;
            this.gj = qz.azj;
            this.gk = 0;
            this.gl = qz.azj;
            this.gm = 0;
            this.gn = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.i */
    public static final class C1046i extends qq<C1046i> {
        private static volatile C1046i[] go;
        public C1070a gp;
        public C1041d gq;
        public String name;

        public C1046i() {
            m4329p();
        }

        public static C1046i[] m4324o() {
            if (go == null) {
                synchronized (qu.azg) {
                    if (go == null) {
                        go = new C1046i[0];
                    }
                }
            }
            return go;
        }

        public final void m4325a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.m5970b(1, this.name);
            }
            if (this.gp != null) {
                qpVar.m5965a(2, this.gp);
            }
            if (this.gq != null) {
                qpVar.m5965a(3, this.gq);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4326b(qo qoVar) throws IOException {
            return m4328j(qoVar);
        }

        protected final int m4327c() {
            int c = super.m2153c();
            if (!this.name.equals("")) {
                c += qp.m5954j(1, this.name);
            }
            if (this.gp != null) {
                c += qp.m5946c(2, this.gp);
            }
            return this.gq != null ? c + qp.m5946c(3, this.gq) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1046i)) {
                return false;
            }
            C1046i c1046i = (C1046i) obj;
            if (this.name == null) {
                if (c1046i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1046i.name)) {
                return false;
            }
            if (this.gp == null) {
                if (c1046i.gp != null) {
                    return false;
                }
            } else if (!this.gp.equals(c1046i.gp)) {
                return false;
            }
            if (this.gq == null) {
                if (c1046i.gq != null) {
                    return false;
                }
            } else if (!this.gq.equals(c1046i.gq)) {
                return false;
            }
            return m2152a((qq) c1046i);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.gp == null ? 0 : this.gp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.gq != null) {
                i = this.gq.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1046i m4328j(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.gp == null) {
                            this.gp = new C1070a();
                        }
                        qoVar.m5933a(this.gp);
                        continue;
                    case 26:
                        if (this.gq == null) {
                            this.gq = new C1041d();
                        }
                        qoVar.m5933a(this.gq);
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

        public final C1046i m4329p() {
            this.name = "";
            this.gp = null;
            this.gq = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.j */
    public static final class C1047j extends qq<C1047j> {
        public C1046i[] gr;
        public C1043f gs;
        public String gt;

        public C1047j() {
            m4335q();
        }

        public static C1047j m4330b(byte[] bArr) throws qv {
            return (C1047j) qw.m2142a(new C1047j(), bArr);
        }

        public final void m4331a(qp qpVar) throws IOException {
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        qpVar.m5965a(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                qpVar.m5965a(2, this.gs);
            }
            if (!this.gt.equals("")) {
                qpVar.m5970b(3, this.gt);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m4332b(qo qoVar) throws IOException {
            return m4334k(qoVar);
        }

        protected final int m4333c() {
            int c = super.m2153c();
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        c += qp.m5946c(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                c += qp.m5946c(2, this.gs);
            }
            return !this.gt.equals("") ? c + qp.m5954j(3, this.gt) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1047j)) {
                return false;
            }
            C1047j c1047j = (C1047j) obj;
            if (!qu.equals(this.gr, c1047j.gr)) {
                return false;
            }
            if (this.gs == null) {
                if (c1047j.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(c1047j.gs)) {
                return false;
            }
            if (this.gt == null) {
                if (c1047j.gt != null) {
                    return false;
                }
            } else if (!this.gt.equals(c1047j.gt)) {
                return false;
            }
            return m2152a((qq) c1047j);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((qu.hashCode(this.gr) + 527) * 31)) * 31;
            if (this.gt != null) {
                i = this.gt.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1047j m4334k(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        int b = qz.m6007b(qoVar, 10);
                        rz = this.gr == null ? 0 : this.gr.length;
                        Object obj = new C1046i[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1046i();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1046i();
                        qoVar.m5933a(obj[rz]);
                        this.gr = obj;
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new C1043f();
                        }
                        qoVar.m5933a(this.gs);
                        continue;
                    case 26:
                        this.gt = qoVar.readString();
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

        public final C1047j m4335q() {
            this.gr = C1046i.m4324o();
            this.gs = null;
            this.gt = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
