package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.regex.Pattern;

public final class lc {
    private static Pattern Oe;

    static {
        Oe = null;
    }

    public static boolean m5323K(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int aS(int i) {
        return i / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public static int aT(int i) {
        return (i % LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100;
    }

    public static boolean aU(int i) {
        return aT(i) == 3;
    }
}
