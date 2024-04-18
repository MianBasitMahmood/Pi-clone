package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;
import com.google.android.gms.cast.TextTrackStyle;

public class an extends LinearLayout {
    private Paint f460a;
    private float f461b;
    private int f462c;

    public an(Context context) {
        super(context);
        this.f461b = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.f462c = 0;
        int round = Math.round(context.getResources().getDisplayMetrics().density * 5.0f);
        setPadding(round, round, round, round);
        setBaselineAligned(false);
        this.f460a = new Paint();
        this.f460a.setStyle(Style.FILL);
    }

    public void m762a(int i) {
        this.f460a.setColor(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = getContext().getResources().getDisplayMetrics().density;
        if ((this.f462c & 1) > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), this.f461b * f, this.f460a);
        }
        if ((this.f462c & 2) > 0) {
            canvas.drawRect(((float) canvas.getWidth()) - (this.f461b * f), 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f460a);
        }
        if ((this.f462c & 4) > 0) {
            canvas.drawRect(0.0f, ((float) canvas.getHeight()) - (this.f461b * f), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f460a);
        }
        if ((this.f462c & 8) > 0) {
            canvas.drawRect(0.0f, 0.0f, this.f461b * f, (float) canvas.getHeight(), this.f460a);
        }
    }

    public void m763b(int i) {
        this.f462c = i;
    }
}
