package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.1 */
    static class C08721 implements LoadAclResult {
        final /* synthetic */ Status DS;

        C08721(Status status) {
            this.DS = status;
        }

        public final Status getStatus() {
            return this.DS;
        }

        public final void release() {
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public LoadAclResult m3723M(Status status) {
            return AclsImpl.m3731K(status);
        }

        public /* synthetic */ Result m3724c(Status status) {
            return m3723M(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.2 */
    class C08732 extends LoadNotifyAclImpl {
        protected void m3726a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3219h(this);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public Status m3727b(Status status) {
            return status;
        }

        public /* synthetic */ Result m3728c(Status status) {
            return m3727b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.3 */
    class C08743 extends UpdateNotifyAclImpl {
        final /* synthetic */ String aae;

        protected void m3730a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3232o((C0433b) this, this.aae);
        }
    }

    private static LoadAclResult m3731K(Status status) {
        return new C08721(status);
    }
}
