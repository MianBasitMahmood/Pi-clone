package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.C0177f.C0138b;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.bc.C0134b;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.plus.PlusShare;
import java.io.File;

/* renamed from: com.chartboost.sdk.Libraries.j */
public final class C0139j implements C0138b {
    private C0137a f151a;
    private C0177f f152b;
    private String f153c;
    private float f154d;
    private C0134b f155e;

    /* renamed from: com.chartboost.sdk.Libraries.j.1 */
    class C01351 implements C0134b {
        final /* synthetic */ C0139j f139a;

        C01351(C0139j c0139j) {
            this.f139a = c0139j;
        }

        public void m252a(C0137a c0137a, Bundle bundle) {
            this.f139a.f151a = c0137a;
            this.f139a.f152b.m507a(this.f139a);
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.j.2 */
    class C01362 implements Runnable {
        final /* synthetic */ C0111a f140a;
        final /* synthetic */ String f141b;
        final /* synthetic */ Bundle f142c;
        final /* synthetic */ C0139j f143d;

        C01362(C0139j c0139j, C0111a c0111a, String str, Bundle bundle) {
            this.f143d = c0139j;
            this.f140a = c0111a;
            this.f141b = str;
            this.f142c = bundle;
        }

        public void run() {
            String str = "";
            if (!(this.f140a.m162e("checksum") == null || this.f140a.m162e("checksum").isEmpty())) {
                str = this.f140a.m162e("checksum");
            }
            bc.m973a().m979a(this.f141b, str, this.f143d.f155e, null, this.f142c == null ? new Bundle() : this.f142c);
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.j.a */
    public static class C0137a {
        private int f144a;
        private String f145b;
        private File f146c;
        private Bitmap f147d;
        private C0132h f148e;
        private int f149f;
        private int f150g;

        public C0137a(String str, File file, C0132h c0132h) {
            this.f149f = -1;
            this.f150g = -1;
            this.f146c = file;
            this.f145b = str;
            this.f147d = null;
            this.f144a = 1;
            this.f148e = c0132h;
        }

        public Bitmap m255a() {
            if (this.f147d == null) {
                m256b();
            }
            return this.f147d;
        }

        public void m256b() {
            if (this.f147d == null) {
                CBLogging.m97a("MemoryBitmap", "Loading image '" + this.f145b + "' from cache");
                byte[] b = this.f148e.m241b(this.f146c);
                if (b == null) {
                    CBLogging.m101b("MemoryBitmap", "decode() - bitmap not found");
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(b, 0, b.length, options);
                Options options2 = new Options();
                options2.inJustDecodeBounds = false;
                options2.inDither = false;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                options2.inTempStorage = new byte[AccessibilityNodeInfoCompat.ACTION_PASTE];
                options2.inSampleSize = 1;
                while (options2.inSampleSize < 32) {
                    try {
                        this.f147d = BitmapFactory.decodeByteArray(b, 0, b.length, options2);
                        break;
                    } catch (Throwable e) {
                        CBLogging.m102b("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", e);
                        options2.inSampleSize *= 2;
                    } catch (Throwable e2) {
                        CBLogging.m102b("MemoryBitmap", "Exception raised decoding bitmap", e2);
                    }
                }
                this.f144a = options2.inSampleSize;
            }
        }

        public void m257c() {
            try {
                if (!(this.f147d == null || this.f147d.isRecycled())) {
                    this.f147d.recycle();
                }
            } catch (Exception e) {
            }
            this.f147d = null;
        }

        public int m258d() {
            if (this.f147d != null) {
                return this.f147d.getWidth();
            }
            if (this.f149f >= 0) {
                return this.f149f;
            }
            m254f();
            return this.f149f;
        }

        public int m259e() {
            if (this.f147d != null) {
                return this.f147d.getHeight();
            }
            if (this.f150g >= 0) {
                return this.f150g;
            }
            m254f();
            return this.f150g;
        }

        private void m254f() {
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f146c.getAbsolutePath(), options);
                this.f149f = options.outWidth;
                this.f150g = options.outHeight;
            } catch (Throwable e) {
                CBLogging.m102b("MemoryBitmap", "Error decoding file size", e);
            }
        }
    }

    public C0139j(C0177f c0177f) {
        this.f154d = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.f155e = new C01351(this);
        this.f152b = c0177f;
    }

    public final int m267b() {
        if (this.f151a == null) {
            return 0;
        }
        return this.f151a.m258d() * this.f151a.f144a;
    }

    public final int m268c() {
        if (this.f151a == null) {
            return 0;
        }
        return this.f151a.m259e() * this.f151a.f144a;
    }

    public final void m265a(String str) {
        m264a(this.f152b.m519g(), str, new Bundle());
    }

    public final void m264a(C0111a c0111a, String str, Bundle bundle) {
        C0111a a = c0111a.m151a(str);
        this.f153c = str;
        if (!a.m155b()) {
            Object e = a.m162e(PlusShare.KEY_CALL_TO_ACTION_URL);
            this.f154d = a.m151a("scale").m149a((float) TextTrackStyle.DEFAULT_FONT_SCALE);
            if (!TextUtils.isEmpty(e)) {
                this.f152b.m513b((C0138b) this);
                CBUtility.m120e().post(new C01362(this, a, e, bundle));
            }
        }
    }

    public final boolean m266a() {
        return m270e();
    }

    public final void m269d() {
        if (this.f151a != null) {
            this.f151a.m257c();
        }
    }

    public final boolean m270e() {
        return this.f151a != null;
    }

    public final Bitmap m271f() {
        return this.f151a != null ? this.f151a.m255a() : null;
    }

    public final float m272g() {
        return this.f154d;
    }

    public final int m273h() {
        return Math.round(((float) m267b()) / this.f154d);
    }

    public final int m274i() {
        return Math.round(((float) m268c()) / this.f154d);
    }
}
