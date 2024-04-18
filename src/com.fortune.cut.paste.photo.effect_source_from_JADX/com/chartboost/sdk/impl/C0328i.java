package com.chartboost.sdk.impl;

import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.i */
public class C0328i {
    public final int f912a;
    public final byte[] f913b;
    public final Map<String, String> f914c;
    public final boolean f915d;

    public C0328i(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this.f912a = i;
        this.f913b = bArr;
        this.f914c = map;
        this.f915d = z;
    }

    public C0328i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false);
    }
}
