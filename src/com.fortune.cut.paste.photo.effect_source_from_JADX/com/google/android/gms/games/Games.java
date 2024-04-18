package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0430b;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class Games {
    public static final Api<GamesOptions> API;
    public static final Achievements Achievements;
    static final C0490c<GamesClientImpl> DQ;
    private static final C0430b<GamesClientImpl, GamesOptions> DR;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Events Events;
    public static final GamesMetadata GamesMetadata;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final Quests Quests;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final Snapshots Snapshots;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    public static final Scope WV;
    public static final Api<GamesOptions> WW;
    public static final AppContents WX;
    public static final Multiplayer WY;
    public static final Acls WZ;

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C08531 implements C0430b<GamesClientImpl, GamesOptions> {
        C08531() {
        }

        public final GamesClientImpl m2821a(Context context, Looper looper, jg jgVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, jgVar.hq(), jgVar.hm(), connectionCallbacks, onConnectionFailedListener, jgVar.hp(), jgVar.hn(), jgVar.hr(), gamesOptions == null ? new GamesOptions() : gamesOptions);
        }

        public final int getPriority() {
            return 1;
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends C0435a<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.DQ, googleApiClient);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m2822b(Status status) {
            return status;
        }

        public /* synthetic */ Result m2823c(Status status) {
            return m2822b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C08542 extends SignOutImpl {
        C08542(GoogleApiClient googleApiClient) {
            super(null);
        }

        protected final /* synthetic */ void m2824a(C0489a c0489a) throws RemoteException {
            ((GamesClientImpl) c0489a).m3169b((C0433b) this);
        }

        protected final void m2825a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3169b((C0433b) this);
        }
    }

    public static final class GamesOptions implements Optional {
        public final boolean Xa;
        public final boolean Xb;
        public final int Xc;
        public final boolean Xd;
        public final int Xe;
        public final String Xf;
        public final ArrayList<String> Xg;

        public static final class Builder {
            boolean Xa;
            boolean Xb;
            int Xc;
            boolean Xd;
            int Xe;
            String Xf;
            ArrayList<String> Xg;

            private Builder() {
                this.Xa = false;
                this.Xb = true;
                this.Xc = 17;
                this.Xd = false;
                this.Xe = 4368;
                this.Xf = null;
                this.Xg = new ArrayList();
            }

            public final GamesOptions build() {
                return new GamesOptions();
            }

            public final Builder setSdkVariant(int i) {
                this.Xe = i;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z) {
                this.Xb = z;
                this.Xc = 17;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z, int i) {
                this.Xb = z;
                this.Xc = i;
                return this;
            }
        }

        private GamesOptions() {
            this.Xa = false;
            this.Xb = true;
            this.Xc = 17;
            this.Xd = false;
            this.Xe = 4368;
            this.Xf = null;
            this.Xg = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.Xa = builder.Xa;
            this.Xb = builder.Xb;
            this.Xc = builder.Xc;
            this.Xd = builder.Xd;
            this.Xe = builder.Xe;
            this.Xf = builder.Xf;
            this.Xg = builder.Xg;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    static {
        DQ = new C0490c();
        DR = new C08531();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api(DR, DQ, SCOPE_GAMES);
        WV = new Scope("https://www.googleapis.com/auth/games.firstparty");
        WW = new Api(DR, DQ, WV);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        WX = new AppContentsImpl();
        Events = new EventsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        WY = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Quests = new QuestsImpl();
        Requests = new RequestsImpl();
        Snapshots = new SnapshotsImpl();
        WZ = new AclsImpl();
    }

    private Games() {
    }

    public static GamesClientImpl m2826d(GoogleApiClient googleApiClient) {
        jx.m5221b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m5217a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return m2827e(googleApiClient);
    }

    public static GamesClientImpl m2827e(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.m1803a(DQ);
        jx.m5217a(gamesClientImpl != null, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient googleApiClient) {
        return m2826d(googleApiClient).lw();
    }

    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return m2826d(googleApiClient).lh();
    }

    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return m2826d(googleApiClient).lv();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return m2826d(googleApiClient).lu();
    }

    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        m2826d(googleApiClient).dS(i);
    }

    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        jx.m5223i(view);
        m2826d(googleApiClient).m3225k(view);
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new C08542(googleApiClient));
    }
}
