package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.impl.cc;
import java.io.File;

/* renamed from: com.chartboost.sdk.Libraries.h */
public class C0132h {
    private static C0132h f133f;
    public Context f134a;
    private File f135b;
    private File f136c;
    private File f137d;
    private boolean f138e;

    public C0132h(String str, boolean z) {
        this.f134a = C0153b.m400l();
        if (this.f134a == null) {
            throw new RuntimeException("Cannot find context object");
        }
        this.f138e = this.f134a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (str != null) {
            this.f135b = m229a(str, z);
        } else {
            this.f135b = m229a("CBCommonCacheFolder", z);
        }
    }

    private File m229a(String str, boolean z) {
        if (this.f135b != null) {
            return this.f135b;
        }
        File file;
        if (z && m231d()) {
            file = new File(new File(this.f134a.getExternalCacheDir(), "__chartboost"), str);
            this.f137d = file;
        } else {
            file = new File(new File(this.f134a.getCacheDir(), "__chartboost"), str);
            this.f136c = file;
        }
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public synchronized void m236a(String str, C0111a c0111a) {
        if (this.f137d == null || m231d()) {
            if (this.f135b != null) {
                File file = null;
                if (!TextUtils.isEmpty(str)) {
                    file = new File(this.f135b.getPath(), str);
                }
                m234a(file, c0111a);
            }
        }
    }

    public synchronized File m234a(File file, C0111a c0111a) {
        File file2 = null;
        synchronized (this) {
            if (this.f137d == null || m231d()) {
                if (this.f135b != null) {
                    if (file == null) {
                        file2 = new File(this.f135b.getPath(), Long.toString(System.nanoTime()));
                    } else {
                        file2 = file;
                    }
                    try {
                        cc.m1187a(file2, c0111a.toString().getBytes());
                    } catch (Throwable e) {
                        CBLogging.m102b("CBFileCache", "IOException attempting to write cache to disk", e);
                    }
                }
            }
        }
        return file2;
    }

    public synchronized void m237a(String str, byte[] bArr) {
        if (this.f137d == null || m231d()) {
            if (this.f135b != null) {
                File file = null;
                if (!TextUtils.isEmpty(str)) {
                    file = new File(this.f135b.getPath(), str);
                }
                m235a(file, bArr);
            }
        }
    }

    public synchronized void m235a(File file, byte[] bArr) {
        if (this.f137d == null || m231d()) {
            if (!(this.f135b == null || bArr == null)) {
                if (file == null) {
                    file = new File(this.f135b.getPath(), Long.toString(System.nanoTime()));
                }
                try {
                    cc.m1187a(file, bArr);
                } catch (Throwable e) {
                    CBLogging.m102b("CBFileCache", "IOException attempting to write cache to disk", e);
                }
            }
        }
    }

    public synchronized C0111a m233a(String str) {
        C0111a c0111a;
        if (this.f137d != null && !m231d()) {
            c0111a = C0111a.f95a;
        } else if (this.f135b == null || str == null) {
            c0111a = C0111a.f95a;
        } else {
            File file = new File(this.f135b, str);
            if (file.exists()) {
                c0111a = m232a(file);
            } else {
                c0111a = C0111a.f95a;
            }
        }
        return c0111a;
    }

    public synchronized C0111a m232a(File file) {
        C0111a c0111a;
        if (this.f137d != null && !m231d()) {
            c0111a = C0111a.f95a;
        } else if (this.f135b == null) {
            c0111a = C0111a.f95a;
        } else {
            String str;
            try {
                str = new String(cc.m1189b(file));
            } catch (Throwable e) {
                CBLogging.m102b("CBFileCache", "Error loading cache from disk", e);
                str = null;
            }
            c0111a = C0111a.m147j(str);
        }
        return c0111a;
    }

    public synchronized byte[] m241b(File file) {
        byte[] bArr = null;
        synchronized (this) {
            if (this.f137d == null || m231d()) {
                if (this.f135b != null) {
                    try {
                        bArr = cc.m1189b(file);
                    } catch (Throwable e) {
                        CBLogging.m102b("CBFileCache", "Error loading cache from disk", e);
                    }
                }
            }
        }
        return bArr;
    }

    public synchronized String[] m238a() {
        String[] strArr = null;
        synchronized (this) {
            if (this.f137d == null || m231d()) {
                if (this.f135b != null) {
                    strArr = this.f135b.list();
                }
            }
        }
        return strArr;
    }

    public synchronized void m242c(File file) {
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public synchronized void m240b(String str) {
        if (!TextUtils.isEmpty(str)) {
            m242c(m244d(str));
        }
    }

    public synchronized void m239b() {
        int i = 0;
        synchronized (this) {
            if (this.f137d == null || m231d()) {
                if (this.f135b != null) {
                    try {
                        if (this.f137d != null) {
                            File[] listFiles = this.f137d.listFiles();
                            if (listFiles != null) {
                                for (File delete : listFiles) {
                                    delete.delete();
                                }
                            }
                        }
                        if (this.f136c != null) {
                            File[] listFiles2 = this.f136c.listFiles();
                            if (listFiles2 != null) {
                                int length = listFiles2.length;
                                while (i < length) {
                                    listFiles2[i].delete();
                                    i++;
                                }
                            }
                        }
                    } catch (Exception e) {
                        CBLogging.m101b("CBFileCache", "Error while clearing the file cache");
                    }
                }
            }
        }
    }

    private boolean m231d() {
        if (this.f138e && Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public boolean m243c(String str) {
        if ((this.f137d != null && !m231d()) || this.f135b == null || str == null) {
            return false;
        }
        return new File(this.f135b.getPath(), str).exists();
    }

    public File m244d(String str) {
        if ((this.f137d == null || m231d()) && this.f135b != null) {
            return new File(this.f135b.getPath(), str);
        }
        return null;
    }

    public static synchronized C0132h m230c() {
        C0132h c0132h;
        synchronized (C0132h.class) {
            if (f133f == null) {
                f133f = new C0132h("CBVideoCompletion", false);
            }
            c0132h = f133f;
        }
        return c0132h;
    }
}
