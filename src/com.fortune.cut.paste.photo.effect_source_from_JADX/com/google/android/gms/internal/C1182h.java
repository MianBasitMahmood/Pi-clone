package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.drive.FileUploadPreferences;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.h */
public abstract class C1182h implements C1162g {
    protected MotionEvent kw;
    protected DisplayMetrics kx;
    protected C1101m ky;
    private C1361n kz;

    protected C1182h(Context context, C1101m c1101m, C1361n c1361n) {
        this.ky = c1101m;
        this.kz = c1361n;
        try {
            this.kx = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.kx = new DisplayMetrics();
            this.kx.density = TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    }

    private String m4812a(Context context, String str, boolean z) {
        try {
            byte[] u;
            synchronized (this) {
                m4813t();
                if (z) {
                    m4824c(context);
                } else {
                    m4823b(context);
                }
                u = m4814u();
            }
            return u.length == 0 ? Integer.toString(5) : m4817a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m4813t() {
        this.kz.reset();
    }

    private byte[] m4814u() throws IOException {
        return this.kz.m5534D();
    }

    public String m4815a(Context context) {
        return m4812a(context, null, false);
    }

    public String m4816a(Context context, String str) {
        return m4812a(context, str, true);
    }

    String m4817a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m4813t();
            m4819a(20, 1);
            bArr = m4814u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
        new C1133f().m4561a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m4822a(str, bArr3);
        }
        return this.ky.m4482a(bArr3, true);
    }

    public void m4818a(int i, int i2, int i3) {
        if (this.kw != null) {
            this.kw.recycle();
        }
        this.kw = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.kx.density, ((float) i2) * this.kx.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m4819a(int i, long j) throws IOException {
        this.kz.m5535b(i, j);
    }

    protected void m4820a(int i, String str) throws IOException {
        this.kz.m5536b(i, str);
    }

    public void m4821a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.kw != null) {
                this.kw.recycle();
            }
            this.kw = MotionEvent.obtain(motionEvent);
        }
    }

    void m4822a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new qn(str.getBytes("UTF-8")).m5929o(bArr);
    }

    protected abstract void m4823b(Context context);

    protected abstract void m4824c(Context context);
}
