package com.google.android.gms.games.internal.constants;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String dZ(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "PUBLIC";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
