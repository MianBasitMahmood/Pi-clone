package com.fortune.cut.paste.photo.effect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.google.android.gms.wearable.WearableStatusCodes;

public class LoadingActivity extends Activity {
    private static int f1037b;
    GoogleAd f1038a;

    /* renamed from: com.fortune.cut.paste.photo.effect.LoadingActivity.1 */
    class C03601 implements Runnable {
        final /* synthetic */ LoadingActivity f1036a;

        C03601(LoadingActivity loadingActivity) {
            this.f1036a = loadingActivity;
        }

        public final void run() {
            this.f1036a.startActivity(new Intent(this.f1036a, WelcomeActivity.class));
            this.f1036a.f1038a.m1429a();
            this.f1036a.finish();
        }
    }

    static {
        f1037b = WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.loading_activity);
        this.f1038a = new GoogleAd(this);
        ImageView imageView = (ImageView) findViewById(R.id.loadingImage);
        imageView.setBackgroundResource(R.drawable.load);
        ((AnimationDrawable) imageView.getBackground()).start();
        new Handler().postDelayed(new C03601(this), (long) f1037b);
    }
}
