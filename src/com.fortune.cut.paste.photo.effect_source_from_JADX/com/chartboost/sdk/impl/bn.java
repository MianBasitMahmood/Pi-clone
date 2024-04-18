package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public abstract class bn extends View {
    private Bitmap f435a;
    private Canvas f436b;

    protected abstract void m747a(Canvas canvas);

    public bn(Context context) {
        super(context);
        this.f435a = null;
        this.f436b = null;
        m745a(context);
    }

    private void m745a(Context context) {
        try {
            getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
        } catch (Exception e) {
        }
    }

    private boolean m746b(Canvas canvas) {
        try {
            return ((Boolean) Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(canvas, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    protected final void onDraw(Canvas canvas) {
        Canvas canvas2;
        boolean b = m746b(canvas);
        if (b) {
            if (!(this.f435a != null && this.f435a.getWidth() == canvas.getWidth() && this.f435a.getHeight() == canvas.getHeight())) {
                if (!(this.f435a == null || this.f435a.isRecycled())) {
                    this.f435a.recycle();
                }
                try {
                    this.f435a = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
                    this.f436b = new Canvas(this.f435a);
                } catch (Throwable th) {
                    return;
                }
            }
            this.f435a.eraseColor(0);
            canvas2 = this.f436b;
        } else {
            canvas2 = canvas;
            canvas = null;
        }
        m747a(canvas2);
        if (b && canvas != null) {
            canvas.drawBitmap(this.f435a, 0.0f, 0.0f, null);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!(this.f435a == null || this.f435a.isRecycled())) {
            this.f435a.recycle();
        }
        this.f435a = null;
    }
}
