package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ao {
    private static MessageDigest nS;
    protected Object mH;

    static {
        nS = null;
    }

    public ao() {
        this.mH = new Object();
    }

    protected MessageDigest bf() {
        MessageDigest messageDigest;
        synchronized (this.mH) {
            if (nS != null) {
                messageDigest = nS;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        nS = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = nS;
            }
        }
        return messageDigest;
    }

    abstract byte[] m4172l(String str);
}
