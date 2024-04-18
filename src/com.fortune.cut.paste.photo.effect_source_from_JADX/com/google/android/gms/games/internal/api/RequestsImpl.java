package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C09571 implements UpdateRequestsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ UpdateRequestsImpl abE;

            C09571(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.abE = updateRequestsImpl;
                this.DS = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String str) {
                throw new IllegalArgumentException("Unknown request ID " + str);
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult an(Status status) {
            return new C09571(this, status);
        }

        public /* synthetic */ Result m3931c(Status status) {
            return an(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C09461 extends UpdateRequestsImpl {
        final /* synthetic */ String[] abt;
        final /* synthetic */ RequestsImpl abu;

        C09461(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, String[] strArr) {
            this.abu = requestsImpl;
            this.abt = strArr;
            super(null);
        }

        protected void m3933a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3182b((C0433b) this, this.abt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C09472 extends UpdateRequestsImpl {
        final /* synthetic */ String[] abt;
        final /* synthetic */ RequestsImpl abu;

        C09472(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, String[] strArr) {
            this.abu = requestsImpl;
            this.abt = strArr;
            super(null);
        }

        protected void m3935a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3194c((C0433b) this, this.abt);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C09551 implements LoadRequestsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadRequestsImpl abC;

            C09551(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.abC = loadRequestsImpl;
                this.DS = status;
            }

            public GameRequestBuffer getRequests(int i) {
                return new GameRequestBuffer(DataHolder.av(this.DS.getStatusCode()));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult al(Status status) {
            return new C09551(this, status);
        }

        public /* synthetic */ Result m3936c(Status status) {
            return al(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C09483 extends LoadRequestsImpl {
        final /* synthetic */ int aaA;
        final /* synthetic */ RequestsImpl abu;
        final /* synthetic */ int abv;
        final /* synthetic */ int abw;

        C09483(RequestsImpl requestsImpl, GoogleApiClient googleApiClient, int i, int i2, int i3) {
            this.abu = requestsImpl;
            this.abv = i;
            this.abw = i2;
            this.aaA = i3;
            super(null);
        }

        protected void m3938a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3128a((C0433b) this, this.abv, this.abw, this.aaA);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C09561 implements SendRequestResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ SendRequestImpl abD;

            C09561(SendRequestImpl sendRequestImpl, Status status) {
                this.abD = sendRequestImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public SendRequestResult am(Status status) {
            return new C09561(this, status);
        }

        public /* synthetic */ Result m3939c(Status status) {
            return am(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C09494 extends SendRequestImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abA;
        final /* synthetic */ String[] abx;
        final /* synthetic */ int aby;
        final /* synthetic */ byte[] abz;

        protected void m3941a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3156a((C0433b) this, this.ZZ, this.abx, this.aby, this.abz, this.abA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C09505 extends SendRequestImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abA;
        final /* synthetic */ String[] abx;
        final /* synthetic */ int aby;
        final /* synthetic */ byte[] abz;

        protected void m3943a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3156a((C0433b) this, this.ZZ, this.abx, this.aby, this.abz, this.abA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C09516 extends UpdateRequestsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abp;
        final /* synthetic */ String[] abt;

        protected void m3945a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3152a((C0433b) this, this.ZZ, this.abp, this.abt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C09527 extends LoadRequestsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;
        final /* synthetic */ String abp;
        final /* synthetic */ int abv;
        final /* synthetic */ int abw;

        protected void m3947a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3145a((C0433b) this, this.ZZ, this.abp, this.abv, this.abw, this.aaA);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C09541 implements LoadRequestSummariesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadRequestSummariesImpl abB;

            C09541(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.abB = loadRequestSummariesImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        public LoadRequestSummariesResult ak(Status status) {
            return new C09541(this, status);
        }

        public /* synthetic */ Result m3948c(Status status) {
            return ak(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C09538 extends LoadRequestSummariesImpl {
        final /* synthetic */ String abp;
        final /* synthetic */ int abw;

        protected void m3950a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3213f(this, this.abp, this.abw);
        }
    }

    public final PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    public final PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.m1806b(new C09461(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public final PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    public final PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.m1806b(new C09472(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public final ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public final ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        return intent == null ? new ArrayList() : getGameRequestsFromBundle(intent.getExtras());
    }

    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).ly();
    }

    public final int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lA();
    }

    public final int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lz();
    }

    public final Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.m2826d(googleApiClient).m3123a(i, bArr, i2, bitmap, str);
    }

    public final PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        return googleApiClient.m1804a(new C09483(this, googleApiClient, i, i2, i3));
    }

    public final void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        Games.m2826d(googleApiClient).m3205d(googleApiClient.m1807d(onRequestReceivedListener));
    }

    public final void unregisterRequestListener(GoogleApiClient googleApiClient) {
        Games.m2826d(googleApiClient).ls();
    }
}
