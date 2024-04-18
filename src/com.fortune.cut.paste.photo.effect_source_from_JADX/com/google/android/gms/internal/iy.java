package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

public abstract class iy<T> {
    private static C1232a KO;
    private static final Object mH;
    protected final String KP;
    protected final T KQ;
    private T KR;

    /* renamed from: com.google.android.gms.internal.iy.1 */
    static class C12291 extends iy<Boolean> {
        C12291(String str, Boolean bool) {
            super(str, bool);
        }
    }

    /* renamed from: com.google.android.gms.internal.iy.2 */
    static class C12302 extends iy<Integer> {
        C12302(String str, Integer num) {
            super(str, num);
        }
    }

    /* renamed from: com.google.android.gms.internal.iy.3 */
    static class C12313 extends iy<String> {
        C12313(String str, String str2) {
            super(str, str2);
        }
    }

    /* renamed from: com.google.android.gms.internal.iy.a */
    private interface C1232a {
    }

    /* renamed from: com.google.android.gms.internal.iy.b */
    private static class C1233b implements C1232a {
        private final ContentResolver mContentResolver;

        public C1233b(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }
    }

    static {
        mH = new Object();
        KO = null;
    }

    protected iy(String str, T t) {
        this.KR = null;
        this.KP = str;
        this.KQ = t;
    }

    public static void m5062H(Context context) {
        synchronized (mH) {
            if (KO == null) {
                KO = new C1233b(context.getContentResolver());
            }
        }
    }

    public static iy<Integer> m5063a(String str, Integer num) {
        return new C12302(str, num);
    }

    public static iy<Boolean> m5064h(String str, boolean z) {
        return new C12291(str, Boolean.valueOf(z));
    }

    public static iy<String> m5065l(String str, String str2) {
        return new C12313(str, str2);
    }

    public String getKey() {
        return this.KP;
    }
}
