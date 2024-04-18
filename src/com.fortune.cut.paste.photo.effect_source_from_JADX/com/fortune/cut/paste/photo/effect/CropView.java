package com.fortune.cut.paste.photo.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.List;

public class CropView extends View implements OnTouchListener {
    public static List<C0359a> f1024a;
    int f1025b;
    boolean f1026c;
    C0359a f1027d;
    boolean f1028e;
    C0359a f1029f;
    Bitmap f1030g;
    Context f1031h;
    Path f1032i;
    private Paint f1033j;

    /* renamed from: com.fortune.cut.paste.photo.effect.CropView.a */
    class C0359a {
        float f1021a;
        float f1022b;
        final /* synthetic */ CropView f1023c;

        C0359a(CropView cropView) {
            this.f1023c = cropView;
        }

        public final String toString() {
            return this.f1021a + ", " + this.f1022b;
        }
    }

    public CropView(Context context, Bitmap bitmap) {
        super(context);
        this.f1025b = 2;
        this.f1026c = true;
        this.f1027d = null;
        this.f1028e = false;
        this.f1029f = null;
        this.f1032i = new Path();
        this.f1030g = bitmap;
        this.f1031h = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f1033j = new Paint(1);
        this.f1033j.setAntiAlias(true);
        this.f1033j.setDither(true);
        this.f1033j.setStyle(Style.STROKE);
        this.f1033j.setPathEffect(new DashPathEffect(new float[]{10.0f, 20.0f}, 0.0f));
        this.f1033j.setStrokeWidth(5.0f);
        this.f1033j.setColor(-1);
        setOnTouchListener(this);
        f1024a = new ArrayList();
        this.f1028e = false;
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1025b = 2;
        this.f1026c = true;
        this.f1027d = null;
        this.f1028e = false;
        this.f1029f = null;
        this.f1032i = new Path();
        this.f1031h = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f1033j = new Paint(1);
        this.f1033j.setAntiAlias(true);
        this.f1033j.setDither(true);
        this.f1033j.setStyle(Style.STROKE);
        this.f1033j.setStrokeWidth(2.0f);
        this.f1033j.setColor(-1);
        setOnTouchListener(this);
        f1024a = new ArrayList();
        this.f1028e = false;
    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f1030g, 0.0f, 0.0f, null);
        int i = 0;
        Object obj = 1;
        while (i < f1024a.size()) {
            Object obj2;
            C0359a c0359a = (C0359a) f1024a.get(i);
            if (obj != null) {
                this.f1032i.moveTo(c0359a.f1021a, c0359a.f1022b);
                obj2 = null;
            } else if (i < f1024a.size() - 1) {
                C0359a c0359a2 = (C0359a) f1024a.get(i + 1);
                this.f1032i.quadTo(c0359a.f1021a, c0359a.f1022b, c0359a2.f1021a, c0359a2.f1022b);
                obj2 = obj;
            } else {
                this.f1029f = (C0359a) f1024a.get(i);
                this.f1032i.lineTo(c0359a.f1021a, c0359a.f1022b);
                obj2 = obj;
            }
            i += 2;
            obj = obj2;
        }
        canvas.drawPath(this.f1032i, this.f1033j);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        C0359a c0359a = new C0359a(this);
        c0359a.f1021a = (float) ((int) motionEvent.getX());
        c0359a.f1022b = (float) ((int) motionEvent.getY());
        if (this.f1026c) {
            if (!this.f1028e) {
                f1024a.add(c0359a);
            } else if (m1425a(this.f1027d, c0359a)) {
                f1024a.add(this.f1027d);
                this.f1026c = false;
                MainActivity.m1427a().findViewById(R.id.optionLyt).setVisibility(0);
            } else {
                f1024a.add(c0359a);
            }
            if (!this.f1028e) {
                this.f1027d = c0359a;
                this.f1028e = true;
            }
        }
        invalidate();
        Log.e("Hi  ==>", "Size: " + c0359a.f1021a + " " + c0359a.f1022b);
        if (motionEvent.getAction() == 1) {
            Log.d("Action up*******~~~~~~~>>>>", "called");
            this.f1029f = c0359a;
            if (this.f1026c && f1024a.size() > 12 && !m1425a(this.f1027d, this.f1029f)) {
                this.f1026c = false;
                f1024a.add(this.f1027d);
                MainActivity.m1427a().findViewById(R.id.optionLyt).setVisibility(0);
            }
        }
        return true;
    }

    private static boolean m1425a(C0359a c0359a, C0359a c0359a2) {
        int i = (int) (c0359a2.f1022b - 3.0f);
        int i2 = (int) (c0359a2.f1021a + 3.0f);
        int i3 = (int) (c0359a2.f1022b + 3.0f);
        if (((float) ((int) (c0359a2.f1021a - 3.0f))) >= c0359a.f1021a || c0359a.f1021a >= ((float) i2) || ((float) i) >= c0359a.f1022b || c0359a.f1022b >= ((float) i3) || f1024a.size() < 10) {
            return false;
        }
        return true;
    }

    public final void m1426a() {
        f1024a.clear();
        this.f1033j.setColor(-1);
        this.f1033j.setStyle(Style.STROKE);
        this.f1026c = true;
        this.f1027d = null;
        this.f1029f = null;
        this.f1028e = false;
        this.f1032i.reset();
        invalidate();
    }
}
