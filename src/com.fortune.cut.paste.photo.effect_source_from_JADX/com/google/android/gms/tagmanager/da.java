package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.C1810l.C1787a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class da<K, V> implements C1762k<K, V> {
    private final Map<K, V> atM;
    private final int atN;
    private final C1787a<K, V> atO;
    private int atP;

    da(int i, C1787a<K, V> c1787a) {
        this.atM = new HashMap();
        this.atN = i;
        this.atO = c1787a;
    }

    public synchronized void m6593e(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.atP += this.atO.sizeOf(k, v);
        if (this.atP > this.atN) {
            Iterator it = this.atM.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.atP -= this.atO.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.atP <= this.atN) {
                    break;
                }
            }
        }
        this.atM.put(k, v);
    }

    public synchronized V get(K k) {
        return this.atM.get(k);
    }
}
