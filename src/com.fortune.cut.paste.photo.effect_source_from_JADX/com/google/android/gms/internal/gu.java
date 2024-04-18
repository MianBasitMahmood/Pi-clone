package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class gu extends WebView implements DownloadListener {
    private final Object mH;
    private final WindowManager mR;
    private ay qI;
    private final gs qJ;
    private final C1266k tl;
    private final gv wW;
    private final C1173a wX;
    private dp wY;
    private boolean wZ;
    private boolean xa;
    private boolean xb;
    private boolean xc;

    @ey
    /* renamed from: com.google.android.gms.internal.gu.a */
    protected static class C1173a extends MutableContextWrapper {
        private Context mO;
        private Activity xd;

        public C1173a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context dI() {
            return this.xd;
        }

        public void setBaseContext(Context context) {
            this.mO = context.getApplicationContext();
            this.xd = context instanceof Activity ? (Activity) context : null;
            super.setBaseContext(this.mO);
        }

        public void startActivity(Intent intent) {
            if (this.xd != null) {
                this.xd.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.mO.startActivity(intent);
        }
    }

    protected gu(C1173a c1173a, ay ayVar, boolean z, boolean z2, C1266k c1266k, gs gsVar) {
        super(c1173a);
        this.mH = new Object();
        this.wX = c1173a;
        this.qI = ayVar;
        this.wZ = z;
        this.tl = c1266k;
        this.qJ = gsVar;
        this.mR = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        gi.m4723a((Context) c1173a, gsVar.wS, settings);
        if (VERSION.SDK_INT >= 17) {
            go.m4761a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            gm.m4752a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.wW = new gx(this, z2);
        } else {
            this.wW = new gv(this, z2);
        }
        setWebViewClient(this.wW);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new gy(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new gw(this));
        }
        dJ();
    }

    public static gu m4782a(Context context, ay ayVar, boolean z, boolean z2, C1266k c1266k, gs gsVar) {
        return new gu(new C1173a(context), ayVar, z, z2, c1266k, gsVar);
    }

    private void dJ() {
        synchronized (this.mH) {
            if (this.wZ || this.qI.oq) {
                if (VERSION.SDK_INT < 14) {
                    gr.m4769S("Disabling hardware acceleration on an overlay.");
                    dK();
                } else {
                    gr.m4769S("Enabling hardware acceleration on an overlay.");
                    dL();
                }
            } else if (VERSION.SDK_INT < 18) {
                gr.m4769S("Disabling hardware acceleration on an AdView.");
                dK();
            } else {
                gr.m4769S("Enabling hardware acceleration on an AdView.");
                dL();
            }
        }
    }

    private void dK() {
        synchronized (this.mH) {
            if (!this.xa && VERSION.SDK_INT >= 11) {
                gm.m4756i(this);
            }
            this.xa = true;
        }
    }

    private void dL() {
        synchronized (this.mH) {
            if (this.xa && VERSION.SDK_INT >= 11) {
                gm.m4757j(this);
            }
            this.xa = false;
        }
    }

    protected void m4783X(String str) {
        synchronized (this.mH) {
            if (isDestroyed()) {
                gr.m4773W("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void m4784a(Context context, ay ayVar) {
        synchronized (this.mH) {
            this.wX.setBaseContext(context);
            this.wY = null;
            this.qI = ayVar;
            this.wZ = false;
            this.xc = false;
            gi.m4734b(this);
            loadUrl("about:blank");
            this.wW.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
        }
    }

    public void m4785a(ay ayVar) {
        synchronized (this.mH) {
            this.qI = ayVar;
            requestLayout();
        }
    }

    public void m4786a(dp dpVar) {
        synchronized (this.mH) {
            this.wY = dpVar;
        }
    }

    public void m4787a(String str, Map<String, ?> map) {
        try {
            m4789b(str, gi.m4743t((Map) map));
        } catch (JSONException e) {
            gr.m4773W("Could not convert parameters to JSON.");
        }
    }

    public void m4788a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        m4783X(stringBuilder.toString());
    }

    public ay ac() {
        ay ayVar;
        synchronized (this.mH) {
            ayVar = this.qI;
        }
        return ayVar;
    }

    public void m4789b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        gr.m4772V("Dispatching AFMA event: " + stringBuilder);
        m4783X(stringBuilder.toString());
    }

    public void cb() {
        if (dD().dN()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.mR.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            int s = gi.m4742s(getContext());
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            int round = Math.round(((float) displayMetrics.widthPixels) * f);
            try {
                m4789b("onScreenInfoChanged", new JSONObject().put("width", round).put("height", Math.round(((float) (displayMetrics.heightPixels - s)) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                gr.m4775b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void ci() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.qJ.wS);
        m4787a("onshow", hashMap);
    }

    public void cj() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.qJ.wS);
        m4787a("onhide", hashMap);
    }

    public dp dC() {
        dp dpVar;
        synchronized (this.mH) {
            dpVar = this.wY;
        }
        return dpVar;
    }

    public gv dD() {
        return this.wW;
    }

    public boolean dE() {
        return this.xc;
    }

    public C1266k dF() {
        return this.tl;
    }

    public gs dG() {
        return this.qJ;
    }

    public boolean dH() {
        boolean z;
        synchronized (this.mH) {
            z = this.wZ;
        }
        return z;
    }

    public Context dI() {
        return this.wX.dI();
    }

    public void destroy() {
        synchronized (this.mH) {
            if (this.wY != null) {
                this.wY.close();
            }
            this.xb = true;
            super.destroy();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.mH) {
            if (isDestroyed()) {
                gr.m4773W("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mH) {
            z = this.xb;
        }
        return z;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            gr.m4769S("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this.mH) {
            if (isInEditMode() || this.wZ) {
                super.onMeasure(i, i2);
                return;
            }
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size2 = MeasureSpec.getSize(i2);
            mode = (mode == ExploreByTouchHelper.INVALID_ID || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == ExploreByTouchHelper.INVALID_ID || mode2 == 1073741824) {
                i3 = size2;
            }
            if (this.qI.widthPixels > mode || this.qI.heightPixels > r0) {
                float f = this.wX.getResources().getDisplayMetrics().density;
                gr.m4773W("Not enough space to show ad. Needs " + ((int) (((float) this.qI.widthPixels) / f)) + "x" + ((int) (((float) this.qI.heightPixels) / f)) + " dp, but only has " + ((int) (((float) size) / f)) + "x" + ((int) (((float) size2) / f)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.qI.widthPixels, this.qI.heightPixels);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tl != null) {
            this.tl.m5238a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void m4790q(boolean z) {
        synchronized (this.mH) {
            if (this.wY != null) {
                this.wY.m4454q(z);
            } else {
                this.xc = z;
            }
        }
    }

    public void setContext(Context context) {
        this.wX.setBaseContext(context);
    }

    public void m4791z(boolean z) {
        synchronized (this.mH) {
            this.wZ = z;
            dJ();
        }
    }
}
