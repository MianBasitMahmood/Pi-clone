package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.io.Writer;

public class cf extends Writer implements Serializable {
    private final StringBuilder f823a;

    public cf() {
        this.f823a = new StringBuilder();
    }

    public cf(int i) {
        this.f823a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.f823a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f823a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f823a.append(charSequence, i, i2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(String str) {
        if (str != null) {
            this.f823a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f823a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f823a.toString();
    }
}
