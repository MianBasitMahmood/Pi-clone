package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jc.C1242a;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C0536a {
    final C0535a LJ;
    protected int LK;
    protected int LL;
    protected boolean LM;
    protected OnImageLoadedListener LN;
    private boolean LO;
    private boolean LP;
    private boolean LQ;
    protected int LR;

    /* renamed from: com.google.android.gms.common.images.a.a */
    static final class C0535a {
        public final Uri uri;

        public C0535a(Uri uri) {
            this.uri = uri;
        }

        public final boolean equals(Object obj) {
            return !(obj instanceof C0535a) ? false : this == obj ? true : jv.equal(((C0535a) obj).uri, this.uri);
        }

        public final int hashCode() {
            return jv.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.b */
    public static final class C0537b extends C0536a {
        private WeakReference<ImageView> LS;

        public C0537b(ImageView imageView, int i) {
            super(null, i);
            je.m5081f(imageView);
            this.LS = new WeakReference(imageView);
        }

        public C0537b(ImageView imageView, Uri uri) {
            super(uri, 0);
            je.m5081f(imageView);
            this.LS = new WeakReference(imageView);
        }

        private void m1909a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof jb)) {
                int hj = ((jb) imageView).hj();
                if (this.LL != 0 && hj == this.LL) {
                    return;
                }
            }
            boolean b = m1908b(z, z2);
            Drawable newDrawable = (!this.LM || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (b) {
                newDrawable = m1903a(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof jb) {
                jb jbVar = (jb) imageView;
                jbVar.m5078g(z3 ? this.LJ.uri : null);
                jbVar.aB(obj != null ? this.LL : 0);
            }
            if (b) {
                ((iz) newDrawable).startTransition(250);
            }
        }

        protected final void m1910a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.LS.get();
            if (imageView != null) {
                m1909a(imageView, drawable, z, z2, z3);
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0537b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.LS.get();
            ImageView imageView2 = (ImageView) ((C0537b) obj).LS.get();
            return (imageView2 == null || imageView == null || !jv.equal(imageView2, imageView)) ? false : true;
        }

        public final int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a.c */
    public static final class C0538c extends C0536a {
        private WeakReference<OnImageLoadedListener> LT;

        public C0538c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            je.m5081f(onImageLoadedListener);
            this.LT = new WeakReference(onImageLoadedListener);
        }

        protected final void m1911a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.LJ.uri, drawable, z3);
                }
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0538c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0538c c0538c = (C0538c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c0538c.LT.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && jv.equal(onImageLoadedListener2, onImageLoadedListener) && jv.equal(c0538c.LJ, this.LJ);
        }

        public final int hashCode() {
            return jv.hashCode(this.LJ);
        }
    }

    public C0536a(Uri uri, int i) {
        this.LK = 0;
        this.LL = 0;
        this.LM = false;
        this.LO = true;
        this.LP = false;
        this.LQ = true;
        this.LJ = new C0535a(uri);
        this.LL = i;
    }

    private Drawable m1901a(Context context, jc jcVar, int i) {
        Resources resources = context.getResources();
        if (this.LR <= 0) {
            return resources.getDrawable(i);
        }
        C1242a c1242a = new C1242a(i, this.LR);
        Drawable drawable = (Drawable) jcVar.get(c1242a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.LR & 1) != 0) {
            drawable = m1902a(resources, drawable);
        }
        jcVar.put(c1242a, drawable);
        return drawable;
    }

    protected Drawable m1902a(Resources resources, Drawable drawable) {
        return ja.m5076a(resources, drawable);
    }

    protected iz m1903a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof iz) {
            drawable = ((iz) drawable).hh();
        }
        return new iz(drawable, drawable2);
    }

    void m1904a(Context context, Bitmap bitmap, boolean z) {
        je.m5081f(bitmap);
        if ((this.LR & 1) != 0) {
            bitmap = ja.m5074a(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, bitmapDrawable, true);
        }
        m1907a(bitmapDrawable, z, false, true);
    }

    void m1905a(Context context, jc jcVar) {
        if (this.LQ) {
            Drawable drawable = null;
            if (this.LK != 0) {
                drawable = m1901a(context, jcVar, this.LK);
            }
            m1907a(drawable, false, true, false);
        }
    }

    void m1906a(Context context, jc jcVar, boolean z) {
        Drawable drawable = null;
        if (this.LL != 0) {
            drawable = m1901a(context, jcVar, this.LL);
        }
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, drawable, false);
        }
        m1907a(drawable, z, false, false);
    }

    protected abstract void m1907a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void az(int i) {
        this.LL = i;
    }

    protected boolean m1908b(boolean z, boolean z2) {
        return this.LO && !z2 && (!z || this.LP);
    }
}
