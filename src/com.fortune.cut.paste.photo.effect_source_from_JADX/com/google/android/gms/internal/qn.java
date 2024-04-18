package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.FileUploadPreferences;

public class qn {
    private final byte[] ayJ;
    private int ayK;
    private int ayL;

    public qn(byte[] bArr) {
        int i;
        this.ayJ = new byte[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
        for (i = 0; i < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i++) {
            this.ayJ[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i2++) {
            i = ((i + this.ayJ[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ayJ[i2];
            this.ayJ[i2] = this.ayJ[i];
            this.ayJ[i] = b;
        }
        this.ayK = 0;
        this.ayL = 0;
    }

    public void m5929o(byte[] bArr) {
        int i = this.ayK;
        int i2 = this.ayL;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.ayJ[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ayJ[i];
            this.ayJ[i] = this.ayJ[i2];
            this.ayJ[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.ayJ[(this.ayJ[i] + this.ayJ[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.ayK = i;
        this.ayL = i2;
    }
}
