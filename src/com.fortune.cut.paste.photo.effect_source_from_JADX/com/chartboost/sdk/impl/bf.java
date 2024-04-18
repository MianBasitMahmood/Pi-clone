package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.bg.C0253a;
import java.util.Map;

public class bf extends TextureView implements SurfaceTextureListener, C0253a {
    OnVideoSizeChangedListener f694a;
    OnPreparedListener f695b;
    private String f696c;
    private Uri f697d;
    private Map<String, String> f698e;
    private int f699f;
    private int f700g;
    private int f701h;
    private Surface f702i;
    private MediaPlayer f703j;
    private int f704k;
    private int f705l;
    private OnCompletionListener f706m;
    private OnPreparedListener f707n;
    private int f708o;
    private OnErrorListener f709p;
    private int f710q;
    private OnCompletionListener f711r;
    private OnErrorListener f712s;
    private OnBufferingUpdateListener f713t;

    /* renamed from: com.chartboost.sdk.impl.bf.1 */
    class C02541 implements OnVideoSizeChangedListener {
        final /* synthetic */ bf f689a;

        C02541(bf bfVar) {
            this.f689a = bfVar;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            this.f689a.f704k = mediaPlayer.getVideoWidth();
            this.f689a.f705l = mediaPlayer.getVideoHeight();
            if (this.f689a.f704k != 0 && this.f689a.f705l != 0) {
                this.f689a.m1087a(this.f689a.getWidth(), this.f689a.getHeight());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.2 */
    class C02552 implements OnPreparedListener {
        final /* synthetic */ bf f690a;

        C02552(bf bfVar) {
            this.f690a = bfVar;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f690a.f700g = 2;
            this.f690a.f704k = mediaPlayer.getVideoWidth();
            this.f690a.f705l = mediaPlayer.getVideoHeight();
            if (this.f690a.f707n != null) {
                this.f690a.f707n.onPrepared(this.f690a.f703j);
            }
            int e = this.f690a.f710q;
            if (e != 0) {
                this.f690a.m1086a(e);
            }
            if (this.f690a.f701h == 3) {
                this.f690a.m1085a();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.3 */
    class C02563 implements OnCompletionListener {
        final /* synthetic */ bf f691a;

        C02563(bf bfVar) {
            this.f691a = bfVar;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f691a.f701h = 5;
            if (this.f691a.f700g != 5) {
                this.f691a.f700g = 5;
                if (this.f691a.f706m != null) {
                    this.f691a.f706m.onCompletion(this.f691a.f703j);
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.4 */
    class C02574 implements OnErrorListener {
        final /* synthetic */ bf f692a;

        C02574(bf bfVar) {
            this.f692a = bfVar;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            CBLogging.m97a(this.f692a.f696c, "Error: " + i + "," + i2);
            this.f692a.f700g = -1;
            this.f692a.f701h = -1;
            return (this.f692a.f709p == null || this.f692a.f709p.onError(this.f692a.f703j, i, i2)) ? true : true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.5 */
    class C02585 implements OnBufferingUpdateListener {
        final /* synthetic */ bf f693a;

        C02585(bf bfVar) {
            this.f693a = bfVar;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.f693a.f708o = i;
        }
    }

    public bf(Context context) {
        super(context);
        this.f696c = "VideoTextureView";
        this.f700g = 0;
        this.f701h = 0;
        this.f702i = null;
        this.f703j = null;
        this.f694a = new C02541(this);
        this.f695b = new C02552(this);
        this.f711r = new C02563(this);
        this.f712s = new C02574(this);
        this.f713t = new C02585(this);
        m1078f();
    }

    private void m1078f() {
        this.f704k = 0;
        this.f705l = 0;
        setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f700g = 0;
        this.f701h = 0;
    }

    public void m1091a(Uri uri) {
        m1092a(uri, null);
    }

    public void m1087a(int i, int i2) {
        if (this.f704k != 0 && this.f705l != 0 && i != 0 && i2 != 0) {
            float min = Math.min(((float) i) / ((float) this.f704k), ((float) i2) / ((float) this.f705l));
            float f = ((float) this.f704k) * min;
            min *= (float) this.f705l;
            Matrix matrix = new Matrix();
            matrix.setScale(f / ((float) i), min / ((float) i2), ((float) i) / 2.0f, ((float) i2) / 2.0f);
            setTransform(matrix);
        }
    }

    public void m1092a(Uri uri, Map<String, String> map) {
        this.f697d = uri;
        this.f698e = map;
        this.f710q = 0;
        m1080g();
        requestLayout();
        invalidate();
    }

    private void m1080g() {
        if (this.f697d != null && this.f702i != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m1068a(false);
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f697d.toString());
                String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                this.f705l = (int) Float.parseFloat(extractMetadata);
                this.f704k = (int) Float.parseFloat(extractMetadata2);
            } catch (Throwable e) {
                CBLogging.m106d("play video", "read size error", e);
            }
            try {
                this.f703j = new MediaPlayer();
                this.f703j.setOnPreparedListener(this.f695b);
                this.f703j.setOnVideoSizeChangedListener(this.f694a);
                this.f699f = -1;
                this.f703j.setOnCompletionListener(this.f711r);
                this.f703j.setOnErrorListener(this.f712s);
                this.f703j.setOnBufferingUpdateListener(this.f713t);
                this.f708o = 0;
                this.f703j.setDataSource(getContext(), this.f697d, this.f698e);
                this.f703j.setSurface(this.f702i);
                this.f703j.setAudioStreamType(3);
                this.f703j.setScreenOnWhilePlaying(true);
                this.f703j.prepareAsync();
                this.f700g = 1;
            } catch (Throwable e2) {
                CBLogging.m106d(this.f696c, "Unable to open content: " + this.f697d, e2);
                this.f700g = -1;
                this.f701h = -1;
                this.f712s.onError(this.f703j, 1, 0);
            } catch (Throwable e22) {
                CBLogging.m106d(this.f696c, "Unable to open content: " + this.f697d, e22);
                this.f700g = -1;
                this.f701h = -1;
                this.f712s.onError(this.f703j, 1, 0);
            }
        }
    }

    public void m1090a(OnPreparedListener onPreparedListener) {
        this.f707n = onPreparedListener;
    }

    public void m1088a(OnCompletionListener onCompletionListener) {
        this.f706m = onCompletionListener;
    }

    public void m1089a(OnErrorListener onErrorListener) {
        this.f709p = onErrorListener;
    }

    private void m1068a(boolean z) {
        if (this.f703j != null) {
            this.f703j.reset();
            this.f703j.release();
            this.f703j = null;
            this.f700g = 0;
            if (z) {
                this.f701h = 0;
            }
        }
    }

    public void m1085a() {
        if (m1082h()) {
            this.f703j.start();
            this.f700g = 3;
        }
        this.f701h = 3;
    }

    public void m1093b() {
        if (m1082h() && this.f703j.isPlaying()) {
            this.f703j.pause();
            this.f700g = 4;
        }
        this.f701h = 4;
    }

    public int m1094c() {
        if (!m1082h()) {
            this.f699f = -1;
            return this.f699f;
        } else if (this.f699f > 0) {
            return this.f699f;
        } else {
            this.f699f = this.f703j.getDuration();
            return this.f699f;
        }
    }

    public int m1095d() {
        if (m1082h()) {
            return this.f703j.getCurrentPosition();
        }
        return 0;
    }

    public void m1086a(int i) {
        if (m1082h()) {
            this.f703j.seekTo(i);
            this.f710q = 0;
            return;
        }
        this.f710q = i;
    }

    public boolean m1096e() {
        return m1082h() && this.f703j.isPlaying();
    }

    private boolean m1082h() {
        return (this.f703j == null || this.f700g == -1 || this.f700g == 0 || this.f700g == 1) ? false : true;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f702i = new Surface(surfaceTexture);
        m1080g();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f702i = null;
        m1068a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Object obj = this.f701h == 3 ? 1 : null;
        if (this.f703j != null && obj != null) {
            if (this.f710q != 0) {
                m1086a(this.f710q);
            }
            m1085a();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
