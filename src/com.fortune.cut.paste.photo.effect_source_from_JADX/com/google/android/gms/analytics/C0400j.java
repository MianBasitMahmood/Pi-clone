package com.google.android.gms.analytics;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.wallet.WalletConstants;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.j */
public class C0400j implements C0399o {
    private final Set<Integer> yo;

    C0400j() {
        this.yo = new HashSet();
        this.yo.add(Integer.valueOf(302));
        this.yo.add(Integer.valueOf(WalletConstants.ERROR_CODE_INVALID_PARAMETERS));
        this.yo.add(Integer.valueOf(502));
    }

    public int eb() {
        return 2036;
    }

    public int ec() {
        return AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD;
    }

    public int ed() {
        return AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD;
    }

    public int ee() {
        return 20;
    }

    public long ef() {
        return 3600;
    }

    public String eg() {
        return "/collect";
    }

    public String eh() {
        return "/batch";
    }

    public C0398i ei() {
        return C0398i.BATCH_BY_SESSION;
    }

    public C0403l ej() {
        return C0403l.GZIP;
    }

    public Set<Integer> ek() {
        return this.yo;
    }
}
