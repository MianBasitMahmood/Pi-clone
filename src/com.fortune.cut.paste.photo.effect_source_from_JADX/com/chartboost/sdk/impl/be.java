package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.bg.C0253a;
import java.util.Map;

public class be extends SurfaceView implements C0253a {
    OnVideoSizeChangedListener f666a;
    OnPreparedListener f667b;
    Callback f668c;
    private String f669d;
    private Uri f670e;
    private Map<String, String> f671f;
    private int f672g;
    private int f673h;
    private int f674i;
    private SurfaceHolder f675j;
    private MediaPlayer f676k;
    private int f677l;
    private int f678m;
    private int f679n;
    private int f680o;
    private OnCompletionListener f681p;
    private OnPreparedListener f682q;
    private int f683r;
    private OnErrorListener f684s;
    private int f685t;
    private OnCompletionListener f686u;
    private OnErrorListener f687v;
    private OnBufferingUpdateListener f688w;

    /* renamed from: com.chartboost.sdk.impl.be.1 */
    class C02471 implements OnVideoSizeChangedListener {
        final /* synthetic */ be f660a;

        C02471(be beVar) {
            this.f660a = beVar;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            this.f660a.f677l = mediaPlayer.getVideoWidth();
            this.f660a.f678m = mediaPlayer.getVideoHeight();
            if (this.f660a.f677l != 0 && this.f660a.f678m != 0) {
                this.f660a.getHolder().setFixedSize(this.f660a.f677l, this.f660a.f678m);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.2 */
    class C02482 implements OnPreparedListener {
        final /* synthetic */ be f661a;

        C02482(be beVar) {
            this.f661a = beVar;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f661a.f673h = 2;
            this.f661a.f677l = mediaPlayer.getVideoWidth();
            this.f661a.f678m = mediaPlayer.getVideoHeight();
            if (this.f661a.f682q != null) {
                this.f661a.f682q.onPrepared(this.f661a.f676k);
            }
            int e = this.f661a.f685t;
            if (e != 0) {
                this.f661a.m1055a(e);
            }
            if (this.f661a.f677l != 0 && this.f661a.f678m != 0) {
                this.f661a.getHolder().setFixedSize(this.f661a.f677l, this.f661a.f678m);
                if (this.f661a.f679n == this.f661a.f677l && this.f661a.f680o == this.f661a.f678m && this.f661a.f674i == 3) {
                    this.f661a.m1054a();
                }
            } else if (this.f661a.f674i == 3) {
                this.f661a.m1054a();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.3 */
    class C02493 implements OnCompletionListener {
        final /* synthetic */ be f662a;

        C02493(be beVar) {
            this.f662a = beVar;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f662a.f674i = 5;
            if (this.f662a.f673h != 5) {
                this.f662a.f673h = 5;
                if (this.f662a.f681p != null) {
                    this.f662a.f681p.onCompletion(this.f662a.f676k);
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.4 */
    class C02504 implements OnErrorListener {
        final /* synthetic */ be f663a;

        C02504(be beVar) {
            this.f663a = beVar;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            CBLogging.m97a(this.f663a.f669d, "Error: " + i + "," + i2);
            this.f663a.f673h = -1;
            this.f663a.f674i = -1;
            return (this.f663a.f684s == null || this.f663a.f684s.onError(this.f663a.f676k, i, i2)) ? true : true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.5 */
    class C02515 implements OnBufferingUpdateListener {
        final /* synthetic */ be f664a;

        C02515(be beVar) {
            this.f664a = beVar;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.f664a.f683r = i;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.6 */
    class C02526 implements Callback {
        final /* synthetic */ be f665a;

        C02526(be beVar) {
            this.f665a = beVar;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Object obj = 1;
            this.f665a.f679n = i2;
            this.f665a.f680o = i3;
            Object obj2 = this.f665a.f674i == 3 ? 1 : null;
            if (!(this.f665a.f677l == i2 && this.f665a.f678m == i3)) {
                obj = null;
            }
            if (this.f665a.f676k != null && obj2 != null && r1 != null) {
                if (this.f665a.f685t != 0) {
                    this.f665a.m1055a(this.f665a.f685t);
                }
                this.f665a.m1054a();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f665a.f675j = surfaceHolder;
            this.f665a.m1046g();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f665a.f675j = null;
            this.f665a.m1032a(true);
        }
    }

    public be(Context context) {
        super(context);
        this.f669d = "VideoSurfaceView";
        this.f673h = 0;
        this.f674i = 0;
        this.f675j = null;
        this.f676k = null;
        this.f666a = new C02471(this);
        this.f667b = new C02482(this);
        this.f686u = new C02493(this);
        this.f687v = new C02504(this);
        this.f688w = new C02515(this);
        this.f668c = new C02526(this);
        m1043f();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        if (this.f677l <= 0 || this.f678m <= 0) {
            i3 = defaultSize2;
            defaultSize2 = defaultSize;
        } else {
            i3 = Math.min(defaultSize2, Math.round((((float) this.f678m) / ((float) this.f677l)) * ((float) defaultSize)));
            defaultSize2 = Math.min(defaultSize, Math.round(((float) defaultSize2) * (((float) this.f677l) / ((float) this.f678m))));
        }
        setMeasuredDimension(defaultSize2, i3);
    }

    private void m1043f() {
        this.f677l = 0;
        this.f678m = 0;
        getHolder().addCallback(this.f668c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f673h = 0;
        this.f674i = 0;
    }

    public void m1060a(Uri uri) {
        m1061a(uri, null);
    }

    public void m1061a(Uri uri, Map<String, String> map) {
        this.f670e = uri;
        this.f671f = map;
        this.f685t = 0;
        m1046g();
        requestLayout();
        invalidate();
    }

    private void m1046g() {
        if (this.f670e != null && this.f675j != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m1032a(false);
            try {
                this.f676k = new MediaPlayer();
                this.f676k.setOnPreparedListener(this.f667b);
                this.f676k.setOnVideoSizeChangedListener(this.f666a);
                this.f672g = -1;
                this.f676k.setOnCompletionListener(this.f686u);
                this.f676k.setOnErrorListener(this.f687v);
                this.f676k.setOnBufferingUpdateListener(this.f688w);
                this.f683r = 0;
                this.f676k.setDataSource(getContext(), this.f670e, this.f671f);
                this.f676k.setDisplay(this.f675j);
                this.f676k.setAudioStreamType(3);
                this.f676k.setScreenOnWhilePlaying(true);
                this.f676k.prepareAsync();
                this.f673h = 1;
            } catch (Throwable e) {
                CBLogging.m106d(this.f669d, "Unable to open content: " + this.f670e, e);
                this.f673h = -1;
                this.f674i = -1;
                this.f687v.onError(this.f676k, 1, 0);
            } catch (Throwable e2) {
                CBLogging.m106d(this.f669d, "Unable to open content: " + this.f670e, e2);
                this.f673h = -1;
                this.f674i = -1;
                this.f687v.onError(this.f676k, 1, 0);
            }
        }
    }

    public void m1059a(OnPreparedListener onPreparedListener) {
        this.f682q = onPreparedListener;
    }

    public void m1057a(OnCompletionListener onCompletionListener) {
        this.f681p = onCompletionListener;
    }

    public void m1058a(OnErrorListener onErrorListener) {
        this.f684s = onErrorListener;
    }

    private void m1032a(boolean z) {
        if (this.f676k != null) {
            this.f676k.reset();
            this.f676k.release();
            this.f676k = null;
            this.f673h = 0;
            if (z) {
                this.f674i = 0;
            }
        }
    }

    public void m1054a() {
        if (m1048h()) {
            this.f676k.start();
            this.f673h = 3;
        }
        this.f674i = 3;
    }

    public void m1062b() {
        if (m1048h() && this.f676k.isPlaying()) {
            this.f676k.pause();
            this.f673h = 4;
        }
        this.f674i = 4;
    }

    public int m1063c() {
        if (!m1048h()) {
            this.f672g = -1;
            return this.f672g;
        } else if (this.f672g > 0) {
            return this.f672g;
        } else {
            this.f672g = this.f676k.getDuration();
            return this.f672g;
        }
    }

    public int m1064d() {
        if (m1048h()) {
            return this.f676k.getCurrentPosition();
        }
        return 0;
    }

    public void m1055a(int i) {
        if (m1048h()) {
            this.f676k.seekTo(i);
            this.f685t = 0;
            return;
        }
        this.f685t = i;
    }

    public boolean m1065e() {
        return m1048h() && this.f676k.isPlaying();
    }

    private boolean m1048h() {
        return (this.f676k == null || this.f673h == -1 || this.f673h == 0 || this.f673h == 1) ? false : true;
    }

    public void m1056a(int i, int i2) {
    }
}
