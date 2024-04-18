package com.google.android.gms.tagmanager;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1048c.C1039b;
import com.google.android.gms.internal.C1048c.C1042e;
import com.google.android.gms.internal.C1048c.C1043f;
import com.google.android.gms.internal.C1048c.C1044g;
import com.google.android.gms.internal.C1048c.C1045h;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {

    /* renamed from: com.google.android.gms.tagmanager.cr.a */
    public static class C1780a {
        private final Map<String, C1070a> asM;
        private final C1070a asN;

        private C1780a(Map<String, C1070a> map, C1070a c1070a) {
            this.asM = map;
            this.asN = c1070a;
        }

        public static C1781b qk() {
            return new C1781b();
        }

        public void m6531a(String str, C1070a c1070a) {
            this.asM.put(str, c1070a);
        }

        public Map<String, C1070a> ql() {
            return Collections.unmodifiableMap(this.asM);
        }

        public C1070a qm() {
            return this.asN;
        }

        public String toString() {
            return "Properties: " + ql() + " pushAfterEvaluate: " + this.asN;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.b */
    public static class C1781b {
        private final Map<String, C1070a> asM;
        private C1070a asN;

        private C1781b() {
            this.asM = new HashMap();
        }

        public C1781b m6532b(String str, C1070a c1070a) {
            this.asM.put(str, c1070a);
            return this;
        }

        public C1781b m6533i(C1070a c1070a) {
            this.asN = c1070a;
            return this;
        }

        public C1780a qn() {
            return new C1780a(this.asN, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.c */
    public static class C1782c {
        private final String TU;
        private final List<C1784e> asO;
        private final Map<String, List<C1780a>> asP;
        private final int asQ;

        private C1782c(List<C1784e> list, Map<String, List<C1780a>> map, String str, int i) {
            this.asO = Collections.unmodifiableList(list);
            this.asP = Collections.unmodifiableMap(map);
            this.TU = str;
            this.asQ = i;
        }

        public static C1783d qo() {
            return new C1783d();
        }

        public String getVersion() {
            return this.TU;
        }

        public List<C1784e> qp() {
            return this.asO;
        }

        public Map<String, List<C1780a>> qq() {
            return this.asP;
        }

        public String toString() {
            return "Rules: " + qp() + "  Macros: " + this.asP;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.d */
    public static class C1783d {
        private String TU;
        private final List<C1784e> asO;
        private final Map<String, List<C1780a>> asP;
        private int asQ;

        private C1783d() {
            this.asO = new ArrayList();
            this.asP = new HashMap();
            this.TU = "";
            this.asQ = 0;
        }

        public C1783d m6534a(C1780a c1780a) {
            String j = di.m6607j((C1070a) c1780a.ql().get(C1022b.INSTANCE_NAME.toString()));
            List list = (List) this.asP.get(j);
            if (list == null) {
                list = new ArrayList();
                this.asP.put(j, list);
            }
            list.add(c1780a);
            return this;
        }

        public C1783d m6535a(C1784e c1784e) {
            this.asO.add(c1784e);
            return this;
        }

        public C1783d cO(String str) {
            this.TU = str;
            return this;
        }

        public C1783d fO(int i) {
            this.asQ = i;
            return this;
        }

        public C1782c qr() {
            return new C1782c(this.asP, this.TU, this.asQ, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.e */
    public static class C1784e {
        private final List<C1780a> asR;
        private final List<C1780a> asS;
        private final List<C1780a> asT;
        private final List<C1780a> asU;
        private final List<C1780a> asV;
        private final List<C1780a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private C1784e(List<C1780a> list, List<C1780a> list2, List<C1780a> list3, List<C1780a> list4, List<C1780a> list5, List<C1780a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.asR = Collections.unmodifiableList(list);
            this.asS = Collections.unmodifiableList(list2);
            this.asT = Collections.unmodifiableList(list3);
            this.asU = Collections.unmodifiableList(list4);
            this.asV = Collections.unmodifiableList(list5);
            this.asW = Collections.unmodifiableList(list6);
            this.asX = Collections.unmodifiableList(list7);
            this.asY = Collections.unmodifiableList(list8);
            this.asZ = Collections.unmodifiableList(list9);
            this.ata = Collections.unmodifiableList(list10);
        }

        public static C1785f qs() {
            return new C1785f();
        }

        public List<String> qA() {
            return this.asZ;
        }

        public List<String> qB() {
            return this.ata;
        }

        public List<C1780a> qC() {
            return this.asW;
        }

        public List<C1780a> qt() {
            return this.asR;
        }

        public List<C1780a> qu() {
            return this.asS;
        }

        public List<C1780a> qv() {
            return this.asT;
        }

        public List<C1780a> qw() {
            return this.asU;
        }

        public List<C1780a> qx() {
            return this.asV;
        }

        public List<String> qy() {
            return this.asX;
        }

        public List<String> qz() {
            return this.asY;
        }

        public String toString() {
            return "Positive predicates: " + qt() + "  Negative predicates: " + qu() + "  Add tags: " + qv() + "  Remove tags: " + qw() + "  Add macros: " + qx() + "  Remove macros: " + qC();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.f */
    public static class C1785f {
        private final List<C1780a> asR;
        private final List<C1780a> asS;
        private final List<C1780a> asT;
        private final List<C1780a> asU;
        private final List<C1780a> asV;
        private final List<C1780a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private C1785f() {
            this.asR = new ArrayList();
            this.asS = new ArrayList();
            this.asT = new ArrayList();
            this.asU = new ArrayList();
            this.asV = new ArrayList();
            this.asW = new ArrayList();
            this.asX = new ArrayList();
            this.asY = new ArrayList();
            this.asZ = new ArrayList();
            this.ata = new ArrayList();
        }

        public C1785f m6536b(C1780a c1780a) {
            this.asR.add(c1780a);
            return this;
        }

        public C1785f m6537c(C1780a c1780a) {
            this.asS.add(c1780a);
            return this;
        }

        public C1785f cP(String str) {
            this.asZ.add(str);
            return this;
        }

        public C1785f cQ(String str) {
            this.ata.add(str);
            return this;
        }

        public C1785f cR(String str) {
            this.asX.add(str);
            return this;
        }

        public C1785f cS(String str) {
            this.asY.add(str);
            return this;
        }

        public C1785f m6538d(C1780a c1780a) {
            this.asT.add(c1780a);
            return this;
        }

        public C1785f m6539e(C1780a c1780a) {
            this.asU.add(c1780a);
            return this;
        }

        public C1785f m6540f(C1780a c1780a) {
            this.asV.add(c1780a);
            return this;
        }

        public C1785f m6541g(C1780a c1780a) {
            this.asW.add(c1780a);
            return this;
        }

        public C1784e qD() {
            return new C1784e(this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.g */
    public static class C1786g extends Exception {
        public C1786g(String str) {
            super(str);
        }
    }

    private static C1070a m6542a(int i, C1043f c1043f, C1070a[] c1070aArr, Set<Integer> set) throws C1786g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cN("Value cycle detected.  Current value reference: " + i + ".  Previous value references: " + set + ".");
        }
        C1070a c1070a = (C1070a) m6545a(c1043f.fG, i, "values");
        if (c1070aArr[i] != null) {
            return c1070aArr[i];
        }
        C1070a c1070a2 = null;
        set.add(Integer.valueOf(i));
        C1045h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c1070a.type) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case Dimension.UNIT_MM /*5*/:
            case Error.OTHER /*6*/:
            case Error.FRAUD_DECLINE /*8*/:
                c1070a2 = c1070a;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                h = m6549h(c1070a);
                c1070a2 = m6548g(c1070a);
                c1070a2.gw = new C1070a[h.gh.length];
                iArr = h.gh;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1070a2.gw[i3] = m6542a(iArr[i2], c1043f, c1070aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case WalletFragmentState.PROCESSING /*3*/:
                c1070a2 = m6548g(c1070a);
                C1045h h2 = m6549h(c1070a);
                if (h2.gi.length != h2.gj.length) {
                    cN("Uneven map keys (" + h2.gi.length + ") and map values (" + h2.gj.length + ")");
                }
                c1070a2.gx = new C1070a[h2.gi.length];
                c1070a2.gy = new C1070a[h2.gi.length];
                int[] iArr2 = h2.gi;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c1070a2.gx[i4] = m6542a(iArr2[i3], c1043f, c1070aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.gj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1070a2.gy[i3] = m6542a(iArr[i2], c1043f, c1070aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                c1070a2 = m6548g(c1070a);
                c1070a2.gz = di.m6607j(m6542a(m6549h(c1070a).gm, c1043f, c1070aArr, (Set) set));
                break;
            case Error.AVS_DECLINE /*7*/:
                c1070a2 = m6548g(c1070a);
                h = m6549h(c1070a);
                c1070a2.gD = new C1070a[h.gl.length];
                iArr = h.gl;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1070a2.gD[i3] = m6542a(iArr[i2], c1043f, c1070aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c1070a2 == null) {
            cN("Invalid value: " + c1070a);
        }
        c1070aArr[i] = c1070a2;
        set.remove(Integer.valueOf(i));
        return c1070a2;
    }

    private static C1780a m6543a(C1039b c1039b, C1043f c1043f, C1070a[] c1070aArr, int i) throws C1786g {
        C1781b qk = C1780a.qk();
        for (int valueOf : c1039b.fq) {
            C1042e c1042e = (C1042e) m6545a(c1043f.fH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m6545a(c1043f.fF, c1042e.key, "keys");
            C1070a c1070a = (C1070a) m6545a(c1070aArr, c1042e.value, "values");
            if (C1022b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                qk.m6533i(c1070a);
            } else {
                qk.m6532b(str, c1070a);
            }
        }
        return qk.qn();
    }

    private static C1784e m6544a(C1044g c1044g, List<C1780a> list, List<C1780a> list2, List<C1780a> list3, C1043f c1043f) {
        C1785f qs = C1784e.qs();
        for (int valueOf : c1044g.fV) {
            qs.m6536b((C1780a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c1044g.fW) {
            qs.m6537c((C1780a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c1044g.fX) {
            qs.m6538d((C1780a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c1044g.fZ) {
            qs.cP(c1043f.fG[Integer.valueOf(valueOf3).intValue()].gv);
        }
        for (int valueOf222 : c1044g.fY) {
            qs.m6539e((C1780a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c1044g.ga) {
            qs.cQ(c1043f.fG[Integer.valueOf(valueOf32).intValue()].gv);
        }
        for (int valueOf2222 : c1044g.gb) {
            qs.m6540f((C1780a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c1044g.gd) {
            qs.cR(c1043f.fG[Integer.valueOf(valueOf322).intValue()].gv);
        }
        for (int valueOf22222 : c1044g.gc) {
            qs.m6541g((C1780a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c1044g.ge) {
            qs.cS(c1043f.fG[Integer.valueOf(valueOf4).intValue()].gv);
        }
        return qs.qD();
    }

    private static <T> T m6545a(T[] tArr, int i, String str) throws C1786g {
        if (i < 0 || i >= tArr.length) {
            cN("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static C1782c m6546b(C1043f c1043f) throws C1786g {
        int i;
        int i2 = 0;
        C1070a[] c1070aArr = new C1070a[c1043f.fG.length];
        for (i = 0; i < c1043f.fG.length; i++) {
            m6542a(i, c1043f, c1070aArr, new HashSet(0));
        }
        C1783d qo = C1782c.qo();
        List arrayList = new ArrayList();
        for (i = 0; i < c1043f.fJ.length; i++) {
            arrayList.add(m6543a(c1043f.fJ[i], c1043f, c1070aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c1043f.fK.length; i++) {
            arrayList2.add(m6543a(c1043f.fK[i], c1043f, c1070aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c1043f.fI.length; i++) {
            C1780a a = m6543a(c1043f.fI[i], c1043f, c1070aArr, i);
            qo.m6534a(a);
            arrayList3.add(a);
        }
        C1044g[] c1044gArr = c1043f.fL;
        int length = c1044gArr.length;
        while (i2 < length) {
            qo.m6535a(m6544a(c1044gArr[i2], arrayList, arrayList3, arrayList2, c1043f));
            i2++;
        }
        qo.cO(c1043f.version);
        qo.fO(c1043f.fT);
        return qo.qr();
    }

    public static void m6547b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cN(String str) throws C1786g {
        bh.m6458T(str);
        throw new C1786g(str);
    }

    public static C1070a m6548g(C1070a c1070a) {
        C1070a c1070a2 = new C1070a();
        c1070a2.type = c1070a.type;
        c1070a2.gE = (int[]) c1070a.gE.clone();
        if (c1070a.gF) {
            c1070a2.gF = c1070a.gF;
        }
        return c1070a2;
    }

    private static C1045h m6549h(C1070a c1070a) throws C1786g {
        if (((C1045h) c1070a.m2149a(C1045h.gf)) == null) {
            cN("Expected a ServingValue and didn't get one. Value is: " + c1070a);
        }
        return (C1045h) c1070a.m2149a(C1045h.gf);
    }
}
