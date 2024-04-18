package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1 */
        class C09661 implements LoadSnapshotsResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadImpl abQ;

            C09661(LoadImpl loadImpl, Status status) {
                this.abQ = loadImpl;
                this.DS = status;
            }

            public SnapshotMetadataBuffer getSnapshots() {
                return new SnapshotMetadataBuffer(DataHolder.av(14));
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

        public LoadSnapshotsResult aq(Status status) {
            return new C09661(this, status);
        }

        public /* synthetic */ Result m3951c(Status status) {
            return aq(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.1 */
    class C09581 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ SnapshotsImpl abF;

        C09581(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.abF = snapshotsImpl;
            this.ZW = z;
            super(null);
        }

        protected void m3953a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3210e((C0433b) this, this.ZW);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1 */
        class C09671 implements OpenSnapshotResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ OpenImpl abR;

            C09671(OpenImpl openImpl, Status status) {
                this.abR = openImpl;
                this.DS = status;
            }

            public String getConflictId() {
                return null;
            }

            public Snapshot getConflictingSnapshot() {
                return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
                return null;
            }

            public Snapshot getSnapshot() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult ar(Status status) {
            return new C09671(this, status);
        }

        public /* synthetic */ Result m3954c(Status status) {
            return ar(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.2 */
    class C09592 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl abF;
        final /* synthetic */ String abG;
        final /* synthetic */ boolean abH;

        C09592(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.abF = snapshotsImpl;
            this.abG = str;
            this.abH = z;
            super(null);
        }

        protected void m3956a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3192c((C0433b) this, this.abG, this.abH);
        }
    }

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1 */
        class C09641 implements CommitSnapshotResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ CommitImpl abO;

            C09641(CommitImpl commitImpl, Status status) {
                this.abO = commitImpl;
                this.DS = status;
            }

            public SnapshotMetadata getSnapshotMetadata() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult ao(Status status) {
            return new C09641(this, status);
        }

        public /* synthetic */ Result m3957c(Status status) {
            return ao(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.3 */
    class C09603 extends CommitImpl {
        final /* synthetic */ SnapshotsImpl abF;
        final /* synthetic */ Snapshot abI;
        final /* synthetic */ SnapshotMetadataChange abJ;

        C09603(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
            this.abF = snapshotsImpl;
            this.abI = snapshot;
            this.abJ = snapshotMetadataChange;
            super(null);
        }

        protected void m3959a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3135a((C0433b) this, this.abI, this.abJ);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1 */
        class C09651 implements DeleteSnapshotResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ DeleteImpl abP;

            C09651(DeleteImpl deleteImpl, Status status) {
                this.abP = deleteImpl;
                this.DS = status;
            }

            public String getSnapshotId() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult ap(Status status) {
            return new C09651(this, status);
        }

        public /* synthetic */ Result m3960c(Status status) {
            return ap(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.4 */
    class C09614 extends DeleteImpl {
        final /* synthetic */ SnapshotsImpl abF;
        final /* synthetic */ SnapshotMetadata abK;

        C09614(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
            this.abF = snapshotsImpl;
            this.abK = snapshotMetadata;
            super(null);
        }

        protected void m3962a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3223i(this, this.abK.getSnapshotId());
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.5 */
    class C09625 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl abF;
        final /* synthetic */ SnapshotMetadataChange abJ;
        final /* synthetic */ String abL;
        final /* synthetic */ String abM;
        final /* synthetic */ SnapshotContents abN;

        C09625(SnapshotsImpl snapshotsImpl, GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
            this.abF = snapshotsImpl;
            this.abL = str;
            this.abM = str2;
            this.abJ = snapshotMetadataChange;
            this.abN = snapshotContents;
            super(null);
        }

        protected void m3964a(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.m3148a((C0433b) this, this.abL, this.abM, this.abJ, this.abN);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.6 */
    class C09636 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ String ZZ;

        protected void m3966a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3191c((C0433b) this, this.ZY, this.ZZ, this.ZW);
        }
    }

    public final PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.m1806b(new C09603(this, googleApiClient, snapshot, snapshotMetadataChange));
    }

    public final PendingResult<DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return googleApiClient.m1806b(new C09614(this, googleApiClient, snapshotMetadata));
    }

    public final void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.m2826d(googleApiClient).m3165a(snapshot);
    }

    public final int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lC();
    }

    public final int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.m2826d(googleApiClient).lB();
    }

    public final Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.m2826d(googleApiClient).m3125a(str, z, z2, i);
    }

    public final SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        return (bundle == null || !bundle.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) bundle.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public final PendingResult<LoadSnapshotsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.m1804a(new C09581(this, googleApiClient, z));
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    public final PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.m1806b(new C09592(this, googleApiClient, str, z));
    }

    public final PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public final PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return googleApiClient.m1806b(new C09625(this, googleApiClient, str, str2, snapshotMetadataChange, snapshotContents));
    }
}
