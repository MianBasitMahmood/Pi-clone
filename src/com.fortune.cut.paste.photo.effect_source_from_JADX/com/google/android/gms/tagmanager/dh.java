package com.google.android.gms.tagmanager;

class dh extends Number implements Comparable<dh> {
    private double atZ;
    private long aua;
    private boolean aub;

    private dh(double d) {
        this.atZ = d;
        this.aub = false;
    }

    private dh(long j) {
        this.aua = j;
        this.aub = true;
    }

    public static dh m6604a(Double d) {
        return new dh(d.doubleValue());
    }

    public static dh cY(String str) throws NumberFormatException {
        try {
            return new dh(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new dh(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public static dh m6605z(long j) {
        return new dh(j);
    }

    public int m6606a(dh dhVar) {
        return (qR() && dhVar.qR()) ? new Long(this.aua).compareTo(Long.valueOf(dhVar.aua)) : Double.compare(doubleValue(), dhVar.doubleValue());
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m6606a((dh) obj);
    }

    public double doubleValue() {
        return qR() ? (double) this.aua : this.atZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof dh) && m6606a((dh) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return qT();
    }

    public long longValue() {
        return qS();
    }

    public boolean qQ() {
        return !qR();
    }

    public boolean qR() {
        return this.aub;
    }

    public long qS() {
        return qR() ? this.aua : (long) this.atZ;
    }

    public int qT() {
        return (int) longValue();
    }

    public short qU() {
        return (short) ((int) longValue());
    }

    public short shortValue() {
        return qU();
    }

    public String toString() {
        return qR() ? Long.toString(this.aua) : Double.toString(this.atZ);
    }
}
