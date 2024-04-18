package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0757g.C0756a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private View Jk;
    private OnClickListener Jl;
    private int mColor;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, SIZE_STANDARD);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Jl = null;
        setStyle(SIZE_STANDARD, SIZE_STANDARD);
    }

    private void m1788G(Context context) {
        if (this.Jk != null) {
            removeView(this.Jk);
        }
        try {
            this.Jk = jy.m5224b(context, this.mSize, this.mColor);
        } catch (C0756a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.Jk = m1789a(context, this.mSize, this.mColor);
        }
        addView(this.Jk);
        this.Jk.setEnabled(isEnabled());
        this.Jk.setOnClickListener(this);
    }

    private static Button m1789a(Context context, int i, int i2) {
        Button jzVar = new jz(context);
        jzVar.m5232a(context.getResources(), i, i2);
        return jzVar;
    }

    public final void onClick(View view) {
        if (this.Jl != null && view == this.Jk) {
            this.Jl.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.Jk.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.Jl = onClickListener;
        if (this.Jk != null) {
            this.Jk.setOnClickListener(this);
        }
    }

    public final void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public final void setStyle(int i, int i2) {
        boolean z = i >= 0 && i < 3;
        Object[] objArr = new Object[SIZE_WIDE];
        objArr[SIZE_STANDARD] = Integer.valueOf(i);
        jx.m5218a(z, "Unknown button size %d", objArr);
        z = i2 >= 0 && i2 < SIZE_ICON_ONLY;
        Object[] objArr2 = new Object[SIZE_WIDE];
        objArr2[SIZE_STANDARD] = Integer.valueOf(i2);
        jx.m5218a(z, "Unknown color scheme %s", objArr2);
        this.mSize = i;
        this.mColor = i2;
        m1788G(getContext());
    }
}
