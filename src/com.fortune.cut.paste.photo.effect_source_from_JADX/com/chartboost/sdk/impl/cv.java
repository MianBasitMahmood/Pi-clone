package com.chartboost.sdk.impl;

public class cv extends cu {
    final cj f864b;

    public cj m1280b() {
        return this.f864b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cv)) {
            return false;
        }
        cv cvVar = (cv) obj;
        if (this.a.equals(cvVar.a) && this.f864b.equals(cvVar.f864b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.f864b.hashCode();
    }
}
