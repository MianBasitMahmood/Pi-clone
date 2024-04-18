package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C0454a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.iv;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final it Gw;
    private final C0480a Gx;
    private OnMetadataUpdatedListener Gy;
    private OnStatusUpdatedListener Gz;
    private final Object mH;

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b */
    private static abstract class C0469b extends C0454a<MediaChannelResult> {
        iv GR;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.1 */
        class C04811 implements iv {
            final /* synthetic */ C0469b GS;

            C04811(C0469b c0469b) {
                this.GS = c0469b;
            }

            public void m1750a(long j, int i, JSONObject jSONObject) {
                this.GS.m1615b(new C0483c(new Status(i), jSONObject));
            }

            public void m1751n(long j) {
                this.GS.m1615b(this.GS.m1704k(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.2 */
        class C04822 implements MediaChannelResult {
            final /* synthetic */ Status DS;
            final /* synthetic */ C0469b GS;

            C04822(C0469b c0469b, Status status) {
                this.GS = c0469b;
                this.DS = status;
            }

            public JSONObject getCustomData() {
                return null;
            }

            public Status getStatus() {
                return this.DS;
            }
        }

        C0469b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.GR = new C04811(this);
        }

        public /* synthetic */ Result m1703c(Status status) {
            return m1704k(status);
        }

        public MediaChannelResult m1704k(Status status) {
            return new C04822(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.10 */
    class AnonymousClass10 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;
        final /* synthetic */ boolean GM;

        AnonymousClass10(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, boolean z, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GM = z;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1706a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1723a(this.GR, this.GM, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IllegalStateException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (IOException e2) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.11 */
    class AnonymousClass11 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;

        AnonymousClass11(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            super(googleApiClient);
        }

        protected void m1708a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1717a(this.GR);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C04701 extends it {
        final /* synthetic */ RemoteMediaPlayer GA;

        C04701(RemoteMediaPlayer remoteMediaPlayer) {
            this.GA = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.GA.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.GA.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C04712 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ long[] GC;

        C04712(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long[] jArr) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GC = jArr;
            super(googleApiClient);
        }

        protected void m1729a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1724a(this.GR, this.GC);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C04723 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ TextTrackStyle GD;

        C04723(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, TextTrackStyle textTrackStyle) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GD = textTrackStyle;
            super(googleApiClient);
        }

        protected void m1731a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1721a(this.GR, this.GD);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C04734 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ MediaInfo GE;
        final /* synthetic */ boolean GF;
        final /* synthetic */ long GG;
        final /* synthetic */ long[] GH;
        final /* synthetic */ JSONObject GI;

        C04734(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GE = mediaInfo;
            this.GF = z;
            this.GG = j;
            this.GH = jArr;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1733a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1720a(this.GR, this.GE, this.GF, this.GG, this.GH, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C04745 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;

        C04745(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1735a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1722a(this.GR, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C04756 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;

        C04756(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1737a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1725b(this.GR, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C04767 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;

        C04767(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1739a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1727c(this.GR, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C04778 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;
        final /* synthetic */ long GJ;
        final /* synthetic */ int GK;

        C04778(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long j, int i, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GJ = j;
            this.GK = i;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1741a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1719a(this.GR, this.GJ, this.GK, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IOException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C04789 extends C0469b {
        final /* synthetic */ RemoteMediaPlayer GA;
        final /* synthetic */ GoogleApiClient GB;
        final /* synthetic */ JSONObject GI;
        final /* synthetic */ double GL;

        C04789(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, double d, JSONObject jSONObject) {
            this.GA = remoteMediaPlayer;
            this.GB = googleApiClient2;
            this.GL = d;
            this.GI = jSONObject;
            super(googleApiClient);
        }

        protected void m1743a(im imVar) {
            synchronized (this.GA.mH) {
                this.GA.Gx.m1747b(this.GB);
                try {
                    this.GA.Gw.m1718a(this.GR, this.GL, this.GI);
                    this.GA.Gx.m1747b(null);
                } catch (IllegalStateException e) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (IllegalArgumentException e2) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (IOException e3) {
                    m1615b(m1704k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.GA.Gx.m1747b(null);
                } catch (Throwable th) {
                    this.GA.Gx.m1747b(null);
                }
            }
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a */
    private class C0480a implements iu {
        final /* synthetic */ RemoteMediaPlayer GA;
        private GoogleApiClient GN;
        private long GO;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a.a */
        private final class C0479a implements ResultCallback<Status> {
            private final long GP;
            final /* synthetic */ C0480a GQ;

            C0479a(C0480a c0480a, long j) {
                this.GQ = c0480a;
                this.GP = j;
            }

            public final void m1744j(Status status) {
                if (!status.isSuccess()) {
                    this.GQ.GA.Gw.m1726b(this.GP, status.getStatusCode());
                }
            }

            public final /* synthetic */ void onResult(Result result) {
                m1744j((Status) result);
            }
        }

        public C0480a(RemoteMediaPlayer remoteMediaPlayer) {
            this.GA = remoteMediaPlayer;
            this.GO = 0;
        }

        public void m1746a(String str, String str2, long j, String str3) throws IOException {
            if (this.GN == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.GN, str, str2).setResultCallback(new C0479a(this, j));
        }

        public void m1747b(GoogleApiClient googleApiClient) {
            this.GN = googleApiClient;
        }

        public long fS() {
            long j = this.GO + 1;
            this.GO = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.c */
    private static final class C0483c implements MediaChannelResult {
        private final Status Eb;
        private final JSONObject Ga;

        C0483c(Status status, JSONObject jSONObject) {
            this.Eb = status;
            this.Ga = jSONObject;
        }

        public final JSONObject getCustomData() {
            return this.Ga;
        }

        public final Status getStatus() {
            return this.Eb;
        }
    }

    public RemoteMediaPlayer() {
        this.mH = new Object();
        this.Gx = new C0480a(this);
        this.Gw = new C04701(this);
        this.Gw.m1709a(this.Gx);
    }

    private void onMetadataUpdated() {
        if (this.Gy != null) {
            this.Gy.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.Gz != null) {
            this.Gz.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mH) {
            approximateStreamPosition = this.Gw.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mH) {
            mediaInfo = this.Gw.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mH) {
            mediaStatus = this.Gw.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.Gw.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mH) {
            streamDuration = this.Gw.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        return googleApiClient.m1806b(new C04734(this, googleApiClient, googleApiClient, mediaInfo, z, j, jArr, jSONObject));
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.Gw.aD(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.m1806b(new C04745(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.m1806b(new C04767(this, googleApiClient, googleApiClient, jSONObject));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.m1806b(new AnonymousClass11(this, googleApiClient, googleApiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        return googleApiClient.m1806b(new C04778(this, googleApiClient, googleApiClient, j, i, jSONObject));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient googleApiClient, long[] jArr) {
        if (jArr != null && jArr.length != 0) {
            return googleApiClient.m1806b(new C04712(this, googleApiClient, googleApiClient, jArr));
        }
        throw new IllegalArgumentException("trackIds cannot be null or empty");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.Gy = onMetadataUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.Gz = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
        return googleApiClient.m1806b(new AnonymousClass10(this, googleApiClient, googleApiClient, z, jSONObject));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) throws IllegalArgumentException {
        return setStreamVolume(googleApiClient, d, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d, JSONObject jSONObject) throws IllegalArgumentException {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return googleApiClient.m1806b(new C04789(this, googleApiClient, googleApiClient, d, jSONObject));
        }
        throw new IllegalArgumentException("Volume cannot be " + d);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            return googleApiClient.m1806b(new C04723(this, googleApiClient, googleApiClient, textTrackStyle));
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.m1806b(new C04756(this, googleApiClient, googleApiClient, jSONObject));
    }
}
