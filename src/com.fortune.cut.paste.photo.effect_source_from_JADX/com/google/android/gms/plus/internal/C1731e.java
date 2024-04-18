package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1246b;
import com.google.android.gms.internal.jl.C1248d;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C1720d.C1722a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1731e extends jl<C1720d> {
    private Person anG;
    private final C1734h anH;

    /* renamed from: com.google.android.gms.plus.internal.e.a */
    final class C1723a extends C1715a {
        private final C0433b<Status> anI;
        final /* synthetic */ C1731e anJ;

        public C1723a(C1731e c1731e, C0433b<Status> c0433b) {
            this.anJ = c1731e;
            this.anI = c0433b;
        }

        public final void aA(Status status) {
            this.anJ.m2259a(new C1726d(this.anJ, this.anI, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.b */
    final class C1724b extends C1715a {
        private final C0433b<LoadMomentsResult> anI;
        final /* synthetic */ C1731e anJ;

        public C1724b(C1731e c1731e, C0433b<LoadMomentsResult> c0433b) {
            this.anJ = c1731e;
            this.anI = c0433b;
        }

        public final void m6329a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.m2259a(new C1725c(this.anJ, this.anI, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.c */
    final class C1725c extends C1248d<C0433b<LoadMomentsResult>> implements LoadMomentsResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ C1731e anJ;
        private final String anK;
        private MomentBuffer anL;

        public C1725c(C1731e c1731e, C0433b<LoadMomentsResult> c0433b, Status status, DataHolder dataHolder, String str, String str2) {
            this.anJ = c1731e;
            super(c1731e, c0433b, dataHolder);
            this.Eb = status;
            this.OB = str;
            this.anK = str2;
        }

        protected final void m6330a(C0433b<LoadMomentsResult> c0433b, DataHolder dataHolder) {
            this.anL = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0433b.m1609b(this);
        }

        protected final /* synthetic */ void m6331b(Object obj, DataHolder dataHolder) {
            m6330a((C0433b) obj, dataHolder);
        }

        public final MomentBuffer getMomentBuffer() {
            return this.anL;
        }

        public final String getNextPageToken() {
            return this.OB;
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final String getUpdated() {
            return this.anK;
        }

        public final void release() {
            if (this.anL != null) {
                this.anL.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.d */
    final class C1726d extends C1246b<C0433b<Status>> {
        private final Status Eb;
        final /* synthetic */ C1731e anJ;

        public C1726d(C1731e c1731e, C0433b<Status> c0433b, Status status) {
            this.anJ = c1731e;
            super(c1731e, c0433b);
            this.Eb = status;
        }

        protected final /* synthetic */ void m6332g(Object obj) {
            m6333m((C0433b) obj);
        }

        protected final void hx() {
        }

        protected final void m6333m(C0433b<Status> c0433b) {
            if (c0433b != null) {
                c0433b.m1609b(this.Eb);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.e */
    final class C1727e extends C1715a {
        private final C0433b<LoadPeopleResult> anI;
        final /* synthetic */ C1731e anJ;

        public C1727e(C1731e c1731e, C0433b<LoadPeopleResult> c0433b) {
            this.anJ = c1731e;
            this.anI = c0433b;
        }

        public final void m6334a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.m2259a(new C1728f(this.anJ, this.anI, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.f */
    final class C1728f extends C1248d<C0433b<LoadPeopleResult>> implements LoadPeopleResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ C1731e anJ;
        private PersonBuffer anM;

        public C1728f(C1731e c1731e, C0433b<LoadPeopleResult> c0433b, Status status, DataHolder dataHolder, String str) {
            this.anJ = c1731e;
            super(c1731e, c0433b, dataHolder);
            this.Eb = status;
            this.OB = str;
        }

        protected final void m6335a(C0433b<LoadPeopleResult> c0433b, DataHolder dataHolder) {
            this.anM = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0433b.m1609b(this);
        }

        protected final /* synthetic */ void m6336b(Object obj, DataHolder dataHolder) {
            m6335a((C0433b) obj, dataHolder);
        }

        public final String getNextPageToken() {
            return this.OB;
        }

        public final PersonBuffer getPersonBuffer() {
            return this.anM;
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final void release() {
            if (this.anM != null) {
                this.anM.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.g */
    final class C1729g extends C1715a {
        private final C0433b<Status> anI;
        final /* synthetic */ C1731e anJ;

        public C1729g(C1731e c1731e, C0433b<Status> c0433b) {
            this.anJ = c1731e;
            this.anI = c0433b;
        }

        public final void m6337h(int i, Bundle bundle) {
            this.anJ.m2259a(new C1730h(this.anJ, this.anI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.h */
    final class C1730h extends C1246b<C0433b<Status>> {
        private final Status Eb;
        final /* synthetic */ C1731e anJ;

        public C1730h(C1731e c1731e, C0433b<Status> c0433b, Status status) {
            this.anJ = c1731e;
            super(c1731e, c0433b);
            this.Eb = status;
        }

        protected final /* synthetic */ void m6338g(Object obj) {
            m6339m((C0433b) obj);
        }

        protected final void hx() {
        }

        protected final void m6339m(C0433b<Status> c0433b) {
            this.anJ.disconnect();
            if (c0433b != null) {
                c0433b.m1609b(this.Eb);
            }
        }
    }

    public C1731e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C1734h c1734h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c1734h.oz());
        this.anH = c1734h;
    }

    public jr m6340a(C0433b<LoadPeopleResult> c0433b, int i, String str) {
        dS();
        Object c1727e = new C1727e(this, c0433b);
        try {
            return ((C1720d) hw()).m6299a(c1727e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1727e.m6334a(DataHolder.av(8), null);
            return null;
        }
    }

    protected void m6341a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.anG = pi.m5796i(bundle.getByteArray("loaded_person"));
        }
        super.m2258a(i, iBinder, bundle);
    }

    public void m6342a(C0433b<LoadMomentsResult> c0433b, int i, String str, Uri uri, String str2, String str3) {
        dS();
        Object c1724b = c0433b != null ? new C1724b(this, c0433b) : null;
        try {
            ((C1720d) hw()).m6302a(c1724b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1724b.m6329a(DataHolder.av(8), null, null);
        }
    }

    public void m6343a(C0433b<Status> c0433b, Moment moment) {
        dS();
        C1713b c1723a = c0433b != null ? new C1723a(this, c0433b) : null;
        try {
            ((C1720d) hw()).m6304a(c1723a, ky.m5296a((pf) moment));
        } catch (Throwable e) {
            if (c1723a == null) {
                throw new IllegalStateException(e);
            }
            c1723a.aA(new Status(8, null, null));
        }
    }

    public void m6344a(C0433b<LoadPeopleResult> c0433b, Collection<String> collection) {
        dS();
        C1713b c1727e = new C1727e(this, c0433b);
        try {
            ((C1720d) hw()).m6307a(c1727e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1727e.m6334a(DataHolder.av(8), null);
        }
    }

    protected void m6345a(jt jtVar, C1250e c1250e) throws RemoteException {
        Bundle oH = this.anH.oH();
        oH.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.anH.oA());
        oH.putString("auth_package", this.anH.oC());
        jtVar.m5132a((js) c1250e, new jj(2).aX(this.anH.oD()).m5082a(jd.aT(this.anH.getAccountName())).m5083a(lm.m5335d(hv())).m5084e(oH));
    }

    protected String bK() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected C1720d bN(IBinder iBinder) {
        return C1722a.bM(iBinder);
    }

    public boolean cj(String str) {
        return Arrays.asList(hv()).contains(str);
    }

    public void clearDefaultAccount() {
        dS();
        try {
            this.anG = null;
            ((C1720d) hw()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m6346d(C0433b<LoadPeopleResult> c0433b, String[] strArr) {
        m6344a((C0433b) c0433b, Arrays.asList(strArr));
    }

    public String getAccountName() {
        dS();
        try {
            return ((C1720d) hw()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        dS();
        return this.anG;
    }

    public void m6347j(C0433b<LoadMomentsResult> c0433b) {
        m6342a(c0433b, 20, null, null, null, "me");
    }

    public void m6348k(C0433b<LoadPeopleResult> c0433b) {
        dS();
        Object c1727e = new C1727e(this, c0433b);
        try {
            ((C1720d) hw()).m6299a(c1727e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1727e.m6334a(DataHolder.av(8), null);
        }
    }

    protected /* synthetic */ IInterface m6349l(IBinder iBinder) {
        return bN(iBinder);
    }

    public void m6350l(C0433b<Status> c0433b) {
        dS();
        clearDefaultAccount();
        Object c1729g = new C1729g(this, c0433b);
        try {
            ((C1720d) hw()).m6309b(c1729g);
        } catch (RemoteException e) {
            c1729g.m6337h(8, null);
        }
    }

    public jr m6351q(C0433b<LoadPeopleResult> c0433b, String str) {
        return m6340a((C0433b) c0433b, 0, str);
    }

    public void removeMoment(String str) {
        dS();
        try {
            ((C1720d) hw()).removeMoment(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
