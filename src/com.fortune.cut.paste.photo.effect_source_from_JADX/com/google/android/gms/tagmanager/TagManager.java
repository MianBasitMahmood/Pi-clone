package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C1746b;
import com.google.android.gms.tagmanager.ce.C1770a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager atW;
    private final DataLayer aqn;
    private final C1824r asD;
    private final C1749a atT;
    private final cx atU;
    private final ConcurrentMap<C1814n, Boolean> atV;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C17481 implements C1746b {
        final /* synthetic */ TagManager atX;

        C17481(TagManager tagManager) {
            this.atX = tagManager;
        }

        public void m6389C(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.atX.cV(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.a */
    interface C1749a {
        C1821o m6390a(Context context, TagManager tagManager, Looper looper, String str, int i, C1824r c1824r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C17502 implements C1749a {
        C17502() {
        }

        public final C1821o m6391a(Context context, TagManager tagManager, Looper looper, String str, int i, C1824r c1824r) {
            return new C1821o(context, tagManager, looper, str, i, c1824r);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    class C17513 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager atX;

        C17513(TagManager tagManager) {
            this.atX = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.atX.dispatch();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.4 */
    static /* synthetic */ class C17524 {
        static final /* synthetic */ int[] atY;

        static {
            atY = new int[C1770a.values().length];
            try {
                atY[C1770a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                atY[C1770a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                atY[C1770a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    TagManager(Context context, C1749a c1749a, DataLayer dataLayer, cx cxVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.atU = cxVar;
        this.atT = c1749a;
        this.atV = new ConcurrentHashMap();
        this.aqn = dataLayer;
        this.aqn.m6383a(new C17481(this));
        this.aqn.m6383a(new C1799d(this.mContext));
        this.asD = new C1824r();
        qP();
    }

    private void cV(String str) {
        for (C1814n cr : this.atV.keySet()) {
            cr.cr(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (atW == null) {
                if (context == null) {
                    bh.m6458T("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                atW = new TagManager(context, new C17502(), new DataLayer(new C1832v(context)), cy.qN());
            }
            tagManager = atW;
        }
        return tagManager;
    }

    private void qP() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C17513(this));
        }
    }

    void m6393a(C1814n c1814n) {
        this.atV.put(c1814n, Boolean.valueOf(true));
    }

    boolean m6394b(C1814n c1814n) {
        return this.atV.remove(c1814n) != null;
    }

    public void dispatch() {
        this.atU.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.aqn;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m6395i(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.ce.qa();	 Catch:{ all -> 0x0049 }
        r0 = r1.m6509i(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C17524.atY;	 Catch:{ all -> 0x0049 }
        r3 = r1.qb();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.atV;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1814n) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.ct(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.atV;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1814n) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.qc();	 Catch:{ all -> 0x0049 }
        r0.ct(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.pl();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.ct(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.i(android.net.Uri):boolean");
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        PendingResult a = this.atT.m6390a(this.mContext, this, null, str, i, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        PendingResult a = this.atT.m6390a(this.mContext, this, handler.getLooper(), str, i, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        PendingResult a = this.atT.m6390a(this.mContext, this, null, str, i, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        PendingResult a = this.atT.m6390a(this.mContext, this, handler.getLooper(), str, i, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        PendingResult a = this.atT.m6390a(this.mContext, this, null, str, i, this.asD);
        a.pp();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        PendingResult a = this.atT.m6390a(this.mContext, this, handler.getLooper(), str, i, this.asD);
        a.pp();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        bh.setLogLevel(z ? 2 : 5);
    }
}
