package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class da<K, V, M extends Map<K, V>> implements Serializable, ConcurrentMap<K, V> {
    private volatile M f889a;
    private final transient Lock f890b;
    private final C0307h<K, V> f891c;

    /* renamed from: com.chartboost.sdk.impl.da.a */
    protected static abstract class C0305a<E> implements Collection<E> {
        abstract Collection<E> m1300a();

        protected C0305a() {
        }

        public final boolean contains(Object obj) {
            return m1300a().contains(obj);
        }

        public final boolean containsAll(Collection<?> collection) {
            return m1300a().containsAll(collection);
        }

        public final Iterator<E> iterator() {
            return new C0311f(m1300a().iterator());
        }

        public final boolean isEmpty() {
            return m1300a().isEmpty();
        }

        public final int size() {
            return m1300a().size();
        }

        public final Object[] toArray() {
            return m1300a().toArray();
        }

        public final <T> T[] toArray(T[] tArr) {
            return m1300a().toArray(tArr);
        }

        public int hashCode() {
            return m1300a().hashCode();
        }

        public boolean equals(Object obj) {
            return m1300a().equals(obj);
        }

        public String toString() {
            return m1300a().toString();
        }

        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.b */
    private class C0306b extends C0305a<Entry<K, V>> implements Set<Entry<K, V>> {
        final /* synthetic */ da f877a;

        private C0306b(da daVar) {
            this.f877a = daVar;
        }

        Collection<Entry<K, V>> m1301a() {
            return this.f877a.f889a.entrySet();
        }

        public void clear() {
            this.f877a.f890b.lock();
            try {
                Map a = this.f877a.m1319a();
                a.entrySet().clear();
                this.f877a.m1321b(a);
            } finally {
                this.f877a.f890b.unlock();
            }
        }

        public boolean remove(Object obj) {
            Map a;
            this.f877a.f890b.lock();
            try {
                if (contains(obj)) {
                    a = this.f877a.m1319a();
                    boolean remove = a.entrySet().remove(obj);
                    this.f877a.m1321b(a);
                    this.f877a.f890b.unlock();
                    return remove;
                }
                this.f877a.f890b.unlock();
                return false;
            } catch (Throwable th) {
                this.f877a.f890b.unlock();
            }
        }

        public boolean removeAll(Collection<?> collection) {
            this.f877a.f890b.lock();
            Map a;
            try {
                a = this.f877a.m1319a();
                boolean removeAll = a.entrySet().removeAll(collection);
                this.f877a.m1321b(a);
                this.f877a.f890b.unlock();
                return removeAll;
            } catch (Throwable th) {
                this.f877a.f890b.unlock();
            }
        }

        public boolean retainAll(Collection<?> collection) {
            this.f877a.f890b.lock();
            Map a;
            try {
                a = this.f877a.m1319a();
                boolean retainAll = a.entrySet().retainAll(collection);
                this.f877a.m1321b(a);
                this.f877a.f890b.unlock();
                return retainAll;
            } catch (Throwable th) {
                this.f877a.f890b.unlock();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.h */
    public static abstract class C0307h<K, V> {

        /* renamed from: com.chartboost.sdk.impl.da.h.a */
        public enum C0313a {
            STABLE {
                final <K, V, M extends Map<K, V>> C0307h<K, V> m1314a(da<K, V, M> daVar) {
                    daVar.getClass();
                    return new C0308c(daVar);
                }
            },
            LIVE {
                final <K, V, M extends Map<K, V>> C0307h<K, V> m1315a(da<K, V, M> daVar) {
                    daVar.getClass();
                    return new C0310e(daVar);
                }
            };

            abstract <K, V, M extends Map<K, V>> C0307h<K, V> m1313a(da<K, V, M> daVar);
        }

        abstract Set<K> m1302a();

        abstract Set<Entry<K, V>> m1303b();

        abstract Collection<V> m1304c();

        C0307h() {
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.c */
    final class C0308c extends C0307h<K, V> implements Serializable {
        final /* synthetic */ da f878a;

        C0308c(da daVar) {
            this.f878a = daVar;
        }

        public final Set<K> m1305a() {
            return Collections.unmodifiableSet(this.f878a.f889a.keySet());
        }

        public final Set<Entry<K, V>> m1306b() {
            return Collections.unmodifiableSet(this.f878a.f889a.entrySet());
        }

        public final Collection<V> m1307c() {
            return Collections.unmodifiableCollection(this.f878a.f889a.values());
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.d */
    private class C0309d extends C0305a<K> implements Set<K> {
        final /* synthetic */ da f879a;

        private C0309d(da daVar) {
            this.f879a = daVar;
        }

        Collection<K> m1308a() {
            return this.f879a.f889a.keySet();
        }

        public void clear() {
            this.f879a.f890b.lock();
            try {
                Map a = this.f879a.m1319a();
                a.keySet().clear();
                this.f879a.m1321b(a);
            } finally {
                this.f879a.f890b.unlock();
            }
        }

        public boolean remove(Object obj) {
            return this.f879a.remove(obj) != null;
        }

        public boolean removeAll(Collection<?> collection) {
            Map a;
            this.f879a.f890b.lock();
            try {
                a = this.f879a.m1319a();
                boolean removeAll = a.keySet().removeAll(collection);
                this.f879a.m1321b(a);
                this.f879a.f890b.unlock();
                return removeAll;
            } catch (Throwable th) {
                this.f879a.f890b.unlock();
            }
        }

        public boolean retainAll(Collection<?> collection) {
            this.f879a.f890b.lock();
            Map a;
            try {
                a = this.f879a.m1319a();
                boolean retainAll = a.keySet().retainAll(collection);
                this.f879a.m1321b(a);
                this.f879a.f890b.unlock();
                return retainAll;
            } catch (Throwable th) {
                this.f879a.f890b.unlock();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.e */
    final class C0310e extends C0307h<K, V> implements Serializable {
        final /* synthetic */ da f880a;
        private final transient C0309d f881b;
        private final transient C0306b f882c;
        private final transient C0312g f883d;

        C0310e(da daVar) {
            this.f880a = daVar;
            this.f881b = new C0309d(null);
            this.f882c = new C0306b(null);
            this.f883d = new C0312g(null);
        }

        public final Set<K> m1309a() {
            return this.f881b;
        }

        public final Set<Entry<K, V>> m1310b() {
            return this.f882c;
        }

        public final Collection<V> m1311c() {
            return this.f883d;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.f */
    private static class C0311f<T> implements Iterator<T> {
        private final Iterator<T> f884a;

        public C0311f(Iterator<T> it) {
            this.f884a = it;
        }

        public boolean hasNext() {
            return this.f884a.hasNext();
        }

        public T next() {
            return this.f884a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.da.g */
    private final class C0312g extends C0305a<V> {
        final /* synthetic */ da f885a;

        private C0312g(da daVar) {
            this.f885a = daVar;
        }

        final Collection<V> m1312a() {
            return this.f885a.f889a.values();
        }

        public final void clear() {
            this.f885a.f890b.lock();
            try {
                Map a = this.f885a.m1319a();
                a.values().clear();
                this.f885a.m1321b(a);
            } finally {
                this.f885a.f890b.unlock();
            }
        }

        public final boolean remove(Object obj) {
            this.f885a.f890b.lock();
            Map a;
            try {
                if (contains(obj)) {
                    a = this.f885a.m1319a();
                    boolean remove = a.values().remove(obj);
                    this.f885a.m1321b(a);
                    this.f885a.f890b.unlock();
                    return remove;
                }
                this.f885a.f890b.unlock();
                return false;
            } catch (Throwable th) {
                this.f885a.f890b.unlock();
            }
        }

        public final boolean removeAll(Collection<?> collection) {
            this.f885a.f890b.lock();
            Map a;
            try {
                a = this.f885a.m1319a();
                boolean removeAll = a.values().removeAll(collection);
                this.f885a.m1321b(a);
                this.f885a.f890b.unlock();
                return removeAll;
            } catch (Throwable th) {
                this.f885a.f890b.unlock();
            }
        }

        public final boolean retainAll(Collection<?> collection) {
            this.f885a.f890b.lock();
            Map a;
            try {
                a = this.f885a.m1319a();
                boolean retainAll = a.values().retainAll(collection);
                this.f885a.m1321b(a);
                this.f885a.f890b.unlock();
                return retainAll;
            } catch (Throwable th) {
                this.f885a.f890b.unlock();
            }
        }
    }

    abstract <N extends Map<? extends K, ? extends V>> M m1320a(N n);

    protected <N extends Map<? extends K, ? extends V>> da(N n, C0313a c0313a) {
        this.f890b = new ReentrantLock();
        this.f889a = (Map) db.m1322a("delegate", m1320a((Map) db.m1322a("map", n)));
        this.f891c = ((C0313a) db.m1322a("viewType", c0313a)).m1313a(this);
    }

    public final void clear() {
        this.f890b.lock();
        try {
            m1321b(m1320a(Collections.emptyMap()));
        } finally {
            this.f890b.unlock();
        }
    }

    public final V remove(Object obj) {
        Map a;
        this.f890b.lock();
        try {
            if (this.f889a.containsKey(obj)) {
                a = m1319a();
                V remove = a.remove(obj);
                m1321b(a);
                this.f890b.unlock();
                return remove;
            }
            this.f890b.unlock();
            return null;
        } catch (Throwable th) {
            this.f890b.unlock();
        }
    }

    public boolean remove(Object obj, Object obj2) {
        this.f890b.lock();
        try {
            if (this.f889a.containsKey(obj) && m1317a(obj2, this.f889a.get(obj))) {
                Map a = m1319a();
                a.remove(obj);
                m1321b(a);
                return true;
            }
            this.f890b.unlock();
            return false;
        } finally {
            this.f890b.unlock();
        }
    }

    public boolean replace(K k, V v, V v2) {
        this.f890b.lock();
        try {
            if (this.f889a.containsKey(k) && m1317a(v, this.f889a.get(k))) {
                Map a = m1319a();
                a.put(k, v2);
                m1321b(a);
                this.f890b.unlock();
                return true;
            }
            this.f890b.unlock();
            return false;
        } catch (Throwable th) {
            this.f890b.unlock();
        }
    }

    public V replace(K k, V v) {
        this.f890b.lock();
        Map a;
        try {
            if (this.f889a.containsKey(k)) {
                a = m1319a();
                V put = a.put(k, v);
                m1321b(a);
                this.f890b.unlock();
                return put;
            }
            this.f890b.unlock();
            return null;
        } catch (Throwable th) {
            this.f890b.unlock();
        }
    }

    public final V put(K k, V v) {
        Map a;
        this.f890b.lock();
        try {
            a = m1319a();
            V put = a.put(k, v);
            m1321b(a);
            this.f890b.unlock();
            return put;
        } catch (Throwable th) {
            this.f890b.unlock();
        }
    }

    public V putIfAbsent(K k, V v) {
        this.f890b.lock();
        Map a;
        try {
            V v2;
            if (this.f889a.containsKey(k)) {
                v2 = this.f889a.get(k);
                this.f890b.unlock();
            } else {
                a = m1319a();
                v2 = a.put(k, v);
                m1321b(a);
                this.f890b.unlock();
            }
            return v2;
        } catch (Throwable th) {
            this.f890b.unlock();
        }
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        this.f890b.lock();
        try {
            Map a = m1319a();
            a.putAll(map);
            m1321b(a);
        } finally {
            this.f890b.unlock();
        }
    }

    protected M m1319a() {
        this.f890b.lock();
        try {
            M a = m1320a(this.f889a);
            return a;
        } finally {
            this.f890b.unlock();
        }
    }

    protected void m1321b(M m) {
        this.f889a = m;
    }

    public final Set<Entry<K, V>> entrySet() {
        return this.f891c.m1303b();
    }

    public final Set<K> keySet() {
        return this.f891c.m1302a();
    }

    public final Collection<V> values() {
        return this.f891c.m1304c();
    }

    public final boolean containsKey(Object obj) {
        return this.f889a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.f889a.containsValue(obj);
    }

    public final V get(Object obj) {
        return this.f889a.get(obj);
    }

    public final boolean isEmpty() {
        return this.f889a.isEmpty();
    }

    public final int size() {
        return this.f889a.size();
    }

    public final boolean equals(Object obj) {
        return this.f889a.equals(obj);
    }

    public final int hashCode() {
        return this.f889a.hashCode();
    }

    public String toString() {
        return this.f889a.toString();
    }

    private boolean m1317a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }
}
