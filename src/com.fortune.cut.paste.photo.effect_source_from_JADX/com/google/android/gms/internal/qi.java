package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0748c;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.dynamic.C0757g;
import com.google.android.gms.internal.qd.C1455a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class qi extends C0757g<qd> {
    private static qi awH;

    protected qi() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static qa m5902a(Activity activity, C0748c c0748c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((qd) rg().m2595L(activity)).m5859a(C0755e.m2594k(activity), c0748c, walletFragmentOptions, qbVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static qi rg() {
        if (awH == null) {
            awH = new qi();
        }
        return awH;
    }

    protected qd bW(IBinder iBinder) {
        return C1455a.bS(iBinder);
    }

    protected /* synthetic */ Object m5903d(IBinder iBinder) {
        return bW(iBinder);
    }
}
