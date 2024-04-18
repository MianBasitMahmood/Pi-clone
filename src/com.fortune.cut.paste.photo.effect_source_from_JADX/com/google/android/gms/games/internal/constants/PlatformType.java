package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class PlatformType {
    private PlatformType() {
    }

    public static String dZ(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "ANDROID";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "IOS";
            case DataEvent.TYPE_DELETED /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
