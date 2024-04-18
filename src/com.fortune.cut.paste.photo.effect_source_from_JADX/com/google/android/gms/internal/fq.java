package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.fl.C1149a;
import com.google.android.gms.internal.gv.C1012a;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ey
public final class fq extends C1149a {
    private static final Object ut;
    private static fq uu;
    private final Context mContext;
    private final fw uv;
    private final cn uw;
    private final bm ux;

    /* renamed from: com.google.android.gms.internal.fq.1 */
    static class C11551 implements Runnable {
        final /* synthetic */ Context nf;
        final /* synthetic */ C1012a uA;
        final /* synthetic */ String uB;
        final /* synthetic */ fh uy;
        final /* synthetic */ fs uz;

        C11551(Context context, fh fhVar, fs fsVar, C1012a c1012a, String str) {
            this.nf = context;
            this.uy = fhVar;
            this.uz = fsVar;
            this.uA = c1012a;
            this.uB = str;
        }

        public final void run() {
            gu a = gu.m4782a(this.nf, new ay(), false, false, null, this.uy.lO);
            a.setWillNotDraw(true);
            this.uz.m4648b(a);
            gv dD = a.dD();
            dD.m4800a("/invalidRequest", this.uz.uG);
            dD.m4800a("/loadAdURL", this.uz.uH);
            dD.m4800a("/log", cc.pX);
            dD.m4797a(this.uA);
            gr.m4769S("Loading the JS library.");
            a.loadUrl(this.uB);
        }
    }

    /* renamed from: com.google.android.gms.internal.fq.2 */
    static class C11562 implements Runnable {
        final /* synthetic */ fs uz;

        C11562(fs fsVar) {
            this.uz = fsVar;
        }

        public final void run() {
            this.uz.cS();
        }
    }

    /* renamed from: com.google.android.gms.internal.fq.3 */
    static class C11573 implements C1012a {
        final /* synthetic */ String uC;

        C11573(String str) {
            this.uC = str;
        }

        public final void m4628a(gu guVar) {
            String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", this.uC});
            gr.m4772V("About to execute: " + format);
            guVar.loadUrl(format);
        }
    }

    static {
        ut = new Object();
    }

    fq(Context context, bm bmVar, cn cnVar, fw fwVar) {
        this.mContext = context;
        this.uv = fwVar;
        this.uw = cnVar;
        this.ux = bmVar;
    }

    private static C1012a m4629I(String str) {
        return new C11573(str);
    }

    private static fj m4630a(Context context, bm bmVar, cn cnVar, fw fwVar, fh fhVar) {
        gr.m4769S("Starting ad request from service.");
        cnVar.init();
        fv fvVar = new fv(context);
        if (fvVar.vr == -1) {
            gr.m4769S("Device is offline.");
            return new fj(2);
        }
        String string;
        fs fsVar = new fs(fhVar.applicationInfo.packageName);
        if (fhVar.tL.extras != null) {
            string = fhVar.tL.extras.getString("_ad");
            if (string != null) {
                return fr.m4635a(context, fhVar, string);
            }
        }
        Location a = cnVar.m4361a(250);
        String bu = bmVar.bu();
        string = fr.m4636a(fhVar, fvVar, a, bmVar.bv(), bmVar.bw(), bmVar.bx());
        if (string == null) {
            return new fj(0);
        }
        gq.wR.post(new C11551(context, fhVar, fsVar, m4629I(string), bu));
        fj fjVar;
        try {
            fu fuVar = (fu) fsVar.cR().get(10, TimeUnit.SECONDS);
            if (fuVar == null) {
                fjVar = new fj(0);
                return fjVar;
            } else if (fuVar.getErrorCode() != -2) {
                fj fjVar2 = new fj(fuVar.getErrorCode());
                gq.wR.post(new C11562(fsVar));
                return fjVar2;
            } else {
                String str = null;
                if (fuVar.cV()) {
                    str = fwVar.m4674K(fhVar.tM.packageName);
                }
                fjVar = m4631a(context, fhVar.lO.wS, fuVar.getUrl(), str, fuVar);
                gq.wR.post(new C11562(fsVar));
                return fjVar;
            }
        } catch (Exception e) {
            fjVar = new fj(0);
            return fjVar;
        } finally {
            gq.wR.post(new C11562(fsVar));
        }
    }

    public static fj m4631a(Context context, String str, String str2, String str3, fu fuVar) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            fj fjVar;
            ft ftVar = new ft();
            gr.m4769S("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                gi.m4726a(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!(fuVar == null || TextUtils.isEmpty(fuVar.cU()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = fuVar.cU().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    m4633a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        gr.m4773W("No location header to follow redirect.");
                        fjVar = new fj(0);
                        httpURLConnection.disconnect();
                        return fjVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        gr.m4773W("Too many redirects.");
                        fjVar = new fj(0);
                        httpURLConnection.disconnect();
                        return fjVar;
                    }
                    ftVar.m4668e(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = gi.m4720a(new InputStreamReader(httpURLConnection.getInputStream()));
                    m4633a(url3, headerFields, a, responseCode);
                    ftVar.m4667a(url3, headerFields, a);
                    fjVar = ftVar.m4669i(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return fjVar;
                }
            }
            gr.m4773W("Received error HTTP response code: " + responseCode);
            fjVar = new fj(0);
            httpURLConnection.disconnect();
            return fjVar;
        } catch (IOException e) {
            gr.m4773W("Error while connecting to ad server: " + e.getMessage());
            return new fj(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static fq m4632a(Context context, bm bmVar, cn cnVar, fw fwVar) {
        fq fqVar;
        synchronized (ut) {
            if (uu == null) {
                uu = new fq(context.getApplicationContext(), bmVar, cnVar, fwVar);
            }
            fqVar = uu;
        }
        return fqVar;
    }

    private static void m4633a(String str, Map<String, List<String>> map, String str2, int i) {
        if (gr.m4778v(2)) {
            gr.m4772V("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    gr.m4772V("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        gr.m4772V("      " + str32);
                    }
                }
            }
            gr.m4772V("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                    gr.m4772V(str2.substring(i2, Math.min(str2.length(), i2 + LocationStatusCodes.GEOFENCE_NOT_AVAILABLE)));
                }
            } else {
                gr.m4772V("    null");
            }
            gr.m4772V("  Response Code:\n    " + i + "\n}");
        }
    }

    public final fj m4634b(fh fhVar) {
        return m4630a(this.mContext, this.ux, this.uw, this.uv, fhVar);
    }
}
