package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

/* renamed from: com.google.android.gms.analytics.a */
class C0380a implements C0379q {
    private static Object xO;
    private static C0380a xP;
    private Context mContext;
    private Info xQ;
    private long xR;
    private String xS;
    private boolean xT;
    private Object xU;

    static {
        xO = new Object();
    }

    C0380a(Context context) {
        this.xT = false;
        this.xU = new Object();
        this.mContext = context.getApplicationContext();
    }

    private boolean m1480a(Info info, Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        C0402k.m1553y(this.mContext);
        C0402k el = C0402k.el();
        String value = el.getValue("&cid");
        synchronized (this.xU) {
            if (!this.xT) {
                this.xS = C0380a.m1482x(this.mContext);
                this.xT = true;
            } else if (TextUtils.isEmpty(this.xS)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    boolean ab = ab(id + value);
                    return ab;
                }
                this.xS = C0380a.aa(str + value);
            }
            Object aa = C0380a.aa(id + value);
            if (TextUtils.isEmpty(aa)) {
                return false;
            } else if (aa.equals(this.xS)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.xS)) {
                    str = value;
                } else {
                    ae.m1487V("Resetting the client id because Advertising Id changed.");
                    str = el.em();
                    ae.m1487V("New client Id: " + str);
                }
                ab = ab(id + str);
                return ab;
            }
        }
    }

    static String aa(String str) {
        if (an.ap("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, an.ap("MD5").digest(str.getBytes()))});
    }

    private boolean ab(String str) {
        try {
            String aa = C0380a.aa(str);
            ae.m1487V("Storing hashed adid.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(aa.getBytes());
            openFileOutput.close();
            this.xS = aa;
            return true;
        } catch (FileNotFoundException e) {
            ae.m1485T("Error creating hash file.");
            return false;
        } catch (IOException e2) {
            ae.m1485T("Error writing to hash file.");
            return false;
        }
    }

    public static C0379q m1481w(Context context) {
        if (xP == null) {
            synchronized (xO) {
                if (xP == null) {
                    xP = new C0380a(context);
                }
            }
        }
        return xP;
    }

    static String m1482x(Context context) {
        String str = null;
        try {
            FileInputStream openFileInput = context.openFileInput("gaClientIdData");
            byte[] bArr = new byte[Cast.MAX_NAMESPACE_LENGTH];
            int read = openFileInput.read(bArr, 0, Cast.MAX_NAMESPACE_LENGTH);
            if (openFileInput.available() > 0) {
                ae.m1488W("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                ae.m1486U("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    str = str2;
                    ae.m1488W("Error reading Hash file, deleting it.");
                    context.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            ae.m1488W("Error reading Hash file, deleting it.");
            context.deleteFile("gaClientIdData");
            return str;
        }
    }

    Info dP() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            ae.m1488W("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (GooglePlayServicesRepairableException e2) {
            ae.m1488W("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            ae.m1488W("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            ae.m1488W("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Throwable th) {
            ae.m1488W("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }

    public String getValue(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.xR > 1000) {
            Info dP = dP();
            if (m1480a(this.xQ, dP)) {
                this.xQ = dP;
            } else {
                this.xQ = new Info("", false);
            }
            this.xR = currentTimeMillis;
        }
        if (this.xQ != null) {
            if ("&adid".equals(str)) {
                return this.xQ.getId();
            }
            if ("&ate".equals(str)) {
                return this.xQ.isLimitAdTrackingEnabled() ? "0" : "1";
            }
        }
        return null;
    }
}
