package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1415a;
import com.google.android.gms.plus.internal.C1731e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class pb implements Moments {

    /* renamed from: com.google.android.gms.internal.pb.a */
    private static abstract class C1421a extends C1415a<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.pb.a.1 */
        class C14281 implements LoadMomentsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C1421a aog;

            C14281(C1421a c1421a, Status status) {
                this.aog = c1421a;
                this.DS = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        private C1421a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult aB(Status status) {
            return new C14281(this, status);
        }

        public /* synthetic */ Result m5748c(Status status) {
            return aB(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.1 */
    class C14221 extends C1421a {
        final /* synthetic */ pb anZ;

        C14221(pb pbVar, GoogleApiClient googleApiClient) {
            this.anZ = pbVar;
            super(null);
        }

        protected void m5750a(C1731e c1731e) {
            c1731e.m6347j(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.2 */
    class C14232 extends C1421a {
        final /* synthetic */ int aaI;
        final /* synthetic */ pb anZ;
        final /* synthetic */ String aoa;
        final /* synthetic */ Uri aob;
        final /* synthetic */ String aoc;
        final /* synthetic */ String aod;

        C14232(pb pbVar, GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
            this.anZ = pbVar;
            this.aaI = i;
            this.aoa = str;
            this.aob = uri;
            this.aoc = str2;
            this.aod = str3;
            super(null);
        }

        protected void m5752a(C1731e c1731e) {
            c1731e.m6342a(this, this.aaI, this.aoa, this.aob, this.aoc, this.aod);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.c */
    private static abstract class C1424c extends C1415a<Status> {
        private C1424c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5753b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5754c(Status status) {
            return m5753b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.3 */
    class C14253 extends C1424c {
        final /* synthetic */ pb anZ;
        final /* synthetic */ Moment aoe;

        C14253(pb pbVar, GoogleApiClient googleApiClient, Moment moment) {
            this.anZ = pbVar;
            this.aoe = moment;
            super(null);
        }

        protected void m5756a(C1731e c1731e) {
            c1731e.m6343a((C0433b) this, this.aoe);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.b */
    private static abstract class C1426b extends C1415a<Status> {
        private C1426b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m5757b(Status status) {
            return status;
        }

        public /* synthetic */ Result m5758c(Status status) {
            return m5757b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb.4 */
    class C14274 extends C1426b {
        final /* synthetic */ pb anZ;
        final /* synthetic */ String aof;

        C14274(pb pbVar, GoogleApiClient googleApiClient, String str) {
            this.anZ = pbVar;
            this.aof = str;
            super(null);
        }

        protected void m5760a(C1731e c1731e) {
            c1731e.removeMoment(this.aof);
            m1615b(Status.Kw);
        }
    }

    public final PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C14221(this, googleApiClient));
    }

    public final PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
        return googleApiClient.m1804a(new C14232(this, googleApiClient, i, str, uri, str2, str3));
    }

    public final PendingResult<Status> remove(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C14274(this, googleApiClient, str));
    }

    public final PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.m1806b(new C14253(this, googleApiClient, moment));
    }
}
