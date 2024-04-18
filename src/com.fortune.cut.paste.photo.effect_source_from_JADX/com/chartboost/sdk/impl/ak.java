package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.google.android.gms.cast.TextTrackStyle;

public class ak extends bn {
    private Paint f437a;
    private Paint f438b;
    private Path f439c;
    private RectF f440d;
    private RectF f441e;
    private int f442f;
    private float f443g;
    private float f444h;

    public ak(Context context) {
        super(context);
        this.f442f = 0;
        m748a(context);
    }

    private void m748a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f443g = 4.5f * f;
        this.f437a = new Paint();
        this.f437a.setColor(-1);
        this.f437a.setStyle(Style.STROKE);
        this.f437a.setStrokeWidth(f * TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f437a.setAntiAlias(true);
        this.f438b = new Paint();
        this.f438b.setColor(-855638017);
        this.f438b.setStyle(Style.FILL);
        this.f438b.setAntiAlias(true);
        this.f439c = new Path();
        this.f441e = new RectF();
        this.f440d = new RectF();
    }

    protected void m751a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f440d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        int min = Math.min(1, Math.round(f * 0.5f));
        this.f440d.inset((float) min, (float) min);
        this.f439c.reset();
        this.f439c.addRoundRect(this.f440d, this.f443g, this.f443g, Direction.CW);
        canvas.save();
        canvas.clipPath(this.f439c);
        canvas.drawColor(this.f442f);
        this.f441e.set(this.f440d);
        this.f441e.right = ((this.f441e.right - this.f441e.left) * this.f444h) + this.f441e.left;
        canvas.drawRect(this.f441e, this.f438b);
        canvas.restore();
        canvas.drawRoundRect(this.f440d, this.f443g, this.f443g, this.f437a);
    }

    public void m750a(int i) {
        this.f442f = i;
        invalidate();
    }

    public void m753b(int i) {
        this.f437a.setColor(i);
        invalidate();
    }

    public void m754c(int i) {
        this.f438b.setColor(i);
        invalidate();
    }

    public void m749a(float f) {
        this.f444h = f;
        if (getVisibility() != 8) {
            invalidate();
        }
    }

    public void m752b(float f) {
        this.f443g = f;
    }
}
