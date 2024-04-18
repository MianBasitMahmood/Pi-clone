package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C1731e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1731e ant;

    /* renamed from: com.google.android.gms.plus.PlusClient.1 */
    class C17011 implements C0433b<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener anu;
        final /* synthetic */ PlusClient anv;

        C17011(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.anv = plusClient;
            this.anu = onMomentsLoadedListener;
        }

        public void m6256a(LoadMomentsResult loadMomentsResult) {
            this.anu.onMomentsLoaded(loadMomentsResult.getStatus().gQ(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m6257b(Object obj) {
            m6256a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.2 */
    class C17022 implements C0433b<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener anu;
        final /* synthetic */ PlusClient anv;

        C17022(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.anv = plusClient;
            this.anu = onMomentsLoadedListener;
        }

        public void m6258a(LoadMomentsResult loadMomentsResult) {
            this.anu.onMomentsLoaded(loadMomentsResult.getStatus().gQ(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m6259b(Object obj) {
            m6258a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.3 */
    class C17033 implements C0433b<LoadPeopleResult> {
        final /* synthetic */ PlusClient anv;
        final /* synthetic */ OnPeopleLoadedListener anw;

        C17033(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.anv = plusClient;
            this.anw = onPeopleLoadedListener;
        }

        public void m6260a(LoadPeopleResult loadPeopleResult) {
            this.anw.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m6261b(Object obj) {
            m6260a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.4 */
    class C17044 implements C0433b<LoadPeopleResult> {
        final /* synthetic */ PlusClient anv;
        final /* synthetic */ OnPeopleLoadedListener anw;

        C17044(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.anv = plusClient;
            this.anw = onPeopleLoadedListener;
        }

        public void m6262a(LoadPeopleResult loadPeopleResult) {
            this.anw.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m6263b(Object obj) {
            m6262a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.5 */
    class C17055 implements C0433b<LoadPeopleResult> {
        final /* synthetic */ PlusClient anv;
        final /* synthetic */ OnPeopleLoadedListener anw;

        C17055(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.anv = plusClient;
            this.anw = onPeopleLoadedListener;
        }

        public void m6264a(LoadPeopleResult loadPeopleResult) {
            this.anw.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m6265b(Object obj) {
            m6264a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.6 */
    class C17066 implements C0433b<LoadPeopleResult> {
        final /* synthetic */ PlusClient anv;
        final /* synthetic */ OnPeopleLoadedListener anw;

        C17066(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.anv = plusClient;
            this.anw = onPeopleLoadedListener;
        }

        public void m6266a(LoadPeopleResult loadPeopleResult) {
            this.anw.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m6267b(Object obj) {
            m6266a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.7 */
    class C17077 implements C0433b<Status> {
        final /* synthetic */ PlusClient anv;
        final /* synthetic */ OnAccessRevokedListener anx;

        C17077(PlusClient plusClient, OnAccessRevokedListener onAccessRevokedListener) {
            this.anv = plusClient;
            this.anx = onAccessRevokedListener;
        }

        public void az(Status status) {
            this.anx.onAccessRevoked(status.getStatus().gQ());
        }

        public /* synthetic */ void m6268b(Object obj) {
            az((Status) obj);
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.ant.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.ant.connect();
    }

    @Deprecated
    public void disconnect() {
        this.ant.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.ant.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.ant.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.ant.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.ant.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.ant.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.ant.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener onMomentsLoadedListener) {
        this.ant.m6347j(new C17011(this, onMomentsLoadedListener));
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener onMomentsLoadedListener, int i, String str, Uri uri, String str2, String str3) {
        this.ant.m6342a(new C17022(this, onMomentsLoadedListener), i, str, uri, str2, str3);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        this.ant.m6344a(new C17055(this, onPeopleLoadedListener), (Collection) collection);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener onPeopleLoadedListener, String... strArr) {
        this.ant.m6346d(new C17066(this, onPeopleLoadedListener), strArr);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener onPeopleLoadedListener, int i, String str) {
        this.ant.m6340a(new C17033(this, onPeopleLoadedListener), i, str);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener onPeopleLoadedListener, String str) {
        this.ant.m6351q(new C17044(this, onPeopleLoadedListener), str);
    }

    C1731e os() {
        return this.ant;
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.ant.registerConnectionCallbacks(connectionCallbacks);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.ant.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Deprecated
    public void removeMoment(String str) {
        this.ant.removeMoment(str);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(OnAccessRevokedListener onAccessRevokedListener) {
        this.ant.m6350l(new C17077(this, onAccessRevokedListener));
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.ant.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.ant.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.ant.m6343a(null, moment);
    }
}
