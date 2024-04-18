package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1048c.C1046i;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.tagmanager.C1810l.C1787a;
import com.google.android.gms.tagmanager.C1825s.C1738a;
import com.google.android.gms.tagmanager.cr.C1780a;
import com.google.android.gms.tagmanager.cr.C1782c;
import com.google.android.gms.tagmanager.cr.C1784e;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct {
    private static final bz<C1070a> atb;
    private final DataLayer aqn;
    private final C1782c atc;
    private final ag atd;
    private final Map<String, aj> ate;
    private final Map<String, aj> atf;
    private final Map<String, aj> atg;
    private final C1762k<C1780a, bz<C1070a>> ath;
    private final C1762k<String, C1793b> ati;
    private final Set<C1784e> atj;
    private final Map<String, C1794c> atk;
    private volatile String atl;
    private int atm;

    /* renamed from: com.google.android.gms.tagmanager.ct.1 */
    class C17881 implements C1787a<C1780a, bz<C1070a>> {
        final /* synthetic */ ct atn;

        C17881(ct ctVar) {
            this.atn = ctVar;
        }

        public int m6550a(C1780a c1780a, bz<C1070a> bzVar) {
            return ((C1070a) bzVar.getObject()).rY();
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m6550a((C1780a) obj, (bz) obj2);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.2 */
    class C17892 implements C1787a<String, C1793b> {
        final /* synthetic */ ct atn;

        C17892(ct ctVar) {
            this.atn = ctVar;
        }

        public int m6551a(String str, C1793b c1793b) {
            return str.length() + c1793b.getSize();
        }

        public /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m6551a((String) obj, (C1793b) obj2);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.a */
    interface C1790a {
        void m6552a(C1784e c1784e, Set<C1780a> set, Set<C1780a> set2, cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.3 */
    class C17913 implements C1790a {
        final /* synthetic */ ct atn;
        final /* synthetic */ Map ato;
        final /* synthetic */ Map atp;
        final /* synthetic */ Map atq;
        final /* synthetic */ Map atr;

        C17913(ct ctVar, Map map, Map map2, Map map3, Map map4) {
            this.atn = ctVar;
            this.ato = map;
            this.atp = map2;
            this.atq = map3;
            this.atr = map4;
        }

        public void m6553a(C1784e c1784e, Set<C1780a> set, Set<C1780a> set2, cn cnVar) {
            List list = (List) this.ato.get(c1784e);
            List list2 = (List) this.atp.get(c1784e);
            if (list != null) {
                set.addAll(list);
                cnVar.pR().m6479c(list, list2);
            }
            list = (List) this.atq.get(c1784e);
            list2 = (List) this.atr.get(c1784e);
            if (list != null) {
                set2.addAll(list);
                cnVar.pS().m6479c(list, list2);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.4 */
    class C17924 implements C1790a {
        final /* synthetic */ ct atn;

        C17924(ct ctVar) {
            this.atn = ctVar;
        }

        public void m6554a(C1784e c1784e, Set<C1780a> set, Set<C1780a> set2, cn cnVar) {
            set.addAll(c1784e.qv());
            set2.addAll(c1784e.qw());
            cnVar.pT().m6479c(c1784e.qv(), c1784e.qA());
            cnVar.pU().m6479c(c1784e.qw(), c1784e.qB());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.b */
    private static class C1793b {
        private C1070a asN;
        private bz<C1070a> ats;

        public C1793b(bz<C1070a> bzVar, C1070a c1070a) {
            this.ats = bzVar;
            this.asN = c1070a;
        }

        public int getSize() {
            return (this.asN == null ? 0 : this.asN.rY()) + ((C1070a) this.ats.getObject()).rY();
        }

        public bz<C1070a> qG() {
            return this.ats;
        }

        public C1070a qm() {
            return this.asN;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.c */
    private static class C1794c {
        private final Set<C1784e> atj;
        private final Map<C1784e, List<C1780a>> att;
        private final Map<C1784e, List<C1780a>> atu;
        private final Map<C1784e, List<String>> atv;
        private final Map<C1784e, List<String>> atw;
        private C1780a atx;

        public C1794c() {
            this.atj = new HashSet();
            this.att = new HashMap();
            this.atv = new HashMap();
            this.atu = new HashMap();
            this.atw = new HashMap();
        }

        public void m6555a(C1784e c1784e, C1780a c1780a) {
            List list = (List) this.att.get(c1784e);
            if (list == null) {
                list = new ArrayList();
                this.att.put(c1784e, list);
            }
            list.add(c1780a);
        }

        public void m6556a(C1784e c1784e, String str) {
            List list = (List) this.atv.get(c1784e);
            if (list == null) {
                list = new ArrayList();
                this.atv.put(c1784e, list);
            }
            list.add(str);
        }

        public void m6557b(C1784e c1784e) {
            this.atj.add(c1784e);
        }

        public void m6558b(C1784e c1784e, C1780a c1780a) {
            List list = (List) this.atu.get(c1784e);
            if (list == null) {
                list = new ArrayList();
                this.atu.put(c1784e, list);
            }
            list.add(c1780a);
        }

        public void m6559b(C1784e c1784e, String str) {
            List list = (List) this.atw.get(c1784e);
            if (list == null) {
                list = new ArrayList();
                this.atw.put(c1784e, list);
            }
            list.add(str);
        }

        public void m6560i(C1780a c1780a) {
            this.atx = c1780a;
        }

        public Set<C1784e> qH() {
            return this.atj;
        }

        public Map<C1784e, List<C1780a>> qI() {
            return this.att;
        }

        public Map<C1784e, List<String>> qJ() {
            return this.atv;
        }

        public Map<C1784e, List<String>> qK() {
            return this.atw;
        }

        public Map<C1784e, List<C1780a>> qL() {
            return this.atu;
        }

        public C1780a qM() {
            return this.atx;
        }
    }

    static {
        atb = new bz(di.rb(), true);
    }

    public ct(Context context, C1782c c1782c, DataLayer dataLayer, C1738a c1738a, C1738a c1738a2, ag agVar) {
        if (c1782c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.atc = c1782c;
        this.atj = new HashSet(c1782c.qp());
        this.aqn = dataLayer;
        this.atd = agVar;
        this.ath = new C1810l().m6647a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C17881(this));
        this.ati = new C1810l().m6647a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C17892(this));
        this.ate = new HashMap();
        m6575b(new C1807i(context));
        m6575b(new C1825s(c1738a2));
        m6575b(new C1833w(dataLayer));
        m6575b(new dj(context, dataLayer));
        this.atf = new HashMap();
        m6576c(new C1823q());
        m6576c(new ad());
        m6576c(new ae());
        m6576c(new al());
        m6576c(new am());
        m6576c(new bd());
        m6576c(new be());
        m6576c(new ci());
        m6576c(new dc());
        this.atg = new HashMap();
        m6574a(new C1760b(context));
        m6574a(new C1766c(context));
        m6574a(new C1801e(context));
        m6574a(new C1802f(context));
        m6574a(new C1803g(context));
        m6574a(new C1804h(context));
        m6574a(new C1811m());
        m6574a(new C1822p(this.atc.getVersion()));
        m6574a(new C1825s(c1738a));
        m6574a(new C1826u(dataLayer));
        m6574a(new C1836z(context));
        m6574a(new aa());
        m6574a(new ac());
        m6574a(new ah(this));
        m6574a(new an());
        m6574a(new ao());
        m6574a(new ax(context));
        m6574a(new az());
        m6574a(new bc());
        m6574a(new bj());
        m6574a(new bl(context));
        m6574a(new ca());
        m6574a(new cc());
        m6574a(new cf());
        m6574a(new ch());
        m6574a(new cj(context));
        m6574a(new cu());
        m6574a(new cv());
        m6574a(new de());
        m6574a(new dk());
        this.atk = new HashMap();
        for (C1784e c1784e : this.atj) {
            if (agVar.pH()) {
                m6566a(c1784e.qx(), c1784e.qy(), "add macro");
                m6566a(c1784e.qC(), c1784e.qz(), "remove macro");
                m6566a(c1784e.qv(), c1784e.qA(), "add tag");
                m6566a(c1784e.qw(), c1784e.qB(), "remove tag");
            }
            int i = 0;
            while (i < c1784e.qx().size()) {
                C1780a c1780a = (C1780a) c1784e.qx().get(i);
                String str = "Unknown";
                if (agVar.pH() && i < c1784e.qy().size()) {
                    str = (String) c1784e.qy().get(i);
                }
                C1794c e = m6568e(this.atk, m6569h(c1780a));
                e.m6557b(c1784e);
                e.m6555a(c1784e, c1780a);
                e.m6556a(c1784e, str);
                i++;
            }
            i = 0;
            while (i < c1784e.qC().size()) {
                C1780a c1780a2 = (C1780a) c1784e.qC().get(i);
                String str2 = "Unknown";
                if (agVar.pH() && i < c1784e.qz().size()) {
                    str2 = (String) c1784e.qz().get(i);
                }
                e = m6568e(this.atk, m6569h(c1780a2));
                e.m6557b(c1784e);
                e.m6558b(c1784e, c1780a2);
                e.m6559b(c1784e, str2);
                i++;
            }
        }
        for (Entry entry : this.atc.qq().entrySet()) {
            for (C1780a c1780a3 : (List) entry.getValue()) {
                if (!di.m6611n((C1070a) c1780a3.ql().get(C1022b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m6568e(this.atk, (String) entry.getKey()).m6560i(c1780a3);
                }
            }
        }
    }

    private bz<C1070a> m6561a(C1070a c1070a, Set<String> set, dl dlVar) {
        if (!c1070a.gF) {
            return new bz(c1070a, true);
        }
        C1070a g;
        int i;
        bz a;
        switch (c1070a.type) {
            case DataEvent.TYPE_DELETED /*2*/:
                g = cr.m6548g(c1070a);
                g.gw = new C1070a[c1070a.gw.length];
                for (i = 0; i < c1070a.gw.length; i++) {
                    a = m6561a(c1070a.gw[i], (Set) set, dlVar.fK(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gw[i] = (C1070a) a.getObject();
                }
                return new bz(g, false);
            case WalletFragmentState.PROCESSING /*3*/:
                g = cr.m6548g(c1070a);
                if (c1070a.gx.length != c1070a.gy.length) {
                    bh.m6458T("Invalid serving value: " + c1070a.toString());
                    return atb;
                }
                g.gx = new C1070a[c1070a.gx.length];
                g.gy = new C1070a[c1070a.gx.length];
                for (i = 0; i < c1070a.gx.length; i++) {
                    a = m6561a(c1070a.gx[i], (Set) set, dlVar.fL(i));
                    bz a2 = m6561a(c1070a.gy[i], (Set) set, dlVar.fM(i));
                    if (a == atb || a2 == atb) {
                        return atb;
                    }
                    g.gx[i] = (C1070a) a.getObject();
                    g.gy[i] = (C1070a) a2.getObject();
                }
                return new bz(g, false);
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                if (set.contains(c1070a.gz)) {
                    bh.m6458T("Macro cycle detected.  Current macro reference: " + c1070a.gz + ".  Previous macro references: " + set.toString() + ".");
                    return atb;
                }
                set.add(c1070a.gz);
                bz<C1070a> a3 = dm.m6639a(m6562a(c1070a.gz, (Set) set, dlVar.pW()), c1070a.gE);
                set.remove(c1070a.gz);
                return a3;
            case Error.AVS_DECLINE /*7*/:
                g = cr.m6548g(c1070a);
                g.gD = new C1070a[c1070a.gD.length];
                for (i = 0; i < c1070a.gD.length; i++) {
                    a = m6561a(c1070a.gD[i], (Set) set, dlVar.fN(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gD[i] = (C1070a) a.getObject();
                }
                return new bz(g, false);
            default:
                bh.m6458T("Unknown type: " + c1070a.type);
                return atb;
        }
    }

    private bz<C1070a> m6562a(String str, Set<String> set, bk bkVar) {
        this.atm++;
        C1793b c1793b = (C1793b) this.ati.get(str);
        if (c1793b == null || this.atd.pH()) {
            C1794c c1794c = (C1794c) this.atk.get(str);
            if (c1794c == null) {
                bh.m6458T(qF() + "Invalid macro: " + str);
                this.atm--;
                return atb;
            }
            C1780a qM;
            bz a = m6572a(str, c1794c.qH(), c1794c.qI(), c1794c.qJ(), c1794c.qL(), c1794c.qK(), set, bkVar.py());
            if (((Set) a.getObject()).isEmpty()) {
                qM = c1794c.qM();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m6461W(qF() + "Multiple macros active for macroName " + str);
                }
                qM = (C1780a) ((Set) a.getObject()).iterator().next();
            }
            if (qM == null) {
                this.atm--;
                return atb;
            }
            bz a2 = m6563a(this.atg, qM, (Set) set, bkVar.pN());
            boolean z = a.pX() && a2.pX();
            bz<C1070a> bzVar = a2 == atb ? atb : new bz(a2.getObject(), z);
            C1070a qm = qM.qm();
            if (bzVar.pX()) {
                this.ati.m6450e(str, new C1793b(bzVar, qm));
            }
            m6565a(qm, (Set) set);
            this.atm--;
            return bzVar;
        }
        m6565a(c1793b.qm(), (Set) set);
        this.atm--;
        return c1793b.qG();
    }

    private bz<C1070a> m6563a(Map<String, aj> map, C1780a c1780a, Set<String> set, ck ckVar) {
        boolean z = true;
        C1070a c1070a = (C1070a) c1780a.ql().get(C1022b.FUNCTION.toString());
        if (c1070a == null) {
            bh.m6458T("No function id in properties");
            return atb;
        }
        String str = c1070a.gA;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m6458T(str + " has no backing implementation.");
            return atb;
        }
        bz<C1070a> bzVar = (bz) this.ath.get(c1780a);
        if (bzVar != null && !this.atd.pH()) {
            return bzVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c1780a.ql().entrySet()) {
            bz a = m6561a((C1070a) entry.getValue(), (Set) set, ckVar.cJ((String) entry.getKey()).m6477e((C1070a) entry.getValue()));
            if (a == atb) {
                return atb;
            }
            boolean z3;
            if (a.pX()) {
                c1780a.m6531a((String) entry.getKey(), (C1070a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m6400a(hashMap.keySet())) {
            if (!(z2 && ajVar.pe())) {
                z = false;
            }
            bzVar = new bz(ajVar.m6399B(hashMap), z);
            if (z) {
                this.ath.m6450e(c1780a, bzVar);
            }
            ckVar.m6475d((C1070a) bzVar.getObject());
            return bzVar;
        }
        bh.m6458T("Incorrect keys for function " + str + " required " + ajVar.pJ() + " had " + hashMap.keySet());
        return atb;
    }

    private bz<Set<C1780a>> m6564a(Set<C1784e> set, Set<String> set2, C1790a c1790a, cs csVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C1784e c1784e : set) {
            cn pV = csVar.pV();
            bz a = m6571a(c1784e, (Set) set2, pV);
            if (((Boolean) a.getObject()).booleanValue()) {
                c1790a.m6552a(c1784e, hashSet, hashSet2, pV);
            }
            boolean z2 = z && a.pX();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        csVar.m6483b(hashSet);
        return new bz(hashSet, z);
    }

    private void m6565a(C1070a c1070a, Set<String> set) {
        if (c1070a != null) {
            bz a = m6561a(c1070a, (Set) set, new bx());
            if (a != atb) {
                Object o = di.m6612o((C1070a) a.getObject());
                if (o instanceof Map) {
                    this.aqn.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aqn.push((Map) o2);
                        } else {
                            bh.m6461W("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m6461W("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m6566a(List<C1780a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m6459U("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m6567a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.pI())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.pI());
        }
        map.put(ajVar.pI(), ajVar);
    }

    private static C1794c m6568e(Map<String, C1794c> map, String str) {
        C1794c c1794c = (C1794c) map.get(str);
        if (c1794c != null) {
            return c1794c;
        }
        c1794c = new C1794c();
        map.put(str, c1794c);
        return c1794c;
    }

    private static String m6569h(C1780a c1780a) {
        return di.m6607j((C1070a) c1780a.ql().get(C1022b.INSTANCE_NAME.toString()));
    }

    private String qF() {
        if (this.atm <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.atm));
        for (int i = 2; i < this.atm; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    bz<Boolean> m6570a(C1780a c1780a, Set<String> set, ck ckVar) {
        bz a = m6563a(this.atf, c1780a, (Set) set, ckVar);
        Boolean n = di.m6611n((C1070a) a.getObject());
        ckVar.m6475d(di.m6618u(n));
        return new bz(n, a.pX());
    }

    bz<Boolean> m6571a(C1784e c1784e, Set<String> set, cn cnVar) {
        boolean z = true;
        for (C1780a a : c1784e.qu()) {
            bz a2 = m6570a(a, (Set) set, cnVar.pP());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.m6481f(di.m6618u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
            boolean z2 = z && a2.pX();
            z = z2;
        }
        for (C1780a a3 : c1784e.qt()) {
            a2 = m6570a(a3, (Set) set, cnVar.pQ());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.pX();
            } else {
                cnVar.m6481f(di.m6618u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
        }
        cnVar.m6481f(di.m6618u(Boolean.valueOf(true)));
        return new bz(Boolean.valueOf(true), z);
    }

    bz<Set<C1780a>> m6572a(String str, Set<C1784e> set, Map<C1784e, List<C1780a>> map, Map<C1784e, List<String>> map2, Map<C1784e, List<C1780a>> map3, Map<C1784e, List<String>> map4, Set<String> set2, cs csVar) {
        return m6564a((Set) set, (Set) set2, new C17913(this, map, map2, map3, map4), csVar);
    }

    bz<Set<C1780a>> m6573a(Set<C1784e> set, cs csVar) {
        return m6564a((Set) set, new HashSet(), new C17924(this), csVar);
    }

    void m6574a(aj ajVar) {
        m6567a(this.atg, ajVar);
    }

    void m6575b(aj ajVar) {
        m6567a(this.ate, ajVar);
    }

    void m6576c(aj ajVar) {
        m6567a(this.atf, ajVar);
    }

    public bz<C1070a> cT(String str) {
        this.atm = 0;
        af cC = this.atd.cC(str);
        bz<C1070a> a = m6562a(str, new HashSet(), cC.pE());
        cC.pG();
        return a;
    }

    synchronized void cU(String str) {
        this.atl = str;
    }

    public synchronized void cr(String str) {
        cU(str);
        af cD = this.atd.cD(str);
        C1764t pF = cD.pF();
        for (C1780a a : (Set) m6573a(this.atj, pF.py()).getObject()) {
            m6563a(this.ate, a, new HashSet(), pF.px());
        }
        cD.pG();
        cU(null);
    }

    public synchronized void m6577l(List<C1046i> list) {
        for (C1046i c1046i : list) {
            if (c1046i.name == null || !c1046i.name.startsWith("gaExperiment:")) {
                bh.m6460V("Ignored supplemental: " + c1046i);
            } else {
                ai.m6412a(this.aqn, c1046i);
            }
        }
    }

    synchronized String qE() {
        return this.atl;
    }
}
