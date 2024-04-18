package com.google.android.gms.fitness.data;

import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.t */
public class C0789t {
    public static <T> int m2675a(T t, List<T> list) {
        if (t == null) {
            return -1;
        }
        int indexOf = list.indexOf(t);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(t);
        return list.size() - 1;
    }
}
