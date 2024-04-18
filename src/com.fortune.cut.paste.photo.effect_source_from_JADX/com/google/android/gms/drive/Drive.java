package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0607p;
import com.google.android.gms.drive.internal.C0613r;
import com.google.android.gms.drive.internal.C0624u;
import com.google.android.gms.drive.internal.C0640x;
import com.google.android.gms.drive.internal.C0649z;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API;
    public static final C0490c<C0613r> DQ;
    public static final DriveApi DriveApi;
    public static final DrivePreferencesApi DrivePreferencesApi;
    public static final Scope Oo;
    public static final Scope Op;
    public static final Api<C0548b> Oq;
    public static final C0551b Or;
    public static final C0554e Os;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;

    /* renamed from: com.google.android.gms.drive.Drive.a */
    public static abstract class C0545a<O extends ApiOptions> implements C0430b<C0613r, O> {
        protected abstract Bundle m1987a(O o);

        public C0613r m1989a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List ho = jgVar.ho();
            return new C0613r(context, looper, jgVar, connectionCallbacks, onConnectionFailedListener, (String[]) ho.toArray(new String[ho.size()]), m1987a(o));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C05461 extends C0545a<NoOptions> {
        C05461() {
        }

        protected final Bundle m1990a(NoOptions noOptions) {
            return new Bundle();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.2 */
    static class C05472 extends C0545a<C0548b> {
        C05472() {
        }

        protected final Bundle m1993a(C0548b c0548b) {
            return c0548b == null ? new Bundle() : c0548b.iq();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.b */
    public static class C0548b implements Optional {
        private final Bundle DJ;

        private C0548b() {
            this(new Bundle());
        }

        private C0548b(Bundle bundle) {
            this.DJ = bundle;
        }

        public Bundle iq() {
            return this.DJ;
        }
    }

    static {
        DQ = new C0490c();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        Oo = new Scope("https://www.googleapis.com/auth/drive");
        Op = new Scope("https://www.googleapis.com/auth/drive.apps");
        API = new Api(new C05461(), DQ, new Scope[0]);
        Oq = new Api(new C05472(), DQ, new Scope[0]);
        DriveApi = new C0607p();
        Or = new C0624u();
        Os = new C0649z();
        DrivePreferencesApi = new C0640x();
    }

    private Drive() {
    }
}
