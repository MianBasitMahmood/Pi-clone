package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C0139j;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public abstract class bk extends RelativeLayout {
    private static Rect f352d;
    private C0265a f353a;
    private boolean f354b;
    protected Button f355c;
    private boolean f356e;

    /* renamed from: com.chartboost.sdk.impl.bk.1 */
    class C02631 implements OnTouchListener {
        final /* synthetic */ bk f735a;

        C02631(bk bkVar) {
            this.f735a = bkVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean a = bk.m637b(view, motionEvent);
            switch (motionEvent.getActionMasked()) {
                case WalletFragmentState.UNKNOWN /*0*/:
                    this.f735a.f353a.m1112a(a);
                    return a;
                case DataEvent.TYPE_CHANGED /*1*/:
                    if (this.f735a.getVisibility() == 0 && this.f735a.isEnabled() && a) {
                        this.f735a.m641a(motionEvent);
                    }
                    this.f735a.f353a.m1112a(false);
                    break;
                case DataEvent.TYPE_DELETED /*2*/:
                    this.f735a.f353a.m1112a(a);
                    break;
                case WalletFragmentState.PROCESSING /*3*/:
                case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    this.f735a.f353a.m1112a(false);
                    break;
            }
            return true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bk.2 */
    class C02642 implements OnClickListener {
        final /* synthetic */ bk f736a;

        C02642(bk bkVar) {
            this.f736a = bkVar;
        }

        public void onClick(View view) {
            this.f736a.m641a(null);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bk.a */
    public class C0265a extends bj {
        final /* synthetic */ bk f737b;

        public C0265a(bk bkVar, Context context) {
            this.f737b = bkVar;
            super(context);
            bkVar.f354b = false;
        }

        protected void m1112a(boolean z) {
            if (this.f737b.f356e && z) {
                if (!this.f737b.f354b) {
                    if (getDrawable() != null) {
                        getDrawable().setColorFilter(1996488704, Mode.SRC_ATOP);
                    } else if (getBackground() != null) {
                        getBackground().setColorFilter(1996488704, Mode.SRC_ATOP);
                    }
                    invalidate();
                    this.f737b.f354b = true;
                }
            } else if (this.f737b.f354b) {
                if (getDrawable() != null) {
                    getDrawable().clearColorFilter();
                } else if (getBackground() != null) {
                    getBackground().clearColorFilter();
                }
                invalidate();
                this.f737b.f354b = false;
            }
        }

        public void m1111a(C0139j c0139j, LayoutParams layoutParams) {
            m814a(c0139j);
            layoutParams.width = c0139j.m273h();
            layoutParams.height = c0139j.m274i();
        }
    }

    protected abstract void m641a(MotionEvent motionEvent);

    static {
        f352d = new Rect();
    }

    public bk(Context context) {
        super(context);
        this.f354b = false;
        this.f355c = null;
        this.f356e = true;
        m636b();
    }

    private void m636b() {
        this.f353a = new C0265a(this, getContext());
        this.f353a.setOnTouchListener(new C02631(this));
        addView(this.f353a, new RelativeLayout.LayoutParams(-1, -1));
    }

    private static boolean m637b(View view, MotionEvent motionEvent) {
        view.getLocalVisibleRect(f352d);
        Rect rect = f352d;
        rect.left += view.getPaddingLeft();
        rect = f352d;
        rect.top += view.getPaddingTop();
        rect = f352d;
        rect.right -= view.getPaddingRight();
        rect = f352d;
        rect.bottom -= view.getPaddingBottom();
        return f352d.contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
    }

    public void m645a(String str) {
        if (str != null) {
            m640a().setText(str);
            addView(m640a(), new RelativeLayout.LayoutParams(-1, -1));
            this.f353a.setVisibility(8);
            m646a(false);
            this.f355c.setOnClickListener(new C02642(this));
        } else if (this.f355c != null) {
            removeView(m640a());
            this.f355c = null;
            this.f353a.setVisibility(0);
            m646a(true);
        }
    }

    public TextView m640a() {
        if (this.f355c == null) {
            this.f355c = new Button(getContext());
            this.f355c.setGravity(17);
        }
        this.f355c.postInvalidate();
        return this.f355c;
    }

    public void m643a(C0139j c0139j) {
        this.f353a.m814a(c0139j);
        m645a(null);
    }

    public void m644a(C0139j c0139j, RelativeLayout.LayoutParams layoutParams) {
        this.f353a.m1111a(c0139j, layoutParams);
        m645a(null);
    }

    public void m642a(ScaleType scaleType) {
        this.f353a.setScaleType(scaleType);
    }

    public void m646a(boolean z) {
        this.f356e = z;
    }
}
