package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1415a;
import com.google.android.gms.plus.internal.C1731e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class pc implements People {

    /* renamed from: com.google.android.gms.internal.pc.a */
    private static abstract class C1429a extends C1415a<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.pc.a.1 */
        class C14351 implements LoadPeopleResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C1429a aol;

            C14351(C1429a c1429a, Status status) {
                this.aol = c1429a;
                this.DS = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private C1429a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult aC(Status status) {
            return new C14351(this, status);
        }

        public /* synthetic */ Result m5761c(Status status) {
            return aC(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pc.1 */
    class C14301 extends C1429a {
        final /* synthetic */ String aoa;
        final /* synthetic */ int aoh;
        final /* synthetic */ pc aoi;

        C14301(pc pcVar, GoogleApiClient googleApiClient, int i, String str) {
            this.aoi = pcVar;
            this.aoh = i;
            this.aoa = str;
            super(null);
        }

        protected void m5763a(C1731e c1731e) {
            m1614a(c1731e.m6340a((C0433b) this, this.aoh, this.aoa));
        }
    }

    /* renamed from: com.google.android.gms.internal.pc.2 */
    class C14312 extends C1429a {
        final /* synthetic */ String aoa;
        final /* synthetic */ pc aoi;

        C14312(pc pcVar, GoogleApiClient googleApiClient, String str) {
            this.aoi = pcVar;
            this.aoa = str;
            super(null);
        }

        protected void m5765a(C1731e c1731e) {
            m1614a(c1731e.m6351q(this, this.aoa));
        }
    }

    /* renamed from: com.google.android.gms.internal.pc.3 */
    class C14323 extends C1429a {
        final /* synthetic */ pc aoi;

        C14323(pc pcVar, GoogleApiClient googleApiClient) {
            this.aoi = pcVar;
            super(null);
        }

        protected void m5767a(C1731e c1731e) {
            c1731e.m6348k(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.pc.4 */
    class C14334 extends C1429a {
        final /* synthetic */ pc aoi;
        final /* synthetic */ Collection aoj;

        C14334(pc pcVar, GoogleApiClient googleApiClient, Collection collection) {
            this.aoi = pcVar;
            this.aoj = collection;
            super(null);
        }

        protected void m5769a(C1731e c1731e) {
            c1731e.m6344a((C0433b) this, this.aoj);
        }
    }

    /* renamed from: com.google.android.gms.internal.pc.5 */
    class C14345 extends C1429a {
        final /* synthetic */ pc aoi;
        final /* synthetic */ String[] aok;

        C14345(pc pcVar, GoogleApiClient googleApiClient, String[] strArr) {
            this.aoi = pcVar;
            this.aok = strArr;
            super(null);
        }

        protected void m5771a(C1731e c1731e) {
            c1731e.m6346d(this, this.aok);
        }
    }

    public final Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m6255a(googleApiClient, Plus.DQ).getCurrentPerson();
    }

    public final PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection) {
        return googleApiClient.m1804a(new C14334(this, googleApiClient, collection));
    }

    public final PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr) {
        return googleApiClient.m1804a(new C14345(this, googleApiClient, strArr));
    }

    public final PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C14323(this, googleApiClient));
    }

    public final PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str) {
        return googleApiClient.m1804a(new C14301(this, googleApiClient, i, str));
    }

    public final PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1804a(new C14312(this, googleApiClient, str));
    }
}
