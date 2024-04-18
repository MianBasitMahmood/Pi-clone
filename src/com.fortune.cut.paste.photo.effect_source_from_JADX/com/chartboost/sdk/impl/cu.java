package com.chartboost.sdk.impl;

import java.io.Serializable;

public class cu implements Serializable {
    final String f863a;

    public String m1279a() {
        return this.f863a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cu)) {
            return false;
        }
        return this.f863a.equals(((cu) obj).f863a);
    }

    public int hashCode() {
        return this.f863a.hashCode();
    }

    public String toString() {
        return m1279a();
    }
}
