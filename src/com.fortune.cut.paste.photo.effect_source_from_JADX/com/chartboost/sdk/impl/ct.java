package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Arrays;

public class ct implements Serializable {
    final byte f861a;
    final byte[] f862b;

    public byte m1277a() {
        return this.f861a;
    }

    public byte[] m1278b() {
        return this.f862b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ct)) {
            return false;
        }
        ct ctVar = (ct) obj;
        if (this.f861a != ctVar.f861a) {
            return false;
        }
        if (Arrays.equals(this.f862b, ctVar.f862b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f862b != null ? Arrays.hashCode(this.f862b) : 0) + (this.f861a * 31);
    }
}
