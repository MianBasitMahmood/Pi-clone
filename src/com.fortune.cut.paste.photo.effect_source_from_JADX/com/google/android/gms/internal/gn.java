package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ey
public class gn {
    public static final C1152a<Void> wN;

    /* renamed from: com.google.android.gms.internal.gn.a */
    public interface C1152a<T> {
        T m4612b(InputStream inputStream);

        T cQ();
    }

    /* renamed from: com.google.android.gms.internal.gn.1 */
    static class C11711 implements C1152a {
        C11711() {
        }

        public final /* synthetic */ Object m4758b(InputStream inputStream) {
            return m4759c(inputStream);
        }

        public final Void m4759c(InputStream inputStream) {
            return null;
        }

        public final /* synthetic */ Object cQ() {
            return dz();
        }

        public final Void dz() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.gn.2 */
    class C11722 implements Callable<T> {
        final /* synthetic */ String wO;
        final /* synthetic */ C1152a wP;
        final /* synthetic */ gn wQ;

        C11722(gn gnVar, String str, C1152a c1152a) {
            this.wQ = gnVar;
            this.wO = str;
            this.wP = c1152a;
        }

        public T call() {
            Throwable th;
            Throwable th2;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.wO).openConnection();
                try {
                    httpURLConnection2.connect();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode < 200 || responseCode > 299) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return this.wP.cQ();
                    }
                    T b = this.wP.m4612b(httpURLConnection2.getInputStream());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return b;
                } catch (Throwable e) {
                    th = e;
                    httpURLConnection = httpURLConnection2;
                    th2 = th;
                    try {
                        gr.m4777d("Error making HTTP request.", th2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return this.wP.cQ();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th2;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    httpURLConnection = httpURLConnection2;
                    th2 = th;
                    gr.m4777d("Error making HTTP request.", th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return this.wP.cQ();
                } catch (Throwable e22) {
                    th = e22;
                    httpURLConnection = httpURLConnection2;
                    th2 = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (MalformedURLException e3) {
                th2 = e3;
                gr.m4777d("Error making HTTP request.", th2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return this.wP.cQ();
            } catch (IOException e4) {
                th2 = e4;
                gr.m4777d("Error making HTTP request.", th2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return this.wP.cQ();
            }
        }
    }

    static {
        wN = new C11711();
    }

    public <T> Future<T> m4760a(String str, C1152a<T> c1152a) {
        return gh.submit(new C11722(this, str, c1152a));
    }
}
