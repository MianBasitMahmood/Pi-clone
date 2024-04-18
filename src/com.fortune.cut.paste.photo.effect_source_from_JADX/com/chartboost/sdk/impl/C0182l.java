package com.chartboost.sdk.impl;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.chartboost.sdk.impl.C0230b.C0229a;
import com.chartboost.sdk.impl.C0336n.C0096a;
import com.chartboost.sdk.impl.C0341t.C0340a;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.chartboost.sdk.impl.l */
public abstract class C0182l<T> implements Comparable<C0182l<T>> {
    private final C0340a f319a;
    private final int f320b;
    private final String f321c;
    private final int f322d;
    private final C0096a f323e;
    private Integer f324f;
    private C0335m f325g;
    private boolean f326h;
    private boolean f327i;
    private boolean f328j;
    private long f329k;
    private C0302p f330l;
    private C0229a f331m;
    private Object f332n;

    /* renamed from: com.chartboost.sdk.impl.l.1 */
    class C03311 implements Runnable {
        final /* synthetic */ C0182l f916a;
        private final /* synthetic */ String f917b;
        private final /* synthetic */ long f918c;

        C03311(C0182l c0182l, String str, long j) {
            this.f916a = c0182l;
            this.f917b = str;
            this.f918c = j;
        }

        public void run() {
            this.f916a.f319a.m1366a(this.f917b, this.f918c);
            this.f916a.f319a.m1365a(toString());
        }
    }

    /* renamed from: com.chartboost.sdk.impl.l.a */
    public enum C0332a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract C0336n<T> m543a(C0328i c0328i);

    protected abstract void m548b(T t);

    public /* synthetic */ int compareTo(Object obj) {
        return m537a((C0182l) obj);
    }

    public C0182l(int i, String str, C0096a c0096a) {
        C0340a c0340a;
        if (C0340a.f944a) {
            c0340a = new C0340a();
        } else {
            c0340a = null;
        }
        this.f319a = c0340a;
        this.f326h = true;
        this.f327i = false;
        this.f328j = false;
        this.f329k = 0;
        this.f331m = null;
        this.f320b = i;
        this.f321c = str;
        this.f323e = c0096a;
        m541a(new C0303d());
        this.f322d = C0182l.m535c(str);
    }

    public int m536a() {
        return this.f320b;
    }

    public C0182l<?> m542a(Object obj) {
        this.f332n = obj;
        return this;
    }

    public Object m546b() {
        return this.f332n;
    }

    public int m550c() {
        return this.f322d;
    }

    private static int m535c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public C0182l<?> m541a(C0302p c0302p) {
        this.f330l = c0302p;
        return this;
    }

    public void m545a(String str) {
        if (C0340a.f944a) {
            this.f319a.m1366a(str, Thread.currentThread().getId());
        } else if (this.f329k == 0) {
            this.f329k = SystemClock.elapsedRealtime();
        }
    }

    void m549b(String str) {
        if (this.f325g != null) {
            this.f325g.m1359b(this);
        }
        if (C0340a.f944a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C03311(this, str, id));
                return;
            }
            this.f319a.m1366a(str, id);
            this.f319a.m1365a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f329k >= 3000) {
            C0341t.m1369b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f329k), toString());
        }
    }

    public C0182l<?> m540a(C0335m c0335m) {
        this.f325g = c0335m;
        return this;
    }

    public final C0182l<?> m538a(int i) {
        this.f324f = Integer.valueOf(i);
        return this;
    }

    public String m551d() {
        return this.f321c;
    }

    public String m552e() {
        return m551d();
    }

    public C0182l<?> m539a(C0229a c0229a) {
        this.f331m = c0229a;
        return this;
    }

    public C0229a m553f() {
        return this.f331m;
    }

    public void m554g() {
        this.f327i = true;
    }

    public boolean m555h() {
        return this.f327i;
    }

    public Map<String, String> m556i() throws C0179a {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> m557j() throws C0179a {
        return m561n();
    }

    @Deprecated
    protected String m558k() {
        return m562o();
    }

    @Deprecated
    public String m559l() {
        return m563p();
    }

    @Deprecated
    public byte[] m560m() throws C0179a {
        Map j = m557j();
        if (j == null || j.size() <= 0) {
            return null;
        }
        return m533a(j, m558k());
    }

    protected Map<String, String> m561n() throws C0179a {
        return null;
    }

    protected String m562o() {
        return "UTF-8";
    }

    public String m563p() {
        return "application/x-www-form-urlencoded; charset=" + m562o();
    }

    public byte[] m564q() throws C0179a {
        Map n = m561n();
        if (n == null || n.size() <= 0) {
            return null;
        }
        return m533a(n, m562o());
    }

    private byte[] m533a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public final boolean m565r() {
        return this.f326h;
    }

    public C0332a m566s() {
        return C0332a.NORMAL;
    }

    public final int m567t() {
        return this.f330l.m1293a();
    }

    public C0302p m568u() {
        return this.f330l;
    }

    public void m569v() {
        this.f328j = true;
    }

    public boolean m570w() {
        return this.f328j;
    }

    protected C0178s m544a(C0178s c0178s) {
        return c0178s;
    }

    public void m547b(C0178s c0178s) {
        if (this.f323e != null) {
            this.f323e.m77a(c0178s);
        }
    }

    public int m537a(C0182l<T> c0182l) {
        C0332a s = m566s();
        C0332a s2 = c0182l.m566s();
        if (s == s2) {
            return this.f324f.intValue() - c0182l.f324f.intValue();
        }
        return s2.ordinal() - s.ordinal();
    }

    public String toString() {
        return new StringBuilder(String.valueOf(this.f327i ? "[X] " : "[ ] ")).append(m551d()).append(" ").append("0x" + Integer.toHexString(m550c())).append(" ").append(m566s()).append(" ").append(this.f324f).toString();
    }
}
