package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C1201i extends C1182h {
    private static Method kA;
    private static Method kB;
    private static Method kC;
    private static Method kD;
    private static Method kE;
    private static Method kF;
    private static Method kG;
    private static Method kH;
    private static Method kI;
    private static String kJ;
    private static String kK;
    private static String kL;
    private static C1397o kM;
    static boolean kN;
    private static long startTime;

    /* renamed from: com.google.android.gms.internal.i.a */
    static class C1200a extends Exception {
        public C1200a(Throwable th) {
            super(th);
        }
    }

    static {
        startTime = 0;
        kN = false;
    }

    protected C1201i(Context context, C1101m c1101m, C1361n c1361n) {
        super(context, c1101m, c1361n);
    }

    static String m4910a(Context context, C1101m c1101m) throws C1200a {
        if (kK != null) {
            return kK;
        }
        if (kD == null) {
            throw new C1200a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kD.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C1200a();
            }
            String a = c1101m.m4482a(byteBuffer.array(), true);
            kK = a;
            return a;
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static ArrayList<Long> m4911a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C1200a {
        if (kE == null || motionEvent == null) {
            throw new C1200a();
        }
        try {
            return (ArrayList) kE.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    protected static synchronized void m4912a(String str, Context context, C1101m c1101m) {
        synchronized (C1201i.class) {
            if (!kN) {
                try {
                    kM = new C1397o(c1101m, null);
                    kJ = str;
                    C1201i.m4918g(context);
                    startTime = C1201i.m4920w().longValue();
                    kN = true;
                } catch (C1200a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String m4913b(Context context, C1101m c1101m) throws C1200a {
        if (kL != null) {
            return kL;
        }
        if (kG == null) {
            throw new C1200a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kG.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C1200a();
            }
            String a = c1101m.m4482a(byteBuffer.array(), true);
            kL = a;
            return a;
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    private static String m4914b(byte[] bArr, String str) throws C1200a {
        try {
            return new String(kM.m5687c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static String m4915d(Context context) throws C1200a {
        if (kF == null) {
            throw new C1200a();
        }
        try {
            String str = (String) kF.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C1200a();
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static ArrayList<Long> m4916e(Context context) throws C1200a {
        if (kH == null) {
            throw new C1200a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) kH.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C1200a();
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static int[] m4917f(Context context) throws C1200a {
        if (kI == null) {
            throw new C1200a();
        }
        try {
            return (int[]) kI.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    private static void m4918g(Context context) throws C1200a {
        File file;
        File createTempFile;
        try {
            byte[] b = kM.m5686b(C1447q.getKey());
            byte[] c = kM.m5687c(b, C1447q.m5816E());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C1200a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5819H()));
            Class loadClass2 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5831T()));
            Class loadClass3 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5825N()));
            Class loadClass4 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5823L()));
            Class loadClass5 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5833V()));
            Class loadClass6 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5821J()));
            Class loadClass7 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5829R()));
            Class loadClass8 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5827P()));
            Class loadClass9 = dexClassLoader.loadClass(C1201i.m4914b(b, C1447q.m5817F()));
            kA = loadClass.getMethod(C1201i.m4914b(b, C1447q.m5820I()), new Class[0]);
            kB = loadClass2.getMethod(C1201i.m4914b(b, C1447q.m5832U()), new Class[0]);
            kC = loadClass3.getMethod(C1201i.m4914b(b, C1447q.m5826O()), new Class[0]);
            kD = loadClass4.getMethod(C1201i.m4914b(b, C1447q.m5824M()), new Class[]{Context.class});
            kE = loadClass5.getMethod(C1201i.m4914b(b, C1447q.m5834W()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            kF = loadClass6.getMethod(C1201i.m4914b(b, C1447q.m5822K()), new Class[]{Context.class});
            kG = loadClass7.getMethod(C1201i.m4914b(b, C1447q.m5830S()), new Class[]{Context.class});
            kH = loadClass8.getMethod(C1201i.m4914b(b, C1447q.m5828Q()), new Class[]{Context.class});
            kI = loadClass9.getMethod(C1201i.m4914b(b, C1447q.m5818G()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        } catch (Throwable e22) {
            throw new C1200a(e22);
        } catch (Throwable e222) {
            throw new C1200a(e222);
        } catch (Throwable e2222) {
            throw new C1200a(e2222);
        } catch (Throwable e22222) {
            throw new C1200a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    static String m4919v() throws C1200a {
        if (kJ != null) {
            return kJ;
        }
        throw new C1200a();
    }

    static Long m4920w() throws C1200a {
        if (kA == null) {
            throw new C1200a();
        }
        try {
            return (Long) kA.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static String m4921x() throws C1200a {
        if (kC == null) {
            throw new C1200a();
        }
        try {
            return (String) kC.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    static Long m4922y() throws C1200a {
        if (kB == null) {
            throw new C1200a();
        }
        try {
            return (Long) kB.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C1200a(e);
        } catch (Throwable e2) {
            throw new C1200a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m4923b(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C1201i.m4921x();	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
        r6.m4820a(r0, r1);	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C1201i.m4919v();	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
        r6.m4820a(r0, r1);	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
    L_0x0010:
        r0 = com.google.android.gms.internal.C1201i.m4920w();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = 25;
        r6.m4819a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0 - r3;
        r6.m4819a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r6.m4819a(r0, r1);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
    L_0x0034:
        r1 = com.google.android.gms.internal.C1201i.m4916e(r7);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r3 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.m4819a(r2, r3);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.m4819a(r2, r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
    L_0x0058:
        r0 = 33;
        r1 = com.google.android.gms.internal.C1201i.m4922y();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r1 = r1.longValue();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r6.m4819a(r0, r1);	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
    L_0x0065:
        r0 = 27;
        r1 = r6.ky;	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r1 = com.google.android.gms.internal.C1201i.m4910a(r7, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r6.m4820a(r0, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
    L_0x0070:
        r0 = 29;
        r1 = r6.ky;	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r1 = com.google.android.gms.internal.C1201i.m4913b(r7, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r6.m4820a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
    L_0x007b:
        r0 = com.google.android.gms.internal.C1201i.m4917f(r7);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 5;
        r2 = 0;
        r2 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r2;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.m4819a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 6;
        r2 = 1;
        r0 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r0;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.m4819a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
    L_0x008f:
        return;
    L_0x0090:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0092:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0094:
        r0 = move-exception;
        goto L_0x007b;
    L_0x0096:
        r0 = move-exception;
        goto L_0x0070;
    L_0x0098:
        r0 = move-exception;
        goto L_0x0065;
    L_0x009a:
        r0 = move-exception;
        goto L_0x0058;
    L_0x009c:
        r0 = move-exception;
        goto L_0x0034;
    L_0x009e:
        r0 = move-exception;
        goto L_0x0010;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m4924c(android.content.Context r6) {
        /*
        r5 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C1201i.m4919v();	 Catch:{ a -> 0x0065, IOException -> 0x005d }
        r5.m4820a(r0, r1);	 Catch:{ a -> 0x0065, IOException -> 0x005d }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C1201i.m4921x();	 Catch:{ a -> 0x0063, IOException -> 0x005d }
        r5.m4820a(r0, r1);	 Catch:{ a -> 0x0063, IOException -> 0x005d }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C1201i.m4920w();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r1 = r1.longValue();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r5.m4819a(r0, r1);	 Catch:{ a -> 0x0061, IOException -> 0x005d }
    L_0x001d:
        r0 = r5.kw;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = r5.kx;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = com.google.android.gms.internal.C1201i.m4911a(r0, r1);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r3 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m4819a(r2, r3);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r3 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m4819a(r2, r3);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r1.size();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 3;
        if (r0 < r2) goto L_0x005c;
    L_0x004c:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m4819a(r2, r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
    L_0x005c:
        return;
    L_0x005d:
        r0 = move-exception;
        goto L_0x005c;
    L_0x005f:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0061:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.c(android.content.Context):void");
    }
}
