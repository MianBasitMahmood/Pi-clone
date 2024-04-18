package com.chartboost.sdk.impl;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import com.google.android.gms.games.request.GameRequest;
import java.io.Serializable;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cy implements Serializable, Comparable<cy> {
    static final Logger f865a;
    private static AtomicInteger f866f;
    private static final int f867g;
    final int f868b;
    final int f869c;
    final int f870d;
    boolean f871e;

    public /* synthetic */ int compareTo(Object obj) {
        return m1286a((cy) obj);
    }

    static {
        int hashCode;
        f865a = Logger.getLogger("org.bson.ObjectId");
        f866f = new AtomicInteger(new Random().nextInt());
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                stringBuilder.append(((NetworkInterface) networkInterfaces.nextElement()).toString());
            }
            hashCode = stringBuilder.toString().hashCode() << 16;
        } catch (Throwable th) {
            try {
                f865a.log(Level.WARNING, th.getMessage(), th);
                hashCode = new Random().nextInt() << 16;
            } catch (Throwable th2) {
                throw new RuntimeException(th2);
            }
        }
        f865a.fine("machine piece post: " + Integer.toHexString(hashCode));
        int nextInt = new Random().nextInt();
        ClassLoader classLoader = cy.class.getClassLoader();
        int identityHashCode = classLoader != null ? System.identityHashCode(classLoader) : 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Integer.toHexString(nextInt));
        stringBuilder2.append(Integer.toHexString(identityHashCode));
        identityHashCode = stringBuilder2.toString().hashCode() & GameRequest.TYPE_ALL;
        f865a.fine("process piece: " + Integer.toHexString(identityHashCode));
        f867g = identityHashCode | hashCode;
        f865a.fine("machine : " + Integer.toHexString(f867g));
    }

    public static boolean m1283a(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length != 24) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && (charAt < 'A' || charAt > 'F'))) {
                return false;
            }
        }
        return true;
    }

    public static cy m1281a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof cy) {
            return (cy) obj;
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (m1283a(obj2)) {
                return new cy(obj2);
            }
        }
        return null;
    }

    public cy(String str) {
        this(str, false);
    }

    public cy(String str, boolean z) {
        if (m1283a(str)) {
            if (z) {
                str = m1284b(str);
            }
            byte[] bArr = new byte[12];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f868b = wrap.getInt();
            this.f869c = wrap.getInt();
            this.f870d = wrap.getInt();
            this.f871e = false;
            return;
        }
        throw new IllegalArgumentException("invalid ObjectId [" + str + "]");
    }

    public cy(int i, int i2, int i3) {
        this.f868b = i;
        this.f869c = i2;
        this.f870d = i3;
        this.f871e = false;
    }

    public cy() {
        this.f868b = (int) (System.currentTimeMillis() / 1000);
        this.f869c = f867g;
        this.f870d = f866f.getAndIncrement();
        this.f871e = true;
    }

    public int hashCode() {
        return (this.f868b + (this.f869c * 111)) + (this.f870d * 17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        cy a = m1281a(obj);
        if (a == null) {
            return false;
        }
        if (this.f868b == a.f868b && this.f869c == a.f869c && this.f870d == a.f870d) {
            return true;
        }
        return false;
    }

    public String m1287a() {
        byte[] b = m1288b();
        StringBuilder stringBuilder = new StringBuilder(24);
        for (byte b2 : b) {
            String toHexString = Integer.toHexString(b2 & MotionEventCompat.ACTION_MASK);
            if (toHexString.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public byte[] m1288b() {
        byte[] bArr = new byte[12];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putInt(this.f868b);
        wrap.putInt(this.f869c);
        wrap.putInt(this.f870d);
        return bArr;
    }

    static String m1282a(String str, int i) {
        return str.substring(i * 2, (i * 2) + 2);
    }

    public static String m1284b(String str) {
        if (m1283a(str)) {
            int i;
            StringBuilder stringBuilder = new StringBuilder(24);
            for (i = 7; i >= 0; i--) {
                stringBuilder.append(m1282a(str, i));
            }
            for (i = 11; i >= 8; i--) {
                stringBuilder.append(m1282a(str, i));
            }
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("invalid object id: " + str);
    }

    public String toString() {
        return m1287a();
    }

    int m1285a(int i, int i2) {
        long j = (((long) i) & 4294967295L) - (((long) i2) & 4294967295L);
        if (j < -2147483648L) {
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public int m1286a(cy cyVar) {
        if (cyVar == null) {
            return -1;
        }
        int a = m1285a(this.f868b, cyVar.f868b);
        if (a != 0) {
            return a;
        }
        a = m1285a(this.f869c, cyVar.f869c);
        return a == 0 ? m1285a(this.f870d, cyVar.f870d) : a;
    }

    public int m1289c() {
        return this.f868b;
    }

    public int m1290d() {
        return this.f869c;
    }

    public int m1291e() {
        return this.f870d;
    }
}
