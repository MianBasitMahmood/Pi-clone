package com.chartboost.sdk.impl;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.CBLogging;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class ax {
    private static ExecutorService f561a;
    private static ThreadFactory f562b;
    private static HttpClient f563c;

    /* renamed from: com.chartboost.sdk.impl.ax.1 */
    static class C02231 implements ThreadFactory {
        private final AtomicInteger f559a;

        C02231() {
            this.f559a = new AtomicInteger(1);
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Chartboost Thread #" + this.f559a.getAndIncrement());
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ax.2 */
    static class C02242 extends DefaultHttpClient {
        final /* synthetic */ Application f560a;

        C02242(Application application) {
            this.f560a = application;
        }

        protected final ClientConnectionManager createClientConnectionManager() {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", m865a(), 443));
            HttpParams params = getParams();
            HttpConnectionParams.setConnectionTimeout(params, 30000);
            HttpConnectionParams.setSoTimeout(params, 30000);
            HttpProtocolParams.setUserAgent(params, ax.m868b(this.f560a, HttpProtocolParams.getUserAgent(params)));
            return new ThreadSafeClientConnManager(params, schemeRegistry);
        }

        protected final SocketFactory m865a() {
            try {
                Object newInstance = Class.forName("android.net.SSLSessionCache").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f560a});
                return (SocketFactory) Class.forName("android.net.SSLCertificateSocketFactory").getMethod("getHttpSocketFactory", new Class[]{Integer.TYPE, r0}).invoke(null, new Object[]{Integer.valueOf(30000), newInstance});
            } catch (Throwable e) {
                CBLogging.m102b("CBAsync:HttpClientProvider", "Unable to use android.net.SSLCertificateSocketFactory to get a SSL session caching socket factory, falling back to a non-caching socket factory", e);
                return SSLSocketFactory.getSocketFactory();
            }
        }
    }

    static {
        f561a = null;
        f562b = null;
        f563c = null;
    }

    public static ExecutorService m867a() {
        if (f562b == null) {
            f562b = new C02231();
        }
        if (f561a == null) {
            f561a = Executors.newFixedThreadPool(5, f562b);
        }
        return f561a;
    }

    protected static HttpClient m869b() {
        if (f563c != null) {
            return f563c;
        }
        try {
            HttpClient c02242 = new C02242((Application) C0153b.m400l().getApplicationContext());
            f563c = c02242;
            return c02242;
        } catch (Throwable e) {
            Throwable th = e;
            CBLogging.m102b("CBAsync", "Exception raised getting a Chartboost HTTPClient on which to run any network request", th);
            HttpClient defaultHttpClient;
            try {
                defaultHttpClient = new DefaultHttpClient();
                ClientConnectionManager connectionManager = defaultHttpClient.getConnectionManager();
                HttpParams params = defaultHttpClient.getParams();
                defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params, connectionManager.getSchemeRegistry()), params);
                f563c = defaultHttpClient;
                return defaultHttpClient;
            } catch (Exception e2) {
                CBLogging.m102b("CBAsync", "Exception raised creating a simple HTTP client", th);
                defaultHttpClient = new DefaultHttpClient();
                f563c = defaultHttpClient;
                return defaultHttpClient;
            }
        }
    }

    private static String m868b(Application application, String str) {
        try {
            String str2 = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(application.getPackageName());
            stringBuilder.append("/");
            stringBuilder.append(str2);
            stringBuilder.append(" (");
            stringBuilder.append("Linux; U; Android ");
            stringBuilder.append(VERSION.RELEASE);
            stringBuilder.append("; ");
            stringBuilder.append(Locale.getDefault());
            stringBuilder.append("; ");
            stringBuilder.append(Build.PRODUCT);
            stringBuilder.append(")");
            if (str != null) {
                stringBuilder.append(" ");
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
