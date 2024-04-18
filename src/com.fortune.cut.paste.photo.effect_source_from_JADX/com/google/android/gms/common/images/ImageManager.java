package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0536a.C0535a;
import com.google.android.gms.common.images.C0536a.C0537b;
import com.google.android.gms.common.images.C0536a.C0538c;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.ll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object Lu;
    private static HashSet<Uri> Lv;
    private static ImageManager Lw;
    private static ImageManager Lx;
    private final jc LA;
    private final Map<C0536a, ImageReceiver> LB;
    private final Map<Uri, ImageReceiver> LC;
    private final Map<Uri, Long> LD;
    private final ExecutorService Ly;
    private final C0530b Lz;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<C0536a> LE;
        final /* synthetic */ ImageManager LF;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.LF = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.LE = new ArrayList();
        }

        public final void m1880b(C0536a c0536a) {
            je.aU("ImageReceiver.addImageRequest() must be called in the main thread");
            this.LE.add(c0536a);
        }

        public final void m1881c(C0536a c0536a) {
            je.aU("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.LE.remove(c0536a);
        }

        public final void hg() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.LF.mContext.sendBroadcast(intent);
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            this.LF.Ly.execute(new C0531c(this.LF, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.a */
    private static final class C0529a {
        static int m1882a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.b */
    private static final class C0530b extends kj<C0535a, Bitmap> {
        public C0530b(Context context) {
            super(C0530b.m1884I(context));
        }

        private static int m1884I(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ll.ig()) ? activityManager.getMemoryClass() : C0529a.m1882a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected final int m1885a(C0535a c0535a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected final void m1886a(boolean z, C0535a c0535a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0535a, bitmap, bitmap2);
        }

        protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            m1886a(z, (C0535a) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m1885a((C0535a) obj, (Bitmap) obj2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.c */
    private final class C0531c implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final ParcelFileDescriptor LG;
        private final Uri mUri;

        public C0531c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.LF = imageManager;
            this.mUri = uri;
            this.LG = parcelFileDescriptor;
        }

        public final void run() {
            je.aV("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.LG != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.LG.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.LG.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.LF.mHandler.post(new C0534f(this.LF, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.d */
    private final class C0532d implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final C0536a LH;

        public C0532d(ImageManager imageManager, C0536a c0536a) {
            this.LF = imageManager;
            this.LH = c0536a;
        }

        public final void run() {
            je.aU("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LB.get(this.LH);
            if (imageReceiver != null) {
                this.LF.LB.remove(this.LH);
                imageReceiver.m1881c(this.LH);
            }
            C0535a c0535a = this.LH.LJ;
            if (c0535a.uri == null) {
                this.LH.m1906a(this.LF.mContext, this.LF.LA, true);
                return;
            }
            Bitmap a = this.LF.m1889a(c0535a);
            if (a != null) {
                this.LH.m1904a(this.LF.mContext, a, true);
                return;
            }
            Long l = (Long) this.LF.LD.get(c0535a.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.LH.m1906a(this.LF.mContext, this.LF.LA, true);
                    return;
                }
                this.LF.LD.remove(c0535a.uri);
            }
            this.LH.m1905a(this.LF.mContext, this.LF.LA);
            imageReceiver = (ImageReceiver) this.LF.LC.get(c0535a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.LF, c0535a.uri);
                this.LF.LC.put(c0535a.uri, imageReceiver);
            }
            imageReceiver.m1880b(this.LH);
            if (!(this.LH instanceof C0538c)) {
                this.LF.LB.put(this.LH, imageReceiver);
            }
            synchronized (ImageManager.Lu) {
                if (!ImageManager.Lv.contains(c0535a.uri)) {
                    ImageManager.Lv.add(c0535a.uri);
                    imageReceiver.hg();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.e */
    private static final class C0533e implements ComponentCallbacks2 {
        private final C0530b Lz;

        public C0533e(C0530b c0530b) {
            this.Lz = c0530b;
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            this.Lz.evictAll();
        }

        public final void onTrimMemory(int i) {
            if (i >= 60) {
                this.Lz.evictAll();
            } else if (i >= 20) {
                this.Lz.trimToSize(this.Lz.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.f */
    private final class C0534f implements Runnable {
        final /* synthetic */ ImageManager LF;
        private boolean LI;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch mr;

        public C0534f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.LF = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.LI = z;
            this.mr = countDownLatch;
        }

        private void m1887a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.LE;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0536a c0536a = (C0536a) a.get(i);
                if (z) {
                    c0536a.m1904a(this.LF.mContext, this.mBitmap, false);
                } else {
                    this.LF.LD.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    c0536a.m1906a(this.LF.mContext, this.LF.LA, false);
                }
                if (!(c0536a instanceof C0538c)) {
                    this.LF.LB.remove(c0536a);
                }
            }
        }

        public final void run() {
            je.aU("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.LF.Lz != null) {
                if (this.LI) {
                    this.LF.Lz.evictAll();
                    System.gc();
                    this.LI = false;
                    this.LF.mHandler.post(this);
                    return;
                } else if (z) {
                    this.LF.Lz.put(new C0535a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LC.remove(this.mUri);
            if (imageReceiver != null) {
                m1887a(imageReceiver, z);
            }
            this.mr.countDown();
            synchronized (ImageManager.Lu) {
                ImageManager.Lv.remove(this.mUri);
            }
        }
    }

    static {
        Lu = new Object();
        Lv = new HashSet();
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Ly = Executors.newFixedThreadPool(4);
        if (z) {
            this.Lz = new C0530b(this.mContext);
            if (ll.ij()) {
                hd();
            }
        } else {
            this.Lz = null;
        }
        this.LA = new jc();
        this.LB = new HashMap();
        this.LC = new HashMap();
        this.LD = new HashMap();
    }

    private Bitmap m1889a(C0535a c0535a) {
        return this.Lz == null ? null : (Bitmap) this.Lz.get(c0535a);
    }

    public static ImageManager m1892c(Context context, boolean z) {
        if (z) {
            if (Lx == null) {
                Lx = new ImageManager(context, true);
            }
            return Lx;
        }
        if (Lw == null) {
            Lw = new ImageManager(context, false);
        }
        return Lw;
    }

    public static ImageManager create(Context context) {
        return m1892c(context, false);
    }

    private void hd() {
        this.mContext.registerComponentCallbacks(new C0533e(this.Lz));
    }

    public final void m1899a(C0536a c0536a) {
        je.aU("ImageManager.loadImage() must be called in the main thread");
        new C0532d(this, c0536a).run();
    }

    public final void loadImage(ImageView imageView, int i) {
        m1899a(new C0537b(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        m1899a(new C0537b(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        C0536a c0537b = new C0537b(imageView, uri);
        c0537b.az(i);
        m1899a(c0537b);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        m1899a(new C0538c(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        C0536a c0538c = new C0538c(onImageLoadedListener, uri);
        c0538c.az(i);
        m1899a(c0538c);
    }
}
