package com.p000a.p001a.p002a;

/* renamed from: com.a.a.a.b */
public abstract class PointFilter {
    protected boolean f6a;
    private int f7b;
    private int f8c;

    public abstract int m12a(int i);

    public PointFilter() {
        this.f6a = false;
    }

    public int[] m13a(int[] iArr, int i, int i2) {
        this.f7b = i;
        this.f8c = i2;
        int i3 = this.f7b;
        int i4 = this.f8c;
        this.f7b = i3;
        this.f8c = i4;
        int[] iArr2 = new int[this.f7b];
        int[] iArr3 = new int[(this.f7b * this.f8c)];
        for (i3 = 0; i3 < this.f8c; i3++) {
            int i5 = 0;
            for (i4 = this.f7b * i3; i4 < (this.f7b * i3) + this.f7b; i4++) {
                iArr2[i5] = iArr[i4];
                i5++;
            }
            for (i4 = 0; i4 < this.f7b; i4++) {
                iArr2[i4] = m12a(iArr2[i4]);
            }
            i5 = 0;
            for (i4 = this.f7b * i3; i4 < (this.f7b * i3) + this.f7b; i4++) {
                iArr3[i4] = iArr2[i5];
                i5++;
            }
        }
        return iArr3;
    }
}
