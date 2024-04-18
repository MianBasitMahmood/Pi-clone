package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C0139j;

public class bj extends ImageView {
    protected TextView f509a;
    private C0139j f510b;

    public bj(Context context) {
        super(context);
        this.f510b = null;
        this.f509a = null;
    }

    public void m814a(C0139j c0139j) {
        if (this.f510b != c0139j) {
            this.f510b = c0139j;
            setImageDrawable(new BitmapDrawable(c0139j.m271f()));
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f510b = null;
        setImageDrawable(new BitmapDrawable(bitmap));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m813a(canvas);
    }

    protected void m813a(Canvas canvas) {
        if (this.f509a != null) {
            this.f509a.layout(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f509a.setEnabled(isEnabled());
            this.f509a.setSelected(isSelected());
            if (isFocused()) {
                this.f509a.requestFocus();
            } else {
                this.f509a.clearFocus();
            }
            this.f509a.setPressed(isPressed());
            this.f509a.draw(canvas);
        }
    }
}
