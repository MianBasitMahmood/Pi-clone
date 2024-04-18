package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di {
    private static final Object auc;
    private static Long aud;
    private static Double aue;
    private static dh auf;
    private static String aug;
    private static Boolean auh;
    private static List<Object> aui;
    private static Map<Object, Object> auj;
    private static C1070a auk;

    static {
        auc = null;
        aud = new Long(0);
        aue = new Double(0.0d);
        auf = dh.m6605z(0);
        aug = new String("");
        auh = new Boolean(false);
        aui = new ArrayList(0);
        auj = new HashMap();
        auk = m6618u(aug);
    }

    public static C1070a cZ(String str) {
        C1070a c1070a = new C1070a();
        c1070a.type = 5;
        c1070a.gA = str;
        return c1070a;
    }

    private static dh da(String str) {
        try {
            return dh.cY(str);
        } catch (NumberFormatException e) {
            bh.m6458T("Failed to convert '" + str + "' to a number.");
            return auf;
        }
    }

    private static Long db(String str) {
        dh da = da(str);
        return da == auf ? aud : Long.valueOf(da.longValue());
    }

    private static Double dc(String str) {
        dh da = da(str);
        return da == auf ? aue : Double.valueOf(da.doubleValue());
    }

    private static Boolean dd(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : auh;
    }

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        bh.m6458T("getDouble received non-Number");
        return 0.0d;
    }

    public static String m6607j(C1070a c1070a) {
        return m6613p(m6612o(c1070a));
    }

    public static dh m6608k(C1070a c1070a) {
        return m6614q(m6612o(c1070a));
    }

    public static Long m6609l(C1070a c1070a) {
        return m6615r(m6612o(c1070a));
    }

    public static Double m6610m(C1070a c1070a) {
        return m6616s(m6612o(c1070a));
    }

    public static Boolean m6611n(C1070a c1070a) {
        return m6617t(m6612o(c1070a));
    }

    public static Object m6612o(C1070a c1070a) {
        int i = 0;
        if (c1070a == null) {
            return auc;
        }
        C1070a[] c1070aArr;
        int length;
        switch (c1070a.type) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return c1070a.gv;
            case DataEvent.TYPE_DELETED /*2*/:
                ArrayList arrayList = new ArrayList(c1070a.gw.length);
                c1070aArr = c1070a.gw;
                length = c1070aArr.length;
                while (i < length) {
                    Object o = m6612o(c1070aArr[i]);
                    if (o == auc) {
                        return auc;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case WalletFragmentState.PROCESSING /*3*/:
                if (c1070a.gx.length != c1070a.gy.length) {
                    bh.m6458T("Converting an invalid value to object: " + c1070a.toString());
                    return auc;
                }
                Map hashMap = new HashMap(c1070a.gy.length);
                while (i < c1070a.gx.length) {
                    Object o2 = m6612o(c1070a.gx[i]);
                    Object o3 = m6612o(c1070a.gy[i]);
                    if (o2 == auc || o3 == auc) {
                        return auc;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                bh.m6458T("Trying to convert a macro reference to object");
                return auc;
            case Dimension.UNIT_MM /*5*/:
                bh.m6458T("Trying to convert a function id to object");
                return auc;
            case Error.OTHER /*6*/:
                return Long.valueOf(c1070a.gB);
            case Error.AVS_DECLINE /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c1070aArr = c1070a.gD;
                length = c1070aArr.length;
                while (i < length) {
                    String j = m6607j(c1070aArr[i]);
                    if (j == aug) {
                        return auc;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case Error.FRAUD_DECLINE /*8*/:
                return Boolean.valueOf(c1070a.gC);
            default:
                bh.m6458T("Failed to convert a value of type: " + c1070a.type);
                return auc;
        }
    }

    public static String m6613p(Object obj) {
        return obj == null ? aug : obj.toString();
    }

    public static dh m6614q(Object obj) {
        return obj instanceof dh ? (dh) obj : m6620w(obj) ? dh.m6605z(m6621x(obj)) : m6619v(obj) ? dh.m6604a(Double.valueOf(getDouble(obj))) : da(m6613p(obj));
    }

    public static Object qV() {
        return auc;
    }

    public static Long qW() {
        return aud;
    }

    public static Double qX() {
        return aue;
    }

    public static Boolean qY() {
        return auh;
    }

    public static dh qZ() {
        return auf;
    }

    public static Long m6615r(Object obj) {
        return m6620w(obj) ? Long.valueOf(m6621x(obj)) : db(m6613p(obj));
    }

    public static String ra() {
        return aug;
    }

    public static C1070a rb() {
        return auk;
    }

    public static Double m6616s(Object obj) {
        return m6619v(obj) ? Double.valueOf(getDouble(obj)) : dc(m6613p(obj));
    }

    public static Boolean m6617t(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : dd(m6613p(obj));
    }

    public static C1070a m6618u(Object obj) {
        boolean z = false;
        C1070a c1070a = new C1070a();
        if (obj instanceof C1070a) {
            return (C1070a) obj;
        }
        if (obj instanceof String) {
            c1070a.type = 1;
            c1070a.gv = (String) obj;
        } else if (obj instanceof List) {
            c1070a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object u : list) {
                C1070a u2 = m6618u(u);
                if (u2 == auk) {
                    return auk;
                }
                r0 = r1 || u2.gF;
                r5.add(u2);
                r1 = r0;
            }
            c1070a.gw = (C1070a[]) r5.toArray(new C1070a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c1070a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C1070a u3 = m6618u(entry.getKey());
                C1070a u4 = m6618u(entry.getValue());
                if (u3 == auk || u4 == auk) {
                    return auk;
                }
                r0 = r1 || u3.gF || u4.gF;
                r5.add(u3);
                arrayList.add(u4);
                r1 = r0;
            }
            c1070a.gx = (C1070a[]) r5.toArray(new C1070a[0]);
            c1070a.gy = (C1070a[]) arrayList.toArray(new C1070a[0]);
            z = r1;
        } else if (m6619v(obj)) {
            c1070a.type = 1;
            c1070a.gv = obj.toString();
        } else if (m6620w(obj)) {
            c1070a.type = 6;
            c1070a.gB = m6621x(obj);
        } else if (obj instanceof Boolean) {
            c1070a.type = 8;
            c1070a.gC = ((Boolean) obj).booleanValue();
        } else {
            bh.m6458T("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return auk;
        }
        c1070a.gF = z;
        return c1070a;
    }

    private static boolean m6619v(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dh) && ((dh) obj).qQ());
    }

    private static boolean m6620w(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dh) && ((dh) obj).qR());
    }

    private static long m6621x(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m6458T("getInt64 received non-Number");
        return 0;
    }
}
