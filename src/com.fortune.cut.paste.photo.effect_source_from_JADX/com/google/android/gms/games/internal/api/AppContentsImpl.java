package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.1 */
        class C08761 implements LoadAppContentResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ LoadsImpl aai;

            C08761(LoadsImpl loadsImpl, Status status) {
                this.aai = loadsImpl;
                this.DS = status;
            }

            public Status getStatus() {
                return this.DS;
            }

            public void release() {
            }
        }

        public LoadAppContentResult m3733N(Status status) {
            return new C08761(this, status);
        }

        public /* synthetic */ Result m3734c(Status status) {
            return m3733N(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.1 */
    class C08751 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aaf;
        final /* synthetic */ String aag;
        final /* synthetic */ String[] aah;

        protected void m3736a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3130a((C0433b) this, this.aaf, this.aag, this.aah, this.ZW);
        }
    }
}
