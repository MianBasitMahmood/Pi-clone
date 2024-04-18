package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.C0161c.C0094b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0148a;
import com.chartboost.sdk.Model.C0148a.C0145b;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.ExecutionOptions;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class bb {
    private static bb f622c;
    private C0158a f623a;
    private C0148a f624b;

    /* renamed from: com.chartboost.sdk.impl.bb.a */
    public interface C0158a {
        void m418a(C0148a c0148a, boolean z, String str, CBClickError cBClickError, C0094b c0094b);
    }

    /* renamed from: com.chartboost.sdk.impl.bb.1 */
    class C02371 implements Runnable {
        final /* synthetic */ String f618a;
        final /* synthetic */ Activity f619b;
        final /* synthetic */ C0094b f620c;
        final /* synthetic */ bb f621d;

        /* renamed from: com.chartboost.sdk.impl.bb.1.1 */
        class C02361 implements Runnable {
            final /* synthetic */ String f616a;
            final /* synthetic */ C02371 f617b;

            C02361(C02371 c02371, String str) {
                this.f617b = c02371;
                this.f616a = str;
            }

            public void run() {
                this.f617b.f621d.m961a(this.f616a, this.f617b.f619b, this.f617b.f620c);
            }
        }

        C02371(bb bbVar, String str, Activity activity, C0094b c0094b) {
            this.f621d = bbVar;
            this.f618a = str;
            this.f619b = activity;
            this.f620c = c0094b;
        }

        public void run() {
            String str;
            Throwable th;
            String str2 = this.f618a;
            if (ay.m871a().m878c()) {
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f618a).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        String headerField = httpURLConnection2.getHeaderField("Location");
                        if (headerField != null) {
                            str2 = headerField;
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            str = str2;
                            m958a(str);
                        }
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        try {
                            CBLogging.m102b("CBURLOpener", "Exception raised while opening a HTTP Conection", th);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                str = str2;
                                m958a(str);
                            }
                            str = str2;
                            m958a(str);
                        } catch (Throwable th3) {
                            th = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    th = e2;
                    CBLogging.m102b("CBURLOpener", "Exception raised while opening a HTTP Conection", th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        str = str2;
                        m958a(str);
                    }
                    str = str2;
                    m958a(str);
                }
            }
            str = str2;
            m958a(str);
        }

        public void m958a(String str) {
            Runnable c02361 = new C02361(this, str);
            if (this.f619b != null) {
                this.f619b.runOnUiThread(c02361);
            } else {
                CBUtility.m120e().post(c02361);
            }
        }
    }

    public static bb m959a(C0158a c0158a) {
        if (f622c == null) {
            f622c = new bb(c0158a);
        }
        return f622c;
    }

    private bb(C0158a c0158a) {
        this.f623a = c0158a;
    }

    public final void m963a(C0148a c0148a, String str, Activity activity, C0094b c0094b) {
        this.f624b = c0148a;
        try {
            String scheme = new URI(str).getScheme();
            if (scheme == null) {
                if (this.f623a != null) {
                    this.f623a.m418a(c0148a, false, str, CBClickError.URI_INVALID, c0094b);
                }
            } else if (scheme.equals("http") || scheme.equals("https")) {
                ax.m867a().execute(new C02371(this, str, activity, c0094b));
            } else {
                m961a(str, activity, c0094b);
            }
        } catch (URISyntaxException e) {
            if (this.f623a != null) {
                this.f623a.m418a(c0148a, false, str, CBClickError.URI_INVALID, c0094b);
            }
        }
    }

    private void m961a(String str, Context context, C0094b c0094b) {
        Intent intent;
        String str2;
        if (this.f624b != null && this.f624b.m293a()) {
            this.f624b.f191b = C0145b.NONE;
        }
        if (context == null) {
            context = C0153b.m400l();
        }
        if (context != null) {
            try {
                intent = new Intent("android.intent.action.VIEW");
                if (!(context instanceof Activity)) {
                    intent.addFlags(DriveFile.MODE_READ_ONLY);
                }
                intent.setData(Uri.parse(str));
                context.startActivity(intent);
                str2 = str;
            } catch (Exception e) {
                if (str.startsWith("market://")) {
                    try {
                        str = "http://market.android.com/" + str.substring(9);
                        intent = new Intent("android.intent.action.VIEW");
                        if (!(context instanceof Activity)) {
                            intent.addFlags(DriveFile.MODE_READ_ONLY);
                        }
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                        str2 = str;
                    } catch (Throwable e2) {
                        str2 = str;
                        CBLogging.m102b("CBURLOpener", "Exception raised openeing an inavld playstore URL", e2);
                        if (this.f623a != null) {
                            this.f623a.m418a(this.f624b, false, str2, CBClickError.URI_UNRECOGNIZED, c0094b);
                            return;
                        }
                        return;
                    }
                }
                if (this.f623a != null) {
                    this.f623a.m418a(this.f624b, false, str, CBClickError.URI_UNRECOGNIZED, c0094b);
                }
                str2 = str;
            }
            if (this.f623a != null) {
                this.f623a.m418a(this.f624b, true, str2, null, c0094b);
            }
        } else if (this.f623a != null) {
            this.f623a.m418a(this.f624b, false, str, CBClickError.NO_HOST_ACTIVITY, c0094b);
        }
    }

    public static boolean m962a(String str) {
        Context l = C0153b.m400l();
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(l instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        intent.setData(Uri.parse(str));
        return l.getPackageManager().queryIntentActivities(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH).size() > 0;
    }
}
