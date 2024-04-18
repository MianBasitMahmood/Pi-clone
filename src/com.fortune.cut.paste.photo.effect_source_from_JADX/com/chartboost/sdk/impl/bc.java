package com.chartboost.sdk.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chartboost.sdk.Libraries.C0105b;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.C0139j.C0137a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public final class bc {
    private static volatile bc f634c;
    private C0132h f635a;
    private Map<String, C0137a> f636b;

    /* renamed from: com.chartboost.sdk.impl.bc.b */
    public interface C0134b {
        void m251a(C0137a c0137a, Bundle bundle);
    }

    /* renamed from: com.chartboost.sdk.impl.bc.a */
    private class C0239a implements Runnable {
        final /* synthetic */ bc f627a;
        private String f628b;
        private final WeakReference<ImageView> f629c;
        private C0134b f630d;
        private String f631e;
        private Bundle f632f;

        /* renamed from: com.chartboost.sdk.impl.bc.a.1 */
        class C02381 implements Runnable {
            final /* synthetic */ C0137a f625a;
            final /* synthetic */ C0239a f626b;

            C02381(C0239a c0239a, C0137a c0137a) {
                this.f626b = c0239a;
                this.f625a = c0137a;
            }

            public void run() {
                if (this.f626b.f629c != null) {
                    ImageView imageView = (ImageView) this.f626b.f629c.get();
                    C0239a a = bc.m976b(imageView);
                    if (this.f625a != null && this.f626b == a) {
                        imageView.setImageBitmap(this.f625a.m255a());
                    }
                }
                if (this.f626b.f630d != null) {
                    this.f626b.f630d.m251a(this.f625a, this.f626b.f632f);
                }
            }
        }

        public C0239a(bc bcVar, ImageView imageView, C0134b c0134b, String str, Bundle bundle, String str2) {
            this.f627a = bcVar;
            this.f629c = new WeakReference(imageView);
            Drawable c0240c = new C0240c(this);
            if (imageView != null) {
                imageView.setImageDrawable(c0240c);
            }
            this.f631e = str;
            this.f630d = c0134b;
            this.f632f = bundle;
            this.f628b = str2;
        }

        public void run() {
            HttpEntity entity;
            Throwable e;
            HttpResponse httpResponse = null;
            if (this.f627a.m978b(this.f631e)) {
                m968a();
                return;
            }
            HttpClient b = ax.m869b();
            HttpGet httpGet = new HttpGet(this.f628b);
            CBLogging.m97a("CBWebImageCache", "downloading image to cache... " + this.f628b);
            HttpResponse execute;
            try {
                execute = b.execute(httpGet);
                try {
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode != 200) {
                        CBLogging.m105d("CBWebImageCache:ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + this.f628b);
                        CBUtility.m114a(execute);
                        m968a();
                        return;
                    }
                    entity = execute.getEntity();
                    if (entity != null) {
                        InputStream content = entity.getContent();
                        byte[] b2 = cd.m1198b(content);
                        String b3 = C0105b.m127b(C0105b.m126a(b2));
                        if (!b3.equals(this.f631e)) {
                            this.f631e = b3;
                            CBLogging.m101b("CBWebImageCache:ImageDownloader", "Error: checksum did not match while downloading from " + this.f628b);
                        }
                        this.f627a.f635a.m237a(String.format("%s%s", new Object[]{this.f631e, ".png"}), b2);
                        this.f627a.m971a(this.f631e);
                        if (content != null) {
                            content.close();
                        } else {
                            CBUtility.m113a(entity);
                        }
                    }
                    m968a();
                } catch (IOException e2) {
                    e = e2;
                    httpResponse = execute;
                    httpGet.abort();
                    CBUtility.m114a(httpResponse);
                    CBLogging.m106d("CBWebImageCache", "I/O error while retrieving bitmap from " + this.f628b, e);
                    m968a();
                } catch (IllegalStateException e3) {
                    e = e3;
                    httpGet.abort();
                    CBUtility.m114a(execute);
                    CBLogging.m106d("CBWebImageCache", "Incorrect URL: " + this.f628b, e);
                    m968a();
                } catch (Throwable th) {
                    e = th;
                    httpGet.abort();
                    CBUtility.m114a(execute);
                    CBLogging.m106d("CBWebImageCache", "Error while retrieving bitmap from " + this.f628b, e);
                    m968a();
                }
            } catch (IOException e4) {
                e = e4;
                httpGet.abort();
                CBUtility.m114a(httpResponse);
                CBLogging.m106d("CBWebImageCache", "I/O error while retrieving bitmap from " + this.f628b, e);
                m968a();
            } catch (IllegalStateException e5) {
                e = e5;
                execute = httpResponse;
                httpGet.abort();
                CBUtility.m114a(execute);
                CBLogging.m106d("CBWebImageCache", "Incorrect URL: " + this.f628b, e);
                m968a();
            } catch (Throwable th2) {
                e = th2;
                execute = httpResponse;
                httpGet.abort();
                CBUtility.m114a(execute);
                CBLogging.m106d("CBWebImageCache", "Error while retrieving bitmap from " + this.f628b, e);
                m968a();
            }
        }

        public void m968a() {
            C0137a b = m965b();
            if (!(b == null || this.f629c == null || this.f629c.get() == null || this != bc.m976b((ImageView) this.f629c.get()))) {
                b.m256b();
            }
            CBUtility.m120e().post(new C02381(this, b));
        }

        private C0137a m965b() {
            return (C0137a) this.f627a.f636b.get(this.f631e);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bc.c */
    static class C0240c extends BitmapDrawable {
        private final WeakReference<C0239a> f633a;

        public C0240c(C0239a c0239a) {
            this.f633a = new WeakReference(c0239a);
        }

        public C0239a m969a() {
            return (C0239a) this.f633a.get();
        }
    }

    static {
        f634c = null;
    }

    public static bc m973a() {
        if (f634c == null) {
            synchronized (bc.class) {
                if (f634c == null) {
                    f634c = new bc();
                }
            }
        }
        return f634c;
    }

    private bc() {
        this.f635a = new C0132h("CBImagesDirectory", true);
        this.f636b = new HashMap();
    }

    public final void m980b() {
        this.f635a.m239b();
        this.f636b.clear();
    }

    public final void m979a(String str, String str2, C0134b c0134b, ImageView imageView, Bundle bundle) {
        C0137a a = m971a(str2);
        if (a != null) {
            if (imageView != null) {
                imageView.setImageBitmap(a.m255a());
            }
            if (c0134b != null) {
                c0134b.m251a(a, bundle);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) && c0134b != null) {
            c0134b.m251a(null, bundle);
        }
        ax.m867a().execute(new C0239a(this, imageView, c0134b, str2, bundle, str));
    }

    private C0137a m971a(String str) {
        if (!m978b(str)) {
            if (this.f636b.containsKey(str)) {
                this.f636b.remove(str);
            }
            return null;
        } else if (this.f636b.containsKey(str)) {
            return (C0137a) this.f636b.get(str);
        } else {
            C0137a c0137a = new C0137a(str, this.f635a.m244d(String.format("%s%s", new Object[]{str, ".png"})), this.f635a);
            this.f636b.put(str, c0137a);
            return c0137a;
        }
    }

    private static C0239a m976b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof C0240c) {
                return ((C0240c) drawable).m969a();
            }
        }
        return null;
    }

    private boolean m978b(String str) {
        return this.f635a.m243c(String.format("%s%s", new Object[]{str, ".png"}));
    }
}
