package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0366R;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jh;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lc;
import com.google.android.gms.internal.ll;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6587000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean Jg;
    public static boolean Jh;
    private static int Ji;
    private static final Object Jj;

    /* renamed from: com.google.android.gms.common.GooglePlayServicesUtil.a */
    private static class C0487a extends Handler {
        private final Context mO;

        C0487a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.mO = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mO);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.m1774a(isGooglePlayServicesAvailable, this.mO);
                    }
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
            }
        }
    }

    static {
        Jg = false;
        Jh = false;
        Ji = -1;
        Jj = new Object();
    }

    private GooglePlayServicesUtil() {
    }

    public static void m1769C(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent aj = aj(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (aj == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", aj);
        }
    }

    private static void m1770D(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Cast.MAX_NAMESPACE_LENGTH);
        } catch (Throwable e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6587000 but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    private static void m1771E(Context context) {
        Handler c0487a = new C0487a(context);
        c0487a.sendMessageDelayed(c0487a.obtainMessage(1), 120000);
    }

    private static String m1772F(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    private static Dialog m1773a(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder;
        Intent aj;
        OnClickListener jhVar;
        CharSequence c;
        if (lc.m5323K(activity) && i == 2) {
            i = 42;
        }
        if (ll.ij()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
                if (builder == null) {
                    builder = new Builder(activity);
                }
                builder.setMessage(m1779b((Context) activity, i));
                if (onCancelListener != null) {
                    builder.setOnCancelListener(onCancelListener);
                }
                aj = aj(i);
                jhVar = fragment != null ? new jh(activity, aj, i2) : new jh(fragment, aj, i2);
                c = m1784c(activity, i);
                if (c != null) {
                    builder.setPositiveButton(c, jhVar);
                }
                switch (i) {
                    case WalletFragmentState.UNKNOWN /*0*/:
                        return null;
                    case DataEvent.TYPE_CHANGED /*1*/:
                        return builder.setTitle(C0366R.string.common_google_play_services_install_title).create();
                    case DataEvent.TYPE_DELETED /*2*/:
                        return builder.setTitle(C0366R.string.common_google_play_services_update_title).create();
                    case WalletFragmentState.PROCESSING /*3*/:
                        return builder.setTitle(C0366R.string.common_google_play_services_enable_title).create();
                    case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                    case Error.OTHER /*6*/:
                        return builder.create();
                    case Dimension.UNIT_MM /*5*/:
                        Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                        return builder.setTitle(C0366R.string.common_google_play_services_invalid_account_title).create();
                    case Error.AVS_DECLINE /*7*/:
                        Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                        return builder.setTitle(C0366R.string.common_google_play_services_network_error_title).create();
                    case Error.FRAUD_DECLINE /*8*/:
                        Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                        return builder.create();
                    case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                        return builder.setTitle(C0366R.string.common_google_play_services_unsupported_title).create();
                    case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                        Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                        return builder.create();
                    case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                        Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                        return builder.create();
                    case 42:
                        return builder.setTitle(C0366R.string.common_android_wear_update_title).create();
                    default:
                        Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                        return builder.create();
                }
            }
        }
        builder = null;
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(m1779b((Context) activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        aj = aj(i);
        if (fragment != null) {
        }
        c = m1784c(activity, i);
        if (c != null) {
            builder.setPositiveButton(c, jhVar);
        }
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return null;
            case DataEvent.TYPE_CHANGED /*1*/:
                return builder.setTitle(C0366R.string.common_google_play_services_install_title).create();
            case DataEvent.TYPE_DELETED /*2*/:
                return builder.setTitle(C0366R.string.common_google_play_services_update_title).create();
            case WalletFragmentState.PROCESSING /*3*/:
                return builder.setTitle(C0366R.string.common_google_play_services_enable_title).create();
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
            case Error.OTHER /*6*/:
                return builder.create();
            case Dimension.UNIT_MM /*5*/:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                return builder.setTitle(C0366R.string.common_google_play_services_invalid_account_title).create();
            case Error.AVS_DECLINE /*7*/:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                return builder.setTitle(C0366R.string.common_google_play_services_network_error_title).create();
            case Error.FRAUD_DECLINE /*8*/:
                Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                return builder.create();
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                return builder.setTitle(C0366R.string.common_google_play_services_unsupported_title).create();
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                return builder.create();
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                return builder.create();
            case 42:
                return builder.setTitle(C0366R.string.common_android_wear_update_title).create();
            default:
                Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                return builder.create();
        }
    }

    private static void m1774a(int i, Context context) {
        Notification build;
        Resources resources = context.getResources();
        CharSequence d = m1786d(context, i);
        CharSequence string = resources.getString(C0366R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{m1772F(context)});
        PendingIntent errorPendingIntent = getErrorPendingIntent(i, context, 0);
        if (lc.m5323K(context)) {
            jx.m5215K(ll.ik());
            build = new Notification.Builder(context).setSmallIcon(C0366R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(d + " " + string)).addAction(C0366R.drawable.common_full_open_on_phone, resources.getString(C0366R.string.common_open_on_phone), errorPendingIntent).build();
        } else {
            Notification notification = new Notification(17301642, resources.getString(C0366R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
            notification.flags |= 16;
            notification.setLatestEventInfo(context, d, string, errorPendingIntent);
            build = notification;
        }
        ((NotificationManager) context.getSystemService("notification")).notify(ak(i), build);
    }

    public static boolean m1775a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean z = false;
        if (packageInfo == null) {
            return false;
        }
        if (m1785c(packageManager)) {
            return m1777a(packageInfo, true) != null;
        } else {
            if (m1777a(packageInfo, false) != null) {
                z = true;
            }
            if (z || m1777a(packageInfo, true) == null) {
                return z;
            }
            Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
            return z;
        }
    }

    public static boolean m1776a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (ll.ig() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m1783b(resources);
    }

    private static byte[] m1777a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        Object toByteArray = packageInfo.signatures[0].toByteArray();
        if ((z ? C0518b.gu() : C0518b.gv()).contains(toByteArray)) {
            return toByteArray;
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
        }
        return null;
    }

    private static byte[] m1778a(PackageInfo packageInfo, byte[]... bArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        byte[] toByteArray = packageInfo.signatures[0].toByteArray();
        for (byte[] bArr2 : bArr) {
            if (Arrays.equals(bArr2, toByteArray)) {
                return bArr2;
            }
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
        }
        return null;
    }

    public static Intent aj(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
                return jo.ba(GOOGLE_PLAY_SERVICES_PACKAGE);
            case WalletFragmentState.PROCESSING /*3*/:
                return jo.aY(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 42:
                return jo.hE();
            default:
                return null;
        }
    }

    private static int ak(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case WalletFragmentState.PROCESSING /*3*/:
                return 10436;
            default:
                return 39789;
        }
    }

    public static String m1779b(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return m1776a(context.getResources()) ? resources.getString(C0366R.string.common_google_play_services_install_text_tablet) : resources.getString(C0366R.string.common_google_play_services_install_text_phone);
            case DataEvent.TYPE_DELETED /*2*/:
                return resources.getString(C0366R.string.common_google_play_services_update_text);
            case WalletFragmentState.PROCESSING /*3*/:
                return resources.getString(C0366R.string.common_google_play_services_enable_text);
            case Dimension.UNIT_MM /*5*/:
                return resources.getString(C0366R.string.common_google_play_services_invalid_account_text);
            case Error.AVS_DECLINE /*7*/:
                return resources.getString(C0366R.string.common_google_play_services_network_error_text);
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return resources.getString(C0366R.string.common_google_play_services_unsupported_text);
            case 42:
                return resources.getString(C0366R.string.common_android_wear_update_text);
            default:
                return resources.getString(C0366R.string.common_google_play_services_unknown_issue);
        }
    }

    public static boolean m1781b(PackageManager packageManager) {
        synchronized (Jj) {
            if (Ji == -1) {
                try {
                    if (m1778a(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), C0518b.Jc[1]) != null) {
                        Ji = 1;
                    } else {
                        Ji = 0;
                    }
                } catch (NameNotFoundException e) {
                    Ji = 0;
                }
            }
        }
        return Ji != 0;
    }

    public static boolean m1782b(PackageManager packageManager, String str) {
        try {
            return m1775a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }

    private static boolean m1783b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return ll.ii() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    public static String m1784c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return resources.getString(C0366R.string.common_google_play_services_install_button);
            case DataEvent.TYPE_DELETED /*2*/:
            case 42:
                return resources.getString(C0366R.string.common_google_play_services_update_button);
            case WalletFragmentState.PROCESSING /*3*/:
                return resources.getString(C0366R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static boolean m1785c(PackageManager packageManager) {
        return m1781b(packageManager) || !gw();
    }

    public static String m1786d(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return resources.getString(C0366R.string.f1090x8f024ee1);
            case DataEvent.TYPE_DELETED /*2*/:
                return resources.getString(C0366R.string.common_google_play_services_notification_needs_update_title);
            case WalletFragmentState.PROCESSING /*3*/:
                return resources.getString(C0366R.string.common_google_play_services_needs_enabling_title);
            case Dimension.UNIT_MM /*5*/:
                return resources.getString(C0366R.string.common_google_play_services_invalid_account_text);
            case Error.AVS_DECLINE /*7*/:
                return resources.getString(C0366R.string.common_google_play_services_network_error_text);
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return resources.getString(C0366R.string.common_google_play_services_unsupported_text);
            case 42:
                return resources.getString(C0366R.string.common_android_wear_notification_needs_update_text);
            default:
                return resources.getString(C0366R.string.common_google_play_services_unknown_issue);
        }
    }

    public static boolean m1787e(Context context, int i) {
        if (i == 1) {
            try {
                if (context.getPackageManager().getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD).enabled) {
                    return true;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return false;
    }

    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return m1773a(i, activity, null, i2, onCancelListener);
    }

    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        Intent aj = aj(i);
        return aj == null ? null : PendingIntent.getActivity(context, i2, aj, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int i) {
        switch (i) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "SUCCESS";
            case DataEvent.TYPE_CHANGED /*1*/:
                return "SERVICE_MISSING";
            case DataEvent.TYPE_DELETED /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case WalletFragmentState.PROCESSING /*3*/:
                return "SERVICE_DISABLED";
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return "SIGN_IN_REQUIRED";
            case Dimension.UNIT_MM /*5*/:
                return "INVALID_ACCOUNT";
            case Error.OTHER /*6*/:
                return "RESOLUTION_REQUIRED";
            case Error.AVS_DECLINE /*7*/:
                return "NETWORK_ERROR";
            case Error.FRAUD_DECLINE /*8*/:
                return "INTERNAL_ERROR";
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return "SERVICE_INVALID";
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                return "DEVELOPER_ERROR";
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean gw() {
        return Jg ? Jh : "user".equals(Build.TYPE);
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (!jf.Mv) {
            try {
                context.getResources().getString(C0366R.string.common_google_play_services_unknown_issue);
            } catch (Throwable th) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
        }
        if (!jf.Mv) {
            m1770D(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (lc.aU(packageInfo.versionCode)) {
                int i = gw() ? 0 : 1;
                if (m1778a(packageInfo, C0518b.Ix[i], C0518b.IE[i], C0518b.IC[i]) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
                    return 9;
                }
                String packageName = context.getPackageName();
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 64);
                    if (!m1775a(packageManager, packageInfo2)) {
                        Log.w("GooglePlayServicesUtil", "Calling package " + packageInfo2.packageName + " signature invalid on Glass.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + packageName);
                    return 9;
                }
            } else if (!lc.m5323K(context)) {
                try {
                    if (m1778a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), C0518b.Ix) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (m1778a(packageInfo, m1778a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), C0518b.Ix)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (m1778a(packageInfo, C0518b.Ix) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (lc.aS(packageInfo.versionCode) < lc.aS(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6587000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (NameNotFoundException e3) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e3.printStackTrace();
                return 1;
            }
        } catch (NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isGoogleSignedUid(PackageManager packageManager, int i) {
        if (packageManager == null) {
            throw new SecurityException("Unknown error: invalid Package Manager");
        }
        String[] packagesForUid = packageManager.getPackagesForUid(i);
        if (packagesForUid.length != 0 && m1782b(packageManager, packagesForUid[0])) {
            return true;
        }
        throw new SecurityException("Uid is not Google Signed");
    }

    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case WalletFragmentState.PROCESSING /*3*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        boolean z = false;
        Dialog a = m1773a(i, activity, fragment, i2, onCancelListener);
        if (a == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(a, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (ll.ig()) {
            ErrorDialogFragment.newInstance(a, onCancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int i, Context context) {
        if (lc.m5323K(context) && i == 2) {
            i = 42;
        }
        if (m1787e(context, i)) {
            m1771E(context);
        } else {
            m1774a(i, context);
        }
    }
}
