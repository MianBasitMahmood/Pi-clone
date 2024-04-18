package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class RequestUpdateResultOutcome {
    private RequestUpdateResultOutcome() {
    }

    public static boolean isValid(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case WalletFragmentState.PROCESSING /*3*/:
                return true;
            default:
                return false;
        }
    }
}
