package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.C0489a;
import com.google.android.gms.common.api.Api.C0490c;
import com.google.android.gms.common.api.BaseImplementation.C0435a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {
        private String DZ;
        private Looper JF;
        private final Set<String> JH;
        private int JI;
        private View JJ;
        private String JK;
        private final Map<Api<?>, ApiOptions> JL;
        private FragmentActivity JM;
        private int JN;
        private OnConnectionFailedListener JO;
        private final Set<ConnectionCallbacks> JP;
        private final Set<OnConnectionFailedListener> JQ;
        private final Context mContext;

        public Builder(Context context) {
            this.JH = new HashSet();
            this.JL = new HashMap();
            this.JN = -1;
            this.JP = new HashSet();
            this.JQ = new HashSet();
            this.mContext = context;
            this.JF = context.getMainLooper();
            this.JK = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            jx.m5219b((Object) connectionCallbacks, (Object) "Must provide a connected listener");
            this.JP.add(connectionCallbacks);
            jx.m5219b((Object) onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.JQ.add(onConnectionFailedListener);
        }

        private GoogleApiClient gI() {
            C0516g a = C0516g.m1847a(this.JM);
            GoogleApiClient an = a.an(this.JN);
            if (an == null) {
                an = new C0507c(this.mContext.getApplicationContext(), this.JF, gH(), this.JL, this.JP, this.JQ, this.JN);
            }
            a.m1852a(this.JN, an, this.JO);
            return an;
        }

        public final Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.JL.put(api, null);
            List gy = api.gy();
            int size = gy.size();
            for (int i = 0; i < size; i++) {
                this.JH.add(((Scope) gy.get(i)).gO());
            }
            return this;
        }

        public final <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            jx.m5219b((Object) o, (Object) "Null options are not permitted for this Api");
            this.JL.put(api, o);
            List gy = api.gy();
            int size = gy.size();
            for (int i = 0; i < size; i++) {
                this.JH.add(((Scope) gy.get(i)).gO());
            }
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.JP.add(connectionCallbacks);
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            this.JQ.add(onConnectionFailedListener);
            return this;
        }

        public final Builder addScope(Scope scope) {
            this.JH.add(scope.gO());
            return this;
        }

        public final GoogleApiClient build() {
            jx.m5221b(!this.JL.isEmpty(), (Object) "must call addApi() to add at least one API");
            return this.JN >= 0 ? gI() : new C0507c(this.mContext, this.JF, gH(), this.JL, this.JP, this.JQ, -1);
        }

        public final Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m5221b(i >= 0, (Object) "clientId must be non-negative");
            this.JN = i;
            this.JM = (FragmentActivity) jx.m5219b((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.JO = onConnectionFailedListener;
            return this;
        }

        public final jg gH() {
            return new jg(this.DZ, this.JH, this.JI, this.JJ, this.JK);
        }

        public final Builder setAccountName(String str) {
            this.DZ = str;
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.JI = i;
            return this;
        }

        public final Builder setHandler(Handler handler) {
            jx.m5219b((Object) handler, (Object) "Handler must not be null");
            this.JF = handler.getLooper();
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.JJ = view;
            return this;
        }

        public final Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    <C extends C0489a> C m1803a(C0490c<C> c0490c);

    <A extends C0489a, R extends Result, T extends C0435a<R, A>> T m1804a(T t);

    boolean m1805a(Scope scope);

    <A extends C0489a, T extends C0435a<? extends Result, A>> T m1806b(T t);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    PendingResult<Status> clearDefaultAccountAndReconnect();

    void connect();

    <L> C0509d<L> m1807d(L l);

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
