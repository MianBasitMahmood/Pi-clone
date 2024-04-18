package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.o */
public class C1397o {
    private final SecureRandom kZ;
    private final C1101m ky;

    /* renamed from: com.google.android.gms.internal.o.a */
    public class C1396a extends Exception {
        final /* synthetic */ C1397o la;

        public C1396a(C1397o c1397o) {
            this.la = c1397o;
        }

        public C1396a(C1397o c1397o, Throwable th) {
            this.la = c1397o;
            super(th);
        }
    }

    public C1397o(C1101m c1101m, SecureRandom secureRandom) {
        this.ky = c1101m;
        this.kZ = secureRandom;
    }

    static void m5685c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m5686b(String str) throws C1396a {
        try {
            byte[] a = this.ky.m4483a(str, false);
            if (a.length != 32) {
                throw new C1396a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C1397o.m5685c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C1396a(this, e);
        }
    }

    public byte[] m5687c(byte[] bArr, String str) throws C1396a {
        if (bArr.length != 16) {
            throw new C1396a(this);
        }
        try {
            byte[] a = this.ky.m4483a(str, false);
            if (a.length <= 16) {
                throw new C1396a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C1396a(this, e);
        } catch (Throwable e2) {
            throw new C1396a(this, e2);
        } catch (Throwable e22) {
            throw new C1396a(this, e22);
        } catch (Throwable e222) {
            throw new C1396a(this, e222);
        } catch (Throwable e2222) {
            throw new C1396a(this, e2222);
        } catch (Throwable e22222) {
            throw new C1396a(this, e22222);
        } catch (Throwable e222222) {
            throw new C1396a(this, e222222);
        }
    }
}
