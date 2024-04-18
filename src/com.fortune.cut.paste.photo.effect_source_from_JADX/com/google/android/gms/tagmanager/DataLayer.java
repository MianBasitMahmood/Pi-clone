package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT;
    static final String[] aqQ;
    private static final Pattern aqR;
    private final ConcurrentHashMap<C1746b, Integer> aqS;
    private final Map<String, Object> aqT;
    private final ReentrantLock aqU;
    private final LinkedList<Map<String, Object>> aqV;
    private final C1741c aqW;
    private final CountDownLatch aqX;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.c */
    interface C1741c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer.c.a */
        public interface C1743a {
            void m6370h(List<C1745a> list);
        }

        void m6366a(C1743a c1743a);

        void m6367a(List<C1745a> list, long j);

        void cz(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.1 */
    class C17421 implements C1741c {
        C17421() {
        }

        public void m6368a(C1743a c1743a) {
            c1743a.m6370h(new ArrayList());
        }

        public void m6369a(List<C1745a> list, long j) {
        }

        public void cz(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.2 */
    class C17442 implements C1743a {
        final /* synthetic */ DataLayer aqY;

        C17442(DataLayer dataLayer) {
            this.aqY = dataLayer;
        }

        public void m6371h(List<C1745a> list) {
            for (C1745a c1745a : list) {
                this.aqY.m6373E(this.aqY.m6386c(c1745a.KP, c1745a.wF));
            }
            this.aqY.aqX.countDown();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.a */
    static final class C1745a {
        public final String KP;
        public final Object wF;

        C1745a(String str, Object obj) {
            this.KP = str;
            this.wF = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1745a)) {
                return false;
            }
            C1745a c1745a = (C1745a) obj;
            return this.KP.equals(c1745a.KP) && this.wF.equals(c1745a.wF);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.KP.hashCode()), Integer.valueOf(this.wF.hashCode())});
        }

        public final String toString() {
            return "Key: " + this.KP + " value: " + this.wF.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.b */
    interface C1746b {
        void m6372C(Map<String, Object> map);
    }

    static {
        OBJECT_NOT_PRESENT = new Object();
        aqQ = "gtm.lifetime".toString().split("\\.");
        aqR = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    DataLayer() {
        this(new C17421());
    }

    DataLayer(C1741c c1741c) {
        this.aqW = c1741c;
        this.aqS = new ConcurrentHashMap();
        this.aqT = new HashMap();
        this.aqU = new ReentrantLock();
        this.aqV = new LinkedList();
        this.aqX = new CountDownLatch(1);
        pv();
    }

    private void m6373E(Map<String, Object> map) {
        this.aqU.lock();
        try {
            this.aqV.offer(map);
            if (this.aqU.getHoldCount() == 1) {
                pw();
            }
            m6374F(map);
        } finally {
            this.aqU.unlock();
        }
    }

    private void m6374F(Map<String, Object> map) {
        Long G = m6375G(map);
        if (G != null) {
            List I = m6377I(map);
            I.remove("gtm.lifetime");
            this.aqW.m6367a(I, G.longValue());
        }
    }

    private Long m6375G(Map<String, Object> map) {
        Object H = m6376H(map);
        return H == null ? null : cy(H.toString());
    }

    private Object m6376H(Map<String, Object> map) {
        String[] strArr = aqQ;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<C1745a> m6377I(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m6382a(map, "", arrayList);
        return arrayList;
    }

    private void m6378J(Map<String, Object> map) {
        synchronized (this.aqT) {
            for (String str : map.keySet()) {
                m6384a(m6386c(str, map.get(str)), this.aqT);
            }
        }
        m6379K(map);
    }

    private void m6379K(Map<String, Object> map) {
        for (C1746b C : this.aqS.keySet()) {
            C.m6372C(map);
        }
    }

    private void m6382a(Map<String, Object> map, String str, Collection<C1745a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m6382a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C1745a(str2, entry.getValue()));
            }
        }
    }

    static Long cy(String str) {
        Matcher matcher = aqR.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m6461W("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m6459U("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m6461W("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m6459U("unknown _lifetime: " + str);
        return null;
    }

    public static List<Object> listOf(Object... objArr) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] instanceof String) {
                hashMap.put((String) objArr[i], objArr[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objArr[i]);
            }
        }
        return hashMap;
    }

    private void pv() {
        this.aqW.m6366a(new C17442(this));
    }

    private void pw() {
        int i = 0;
        while (true) {
            Map map = (Map) this.aqV.poll();
            if (map != null) {
                m6378J(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.aqV.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    void m6383a(C1746b c1746b) {
        this.aqS.put(c1746b, Integer.valueOf(0));
    }

    void m6384a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m6385b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m6384a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void m6385b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m6385b((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m6384a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    Map<String, Object> m6386c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void cx(String str) {
        push(str, null);
        this.aqW.cz(str);
    }

    public Object get(String str) {
        synchronized (this.aqT) {
            Map map = this.aqT;
            String[] split = str.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(m6386c(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.aqX.await();
        } catch (InterruptedException e) {
            bh.m6461W("DataLayer.push: unexpected InterruptedException");
        }
        m6373E(map);
    }

    public void pushEvent(String str, Map<String, Object> map) {
        Map hashMap = new HashMap(map);
        hashMap.put(EVENT_KEY, str);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.aqT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.aqT.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
