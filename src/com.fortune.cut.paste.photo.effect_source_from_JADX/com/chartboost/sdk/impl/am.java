package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C0177f;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public abstract class am extends RelativeLayout {
    protected ai f358a;
    private an f359b;
    private C0206a f360c;

    /* renamed from: com.chartboost.sdk.impl.am.1 */
    class C02041 implements Runnable {
        final /* synthetic */ boolean f452a;
        final /* synthetic */ am f453b;

        C02041(am amVar, boolean z) {
            this.f453b = amVar;
            this.f452a = z;
        }

        public void run() {
            if (!this.f452a) {
                this.f453b.setVisibility(8);
                this.f453b.clearAnimation();
            }
            this.f453b.f358a.h.remove(Integer.valueOf(hashCode()));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.am.2 */
    static /* synthetic */ class C02052 {
        static final /* synthetic */ int[] f454a;

        static {
            f454a = new int[C0206a.values().length];
            try {
                f454a[C0206a.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f454a[C0206a.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f454a[C0206a.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f454a[C0206a.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.am.a */
    public enum C0206a {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    protected abstract View m650a();

    protected abstract int m653b();

    public am(Context context, ai aiVar) {
        super(context);
        this.f358a = aiVar;
        this.f360c = C0206a.BOTTOM;
        m648a(context);
    }

    public void m651a(C0206a c0206a) {
        if (c0206a == null) {
            throw new IllegalArgumentException("the given side cannot be null");
        }
        this.f360c = c0206a;
        LayoutParams layoutParams = null;
        setClickable(false);
        int b = m653b();
        switch (C02052.f454a[this.f360c.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.m109a(b, getContext()));
                layoutParams.addRule(10);
                this.f359b.m763b(1);
                break;
            case DataEvent.TYPE_DELETED /*2*/:
                layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.m109a(b, getContext()));
                layoutParams.addRule(12);
                this.f359b.m763b(4);
                break;
            case WalletFragmentState.PROCESSING /*3*/:
                layoutParams = new RelativeLayout.LayoutParams(CBUtility.m109a(b, getContext()), -1);
                layoutParams.addRule(9);
                this.f359b.m763b(8);
                break;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                layoutParams = new RelativeLayout.LayoutParams(CBUtility.m109a(b, getContext()), -1);
                layoutParams.addRule(11);
                this.f359b.m763b(2);
                break;
        }
        setLayoutParams(layoutParams);
    }

    private void m648a(Context context) {
        Context context2 = getContext();
        setGravity(17);
        this.f359b = new an(context2);
        this.f359b.m762a(-1);
        this.f359b.setBackgroundColor(-855638017);
        addView(this.f359b, new RelativeLayout.LayoutParams(-1, -1));
        addView(m650a(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void m652a(boolean z) {
        m649a(z, 250);
    }

    private void m649a(boolean z, long j) {
        this.f358a.f430y = z;
        if (!z || getVisibility() != 0) {
            if (z || getVisibility() != 8) {
                Animation translateAnimation;
                Runnable c02041 = new C02041(this, z);
                if (z) {
                    setVisibility(0);
                }
                float a = CBUtility.m108a((float) m653b(), getContext());
                float f;
                switch (C02052.f454a[this.f360c.ordinal()]) {
                    case DataEvent.TYPE_CHANGED /*1*/:
                        if (z) {
                            f = -a;
                        } else {
                            f = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, z ? 0.0f : -a);
                        break;
                    case DataEvent.TYPE_DELETED /*2*/:
                        if (z) {
                            f = a;
                        } else {
                            f = 0.0f;
                        }
                        if (z) {
                            a = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, a);
                        break;
                    case WalletFragmentState.PROCESSING /*3*/:
                        if (z) {
                            f = -a;
                        } else {
                            f = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(f, z ? 0.0f : -a, 0.0f, 0.0f);
                        break;
                    case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                        f = z ? a : 0.0f;
                        if (z) {
                            a = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(f, a, 0.0f, 0.0f);
                        break;
                    default:
                        translateAnimation = null;
                        break;
                }
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(!z);
                startAnimation(translateAnimation);
                this.f358a.h.put(Integer.valueOf(hashCode()), c02041);
                C0177f.f303a.postDelayed(c02041, j);
            }
        }
    }
}
