package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@ey
public final class dt extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final gu mo;
    private final MediaController so;
    private final C1096a sp;
    private final VideoView sq;
    private long sr;
    private String ss;

    /* renamed from: com.google.android.gms.internal.dt.a */
    private static final class C1096a {
        private final Runnable mv;
        private volatile boolean st;

        /* renamed from: com.google.android.gms.internal.dt.a.1 */
        class C10951 implements Runnable {
            private final WeakReference<dt> su;
            final /* synthetic */ dt sv;
            final /* synthetic */ C1096a sw;

            C10951(C1096a c1096a, dt dtVar) {
                this.sw = c1096a;
                this.sv = dtVar;
                this.su = new WeakReference(this.sv);
            }

            public void run() {
                dt dtVar = (dt) this.su.get();
                if (!this.sw.st && dtVar != null) {
                    dtVar.cr();
                    this.sw.cs();
                }
            }
        }

        public C1096a(dt dtVar) {
            this.st = false;
            this.mv = new C10951(this, dtVar);
        }

        public final void cancel() {
            this.st = true;
            gq.wR.removeCallbacks(this.mv);
        }

        public final void cs() {
            gq.wR.postDelayed(this.mv, 250);
        }
    }

    public dt(Context context, gu guVar) {
        super(context);
        this.mo = guVar;
        this.sq = new VideoView(context);
        addView(this.sq, new LayoutParams(-1, -1, 17));
        this.so = new MediaController(context);
        this.sp = new C1096a(this);
        this.sp.cs();
        this.sq.setOnCompletionListener(this);
        this.sq.setOnPreparedListener(this);
        this.sq.setOnErrorListener(this);
    }

    private static void m4462a(gu guVar, String str) {
        m4465a(guVar, str, new HashMap(1));
    }

    public static void m4463a(gu guVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m4465a(guVar, "error", hashMap);
    }

    private static void m4464a(gu guVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m4465a(guVar, str, hashMap);
    }

    private static void m4465a(gu guVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        guVar.m4787a("onVideoEvent", (Map) map);
    }

    public final void m4466C(String str) {
        this.ss = str;
    }

    public final void m4467b(MotionEvent motionEvent) {
        this.sq.dispatchTouchEvent(motionEvent);
    }

    public final void cq() {
        if (TextUtils.isEmpty(this.ss)) {
            m4463a(this.mo, "no_src", null);
        } else {
            this.sq.setVideoPath(this.ss);
        }
    }

    public final void cr() {
        long currentPosition = (long) this.sq.getCurrentPosition();
        if (this.sr != currentPosition) {
            m4464a(this.mo, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.sr = currentPosition;
        }
    }

    public final void destroy() {
        this.sp.cancel();
        this.sq.stopPlayback();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        m4462a(this.mo, "ended");
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        m4463a(this.mo, String.valueOf(i), String.valueOf(i2));
        return true;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        m4464a(this.mo, "canplaythrough", "duration", String.valueOf(((float) this.sq.getDuration()) / 1000.0f));
    }

    public final void pause() {
        this.sq.pause();
    }

    public final void play() {
        this.sq.start();
    }

    public final void m4468s(boolean z) {
        if (z) {
            this.sq.setMediaController(this.so);
            return;
        }
        this.so.hide();
        this.sq.setMediaController(null);
    }

    public final void seekTo(int i) {
        this.sq.seekTo(i);
    }
}
