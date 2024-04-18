package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case WalletFragmentState.UNKNOWN /*0*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case WalletFragmentState.PROCESSING /*3*/:
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
            case Dimension.UNIT_MM /*5*/:
            case Error.OTHER /*6*/:
                return true;
            case DataEvent.TYPE_CHANGED /*1*/:
            case Error.AVS_DECLINE /*7*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return false;
            default:
                return true;
        }
    }
}
