package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C09801 implements LoadMatchResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadMatchImpl acd;

            C09801(LoadMatchImpl loadMatchImpl, Status status) {
                this.acd = loadMatchImpl;
                this.DS = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult av(Status status) {
            return new C09801(this, status);
        }

        public /* synthetic */ Result m3967c(Status status) {
            return av(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            super(null);
        }

        protected void m3969a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3217g((C0433b) this, this.abU);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C09781 implements InitiateMatchResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ InitiateMatchImpl acb;

            C09781(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.acb = initiateMatchImpl;
                this.DS = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult at(Status status) {
            return new C09781(this, status);
        }

        public /* synthetic */ Result m3970c(Status status) {
            return at(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abU;

        protected void m3972a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3190c((C0433b) this, this.ZZ, this.abU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ String abU;

        protected void m3974a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3202d((C0433b) this, this.ZZ, this.abU);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C09811 implements LoadMatchesResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadMatchesImpl ace;

            C09811(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.ace = loadMatchesImpl;
                this.DS = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult aw(Status status) {
            return new C09811(this, status);
        }

        public /* synthetic */ Result m3975c(Status status) {
            return aw(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int abV;
        final /* synthetic */ int[] abW;

        protected void m3977a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3141a((C0433b) this, this.ZZ, this.abV, this.abW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C09681 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig abS;
        final /* synthetic */ TurnBasedMultiplayerImpl abT;

        C09681(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.abT = turnBasedMultiplayerImpl;
            this.abS = turnBasedMatchConfig;
            super(null);
        }

        protected void m3979a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3134a((C0433b) this, this.abS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C09692 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;

        C09692(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            super(null);
        }

        protected void m3981a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3187c((C0433b) this, this.abU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C09703 extends InitiateMatchImpl {
        final /* synthetic */ String aaC;
        final /* synthetic */ TurnBasedMultiplayerImpl abT;

        C09703(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.abT = turnBasedMultiplayerImpl;
            this.aaC = str;
            super(null);
        }

        protected void m3983a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3199d((C0433b) this, this.aaC);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C09821 implements UpdateMatchResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ UpdateMatchImpl acf;

            C09821(UpdateMatchImpl updateMatchImpl, Status status) {
                this.acf = updateMatchImpl;
                this.DS = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult ax(Status status) {
            return new C09821(this, status);
        }

        public /* synthetic */ Result m3984c(Status status) {
            return ax(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C09714 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;
        final /* synthetic */ byte[] abX;
        final /* synthetic */ String abY;
        final /* synthetic */ ParticipantResult[] abZ;

        C09714(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            this.abX = bArr;
            this.abY = str2;
            this.abZ = participantResultArr;
            super(null);
        }

        protected void m3986a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3154a((C0433b) this, this.abU, this.abX, this.abY, this.abZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C09725 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;
        final /* synthetic */ byte[] abX;
        final /* synthetic */ ParticipantResult[] abZ;

        C09725(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            this.abX = bArr;
            this.abZ = participantResultArr;
            super(null);
        }

        protected void m3988a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3155a((C0433b) this, this.abU, this.abX, this.abZ);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C09791 implements LeaveMatchResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LeaveMatchImpl acc;

            C09791(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.acc = leaveMatchImpl;
                this.DS = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult au(Status status) {
            return new C09791(this, status);
        }

        public /* synthetic */ Result m3989c(Status status) {
            return au(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C09736 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;

        C09736(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            super(null);
        }

        protected void m3991a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3206e((C0433b) this, this.abU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C09747 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;
        final /* synthetic */ String abY;

        C09747(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, String str, String str2) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str;
            this.abY = str2;
            super(null);
        }

        protected void m3993a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3143a((C0433b) this, this.abU, this.abY);
        }
    }

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String CE;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C09771 implements CancelMatchResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ CancelMatchImpl aca;

            C09771(CancelMatchImpl cancelMatchImpl, Status status) {
                this.aca = cancelMatchImpl;
                this.DS = status;
            }

            public String getMatchId() {
                return this.aca.CE;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public CancelMatchImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.CE = str;
        }

        public CancelMatchResult as(Status status) {
            return new C09771(this, status);
        }

        public /* synthetic */ Result m3995c(Status status) {
            return as(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C09758 extends CancelMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ String abU;

        C09758(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, GoogleApiClient googleApiClient, String str2) {
            this.abT = turnBasedMultiplayerImpl;
            this.abU = str2;
            super(str, googleApiClient);
        }

        protected void m3997a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3212f((C0433b) this, this.abU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C09769 extends LoadMatchesImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl abT;
        final /* synthetic */ int abV;
        final /* synthetic */ int[] abW;

        C09769(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient googleApiClient, int i, int[] iArr) {
            this.abT = turnBasedMultiplayerImpl;
            this.abV = i;
            this.abW = iArr;
            super(null);
        }

        protected void m3999a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3132a((C0433b) this, this.abV, this.abW);
        }
    }

    public final PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C09703(this, googleApiClient, str));
    }

    public final PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C09758(this, str, googleApiClient, str));
    }

    public final PendingResult<InitiateMatchResult> createMatch(GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.m1806b(new C09681(this, googleApiClient, turnBasedMatchConfig));
    }

    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).m3236q(str, 1);
    }

    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).m3235p(str, 1);
    }

    public final void dismissMatch(GoogleApiClient googleApiClient, String str) {
        Games.m2826d(googleApiClient).bA(str);
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, null, null);
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List<ParticipantResult> list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult... participantResultArr) {
        return googleApiClient.m1806b(new C09725(this, googleApiClient, str, bArr, participantResultArr));
    }

    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).ln();
    }

    public final int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lx();
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.m2826d(googleApiClient).m3122a(i, i2, true);
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.m2826d(googleApiClient).m3122a(i, i2, z);
    }

    public final PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C09736(this, googleApiClient, str));
    }

    public final PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.m1806b(new C09747(this, googleApiClient, str, str2));
    }

    public final PendingResult<LoadMatchResult> loadMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1804a(new AnonymousClass10(this, googleApiClient, str));
    }

    public final PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int i, int[] iArr) {
        return googleApiClient.m1804a(new C09769(this, googleApiClient, i, iArr));
    }

    public final PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    public final void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        Games.m2826d(googleApiClient).m3183b(googleApiClient.m1807d(onTurnBasedMatchUpdateReceivedListener));
    }

    public final PendingResult<InitiateMatchResult> rematch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.m1806b(new C09692(this, googleApiClient, str));
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, null);
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        return googleApiClient.m1806b(new C09714(this, googleApiClient, str, bArr, str2, participantResultArr));
    }

    public final void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        Games.m2826d(googleApiClient).lq();
    }
}
