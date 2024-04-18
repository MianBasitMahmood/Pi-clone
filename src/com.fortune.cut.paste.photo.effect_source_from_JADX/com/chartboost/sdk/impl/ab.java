package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.chartboost.sdk.impl.C0182l.C0332a;
import com.chartboost.sdk.impl.C0336n.C0096a;
import com.chartboost.sdk.impl.C0336n.C0098b;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.LocationStatusCodes;

public class ab extends C0182l<Bitmap> {
    private static final Object f333e;
    private final C0098b<Bitmap> f334a;
    private final Config f335b;
    private final int f336c;
    private final int f337d;

    protected /* synthetic */ void m576b(Object obj) {
        m575a((Bitmap) obj);
    }

    static {
        f333e = new Object();
    }

    public ab(String str, C0098b<Bitmap> c0098b, int i, int i2, Config config, C0096a c0096a) {
        super(0, str, c0096a);
        m541a(new C0303d(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, 2, 2.0f));
        this.f334a = c0098b;
        this.f335b = config;
        this.f336c = i;
        this.f337d = i2;
    }

    public C0332a m577s() {
        return C0332a.LOW;
    }

    private static int m572b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) ((((double) i2) / ((double) i4)) * ((double) i3));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (((double) i) * d > ((double) i2)) {
            return (int) (((double) i2) / d);
        }
        return i;
    }

    protected C0336n<Bitmap> m574a(C0328i c0328i) {
        C0336n<Bitmap> b;
        synchronized (f333e) {
            try {
                b = m573b(c0328i);
            } catch (Throwable e) {
                C0341t.m1370c("Caught OOM for %d byte image, url=%s", Integer.valueOf(c0328i.f913b.length), m551d());
                b = C0336n.m1361a(new C0330k(e));
            }
        }
        return b;
    }

    private C0336n<Bitmap> m573b(C0328i c0328i) {
        Object decodeByteArray;
        byte[] bArr = c0328i.f913b;
        Options options = new Options();
        if (this.f336c == 0 && this.f337d == 0) {
            options.inPreferredConfig = this.f335b;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = m572b(this.f336c, this.f337d, i, i2);
            int b2 = m572b(this.f337d, this.f336c, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m571a(i, i2, b, b2);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray2 == null || (decodeByteArray2.getWidth() <= b && decodeByteArray2.getHeight() <= b2)) {
                Bitmap bitmap = decodeByteArray2;
            } else {
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray2, b, b2, true);
                decodeByteArray2.recycle();
            }
        }
        if (decodeByteArray == null) {
            return C0336n.m1361a(new C0330k(c0328i));
        }
        return C0336n.m1362a(decodeByteArray, C0350y.m1411a(c0328i));
    }

    protected void m575a(Bitmap bitmap) {
        this.f334a.m79a(bitmap);
    }

    static int m571a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = TextTrackStyle.DEFAULT_FONT_SCALE;
        while (((double) (f * 2.0f)) <= min) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
