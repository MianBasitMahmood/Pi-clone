package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C1048c.C1043f;
import com.google.android.gms.internal.pu.C1446a;
import com.google.android.gms.internal.qv;
import com.google.android.gms.tagmanager.C1821o.C1778f;
import com.google.android.gms.tagmanager.cr.C1782c;
import com.google.android.gms.tagmanager.cr.C1786g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cq implements C1778f {
    private final String aqm;
    private bg<C1446a> asC;
    private final ExecutorService asJ;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cq.1 */
    class C17761 implements Runnable {
        final /* synthetic */ cq asK;

        C17761(cq cqVar) {
            this.asK = cqVar;
        }

        public void run() {
            this.asK.qi();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.2 */
    class C17772 implements Runnable {
        final /* synthetic */ cq asK;
        final /* synthetic */ C1446a asL;

        C17772(cq cqVar, C1446a c1446a) {
            this.asK = cqVar;
            this.asL = c1446a;
        }

        public void run() {
            this.asK.m6530c(this.asL);
        }
    }

    cq(Context context, String str) {
        this.mContext = context;
        this.aqm = str;
        this.asJ = Executors.newSingleThreadExecutor();
    }

    private C1782c m6525a(ByteArrayOutputStream byteArrayOutputStream) {
        C1782c c1782c = null;
        try {
            c1782c = ba.cI(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m6457S("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            bh.m6461W("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c1782c;
    }

    private void m6526d(C1446a c1446a) throws IllegalArgumentException {
        if (c1446a.gs == null && c1446a.auC == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private C1782c m6527k(byte[] bArr) {
        try {
            C1782c b = cr.m6546b(C1043f.m4307a(bArr));
            if (b == null) {
                return b;
            }
            bh.m6460V("The container was successfully loaded from the resource (using binary file)");
            return b;
        } catch (qv e) {
            bh.m6458T("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (C1786g e2) {
            bh.m6461W("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public void m6528a(bg<C1446a> bgVar) {
        this.asC = bgVar;
    }

    public void m6529b(C1446a c1446a) {
        this.asJ.execute(new C17772(this, c1446a));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m6530c(com.google.android.gms.internal.pu.C1446a r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.qj();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.qw.m2145f(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0014:
        r0 = 1;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.bh.m6458T(r1);
        goto L_0x0015;
    L_0x001d:
        r0 = move-exception;
        r0 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m6461W(r0);
        goto L_0x0014;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.bh.m6461W(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m6461W(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m6461W(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.c(com.google.android.gms.internal.pu$a):boolean");
    }

    public C1782c fH(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            bh.m6460V("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cr.m6547b(openRawResource, byteArrayOutputStream);
                C1782c a = m6525a(byteArrayOutputStream);
                if (a == null) {
                    return m6527k(byteArrayOutputStream.toByteArray());
                }
                bh.m6460V("The container was successfully loaded from the resource (using JSON file format)");
                return a;
            } catch (IOException e) {
                bh.m6461W("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (NotFoundException e2) {
            bh.m6461W("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    public void pt() {
        this.asJ.execute(new C17761(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void qi() {
        /*
        r3 = this;
        r0 = r3.asC;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "Callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.asC;
        r0.ps();
        r0 = "Attempting to load resource from disk";
        com.google.android.gms.tagmanager.bh.m6460V(r0);
        r0 = com.google.android.gms.tagmanager.ce.qa();
        r0 = r0.qb();
        r1 = com.google.android.gms.tagmanager.ce.C1770a.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.ce.qa();
        r0 = r0.qb();
        r1 = com.google.android.gms.tagmanager.ce.C1770a.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.aqm;
        r1 = com.google.android.gms.tagmanager.ce.qa();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.asC;
        r1 = com.google.android.gms.tagmanager.bg.C1763a.NOT_AVAILABLE;
        r0.m6455a(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = r3.qj();	 Catch:{ FileNotFoundException -> 0x0070 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0070 }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0.<init>();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        com.google.android.gms.tagmanager.cr.m6547b(r1, r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r0 = com.google.android.gms.internal.pu.C1446a.m5809l(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r3.m6526d(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2 = r3.asC;	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r2.m6456l(r0);	 Catch:{ IOException -> 0x0085, IllegalArgumentException -> 0x009d }
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x006a:
        r0 = "The Disk resource was successfully read.";
        com.google.android.gms.tagmanager.bh.m6460V(r0);
        goto L_0x0045;
    L_0x0070:
        r0 = move-exception;
        r0 = "Failed to find the resource in the disk";
        com.google.android.gms.tagmanager.bh.m6457S(r0);
        r0 = r3.asC;
        r1 = com.google.android.gms.tagmanager.bg.C1763a.NOT_AVAILABLE;
        r0.m6455a(r1);
        goto L_0x0045;
    L_0x007e:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m6461W(r0);
        goto L_0x006a;
    L_0x0085:
        r0 = move-exception;
        r0 = r3.asC;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.bg.C1763a.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.m6455a(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk";
        com.google.android.gms.tagmanager.bh.m6461W(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x006a;
    L_0x0096:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m6461W(r0);
        goto L_0x006a;
    L_0x009d:
        r0 = move-exception;
        r0 = r3.asC;	 Catch:{ all -> 0x00b5 }
        r2 = com.google.android.gms.tagmanager.bg.C1763a.IO_ERROR;	 Catch:{ all -> 0x00b5 }
        r0.m6455a(r2);	 Catch:{ all -> 0x00b5 }
        r0 = "Failed to read the resource from disk. The resource is inconsistent";
        com.google.android.gms.tagmanager.bh.m6461W(r0);	 Catch:{ all -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x00ae }
        goto L_0x006a;
    L_0x00ae:
        r0 = move-exception;
        r0 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m6461W(r0);
        goto L_0x006a;
    L_0x00b5:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00b9:
        throw r0;
    L_0x00ba:
        r1 = move-exception;
        r1 = "Error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m6461W(r1);
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.qi():void");
    }

    File qj() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.aqm);
    }

    public synchronized void release() {
        this.asJ.shutdown();
    }
}
