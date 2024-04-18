package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;

public class bg extends FrameLayout {
    private View f714a;
    private boolean f715b;

    /* renamed from: com.chartboost.sdk.impl.bg.a */
    public interface C0253a {
        void m1017a();

        void m1018a(int i);

        void m1019a(int i, int i2);

        void m1020a(OnCompletionListener onCompletionListener);

        void m1021a(OnErrorListener onErrorListener);

        void m1022a(OnPreparedListener onPreparedListener);

        void m1023a(Uri uri);

        void m1024b();

        int m1025c();

        int m1026d();

        boolean m1027e();
    }

    public bg(Context context) {
        super(context);
        m1099d();
    }

    private void m1099d() {
        this.f715b = m1098c();
        if (!Chartboost.getImpressionsUseActivities() && (getContext() instanceof Activity)) {
            this.f715b = m1097a((Activity) getContext());
        }
        CBLogging.m107e("VideoInit", "Choosing " + (this.f715b ? "texture" : "surface") + " solution for video playback");
        if (this.f715b) {
            this.f714a = new bf(getContext());
        } else {
            this.f714a = new be(getContext());
        }
        addView(this.f714a, new LayoutParams(-1, -1));
        if (!this.f715b) {
            ((SurfaceView) this.f714a).setZOrderMediaOverlay(true);
        }
    }

    public boolean m1100a() {
        return this.f715b;
    }

    public C0253a m1101b() {
        return (C0253a) this.f714a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m1101b().m1019a(i, i2);
    }

    public static boolean m1097a(Activity activity) {
        if (m1098c()) {
            if (Chartboost.getImpressionsUseActivities()) {
                return true;
            }
            try {
                return activity.getWindow().getDecorView().isHardwareAccelerated();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean m1098c() {
        return VERSION.SDK_INT >= 14;
    }
}
