package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

@ey
public class el {
    public static PublicKey m4519F(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            gr.m4770T("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    public static boolean m4520a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            gr.m4770T("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            gr.m4770T("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            gr.m4770T("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            gr.m4770T("Signature exception.");
            return false;
        }
    }

    public static boolean m4521b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return m4520a(m4519F(str), str2, str3);
        }
        gr.m4770T("Purchase verification failed: missing data.");
        return false;
    }
}
