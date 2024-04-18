package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1 */
        class C08801 implements LoadEventsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadImpl aan;

            C08801(LoadImpl loadImpl, Status status) {
                this.aan = loadImpl;
                this.DS = status;
            }

            public EventBuffer getEvents() {
                return new EventBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult m3737O(Status status) {
            return new C08801(this, status);
        }

        public /* synthetic */ Result m3738c(Status status) {
            return m3737O(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.1 */
    class C08771 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String[] aaj;
        final /* synthetic */ EventsImpl aak;

        C08771(EventsImpl eventsImpl, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
            this.aak = eventsImpl;
            this.ZW = z;
            this.aaj = strArr;
            super(null);
        }

        public void m3740a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3159a((C0433b) this, this.ZW, this.aaj);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.2 */
    class C08782 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ EventsImpl aak;

        C08782(EventsImpl eventsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.aak = eventsImpl;
            this.ZW = z;
            super(null);
        }

        public void m3742a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3204d((C0433b) this, this.ZW);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1 */
        class C08811 implements Result {
            final /* synthetic */ Status DS;
            final /* synthetic */ UpdateImpl aao;

            C08811(UpdateImpl updateImpl, Status status) {
                this.aao = updateImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result m3743c(Status status) {
            return new C08811(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.3 */
    class C08793 extends UpdateImpl {
        final /* synthetic */ EventsImpl aak;
        final /* synthetic */ String aal;
        final /* synthetic */ int aam;

        C08793(EventsImpl eventsImpl, GoogleApiClient googleApiClient, String str, int i) {
            this.aak = eventsImpl;
            this.aal = str;
            this.aam = i;
            super(null);
        }

        public void m3745a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3233o(this.aal, this.aam);
        }
    }

    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        GamesClientImpl e = Games.m2827e(googleApiClient);
        if (e.isConnected()) {
            e.m3233o(str, i);
        } else {
            googleApiClient.m1806b(new C08793(this, googleApiClient, str, i));
        }
    }

    public final PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1804a(new C08782(this, googleApiClient, z));
    }

    public final PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.m1804a(new C08771(this, googleApiClient, z, strArr));
    }
}
