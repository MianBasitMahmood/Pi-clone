package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ka;
import com.google.android.gms.plus.internal.C1733g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int anA;
    private OnPlusOneClickListener anB;
    private View any;
    private int anz;
    private int mSize;
    private String vf;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener anC;
        final /* synthetic */ PlusOneButton anD;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener onPlusOneClickListener) {
            this.anD = plusOneButton;
            this.anC = onPlusOneClickListener;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.anD.any.getTag();
            if (this.anC != null) {
                this.anC.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.anD.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.anD.anA);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.anz = getAnnotation(context, attributeSet);
        this.anA = DEFAULT_ACTIVITY_REQUEST_CODE;
        m6269G(getContext());
        if (!isInEditMode()) {
        }
    }

    private void m6269G(Context context) {
        if (this.any != null) {
            removeView(this.any);
        }
        this.any = C1733g.m6353a(context, this.mSize, this.anz, this.vf, this.anA);
        setOnPlusOneClickListener(this.anB);
        addView(this.any);
    }

    protected static int getAnnotation(Context context, AttributeSet attributeSet) {
        String a = ka.m5241a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(a) ? SIZE_TALL : !"NONE".equalsIgnoreCase(a) ? SIZE_MEDIUM : SIZE_SMALL;
    }

    protected static int getSize(Context context, AttributeSet attributeSet) {
        String a = ka.m5241a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(a) ? SIZE_SMALL : "MEDIUM".equalsIgnoreCase(a) ? SIZE_MEDIUM : "TALL".equalsIgnoreCase(a) ? SIZE_TALL : SIZE_STANDARD;
    }

    public final void initialize(String str, int i) {
        jx.m5217a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.vf = str;
        this.anA = i;
        m6269G(getContext());
    }

    public final void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.vf = str;
        this.anA = SIZE_SMALL;
        m6269G(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.any.layout(SIZE_SMALL, SIZE_SMALL, i3 - i, i4 - i2);
    }

    protected final void onMeasure(int i, int i2) {
        View view = this.any;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void setAnnotation(int i) {
        this.anz = i;
        m6269G(getContext());
    }

    public final void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.anB = onPlusOneClickListener;
        this.any.setOnClickListener(new DefaultOnPlusOneClickListener(this, onPlusOneClickListener));
    }

    public final void setSize(int i) {
        this.mSize = i;
        m6269G(getContext());
    }
}
