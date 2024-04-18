package com.chartboost.sdk.impl;

public class bv {
    final Object f791a;
    final String f792b;

    public String toString() {
        return "{ \"$ref\" : \"" + this.f792b + "\", \"$id\" : \"" + this.f791a + "\" }";
    }

    public Object m1155a() {
        return this.f791a;
    }

    public String m1156b() {
        return this.f792b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bv bvVar = (bv) obj;
        if (this.f791a == null ? bvVar.f791a != null : !this.f791a.equals(bvVar.f791a)) {
            return false;
        }
        if (this.f792b != null) {
            if (this.f792b.equals(bvVar.f792b)) {
                return true;
            }
        } else if (bvVar.f792b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f791a != null) {
            hashCode = this.f791a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f792b != null) {
            i = this.f792b.hashCode();
        }
        return hashCode + i;
    }
}
