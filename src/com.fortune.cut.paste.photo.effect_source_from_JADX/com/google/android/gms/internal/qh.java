package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.qc.C1453a;
import com.google.android.gms.internal.qf.C1459a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class qh extends jl<qc> {
    private final String DZ;
    private final int avV;
    private final int mTheme;
    private final Activity nB;

    /* renamed from: com.google.android.gms.internal.qh.a */
    private static class C1468a extends C1459a {
        private C1468a() {
        }

        public void m5885a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void m5886a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void m5887a(int i, boolean z, Bundle bundle) {
        }

        public void m5888a(Status status, py pyVar, Bundle bundle) {
        }

        public void m5889i(int i, Bundle bundle) {
        }
    }

    /* renamed from: com.google.android.gms.internal.qh.b */
    final class C1469b extends C1468a {
        private final int My;
        final /* synthetic */ qh awG;

        public C1469b(qh qhVar, int i) {
            this.awG = qhVar;
            super();
            this.My = i;
        }

        public final void m5890a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public final void m5891a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public final void m5892a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public final void m5893i(int i, Bundle bundle) {
            jx.m5219b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public qh(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.nB = activity;
        this.avV = i;
        this.DZ = str;
        this.mTheme = i2;
    }

    public static Bundle m5894a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    private Bundle rf() {
        return m5894a(this.avV, this.nB.getPackageName(), this.DZ, this.mTheme);
    }

    protected void m5896a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5152k(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public void m5897a(FullWalletRequest fullWalletRequest, int i) {
        qf c1469b = new C1469b(this, i);
        try {
            ((qc) hw()).m5841a(fullWalletRequest, rf(), c1469b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c1469b.m5890a(8, null, Bundle.EMPTY);
        }
    }

    public void m5898a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle rf = rf();
        qf c1469b = new C1469b(this, i);
        try {
            ((qc) hw()).m5843a(maskedWalletRequest, rf, c1469b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c1469b.m5891a(8, null, Bundle.EMPTY);
        }
    }

    public void m5899a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((qc) hw()).m5844a(notifyTransactionStatusRequest, rf());
        } catch (RemoteException e) {
        }
    }

    protected String bK() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected qc bV(IBinder iBinder) {
        return C1453a.bR(iBinder);
    }

    public void m5900d(String str, String str2, int i) {
        Bundle rf = rf();
        Object c1469b = new C1469b(this, i);
        try {
            ((qc) hw()).m5846a(str, str2, rf, c1469b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c1469b.m5891a(8, null, Bundle.EMPTY);
        }
    }

    public void gk(int i) {
        Bundle rf = rf();
        qf c1469b = new C1469b(this, i);
        try {
            ((qc) hw()).m5839a(rf, c1469b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c1469b.m5892a(8, false, Bundle.EMPTY);
        }
    }

    protected /* synthetic */ IInterface m5901l(IBinder iBinder) {
        return bV(iBinder);
    }
}
