package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Date;

public class cs implements Serializable, Comparable<cs> {
    static final boolean f858a;
    final int f859b;
    final Date f860c;

    public /* synthetic */ int compareTo(Object obj) {
        return m1275a((cs) obj);
    }

    static {
        f858a = Boolean.getBoolean("DEBUG.DBTIMESTAMP");
    }

    public cs() {
        this.f859b = 0;
        this.f860c = null;
    }

    public int m1274a() {
        if (this.f860c == null) {
            return 0;
        }
        return (int) (this.f860c.getTime() / 1000);
    }

    public int m1276b() {
        return this.f859b;
    }

    public String toString() {
        return "TS time:" + this.f860c + " inc:" + this.f859b;
    }

    public int m1275a(cs csVar) {
        if (m1274a() != csVar.m1274a()) {
            return m1274a() - csVar.m1274a();
        }
        return m1276b() - csVar.m1276b();
    }

    public int hashCode() {
        return ((this.f859b + 31) * 31) + m1274a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        if (m1274a() == csVar.m1274a() && m1276b() == csVar.m1276b()) {
            return true;
        }
        return false;
    }
}
