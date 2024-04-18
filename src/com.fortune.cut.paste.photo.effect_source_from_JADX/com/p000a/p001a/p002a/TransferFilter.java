package com.p000a.p001a.p002a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.drive.FileUploadPreferences;
import com.p000a.p001a.p002a.p003a.PixelUtils;

/* renamed from: com.a.a.a.c */
public abstract class TransferFilter extends PointFilter {
    protected int[] f9b;
    protected int[] f10c;
    protected int[] f11d;
    protected boolean f12e;

    public TransferFilter() {
        this.f12e = false;
        this.a = true;
    }

    public final int m15a(int i) {
        int i2 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        return (((ViewCompat.MEASURED_STATE_MASK & i) | (this.f9b[(i >> 16) & MotionEventCompat.ACTION_MASK] << 16)) | (this.f10c[i2] << 8)) | this.f11d[i & MotionEventCompat.ACTION_MASK];
    }

    public final int[] m16a(int[] iArr, int i, int i2) {
        if (!this.f12e) {
            this.f12e = true;
            int[] iArr2 = new int[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
            for (int i3 = 0; i3 < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i3++) {
                iArr2[i3] = PixelUtils.m11a((int) (m14a(((float) i3) / 255.0f) * 255.0f));
            }
            this.f11d = iArr2;
            this.f10c = iArr2;
            this.f9b = iArr2;
        }
        return super.m13a(iArr, i, i2);
    }

    protected float m14a(float f) {
        return 0.0f;
    }
}
