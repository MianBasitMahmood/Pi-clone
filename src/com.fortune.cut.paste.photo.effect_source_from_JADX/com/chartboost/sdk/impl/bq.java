package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class bq extends bn {
    private static Handler f763a;
    private float f764b;
    private long f765c;
    private Paint f766d;
    private Paint f767e;
    private Path f768f;
    private Path f769g;
    private RectF f770h;
    private RectF f771i;
    private Runnable f772j;

    /* renamed from: com.chartboost.sdk.impl.bq.1 */
    class C02701 implements Runnable {
        final /* synthetic */ bq f762a;

        C02701(bq bqVar) {
            this.f762a = bqVar;
        }

        public void run() {
            float f = this.f762a.getContext().getResources().getDisplayMetrics().density;
            bq.m1132a(this.f762a, (BitmapDescriptorFactory.HUE_YELLOW * f) * 0.016666668f);
            f = ((float) this.f762a.getHeight()) - (f * 9.0f);
            if (this.f762a.f764b > f) {
                bq.m1134b(this.f762a, f * 2.0f);
            }
            if (this.f762a.getWindowVisibility() == 0) {
                this.f762a.invalidate();
            }
        }
    }

    static /* synthetic */ float m1132a(bq bqVar, float f) {
        float f2 = bqVar.f764b + f;
        bqVar.f764b = f2;
        return f2;
    }

    static /* synthetic */ float m1134b(bq bqVar, float f) {
        float f2 = bqVar.f764b - f;
        bqVar.f764b = f2;
        return f2;
    }

    static {
        f763a = CBUtility.m120e();
    }

    public bq(Context context) {
        super(context);
        this.f772j = new C02701(this);
        m1133a(context);
    }

    private void m1133a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f764b = 0.0f;
        this.f765c = (long) (((double) System.nanoTime()) / 1000000.0d);
        this.f766d = new Paint();
        this.f766d.setColor(-1);
        this.f766d.setStyle(Style.STROKE);
        this.f766d.setStrokeWidth(f * 3.0f);
        this.f766d.setAntiAlias(true);
        this.f767e = new Paint();
        this.f767e.setColor(-1);
        this.f767e.setStyle(Style.FILL);
        this.f767e.setAntiAlias(true);
        this.f768f = new Path();
        this.f769g = new Path();
        this.f771i = new RectF();
        this.f770h = new RectF();
    }

    protected final void m1135a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f770h.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f770h.inset(1.5f * f, 1.5f * f);
        float height = ((float) getHeight()) / 2.0f;
        canvas.drawRoundRect(this.f770h, height, height, this.f766d);
        this.f771i.set(this.f770h);
        this.f771i.inset(3.0f * f, f * 3.0f);
        f = this.f771i.height() / 2.0f;
        this.f768f.reset();
        this.f768f.addRoundRect(this.f771i, f, f, Direction.CW);
        height = this.f771i.height();
        this.f769g.reset();
        this.f769g.moveTo(0.0f, height);
        this.f769g.lineTo(height, height);
        this.f769g.lineTo(height * 2.0f, 0.0f);
        this.f769g.lineTo(height, 0.0f);
        this.f769g.close();
        canvas.save();
        Object obj = 1;
        try {
            canvas.clipPath(this.f768f);
        } catch (UnsupportedOperationException e) {
            obj = null;
        }
        if (obj != null) {
            for (f = (-height) + this.f764b; f < this.f771i.width() + height; f += 2.0f * height) {
                float f2 = this.f771i.left + f;
                canvas.save();
                canvas.translate(f2, this.f771i.top);
                canvas.drawPath(this.f769g, this.f767e);
                canvas.restore();
            }
        }
        canvas.restore();
        long max = Math.max(0, 16 - (((long) (((double) System.nanoTime()) / 1000000.0d)) - this.f765c));
        f763a.removeCallbacks(this.f772j);
        f763a.postDelayed(this.f772j, max);
    }

    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        f763a.removeCallbacks(this.f772j);
        if (i == 0) {
            f763a.post(this.f772j);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        f763a.removeCallbacks(this.f772j);
        f763a.post(this.f772j);
    }

    protected final void onDetachedFromWindow() {
        f763a.removeCallbacks(this.f772j);
        super.onDetachedFromWindow();
    }
}
