package com.google.android.gms.internal;

import com.google.android.gms.internal.C1048c.C1043f;
import com.google.android.gms.internal.C1048c.C1047j;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import java.io.IOException;

public interface pu {

    /* renamed from: com.google.android.gms.internal.pu.a */
    public static final class C1446a extends qq<C1446a> {
        public long auB;
        public C1047j auC;
        public C1043f gs;

        public C1446a() {
            rc();
        }

        public static C1446a m5809l(byte[] bArr) throws qv {
            return (C1446a) qw.m2142a(new C1446a(), bArr);
        }

        public final void m5810a(qp qpVar) throws IOException {
            qpVar.m5969b(1, this.auB);
            if (this.gs != null) {
                qpVar.m5965a(2, this.gs);
            }
            if (this.auC != null) {
                qpVar.m5965a(3, this.auC);
            }
            super.m2150a(qpVar);
        }

        public final /* synthetic */ qw m5811b(qo qoVar) throws IOException {
            return m5813s(qoVar);
        }

        protected final int m5812c() {
            int c = super.m2153c() + qp.m5948d(1, this.auB);
            if (this.gs != null) {
                c += qp.m5946c(2, this.gs);
            }
            return this.auC != null ? c + qp.m5946c(3, this.auC) : c;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1446a)) {
                return false;
            }
            C1446a c1446a = (C1446a) obj;
            if (this.auB != c1446a.auB) {
                return false;
            }
            if (this.gs == null) {
                if (c1446a.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(c1446a.gs)) {
                return false;
            }
            if (this.auC == null) {
                if (c1446a.auC != null) {
                    return false;
                }
            } else if (!this.auC.equals(c1446a.auC)) {
                return false;
            }
            return m2152a((qq) c1446a);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((((int) (this.auB ^ (this.auB >>> 32))) + 527) * 31)) * 31;
            if (this.auC != null) {
                i = this.auC.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public final C1446a rc() {
            this.auB = 0;
            this.gs = null;
            this.auC = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public final C1446a m5813s(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        break;
                    case Error.FRAUD_DECLINE /*8*/:
                        this.auB = qoVar.rB();
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new C1043f();
                        }
                        qoVar.m5933a(this.gs);
                        continue;
                    case 26:
                        if (this.auC == null) {
                            this.auC = new C1047j();
                        }
                        qoVar.m5933a(this.auC);
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
