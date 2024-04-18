package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;

public class as extends ar {
    private aw f502a;
    private Button f503b;
    private bg f504c;
    private C0111a f505d;

    /* renamed from: com.chartboost.sdk.impl.as.1 */
    class C02131 implements OnClickListener {
        final /* synthetic */ as f500a;

        C02131(as asVar) {
            this.f500a = asVar;
        }

        public void onClick(View view) {
            this.f500a.m808c();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.as.2 */
    class C02142 implements OnCompletionListener {
        final /* synthetic */ as f501a;

        C02142(as asVar) {
            this.f501a = asVar;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            bh.m1105a(false, this.f501a.f504c);
        }
    }

    public as(aw awVar, Context context) {
        super(awVar, context);
        this.f502a = awVar;
        this.f503b = new Button(context);
        this.f503b.setTextColor(-14571545);
        this.f503b.setText("Preview");
        this.f503b.setOnClickListener(new C02131(this));
        addView(this.f503b, 2);
    }

    public void m809a(C0111a c0111a, int i) {
        super.m804a(c0111a, i);
        this.f505d = c0111a;
    }

    private void m808c() {
        CBLogging.m103c(this, "play the video");
        if (this.f504c == null) {
            this.f504c = new bg(getContext());
            this.f502a.m517e().addView(this.f504c, new LayoutParams(-1, -1));
            this.f504c.setVisibility(8);
        }
        this.f504c.m1101b().m1020a(new C02142(this));
        bh.m1105a(true, this.f504c);
        this.f504c.m1101b().m1017a();
    }
}
