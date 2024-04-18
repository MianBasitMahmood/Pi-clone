package com.chartboost.sdk.impl;

import java.io.Serializable;

public class cw implements Serializable {
    public boolean equals(Object obj) {
        return obj instanceof cw;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "MaxKey";
    }
}
