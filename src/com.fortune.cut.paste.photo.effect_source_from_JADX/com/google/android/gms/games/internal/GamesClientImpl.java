package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.C0494a;
import com.google.android.gms.common.api.C0495b;
import com.google.android.gms.common.api.C0509d;
import com.google.android.gms.common.api.C0509d.C0493b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0522a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ll;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends jl<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private final String DZ;
    EventIncrementManager Yk;
    private final String Yl;
    private final Map<String, RealTimeSocket> Ym;
    private PlayerEntity Yn;
    private GameEntity Yo;
    private final PopupManager Yp;
    private boolean Yq;
    private final Binder Yr;
    private final long Ys;
    private final GamesOptions Yt;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl.1 */
    class C08591 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl Yu;

        C08591(GamesClientImpl gamesClientImpl) {
            this.Yu = gamesClientImpl;
        }

        public EventIncrementCache lF() {
            return new GameClientEventIncrementCache(this.Yu);
        }
    }

    private static abstract class AbstractRoomStatusNotifier extends C0494a<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void m3006a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            m3007a(roomStatusUpdateListener, GamesClientImpl.m3118R(dataHolder));
        }

        protected abstract void m3007a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> Yv;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            this.Yv = new ArrayList();
            for (Object add : strArr) {
                this.Yv.add(add);
            }
        }

        protected void m3009a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m3010a(roomStatusUpdateListener, room, this.Yv);
        }

        protected abstract void m3010a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends C0494a<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void m3011a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            m3012a(roomUpdateListener, GamesClientImpl.m3118R(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void m3012a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static final class AcceptQuestResultImpl extends C0495b implements AcceptQuestResult {
        private final Quest Yw;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.Yw = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public final Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<UpdateAchievementResult> Ea;

        AchievementUpdatedBinderCallback(C0433b<UpdateAchievementResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3014g(int i, String str) {
            this.Ea.m1609b(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadAchievementsResult> Ea;

        AchievementsLoadedBinderCallback(C0433b<LoadAchievementsResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3015c(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadAppContentResult> Yx;

        public AppContentLoadedBinderCallbacks(C0433b<LoadAppContentResult> c0433b) {
            this.Yx = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3016a(DataHolder[] dataHolderArr) {
            this.Yx.m1609b(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status Eb;
        private final String Yy;

        CancelMatchResultImpl(Status status, String str) {
            this.Eb = status;
            this.Yy = str;
        }

        public final String getMatchId() {
            return this.Yy;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class ClaimMilestoneResultImpl extends C0495b implements ClaimMilestoneResult {
        private final Quest Yw;
        private final Milestone Yz;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                    List mQ = this.Yw.mQ();
                    int size = mQ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) mQ.get(i)).getMilestoneId().equals(str)) {
                            this.Yz = (Milestone) mQ.get(i);
                            return;
                        }
                    }
                    this.Yz = null;
                } else {
                    this.Yz = null;
                    this.Yw = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public final Milestone getMilestone() {
            return this.Yz;
        }

        public final Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class CommitSnapshotResultImpl extends C0495b implements CommitSnapshotResult {
        private final SnapshotMetadata YA;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.YA = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.YA = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public final SnapshotMetadata getSnapshotMetadata() {
            return this.YA;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3017a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends C0495b implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<ContactSettingLoadResult> Ea;

        ContactSettingsLoadedBinderCallback(C0433b<ContactSettingLoadResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3018D(DataHolder dataHolder) {
            this.Ea.m1609b(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<Status> Ea;

        ContactSettingsUpdatedBinderCallback(C0433b<Status> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void dP(int i) {
            this.Ea.m1609b(new Status(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status Eb;
        private final String YB;

        DeleteSnapshotResultImpl(int i, String str) {
            this.Eb = new Status(i);
            this.YB = str;
        }

        public final String getSnapshotId() {
            return this.YB;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3019a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadEventsResult> Ea;

        EventsLoadedBinderCallback(C0433b<LoadEventsResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3020d(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadExtendedGamesResult> Ea;

        ExtendedGamesLoadedBinderCallback(C0433b<LoadExtendedGamesResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3021j(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl Yu;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.Yu = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
        }

        protected void m3025r(String str, int i) {
            try {
                if (this.Yu.isConnected()) {
                    ((IGamesService) this.Yu.hw()).m3446o(str, i);
                } else {
                    GamesLog.m3243p("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.m3242o("GamesClientImpl", "service died");
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadGameInstancesResult> Ea;

        GameInstancesLoadedBinderCallback(C0433b<LoadGameInstancesResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3026k(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.Eb = new Status(i);
            this.YC = str;
            this.YD = z;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<GameMuteStatusChangeResult> Ea;

        GameMuteStatusChangedBinderCallback(C0433b<GameMuteStatusChangeResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3027a(int i, String str, boolean z) {
            this.Ea.m1609b(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.Eb = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.YC = dataHolder.m1865c("external_game_id", 0, 0);
                    this.YD = dataHolder.m1866d("muted", 0, 0);
                } else {
                    this.YC = null;
                    this.YD = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<GameMuteStatusLoadResult> Ea;

        GameMuteStatusLoadedBinderCallback(C0433b<GameMuteStatusLoadResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3028B(DataHolder dataHolder) {
            this.Ea.m1609b(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadGameSearchSuggestionsResult> Ea;

        GameSearchSuggestionsLoadedBinderCallback(C0433b<LoadGameSearchSuggestionsResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3029l(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadGamesResult> Ea;

        GamesLoadedBinderCallback(C0433b<LoadGamesResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3030i(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status Eb;
        private final Bundle YE;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.Eb = status;
            this.YE = bundle;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<InboxCountResult> Ea;

        InboxCountsLoadedBinderCallback(C0433b<InboxCountResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3031f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.m1609b(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static abstract class TurnBasedMatchResult extends C0495b {
        final TurnBasedMatch Zc;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Zc = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Zc = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.Zc;
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0509d<OnInvitationReceivedListener> Qe;

        InvitationReceivedBinderCallback(C0509d<OnInvitationReceivedListener> c0509d) {
            this.Qe = c0509d;
        }

        public final void m3032n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.Qe.m1840a(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }

        public final void onInvitationRemoved(String str) {
            this.Qe.m1840a(new InvitationRemovedNotifier(str));
        }
    }

    private static final class InvitationReceivedNotifier implements C0493b<OnInvitationReceivedListener> {
        private final Invitation YF;

        InvitationReceivedNotifier(Invitation invitation) {
            this.YF = invitation;
        }

        public final void m3033a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.YF);
        }

        public final /* synthetic */ void m3034c(Object obj) {
            m3033a((OnInvitationReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class InvitationRemovedNotifier implements C0493b<OnInvitationReceivedListener> {
        private final String YG;

        InvitationRemovedNotifier(String str) {
            this.YG = str;
        }

        public final void m3035a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.YG);
        }

        public final /* synthetic */ void m3036c(Object obj) {
            m3035a((OnInvitationReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadInvitationsResult> Ea;

        InvitationsLoadedBinderCallback(C0433b<LoadInvitationsResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3037m(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3038a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends C0495b implements LeaderboardMetadataResult {
        private final LeaderboardBuffer YH;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YH = new LeaderboardBuffer(dataHolder);
        }

        public final LeaderboardBuffer getLeaderboards() {
            return this.YH;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadScoresResult> Ea;

        LeaderboardScoresLoadedBinderCallback(C0433b<LoadScoresResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3039a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.Ea.m1609b(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LeaderboardMetadataResult> Ea;

        LeaderboardsLoadedBinderCallback(C0433b<LeaderboardMetadataResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3040e(DataHolder dataHolder) {
            this.Ea.m1609b(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements C0493b<RoomUpdateListener> {
        private final int Iv;
        private final String YI;

        LeftRoomNotifier(int i, String str) {
            this.Iv = i;
            this.YI = str;
        }

        public final void m3041a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.Iv, this.YI);
        }

        public final /* synthetic */ void m3042c(Object obj) {
            m3041a((RoomUpdateListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class LoadAchievementsResultImpl extends C0495b implements LoadAchievementsResult {
        private final AchievementBuffer YJ;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YJ = new AchievementBuffer(dataHolder);
        }

        public final AchievementBuffer getAchievements() {
            return this.YJ;
        }
    }

    private static final class LoadAclResultImpl extends C0495b implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends C0495b implements LoadAppContentResult {
        private final ArrayList<DataHolder> YK;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.YK = new ArrayList(Arrays.asList(dataHolderArr));
        }
    }

    private static final class LoadEventResultImpl extends C0495b implements LoadEventsResult {
        private final EventBuffer YL;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YL = new EventBuffer(dataHolder);
        }

        public final EventBuffer getEvents() {
            return this.YL;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends C0495b implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer YM;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YM = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends C0495b implements LoadGameInstancesResult {
        private final GameInstanceBuffer YN;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YN = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends C0495b implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer YO;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YO = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    private static final class LoadGamesResultImpl extends C0495b implements LoadGamesResult {
        private final GameBuffer YP;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YP = new GameBuffer(dataHolder);
        }

        public final GameBuffer getGames() {
            return this.YP;
        }
    }

    private static final class LoadInvitationsResultImpl extends C0495b implements LoadInvitationsResult {
        private final InvitationBuffer YQ;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YQ = new InvitationBuffer(dataHolder);
        }

        public final InvitationBuffer getInvitations() {
            return this.YQ;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status Eb;
        private final LoadMatchesResponse YR;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.Eb = status;
            this.YR = new LoadMatchesResponse(bundle);
        }

        public final LoadMatchesResponse getMatches() {
            return this.YR;
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final void release() {
            this.YR.release();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle DJ;
        private final Status Eb;

        LoadOwnerCoverPhotoUrisResultImpl(int i, Bundle bundle) {
            this.Eb = new Status(i);
            this.DJ = bundle;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends C0495b implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity YS;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.YS = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.YS = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public final LeaderboardScore getScore() {
            return this.YS;
        }
    }

    private static final class LoadPlayersResultImpl extends C0495b implements LoadPlayersResult {
        private final PlayerBuffer YT;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YT = new PlayerBuffer(dataHolder);
        }

        public final PlayerBuffer getPlayers() {
            return this.YT;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends C0495b implements LoadProfileSettingsResult {
        private final boolean YU;
        private final boolean Yh;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int au = dataHolder.au(0);
                    this.Yh = dataHolder.m1866d("profile_visible", 0, au);
                    this.YU = dataHolder.m1866d("profile_visibility_explicitly_set", 0, au);
                } else {
                    this.Yh = true;
                    this.YU = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final boolean isProfileVisible() {
            return this.Yh;
        }

        public final boolean isVisibilityExplicitlySet() {
            return this.YU;
        }
    }

    private static final class LoadQuestsResultImpl extends C0495b implements LoadQuestsResult {
        private final DataHolder JG;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.JG = dataHolder;
        }

        public final QuestBuffer getQuests() {
            return new QuestBuffer(this.JG);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends C0495b implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status Eb;
        private final Bundle YV;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.Eb = status;
            this.YV = bundle;
        }

        public final GameRequestBuffer getRequests(int i) {
            String dZ = RequestType.dZ(i);
            return !this.YV.containsKey(dZ) ? null : new GameRequestBuffer((DataHolder) this.YV.get(dZ));
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final void release() {
            for (String parcelable : this.YV.keySet()) {
                DataHolder dataHolder = (DataHolder) this.YV.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends C0495b implements LoadScoresResult {
        private final LeaderboardEntity YW;
        private final LeaderboardScoreBuffer YX;

        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.YW = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.YW = null;
                }
                leaderboardBuffer.release();
                this.YX = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public final Leaderboard getLeaderboard() {
            return this.YW;
        }

        public final LeaderboardScoreBuffer getScores() {
            return this.YX;
        }
    }

    private static final class LoadSnapshotsResultImpl extends C0495b implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.JG);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status Eb;
        private final List<String> YY;
        private final Bundle YZ;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.Eb = status;
            this.YY = bundle.getStringArrayList("game_category_list");
            this.YZ = bundle;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadXpStreamResultImpl extends C0495b implements LoadXpStreamResult {
        private final ExperienceEventBuffer Za;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Za = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements C0493b<OnTurnBasedMatchUpdateReceivedListener> {
        private final String Zb;

        MatchRemovedNotifier(String str) {
            this.Zb = str;
        }

        public final void m3043a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Zb);
        }

        public final /* synthetic */ void m3044c(Object obj) {
            m3043a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0509d<OnTurnBasedMatchUpdateReceivedListener> Qe;

        MatchUpdateReceivedBinderCallback(C0509d<OnTurnBasedMatchUpdateReceivedListener> c0509d) {
            this.Qe = c0509d;
        }

        public final void onTurnBasedMatchRemoved(String str) {
            this.Qe.m1840a(new MatchRemovedNotifier(str));
        }

        public final void m3045t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.Qe.m1840a(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements C0493b<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch Zc;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.Zc = turnBasedMatch;
        }

        public final void m3046a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Zc);
        }

        public final /* synthetic */ void m3047c(Object obj) {
            m3046a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class MessageReceivedNotifier implements C0493b<RealTimeMessageReceivedListener> {
        private final RealTimeMessage Zd;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.Zd = realTimeMessage;
        }

        public final void m3048a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Zd);
        }

        public final /* synthetic */ void m3049c(Object obj) {
            m3048a((RealTimeMessageReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements C0493b<OnNearbyPlayerDetectedListener> {
        private final Player Ze;

        public final void m3050a(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.m2828a(this.Ze);
        }

        public final /* synthetic */ void m3051c(Object obj) {
            m3050a((OnNearbyPlayerDetectedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadAclResult> Ea;

        NotifyAclLoadedBinderCallback(C0433b<LoadAclResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3052C(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<Status> Ea;

        NotifyAclUpdatedBinderCallback(C0433b<Status> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void dO(int i) {
            this.Ea.m1609b(new Status(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends C0495b implements OpenSnapshotResult {
        private final Snapshot Zf;
        private final String Zg;
        private final Snapshot Zh;
        private final Contents Zi;
        private final SnapshotContents Zj;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            boolean z = true;
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.Zf = null;
                    this.Zh = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (dataHolder.getStatusCode() == WearableStatusCodes.INVALID_TARGET_NODE) {
                        z = false;
                    }
                    je.m5079K(z);
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.Zh = null;
                } else {
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.Zh = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                }
                snapshotMetadataBuffer.release();
                this.Zg = str;
                this.Zi = contents3;
                this.Zj = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public final String getConflictId() {
            return this.Zg;
        }

        public final Snapshot getConflictingSnapshot() {
            return this.Zh;
        }

        public final SnapshotContents getResolutionSnapshotContents() {
            return this.Zj;
        }

        public final Snapshot getSnapshot() {
            return this.Zf;
        }
    }

    private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadOwnerCoverPhotoUrisResult> Ea;

        OwnerCoverPhotoUrisLoadedBinderCallback(C0433b<LoadOwnerCoverPhotoUrisResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3053d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.m1609b(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private static final class P2PConnectedNotifier implements C0493b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PConnectedNotifier(String str) {
            this.Zk = str;
        }

        public final void m3054a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.Zk);
        }

        public final /* synthetic */ void m3055c(Object obj) {
            m3054a((RoomStatusUpdateListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class P2PDisconnectedNotifier implements C0493b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PDisconnectedNotifier(String str) {
            this.Zk = str;
        }

        public final void m3056a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.Zk);
        }

        public final /* synthetic */ void m3057c(Object obj) {
            m3056a((RoomStatusUpdateListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3058a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3059a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3060a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3061a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3062a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected final void m3063a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadPlayerScoreResult> Ea;

        PlayerLeaderboardScoreLoadedBinderCallback(C0433b<LoadPlayerScoreResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3064E(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadXpForGameCategoriesResult> Ea;

        PlayerXpForGameCategoriesLoadedBinderCallback(C0433b<LoadXpForGameCategoriesResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3065e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.m1609b(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadXpStreamResult> Ea;

        PlayerXpStreamLoadedBinderCallback(C0433b<LoadXpStreamResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3066P(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadPlayersResult> Ea;

        PlayersLoadedBinderCallback(C0433b<LoadPlayersResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3067g(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadPlayersResultImpl(dataHolder));
        }

        public final void m3068h(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadPlayersResultImpl(dataHolder));
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<LoadProfileSettingsResult> Ea;

        ProfileSettingsLoadedBinderCallback(C0433b<LoadProfileSettingsResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3069Q(DataHolder dataHolder) {
            this.Ea.m1609b(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0433b<Status> Ea;

        ProfileSettingsUpdatedBinderCallback(C0433b<Status> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void dQ(int i) {
            this.Ea.m1609b(new Status(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<AcceptQuestResult> Zl;

        public QuestAcceptedBinderCallbacks(C0433b<AcceptQuestResult> c0433b) {
            this.Zl = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3070L(DataHolder dataHolder) {
            this.Zl.m1609b(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements C0493b<QuestUpdateListener> {
        private final Quest Yw;

        QuestCompletedNotifier(Quest quest) {
            this.Yw = quest;
        }

        public final void m3071a(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.Yw);
        }

        public final /* synthetic */ void m3072c(Object obj) {
            m3071a((QuestUpdateListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<ClaimMilestoneResult> Zm;
        private final String Zn;

        public QuestMilestoneClaimBinderCallbacks(C0433b<ClaimMilestoneResult> c0433b, String str) {
            this.Zm = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
            this.Zn = (String) jx.m5219b((Object) str, (Object) "MilestoneId must not be null");
        }

        public final void m3073K(DataHolder dataHolder) {
            this.Zm.m1609b(new ClaimMilestoneResultImpl(dataHolder, this.Zn));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final C0509d<QuestUpdateListener> Qe;

        QuestUpdateBinderCallback(C0509d<QuestUpdateListener> c0509d) {
            this.Qe = c0509d;
        }

        private Quest m3074T(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public final void m3075M(DataHolder dataHolder) {
            Quest T = m3074T(dataHolder);
            if (T != null) {
                this.Qe.m1840a(new QuestCompletedNotifier(T));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadQuestsResult> Zo;

        public QuestsLoadedBinderCallbacks(C0433b<LoadQuestsResult> c0433b) {
            this.Zo = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3076O(DataHolder dataHolder) {
            this.Zo.m1609b(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements C0493b<ReliableMessageSentCallback> {
        private final int Iv;
        private final String Zp;
        private final int Zq;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.Iv = i;
            this.Zq = i2;
            this.Zp = str;
        }

        public final void m3077a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.Iv, this.Zq, this.Zp);
            }
        }

        public final /* synthetic */ void m3078c(Object obj) {
            m3077a((ReliableMessageSentCallback) obj);
        }

        public final void gG() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final C0509d<ReliableMessageSentCallback> Zr;

        public RealTimeReliableMessageBinderCallbacks(C0509d<ReliableMessageSentCallback> c0509d) {
            this.Zr = c0509d;
        }

        public final void m3079b(int i, int i2, String str) {
            if (this.Zr != null) {
                this.Zr.m1840a(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0509d<OnRequestReceivedListener> Qe;

        RequestReceivedBinderCallback(C0509d<OnRequestReceivedListener> c0509d) {
            this.Qe = c0509d;
        }

        public final void m3080o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.Qe.m1840a(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }

        public final void onRequestRemoved(String str) {
            this.Qe.m1840a(new RequestRemovedNotifier(str));
        }
    }

    private static final class RequestReceivedNotifier implements C0493b<OnRequestReceivedListener> {
        private final GameRequest Zs;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.Zs = gameRequest;
        }

        public final void m3081a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Zs);
        }

        public final /* synthetic */ void m3082c(Object obj) {
            m3081a((OnRequestReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class RequestRemovedNotifier implements C0493b<OnRequestReceivedListener> {
        private final String Zt;

        RequestRemovedNotifier(String str) {
            this.Zt = str;
        }

        public final void m3083a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Zt);
        }

        public final /* synthetic */ void m3084c(Object obj) {
            m3083a((OnRequestReceivedListener) obj);
        }

        public final void gG() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<SendRequestResult> Zu;

        public RequestSentBinderCallbacks(C0433b<SendRequestResult> c0433b) {
            this.Zu = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3085G(DataHolder dataHolder) {
            this.Zu.m1609b(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadRequestSummariesResult> Zv;

        public RequestSummariesLoadedBinderCallbacks(C0433b<LoadRequestSummariesResult> c0433b) {
            this.Zv = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3086H(DataHolder dataHolder) {
            this.Zv.m1609b(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadRequestsResult> Zw;

        public RequestsLoadedBinderCallbacks(C0433b<LoadRequestsResult> c0433b) {
            this.Zw = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3087c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Zw.m1609b(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<UpdateRequestsResult> Zx;

        public RequestsUpdatedBinderCallbacks(C0433b<UpdateRequestsResult> c0433b) {
            this.Zx = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3088F(DataHolder dataHolder) {
            this.Zx.m1609b(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3089a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final C0509d<RealTimeMessageReceivedListener> ZA;
        private final C0509d<? extends RoomUpdateListener> Zy;
        private final C0509d<? extends RoomStatusUpdateListener> Zz;

        public RoomBinderCallbacks(C0509d<RoomUpdateListener> c0509d) {
            this.Zy = (C0509d) jx.m5219b((Object) c0509d, (Object) "Callbacks must not be null");
            this.Zz = null;
            this.ZA = null;
        }

        public RoomBinderCallbacks(C0509d<? extends RoomUpdateListener> c0509d, C0509d<? extends RoomStatusUpdateListener> c0509d2, C0509d<RealTimeMessageReceivedListener> c0509d3) {
            this.Zy = (C0509d) jx.m5219b((Object) c0509d, (Object) "Callbacks must not be null");
            this.Zz = c0509d2;
            this.ZA = c0509d3;
        }

        public final void m3090A(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m1840a(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public final void m3091a(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public final void m3092b(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public final void m3093c(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public final void m3094d(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public final void m3095e(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public final void m3096f(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m1840a(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public final void onLeftRoom(int i, String str) {
            this.Zy.m1840a(new LeftRoomNotifier(i, str));
        }

        public final void onP2PConnected(String str) {
            if (this.Zz != null) {
                this.Zz.m1840a(new P2PConnectedNotifier(str));
            }
        }

        public final void onP2PDisconnected(String str) {
            if (this.Zz != null) {
                this.Zz.m1840a(new P2PDisconnectedNotifier(str));
            }
        }

        public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.ZA != null) {
                this.ZA.m1840a(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        public final void m3097u(DataHolder dataHolder) {
            this.Zy.m1840a(new RoomCreatedNotifier(dataHolder));
        }

        public final void m3098v(DataHolder dataHolder) {
            this.Zy.m1840a(new JoinedRoomNotifier(dataHolder));
        }

        public final void m3099w(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m1840a(new RoomConnectingNotifier(dataHolder));
            }
        }

        public final void m3100x(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m1840a(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public final void m3101y(DataHolder dataHolder) {
            this.Zy.m1840a(new RoomConnectedNotifier(dataHolder));
        }

        public final void m3102z(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m1840a(new ConnectedToRoomNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3103a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3104a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final void m3105a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends C0495b implements SendRequestResult {
        private final GameRequest Zs;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.Zs = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.Zs = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<Status> Ea;

        public SignOutCompleteBinderCallbacks(C0433b<Status> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void fK() {
            this.Ea.m1609b(new Status(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<CommitSnapshotResult> ZB;

        public SnapshotCommittedBinderCallbacks(C0433b<CommitSnapshotResult> c0433b) {
            this.ZB = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3106J(DataHolder dataHolder) {
            this.ZB.m1609b(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<DeleteSnapshotResult> Ea;

        public SnapshotDeletedBinderCallbacks(C0433b<DeleteSnapshotResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3107i(int i, String str) {
            this.Ea.m1609b(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<OpenSnapshotResult> ZC;

        public SnapshotOpenedBinderCallbacks(C0433b<OpenSnapshotResult> c0433b) {
            this.ZC = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3108a(DataHolder dataHolder, Contents contents) {
            this.ZC.m1609b(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public final void m3109a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.ZC.m1609b(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadSnapshotsResult> ZD;

        public SnapshotsLoadedBinderCallbacks(C0433b<LoadSnapshotsResult> c0433b) {
            this.ZD = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3110I(DataHolder dataHolder) {
            this.ZD.m1609b(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<SubmitScoreResult> Ea;

        public SubmitScoreBinderCallbacks(C0433b<SubmitScoreResult> c0433b) {
            this.Ea = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3111f(DataHolder dataHolder) {
            this.Ea.m1609b(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends C0495b implements SubmitScoreResult {
        private final ScoreSubmissionData ZE;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.ZE = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public final ScoreSubmissionData getScoreData() {
            return this.ZE;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<CancelMatchResult> ZF;

        public TurnBasedMatchCanceledBinderCallbacks(C0433b<CancelMatchResult> c0433b) {
            this.ZF = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3112h(int i, String str) {
            this.ZF.m1609b(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<InitiateMatchResult> ZG;

        public TurnBasedMatchInitiatedBinderCallbacks(C0433b<InitiateMatchResult> c0433b) {
            this.ZG = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3113q(DataHolder dataHolder) {
            this.ZG.m1609b(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LeaveMatchResult> ZH;

        public TurnBasedMatchLeftBinderCallbacks(C0433b<LeaveMatchResult> c0433b) {
            this.ZH = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3114s(DataHolder dataHolder) {
            this.ZH.m1609b(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadMatchResult> ZI;

        public TurnBasedMatchLoadedBinderCallbacks(C0433b<LoadMatchResult> c0433b) {
            this.ZI = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3115p(DataHolder dataHolder) {
            this.ZI.m1609b(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<UpdateMatchResult> ZJ;

        public TurnBasedMatchUpdatedBinderCallbacks(C0433b<UpdateMatchResult> c0433b) {
            this.ZJ = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3116r(DataHolder dataHolder) {
            this.ZJ.m1609b(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0433b<LoadMatchesResult> ZK;

        public TurnBasedMatchesLoadedBinderCallbacks(C0433b<LoadMatchesResult> c0433b) {
            this.ZK = (C0433b) jx.m5219b((Object) c0433b, (Object) "Holder must not be null");
        }

        public final void m3117b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.ZK.m1609b(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status Eb;
        private final String Xx;

        UpdateAchievementResultImpl(int i, String str) {
            this.Eb = new Status(i);
            this.Xx = str;
        }

        public final String getAchievementId() {
            return this.Xx;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends C0495b implements UpdateRequestsResult {
        private final RequestUpdateOutcomes ZL;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.ZL = RequestUpdateOutcomes.m4019W(dataHolder);
        }

        public final Set<String> getRequestIds() {
            return this.ZL.getRequestIds();
        }

        public final int getRequestOutcome(String str) {
            return this.ZL.getRequestOutcome(str);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, GamesOptions gamesOptions) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.Yk = new C08591(this);
        this.Yq = false;
        this.Yl = str;
        this.DZ = (String) jx.m5223i(str2);
        this.Yr = new Binder();
        this.Ym = new HashMap();
        this.Yp = PopupManager.m3694a(this, i);
        m3225k(view);
        this.Ys = (long) hashCode();
        this.Yt = gamesOptions;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private static Room m3118R(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private RealTimeSocket bB(String str) {
        RealTimeSocket bD = ll.ii() ? bD(str) : bC(str);
        if (bD != null) {
            this.Ym.put(str, bD);
        }
        return bD;
    }

    private RealTimeSocket bC(String str) {
        try {
            String bH = ((IGamesService) hw()).bH(str);
            if (bH == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress(bH));
            return new RealTimeSocketImpl(localSocket, str);
        } catch (RemoteException e) {
            GamesLog.m3243p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        } catch (IOException e2) {
            GamesLog.m3243p("GamesClientImpl", "connect() call failed on socket: " + e2.getMessage());
            return null;
        }
    }

    private RealTimeSocket bD(String str) {
        try {
            ParcelFileDescriptor bN = ((IGamesService) hw()).bN(str);
            if (bN != null) {
                GamesLog.m3241n("GamesClientImpl", "Created native libjingle socket.");
                return new LibjingleNativeSocket(bN);
            }
            GamesLog.m3243p("GamesClientImpl", "Unable to create socket for " + str);
            return null;
        } catch (RemoteException e) {
            GamesLog.m3243p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void lD() {
        for (RealTimeSocket close : this.Ym.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m3240c("GamesClientImpl", "IOException:", e);
            }
        }
        this.Ym.clear();
    }

    private void lg() {
        this.Yn = null;
    }

    public final int m3120a(C0509d<ReliableMessageSentCallback> c0509d, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) hw()).m3309a(new RealTimeReliableMessageBinderCallbacks(c0509d), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final int m3121a(byte[] bArr, String str, String[] strArr) {
        jx.m5219b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) hw()).m3370b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final Intent m3122a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).m3310a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent m3123a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) hw()).m3311a(i, bArr, i2, str);
            jx.m5219b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent m3124a(Room room, int i) {
        try {
            return ((IGamesService) hw()).m3315a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent m3125a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) hw()).m3316a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    protected final void m3126a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Yq = bundle.getBoolean("show_welcome_popup");
        }
        super.m2258a(i, iBinder, bundle);
    }

    public final void m3127a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).m3320a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m3242o("GamesClientImpl", "service died");
            }
        }
    }

    public final void m3128a(C0433b<LoadRequestsResult> c0433b, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).m3324a(new RequestsLoadedBinderCallbacks(c0433b), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3129a(C0433b<LoadExtendedGamesResult> c0433b, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3325a(new ExtendedGamesLoadedBinderCallback(c0433b), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3130a(C0433b<LoadAppContentResult> c0433b, int i, String str, String[] strArr, boolean z) {
        try {
            ((IGamesService) hw()).m3327a(new AppContentLoadedBinderCallbacks(c0433b), i, str, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3131a(C0433b<LoadPlayersResult> c0433b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3328a(new PlayersLoadedBinderCallback(c0433b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3132a(C0433b<LoadMatchesResult> c0433b, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).m3329a(new TurnBasedMatchesLoadedBinderCallbacks(c0433b), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3133a(C0433b<LoadScoresResult> c0433b, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) hw()).m3332a(new LeaderboardScoresLoadedBinderCallback(c0433b), leaderboardScoreBuffer.mH().mI(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3134a(C0433b<InitiateMatchResult> c0433b, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) hw()).m3326a(new TurnBasedMatchInitiatedBinderCallbacks(c0433b), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.mO(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3135a(C0433b<CommitSnapshotResult> c0433b, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.m5217a(!snapshotContents.isClosed(), "Snapshot already closed");
        C0522a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.m1873a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).m3346a(new SnapshotCommittedBinderCallbacks(c0433b), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3136a(C0433b<UpdateAchievementResult> c0433b, String str) {
        if (c0433b == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(c0433b);
        }
        try {
            ((IGamesService) hw()).m3345a(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3137a(C0433b<UpdateAchievementResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3338a(c0433b == null ? null : new AchievementUpdatedBinderCallback(c0433b), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3138a(C0433b<LoadScoresResult> c0433b, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).m3337a(new LeaderboardScoresLoadedBinderCallback(c0433b), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3139a(C0433b<LoadPlayersResult> c0433b, String str, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case WalletFragmentState.UNKNOWN /*0*/:
                try {
                    ((IGamesService) hw()).m3413d(new PlayersLoadedBinderCallback(c0433b), str, i, z, z2);
                } catch (RemoteException e) {
                    GamesLog.m3242o("GamesClientImpl", "service died");
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public final void m3140a(C0433b<LoadExtendedGamesResult> c0433b, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) hw()).m3341a(new ExtendedGamesLoadedBinderCallback(c0433b), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3141a(C0433b<LoadMatchesResult> c0433b, String str, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).m3342a(new TurnBasedMatchesLoadedBinderCallbacks(c0433b), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3142a(C0433b<SubmitScoreResult> c0433b, String str, long j, String str2) {
        try {
            ((IGamesService) hw()).m3344a(c0433b == null ? null : new SubmitScoreBinderCallbacks(c0433b), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3143a(C0433b<LeaveMatchResult> c0433b, String str, String str2) {
        try {
            ((IGamesService) hw()).m3401c(new TurnBasedMatchLeftBinderCallbacks(c0433b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3144a(C0433b<LoadPlayerScoreResult> c0433b, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) hw()).m3348a(new PlayerLeaderboardScoreLoadedBinderCallback(c0433b), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3145a(C0433b<LoadRequestsResult> c0433b, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).m3349a(new RequestsLoadedBinderCallbacks(c0433b), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3146a(C0433b<LoadScoresResult> c0433b, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).m3350a(new LeaderboardScoresLoadedBinderCallback(c0433b), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3147a(C0433b<LoadPlayersResult> c0433b, String str, String str2, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case WalletFragmentState.UNKNOWN /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
                try {
                    ((IGamesService) hw()).m3351a(new PlayersLoadedBinderCallback(c0433b), str, str2, i, z, z2);
                } catch (RemoteException e) {
                    GamesLog.m3242o("GamesClientImpl", "service died");
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public final void m3148a(C0433b<OpenSnapshotResult> c0433b, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        jx.m5217a(!snapshotContents.isClosed(), "SnapshotContents already closed");
        C0522a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.m1873a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).m3352a(new SnapshotOpenedBinderCallbacks(c0433b), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3149a(C0433b<LeaderboardMetadataResult> c0433b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).m3388b(new LeaderboardsLoadedBinderCallback(c0433b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3150a(C0433b<LoadQuestsResult> c0433b, String str, String str2, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3356a(new QuestsLoadedBinderCallbacks(c0433b), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3151a(C0433b<LoadQuestsResult> c0433b, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3354a(new QuestsLoadedBinderCallbacks(c0433b), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3152a(C0433b<UpdateRequestsResult> c0433b, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) hw()).m3355a(new RequestsUpdatedBinderCallbacks(c0433b), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3153a(C0433b<LoadPlayersResult> c0433b, String str, boolean z) {
        try {
            ((IGamesService) hw()).m3428f(new PlayersLoadedBinderCallback(c0433b), str, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3154a(C0433b<UpdateMatchResult> c0433b, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).m3358a(new TurnBasedMatchUpdatedBinderCallbacks(c0433b), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3155a(C0433b<UpdateMatchResult> c0433b, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).m3359a(new TurnBasedMatchUpdatedBinderCallbacks(c0433b), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3156a(C0433b<SendRequestResult> c0433b, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) hw()).m3361a(new RequestSentBinderCallbacks(c0433b), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3157a(C0433b<LoadPlayersResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3404c(new PlayersLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3158a(C0433b<Status> c0433b, boolean z, Bundle bundle) {
        try {
            ((IGamesService) hw()).m3363a(new ContactSettingsUpdatedBinderCallback(c0433b), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3159a(C0433b<LoadEventsResult> c0433b, boolean z, String... strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3364a(new EventsLoadedBinderCallback(c0433b), z, strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3160a(C0433b<LoadQuestsResult> c0433b, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3366a(new QuestsLoadedBinderCallbacks(c0433b), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3161a(C0433b<LoadPlayersResult> c0433b, String[] strArr) {
        try {
            ((IGamesService) hw()).m3405c(new PlayersLoadedBinderCallback(c0433b), strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3162a(C0509d<OnInvitationReceivedListener> c0509d) {
        try {
            ((IGamesService) hw()).m3330a(new InvitationReceivedBinderCallback(c0509d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3163a(C0509d<RoomUpdateListener> c0509d, C0509d<RoomStatusUpdateListener> c0509d2, C0509d<RealTimeMessageReceivedListener> c0509d3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).m3333a(new RoomBinderCallbacks(c0509d, c0509d2, c0509d3), this.Yr, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3164a(C0509d<RoomUpdateListener> c0509d, String str) {
        try {
            ((IGamesService) hw()).m3398c(new RoomBinderCallbacks(c0509d), str);
            lD();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3165a(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.m5217a(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).m3321a(ir);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    protected final void m3166a(jt jtVar, C1250e c1250e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Yt.Xa);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Yt.Xb);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Yt.Xc);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Yt.Xd);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Yt.Xe);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Yt.Xf);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Yt.Xg);
        jtVar.m5130a(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv(), this.Yl, this.Yp.lV(), locale, bundle);
    }

    protected final IGamesService aC(IBinder iBinder) {
        return Stub.aE(iBinder);
    }

    public final Intent m3167b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).m3371b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent m3168b(int[] iArr) {
        try {
            return ((IGamesService) hw()).m3372b(iArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final void m3169b(C0433b<Status> c0433b) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3322a(new SignOutCompleteBinderCallbacks(c0433b));
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3170b(C0433b<LoadPlayersResult> c0433b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3375b(new PlayersLoadedBinderCallback(c0433b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3171b(C0433b<UpdateAchievementResult> c0433b, String str) {
        if (c0433b == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(c0433b);
        }
        try {
            ((IGamesService) hw()).m3384b(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3172b(C0433b<UpdateAchievementResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3381b(c0433b == null ? null : new AchievementUpdatedBinderCallback(c0433b), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3173b(C0433b<LoadScoresResult> c0433b, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).m3380b(new LeaderboardScoresLoadedBinderCallback(c0433b), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3174b(C0433b<LoadExtendedGamesResult> c0433b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3340a(new ExtendedGamesLoadedBinderCallback(c0433b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3175b(C0433b<ClaimMilestoneResult> c0433b, String str, String str2) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3427f(new QuestMilestoneClaimBinderCallbacks(c0433b, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3176b(C0433b<LoadScoresResult> c0433b, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).m3386b(new LeaderboardScoresLoadedBinderCallback(c0433b), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3177b(C0433b<LoadPlayersResult> c0433b, String str, String str2, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3387b(new PlayersLoadedBinderCallback(c0433b), str, str2, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3178b(C0433b<LoadAchievementsResult> c0433b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).m3353a(new AchievementsLoadedBinderCallback(c0433b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3179b(C0433b<LeaderboardMetadataResult> c0433b, String str, boolean z) {
        try {
            ((IGamesService) hw()).m3403c(new LeaderboardsLoadedBinderCallback(c0433b), str, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3180b(C0433b<LeaderboardMetadataResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3390b(new LeaderboardsLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3181b(C0433b<LoadQuestsResult> c0433b, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3368a(new QuestsLoadedBinderCallbacks(c0433b), strArr, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3182b(C0433b<UpdateRequestsResult> c0433b, String[] strArr) {
        try {
            ((IGamesService) hw()).m3367a(new RequestsUpdatedBinderCallbacks(c0433b), strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3183b(C0509d<OnTurnBasedMatchUpdateReceivedListener> c0509d) {
        try {
            ((IGamesService) hw()).m3376b(new MatchUpdateReceivedBinderCallback(c0509d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3184b(C0509d<RoomUpdateListener> c0509d, C0509d<RoomStatusUpdateListener> c0509d2, C0509d<RealTimeMessageReceivedListener> c0509d3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).m3334a(new RoomBinderCallbacks(c0509d, c0509d2, c0509d3), this.Yr, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void bA(String str) {
        try {
            ((IGamesService) hw()).bL(str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final Intent bE(String str) {
        try {
            return ((IGamesService) hw()).bE(str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final void bF(String str) {
        try {
            ((IGamesService) hw()).m3369a(str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    protected final String bK() {
        return "com.google.android.gms.games.service.START";
    }

    protected final String bL() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public final void m3185c(C0433b<LoadInvitationsResult> c0433b, int i) {
        try {
            ((IGamesService) hw()).m3323a(new InvitationsLoadedBinderCallback(c0433b), i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3186c(C0433b<LoadPlayersResult> c0433b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3395c(new PlayersLoadedBinderCallback(c0433b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3187c(C0433b<InitiateMatchResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3442l(new TurnBasedMatchInitiatedBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3188c(C0433b<LoadXpStreamResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3379b(new PlayerXpStreamLoadedBinderCallback(c0433b), str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3189c(C0433b<LoadExtendedGamesResult> c0433b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3420e(new ExtendedGamesLoadedBinderCallback(c0433b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3190c(C0433b<InitiateMatchResult> c0433b, String str, String str2) {
        try {
            ((IGamesService) hw()).m3414d(new TurnBasedMatchInitiatedBinderCallbacks(c0433b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3191c(C0433b<LoadSnapshotsResult> c0433b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).m3402c(new SnapshotsLoadedBinderCallbacks(c0433b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3192c(C0433b<OpenSnapshotResult> c0433b, String str, boolean z) {
        try {
            ((IGamesService) hw()).m3422e(new SnapshotOpenedBinderCallbacks(c0433b), str, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3193c(C0433b<LoadAchievementsResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3362a(new AchievementsLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3194c(C0433b<UpdateRequestsResult> c0433b, String[] strArr) {
        try {
            ((IGamesService) hw()).m3391b(new RequestsUpdatedBinderCallbacks(c0433b), strArr);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3195c(C0509d<QuestUpdateListener> c0509d) {
        try {
            ((IGamesService) hw()).m3410d(new QuestUpdateBinderCallback(c0509d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    protected final void m3196c(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            jx.m5218a(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        jx.m5218a(z, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    public final void connect() {
        this.Yn = null;
        super.connect();
    }

    public final int m3197d(byte[] bArr, String str) {
        try {
            return ((IGamesService) hw()).m3370b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final void m3198d(C0433b<LoadPlayersResult> c0433b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3418e(new PlayersLoadedBinderCallback(c0433b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3199d(C0433b<InitiateMatchResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3443m(new TurnBasedMatchInitiatedBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3200d(C0433b<LoadXpStreamResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3399c(new PlayerXpStreamLoadedBinderCallback(c0433b), str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3201d(C0433b<LoadExtendedGamesResult> c0433b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3426f(new ExtendedGamesLoadedBinderCallback(c0433b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3202d(C0433b<InitiateMatchResult> c0433b, String str, String str2) {
        try {
            ((IGamesService) hw()).m3421e(new TurnBasedMatchInitiatedBinderCallbacks(c0433b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3203d(C0433b<LeaderboardMetadataResult> c0433b, String str, boolean z) {
        try {
            ((IGamesService) hw()).m3415d(new LeaderboardsLoadedBinderCallback(c0433b), str, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3204d(C0433b<LoadEventsResult> c0433b, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3429f(new EventsLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3205d(C0509d<OnRequestReceivedListener> c0509d) {
        try {
            ((IGamesService) hw()).m3396c(new RequestReceivedBinderCallback(c0509d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void dS(int i) {
        this.Yp.setGravity(i);
    }

    public final void dT(int i) {
        try {
            ((IGamesService) hw()).dT(i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void disconnect() {
        this.Yq = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) hw();
                iGamesService.lE();
                this.Yk.flush();
                iGamesService.m3449q(this.Ys);
            } catch (RemoteException e) {
                GamesLog.m3242o("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        lD();
        super.disconnect();
    }

    public final void m3206e(C0433b<LeaveMatchResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3445o(new TurnBasedMatchLeftBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3207e(C0433b<LoadInvitationsResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3382b(new InvitationsLoadedBinderCallback(c0433b), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3208e(C0433b<LoadExtendedGamesResult> c0433b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3400c(new ExtendedGamesLoadedBinderCallback(c0433b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3209e(C0433b<GameMuteStatusChangeResult> c0433b, String str, boolean z) {
        try {
            ((IGamesService) hw()).m3357a(new GameMuteStatusChangedBinderCallback(c0433b), str, z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3210e(C0433b<LoadSnapshotsResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3416d(new SnapshotsLoadedBinderCallbacks(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3211f(C0433b<LoadGamesResult> c0433b) {
        try {
            ((IGamesService) hw()).m3408d(new GamesLoadedBinderCallback(c0433b));
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3212f(C0433b<CancelMatchResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3444n(new TurnBasedMatchCanceledBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3213f(C0433b<LoadRequestSummariesResult> c0433b, String str, int i) {
        try {
            ((IGamesService) hw()).m3336a(new RequestSummariesLoadedBinderCallbacks(c0433b), str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3214f(C0433b<LoadPlayersResult> c0433b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).m3383b(new PlayersLoadedBinderCallback(c0433b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3215f(C0433b<LoadProfileSettingsResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3432g(new ProfileSettingsLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final Bundle fX() {
        try {
            Bundle fX = ((IGamesService) hw()).fX();
            if (fX == null) {
                return fX;
            }
            fX.setClassLoader(GamesClientImpl.class.getClassLoader());
            return fX;
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final void m3216g(C0433b<LoadOwnerCoverPhotoUrisResult> c0433b) {
        try {
            ((IGamesService) hw()).m3439j(new OwnerCoverPhotoUrisLoadedBinderCallback(c0433b));
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3217g(C0433b<LoadMatchResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3447p(new TurnBasedMatchLoadedBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3218g(C0433b<Status> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3436h(new ProfileSettingsUpdatedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3219h(C0433b<LoadAclResult> c0433b) {
        try {
            ((IGamesService) hw()).m3435h(new NotifyAclLoadedBinderCallback(c0433b));
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3220h(C0433b<AcceptQuestResult> c0433b, String str) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).m3463u(new QuestAcceptedBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3221h(C0433b<ContactSettingLoadResult> c0433b, boolean z) {
        try {
            ((IGamesService) hw()).m3423e(new ContactSettingsLoadedBinderCallback(c0433b), z);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3222i(C0433b<InboxCountResult> c0433b) {
        try {
            ((IGamesService) hw()).m3458t(new InboxCountsLoadedBinderCallback(c0433b), null);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3223i(C0433b<DeleteSnapshotResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3453r(new SnapshotDeletedBinderCallbacks(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3224j(C0433b<LoadExtendedGamesResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3419e(new ExtendedGamesLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3225k(View view) {
        this.Yp.m3695l(view);
    }

    public final void m3226k(C0433b<LoadGameInstancesResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3425f(new GameInstancesLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    protected final /* synthetic */ IInterface m3227l(IBinder iBinder) {
        return aC(iBinder);
    }

    public final void m3228l(C0433b<LoadGameSearchSuggestionsResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3450q(new GameSearchSuggestionsLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final int lA() {
        try {
            return ((IGamesService) hw()).lA();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final int lB() {
        try {
            return ((IGamesService) hw()).lB();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final int lC() {
        try {
            return ((IGamesService) hw()).lC();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final void lE() {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).lE();
            } catch (RemoteException e) {
                GamesLog.m3242o("GamesClientImpl", "service died");
            }
        }
    }

    public final String lh() {
        try {
            return ((IGamesService) hw()).lh();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final String li() {
        try {
            return ((IGamesService) hw()).li();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Player lj() {
        dS();
        synchronized (this) {
            if (this.Yn == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) hw()).lG());
                    if (playerBuffer.getCount() > 0) {
                        this.Yn = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m3242o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.Yn;
    }

    public final Game lk() {
        GameBuffer gameBuffer;
        dS();
        synchronized (this) {
            if (this.Yo == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) hw()).lI());
                    if (gameBuffer.getCount() > 0) {
                        this.Yo = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m3242o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.Yo;
    }

    public final Intent ll() {
        try {
            return ((IGamesService) hw()).ll();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent lm() {
        try {
            return ((IGamesService) hw()).lm();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent ln() {
        try {
            return ((IGamesService) hw()).ln();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent lo() {
        try {
            return ((IGamesService) hw()).lo();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final void lp() {
        try {
            ((IGamesService) hw()).m3452r(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void lq() {
        try {
            ((IGamesService) hw()).m3454s(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void lr() {
        try {
            ((IGamesService) hw()).m3462u(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void ls() {
        try {
            ((IGamesService) hw()).m3457t(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final Intent lt() {
        try {
            return ((IGamesService) hw()).lt();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final Intent lu() {
        try {
            return ((IGamesService) hw()).lu();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final int lv() {
        try {
            return ((IGamesService) hw()).lv();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public final String lw() {
        try {
            return ((IGamesService) hw()).lw();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final int lx() {
        try {
            return ((IGamesService) hw()).lx();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final Intent ly() {
        try {
            return ((IGamesService) hw()).ly();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final int lz() {
        try {
            return ((IGamesService) hw()).lz();
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public final void m3229m(C0433b<LoadXpForGameCategoriesResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3455s(new PlayerXpForGameCategoriesLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final Intent m3230n(String str, int i) {
        try {
            return ((IGamesService) hw()).m3461u(str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
            return null;
        }
    }

    public final void m3231n(C0433b<LoadInvitationsResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3441k(new InvitationsLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3232o(C0433b<Status> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3440j(new NotifyAclUpdatedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3233o(String str, int i) {
        this.Yk.m3005o(str, i);
    }

    public final void onConnected(Bundle bundle) {
        if (this.Yq) {
            this.Yp.lT();
            this.Yq = false;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.Yq = false;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void m3234p(C0433b<GameMuteStatusLoadResult> c0433b, String str) {
        try {
            ((IGamesService) hw()).m3438i(new GameMuteStatusLoadedBinderCallback(c0433b), str);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3235p(String str, int i) {
        try {
            ((IGamesService) hw()).m3448p(str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final void m3236q(String str, int i) {
        try {
            ((IGamesService) hw()).m3451q(str, i);
        } catch (RemoteException e) {
            GamesLog.m3242o("GamesClientImpl", "service died");
        }
    }

    public final RealTimeSocket m3237s(String str, String str2) {
        if (str2 == null || !ParticipantUtils.bY(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Ym.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? bB(str2) : realTimeSocket;
    }
}
