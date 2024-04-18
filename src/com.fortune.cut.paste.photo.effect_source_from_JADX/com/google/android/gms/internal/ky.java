package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.C0541a;
import com.google.android.gms.common.internal.safeparcel.C0541a.C0540a;
import com.google.android.gms.common.internal.safeparcel.C0542b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.kr.C1277a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ky extends kr implements SafeParcelable {
    public static final kz CREATOR;
    private final int CK;
    private final kv NT;
    private final Parcel Oa;
    private final int Ob;
    private int Oc;
    private int Od;
    private final String mClassName;

    static {
        CREATOR = new kz();
    }

    ky(int i, Parcel parcel, kv kvVar) {
        this.CK = i;
        this.Oa = (Parcel) jx.m5223i(parcel);
        this.Ob = 2;
        this.NT = kvVar;
        if (this.NT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.NT.ia();
        }
        this.Oc = 2;
    }

    private ky(SafeParcelable safeParcelable, kv kvVar, String str) {
        this.CK = 1;
        this.Oa = Parcel.obtain();
        safeParcelable.writeToParcel(this.Oa, 0);
        this.Ob = 1;
        this.NT = (kv) jx.m5223i(kvVar);
        this.mClassName = (String) jx.m5223i(str);
        this.Oc = 2;
    }

    public static <T extends kr & SafeParcelable> ky m5296a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ky((SafeParcelable) t, m5302b((kr) t), canonicalName);
    }

    private static void m5297a(kv kvVar, kr krVar) {
        Class cls = krVar.getClass();
        if (!kvVar.m5291b(cls)) {
            HashMap hK = krVar.hK();
            kvVar.m5290a(cls, krVar.hK());
            for (String str : hK.keySet()) {
                C1277a c1277a = (C1277a) hK.get(str);
                Class hS = c1277a.hS();
                if (hS != null) {
                    try {
                        m5297a(kvVar, (kr) hS.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c1277a.hS().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c1277a.hS().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m5298a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case WalletFragmentState.PROCESSING /*3*/:
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
            case Dimension.UNIT_MM /*5*/:
            case Error.OTHER /*6*/:
                stringBuilder.append(obj);
            case Error.AVS_DECLINE /*7*/:
                stringBuilder.append("\"").append(li.bh(obj.toString())).append("\"");
            case Error.FRAUD_DECLINE /*8*/:
                stringBuilder.append("\"").append(lb.m5321d((byte[]) obj)).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(lb.m5322e((byte[]) obj));
                stringBuilder.append("\"");
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                lj.m5333a(stringBuilder, (HashMap) obj);
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m5299a(StringBuilder stringBuilder, C1277a<?, ?> c1277a, Parcel parcel, int i) {
        switch (c1277a.hJ()) {
            case WalletFragmentState.UNKNOWN /*0*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, Integer.valueOf(C0541a.m1933g(parcel, i))));
            case DataEvent.TYPE_CHANGED /*1*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, C0541a.m1937k(parcel, i)));
            case DataEvent.TYPE_DELETED /*2*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, Long.valueOf(C0541a.m1935i(parcel, i))));
            case WalletFragmentState.PROCESSING /*3*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, Float.valueOf(C0541a.m1938l(parcel, i))));
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, Double.valueOf(C0541a.m1939m(parcel, i))));
            case Dimension.UNIT_MM /*5*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, C0541a.m1940n(parcel, i)));
            case Error.OTHER /*6*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, Boolean.valueOf(C0541a.m1929c(parcel, i))));
            case Error.AVS_DECLINE /*7*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, C0541a.m1941o(parcel, i)));
            case Error.FRAUD_DECLINE /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, C0541a.m1944r(parcel, i)));
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                m5305b(stringBuilder, (C1277a) c1277a, m5281a(c1277a, m5307g(C0541a.m1943q(parcel, i))));
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c1277a.hJ());
        }
    }

    private void m5300a(StringBuilder stringBuilder, String str, C1277a<?, ?> c1277a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c1277a.hU()) {
            m5299a(stringBuilder, c1277a, parcel, i);
        } else {
            m5304b(stringBuilder, c1277a, parcel, i);
        }
    }

    private void m5301a(StringBuilder stringBuilder, HashMap<String, C1277a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = m5303b((HashMap) hashMap);
        stringBuilder.append('{');
        int G = C0541a.m1920G(parcel);
        Object obj = null;
        while (parcel.dataPosition() < G) {
            int F = C0541a.m1919F(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(C0541a.aH(F)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m5300a(stringBuilder, (String) entry.getKey(), (C1277a) entry.getValue(), parcel, F);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new C0540a("Overread allowed size end=" + G, parcel);
        }
        stringBuilder.append('}');
    }

    private static kv m5302b(kr krVar) {
        kv kvVar = new kv(krVar.getClass());
        m5297a(kvVar, krVar);
        kvVar.hY();
        kvVar.hX();
        return kvVar;
    }

    private static HashMap<Integer, Entry<String, C1277a<?, ?>>> m5303b(HashMap<String, C1277a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C1277a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C1277a) entry.getValue()).hR()), entry);
        }
        return hashMap2;
    }

    private void m5304b(StringBuilder stringBuilder, C1277a<?, ?> c1277a, Parcel parcel, int i) {
        if (c1277a.hP()) {
            stringBuilder.append("[");
            switch (c1277a.hJ()) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    la.m5313a(stringBuilder, C0541a.m1947u(parcel, i));
                    break;
                case DataEvent.TYPE_CHANGED /*1*/:
                    la.m5315a(stringBuilder, C0541a.m1949w(parcel, i));
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    la.m5314a(stringBuilder, C0541a.m1948v(parcel, i));
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                    la.m5312a(stringBuilder, C0541a.m1950x(parcel, i));
                    break;
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    la.m5311a(stringBuilder, C0541a.m1951y(parcel, i));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    la.m5315a(stringBuilder, C0541a.m1952z(parcel, i));
                    break;
                case Error.OTHER /*6*/:
                    la.m5317a(stringBuilder, C0541a.m1946t(parcel, i));
                    break;
                case Error.AVS_DECLINE /*7*/:
                    la.m5316a(stringBuilder, C0541a.m1914A(parcel, i));
                    break;
                case Error.FRAUD_DECLINE /*8*/:
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    Parcel[] E = C0541a.m1918E(parcel, i);
                    int length = E.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        E[i2].setDataPosition(0);
                        m5301a(stringBuilder, c1277a.hW(), E[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c1277a.hJ()) {
            case WalletFragmentState.UNKNOWN /*0*/:
                stringBuilder.append(C0541a.m1933g(parcel, i));
            case DataEvent.TYPE_CHANGED /*1*/:
                stringBuilder.append(C0541a.m1937k(parcel, i));
            case DataEvent.TYPE_DELETED /*2*/:
                stringBuilder.append(C0541a.m1935i(parcel, i));
            case WalletFragmentState.PROCESSING /*3*/:
                stringBuilder.append(C0541a.m1938l(parcel, i));
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                stringBuilder.append(C0541a.m1939m(parcel, i));
            case Dimension.UNIT_MM /*5*/:
                stringBuilder.append(C0541a.m1940n(parcel, i));
            case Error.OTHER /*6*/:
                stringBuilder.append(C0541a.m1929c(parcel, i));
            case Error.AVS_DECLINE /*7*/:
                stringBuilder.append("\"").append(li.bh(C0541a.m1941o(parcel, i))).append("\"");
            case Error.FRAUD_DECLINE /*8*/:
                stringBuilder.append("\"").append(lb.m5321d(C0541a.m1944r(parcel, i))).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(lb.m5322e(C0541a.m1944r(parcel, i)));
                stringBuilder.append("\"");
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                Bundle q = C0541a.m1943q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(li.bh(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                Parcel D = C0541a.m1917D(parcel, i);
                D.setDataPosition(0);
                m5301a(stringBuilder, c1277a.hW(), D);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m5305b(StringBuilder stringBuilder, C1277a<?, ?> c1277a, Object obj) {
        if (c1277a.hO()) {
            m5306b(stringBuilder, (C1277a) c1277a, (ArrayList) obj);
        } else {
            m5298a(stringBuilder, c1277a.hI(), obj);
        }
    }

    private void m5306b(StringBuilder stringBuilder, C1277a<?, ?> c1277a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m5298a(stringBuilder, c1277a.hI(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> m5307g(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object bc(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean bd(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        kz kzVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public HashMap<String, C1277a<?, ?>> hK() {
        return this.NT == null ? null : this.NT.bg(this.mClassName);
    }

    public Parcel ic() {
        switch (this.Oc) {
            case WalletFragmentState.UNKNOWN /*0*/:
                this.Od = C0542b.m1955H(this.Oa);
                break;
            case DataEvent.TYPE_CHANGED /*1*/:
                break;
        }
        C0542b.m1956H(this.Oa, this.Od);
        this.Oc = 2;
        return this.Oa;
    }

    kv id() {
        switch (this.Ob) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return null;
            case DataEvent.TYPE_CHANGED /*1*/:
                return this.NT;
            case DataEvent.TYPE_DELETED /*2*/:
                return this.NT;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Ob);
        }
    }

    public String toString() {
        jx.m5219b(this.NT, (Object) "Cannot convert to JSON on client side.");
        Parcel ic = ic();
        ic.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m5301a(stringBuilder, this.NT.bg(this.mClassName), ic);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kz kzVar = CREATOR;
        kz.m5308a(this, parcel, i);
    }
}
