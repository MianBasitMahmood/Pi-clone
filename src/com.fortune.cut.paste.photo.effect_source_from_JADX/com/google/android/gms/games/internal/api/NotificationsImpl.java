package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C09131 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C09121 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C09131 aaS;

            C09121(C09131 c09131, Status status) {
                this.aaS = c09131;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public GameMuteStatusChangeResult m3830Y(Status status) {
            return new C09121(this, status);
        }

        protected void m3832a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3209e((C0433b) this, this.aaR, true);
        }

        public /* synthetic */ Result m3833c(Status status) {
            return m3830Y(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C09152 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C09141 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C09152 aaT;

            C09141(C09152 c09152, Status status) {
                this.aaT = c09152;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public GameMuteStatusChangeResult m3834Y(Status status) {
            return new C09141(this, status);
        }

        protected void m3836a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3209e((C0433b) this, this.aaR, false);
        }

        public /* synthetic */ Result m3837c(Status status) {
            return m3834Y(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C09173 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String aaR;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C09161 implements GameMuteStatusLoadResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C09173 aaU;

            C09161(C09173 c09173, Status status) {
                this.aaU = c09173;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public GameMuteStatusLoadResult m3838Z(Status status) {
            return new C09161(this, status);
        }

        protected void m3840a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3234p((C0433b) this, this.aaR);
        }

        public /* synthetic */ Result m3841c(Status status) {
            return m3838Z(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C09211 implements ContactSettingLoadResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ ContactSettingLoadImpl aaX;

            C09211(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.aaX = contactSettingLoadImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public ContactSettingLoadResult aa(Status status) {
            return new C09211(this, status);
        }

        public /* synthetic */ Result m3842c(Status status) {
            return aa(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C09184 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean ZW;

        protected void m3844a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3221h((C0433b) this, this.ZW);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status m3845b(Status status) {
            return status;
        }

        public /* synthetic */ Result m3846c(Status status) {
            return m3845b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C09195 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean aaV;
        final /* synthetic */ Bundle aaW;

        protected void m3848a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3158a((C0433b) this, this.aaV, this.aaW);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1 */
        class C09221 implements InboxCountResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ InboxCountImpl aaY;

            C09221(InboxCountImpl inboxCountImpl, Status status) {
                this.aaY = inboxCountImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        public InboxCountResult ab(Status status) {
            return new C09221(this, status);
        }

        public /* synthetic */ Result m3849c(Status status) {
            return ab(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.6 */
    class C09206 extends InboxCountImpl {
        protected void m3851a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3222i(this);
        }
    }

    public final void clear(GoogleApiClient googleApiClient, int i) {
        Games.m2826d(googleApiClient).dT(i);
    }

    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 31);
    }
}
