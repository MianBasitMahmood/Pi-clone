package com.google.android.gms.internal;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import java.io.IOException;

public interface mv {

    /* renamed from: com.google.android.gms.internal.mv.a */
    public static final class C1352a extends qq<C1352a> {
        public C1351a[] afu;

        /* renamed from: com.google.android.gms.internal.mv.a.a */
        public static final class C1351a extends qq<C1351a> {
            private static volatile C1351a[] afv;
            public String afw;
            public String afx;
            public int viewId;

            public C1351a() {
                mY();
            }

            public static C1351a[] mX() {
                if (afv == null) {
                    synchronized (qu.azg) {
                        if (afv == null) {
                            afv = new C1351a[0];
                        }
                    }
                }
                return afv;
            }

            public final void m5504a(qp qpVar) throws IOException {
                if (!this.afw.equals("")) {
                    qpVar.m5970b(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    qpVar.m5970b(2, this.afx);
                }
                if (this.viewId != 0) {
                    qpVar.m5979t(3, this.viewId);
                }
                super.m2150a(qpVar);
            }

            public final /* synthetic */ qw m5505b(qo qoVar) throws IOException {
                return m5507o(qoVar);
            }

            protected final int m5506c() {
                int c = super.m2153c();
                if (!this.afw.equals("")) {
                    c += qp.m5954j(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    c += qp.m5954j(2, this.afx);
                }
                return this.viewId != 0 ? c + qp.m5957v(3, this.viewId) : c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C1351a)) {
                    return false;
                }
                C1351a c1351a = (C1351a) obj;
                if (this.afw == null) {
                    if (c1351a.afw != null) {
                        return false;
                    }
                } else if (!this.afw.equals(c1351a.afw)) {
                    return false;
                }
                if (this.afx == null) {
                    if (c1351a.afx != null) {
                        return false;
                    }
                } else if (!this.afx.equals(c1351a.afx)) {
                    return false;
                }
                return this.viewId == c1351a.viewId ? m2152a((qq) c1351a) : false;
            }

            public final int hashCode() {
                int i = 0;
                int hashCode = ((this.afw == null ? 0 : this.afw.hashCode()) + 527) * 31;
                if (this.afx != null) {
                    i = this.afx.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + rQ();
            }

            public final C1351a mY() {
                this.afw = "";
                this.afx = "";
                this.viewId = 0;
                this.ayW = null;
                this.azh = -1;
                return this;
            }

            public final C1351a m5507o(qo qoVar) throws IOException {
                while (true) {
                    int rz = qoVar.rz();
                    switch (rz) {
                        case WalletFragmentState.UNKNOWN /*0*/:
                            break;
                        case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                            this.afw = qoVar.readString();
                            continue;
                        case 18:
                            this.afx = qoVar.readString();
                            continue;
                        case 24:
                            this.viewId = qoVar.rC();
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

        public C1352a() {
            mW();
        }

        public final void m5508a(qp qpVar) throws IOException {
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
                    if (qwVar != null) {
                        qpVar.m5965a(1, qwVar);
                    }
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5509b(qo qoVar) throws IOException {
            return m5511n(qoVar);
        }

        protected final int m5510c() {
            int c = super.m2153c();
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
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
            if (!(obj instanceof C1352a)) {
                return false;
            }
            C1352a c1352a = (C1352a) obj;
            return qu.equals(this.afu, c1352a.afu) ? m2152a((qq) c1352a) : false;
        }

        public final int hashCode() {
            return ((qu.hashCode(this.afu) + 527) * 31) + rQ();
        }

        public final C1352a mW() {
            this.afu = C1351a.mX();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1352a m5511n(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        int b = qz.m6007b(qoVar, 10);
                        rz = this.afu == null ? 0 : this.afu.length;
                        Object obj = new C1351a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afu, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1351a();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1351a();
                        qoVar.m5933a(obj[rz]);
                        this.afu = obj;
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

    /* renamed from: com.google.android.gms.internal.mv.b */
    public static final class C1353b extends qq<C1353b> {
        private static volatile C1353b[] afy;
        public C1355d afz;
        public String name;

        public C1353b() {
            na();
        }

        public static C1353b[] mZ() {
            if (afy == null) {
                synchronized (qu.azg) {
                    if (afy == null) {
                        afy = new C1353b[0];
                    }
                }
            }
            return afy;
        }

        public final void m5512a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.m5970b(1, this.name);
            }
            if (this.afz != null) {
                qpVar.m5965a(2, this.afz);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5513b(qo qoVar) throws IOException {
            return m5515p(qoVar);
        }

        protected final int m5514c() {
            int c = super.m2153c();
            if (!this.name.equals("")) {
                c += qp.m5954j(1, this.name);
            }
            return this.afz != null ? c + qp.m5946c(2, this.afz) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1353b)) {
                return false;
            }
            C1353b c1353b = (C1353b) obj;
            if (this.name == null) {
                if (c1353b.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1353b.name)) {
                return false;
            }
            if (this.afz == null) {
                if (c1353b.afz != null) {
                    return false;
                }
            } else if (!this.afz.equals(c1353b.afz)) {
                return false;
            }
            return m2152a((qq) c1353b);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.afz != null) {
                i = this.afz.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1353b na() {
            this.name = "";
            this.afz = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1353b m5515p(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.afz == null) {
                            this.afz = new C1355d();
                        }
                        qoVar.m5933a(this.afz);
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

    /* renamed from: com.google.android.gms.internal.mv.c */
    public static final class C1354c extends qq<C1354c> {
        public C1353b[] afA;
        public String type;

        public C1354c() {
            nb();
        }

        public final void m5516a(qp qpVar) throws IOException {
            if (!this.type.equals("")) {
                qpVar.m5970b(1, this.type);
            }
            if (this.afA != null && this.afA.length > 0) {
                for (qw qwVar : this.afA) {
                    if (qwVar != null) {
                        qpVar.m5965a(2, qwVar);
                    }
                }
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5517b(qo qoVar) throws IOException {
            return m5519q(qoVar);
        }

        protected final int m5518c() {
            int c = super.m2153c();
            if (!this.type.equals("")) {
                c += qp.m5954j(1, this.type);
            }
            if (this.afA == null || this.afA.length <= 0) {
                return c;
            }
            int i = c;
            for (qw qwVar : this.afA) {
                if (qwVar != null) {
                    i += qp.m5946c(2, qwVar);
                }
            }
            return i;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1354c)) {
                return false;
            }
            C1354c c1354c = (C1354c) obj;
            if (this.type == null) {
                if (c1354c.type != null) {
                    return false;
                }
            } else if (!this.type.equals(c1354c.type)) {
                return false;
            }
            return qu.equals(this.afA, c1354c.afA) ? m2152a((qq) c1354c) : false;
        }

        public final int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + qu.hashCode(this.afA)) * 31) + rQ();
        }

        public final C1354c nb() {
            this.type = "";
            this.afA = C1353b.mZ();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1354c m5519q(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        this.type = qoVar.readString();
                        continue;
                    case 18:
                        int b = qz.m6007b(qoVar, 18);
                        rz = this.afA == null ? 0 : this.afA.length;
                        Object obj = new C1353b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1353b();
                            qoVar.m5933a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1353b();
                        qoVar.m5933a(obj[rz]);
                        this.afA = obj;
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

    /* renamed from: com.google.android.gms.internal.mv.d */
    public static final class C1355d extends qq<C1355d> {
        public String NJ;
        public boolean afB;
        public long afC;
        public double afD;
        public C1354c afE;

        public C1355d() {
            nc();
        }

        public final void m5520a(qp qpVar) throws IOException {
            if (this.afB) {
                qpVar.m5971b(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                qpVar.m5970b(2, this.NJ);
            }
            if (this.afC != 0) {
                qpVar.m5969b(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                qpVar.m5964a(4, this.afD);
            }
            if (this.afE != null) {
                qpVar.m5965a(5, this.afE);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5521b(qo qoVar) throws IOException {
            return m5523r(qoVar);
        }

        protected final int m5522c() {
            int c = super.m2153c();
            if (this.afB) {
                c += qp.m5947c(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                c += qp.m5954j(2, this.NJ);
            }
            if (this.afC != 0) {
                c += qp.m5948d(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                c += qp.m5941b(4, this.afD);
            }
            return this.afE != null ? c + qp.m5946c(5, this.afE) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1355d)) {
                return false;
            }
            C1355d c1355d = (C1355d) obj;
            if (this.afB != c1355d.afB) {
                return false;
            }
            if (this.NJ == null) {
                if (c1355d.NJ != null) {
                    return false;
                }
            } else if (!this.NJ.equals(c1355d.NJ)) {
                return false;
            }
            if (this.afC != c1355d.afC || Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(c1355d.afD)) {
                return false;
            }
            if (this.afE == null) {
                if (c1355d.afE != null) {
                    return false;
                }
            } else if (!this.afE.equals(c1355d.afE)) {
                return false;
            }
            return m2152a((qq) c1355d);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = (((this.NJ == null ? 0 : this.NJ.hashCode()) + (((this.afB ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.afC ^ (this.afC >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.afD);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.afE != null) {
                i = this.afE.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1355d nc() {
            this.afB = false;
            this.NJ = "";
            this.afC = 0;
            this.afD = 0.0d;
            this.afE = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1355d m5523r(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        this.afB = qoVar.rD();
                        continue;
                    case 18:
                        this.NJ = qoVar.readString();
                        continue;
                    case 24:
                        this.afC = qoVar.rB();
                        continue;
                    case 33:
                        this.afD = qoVar.readDouble();
                        continue;
                    case 42:
                        if (this.afE == null) {
                            this.afE = new C1354c();
                        }
                        qoVar.m5933a(this.afE);
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
}
