package com.google.android.gms.internal;

import com.google.android.gms.internal.qm.C1474a;
import com.google.android.gms.internal.qm.C1474a.C1473a;
import com.google.android.gms.internal.qm.C1474a.C1473a.C1472a;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ql {

    /* renamed from: com.google.android.gms.internal.ql.a */
    public static class C1471a {
        public final qm ayo;
        public final List<Asset> ayp;

        public C1471a(qm qmVar, List<Asset> list) {
            this.ayo = qmVar;
            this.ayp = list;
        }
    }

    private static int m5904a(String str, C1473a[] c1473aArr) {
        int i = 14;
        for (C1473a c1473a : c1473aArr) {
            if (i == 14) {
                if (c1473a.type == 9 || c1473a.type == 2 || c1473a.type == 6) {
                    i = c1473a.type;
                } else if (c1473a.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + c1473a.type + " for key " + str);
                }
            } else if (c1473a.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c1473a.type);
            }
        }
        return i;
    }

    static int m5905a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static C1471a m5906a(DataMap dataMap) {
        qm qmVar = new qm();
        List arrayList = new ArrayList();
        qmVar.ayq = m5911a(dataMap, arrayList);
        return new C1471a(qmVar, arrayList);
    }

    private static C1473a m5907a(List<Asset> list, Object obj) {
        C1473a c1473a = new C1473a();
        if (obj == null) {
            c1473a.type = 14;
            return c1473a;
        }
        c1473a.ayu = new C1472a();
        if (obj instanceof String) {
            c1473a.type = 2;
            c1473a.ayu.ayw = (String) obj;
        } else if (obj instanceof Integer) {
            c1473a.type = 6;
            c1473a.ayu.ayA = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c1473a.type = 5;
            c1473a.ayu.ayz = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c1473a.type = 3;
            c1473a.ayu.ayx = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c1473a.type = 4;
            c1473a.ayu.ayy = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c1473a.type = 8;
            c1473a.ayu.ayC = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c1473a.type = 7;
            c1473a.ayu.ayB = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c1473a.type = 1;
            c1473a.ayu.ayv = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c1473a.type = 11;
            c1473a.ayu.ayF = (String[]) obj;
        } else if (obj instanceof long[]) {
            c1473a.type = 12;
            c1473a.ayu.ayG = (long[]) obj;
        } else if (obj instanceof float[]) {
            c1473a.type = 15;
            c1473a.ayu.ayH = (float[]) obj;
        } else if (obj instanceof Asset) {
            c1473a.type = 13;
            c1473a.ayu.ayI = (long) m5905a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c1473a.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            C1474a[] c1474aArr = new C1474a[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                c1474aArr[r1] = new C1474a();
                c1474aArr[r1].name = str;
                c1474aArr[r1].ays = m5907a((List) list, dataMap.get(str));
                r1++;
            }
            c1473a.ayu.ayD = c1474aArr;
        } else if (obj instanceof ArrayList) {
            c1473a.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1473a[] c1473aArr = new C1473a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                C1473a a = m5907a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    c1473aArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            c1473a.ayu.ayE = c1473aArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return c1473a;
    }

    public static DataMap m5908a(C1471a c1471a) {
        DataMap dataMap = new DataMap();
        for (C1474a c1474a : c1471a.ayo.ayq) {
            m5910a(c1471a.ayp, dataMap, c1474a.name, c1474a.ays);
        }
        return dataMap;
    }

    private static ArrayList m5909a(List<Asset> list, C1472a c1472a, int i) {
        ArrayList arrayList = new ArrayList(c1472a.ayE.length);
        for (C1473a c1473a : c1472a.ayE) {
            if (c1473a.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (C1474a c1474a : c1473a.ayu.ayD) {
                    m5910a(list, dataMap, c1474a.name, c1474a.ays);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c1473a.ayu.ayw);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(c1473a.ayu.ayA));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void m5910a(List<Asset> list, DataMap dataMap, String str, C1473a c1473a) {
        int i = c1473a.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        C1472a c1472a = c1473a.ayu;
        if (i == 1) {
            dataMap.putByteArray(str, c1472a.ayv);
        } else if (i == 11) {
            dataMap.putStringArray(str, c1472a.ayF);
        } else if (i == 12) {
            dataMap.putLongArray(str, c1472a.ayG);
        } else if (i == 15) {
            dataMap.putFloatArray(str, c1472a.ayH);
        } else if (i == 2) {
            dataMap.putString(str, c1472a.ayw);
        } else if (i == 3) {
            dataMap.putDouble(str, c1472a.ayx);
        } else if (i == 4) {
            dataMap.putFloat(str, c1472a.ayy);
        } else if (i == 5) {
            dataMap.putLong(str, c1472a.ayz);
        } else if (i == 6) {
            dataMap.putInt(str, c1472a.ayA);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) c1472a.ayB);
        } else if (i == 8) {
            dataMap.putBoolean(str, c1472a.ayC);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) c1472a.ayI));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (C1474a c1474a : c1472a.ayD) {
                m5910a(list, dataMap2, c1474a.name, c1474a.ays);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = m5904a(str, c1472a.ayE);
            ArrayList a = m5909a(list, c1472a, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static C1474a[] m5911a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        C1474a[] c1474aArr = new C1474a[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            c1474aArr[i] = new C1474a();
            c1474aArr[i].name = str;
            c1474aArr[i].ays = m5907a((List) list, obj);
            i++;
        }
        return c1474aArr;
    }
}
