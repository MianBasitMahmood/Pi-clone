package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.dx.C1094a;
import com.google.android.gms.internal.gv.C1012a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

@ey
public class dp extends C1094a {
    private static final int rL;
    private gu mo;
    private final Activity nB;
    private dr rM;
    private dt rN;
    private C1093c rO;
    private du rP;
    private boolean rQ;
    private boolean rR;
    private FrameLayout rS;
    private CustomViewCallback rT;
    private boolean rU;
    private boolean rV;
    private boolean rW;
    private RelativeLayout rX;

    /* renamed from: com.google.android.gms.internal.dp.1 */
    class C10901 implements C1012a {
        final /* synthetic */ dp rY;

        C10901(dp dpVar) {
            this.rY = dpVar;
        }

        public void m4444a(gu guVar) {
            guVar.ci();
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.dp.a */
    private static final class C1091a extends Exception {
        public C1091a(String str) {
            super(str);
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.dp.b */
    private static final class C1092b extends RelativeLayout {
        private final gl lJ;

        public C1092b(Context context, String str) {
            super(context);
            this.lJ = new gl(context, str);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.lJ.m4751c(motionEvent);
            return false;
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.dp.c */
    private static final class C1093c {
        public final int index;
        public final LayoutParams rZ;
        public final ViewGroup sa;

        public C1093c(gu guVar) throws C1091a {
            this.rZ = guVar.getLayoutParams();
            ViewParent parent = guVar.getParent();
            if (parent instanceof ViewGroup) {
                this.sa = (ViewGroup) parent;
                this.index = this.sa.indexOfChild(guVar);
                this.sa.removeView(guVar);
                guVar.m4791z(true);
                return;
            }
            throw new C1091a("Could not get the parent of the WebView for an overlay.");
        }
    }

    static {
        rL = Color.argb(0, 0, 0, 0);
    }

    public dp(Activity activity) {
        this.rR = false;
        this.rU = false;
        this.rV = false;
        this.rW = false;
        this.nB = activity;
    }

    private static RelativeLayout.LayoutParams m4447a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static void m4448a(Context context, dr drVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", drVar.lO.wV);
        dr.m4459a(intent, drVar);
        if (!ll.in()) {
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    public void m4449X() {
        this.rQ = true;
    }

    public void m4450a(View view, CustomViewCallback customViewCallback) {
        this.rS = new FrameLayout(this.nB);
        this.rS.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.rS.addView(view, -1, -1);
        this.nB.setContentView(this.rS);
        m4449X();
        this.rT = customViewCallback;
        this.rR = true;
    }

    public void m4451b(int i, int i2, int i3, int i4) {
        if (this.rN != null) {
            this.rN.setLayoutParams(m4447a(i, i2, i3, i4));
        }
    }

    public void m4452c(int i, int i2, int i3, int i4) {
        if (this.rN == null) {
            this.rN = new dt(this.nB, this.mo);
            this.rX.addView(this.rN, 0, m4447a(i, i2, i3, i4));
            this.mo.dD().m4794A(false);
        }
    }

    public dt ce() {
        return this.rN;
    }

    public void cf() {
        if (this.rM != null && this.rR) {
            setRequestedOrientation(this.rM.orientation);
        }
        if (this.rS != null) {
            this.nB.setContentView(this.rX);
            m4449X();
            this.rS.removeAllViews();
            this.rS = null;
        }
        if (this.rT != null) {
            this.rT.onCustomViewHidden();
            this.rT = null;
        }
        this.rR = false;
    }

    public void cg() {
        this.rX.removeView(this.rP);
        m4453p(true);
    }

    void ch() {
        if (this.nB.isFinishing() && !this.rV) {
            this.rV = true;
            if (this.nB.isFinishing()) {
                if (this.mo != null) {
                    cj();
                    this.rX.removeView(this.mo);
                    if (this.rO != null) {
                        this.mo.m4791z(false);
                        this.rO.sa.addView(this.mo, this.rO.index, this.rO.rZ);
                    }
                }
                if (this.rM != null && this.rM.sd != null) {
                    this.rM.sd.ag();
                }
            }
        }
    }

    void ci() {
        this.mo.ci();
    }

    void cj() {
        this.mo.cj();
    }

    public void close() {
        this.nB.finish();
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.rU = z;
        try {
            this.rM = dr.m4460b(this.nB.getIntent());
            if (this.rM == null) {
                throw new C1091a("Could not get info for ad overlay.");
            }
            if (this.rM.sn != null) {
                this.rW = this.rM.sn.mi;
            } else {
                this.rW = false;
            }
            if (bundle == null) {
                if (this.rM.sd != null) {
                    this.rM.sd.ah();
                }
                if (!(this.rM.sk == 1 || this.rM.sc == null)) {
                    this.rM.sc.onAdClicked();
                }
            }
            switch (this.rM.sk) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    m4455r(false);
                case DataEvent.TYPE_DELETED /*2*/:
                    this.rO = new C1093c(this.rM.se);
                    m4455r(false);
                case WalletFragmentState.PROCESSING /*3*/:
                    m4455r(true);
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    if (this.rU) {
                        this.nB.finish();
                    } else if (!dm.m4440a(this.nB, this.rM.sb, this.rM.sj)) {
                        this.nB.finish();
                    }
                default:
                    throw new C1091a("Could not determine ad overlay type.");
            }
        } catch (C1091a e) {
            gr.m4773W(e.getMessage());
            this.nB.finish();
        }
    }

    public void onDestroy() {
        if (this.rN != null) {
            this.rN.destroy();
        }
        if (this.mo != null) {
            this.rX.removeView(this.mo);
        }
        ch();
    }

    public void onPause() {
        if (this.rN != null) {
            this.rN.pause();
        }
        cf();
        if (this.mo != null && (!this.nB.isFinishing() || this.rO == null)) {
            gi.m4729a(this.mo);
        }
        ch();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.rM != null && this.rM.sk == 4) {
            if (this.rU) {
                this.nB.finish();
            } else {
                this.rU = true;
            }
        }
        if (this.mo != null) {
            gi.m4734b(this.mo);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.rU);
    }

    public void onStart() {
    }

    public void onStop() {
        ch();
    }

    public void m4453p(boolean z) {
        this.rP = new du(this.nB, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.rP.m4469q(this.rM.sh);
        this.rX.addView(this.rP, layoutParams);
    }

    public void m4454q(boolean z) {
        if (this.rP != null) {
            this.rP.m4469q(z);
        }
    }

    void m4455r(boolean z) throws C1091a {
        if (!this.rQ) {
            this.nB.requestWindowFeature(1);
        }
        Window window = this.nB.getWindow();
        if (!this.rW || this.rM.sn.ms) {
            window.setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        }
        setRequestedOrientation(this.rM.orientation);
        if (VERSION.SDK_INT >= 11) {
            gr.m4769S("Enabling hardware acceleration on the AdActivity window.");
            gm.m4753a(window);
        }
        this.rX = new C1092b(this.nB, this.rM.sm);
        if (this.rW) {
            this.rX.setBackgroundColor(rL);
        } else {
            this.rX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.nB.setContentView(this.rX);
        m4449X();
        boolean dN = this.rM.se.dD().dN();
        if (z) {
            this.mo = gu.m4782a(this.nB, this.rM.se.ac(), true, dN, null, this.rM.lO);
            this.mo.dD().m4799a(null, null, this.rM.sf, this.rM.sj, true, this.rM.sl, this.rM.se.dD().dM());
            this.mo.dD().m4797a(new C10901(this));
            if (this.rM.rH != null) {
                this.mo.loadUrl(this.rM.rH);
            } else if (this.rM.si != null) {
                this.mo.loadDataWithBaseURL(this.rM.sg, this.rM.si, "text/html", "UTF-8", null);
            } else {
                throw new C1091a("No URL or HTML to display in ad overlay.");
            }
        }
        this.mo = this.rM.se;
        this.mo.setContext(this.nB);
        this.mo.m4786a(this);
        ViewParent parent = this.mo.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.mo);
        }
        if (this.rW) {
            this.mo.setBackgroundColor(rL);
        }
        this.rX.addView(this.mo, -1, -1);
        if (!z) {
            ci();
        }
        m4453p(dN);
        if (this.mo.dE()) {
            m4454q(true);
        }
    }

    public void setRequestedOrientation(int i) {
        this.nB.setRequestedOrientation(i);
    }
}
