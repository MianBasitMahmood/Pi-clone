package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class kr {

    /* renamed from: com.google.android.gms.internal.kr.b */
    public interface C1276b<I, O> {
        I convertBack(O o);

        int hI();

        int hJ();
    }

    /* renamed from: com.google.android.gms.internal.kr.a */
    public static class C1277a<I, O> implements SafeParcelable {
        public static final kt CREATOR;
        private final int CK;
        protected final int NL;
        protected final boolean NM;
        protected final int NN;
        protected final boolean NO;
        protected final String NP;
        protected final int NQ;
        protected final Class<? extends kr> NR;
        protected final String NS;
        private kv NT;
        private C1276b<I, O> NU;

        static {
            CREATOR = new kt();
        }

        C1277a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, km kmVar) {
            this.CK = i;
            this.NL = i2;
            this.NM = z;
            this.NN = i3;
            this.NO = z2;
            this.NP = str;
            this.NQ = i4;
            if (str2 == null) {
                this.NR = null;
                this.NS = null;
            } else {
                this.NR = ky.class;
                this.NS = str2;
            }
            if (kmVar == null) {
                this.NU = null;
            } else {
                this.NU = kmVar.hG();
            }
        }

        protected C1277a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends kr> cls, C1276b<I, O> c1276b) {
            this.CK = 1;
            this.NL = i;
            this.NM = z;
            this.NN = i2;
            this.NO = z2;
            this.NP = str;
            this.NQ = i3;
            this.NR = cls;
            if (cls == null) {
                this.NS = null;
            } else {
                this.NS = cls.getCanonicalName();
            }
            this.NU = c1276b;
        }

        public static C1277a m5269a(String str, int i, C1276b<?, ?> c1276b, boolean z) {
            return new C1277a(c1276b.hI(), z, c1276b.hJ(), false, str, i, null, c1276b);
        }

        public static <T extends kr> C1277a<T, T> m5270a(String str, int i, Class<T> cls) {
            return new C1277a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends kr> C1277a<ArrayList<T>, ArrayList<T>> m5271b(String str, int i, Class<T> cls) {
            return new C1277a(11, true, 11, true, str, i, cls, null);
        }

        public static C1277a<Integer, Integer> m5273i(String str, int i) {
            return new C1277a(0, false, 0, false, str, i, null, null);
        }

        public static C1277a<Double, Double> m5274j(String str, int i) {
            return new C1277a(4, false, 4, false, str, i, null, null);
        }

        public static C1277a<Boolean, Boolean> m5275k(String str, int i) {
            return new C1277a(6, false, 6, false, str, i, null, null);
        }

        public static C1277a<String, String> m5276l(String str, int i) {
            return new C1277a(7, false, 7, false, str, i, null, null);
        }

        public static C1277a<ArrayList<String>, ArrayList<String>> m5277m(String str, int i) {
            return new C1277a(7, true, 7, true, str, i, null, null);
        }

        public void m5278a(kv kvVar) {
            this.NT = kvVar;
        }

        public I convertBack(O o) {
            return this.NU.convertBack(o);
        }

        public int describeContents() {
            kt ktVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.CK;
        }

        public int hI() {
            return this.NL;
        }

        public int hJ() {
            return this.NN;
        }

        public C1277a<I, O> hN() {
            return new C1277a(this.CK, this.NL, this.NM, this.NN, this.NO, this.NP, this.NQ, this.NS, hV());
        }

        public boolean hO() {
            return this.NM;
        }

        public boolean hP() {
            return this.NO;
        }

        public String hQ() {
            return this.NP;
        }

        public int hR() {
            return this.NQ;
        }

        public Class<? extends kr> hS() {
            return this.NR;
        }

        String hT() {
            return this.NS == null ? null : this.NS;
        }

        public boolean hU() {
            return this.NU != null;
        }

        km hV() {
            return this.NU == null ? null : km.m5259a(this.NU);
        }

        public HashMap<String, C1277a<?, ?>> hW() {
            jx.m5223i(this.NS);
            jx.m5223i(this.NT);
            return this.NT.bg(this.NS);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.CK).append('\n');
            stringBuilder.append("                 typeIn=").append(this.NL).append('\n');
            stringBuilder.append("            typeInArray=").append(this.NM).append('\n');
            stringBuilder.append("                typeOut=").append(this.NN).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.NO).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.NP).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.NQ).append('\n');
            stringBuilder.append("       concreteTypeName=").append(hT()).append('\n');
            if (hS() != null) {
                stringBuilder.append("     concreteType.class=").append(hS().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.NU == null ? "null" : this.NU.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            kt ktVar = CREATOR;
            kt.m5284a(this, parcel, i);
        }
    }

    private void m5279a(StringBuilder stringBuilder, C1277a c1277a, Object obj) {
        if (c1277a.hI() == 11) {
            stringBuilder.append(((kr) c1277a.hS().cast(obj)).toString());
        } else if (c1277a.hI() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(li.bh((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m5280a(StringBuilder stringBuilder, C1277a c1277a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m5279a(stringBuilder, c1277a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m5281a(C1277a<I, O> c1277a, Object obj) {
        return c1277a.NU != null ? c1277a.convertBack(obj) : obj;
    }

    protected boolean m5282a(C1277a c1277a) {
        return c1277a.hJ() == 11 ? c1277a.hP() ? bf(c1277a.hQ()) : be(c1277a.hQ()) : bd(c1277a.hQ());
    }

    protected Object m5283b(C1277a c1277a) {
        String hQ = c1277a.hQ();
        if (c1277a.hS() == null) {
            return bc(c1277a.hQ());
        }
        jx.m5218a(bc(c1277a.hQ()) == null, "Concrete field shouldn't be value object: %s", c1277a.hQ());
        Map hM = c1277a.hP() ? hM() : hL();
        if (hM != null) {
            return hM.get(hQ);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(hQ.charAt(0)) + hQ.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object bc(String str);

    protected abstract boolean bd(String str);

    protected boolean be(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean bf(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract HashMap<String, C1277a<?, ?>> hK();

    public HashMap<String, Object> hL() {
        return null;
    }

    public HashMap<String, Object> hM() {
        return null;
    }

    public String toString() {
        HashMap hK = hK();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : hK.keySet()) {
            C1277a c1277a = (C1277a) hK.get(str);
            if (m5282a(c1277a)) {
                Object a = m5281a(c1277a, m5283b(c1277a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c1277a.hJ()) {
                        case Error.FRAUD_DECLINE /*8*/:
                            stringBuilder.append("\"").append(lb.m5321d((byte[]) a)).append("\"");
                            break;
                        case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                            stringBuilder.append("\"").append(lb.m5322e((byte[]) a)).append("\"");
                            break;
                        case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                            lj.m5333a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c1277a.hO()) {
                                m5279a(stringBuilder, c1277a, a);
                                break;
                            }
                            m5280a(stringBuilder, c1277a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
