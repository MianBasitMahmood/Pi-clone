package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method apU;
    private static final Object ut;

    /* renamed from: com.google.android.gms.security.ProviderInstaller.1 */
    static class C17361 extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ ProviderInstallListener apV;
        final /* synthetic */ Context nf;

        C17361(Context context, ProviderInstallListener providerInstallListener) {
            this.nf = context;
            this.apV = providerInstallListener;
        }

        protected final Integer m6356c(Void... voidArr) {
            try {
                ProviderInstaller.installIfNeeded(this.nf);
                return Integer.valueOf(0);
            } catch (GooglePlayServicesRepairableException e) {
                return Integer.valueOf(e.getConnectionStatusCode());
            } catch (GooglePlayServicesNotAvailableException e2) {
                return Integer.valueOf(e2.errorCode);
            }
        }

        protected final void m6357d(Integer num) {
            if (num.intValue() == 0) {
                this.apV.onProviderInstalled();
                return;
            }
            this.apV.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.aj(num.intValue()));
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6356c((Void[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            m6357d((Integer) obj);
        }
    }

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    static {
        ut = new Object();
        apU = null;
    }

    private static void m6358V(Context context) throws ClassNotFoundException, NoSuchMethodException {
        apU = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        jx.m5219b((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.m1769C(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (ut) {
            try {
                if (apU == null) {
                    m6358V(remoteContext);
                }
                apU.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        jx.m5219b((Object) context, (Object) "Context must not be null");
        jx.m5219b((Object) providerInstallListener, (Object) "Listener must not be null");
        jx.aU("Must be called on the UI thread");
        new C17361(context, providerInstallListener).execute(new Void[0]);
    }
}
