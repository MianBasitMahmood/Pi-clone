package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.wearable.DataEvent;

public final class jb extends ImageView {
    private Uri Mn;
    private int Mo;
    private int Mp;
    private C1241a Mq;
    private int Mr;
    private float Ms;

    /* renamed from: com.google.android.gms.internal.jb.a */
    public interface C1241a {
        Path m5077g(int i, int i2);
    }

    public final void aB(int i) {
        this.Mo = i;
    }

    public final void m5078g(Uri uri) {
        this.Mn = uri;
    }

    public final int hj() {
        return this.Mo;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.Mq != null) {
            canvas.clipPath(this.Mq.m5077g(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.Mp != 0) {
            canvas.drawColor(this.Mp);
        }
    }

    protected final void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        super.onMeasure(i, i2);
        switch (this.Mr) {
            case DataEvent.TYPE_CHANGED /*1*/:
                measuredHeight = getMeasuredHeight();
                i3 = (int) (((float) measuredHeight) * this.Ms);
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                i3 = getMeasuredWidth();
                measuredHeight = (int) (((float) i3) / this.Ms);
                break;
            default:
                return;
        }
        setMeasuredDimension(i3, measuredHeight);
    }
}
