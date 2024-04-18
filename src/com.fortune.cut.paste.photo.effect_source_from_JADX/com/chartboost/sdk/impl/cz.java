package com.chartboost.sdk.impl;

import java.io.Serializable;

public class cz implements Serializable {
    private final String f872a;

    public String m1292a() {
        return this.f872a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof cz) {
            obj = ((cz) obj).f872a;
        } else if (!(obj instanceof String)) {
            return false;
        } else {
            String str = (String) obj;
        }
        if (this.f872a != null) {
            if (this.f872a.equals(obj)) {
                return true;
            }
        } else if (obj == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f872a != null ? this.f872a.hashCode() : 0;
    }

    public String toString() {
        return this.f872a;
    }
}
