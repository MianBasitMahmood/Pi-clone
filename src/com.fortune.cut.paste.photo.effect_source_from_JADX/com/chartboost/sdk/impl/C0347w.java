package com.chartboost.sdk.impl;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.chartboost.sdk.impl.C0230b.C0229a;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.chartboost.sdk.impl.w */
public class C0347w implements C0230b {
    private final Map<String, C0345a> f967a;
    private long f968b;
    private final File f969c;
    private final int f970d;

    /* renamed from: com.chartboost.sdk.impl.w.a */
    static class C0345a {
        public long f959a;
        public String f960b;
        public String f961c;
        public long f962d;
        public long f963e;
        public long f964f;
        public Map<String, String> f965g;

        private C0345a() {
        }

        public C0345a(String str, C0229a c0229a) {
            this.f960b = str;
            this.f959a = (long) c0229a.f594a.length;
            this.f961c = c0229a.f595b;
            this.f962d = c0229a.f596c;
            this.f963e = c0229a.f597d;
            this.f964f = c0229a.f598e;
            this.f965g = c0229a.f599f;
        }

        public static C0345a m1382a(InputStream inputStream) throws IOException {
            C0345a c0345a = new C0345a();
            if (C0347w.m1386a(inputStream) != 538183203) {
                throw new IOException();
            }
            c0345a.f960b = C0347w.m1395c(inputStream);
            c0345a.f961c = C0347w.m1395c(inputStream);
            if (c0345a.f961c.equals("")) {
                c0345a.f961c = null;
            }
            c0345a.f962d = C0347w.m1394b(inputStream);
            c0345a.f963e = C0347w.m1394b(inputStream);
            c0345a.f964f = C0347w.m1394b(inputStream);
            c0345a.f965g = C0347w.m1397d(inputStream);
            return c0345a;
        }

        public C0229a m1383a(byte[] bArr) {
            C0229a c0229a = new C0229a();
            c0229a.f594a = bArr;
            c0229a.f595b = this.f961c;
            c0229a.f596c = this.f962d;
            c0229a.f597d = this.f963e;
            c0229a.f598e = this.f964f;
            c0229a.f599f = this.f965g;
            return c0229a;
        }

        public boolean m1384a(OutputStream outputStream) {
            try {
                C0347w.m1388a(outputStream, 538183203);
                C0347w.m1390a(outputStream, this.f960b);
                C0347w.m1390a(outputStream, this.f961c == null ? "" : this.f961c);
                C0347w.m1389a(outputStream, this.f962d);
                C0347w.m1389a(outputStream, this.f963e);
                C0347w.m1389a(outputStream, this.f964f);
                C0347w.m1392a(this.f965g, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                C0341t.m1369b("%s", e.toString());
                return false;
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w.b */
    private static class C0346b extends FilterInputStream {
        private int f966a;

        private C0346b(InputStream inputStream) {
            super(inputStream);
            this.f966a = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f966a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f966a += read;
            }
            return read;
        }
    }

    public C0347w(File file, int i) {
        this.f967a = new LinkedHashMap(16, 0.75f, true);
        this.f968b = 0;
        this.f969c = file;
        this.f970d = i;
    }

    public C0347w(File file) {
        this(file, 5242880);
    }

    public synchronized C0229a m1400a(String str) {
        C0229a c0229a;
        IOException e;
        Throwable th;
        C0345a c0345a = (C0345a) this.f967a.get(str);
        if (c0345a == null) {
            c0229a = null;
        } else {
            File c = m1404c(str);
            C0346b c0346b;
            try {
                c0346b = new C0346b(null);
                try {
                    C0345a.m1382a((InputStream) c0346b);
                    c0229a = c0345a.m1383a(C0347w.m1393a((InputStream) c0346b, (int) (c.length() - ((long) c0346b.f966a))));
                    try {
                        c0346b.close();
                    } catch (IOException e2) {
                        c0229a = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C0341t.m1369b("%s: %s", c.getAbsolutePath(), e.toString());
                        m1403b(str);
                        if (c0346b != null) {
                            try {
                                c0346b.close();
                            } catch (IOException e4) {
                                c0229a = null;
                            }
                        }
                        c0229a = null;
                        return c0229a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0346b != null) {
                            try {
                                c0346b.close();
                            } catch (IOException e5) {
                                c0229a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c0346b = null;
                C0341t.m1369b("%s: %s", c.getAbsolutePath(), e.toString());
                m1403b(str);
                if (c0346b != null) {
                    c0346b.close();
                }
                c0229a = null;
                return c0229a;
            } catch (Throwable th3) {
                th = th3;
                c0346b = null;
                if (c0346b != null) {
                    c0346b.close();
                }
                throw th;
            }
        }
        return c0229a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m1401a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f969c;	 Catch:{ all -> 0x0065 }
        r1 = r1.exists();	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f969c;	 Catch:{ all -> 0x0065 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0065 }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0065 }
        r2 = 0;
        r3 = r9.f969c;	 Catch:{ all -> 0x0065 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0065 }
        r1[r2] = r3;	 Catch:{ all -> 0x0065 }
        com.chartboost.sdk.impl.C0341t.m1370c(r0, r1);	 Catch:{ all -> 0x0065 }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f969c;	 Catch:{ all -> 0x0065 }
        r3 = r1.listFiles();	 Catch:{ all -> 0x0065 }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x0065 }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x0065 }
        r1 = 0;
        r0 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x004f, all -> 0x005e }
        r0.<init>(r5);	 Catch:{ IOException -> 0x004f, all -> 0x005e }
        r1 = com.chartboost.sdk.impl.C0347w.C0345a.m1382a(r0);	 Catch:{ IOException -> 0x0071 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0071 }
        r1.f959a = r6;	 Catch:{ IOException -> 0x0071 }
        r6 = r1.f960b;	 Catch:{ IOException -> 0x0071 }
        r9.m1391a(r6, r1);	 Catch:{ IOException -> 0x0071 }
        r0.close();	 Catch:{ IOException -> 0x006a }
    L_0x004b:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x004f:
        r0 = move-exception;
        r0 = r1;
    L_0x0051:
        if (r5 == 0) goto L_0x0056;
    L_0x0053:
        r5.delete();	 Catch:{ all -> 0x006c }
    L_0x0056:
        if (r0 == 0) goto L_0x004b;
    L_0x0058:
        r0.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x004b;
    L_0x005c:
        r0 = move-exception;
        goto L_0x004b;
    L_0x005e:
        r0 = move-exception;
    L_0x005f:
        if (r1 == 0) goto L_0x0064;
    L_0x0061:
        r1.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0064:
        throw r0;	 Catch:{ all -> 0x0065 }
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0064;
    L_0x006a:
        r0 = move-exception;
        goto L_0x004b;
    L_0x006c:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x005f;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.w.a():void");
    }

    public synchronized void m1402a(String str, C0229a c0229a) {
        m1387a(c0229a.f594a.length);
        File c = m1404c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C0345a c0345a = new C0345a(str, c0229a);
            if (c0345a.m1384a(fileOutputStream)) {
                fileOutputStream.write(c0229a.f594a);
                fileOutputStream.close();
                m1391a(str, c0345a);
            } else {
                fileOutputStream.close();
                C0341t.m1369b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                C0341t.m1369b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m1403b(String str) {
        boolean delete = m1404c(str).delete();
        m1399e(str);
        if (!delete) {
            C0341t.m1369b("Could not delete cache entry for key=%s, filename=%s", str, m1396d(str));
        }
    }

    private String m1396d(String str) {
        int length = str.length() / 2;
        return new StringBuilder(String.valueOf(String.valueOf(str.substring(0, length).hashCode()))).append(String.valueOf(str.substring(length).hashCode())).toString();
    }

    public File m1404c(String str) {
        return new File(this.f969c, m1396d(str));
    }

    private void m1387a(int i) {
        if (this.f968b + ((long) i) >= ((long) this.f970d)) {
            int i2;
            if (C0341t.f948b) {
                C0341t.m1367a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f968b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f967a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C0345a c0345a = (C0345a) ((Entry) it.next()).getValue();
                if (m1404c(c0345a.f960b).delete()) {
                    this.f968b -= c0345a.f959a;
                } else {
                    C0341t.m1369b("Could not delete cache entry for key=%s, filename=%s", c0345a.f960b, m1396d(c0345a.f960b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f968b + ((long) i))) < ((float) this.f970d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (C0341t.f948b) {
                C0341t.m1367a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f968b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void m1391a(String str, C0345a c0345a) {
        if (this.f967a.containsKey(str)) {
            this.f968b += c0345a.f959a - ((C0345a) this.f967a.get(str)).f959a;
        } else {
            this.f968b += c0345a.f959a;
        }
        this.f967a.put(str, c0345a);
    }

    private void m1399e(String str) {
        C0345a c0345a = (C0345a) this.f967a.get(str);
        if (c0345a != null) {
            this.f968b -= c0345a.f959a;
            this.f967a.remove(str);
        }
    }

    private static byte[] m1393a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    private static int m1398e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void m1388a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    static int m1386a(InputStream inputStream) throws IOException {
        return ((((C0347w.m1398e(inputStream) << 0) | 0) | (C0347w.m1398e(inputStream) << 8)) | (C0347w.m1398e(inputStream) << 16)) | (C0347w.m1398e(inputStream) << 24);
    }

    static void m1389a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long m1394b(InputStream inputStream) throws IOException {
        return (((((((0 | ((((long) C0347w.m1398e(inputStream)) & 255) << null)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 8)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 16)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 24)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 32)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 40)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 48)) | ((((long) C0347w.m1398e(inputStream)) & 255) << 56);
    }

    static void m1390a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        C0347w.m1389a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String m1395c(InputStream inputStream) throws IOException {
        return new String(C0347w.m1393a(inputStream, (int) C0347w.m1394b(inputStream)), "UTF-8");
    }

    static void m1392a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            C0347w.m1388a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                C0347w.m1390a(outputStream, (String) entry.getKey());
                C0347w.m1390a(outputStream, (String) entry.getValue());
            }
            return;
        }
        C0347w.m1388a(outputStream, 0);
    }

    static Map<String, String> m1397d(InputStream inputStream) throws IOException {
        Map<String, String> emptyMap;
        int a = C0347w.m1386a(inputStream);
        if (a == 0) {
            emptyMap = Collections.emptyMap();
        } else {
            emptyMap = new HashMap(a);
        }
        for (int i = 0; i < a; i++) {
            emptyMap.put(C0347w.m1395c(inputStream).intern(), C0347w.m1395c(inputStream).intern());
        }
        return emptyMap;
    }
}
