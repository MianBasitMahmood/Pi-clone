package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String dZ(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "DAILY";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "WEEKLY";
            case DataEvent.TYPE_DELETED /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
