package com.chartboost.sdk.Tracking;

import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0104a;
import com.chartboost.sdk.Libraries.C0113e;
import com.chartboost.sdk.Libraries.C0113e.C0111a;
import com.chartboost.sdk.Libraries.C0131g;
import com.chartboost.sdk.Libraries.C0132h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0085c;
import com.chartboost.sdk.impl.ba;
import java.io.File;
import java.util.EnumMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CBAnalytics {

    /* renamed from: com.chartboost.sdk.Tracking.CBAnalytics.1 */
    static class C01501 implements C0085c {
        final /* synthetic */ String f222a;
        final /* synthetic */ CBIAPType f223b;

        C01501(String str, CBIAPType cBIAPType) {
            this.f222a = str;
            this.f223b = cBIAPType;
        }

        public final void m319a(C0111a c0111a, az azVar) {
            CBLogging.m97a("CBPostInstallTracker", this.f222a + " success response!!");
        }

        public final void m320a(C0111a c0111a, az azVar, CBError cBError) {
            if (this.f222a.equals("iap") && c0111a != null && c0111a.m164f("status") == 400 && this.f223b == CBIAPType.GOOGLE_PLAY) {
                CBLogging.m97a("CBPostInstallTracker", this.f222a + " 400 response from server!!");
                ba a = ba.m938a(C0153b.m400l());
                C0132h j = a.m957j();
                ConcurrentHashMap i = a.m956i();
                if (j != null && i != null) {
                    j.m242c((File) i.get(azVar));
                    i.remove(azVar);
                    return;
                }
                return;
            }
            CBLogging.m97a("CBPostInstallTracker", this.f222a + " failure response!!");
        }
    }

    public enum CBIAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    public enum CBIAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    private CBAnalytics() {
    }

    public synchronized void trackInAppPurchaseEvent(EnumMap<CBIAPPurchaseInfo, String> enumMap, CBIAPType cBIAPType) {
        if (!(enumMap == null || cBIAPType == null)) {
            if (!(TextUtils.isEmpty((CharSequence) enumMap.get(CBIAPPurchaseInfo.PRODUCT_ID)) || TextUtils.isEmpty((CharSequence) enumMap.get(CBIAPPurchaseInfo.PRODUCT_TITLE)) || TextUtils.isEmpty((CharSequence) enumMap.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION)) || TextUtils.isEmpty((CharSequence) enumMap.get(CBIAPPurchaseInfo.PRODUCT_PRICE)) || TextUtils.isEmpty((CharSequence) enumMap.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE)))) {
                m322a((String) enumMap.get(CBIAPPurchaseInfo.PRODUCT_ID), (String) enumMap.get(CBIAPPurchaseInfo.PRODUCT_TITLE), (String) enumMap.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION), (String) enumMap.get(CBIAPPurchaseInfo.PRODUCT_PRICE), (String) enumMap.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE), (String) enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_DATA), (String) enumMap.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE), (String) enumMap.get(CBIAPPurchaseInfo.AMAZON_USER_ID), (String) enumMap.get(CBIAPPurchaseInfo.AMAZON_PURCHASE_TOKEN), cBIAPType);
            }
        }
        CBLogging.m101b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
    }

    private static synchronized void m322a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CBIAPType cBIAPType) {
        synchronized (CBAnalytics.class) {
            if (C0153b.m400l() == null) {
                CBLogging.m101b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
            } else if (!C0153b.m401m()) {
                CBLogging.m101b("CBPostInstallTracker", "You need call Chartboost.OnStart() before tracking in-app purchases");
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                CBLogging.m101b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
            } else {
                try {
                    Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(str4);
                    matcher.find();
                    Object group = matcher.group();
                    if (TextUtils.isEmpty(group)) {
                        CBLogging.m101b("CBPostInstallTracker", "Invalid price object");
                    } else {
                        float parseFloat = Float.parseFloat(group);
                        C0111a c0111a = null;
                        if (cBIAPType == CBIAPType.GOOGLE_PLAY) {
                            if (TextUtils.isEmpty(str6) || TextUtils.isEmpty(str7)) {
                                CBLogging.m101b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
                            } else {
                                c0111a = C0113e.m180a(C0113e.m181a("purchaseData", str6), C0113e.m181a("purchaseSignature", str7), C0113e.m181a("type", Integer.valueOf(CBIAPType.GOOGLE_PLAY.ordinal())));
                            }
                        } else if (cBIAPType == CBIAPType.AMAZON) {
                            if (TextUtils.isEmpty(str8) || TextUtils.isEmpty(str9)) {
                                CBLogging.m101b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                            } else {
                                c0111a = C0113e.m180a(C0113e.m181a("userID", str8), C0113e.m181a("purchaseToken", str9), C0113e.m181a("type", Integer.valueOf(CBIAPType.AMAZON.ordinal())));
                            }
                        }
                        if (c0111a == null) {
                            CBLogging.m101b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
                        } else {
                            String encodeToString = Base64.encodeToString(c0111a.toString().getBytes(), 2);
                            m321a(C0113e.m180a(C0113e.m181a("localized-title", str2), C0113e.m181a("localized-description", str3), C0113e.m181a("price", Float.valueOf(parseFloat)), C0113e.m181a("currency", str5), C0113e.m181a("productID", str), C0113e.m181a("receipt", encodeToString)), "iap", cBIAPType);
                        }
                    }
                } catch (IllegalStateException e) {
                    CBLogging.m101b("CBPostInstallTracker", "Invalid price object");
                }
            }
        }
    }

    public static synchronized void trackInAppGooglePlayPurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m322a(str5, str, str2, str3, str4, str6, str7, null, null, CBIAPType.GOOGLE_PLAY);
        }
    }

    public static synchronized void trackInAppAmazonStorePurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        synchronized (CBAnalytics.class) {
            m322a(str5, str, str2, str3, str4, null, null, str6, str7, CBIAPType.AMAZON);
        }
    }

    private static synchronized void m321a(C0111a c0111a, String str, CBIAPType cBIAPType) {
        synchronized (CBAnalytics.class) {
            az azVar = new az(String.format(Locale.US, "%s%s", new Object[]{"/post-install-event/", str}));
            azVar.m891a(str, (Object) c0111a);
            azVar.m885a(C0131g.m221a(C0131g.m223a("status", C0104a.f83a)));
            azVar.m898b(str);
            azVar.m893a(true);
            azVar.m886a(new C01501(str, cBIAPType));
        }
    }
}
