package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0430b;
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
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API;
    public static final CastApi CastApi;
    static final C0490c<im> DQ;
    private static final C0430b<im, CastOptions> DR;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C04531 implements C0430b<im, CastOptions> {
        C04531() {
        }

        public final im m1662a(Context context, Looper looper, jg jgVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m5219b((Object) castOptions, (Object) "Setting the API options is required.");
            return new im(context, looper, castOptions.Fz, (long) castOptions.FB, castOptions.FA, connectionCallbacks, onConnectionFailedListener);
        }

        public final int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    /* renamed from: com.google.android.gms.cast.Cast.a */
    protected static abstract class C0454a<R extends Result> extends C0435a<R, im> {
        public C0454a(GoogleApiClient googleApiClient) {
            super(Cast.DQ, googleApiClient);
        }

        public void m1663W(int i) {
            m1615b(m1617c(new Status(i)));
        }

        public void m1664e(int i, String str) {
            m1615b(m1617c(new Status(i, str, null)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.b */
    private static abstract class C0455b extends C0454a<Status> {
        C0455b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status m1665b(Status status) {
            return status;
        }

        public /* synthetic */ Result m1666c(Status status) {
            return m1665b(status);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.c */
    private static abstract class C0457c extends C0454a<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.c.1 */
        class C04671 implements ApplicationConnectionResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C0457c FF;

            C04671(C0457c c0457c, Status status) {
                this.FF = c0457c;
                this.DS = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        public C0457c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result m1669c(Status status) {
            return m1670i(status);
        }

        public ApplicationConnectionResult m1670i(Status status) {
            return new C04671(this, status);
        }
    }

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast.CastApi.a */
        public static final class C0466a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.1 */
            class C04561 extends C0455b {
                final /* synthetic */ String Ft;
                final /* synthetic */ String Fu;
                final /* synthetic */ C0466a Fv;

                C04561(C0466a c0466a, GoogleApiClient googleApiClient, String str, String str2) {
                    this.Fv = c0466a;
                    this.Ft = str;
                    this.Fu = str2;
                    super(googleApiClient);
                }

                protected void m1668a(im imVar) throws RemoteException {
                    try {
                        imVar.m5022a(this.Ft, this.Fu, (C0433b) this);
                    } catch (IllegalArgumentException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    } catch (IllegalStateException e2) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.2 */
            class C04582 extends C0457c {
                final /* synthetic */ C0466a Fv;
                final /* synthetic */ String Fw;

                C04582(C0466a c0466a, GoogleApiClient googleApiClient, String str) {
                    this.Fv = c0466a;
                    this.Fw = str;
                    super(googleApiClient);
                }

                protected void m1672a(im imVar) throws RemoteException {
                    try {
                        imVar.m5023a(this.Fw, false, (C0433b) this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.3 */
            class C04593 extends C0457c {
                final /* synthetic */ C0466a Fv;
                final /* synthetic */ String Fw;
                final /* synthetic */ LaunchOptions Fx;

                C04593(C0466a c0466a, GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                    this.Fv = c0466a;
                    this.Fw = str;
                    this.Fx = launchOptions;
                    super(googleApiClient);
                }

                protected void m1674a(im imVar) throws RemoteException {
                    try {
                        imVar.m5020a(this.Fw, this.Fx, (C0433b) this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.4 */
            class C04604 extends C0457c {
                final /* synthetic */ C0466a Fv;
                final /* synthetic */ String Fw;
                final /* synthetic */ String Fy;

                C04604(C0466a c0466a, GoogleApiClient googleApiClient, String str, String str2) {
                    this.Fv = c0466a;
                    this.Fw = str;
                    this.Fy = str2;
                    super(googleApiClient);
                }

                protected void m1676a(im imVar) throws RemoteException {
                    try {
                        imVar.m5024b(this.Fw, this.Fy, this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.5 */
            class C04615 extends C0457c {
                final /* synthetic */ C0466a Fv;
                final /* synthetic */ String Fw;

                C04615(C0466a c0466a, GoogleApiClient googleApiClient, String str) {
                    this.Fv = c0466a;
                    this.Fw = str;
                    super(googleApiClient);
                }

                protected void m1678a(im imVar) throws RemoteException {
                    try {
                        imVar.m5024b(this.Fw, null, this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.6 */
            class C04626 extends C0457c {
                final /* synthetic */ C0466a Fv;

                C04626(C0466a c0466a, GoogleApiClient googleApiClient) {
                    this.Fv = c0466a;
                    super(googleApiClient);
                }

                protected void m1680a(im imVar) throws RemoteException {
                    try {
                        imVar.m5024b(null, null, this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.7 */
            class C04637 extends C0455b {
                final /* synthetic */ C0466a Fv;

                C04637(C0466a c0466a, GoogleApiClient googleApiClient) {
                    this.Fv = c0466a;
                    super(googleApiClient);
                }

                protected void m1682a(im imVar) throws RemoteException {
                    try {
                        imVar.m5025d((C0433b) this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.8 */
            class C04648 extends C0455b {
                final /* synthetic */ C0466a Fv;

                C04648(C0466a c0466a, GoogleApiClient googleApiClient) {
                    this.Fv = c0466a;
                    super(googleApiClient);
                }

                protected void m1684a(im imVar) throws RemoteException {
                    try {
                        imVar.m5021a("", (C0433b) this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.9 */
            class C04659 extends C0455b {
                final /* synthetic */ C0466a Fv;
                final /* synthetic */ String Fy;

                C04659(C0466a c0466a, GoogleApiClient googleApiClient, String str) {
                    this.Fv = c0466a;
                    this.Fy = str;
                    super(googleApiClient);
                }

                protected void m1686a(im imVar) throws RemoteException {
                    if (TextUtils.isEmpty(this.Fy)) {
                        m1664e(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        imVar.m5021a(this.Fy, (C0433b) this);
                    } catch (IllegalStateException e) {
                        m1663W(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((im) googleApiClient.m1803a(Cast.DQ)).getApplicationMetadata();
            }

            public final String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((im) googleApiClient.m1803a(Cast.DQ)).getApplicationStatus();
            }

            public final double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((im) googleApiClient.m1803a(Cast.DQ)).fZ();
            }

            public final boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((im) googleApiClient.m1803a(Cast.DQ)).isMute();
            }

            public final PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.m1806b(new C04626(this, googleApiClient));
            }

            public final PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.m1806b(new C04615(this, googleApiClient, str));
            }

            public final PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
                return googleApiClient.m1806b(new C04604(this, googleApiClient, str, str2));
            }

            public final PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.m1806b(new C04582(this, googleApiClient, str));
            }

            public final PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
                return googleApiClient.m1806b(new C04593(this, googleApiClient, str, launchOptions));
            }

            @Deprecated
            public final PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new Builder().setRelaunchIfRunning(z).build());
            }

            public final PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.m1806b(new C04637(this, googleApiClient));
            }

            public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
                try {
                    ((im) googleApiClient.m1803a(Cast.DQ)).aE(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
                try {
                    ((im) googleApiClient.m1803a(Cast.DQ)).fY();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
                return googleApiClient.m1806b(new C04561(this, googleApiClient, str, str2));
            }

            public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
                try {
                    ((im) googleApiClient.m1803a(Cast.DQ)).m5019a(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException {
                try {
                    ((im) googleApiClient.m1803a(Cast.DQ)).m5014I(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((im) googleApiClient.m1803a(Cast.DQ)).m5016a(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.m1806b(new C04648(this, googleApiClient));
            }

            public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
                return googleApiClient.m1806b(new C04659(this, googleApiClient, str));
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final Listener FA;
        private final int FB;
        final CastDevice Fz;

        public static final class Builder {
            CastDevice FC;
            Listener FD;
            private int FE;

            private Builder(CastDevice castDevice, Listener listener) {
                jx.m5219b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                jx.m5219b((Object) listener, (Object) "CastListener parameter cannot be null");
                this.FC = castDevice;
                this.FD = listener;
                this.FE = 0;
            }

            public final CastOptions build() {
                return new CastOptions();
            }

            public final Builder setVerboseLoggingEnabled(boolean z) {
                if (z) {
                    this.FE |= 1;
                } else {
                    this.FE &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Fz = builder.FC;
            this.FA = builder.FD;
            this.FB = builder.FE;
        }

        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(listener, null);
        }
    }

    public static class Listener {
        public void m1689X(int i) {
        }

        public void m1690Y(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static {
        DQ = new C0490c();
        DR = new C04531();
        API = new Api(DR, DQ, new Scope[0]);
        CastApi = new C0466a();
    }

    private Cast() {
    }
}
