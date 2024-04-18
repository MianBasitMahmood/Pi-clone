package com.chartboost.sdk.impl;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.chartboost.sdk.impl.C0230b.C0229a;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.chartboost.sdk.impl.u */
public class C0342u implements C0325f {
    protected static final boolean f949a;
    private static int f950d;
    private static int f951e;
    protected final C0181z f952b;
    protected final C0344v f953c;

    static {
        f949a = C0341t.f948b;
        f950d = GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE;
        f951e = AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD;
    }

    public C0342u(C0181z c0181z) {
        this(c0181z, new C0344v(f951e));
    }

    public C0342u(C0181z c0181z, C0344v c0344v) {
        this.f952b = c0181z;
        this.f953c = c0344v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.chartboost.sdk.impl.C0328i m1377a(com.chartboost.sdk.impl.C0182l<?> r12) throws com.chartboost.sdk.impl.C0178s {
        /*
        r11 = this;
        r8 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r2 = 0;
        r4 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r3 = r12.m553f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r11.m1375a(r0, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r3 = r11.f952b;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r7 = r3.m526a(r12, r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r5 = r7.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r10 = r5.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r0 = r7.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r6 = com.chartboost.sdk.impl.C0342u.m1372a(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r10 != r0) goto L_0x0048;
    L_0x0031:
        r0 = new com.chartboost.sdk.impl.i;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r1 = r12.m553f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        if (r1 != 0) goto L_0x0041;
    L_0x003b:
        r1 = 0;
    L_0x003c:
        r3 = 1;
        r0.<init>(r2, r1, r6, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x0040:
        return r0;
    L_0x0041:
        r1 = r12.m553f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r1 = r1.f594a;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x003c;
    L_0x0048:
        r0 = r7.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        if (r0 == 0) goto L_0x007b;
    L_0x004e:
        r0 = r7.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r4 = r11.m1376a(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x0056:
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r1 = r0 - r8;
        r0 = r11;
        r3 = r12;
        r0.m1373a(r1, r3, r4, r5);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 < r0) goto L_0x0069;
    L_0x0065:
        r0 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r10 <= r0) goto L_0x007f;
    L_0x0069:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x006f:
        r0 = move-exception;
        r0 = "socket";
        r1 = new com.chartboost.sdk.impl.r;
        r1.<init>();
        com.chartboost.sdk.impl.C0342u.m1374a(r0, r12, r1);
        goto L_0x0004;
    L_0x007b:
        r0 = 0;
        r4 = new byte[r0];	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x0056;
    L_0x007f:
        r0 = new com.chartboost.sdk.impl.i;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r1 = 0;
        r0.<init>(r10, r4, r6, r1);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x0040;
    L_0x0086:
        r0 = move-exception;
        r0 = "connection";
        r1 = new com.chartboost.sdk.impl.r;
        r1.<init>();
        com.chartboost.sdk.impl.C0342u.m1374a(r0, r12, r1);
        goto L_0x0004;
    L_0x0093:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Bad URL ";
        r2.<init>(r3);
        r3 = r12.m551d();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00ad:
        r0 = move-exception;
    L_0x00ae:
        if (r2 == 0) goto L_0x00ea;
    L_0x00b0:
        r0 = r2.getStatusLine();
        r0 = r0.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r0);
        r3[r5] = r6;
        r5 = 1;
        r6 = r12.m551d();
        r3[r5] = r6;
        com.chartboost.sdk.impl.C0341t.m1370c(r2, r3);
        r2 = new com.chartboost.sdk.impl.i;
        r3 = 0;
        r2.<init>(r0, r4, r1, r3);
        if (r4 == 0) goto L_0x00f6;
    L_0x00d6:
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x00de;
    L_0x00da:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x00f0;
    L_0x00de:
        r0 = "auth";
        r1 = new com.chartboost.sdk.impl.a;
        r1.<init>(r2);
        com.chartboost.sdk.impl.C0342u.m1374a(r0, r12, r1);
        goto L_0x0004;
    L_0x00ea:
        r1 = new com.chartboost.sdk.impl.j;
        r1.<init>(r0);
        throw r1;
    L_0x00f0:
        r0 = new com.chartboost.sdk.impl.q;
        r0.<init>(r2);
        throw r0;
    L_0x00f6:
        r0 = new com.chartboost.sdk.impl.h;
        r0.<init>(r2);
        throw r0;
    L_0x00fc:
        r0 = move-exception;
        r2 = r7;
        goto L_0x00ae;
    L_0x00ff:
        r0 = move-exception;
        r1 = r6;
        r2 = r7;
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.u.a(com.chartboost.sdk.impl.l):com.chartboost.sdk.impl.i");
    }

    private void m1373a(long j, C0182l<?> c0182l, byte[] bArr, StatusLine statusLine) {
        if (f949a || j > ((long) f950d)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = c0182l;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(c0182l.m568u().m1295b());
            C0341t.m1369b(str, objArr);
        }
    }

    private static void m1374a(String str, C0182l<?> c0182l, C0178s c0178s) throws C0178s {
        C0302p u = c0182l.m568u();
        int t = c0182l.m567t();
        try {
            u.m1294a(c0178s);
            c0182l.m545a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
        } catch (C0178s e) {
            c0182l.m545a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
            throw e;
        }
    }

    private void m1375a(Map<String, String> map, C0229a c0229a) {
        if (c0229a != null) {
            if (c0229a.f595b != null) {
                map.put("If-None-Match", c0229a.f595b);
            }
            if (c0229a.f596c > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c0229a.f596c)));
            }
        }
    }

    private byte[] m1376a(HttpEntity httpEntity) throws IOException, C0337q {
        ac acVar = new ac(this.f953c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new C0337q();
            }
            bArr = this.f953c.m1381a((int) AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                acVar.write(bArr, 0, read);
            }
            byte[] toByteArray = acVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C0341t.m1367a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f953c.m1380a(bArr);
            acVar.close();
        }
    }

    private static Map<String, String> m1372a(Header[] headerArr) {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
