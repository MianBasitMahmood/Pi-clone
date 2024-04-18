package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public final class CBInPlay {
    private static final String f53a;
    private static C0100a f54f;
    private String f55b;
    private Bitmap f56c;
    private String f57d;
    private C0111a f58e;

    static {
        f53a = CBInPlay.class.getSimpleName();
        f54f = null;
    }

    CBInPlay() {
    }

    public final void show() {
        C0100a.m82a().m91a(this);
    }

    public final void click() {
        C0100a.m82a().m93b(this);
    }

    public final String getLocation() {
        return this.f55b;
    }

    protected final void m71a(String str) {
        this.f55b = str;
    }

    public final Bitmap getAppIcon() {
        return this.f56c;
    }

    protected final void m69a(Bitmap bitmap) {
        this.f56c = bitmap;
    }

    public final String getAppName() {
        return this.f57d;
    }

    protected final void m72b(String str) {
        this.f57d = str;
    }

    protected final C0111a m68a() {
        return this.f58e;
    }

    protected final void m70a(C0111a c0111a) {
        this.f58e = c0111a;
    }

    public static void cacheInPlay(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b(f53a, "Inplay location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInPlay(str, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        if (f54f == null) {
            f54f = C0100a.m82a();
        }
        f54f.m92a(str);
    }

    public static boolean hasInPlay(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b(f53a, "Inplay location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInPlay(str, CBImpressionError.INVALID_LOCATION);
            }
            return false;
        }
        if (f54f == null) {
            f54f = C0100a.m82a();
        }
        return f54f.m94b(str);
    }

    public static CBInPlay getInPlay(String str) {
        C0153b.m404p();
        C0153b.m403o();
        C0153b.m402n();
        if (TextUtils.isEmpty(str)) {
            CBLogging.m101b(f53a, "Inplay location cannot be empty");
            if (C0153b.m387d() != null) {
                C0153b.m387d().didFailToLoadInPlay(str, CBImpressionError.INVALID_LOCATION);
            }
            return null;
        }
        if (f54f == null) {
            f54f = C0100a.m82a();
        }
        return f54f.m95c(str);
    }
}
