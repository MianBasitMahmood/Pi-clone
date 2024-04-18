package com.chartboost.sdk.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class cm extends LinkedHashMap<String, Object> implements cj {
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m1150a((String) obj, obj2);
    }

    public cm(String str, Object obj) {
        m1150a(str, obj);
    }

    public boolean m1151b(String str) {
        return super.containsKey(str);
    }

    public Object m1149a(String str) {
        return super.get(str);
    }

    public Object m1150a(String str, Object obj) {
        return super.put(str, obj);
    }

    public void putAll(Map map) {
        for (Entry entry : map.entrySet()) {
            m1150a(entry.getKey().toString(), entry.getValue());
        }
    }

    public String toString() {
        return by.m1160a(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cj)) {
            return false;
        }
        cj cjVar = (cj) obj;
        if (!keySet().equals(cjVar.keySet())) {
            return false;
        }
        for (String str : keySet()) {
            Object a = m1149a(str);
            Object a2 = cjVar.m1146a(str);
            if (a == null && a2 != null) {
                return false;
            }
            if (a2 == null) {
                if (a != null) {
                    return false;
                }
            } else if ((a instanceof Number) && (a2 instanceof Number)) {
                if (((Number) a).doubleValue() != ((Number) a2).doubleValue()) {
                    return false;
                }
            } else if ((a instanceof Pattern) && (a2 instanceof Pattern)) {
                Pattern pattern = (Pattern) a;
                Pattern pattern2 = (Pattern) a2;
                if (!pattern.pattern().equals(pattern2.pattern()) || pattern.flags() != pattern2.flags()) {
                    return false;
                }
            } else if (!a.equals(a2)) {
                return false;
            }
        }
        return true;
    }
}
