package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.gr;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private dx lf;

    private void m1435X() {
        if (this.lf != null) {
            try {
                this.lf.m4445X();
            } catch (Throwable e) {
                gr.m4777d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lf = dw.m4470b(this);
        if (this.lf == null) {
            gr.m4773W("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.lf.onCreate(bundle);
        } catch (Throwable e) {
            gr.m4777d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected final void onDestroy() {
        try {
            if (this.lf != null) {
                this.lf.onDestroy();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected final void onPause() {
        try {
            if (this.lf != null) {
                this.lf.onPause();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected final void onRestart() {
        super.onRestart();
        try {
            if (this.lf != null) {
                this.lf.onRestart();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected final void onResume() {
        super.onResume();
        try {
            if (this.lf != null) {
                this.lf.onResume();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.lf != null) {
                this.lf.onSaveInstanceState(bundle);
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected final void onStart() {
        super.onStart();
        try {
            if (this.lf != null) {
                this.lf.onStart();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected final void onStop() {
        try {
            if (this.lf != null) {
                this.lf.onStop();
            }
        } catch (Throwable e) {
            gr.m4777d("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        m1435X();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        m1435X();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m1435X();
    }
}
