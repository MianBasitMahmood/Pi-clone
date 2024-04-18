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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1 */
        class C09101 implements LoadScoresResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadScoresImpl aaP;

            C09101(LoadScoresImpl loadScoresImpl, Status status) {
                this.aaP = loadScoresImpl;
                this.DS = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult m3800W(Status status) {
            return new C09101(this, status);
        }

        public /* synthetic */ Result m3801c(Status status) {
            return m3800W(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        protected void m3803a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3146a((C0433b) this, this.ZZ, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        protected void m3805a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3176b(this, this.ZZ, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1 */
        class C09081 implements LeaderboardMetadataResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadMetadataImpl aaN;

            C09081(LoadMetadataImpl loadMetadataImpl, Status status) {
                this.aaN = loadMetadataImpl;
                this.DS = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult m3806U(Status status) {
            return new C09081(this, status);
        }

        public /* synthetic */ Result m3807c(Status status) {
            return m3806U(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.1 */
    class C08991 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ LeaderboardsImpl aaE;

        C08991(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.aaE = leaderboardsImpl;
            this.ZW = z;
            super(null);
        }

        protected void m3809a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3180b((C0433b) this, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.2 */
    class C09002 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ String aaF;

        C09002(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.aaE = leaderboardsImpl;
            this.aaF = str;
            this.ZW = z;
            super(null);
        }

        protected void m3811a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3179b((C0433b) this, this.aaF, this.ZW);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1 */
        class C09091 implements LoadPlayerScoreResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadPlayerScoreImpl aaO;

            C09091(LoadPlayerScoreImpl loadPlayerScoreImpl, Status status) {
                this.aaO = loadPlayerScoreImpl;
                this.DS = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult m3812V(Status status) {
            return new C09091(this, status);
        }

        public /* synthetic */ Result m3813c(Status status) {
            return m3812V(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.3 */
    class C09013 extends LoadPlayerScoreImpl {
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;

        C09013(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2) {
            this.aaE = leaderboardsImpl;
            this.aaF = str;
            this.aaG = i;
            this.aaH = i2;
            super(null);
        }

        protected void m3815a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3144a((C0433b) this, null, this.aaF, this.aaG, this.aaH);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.4 */
    class C09024 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        C09024(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
            this.aaE = leaderboardsImpl;
            this.aaF = str;
            this.aaG = i;
            this.aaH = i2;
            this.aaI = i3;
            this.ZW = z;
            super(null);
        }

        protected void m3817a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3138a((C0433b) this, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.5 */
    class C09035 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        C09035(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
            this.aaE = leaderboardsImpl;
            this.aaF = str;
            this.aaG = i;
            this.aaH = i2;
            this.aaI = i3;
            this.ZW = z;
            super(null);
        }

        protected void m3819a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3173b((C0433b) this, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.6 */
    class C09046 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ int aaI;
        final /* synthetic */ LeaderboardScoreBuffer aaJ;
        final /* synthetic */ int aaK;

        C09046(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.aaE = leaderboardsImpl;
            this.aaJ = leaderboardScoreBuffer;
            this.aaI = i;
            this.aaK = i2;
            super(null);
        }

        protected void m3821a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3133a((C0433b) this, this.aaJ, this.aaI, this.aaK);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1 */
        class C09111 implements SubmitScoreResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ SubmitScoreImpl aaQ;

            C09111(SubmitScoreImpl submitScoreImpl, Status status) {
                this.aaQ = submitScoreImpl;
                this.DS = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult m3822X(Status status) {
            return new C09111(this, status);
        }

        public /* synthetic */ Result m3823c(Status status) {
            return m3822X(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.7 */
    class C09057 extends SubmitScoreImpl {
        final /* synthetic */ LeaderboardsImpl aaE;
        final /* synthetic */ String aaF;
        final /* synthetic */ long aaL;
        final /* synthetic */ String aaM;

        C09057(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, long j, String str2) {
            this.aaE = leaderboardsImpl;
            this.aaF = str;
            this.aaL = j;
            this.aaM = str2;
            super(googleApiClient);
        }

        protected void m3825a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3142a((C0433b) this, this.aaF, this.aaL, this.aaM);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.8 */
    class C09068 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;

        protected void m3827a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3203d((C0433b) this, this.ZZ, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.9 */
    class C09079 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;

        protected void m3829a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3149a((C0433b) this, this.ZZ, this.aaF, this.ZW);
        }
    }

    public final Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).ll();
    }

    public final Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str) {
        return getLeaderboardIntent(googleApiClient, str, -1);
    }

    public final Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i) {
        return Games.m2826d(googleApiClient).m3230n(str, i);
    }

    public final PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return googleApiClient.m1804a(new C09013(this, googleApiClient, str, i, i2));
    }

    public final PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.m1804a(new C09002(this, googleApiClient, str, z));
    }

    public final PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1804a(new C08991(this, googleApiClient, z));
    }

    public final PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return googleApiClient.m1804a(new C09046(this, googleApiClient, leaderboardScoreBuffer, i, i2));
    }

    public final PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadPlayerCenteredScores(googleApiClient, str, i, i2, i3, false);
    }

    public final PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.m1804a(new C09035(this, googleApiClient, str, i, i2, i3, z));
    }

    public final PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadTopScores(googleApiClient, str, i, i2, i3, false);
    }

    public final PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.m1804a(new C09024(this, googleApiClient, str, i, i2, i3, z));
    }

    public final void submitScore(GoogleApiClient googleApiClient, String str, long j) {
        submitScore(googleApiClient, str, j, null);
    }

    public final void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2) {
        Games.m2826d(googleApiClient).m3142a(null, str, j, str2);
    }

    public final PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j) {
        return submitScoreImmediate(googleApiClient, str, j, null);
    }

    public final PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j, String str2) {
        return googleApiClient.m1806b(new C09057(this, googleApiClient, str, j, str2));
    }
}
