package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
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
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.jl.C1250e;
import com.google.android.gms.internal.mx.C1356a;
import com.google.android.gms.internal.my.C1360a;

public class mw extends jl<my> {
    private final String DZ;
    private C1357a afJ;
    private final int mTheme;
    private Activity nB;

    /* renamed from: com.google.android.gms.internal.mw.a */
    public static final class C1357a extends C1356a {
        private final int My;
        private Activity nB;

        public C1357a(int i, Activity activity) {
            this.My = i;
            this.nB = activity;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
        }

        public final void m5526g(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.nB.createPendingResult(this.My, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.nB, this.My);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.nB.createPendingResult(this.My, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public mw(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.DZ = str;
        this.nB = activity;
        this.mTheme = i;
    }

    public void m5527a(UserAddressRequest userAddressRequest, int i) {
        Bundle bundle;
        ne();
        this.afJ = new C1357a(i, this.nB);
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.DZ)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.DZ, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            nd().m5531a(this.afJ, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.afJ.m5526g(1, bundle);
        }
    }

    protected void m5528a(jt jtVar, C1250e c1250e) throws RemoteException {
        jtVar.m5138d(c1250e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected my aI(IBinder iBinder) {
        return C1360a.aK(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.afJ != null) {
            this.afJ.nB = null;
            this.afJ = null;
        }
    }

    protected /* synthetic */ IInterface m5529l(IBinder iBinder) {
        return aI(iBinder);
    }

    protected my nd() throws DeadObjectException {
        return (my) super.hw();
    }

    protected void ne() {
        super.dS();
    }
}
