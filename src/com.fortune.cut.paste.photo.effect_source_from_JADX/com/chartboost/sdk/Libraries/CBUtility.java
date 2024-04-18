package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.C0153b;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public final class CBUtility {
    private static Boolean f79a;
    private static final X500Principal f80b;
    private static Handler f81c;

    static {
        f79a = null;
        f80b = new X500Principal("CN=Android Debug,O=Android,C=US");
    }

    private CBUtility() {
    }

    public static SharedPreferences m110a() {
        if (C0153b.m400l() != null) {
            return C0153b.m400l().getSharedPreferences("cbPrefs", 0);
        }
        throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before modifying or accessing preferences.");
    }

    public static boolean m117b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m115a(Context context) {
        int i;
        if (f79a == null) {
            int equals;
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                int i2 = 0;
                i = 0;
                while (i2 < signatureArr.length) {
                    try {
                        equals = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i2].toByteArray()))).getSubjectX500Principal().equals(f80b);
                        if (equals != 0) {
                            break;
                        }
                        i2++;
                        i = equals;
                    } catch (Exception e) {
                        equals = i;
                    }
                }
                equals = i;
            } catch (Exception e2) {
                equals = 0;
            }
            if ((context.getApplicationInfo().flags & 2) != 0) {
                i = 1;
            } else {
                i = 0;
            }
            f79a = Boolean.valueOf(equals | i);
        }
        return f79a.booleanValue();
    }

    public static String m111a(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            stringBuilder.append("?");
        }
        for (String str : map.keySet()) {
            String str2;
            if (stringBuilder.length() > 1) {
                stringBuilder.append("&");
            }
            String obj = map.get(str2).toString();
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                } catch (Throwable e) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e);
                }
            }
            str2 = "";
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append(obj != null ? URLEncoder.encode(obj, "UTF-8") : "");
        }
        return stringBuilder.toString();
    }

    public static float m116b(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int m109a(int i, Context context) {
        return Math.round(((float) i) * m116b(context));
    }

    public static float m108a(float f, Context context) {
        return m116b(context) * f;
    }

    public static C0115f m118c() {
        int i;
        Context l = C0153b.m400l();
        Display defaultDisplay = ((WindowManager) l.getSystemService("window")).getDefaultDisplay();
        int i2 = l.getResources().getConfiguration().orientation;
        int rotation = defaultDisplay.getRotation();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            Object obj = 3;
        } else if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        if (obj == 1) {
            obj = 1;
        } else if (obj == 2) {
            obj = null;
        } else if (i2 == 1) {
            i = 1;
        } else if (i2 == 2) {
            obj = null;
        } else {
            i = 1;
        }
        if (!(rotation == 0 || rotation == 2)) {
            if (obj == null) {
                i = 1;
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            switch (rotation) {
                case DataEvent.TYPE_CHANGED /*1*/:
                    return C0115f.f112g;
                case DataEvent.TYPE_DELETED /*2*/:
                    return C0115f.PORTRAIT_REVERSE;
                case WalletFragmentState.PROCESSING /*3*/:
                    return C0115f.f113h;
                default:
                    return C0115f.PORTRAIT;
            }
        }
        switch (rotation) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return C0115f.f110e;
            case DataEvent.TYPE_DELETED /*2*/:
                return C0115f.LANDSCAPE_REVERSE;
            case WalletFragmentState.PROCESSING /*3*/:
                return C0115f.f111f;
            default:
                return C0115f.LANDSCAPE;
        }
    }

    public static void throwProguardError(Exception exception) {
        if (exception instanceof NoSuchMethodException) {
            throw new IllegalStateException("Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
        }
        throw new RuntimeException(exception);
    }

    public static void m114a(HttpResponse httpResponse) {
        if (httpResponse != null) {
            try {
                if (httpResponse.getEntity() != null) {
                    m113a(httpResponse.getEntity());
                }
            } catch (Throwable e) {
                CBLogging.m102b("CBUtility", "Exception raised calling consumeQuietly over http response", e);
            }
        }
    }

    public static void m113a(HttpEntity httpEntity) {
        try {
            httpEntity.consumeContent();
        } catch (Throwable e) {
            CBLogging.m102b("CBUtility", "Exception raised calling entity.consumeContent()", e);
        }
    }

    public static String m119d() {
        String str = "%s %s %s";
        Object[] objArr = new Object[3];
        objArr[0] = "Chartboost-Android-SDK";
        objArr[1] = C0153b.m373a() == null ? "" : C0153b.m373a();
        objArr[2] = "5.1.2";
        return String.format(str, objArr);
    }

    public static Handler m120e() {
        return f81c;
    }

    public static void m112a(Handler handler) {
        f81c = handler;
    }
}
