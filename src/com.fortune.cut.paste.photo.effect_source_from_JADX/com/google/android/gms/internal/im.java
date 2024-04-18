package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.iq.C1226a;
import com.google.android.gms.internal.ir.C1223a;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class im extends jl<iq> {
    private static final Object HB;
    private static final Object HC;
    private static final is Hh;
    private final Listener FD;
    private double Gp;
    private boolean Gq;
    private C0433b<Status> HA;
    private ApplicationMetadata Hi;
    private final CastDevice Hj;
    private final Map<String, MessageReceivedCallback> Hk;
    private final long Hl;
    private C1224c Hm;
    private String Hn;
    private boolean Ho;
    private boolean Hp;
    private boolean Hq;
    private int Hr;
    private int Hs;
    private final AtomicLong Ht;
    private String Hu;
    private String Hv;
    private Bundle Hw;
    private final Map<Long, C0433b<Status>> Hx;
    private final C1218b Hy;
    private C0433b<ApplicationConnectionResult> Hz;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.im.a */
    private static final class C1217a implements ApplicationConnectionResult {
        private final Status Eb;
        private final ApplicationMetadata HD;
        private final String HE;
        private final boolean HF;
        private final String vZ;

        public C1217a(Status status) {
            this(status, null, null, null, false);
        }

        public C1217a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.Eb = status;
            this.HD = applicationMetadata;
            this.HE = str;
            this.vZ = str2;
            this.HF = z;
        }

        public final ApplicationMetadata getApplicationMetadata() {
            return this.HD;
        }

        public final String getApplicationStatus() {
            return this.HE;
        }

        public final String getSessionId() {
            return this.vZ;
        }

        public final Status getStatus() {
            return this.Eb;
        }

        public final boolean getWasLaunched() {
            return this.HF;
        }
    }

    /* renamed from: com.google.android.gms.internal.im.b */
    private class C1218b implements OnConnectionFailedListener {
        final /* synthetic */ im HG;

        private C1218b(im imVar) {
            this.HG = imVar;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.HG.ga();
        }
    }

    /* renamed from: com.google.android.gms.internal.im.c */
    private class C1224c extends C1223a {
        final /* synthetic */ im HG;
        private final AtomicBoolean HH;

        /* renamed from: com.google.android.gms.internal.im.c.1 */
        class C12191 implements Runnable {
            final /* synthetic */ int HI;
            final /* synthetic */ C1224c HJ;

            C12191(C1224c c1224c, int i) {
                this.HJ = c1224c;
                this.HI = i;
            }

            public void run() {
                if (this.HJ.HG.FD != null) {
                    this.HJ.HG.FD.onApplicationDisconnected(this.HI);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.im.c.2 */
        class C12202 implements Runnable {
            final /* synthetic */ C1224c HJ;
            final /* synthetic */ io HK;

            C12202(C1224c c1224c, io ioVar) {
                this.HJ = c1224c;
                this.HK = ioVar;
            }

            public void run() {
                this.HJ.HG.m5000a(this.HK);
            }
        }

        /* renamed from: com.google.android.gms.internal.im.c.3 */
        class C12213 implements Runnable {
            final /* synthetic */ C1224c HJ;
            final /* synthetic */ ij HL;

            C12213(C1224c c1224c, ij ijVar) {
                this.HJ = c1224c;
                this.HL = ijVar;
            }

            public void run() {
                this.HJ.HG.m4997a(this.HL);
            }
        }

        /* renamed from: com.google.android.gms.internal.im.c.4 */
        class C12224 implements Runnable {
            final /* synthetic */ String Ft;
            final /* synthetic */ C1224c HJ;
            final /* synthetic */ String HM;

            C12224(C1224c c1224c, String str, String str2) {
                this.HJ = c1224c;
                this.Ft = str;
                this.HM = str2;
            }

            public void run() {
                synchronized (this.HJ.HG.Hk) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.HJ.HG.Hk.get(this.Ft);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.HJ.HG.Hj, this.Ft, this.HM);
                    return;
                }
                im.Hh.m5050b("Discarded message for unknown namespace '%s'", this.Ft);
            }
        }

        private C1224c(im imVar) {
            this.HG = imVar;
            this.HH = new AtomicBoolean(false);
        }

        private boolean ah(int i) {
            synchronized (im.HC) {
                if (this.HG.HA != null) {
                    this.HG.HA.m1609b(new Status(i));
                    this.HG.HA = null;
                    return true;
                }
                return false;
            }
        }

        private void m4985c(long j, int i) {
            synchronized (this.HG.Hx) {
                C0433b c0433b = (C0433b) this.HG.Hx.remove(Long.valueOf(j));
            }
            if (c0433b != null) {
                c0433b.m1609b(new Status(i));
            }
        }

        public void m4986a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            if (!this.HH.get()) {
                this.HG.Hi = applicationMetadata;
                this.HG.Hu = applicationMetadata.getApplicationId();
                this.HG.Hv = str2;
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.m1609b(new C1217a(new Status(0), applicationMetadata, str, str2, z));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        public void m4987a(String str, double d, boolean z) {
            im.Hh.m5050b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void m4988a(String str, long j) {
            if (!this.HH.get()) {
                m4985c(j, 0);
            }
        }

        public void m4989a(String str, long j, int i) {
            if (!this.HH.get()) {
                m4985c(j, i);
            }
        }

        public void ad(int i) {
            if (gg()) {
                im.Hh.m5050b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    this.HG.aD(2);
                }
            }
        }

        public void ae(int i) {
            if (!this.HH.get()) {
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.m1609b(new C1217a(new Status(i)));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        public void af(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        public void ag(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        public void m4990b(ij ijVar) {
            if (!this.HH.get()) {
                im.Hh.m5050b("onApplicationStatusChanged", new Object[0]);
                this.HG.mHandler.post(new C12213(this, ijVar));
            }
        }

        public void m4991b(io ioVar) {
            if (!this.HH.get()) {
                im.Hh.m5050b("onDeviceStatusChanged", new Object[0]);
                this.HG.mHandler.post(new C12202(this, ioVar));
            }
        }

        public void m4992b(String str, byte[] bArr) {
            if (!this.HH.get()) {
                im.Hh.m5050b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public boolean gg() {
            if (this.HH.getAndSet(true)) {
                return false;
            }
            this.HG.fW();
            return true;
        }

        public boolean gh() {
            return this.HH.get();
        }

        public void m4993j(String str, String str2) {
            if (!this.HH.get()) {
                im.Hh.m5050b("Receive (type=text, ns=%s) %s", str, str2);
                this.HG.mHandler.post(new C12224(this, str, str2));
            }
        }

        public void onApplicationDisconnected(int i) {
            if (!this.HH.get()) {
                this.HG.Hu = null;
                this.HG.Hv = null;
                ah(i);
                if (this.HG.FD != null) {
                    this.HG.mHandler.post(new C12191(this, i));
                }
            }
        }
    }

    static {
        Hh = new is("CastClientImpl");
        HB = new Object();
        HC = new Object();
    }

    public im(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, null);
        this.Hj = castDevice;
        this.FD = listener;
        this.Hl = j;
        this.mHandler = new Handler(looper);
        this.Hk = new HashMap();
        this.Ht = new AtomicLong(0);
        this.Hx = new HashMap();
        fW();
        this.Hy = new C1218b();
        registerConnectionFailedListener(this.Hy);
    }

    private void m4997a(ij ijVar) {
        boolean z;
        String fT = ijVar.fT();
        if (in.m5027a(fT, this.Hn)) {
            z = false;
        } else {
            this.Hn = fT;
            z = true;
        }
        Hh.m5050b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Ho));
        if (this.FD != null && (z || this.Ho)) {
            this.FD.onApplicationStatusChanged();
        }
        this.Ho = false;
    }

    private void m5000a(io ioVar) {
        boolean z;
        ApplicationMetadata applicationMetadata = ioVar.getApplicationMetadata();
        if (!in.m5027a(applicationMetadata, this.Hi)) {
            this.Hi = applicationMetadata;
            this.FD.onApplicationMetadataChanged(this.Hi);
        }
        double fZ = ioVar.fZ();
        if (fZ == Double.NaN || fZ == this.Gp) {
            z = false;
        } else {
            this.Gp = fZ;
            z = true;
        }
        boolean gi = ioVar.gi();
        if (gi != this.Gq) {
            this.Gq = gi;
            z = true;
        }
        Hh.m5050b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.onVolumeChanged();
        }
        int gj = ioVar.gj();
        if (gj != this.Hr) {
            this.Hr = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.m5050b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.m1689X(this.Hr);
        }
        gj = ioVar.gk();
        if (gj != this.Hs) {
            this.Hs = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.m5050b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.m1690Y(this.Hs);
        }
        this.Hp = false;
    }

    private void m5004c(C0433b<ApplicationConnectionResult> c0433b) {
        synchronized (HB) {
            if (this.Hz != null) {
                this.Hz.m1609b(new C1217a(new Status(CastStatusCodes.CANCELED)));
            }
            this.Hz = c0433b;
        }
    }

    private void m5008e(C0433b<Status> c0433b) {
        synchronized (HC) {
            if (this.HA != null) {
                c0433b.m1609b(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.HA = c0433b;
        }
    }

    private void fW() {
        this.Hq = false;
        this.Hr = -1;
        this.Hs = -1;
        this.Hi = null;
        this.Hn = null;
        this.Gp = 0.0d;
        this.Gq = false;
    }

    private void ga() {
        Hh.m5050b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.Hk) {
            this.Hk.clear();
        }
    }

    private void gb() throws IllegalStateException {
        if (!this.Hq || this.Hm == null || this.Hm.gh()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    public final void m5014I(boolean z) throws IllegalStateException, RemoteException {
        ((iq) hw()).m5037a(z, this.Gp, this.Gq);
    }

    protected final iq m5015L(IBinder iBinder) {
        return C1226a.m5047M(iBinder);
    }

    public final void m5016a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((iq) hw()).m5033a(d, this.Gp, this.Gq);
    }

    protected final void m5017a(int i, IBinder iBinder, Bundle bundle) {
        Hh.m5050b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.Hq = true;
            this.Ho = true;
            this.Hp = true;
        } else {
            this.Hq = false;
        }
        if (i == LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.Hw = new Bundle();
            this.Hw.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.m2258a(i, iBinder, bundle);
    }

    protected final void m5018a(jt jtVar, C1250e c1250e) throws RemoteException {
        Bundle bundle = new Bundle();
        Hh.m5050b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.Hu, this.Hv);
        this.Hj.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.Hl);
        if (this.Hu != null) {
            bundle.putString("last_application_id", this.Hu);
            if (this.Hv != null) {
                bundle.putString("last_session_id", this.Hv);
            }
        }
        this.Hm = new C1224c();
        jtVar.m5124a((js) c1250e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.Hm.asBinder(), bundle);
    }

    public final void m5019a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        in.aF(str);
        aE(str);
        if (messageReceivedCallback != null) {
            synchronized (this.Hk) {
                this.Hk.put(str, messageReceivedCallback);
            }
            ((iq) hw()).aI(str);
        }
    }

    public final void m5020a(String str, LaunchOptions launchOptions, C0433b<ApplicationConnectionResult> c0433b) throws IllegalStateException, RemoteException {
        m5004c((C0433b) c0433b);
        ((iq) hw()).m5034a(str, launchOptions);
    }

    public final void m5021a(String str, C0433b<Status> c0433b) throws IllegalStateException, RemoteException {
        m5008e((C0433b) c0433b);
        ((iq) hw()).aH(str);
    }

    public final void m5022a(String str, String str2, C0433b<Status> c0433b) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            in.aF(str);
            gb();
            long incrementAndGet = this.Ht.incrementAndGet();
            try {
                this.Hx.put(Long.valueOf(incrementAndGet), c0433b);
                ((iq) hw()).m5035a(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.Hx.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public final void m5023a(String str, boolean z, C0433b<ApplicationConnectionResult> c0433b) throws IllegalStateException, RemoteException {
        m5004c((C0433b) c0433b);
        ((iq) hw()).m5038g(str, z);
    }

    public final void aE(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.Hk) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.Hk.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((iq) hw()).aJ(str);
            } catch (Throwable e) {
                Hh.m5049a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public final void m5024b(String str, String str2, C0433b<ApplicationConnectionResult> c0433b) throws IllegalStateException, RemoteException {
        m5004c((C0433b) c0433b);
        ((iq) hw()).m5039k(str, str2);
    }

    protected final String bK() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected final String bL() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public final void m5025d(C0433b<Status> c0433b) throws IllegalStateException, RemoteException {
        m5008e((C0433b) c0433b);
        ((iq) hw()).gl();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = Hh;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.Hm;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.m5050b(r1, r2);
        r0 = r6.Hm;
        r1 = 0;
        r6.Hm = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.gg();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = Hh;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.m5050b(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.ga();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.hw();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.internal.iq) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = Hh;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.m5049a(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.im.disconnect():void");
    }

    public final Bundle fX() {
        if (this.Hw == null) {
            return super.fX();
        }
        Bundle bundle = this.Hw;
        this.Hw = null;
        return bundle;
    }

    public final void fY() throws IllegalStateException, RemoteException {
        ((iq) hw()).fY();
    }

    public final double fZ() throws IllegalStateException {
        gb();
        return this.Gp;
    }

    public final ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        gb();
        return this.Hi;
    }

    public final String getApplicationStatus() throws IllegalStateException {
        gb();
        return this.Hn;
    }

    public final boolean isMute() throws IllegalStateException {
        gb();
        return this.Gq;
    }

    protected final /* synthetic */ IInterface m5026l(IBinder iBinder) {
        return m5015L(iBinder);
    }
}
