package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wearable.DataEvent;

public final class iz extends Drawable implements Callback {
    private boolean LO;
    private int LV;
    private long LW;
    private int LX;
    private int LY;
    private int LZ;
    private int Ma;
    private boolean Mb;
    private C1237b Mc;
    private Drawable Md;
    private Drawable Me;
    private boolean Mf;
    private boolean Mg;
    private boolean Mh;
    private int Mi;
    private int mFrom;

    /* renamed from: com.google.android.gms.internal.iz.a */
    private static final class C1236a extends Drawable {
        private static final C1236a Mj;
        private static final C1235a Mk;

        /* renamed from: com.google.android.gms.internal.iz.a.a */
        private static final class C1235a extends ConstantState {
            private C1235a() {
            }

            public final int getChangingConfigurations() {
                return 0;
            }

            public final Drawable newDrawable() {
                return C1236a.Mj;
            }
        }

        static {
            Mj = new C1236a();
            Mk = new C1235a();
        }

        private C1236a() {
        }

        public final void draw(Canvas canvas) {
        }

        public final ConstantState getConstantState() {
            return Mk;
        }

        public final int getOpacity() {
            return -2;
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* renamed from: com.google.android.gms.internal.iz.b */
    static final class C1237b extends ConstantState {
        int Ml;
        int Mm;

        C1237b(C1237b c1237b) {
            if (c1237b != null) {
                this.Ml = c1237b.Ml;
                this.Mm = c1237b.Mm;
            }
        }

        public final int getChangingConfigurations() {
            return this.Ml;
        }

        public final Drawable newDrawable() {
            return new iz(this);
        }
    }

    public iz(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = C1236a.Mj;
        }
        this.Md = drawable;
        drawable.setCallback(this);
        C1237b c1237b = this.Mc;
        c1237b.Mm |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = C1236a.Mj;
        }
        this.Me = drawable2;
        drawable2.setCallback(this);
        c1237b = this.Mc;
        c1237b.Mm |= drawable2.getChangingConfigurations();
    }

    iz(C1237b c1237b) {
        this.LV = 0;
        this.LY = MotionEventCompat.ACTION_MASK;
        this.Ma = 0;
        this.LO = true;
        this.Mc = new C1237b(c1237b);
    }

    public final boolean canConstantState() {
        if (!this.Mf) {
            boolean z = (this.Md.getConstantState() == null || this.Me.getConstantState() == null) ? false : true;
            this.Mg = z;
            this.Mf = true;
        }
        return this.Mg;
    }

    public final void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.LV) {
            case DataEvent.TYPE_CHANGED /*1*/:
                this.LW = SystemClock.uptimeMillis();
                this.LV = 2;
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                if (this.LW >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.LW)) / ((float) this.LZ);
                    if (uptimeMillis < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.LV = 0;
                    }
                    float min = Math.min(uptimeMillis, TextTrackStyle.DEFAULT_FONT_SCALE);
                    this.Ma = (int) ((min * ((float) (this.LX - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.Ma;
        boolean z = this.LO;
        Drawable drawable = this.Md;
        Drawable drawable2 = this.Me;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.LY) {
                drawable2.setAlpha(this.LY);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.LY - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.LY);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.LY);
        }
        invalidateSelf();
    }

    public final int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.Mc.Ml) | this.Mc.Mm;
    }

    public final ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.Mc.Ml = getChangingConfigurations();
        return this.Mc;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.Md.getIntrinsicHeight(), this.Me.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.Md.getIntrinsicWidth(), this.Me.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.Mh) {
            this.Mi = Drawable.resolveOpacity(this.Md.getOpacity(), this.Me.getOpacity());
            this.Mh = true;
        }
        return this.Mi;
    }

    public final Drawable hh() {
        return this.Me;
    }

    public final void invalidateDrawable(Drawable drawable) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public final Drawable mutate() {
        if (!this.Mb && super.mutate() == this) {
            if (canConstantState()) {
                this.Md.mutate();
                this.Me.mutate();
                this.Mb = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected final void onBoundsChange(Rect rect) {
        this.Md.setBounds(rect);
        this.Me.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, runnable, j);
            }
        }
    }

    public final void setAlpha(int i) {
        if (this.Ma == this.LY) {
            this.Ma = i;
        }
        this.LY = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.Md.setColorFilter(colorFilter);
        this.Me.setColorFilter(colorFilter);
    }

    public final void startTransition(int i) {
        this.mFrom = 0;
        this.LX = this.LY;
        this.Ma = 0;
        this.LZ = i;
        this.LV = 1;
        invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, runnable);
            }
        }
    }
}
