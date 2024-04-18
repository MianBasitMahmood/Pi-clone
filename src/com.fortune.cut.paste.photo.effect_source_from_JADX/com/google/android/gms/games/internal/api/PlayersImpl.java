package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C09331 implements LoadPlayersResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadPlayersImpl abg;

            C09331(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.abg = loadPlayersImpl;
                this.DS = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult ad(Status status) {
            return new C09331(this, status);
        }

        public /* synthetic */ Result m3852c(Status status) {
            return ad(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void m3854a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3147a((C0433b) this, "nearby", this.ZZ, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void m3856a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3147a((C0433b) this, "played_with", this.ZZ, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void m3858a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3147a((C0433b) this, "played_with", this.ZZ, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void m3860a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3170b((C0433b) this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void m3862a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3170b((C0433b) this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void m3864a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3186c((C0433b) this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void m3866a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3186c((C0433b) this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        protected void m3868a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3198d(this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        protected void m3870a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3198d(this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void m3872a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3214f(this, this.aat, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C09231 extends LoadPlayersImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ PlayersImpl aaZ;

        C09231(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str) {
            this.aaZ = playersImpl;
            this.ZY = str;
            super(null);
        }

        protected void m3874a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3153a((C0433b) this, this.ZY, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        protected void m3876a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3214f(this, this.aat, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        protected void m3878a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3177b((C0433b) this, this.aba, this.aaR, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        protected void m3880a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3177b((C0433b) this, this.aba, this.aaR, this.aar, true, false);
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadOwnerCoverPhotoUrisImpl.1 */
        class C09321 implements LoadOwnerCoverPhotoUrisResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadOwnerCoverPhotoUrisImpl abf;

            C09321(LoadOwnerCoverPhotoUrisImpl loadOwnerCoverPhotoUrisImpl, Status status) {
                this.abf = loadOwnerCoverPhotoUrisImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public LoadOwnerCoverPhotoUrisResult ac(Status status) {
            return new C09321(this, status);
        }

        public /* synthetic */ Result m3881c(Status status) {
            return ac(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void m3883a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3216g(this);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C09351 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadXpForGameCategoriesResultImpl abi;

            C09351(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.abi = loadXpForGameCategoriesResultImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public LoadXpForGameCategoriesResult af(Status status) {
            return new C09351(this, status);
        }

        public /* synthetic */ Result m3884c(Status status) {
            return af(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String abb;

        protected void m3886a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3229m(this, this.abb);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C09361 implements LoadXpStreamResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadXpStreamResultImpl abj;

            C09361(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.abj = loadXpStreamResultImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public LoadXpStreamResult ag(Status status) {
            return new C09361(this, status);
        }

        public /* synthetic */ Result m3887c(Status status) {
            return ag(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        protected void m3889a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3188c((C0433b) this, this.abb, this.abc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        protected void m3891a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3200d((C0433b) this, this.abb, this.abc);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1 */
        class C09341 implements LoadProfileSettingsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadProfileSettingsResultImpl abh;

            C09341(LoadProfileSettingsResultImpl loadProfileSettingsResultImpl, Status status) {
                this.abh = loadProfileSettingsResultImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public boolean isProfileVisible() {
                return true;
            }

            public boolean isVisibilityExplicitlySet() {
                return false;
            }
        }

        protected LoadProfileSettingsResult ae(Status status) {
            return new C09341(this, status);
        }

        protected /* synthetic */ Result m3892c(Status status) {
            return ae(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.27 */
    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean ZW;

        protected void m3894a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3215f((C0433b) this, this.ZW);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status m3895b(Status status) {
            return status;
        }

        protected /* synthetic */ Result m3896c(Status status) {
            return m3895b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.28 */
    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean abd;

        protected void m3898a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3218g((C0433b) this, this.abd);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C09242 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ PlayersImpl aaZ;

        C09242(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.aaZ = playersImpl;
            this.ZY = str;
            this.ZW = z;
            super(null);
        }

        protected void m3900a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3153a((C0433b) this, this.ZY, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C09253 extends LoadPlayersImpl {
        final /* synthetic */ String[] abe;

        protected void m3902a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3161a((C0433b) this, this.abe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C09264 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ PlayersImpl aaZ;
        final /* synthetic */ int aar;

        C09264(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.aaZ = playersImpl;
            this.aar = i;
            this.ZW = z;
            super(null);
        }

        protected void m3904a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3131a((C0433b) this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C09275 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl aaZ;
        final /* synthetic */ int aar;

        C09275(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.aaZ = playersImpl;
            this.aar = i;
            super(null);
        }

        protected void m3906a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3131a((C0433b) this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C09286 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ PlayersImpl aaZ;
        final /* synthetic */ int aar;

        C09286(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.aaZ = playersImpl;
            this.aar = i;
            this.ZW = z;
            super(null);
        }

        protected void m3908a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3139a((C0433b) this, "played_with", this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C09297 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl aaZ;
        final /* synthetic */ int aar;

        C09297(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.aaZ = playersImpl;
            this.aar = i;
            super(null);
        }

        protected void m3910a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3139a((C0433b) this, "played_with", this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C09308 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ PlayersImpl aaZ;

        C09308(PlayersImpl playersImpl, GoogleApiClient googleApiClient, boolean z) {
            this.aaZ = playersImpl;
            this.ZW = z;
            super(null);
        }

        protected void m3912a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3157a((C0433b) this, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C09319 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        protected void m3914a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3147a((C0433b) this, "nearby", this.ZZ, this.aar, false, false);
        }
    }

    public final Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lj();
    }

    public final String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).li();
    }

    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lt();
    }

    public final PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1804a(new C09308(this, googleApiClient, z));
    }

    public final PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.m1804a(new C09264(this, googleApiClient, i, z));
    }

    public final PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1804a(new C09275(this, googleApiClient, i));
    }

    public final PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1804a(new C09297(this, googleApiClient, i));
    }

    public final PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1804a(new C09231(this, googleApiClient, str));
    }

    public final PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.m1804a(new C09242(this, googleApiClient, str, z));
    }

    public final PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.m1804a(new C09286(this, googleApiClient, i, z));
    }
}
