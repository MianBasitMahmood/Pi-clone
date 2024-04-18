package com.chartboost.sdk.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class de<K, V> implements dg<K, V>, Map<K, V> {
    private final ConcurrentMap<K, V> f896a;
    private final dg<K, V> f897b;

    public static <K, V> Map<K, V> m1335a(dg<K, V> dgVar) {
        return new de(df.m1339c(), dgVar);
    }

    de(ConcurrentMap<K, V> concurrentMap, dg<K, V> dgVar) {
        this.f896a = (ConcurrentMap) db.m1322a("map", concurrentMap);
        this.f897b = (dg) db.m1322a("function", dgVar);
    }

    public final V get(Object obj) {
        while (true) {
            V v = this.f896a.get(obj);
            if (v != null) {
                return v;
            }
            Object a = this.f897b.m1327a(obj);
            if (a == null) {
                return null;
            }
            this.f896a.putIfAbsent(obj, a);
        }
    }

    public final V m1336a(K k) {
        return get(k);
    }

    public final int size() {
        return this.f896a.size();
    }

    public final boolean isEmpty() {
        return this.f896a.isEmpty();
    }

    public final boolean containsKey(Object obj) {
        return this.f896a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.f896a.containsValue(obj);
    }

    public final V put(K k, V v) {
        return this.f896a.put(k, v);
    }

    public final V remove(Object obj) {
        return this.f896a.remove(obj);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        this.f896a.putAll(map);
    }

    public final void clear() {
        this.f896a.clear();
    }

    public final Set<K> keySet() {
        return this.f896a.keySet();
    }

    public final Collection<V> values() {
        return this.f896a.values();
    }

    public final Set<Entry<K, V>> entrySet() {
        return this.f896a.entrySet();
    }

    public final boolean equals(Object obj) {
        return this.f896a.equals(obj);
    }

    public final int hashCode() {
        return this.f896a.hashCode();
    }
}
