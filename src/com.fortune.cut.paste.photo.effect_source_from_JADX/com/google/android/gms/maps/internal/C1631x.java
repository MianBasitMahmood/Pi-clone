package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0755e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C1604c.C1606a;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentState;

/* renamed from: com.google.android.gms.maps.internal.x */
public class C1631x {
    private static Context alI;
    private static C1604c alJ;

    public static C1604c m6174S(Context context) throws GooglePlayServicesNotAvailableException {
        jx.m5223i(context);
        if (alJ != null) {
            return alJ;
        }
        C1631x.m6175T(context);
        alJ = C1631x.m6176U(context);
        try {
            alJ.m6144a(C0755e.m2594k(C1631x.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return alJ;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m6175T(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case WalletFragmentState.UNKNOWN /*0*/:
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C1604c m6176U(Context context) {
        if (C1631x.nY()) {
            Log.i(C1631x.class.getSimpleName(), "Making Creator statically");
            return (C1604c) C1631x.m6178c(C1631x.nZ());
        }
        Log.i(C1631x.class.getSimpleName(), "Making Creator dynamically");
        return C1606a.aS((IBinder) C1631x.m6177a(C1631x.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static <T> T m6177a(ClassLoader classLoader, String str) {
        try {
            return C1631x.m6178c(((ClassLoader) jx.m5223i(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T m6178c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (alI == null) {
            if (C1631x.nY()) {
                alI = context.getApplicationContext();
            } else {
                alI = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return alI;
    }

    public static boolean nY() {
        return false;
    }

    private static Class<?> nZ() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
