package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.widget.LinearLayout;
import com.chartboost.sdk.Libraries.C0113e.C0111a;

public abstract class ap extends LinearLayout {
    private Rect f484a;
    private Paint f485b;
    private Paint f486c;

    public abstract int m794a();

    public abstract void m795a(C0111a c0111a, int i);

    public ap(Context context) {
        super(context);
        this.f484a = new Rect();
        this.f485b = null;
        this.f486c = null;
    }

    protected void onDraw(Canvas canvas) {
        this.f484a.set(0, 0, canvas.getWidth(), canvas.getHeight());
        m792a(canvas, this.f484a);
        m793b(canvas, this.f484a);
    }

    private void m792a(Canvas canvas, Rect rect) {
        if (this.f486c == null) {
            this.f486c = new Paint();
            this.f486c.setStyle(Style.FILL);
            this.f486c.setColor(-1);
        }
        canvas.drawRect(rect, this.f486c);
    }

    private void m793b(Canvas canvas, Rect rect) {
        if (this.f485b == null) {
            this.f485b = new Paint();
            this.f485b.setStyle(Style.FILL);
            this.f485b.setAntiAlias(true);
        }
        this.f485b.setColor(-2631721);
        canvas.drawRect((float) rect.left, (float) (rect.bottom - 1), (float) rect.right, (float) rect.bottom, this.f485b);
    }
}
