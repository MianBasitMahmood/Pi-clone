package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C0757g<T> {
    private final String TI;
    private T TJ;

    /* renamed from: com.google.android.gms.dynamic.g.a */
    public static class C0756a extends Exception {
        public C0756a(String str) {
            super(str);
        }

        public C0756a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0757g(String str) {
        this.TI = str;
    }

    protected final T m2595L(Context context) throws C0756a {
        if (this.TJ == null) {
            jx.m5223i(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0756a("Could not get remote context.");
            }
            try {
                this.TJ = m2596d((IBinder) remoteContext.getClassLoader().loadClass(this.TI).newInstance());
            } catch (Throwable e) {
                throw new C0756a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C0756a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C0756a("Could not access creator.", e22);
            }
        }
        return this.TJ;
    }

    protected abstract T m2596d(IBinder iBinder);
}
