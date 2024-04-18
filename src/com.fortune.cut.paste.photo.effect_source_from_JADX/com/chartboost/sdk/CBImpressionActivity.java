package com.chartboost.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C0140k;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bg;

public final class CBImpressionActivity extends Activity {
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bg.m1098c()) {
            getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra("paramFullscreen", false)) {
            getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        }
        getWindow().setWindowAnimations(0);
        setContentView(new RelativeLayout(this));
        Chartboost.m32a(this);
        Chartboost.createSurfaceView(this);
        ba.m945d();
    }

    protected final void onStart() {
        super.onStart();
        Chartboost.m28a();
        Chartboost.m30a((Activity) this);
    }

    protected final void onResume() {
        super.onResume();
        Chartboost.m33a(C0140k.m275a((Activity) this));
    }

    protected final void onPause() {
        super.onPause();
        Chartboost.m43b(C0140k.m275a((Activity) this));
    }

    protected final void onStop() {
        super.onStop();
        Chartboost.m40b();
        Chartboost.m47c(C0140k.m275a((Activity) this));
    }

    protected final void onDestroy() {
        super.onDestroy();
        Chartboost.m41b((Activity) this);
    }

    public final void onBackPressed() {
        if (!Chartboost.m50d()) {
            super.onBackPressed();
        }
    }
}
