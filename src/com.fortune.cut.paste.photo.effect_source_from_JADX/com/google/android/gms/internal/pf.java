package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class pf extends ks implements Moment {
    public static final pg CREATOR;
    private static final HashMap<String, C1277a<?, ?>> aom;
    String CE;
    final int CK;
    final Set<Integer> aon;
    String apa;
    pd api;
    pd apj;
    String vc;

    static {
        CREATOR = new pg();
        HashMap hashMap = new HashMap();
        aom = hashMap;
        hashMap.put("id", C1277a.m5276l("id", 2));
        aom.put("result", C1277a.m5270a("result", 4, pd.class));
        aom.put("startDate", C1277a.m5276l("startDate", 5));
        aom.put("target", C1277a.m5270a("target", 6, pd.class));
        aom.put("type", C1277a.m5276l("type", 7));
    }

    public pf() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    pf(Set<Integer> set, int i, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = i;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    public pf(Set<Integer> set, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = 1;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    protected final boolean m5775a(C1277a c1277a) {
        return this.aon.contains(Integer.valueOf(c1277a.hR()));
    }

    protected final Object m5776b(C1277a c1277a) {
        switch (c1277a.hR()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return this.CE;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return this.api;
            case Dimension.UNIT_MM /*5*/:
                return this.apa;
            case Error.OTHER /*6*/:
                return this.apj;
            case Error.AVS_DECLINE /*7*/:
                return this.vc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1277a.hR());
        }
    }

    public final int describeContents() {
        pg pgVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pf pfVar = (pf) obj;
        for (C1277a c1277a : aom.values()) {
            if (m5775a(c1277a)) {
                if (!pfVar.m5775a(c1277a)) {
                    return false;
                }
                if (!m5776b(c1277a).equals(pfVar.m5776b(c1277a))) {
                    return false;
                }
            } else if (pfVar.m5775a(c1277a)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object freeze() {
        return oJ();
    }

    public final String getId() {
        return this.CE;
    }

    public final ItemScope getResult() {
        return this.api;
    }

    public final String getStartDate() {
        return this.apa;
    }

    public final ItemScope getTarget() {
        return this.apj;
    }

    public final String getType() {
        return this.vc;
    }

    public final HashMap<String, C1277a<?, ?>> hK() {
        return aom;
    }

    public final boolean hasId() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public final boolean hasResult() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public final boolean hasStartDate() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public final boolean hasTarget() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public final boolean hasType() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public final int hashCode() {
        int i = 0;
        for (C1277a c1277a : aom.values()) {
            int hashCode;
            if (m5775a(c1277a)) {
                hashCode = m5776b(c1277a).hashCode() + (i + c1277a.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final pf oJ() {
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        pg pgVar = CREATOR;
        pg.m5777a(this, parcel, i);
    }
}
