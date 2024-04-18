package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final C0430b<?, O> Jm;
    private final C0490c<?> Jn;
    private final ArrayList<Scope> Jo;

    /* renamed from: com.google.android.gms.common.api.Api.b */
    public interface C0430b<T extends C0489a, O> {
        T m1606a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api.a */
    public interface C0489a {
        void connect();

        void disconnect();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api.c */
    public static final class C0490c<C extends C0489a> {
    }

    public <C extends C0489a> Api(C0430b<C, O> c0430b, C0490c<C> c0490c, Scope... scopeArr) {
        this.Jm = c0430b;
        this.Jn = c0490c;
        this.Jo = new ArrayList(Arrays.asList(scopeArr));
    }

    public final C0430b<?, O> gx() {
        return this.Jm;
    }

    public final List<Scope> gy() {
        return this.Jo;
    }

    public final C0490c<?> gz() {
        return this.Jn;
    }
}
