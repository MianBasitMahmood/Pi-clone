package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

public class ar extends ao {
    private MessageDigest nZ;

    byte[] m4181a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = m4182e(aq.m4179o(strArr[i]));
        }
        return bArr;
    }

    byte m4182e(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    public byte[] m4183l(String str) {
        byte[] bArr;
        int i = 4;
        byte[] a = m4181a(str.split(" "));
        this.nZ = bf();
        synchronized (this.mH) {
            if (this.nZ == null) {
                bArr = new byte[0];
            } else {
                this.nZ.reset();
                this.nZ.update(a);
                Object digest = this.nZ.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
