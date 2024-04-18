package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class dc {
    private static final ConcurrentMap<Class<?>, List<Class<?>>> f892a;

    public static <T> List<Class<?>> m1323a(Class<T> cls) {
        ConcurrentMap a = m1324a();
        while (true) {
            List<Class<?>> list = (List) a.get(cls);
            if (list != null) {
                return list;
            }
            a.putIfAbsent(cls, m1326b(cls));
        }
    }

    private static List<Class<?>> m1326b(Class<?> cls) {
        Collection arrayList = new ArrayList();
        arrayList.add(Object.class);
        m1325a(cls, arrayList);
        Collections.reverse(arrayList);
        return Collections.unmodifiableList(new ArrayList(arrayList));
    }

    private static <T> void m1325a(Class<T> cls, List<Class<?>> list) {
        if (cls != null && cls != Object.class) {
            Class[] interfaces = cls.getInterfaces();
            for (int length = interfaces.length - 1; length >= 0; length--) {
                m1325a(interfaces[length], list);
            }
            m1325a(cls.getSuperclass(), list);
            if (!list.contains(cls)) {
                list.add(cls);
            }
        }
    }

    private static ConcurrentMap<Class<?>, List<Class<?>>> m1324a() {
        return f892a;
    }

    static {
        f892a = df.m1339c();
    }
}
