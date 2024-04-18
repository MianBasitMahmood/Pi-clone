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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1 */
        class C08981 implements LoadInvitationsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadInvitationsImpl aaD;

            C08981(LoadInvitationsImpl loadInvitationsImpl, Status status) {
                this.aaD = loadInvitationsImpl;
                this.DS = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadInvitationsResult m3792T(Status status) {
            return new C08981(this, status);
        }

        public /* synthetic */ Result m3793c(Status status) {
            return m3792T(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.1 */
    class C08951 extends LoadInvitationsImpl {
        final /* synthetic */ int aaA;
        final /* synthetic */ InvitationsImpl aaB;

        C08951(InvitationsImpl invitationsImpl, GoogleApiClient googleApiClient, int i) {
            this.aaB = invitationsImpl;
            this.aaA = i;
            super(null);
        }

        protected void m3795a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3185c((C0433b) this, this.aaA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.2 */
    class C08962 extends LoadInvitationsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;

        protected void m3797a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3207e((C0433b) this, this.ZZ, this.aaA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.3 */
    class C08973 extends LoadInvitationsImpl {
        final /* synthetic */ String aaC;

        protected void m3799a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3231n((C0433b) this, this.aaC);
        }
    }

    public final Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lo();
    }

    public final PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    public final PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.m1804a(new C08951(this, googleApiClient, i));
    }

    public final void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        Games.m2826d(googleApiClient).m3162a(googleApiClient.m1807d(onInvitationReceivedListener));
    }

    public final void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        Games.m2826d(googleApiClient).lp();
    }
}
