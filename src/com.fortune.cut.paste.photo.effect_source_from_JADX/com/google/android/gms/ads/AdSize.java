package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gq;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final int li;
    private final int lj;
    private final String lk;

    static {
        BANNER = new AdSize(320, 50, "320x50_mb");
        FULL_BANNER = new AdSize(468, 60, "468x60_as");
        LARGE_BANNER = new AdSize(320, 100, "320x100_as");
        LEADERBOARD = new AdSize(728, 90, "728x90_as");
        MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(FULL_WIDTH, AUTO_HEIGHT, "smart_banner");
    }

    public AdSize(int i, int i2) {
        this(i, i2, (i == FULL_WIDTH ? "FULL" : String.valueOf(i)) + "x" + (i2 == AUTO_HEIGHT ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != FULL_WIDTH) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == AUTO_HEIGHT) {
            this.li = i;
            this.lj = i2;
            this.lk = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.li == adSize.li && this.lj == adSize.lj && this.lk.equals(adSize.lk);
    }

    public final int getHeight() {
        return this.lj;
    }

    public final int getHeightInPixels(Context context) {
        return this.lj == AUTO_HEIGHT ? ay.m4200b(context.getResources().getDisplayMetrics()) : gq.m4763a(context, this.lj);
    }

    public final int getWidth() {
        return this.li;
    }

    public final int getWidthInPixels(Context context) {
        return this.li == FULL_WIDTH ? ay.m4199a(context.getResources().getDisplayMetrics()) : gq.m4763a(context, this.li);
    }

    public final int hashCode() {
        return this.lk.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.lj == AUTO_HEIGHT;
    }

    public final boolean isFullWidth() {
        return this.li == FULL_WIDTH;
    }

    public final String toString() {
        return this.lk;
    }
}
