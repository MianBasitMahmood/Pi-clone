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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1 */
        class C09431 implements AcceptQuestResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ AcceptImpl abq;

            C09431(AcceptImpl acceptImpl, Status status) {
                this.abq = acceptImpl;
                this.DS = status;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult ah(Status status) {
            return new C09431(this, status);
        }

        public /* synthetic */ Result m3915c(Status status) {
            return ah(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.1 */
    class C09371 extends AcceptImpl {
        final /* synthetic */ String abk;
        final /* synthetic */ QuestsImpl abl;

        C09371(QuestsImpl questsImpl, GoogleApiClient googleApiClient, String str) {
            this.abl = questsImpl;
            this.abk = str;
            super(null);
        }

        protected void m3917a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3220h((C0433b) this, this.abk);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1 */
        class C09441 implements ClaimMilestoneResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ ClaimImpl abr;

            C09441(ClaimImpl claimImpl, Status status) {
                this.abr = claimImpl;
                this.DS = status;
            }

            public Milestone getMilestone() {
                return null;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult ai(Status status) {
            return new C09441(this, status);
        }

        public /* synthetic */ Result m3918c(Status status) {
            return ai(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.2 */
    class C09382 extends ClaimImpl {
        final /* synthetic */ String abk;
        final /* synthetic */ QuestsImpl abl;
        final /* synthetic */ String abm;

        C09382(QuestsImpl questsImpl, GoogleApiClient googleApiClient, String str, String str2) {
            this.abl = questsImpl;
            this.abk = str;
            this.abm = str2;
            super(null);
        }

        protected void m3920a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3175b((C0433b) this, this.abk, this.abm);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1 */
        class C09451 implements LoadQuestsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadsImpl abs;

            C09451(LoadsImpl loadsImpl, Status status) {
                this.abs = loadsImpl;
                this.DS = status;
            }

            public QuestBuffer getQuests() {
                return new QuestBuffer(DataHolder.av(this.DS.getStatusCode()));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult aj(Status status) {
            return new C09451(this, status);
        }

        public /* synthetic */ Result m3921c(Status status) {
            return aj(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.3 */
    class C09393 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aaA;
        final /* synthetic */ QuestsImpl abl;
        final /* synthetic */ int[] abn;

        C09393(QuestsImpl questsImpl, GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
            this.abl = questsImpl;
            this.abn = iArr;
            this.aaA = i;
            this.ZW = z;
            super(null);
        }

        protected void m3923a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3160a((C0433b) this, this.abn, this.aaA, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.4 */
    class C09404 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ QuestsImpl abl;
        final /* synthetic */ String[] abo;

        C09404(QuestsImpl questsImpl, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
            this.abl = questsImpl;
            this.ZW = z;
            this.abo = strArr;
            super(null);
        }

        protected void m3925a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3181b((C0433b) this, this.ZW, this.abo);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.5 */
    class C09415 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;
        final /* synthetic */ int[] abn;
        final /* synthetic */ String abp;

        protected void m3927a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3151a((C0433b) this, this.ZZ, this.abp, this.abn, this.aaA, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.6 */
    class C09426 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String[] abo;
        final /* synthetic */ String abp;

        protected void m3929a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3150a((C0433b) this, this.ZZ, this.abp, this.ZW, this.abo);
        }
    }

    public final PendingResult<AcceptQuestResult> accept(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C09371(this, googleApiClient, str));
    }

    public final PendingResult<ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.m1806b(new C09382(this, googleApiClient, str, str2));
    }

    public final Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.m2826d(googleApiClient).bE(str);
    }

    public final Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.m2826d(googleApiClient).m3168b(iArr);
    }

    public final PendingResult<LoadQuestsResult> load(GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        return googleApiClient.m1804a(new C09393(this, googleApiClient, iArr, i, z));
    }

    public final PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.m1804a(new C09404(this, googleApiClient, z, strArr));
    }

    public final void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        Games.m2826d(googleApiClient).m3195c(googleApiClient.m1807d(questUpdateListener));
    }

    public final void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).bF(str);
    }

    public final void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        Games.m2826d(googleApiClient).lr();
    }
}
