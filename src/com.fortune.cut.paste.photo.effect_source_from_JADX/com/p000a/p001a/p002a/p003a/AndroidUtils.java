package com.p000a.p001a.p002a.p003a;

import android.graphics.Bitmap;

/* renamed from: com.a.a.a.a.a */
public final class AndroidUtils {
    public static int[] m10a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }
}
