package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class an extends Thread {
    private final Object mH;
    private boolean mStarted;
    private boolean nC;
    private boolean nD;
    private final am nE;
    private final al nF;
    private final ex nG;
    private final int nH;
    private final int nI;
    private final int nJ;
    private final int np;
    private final int nr;

    /* renamed from: com.google.android.gms.internal.an.1 */
    class C10141 implements Runnable {
        final /* synthetic */ View nK;
        final /* synthetic */ an nL;

        C10141(an anVar, View view) {
            this.nL = anVar;
            this.nK = view;
        }

        public void run() {
            this.nL.m4171h(this.nK);
        }
    }

    /* renamed from: com.google.android.gms.internal.an.2 */
    class C10162 implements Runnable {
        final /* synthetic */ an nL;
        ValueCallback<String> nM;
        final /* synthetic */ ak nN;
        final /* synthetic */ WebView nO;

        /* renamed from: com.google.android.gms.internal.an.2.1 */
        class C10151 implements ValueCallback<String> {
            final /* synthetic */ C10162 nP;

            C10151(C10162 c10162) {
                this.nP = c10162;
            }

            public void m4165k(String str) {
                this.nP.nL.m4169a(this.nP.nN, this.nP.nO, str);
            }

            public /* synthetic */ void onReceiveValue(Object obj) {
                m4165k((String) obj);
            }
        }

        C10162(an anVar, ak akVar, WebView webView) {
            this.nL = anVar;
            this.nN = akVar;
            this.nO = webView;
            this.nM = new C10151(this);
        }

        public void run() {
            if (this.nO.getSettings().getJavaScriptEnabled()) {
                this.nO.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nM);
            }
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.an.a */
    class C1017a {
        final /* synthetic */ an nL;
        final int nQ;
        final int nR;

        C1017a(an anVar, int i, int i2) {
            this.nL = anVar;
            this.nQ = i;
            this.nR = i2;
        }
    }

    public an(am amVar, al alVar, Bundle bundle, ex exVar) {
        this.mStarted = false;
        this.nC = false;
        this.nD = false;
        this.nE = amVar;
        this.nF = alVar;
        this.nG = exVar;
        this.mH = new Object();
        this.np = bundle.getInt(bn.pq.getKey());
        this.nI = bundle.getInt(bn.pr.getKey());
        this.nr = bundle.getInt(bn.ps.getKey());
        this.nJ = bundle.getInt(bn.pt.getKey());
        this.nH = bundle.getInt(bn.pu.getKey(), 10);
        setName("ContentFetchTask");
    }

    private void m4166a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                m4170g(view);
            }
        }
    }

    private boolean m4167a(WebView webView, ak akVar) {
        if (!ll.im()) {
            return false;
        }
        akVar.aW();
        webView.post(new C10162(this, akVar, webView));
        return true;
    }

    private boolean bb() {
        try {
            Context context = this.nE.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (activityManager == null || keyguardManager == null || powerManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    C1017a m4168a(View view, ak akVar) {
        int i = 0;
        if (view == null) {
            return new C1017a(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            akVar.m4161i(((TextView) view).getText().toString());
            return new C1017a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof gu)) {
            akVar.aW();
            return m4167a((WebView) view, akVar) ? new C1017a(this, 0, 1) : new C1017a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C1017a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                C1017a a = m4168a(viewGroup.getChildAt(i), akVar);
                i3 += a.nQ;
                i2 += a.nR;
                i++;
            }
            return new C1017a(this, i3, i2);
        }
    }

    void m4169a(ak akVar, WebView webView, String str) {
        akVar.aV();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    akVar.m4160h(optString);
                } else {
                    akVar.m4160h(webView.getTitle() + "\n" + optString);
                }
            }
            if (akVar.aS()) {
                this.nF.m4163b(akVar);
            }
        } catch (JSONException e) {
            gr.m4769S("Json string may be malformed.");
        } catch (Throwable th) {
            gr.m4774a("Failed to get webview content.", th);
            this.nG.m4544b(th);
        }
    }

    public void ba() {
        synchronized (this.mH) {
            if (this.mStarted) {
                gr.m4769S("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public ak bc() {
        return this.nF.aZ();
    }

    public void bd() {
        synchronized (this.mH) {
            this.nC = true;
            gr.m4769S("ContentFetchThread: paused, mPause = " + this.nC);
        }
    }

    public boolean be() {
        return this.nC;
    }

    boolean m4170g(View view) {
        if (view == null) {
            return false;
        }
        view.post(new C10141(this, view));
        return true;
    }

    void m4171h(View view) {
        try {
            ak akVar = new ak(this.np, this.nI, this.nr, this.nJ);
            C1017a a = m4168a(view, akVar);
            akVar.aX();
            if (a.nQ != 0 || a.nR != 0) {
                if (a.nR != 0 || akVar.aY() != 0) {
                    if (a.nR != 0 || !this.nF.m4162a(akVar)) {
                        this.nF.m4164c(akVar);
                    }
                }
            }
        } catch (Throwable e) {
            gr.m4775b("Exception in fetchContentOnUIThread", e);
            this.nG.m4544b(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.nD;
        if (r0 != 0) goto L_0x0051;
    L_0x0004:
        r0 = r2.bb();	 Catch:{ Throwable -> 0x0018 }
        if (r0 == 0) goto L_0x0043;
    L_0x000a:
        r0 = r2.nE;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0.getActivity();	 Catch:{ Throwable -> 0x0018 }
        if (r0 != 0) goto L_0x0037;
    L_0x0012:
        r0 = "ContentFetchThread: no activity";
        com.google.android.gms.internal.gr.m4769S(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0000;
    L_0x0018:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.internal.gr.m4775b(r1, r0);
        r1 = r2.nG;
        r1.m4544b(r0);
    L_0x0023:
        r1 = r2.mH;
        monitor-enter(r1);
    L_0x0026:
        r0 = r2.nC;	 Catch:{ all -> 0x004e }
        if (r0 == 0) goto L_0x004c;
    L_0x002a:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.internal.gr.m4769S(r0);	 Catch:{ InterruptedException -> 0x0035 }
        r0 = r2.mH;	 Catch:{ InterruptedException -> 0x0035 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0035 }
        goto L_0x0026;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0037:
        r2.m4166a(r0);	 Catch:{ Throwable -> 0x0018 }
    L_0x003a:
        r0 = r2.nH;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0018 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0023;
    L_0x0043:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.internal.gr.m4769S(r0);	 Catch:{ Throwable -> 0x0018 }
        r2.bd();	 Catch:{ Throwable -> 0x0018 }
        goto L_0x003a;
    L_0x004c:
        monitor-exit(r1);	 Catch:{ all -> 0x004e }
        goto L_0x0000;
    L_0x004e:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.an.run():void");
    }

    public void wakeup() {
        synchronized (this.mH) {
            this.nC = false;
            this.mH.notifyAll();
            gr.m4769S("ContentFetchThread: wakeup");
        }
    }
}
