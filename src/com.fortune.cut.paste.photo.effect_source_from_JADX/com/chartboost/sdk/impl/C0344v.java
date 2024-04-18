package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.v */
public class C0344v {
    protected static final Comparator<byte[]> f954a;
    private List<byte[]> f955b;
    private List<byte[]> f956c;
    private int f957d;
    private final int f958e;

    /* renamed from: com.chartboost.sdk.impl.v.1 */
    class C03431 implements Comparator<byte[]> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1378a((byte[]) obj, (byte[]) obj2);
        }

        C03431() {
        }

        public int m1378a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    static {
        f954a = new C03431();
    }

    public C0344v(int i) {
        this.f955b = new LinkedList();
        this.f956c = new ArrayList(64);
        this.f957d = 0;
        this.f958e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] m1381a(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r4.f956c;	 Catch:{ all -> 0x002b }
        r0 = r0.size();	 Catch:{ all -> 0x002b }
        if (r1 < r0) goto L_0x000f;
    L_0x000b:
        r0 = new byte[r5];	 Catch:{ all -> 0x002b }
    L_0x000d:
        monitor-exit(r4);
        return r0;
    L_0x000f:
        r0 = r4.f956c;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002b }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x002b }
        r2 = r0.length;	 Catch:{ all -> 0x002b }
        if (r2 < r5) goto L_0x002e;
    L_0x001a:
        r2 = r4.f957d;	 Catch:{ all -> 0x002b }
        r3 = r0.length;	 Catch:{ all -> 0x002b }
        r2 = r2 - r3;
        r4.f957d = r2;	 Catch:{ all -> 0x002b }
        r2 = r4.f956c;	 Catch:{ all -> 0x002b }
        r2.remove(r1);	 Catch:{ all -> 0x002b }
        r1 = r4.f955b;	 Catch:{ all -> 0x002b }
        r1.remove(r0);	 Catch:{ all -> 0x002b }
        goto L_0x000d;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x002e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v.a(int):byte[]");
    }

    public synchronized void m1380a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f958e) {
                this.f955b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f956c, bArr, f954a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f956c.add(binarySearch, bArr);
                this.f957d += bArr.length;
                m1379a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m1379a() {
        /*
        r2 = this;
        monitor-enter(r2);
    L_0x0001:
        r0 = r2.f957d;	 Catch:{ all -> 0x001f }
        r1 = r2.f958e;	 Catch:{ all -> 0x001f }
        if (r0 > r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);
        return;
    L_0x0009:
        r0 = r2.f955b;	 Catch:{ all -> 0x001f }
        r1 = 0;
        r0 = r0.remove(r1);	 Catch:{ all -> 0x001f }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x001f }
        r1 = r2.f956c;	 Catch:{ all -> 0x001f }
        r1.remove(r0);	 Catch:{ all -> 0x001f }
        r1 = r2.f957d;	 Catch:{ all -> 0x001f }
        r0 = r0.length;	 Catch:{ all -> 0x001f }
        r0 = r1 - r0;
        r2.f957d = r0;	 Catch:{ all -> 0x001f }
        goto L_0x0001;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v.a():void");
    }
}
