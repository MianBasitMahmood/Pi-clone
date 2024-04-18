package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.cast.TextTrackStyle;

public final class au extends bj {
    private RectF f511b;
    private Paint f512c;
    private Paint f513d;
    private BitmapShader f514e;
    private float f515f;

    public au(Context context) {
        super(context);
        this.f515f = 0.0f;
        m815a(context);
    }

    private void m815a(Context context) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f511b = new RectF();
        this.f512c = new Paint();
        this.f512c.setStyle(Style.STROKE);
        this.f512c.setStrokeWidth(Math.max(TextTrackStyle.DEFAULT_FONT_SCALE, f * TextTrackStyle.DEFAULT_FONT_SCALE));
        this.f512c.setAntiAlias(true);
    }

    public final void m817a(int i) {
        this.f512c.setColor(i);
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        float a = CBUtility.m108a((float) TextTrackStyle.DEFAULT_FONT_SCALE, getContext());
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.f514e == null) {
                if (bitmap != null) {
                    this.f514e = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
                    this.f513d = new Paint();
                    this.f513d.setAntiAlias(true);
                    this.f513d.setShader(this.f514e);
                } else {
                    postInvalidate();
                    return;
                }
            }
            float max = Math.max(((float) getWidth()) / ((float) bitmap.getWidth()), ((float) getHeight()) / ((float) bitmap.getHeight()));
            canvas.save();
            canvas.scale(max, max);
            this.f511b.set(0.0f, 0.0f, ((float) getWidth()) / max, ((float) getHeight()) / max);
            this.f511b.inset(a / (max * 2.0f), a / (max * 2.0f));
            canvas.drawRoundRect(this.f511b, this.f511b.width() * this.f515f, this.f511b.height() * this.f515f, this.f513d);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        this.f511b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f511b.inset(a / 2.0f, a / 2.0f);
        canvas.drawRoundRect(this.f511b, this.f511b.width() * this.f515f, this.f511b.height() * this.f515f, this.f512c);
    }

    public final void m816a(float f) {
        this.f515f = f;
        invalidate();
    }
}
