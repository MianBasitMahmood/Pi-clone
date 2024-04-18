package com.chartboost.sdk.Libraries;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.chartboost.sdk.Libraries.f */
public enum C0115f {
    PORTRAIT,
    LANDSCAPE,
    PORTRAIT_REVERSE,
    LANDSCAPE_REVERSE;
    
    public static final C0115f f110e;
    public static final C0115f f111f;
    public static final C0115f f112g;
    public static final C0115f f113h;

    /* renamed from: com.chartboost.sdk.Libraries.f.1 */
    static /* synthetic */ class C01141 {
        static final /* synthetic */ int[] f105a;

        static {
            f105a = new int[C0115f.values().length];
            try {
                f105a[C0115f.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f105a[C0115f.PORTRAIT_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f105a[C0115f.LANDSCAPE_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f105a[C0115f.PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f110e = PORTRAIT_REVERSE;
        f111f = PORTRAIT;
        f112g = LANDSCAPE;
        f113h = LANDSCAPE_REVERSE;
    }

    public final C0115f m188a() {
        switch (C01141.f105a[ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return f110e;
            case DataEvent.TYPE_DELETED /*2*/:
                return f113h;
            case WalletFragmentState.PROCESSING /*3*/:
                return f111f;
            default:
                return f112g;
        }
    }

    public final boolean m189b() {
        return this == PORTRAIT || this == PORTRAIT_REVERSE;
    }

    public final boolean m190c() {
        return this == LANDSCAPE || this == LANDSCAPE_REVERSE;
    }
}
