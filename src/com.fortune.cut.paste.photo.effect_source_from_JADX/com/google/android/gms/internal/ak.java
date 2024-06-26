package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@ey
public class ak {
    private final Object mH;
    private final int np;
    private final int nq;
    private final int nr;
    private final ap ns;
    private ArrayList<String> nt;
    private int nu;
    private int nv;
    private int nw;
    private int nx;
    private String ny;

    public ak(int i, int i2, int i3, int i4) {
        this.mH = new Object();
        this.nt = new ArrayList();
        this.nu = 0;
        this.nv = 0;
        this.nw = 0;
        this.ny = "";
        this.np = i;
        this.nq = i2;
        this.nr = i3;
        this.ns = new ap(i4);
    }

    private String m4156a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m4157j(String str) {
        if (str != null && str.length() >= this.nr) {
            synchronized (this.mH) {
                this.nt.add(str);
                this.nu += str.length();
            }
        }
    }

    int m4158a(int i, int i2) {
        return (this.np * i) + (this.nq * i2);
    }

    public boolean aS() {
        boolean z;
        synchronized (this.mH) {
            z = this.nw == 0;
        }
        return z;
    }

    public String aT() {
        return this.ny;
    }

    public void aU() {
        synchronized (this.mH) {
            this.nx -= 100;
        }
    }

    public void aV() {
        synchronized (this.mH) {
            this.nw--;
        }
    }

    public void aW() {
        synchronized (this.mH) {
            this.nw++;
        }
    }

    public void aX() {
        synchronized (this.mH) {
            int a = m4158a(this.nu, this.nv);
            if (a > this.nx) {
                this.nx = a;
                this.ny = this.ns.m4175a(this.nt);
            }
        }
    }

    int aY() {
        return this.nu;
    }

    public void m4159c(int i) {
        this.nv = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ak akVar = (ak) obj;
        return akVar.aT() != null && akVar.aT().equals(aT());
    }

    public int getScore() {
        return this.nx;
    }

    public void m4160h(String str) {
        m4157j(str);
        synchronized (this.mH) {
            if (this.nw < 0) {
                gr.m4769S("ActivityContent: negative number of WebViews.");
            }
            aX();
        }
    }

    public int hashCode() {
        return aT().hashCode();
    }

    public void m4161i(String str) {
        m4157j(str);
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.nv + " score:" + this.nx + " total_length:" + this.nu + "\n text: " + m4156a(this.nt, 200) + "\n signture: " + this.ny;
    }
}
