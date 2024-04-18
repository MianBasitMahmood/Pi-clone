package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadExtendedGamesImpl.1 */
        class C08911 implements LoadExtendedGamesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadExtendedGamesImpl aaw;

            C08911(LoadExtendedGamesImpl loadExtendedGamesImpl, Status status) {
                this.aaw = loadExtendedGamesImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        public LoadExtendedGamesResult m3746P(Status status) {
            return new C08911(this, status);
        }

        public /* synthetic */ Result m3747c(Status status) {
            return m3746P(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void m3749a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3140a((C0433b) this, this.aaq, this.aar, false, true, false, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3751a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3189c(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3753a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3189c(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3755a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3201d(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3757a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3201d(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.15 */
    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void m3759a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3140a((C0433b) this, this.aaq, this.aar, true, false, this.ZW, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.16 */
    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void m3761a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3140a((C0433b) this, this.aaq, this.aar, true, true, false, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.17 */
    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void m3763a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3208e(this, this.aat, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.18 */
    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void m3765a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3208e(this, this.aat, this.aar, true, false);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C08931 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadGameSearchSuggestionsImpl aay;

            C08931(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.aay = loadGameSearchSuggestionsImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        public LoadGameSearchSuggestionsResult m3766R(Status status) {
            return new C08931(this, status);
        }

        public /* synthetic */ Result m3767c(Status status) {
            return m3766R(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.19 */
    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String aat;

        protected void m3769a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3228l(this, this.aat);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C08941 implements LoadGamesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadGamesImpl aaz;

            C08941(LoadGamesImpl loadGamesImpl, Status status) {
                this.aaz = loadGamesImpl;
                this.DS = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult m3770S(Status status) {
            return new C08941(this, status);
        }

        public /* synthetic */ Result m3771c(Status status) {
            return m3770S(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C08821 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl aap;

        C08821(GamesMetadataImpl gamesMetadataImpl, GoogleApiClient googleApiClient) {
            this.aap = gamesMetadataImpl;
            super(null);
        }

        protected void m3773a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3211f(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C08832 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZZ;

        protected void m3775a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3224j(this, this.ZZ);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C08921 implements LoadGameInstancesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadGameInstancesImpl aax;

            C08921(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.aax = loadGameInstancesImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        public LoadGameInstancesResult m3776Q(Status status) {
            return new C08921(this, status);
        }

        public /* synthetic */ Result m3777c(Status status) {
            return m3776Q(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C08843 extends LoadGameInstancesImpl {
        final /* synthetic */ String ZZ;

        protected void m3779a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3226k(this, this.ZZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.4 */
    class C08854 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void m3781a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3174b(this, null, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.5 */
    class C08865 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;

        protected void m3783a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3174b(this, null, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.6 */
    class C08876 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3785a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3174b(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.7 */
    class C08887 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        protected void m3787a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3174b(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.8 */
    class C08898 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ int aau;
        final /* synthetic */ boolean aav;

        protected void m3789a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3129a((C0433b) this, this.aar, this.aau, this.aav, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.9 */
    class C08909 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        protected void m3791a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3140a((C0433b) this, this.aaq, this.aar, false, false, this.ZW, this.aas);
        }
    }

    public final Game getCurrentGame(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lk();
    }

    public final PendingResult<LoadGamesResult> loadGame(GoogleApiClient googleApiClient) {
        return googleApiClient.m1804a(new C08821(this, googleApiClient));
    }
}
