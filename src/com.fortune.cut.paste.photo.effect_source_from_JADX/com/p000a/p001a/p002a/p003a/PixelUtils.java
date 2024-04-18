package com.p000a.p001a.p002a.p003a;

import android.support.v4.view.MotionEventCompat;
import java.util.Random;

/* renamed from: com.a.a.a.a.b */
public final class PixelUtils {
    private static Random f3a;
    private static final float[] f4b;
    private static final float[] f5c;

    static {
        f3a = new Random();
        f4b = new float[3];
        f5c = new float[3];
    }

    public static int m11a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > MotionEventCompat.ACTION_MASK) {
            return MotionEventCompat.ACTION_MASK;
        }
        return i;
    }
}
