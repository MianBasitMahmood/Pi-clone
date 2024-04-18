package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.FileUploadPreferences;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class gi {
    private static final Object ut;
    private static final SimpleDateFormat[] wB;
    private static boolean wC;
    private static String wD;
    private static boolean wE;

    /* renamed from: com.google.android.gms.internal.gi.1 */
    static class C11671 implements Runnable {
        final /* synthetic */ Context nf;

        C11671(Context context) {
            this.nf = context;
        }

        public final void run() {
            synchronized (gi.ut) {
                gi.wD = gi.m4741r(this.nf);
                gi.ut.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.gi.a */
    private static final class C1168a extends BroadcastReceiver {
        private C1168a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                gi.wC = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                gi.wC = false;
            }
        }
    }

    static {
        ut = new Object();
        wB = new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyyMMdd")};
        wC = true;
        wE = false;
    }

    public static String m4715L(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static int m4716M(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            gr.m4773W("Could not parse value:" + e);
            return 0;
        }
    }

    public static boolean m4717N(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static long m4718O(String str) {
        long j = -1;
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            SimpleDateFormat[] simpleDateFormatArr = wB;
            int length = simpleDateFormatArr.length;
            while (i < length) {
                SimpleDateFormat simpleDateFormat = simpleDateFormatArr[i];
                try {
                    simpleDateFormat.setLenient(false);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    j = simpleDateFormat.parse(str).getTime();
                    break;
                } catch (ParseException e) {
                    i++;
                }
            }
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e2) {
            }
        }
        return j;
    }

    public static String m4720a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    private static JSONArray m4721a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m4730a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray m4722a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m4730a(jSONArray, a);
        }
        return jSONArray;
    }

    public static void m4723a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m4735c(context, str));
    }

    public static void m4724a(Context context, String str, List<String> list) {
        for (String gpVar : list) {
            new gp(context, str, gpVar).start();
        }
    }

    public static void m4725a(Context context, String str, List<String> list, String str2) {
        for (String gpVar : list) {
            new gp(context, str, gpVar, str2).start();
        }
    }

    public static void m4726a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m4728a(context, str, z, httpURLConnection, false);
    }

    public static void m4727a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public static void m4728a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m4735c(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public static void m4729a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            gm.m4754a(webView);
        }
    }

    private static void m4730a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m4737c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m4743t((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m4721a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m4722a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void m4731a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m4737c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m4743t((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m4721a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m4721a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean m4732a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean m4733a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public static void m4734b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            gm.m4755b(webView);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4735c(android.content.Context r3, java.lang.String r4) {
        /*
        r1 = ut;
        monitor-enter(r1);
        r0 = wD;	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = wD;	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003a }
        r2 = 17;
        if (r0 < r2) goto L_0x003e;
    L_0x0011:
        r0 = com.google.android.gms.internal.go.getDefaultUserAgent(r3);	 Catch:{ Exception -> 0x003d }
        wD = r0;	 Catch:{ Exception -> 0x003d }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003d }
        r0.<init>();	 Catch:{ Exception -> 0x003d }
        r2 = wD;	 Catch:{ Exception -> 0x003d }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x003d }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x003d }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x003d }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x003d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x003d }
        wD = r0;	 Catch:{ Exception -> 0x003d }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x000a;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x003d:
        r0 = move-exception;
    L_0x003e:
        r0 = com.google.android.gms.internal.gq.dB();	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0074;
    L_0x0044:
        r0 = com.google.android.gms.internal.gq.wR;	 Catch:{ all -> 0x003a }
        r2 = new com.google.android.gms.internal.gi$1;	 Catch:{ all -> 0x003a }
        r2.<init>(r3);	 Catch:{ all -> 0x003a }
        r0.post(r2);	 Catch:{ all -> 0x003a }
    L_0x004e:
        r0 = wD;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x007a;
    L_0x0052:
        r0 = ut;	 Catch:{ InterruptedException -> 0x0058 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0058 }
        goto L_0x004e;
    L_0x0058:
        r0 = move-exception;
        r0 = dw();	 Catch:{ all -> 0x003a }
        wD = r0;	 Catch:{ all -> 0x003a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003a }
        r2 = "Interrupted, use default user agent: ";
        r0.<init>(r2);	 Catch:{ all -> 0x003a }
        r2 = wD;	 Catch:{ all -> 0x003a }
        r0 = r0.append(r2);	 Catch:{ all -> 0x003a }
        r0 = r0.toString();	 Catch:{ all -> 0x003a }
        com.google.android.gms.internal.gr.m4773W(r0);	 Catch:{ all -> 0x003a }
        goto L_0x004e;
    L_0x0074:
        r0 = m4741r(r3);	 Catch:{ Exception -> 0x009e }
        wD = r0;	 Catch:{ Exception -> 0x009e }
    L_0x007a:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003a }
        r0.<init>();	 Catch:{ all -> 0x003a }
        r2 = wD;	 Catch:{ all -> 0x003a }
        r0 = r0.append(r2);	 Catch:{ all -> 0x003a }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x003a }
        r0 = r0.append(r4);	 Catch:{ all -> 0x003a }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x003a }
        r0 = r0.toString();	 Catch:{ all -> 0x003a }
        wD = r0;	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x000a;
    L_0x009e:
        r0 = move-exception;
        r0 = dw();	 Catch:{ all -> 0x003a }
        wD = r0;	 Catch:{ all -> 0x003a }
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gi.c(android.content.Context, java.lang.String):java.lang.String");
    }

    public static Map<String, String> m4736c(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    private static JSONObject m4737c(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m4731a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m4738c(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m4724a(context, str, arrayList);
    }

    public static boolean dt() {
        return wC;
    }

    public static int du() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static int dv() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    static String dw() {
        StringBuffer stringBuffer = new StringBuffer(FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String dx() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public static boolean m4739p(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            gr.m4773W("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            gr.m4773W(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            gr.m4773W(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & Cast.MAX_NAMESPACE_LENGTH) == 0) {
            gr.m4773W(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED) == 0) {
            gr.m4773W(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            gr.m4773W(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) == 0) {
            gr.m4773W(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
            return z;
        }
        gr.m4773W(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static void m4740q(Context context) {
        if (!wE) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C1168a(), intentFilter);
            wE = true;
        }
    }

    private static String m4741r(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public static int m4742s(Context context) {
        int i;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            i2 = window.findViewById(16908290).getTop() - i;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public static JSONObject m4743t(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m4731a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static int[] m4744t(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float f = 160.0f / ((float) displayMetrics.densityDpi);
        int i = (int) (((float) displayMetrics.widthPixels) * f);
        int i2 = (int) (f * ((float) displayMetrics.heightPixels));
        return new int[]{i, i2};
    }
}
