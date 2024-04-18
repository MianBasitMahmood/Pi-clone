package com.google.android.gms.drive.internal;

import com.google.ads.AdSize;
import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import java.io.IOException;

public final class ak extends qq<ak> {
    public String QG;
    public long QH;
    public long QI;
    public int versionCode;

    public ak() {
        iK();
    }

    public static ak m2154g(byte[] bArr) throws qv {
        return (ak) qw.m2142a(new ak(), bArr);
    }

    public final void m2155a(qp qpVar) throws IOException {
        qpVar.m5979t(1, this.versionCode);
        qpVar.m5970b(2, this.QG);
        qpVar.m5973c(3, this.QH);
        qpVar.m5973c(4, this.QI);
        super.m2150a(qpVar);
    }

    public final /* synthetic */ qw m2156b(qo qoVar) throws IOException {
        return m2158m(qoVar);
    }

    protected final int m2157c() {
        return (((super.m2153c() + qp.m5957v(1, this.versionCode)) + qp.m5954j(2, this.QG)) + qp.m5951e(3, this.QH)) + qp.m5951e(4, this.QI);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        if (this.versionCode != akVar.versionCode) {
            return false;
        }
        if (this.QG == null) {
            if (akVar.QG != null) {
                return false;
            }
        } else if (!this.QG.equals(akVar.QG)) {
            return false;
        }
        return (this.QH == akVar.QH && this.QI == akVar.QI) ? m2152a((qq) akVar) : false;
    }

    public final int hashCode() {
        return (((((((this.QG == null ? 0 : this.QG.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.QH ^ (this.QH >>> 32)))) * 31) + ((int) (this.QI ^ (this.QI >>> 32)))) * 31) + rQ();
    }

    public final ak iK() {
        this.versionCode = 1;
        this.QG = "";
        this.QH = -1;
        this.QI = -1;
        this.ayW = null;
        this.azh = -1;
        return this;
    }

    public final ak m2158m(qo qoVar) throws IOException {
        while (true) {
            int rz = qoVar.rz();
            switch (rz) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                    this.versionCode = qoVar.rC();
                    continue;
                case 18:
                    this.QG = qoVar.readString();
                    continue;
                case 24:
                    this.QH = qoVar.rF();
                    continue;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    this.QI = qoVar.rF();
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
