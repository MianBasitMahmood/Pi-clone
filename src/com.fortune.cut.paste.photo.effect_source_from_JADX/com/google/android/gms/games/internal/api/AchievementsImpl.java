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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C08701 implements LoadAchievementsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadImpl aac;

            C08701(LoadImpl loadImpl, Status status) {
                this.aac = loadImpl;
                this.DS = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.av(14));
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

        public LoadAchievementsResult m3698I(Status status) {
            return new C08701(this, status);
        }

        public /* synthetic */ Result m3699c(Status status) {
            return m3698I(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ String ZZ;

        public void m3701a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3178b((C0433b) this, this.ZY, this.ZZ, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C08611 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ AchievementsImpl ZX;

        C08611(AchievementsImpl achievementsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.ZX = achievementsImpl;
            this.ZW = z;
            super(null);
        }

        public void m3703a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3193c((C0433b) this, this.ZW);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String CE;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C08711 implements UpdateAchievementResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ UpdateImpl aad;

            C08711(UpdateImpl updateImpl, Status status) {
                this.aad = updateImpl;
                this.DS = status;
            }

            public String getAchievementId() {
                return this.aad.CE;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.CE = str;
        }

        public UpdateAchievementResult m3705J(Status status) {
            return new C08711(this, status);
        }

        public /* synthetic */ Result m3706c(Status status) {
            return m3705J(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C08622 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;

        C08622(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            super(str, googleApiClient);
        }

        public void m3708a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3136a(null, this.aaa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C08633 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;

        C08633(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            super(str, googleApiClient);
        }

        public void m3710a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3136a((C0433b) this, this.aaa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C08644 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;

        C08644(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            super(str, googleApiClient);
        }

        public void m3712a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3171b(null, this.aaa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C08655 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;

        C08655(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            super(str, googleApiClient);
        }

        public void m3714a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3171b((C0433b) this, this.aaa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C08666 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;
        final /* synthetic */ int aab;

        C08666(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            this.aab = i;
            super(str, googleApiClient);
        }

        public void m3716a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3137a(null, this.aaa, this.aab);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C08677 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;
        final /* synthetic */ int aab;

        C08677(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            this.aab = i;
            super(str, googleApiClient);
        }

        public void m3718a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3137a((C0433b) this, this.aaa, this.aab);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C08688 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;
        final /* synthetic */ int aab;

        C08688(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            this.aab = i;
            super(str, googleApiClient);
        }

        public void m3720a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3172b(null, this.aaa, this.aab);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C08699 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl ZX;
        final /* synthetic */ String aaa;
        final /* synthetic */ int aab;

        C08699(AchievementsImpl achievementsImpl, String str, GoogleApiClient googleApiClient, String str2, int i) {
            this.ZX = achievementsImpl;
            this.aaa = str2;
            this.aab = i;
            super(str, googleApiClient);
        }

        public void m3722a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3172b((C0433b) this, this.aaa, this.aab);
        }
    }

    public final Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lm();
    }

    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.m1806b(new C08666(this, str, googleApiClient, str, i));
    }

    public final PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.m1806b(new C08677(this, str, googleApiClient, str, i));
    }

    public final PendingResult<LoadAchievementsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1804a(new C08611(this, googleApiClient, z));
    }

    public final void reveal(GoogleApiClient googleApiClient, String str) {
        googleApiClient.m1806b(new C08622(this, str, googleApiClient, str));
    }

    public final PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C08633(this, str, googleApiClient, str));
    }

    public final void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        googleApiClient.m1806b(new C08688(this, str, googleApiClient, str, i));
    }

    public final PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        return googleApiClient.m1806b(new C08699(this, str, googleApiClient, str, i));
    }

    public final void unlock(GoogleApiClient googleApiClient, String str) {
        googleApiClient.m1806b(new C08644(this, str, googleApiClient, str));
    }

    public final PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C08655(this, str, googleApiClient, str));
    }
}
