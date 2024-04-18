package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class bm extends Animation {
    private final float f749a;
    private final float f750b;
    private final float f751c;
    private final float f752d;
    private boolean f753e;
    private Camera f754f;

    public bm(float f, float f2, float f3, float f4, boolean z) {
        this.f753e = true;
        this.f749a = f;
        this.f750b = f2;
        this.f751c = f3;
        this.f752d = f4;
        this.f753e = z;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f754f = new Camera();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f749a + ((this.f750b - this.f749a) * f);
        Camera camera = this.f754f;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f753e) {
            camera.rotateY(f2);
        } else {
            camera.rotateX(f2);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.f751c, -this.f752d);
        matrix.postTranslate(this.f751c, this.f752d);
    }
}
