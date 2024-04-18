package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID;
    private static final String arJ;
    private static final String arK;
    private static final String arL;
    private static final String arp;

    /* renamed from: com.google.android.gms.tagmanager.az.1 */
    static /* synthetic */ class C17581 {
        static final /* synthetic */ int[] arM;

        static {
            arM = new int[C1759a.values().length];
            try {
                arM[C1759a.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                arM[C1759a.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                arM[C1759a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.az.a */
    private enum C1759a {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = C0997a.JOINER.toString();
        arp = C1022b.ARG0.toString();
        arJ = C1022b.ITEM_SEPARATOR.toString();
        arK = C1022b.KEY_VALUE_SEPARATOR.toString();
        arL = C1022b.ESCAPE.toString();
    }

    public az() {
        super(ID, arp);
    }

    private String m6443a(String str, C1759a c1759a, Set<Character> set) {
        switch (C17581.arM[c1759a.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                try {
                    return dm.dg(str);
                } catch (Throwable e) {
                    bh.m6462b("Joiner: unsupported encoding", e);
                    return str;
                }
            case DataEvent.TYPE_DELETED /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m6444a(StringBuilder stringBuilder, String str, C1759a c1759a, Set<Character> set) {
        stringBuilder.append(m6443a(str, c1759a, set));
    }

    private void m6445a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public C1070a m6446B(Map<String, C1070a> map) {
        C1070a c1070a = (C1070a) map.get(arp);
        if (c1070a == null) {
            return di.rb();
        }
        C1759a c1759a;
        Set set;
        C1070a c1070a2 = (C1070a) map.get(arJ);
        String j = c1070a2 != null ? di.m6607j(c1070a2) : "";
        c1070a2 = (C1070a) map.get(arK);
        String j2 = c1070a2 != null ? di.m6607j(c1070a2) : "=";
        C1759a c1759a2 = C1759a.NONE;
        c1070a2 = (C1070a) map.get(arL);
        if (c1070a2 != null) {
            String j3 = di.m6607j(c1070a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c1759a = C1759a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c1759a = C1759a.BACKSLASH;
                set = new HashSet();
                m6445a(set, j);
                m6445a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m6458T("Joiner: unsupported escape type: " + j3);
                return di.rb();
            }
        }
        set = null;
        c1759a = c1759a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c1070a.type) {
            case DataEvent.TYPE_DELETED /*2*/:
                Object obj = 1;
                C1070a[] c1070aArr = c1070a.gw;
                int length = c1070aArr.length;
                int i = 0;
                while (i < length) {
                    C1070a c1070a3 = c1070aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m6444a(stringBuilder, di.m6607j(c1070a3), c1759a, set);
                    i++;
                    obj = null;
                }
                break;
            case WalletFragmentState.PROCESSING /*3*/:
                for (int i2 = 0; i2 < c1070a.gx.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = di.m6607j(c1070a.gx[i2]);
                    String j5 = di.m6607j(c1070a.gy[i2]);
                    m6444a(stringBuilder, j4, c1759a, set);
                    stringBuilder.append(j2);
                    m6444a(stringBuilder, j5, c1759a, set);
                }
                break;
            default:
                m6444a(stringBuilder, di.m6607j(c1070a), c1759a, set);
                break;
        }
        return di.m6618u(stringBuilder.toString());
    }

    public boolean pe() {
        return true;
    }
}
