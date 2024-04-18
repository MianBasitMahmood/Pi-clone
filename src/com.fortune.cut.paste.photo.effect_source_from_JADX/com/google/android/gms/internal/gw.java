package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

@ey
public class gw extends WebChromeClient {
    private final gu mo;

    /* renamed from: com.google.android.gms.internal.gw.1 */
    static class C11751 implements OnCancelListener {
        final /* synthetic */ JsResult xn;

        C11751(JsResult jsResult) {
            this.xn = jsResult;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.xn.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.2 */
    static class C11762 implements OnClickListener {
        final /* synthetic */ JsResult xn;

        C11762(JsResult jsResult) {
            this.xn = jsResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.xn.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.3 */
    static class C11773 implements OnClickListener {
        final /* synthetic */ JsResult xn;

        C11773(JsResult jsResult) {
            this.xn = jsResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.xn.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.4 */
    static class C11784 implements OnCancelListener {
        final /* synthetic */ JsPromptResult xo;

        C11784(JsPromptResult jsPromptResult) {
            this.xo = jsPromptResult;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.xo.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.5 */
    static class C11795 implements OnClickListener {
        final /* synthetic */ JsPromptResult xo;

        C11795(JsPromptResult jsPromptResult) {
            this.xo = jsPromptResult;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.xo.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.6 */
    static class C11806 implements OnClickListener {
        final /* synthetic */ JsPromptResult xo;
        final /* synthetic */ EditText xp;

        C11806(JsPromptResult jsPromptResult, EditText editText) {
            this.xo = jsPromptResult;
            this.xp = editText;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.xo.confirm(this.xp.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.gw.7 */
    static /* synthetic */ class C11817 {
        static final /* synthetic */ int[] xq;

        static {
            xq = new int[MessageLevel.values().length];
            try {
                xq[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xq[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xq[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                xq[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                xq[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public gw(gu guVar) {
        this.mo = guVar;
    }

    private static void m4804a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C11773(jsResult)).setNegativeButton(17039360, new C11762(jsResult)).setOnCancelListener(new C11751(jsResult)).create().show();
    }

    private static void m4805a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C11806(jsPromptResult, editText)).setNegativeButton(17039360, new C11795(jsPromptResult)).setOnCancelListener(new C11784(jsPromptResult)).create().show();
    }

    private final Context m4806c(WebView webView) {
        if (!(webView instanceof gu)) {
            return webView.getContext();
        }
        gu guVar = (gu) webView;
        Context dI = guVar.dI();
        return dI == null ? guVar.getContext() : dI;
    }

    protected final void m4807a(View view, int i, CustomViewCallback customViewCallback) {
        dp dC = this.mo.dC();
        if (dC == null) {
            gr.m4773W("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        dC.m4450a(view, customViewCallback);
        dC.setRequestedOrientation(i);
    }

    protected boolean m4808a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                m4805a(context, builder, str2, str3, jsPromptResult);
            } else {
                m4804a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            gr.m4777d("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof gu) {
            dp dC = ((gu) webView).dC();
            if (dC == null) {
                gr.m4773W("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                dC.close();
                return;
            }
        }
        gr.m4773W("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C11817.xq[consoleMessage.messageLevel().ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                gr.m4770T(str);
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                gr.m4773W(str);
                break;
            case WalletFragmentState.PROCESSING /*3*/:
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                gr.m4771U(str);
                break;
            case Dimension.UNIT_MM /*5*/:
                gr.m4769S(str);
                break;
            default:
                gr.m4771U(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.mo.dD());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(131072, j4) + j, 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        dp dC = this.mo.dC();
        if (dC == null) {
            gr.m4773W("Could not get ad overlay when hiding custom view.");
        } else {
            dC.cf();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m4808a(m4806c(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m4808a(m4806c(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m4808a(m4806c(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m4808a(m4806c(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m4807a(view, -1, customViewCallback);
    }
}
