package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.C0831u;
import com.google.android.gms.fitness.request.C0835w.C0834a;
import com.google.android.gms.fitness.request.C0839y.C0838a;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.lu.C1295a;
import com.google.android.gms.internal.lu.C1297b;
import com.google.android.gms.internal.lu.C1298c;
import com.google.android.gms.internal.mb.C1310a;
import com.google.android.gms.internal.mc.C1312a;

public class mn implements SessionsApi {

    /* renamed from: com.google.android.gms.internal.mn.1 */
    class C13421 extends C1298c {
        final /* synthetic */ Session Vv;
        final /* synthetic */ mn Vw;

        C13421(mn mnVar, GoogleApiClient googleApiClient, Session session) {
            this.Vw = mnVar;
            this.Vv = session;
            super(googleApiClient);
        }

        protected void m5483a(lu luVar) throws RemoteException {
            luVar.jM().m5379a(new C0834a().m2774b(this.Vv).kk(), new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.2 */
    class C13432 extends C1295a<SessionStopResult> {
        final /* synthetic */ mn Vw;
        final /* synthetic */ String Vx;
        final /* synthetic */ String val$name;

        C13432(mn mnVar, GoogleApiClient googleApiClient, String str, String str2) {
            this.Vw = mnVar;
            this.val$name = str;
            this.Vx = str2;
            super(googleApiClient);
        }

        protected SessionStopResult m5484A(Status status) {
            return SessionStopResult.m2796H(status);
        }

        protected void m5486a(lu luVar) throws RemoteException {
            luVar.jM().m5380a(new C0838a().bx(this.val$name).by(this.Vx).kl(), new C1349b(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5487c(Status status) {
            return m5484A(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.3 */
    class C13443 extends C1298c {
        final /* synthetic */ mn Vw;
        final /* synthetic */ SessionInsertRequest Vy;

        C13443(mn mnVar, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
            this.Vw = mnVar;
            this.Vy = sessionInsertRequest;
            super(googleApiClient);
        }

        protected void m5489a(lu luVar) throws RemoteException {
            luVar.jM().m5364a(this.Vy, new C1297b(this), luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.4 */
    class C13454 extends C1295a<SessionReadResult> {
        final /* synthetic */ mn Vw;
        final /* synthetic */ SessionReadRequest Vz;

        C13454(mn mnVar, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
            this.Vw = mnVar;
            this.Vz = sessionReadRequest;
            super(googleApiClient);
        }

        protected SessionReadResult m5490B(Status status) {
            return SessionReadResult.m2794G(status);
        }

        protected void m5492a(lu luVar) throws RemoteException {
            luVar.jM().m5365a(this.Vz, new C1348a(null), luVar.getContext().getPackageName());
        }

        protected /* synthetic */ Result m5493c(Status status) {
            return m5490B(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.5 */
    class C13465 extends C1298c {
        final /* synthetic */ PendingIntent VA;
        final /* synthetic */ mn Vw;

        C13465(mn mnVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.Vw = mnVar;
            this.VA = pendingIntent;
            super(googleApiClient);
        }

        protected void m5495a(lu luVar) throws RemoteException {
            md c1297b = new C1297b(this);
            luVar.jM().m5378a(new C0831u(this.VA), c1297b, luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.6 */
    class C13476 extends C1298c {
        final /* synthetic */ PendingIntent VA;
        final /* synthetic */ mn Vw;

        C13476(mn mnVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.Vw = mnVar;
            this.VA = pendingIntent;
            super(googleApiClient);
        }

        protected void m5497a(lu luVar) throws RemoteException {
            md c1297b = new C1297b(this);
            luVar.jM().m5367a(new aa(this.VA), c1297b, luVar.getContext().getPackageName());
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.a */
    private static class C1348a extends C1310a {
        private final C0433b<SessionReadResult> Ea;

        private C1348a(C0433b<SessionReadResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5498a(SessionReadResult sessionReadResult) throws RemoteException {
            this.Ea.m1609b(sessionReadResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.mn.b */
    private static class C1349b extends C1312a {
        private final C0433b<SessionStopResult> Ea;

        private C1349b(C0433b<SessionStopResult> c0433b) {
            this.Ea = c0433b;
        }

        public void m5499a(SessionStopResult sessionStopResult) {
            this.Ea.m1609b(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> m5500a(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.m1806b(new C13432(this, googleApiClient, str, str2));
    }

    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.m1804a(new C13443(this, googleApiClient, sessionInsertRequest));
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
        return googleApiClient.m1804a(new C13454(this, googleApiClient, sessionReadRequest));
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13465(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session) {
        return googleApiClient.m1806b(new C13421(this, googleApiClient, session));
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return m5500a(googleApiClient, null, str);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.m1806b(new C13476(this, googleApiClient, pendingIntent));
    }
}
