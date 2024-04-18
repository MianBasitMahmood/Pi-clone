package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.C0153b;
import com.chartboost.sdk.Libraries.C0108c.C0107a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* renamed from: com.chartboost.sdk.Libraries.d */
public final class C0109d {
    private C0109d() {
    }

    protected static String m144a() {
        Info advertisingIdInfo;
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C0153b.m400l());
        } catch (IOException e) {
            advertisingIdInfo = null;
        } catch (GooglePlayServicesRepairableException e2) {
            advertisingIdInfo = null;
        } catch (GooglePlayServicesNotAvailableException e3) {
            advertisingIdInfo = null;
        } catch (Throwable e4) {
            CBLogging.m98a("CBIdentityAdv", "Security Exception when retrieving AD id", e4);
            advertisingIdInfo = null;
        } catch (Throwable e42) {
            CBLogging.m98a("CBIdentityAdv", "General Exception when retrieving AD id", e42);
            advertisingIdInfo = null;
        }
        if (advertisingIdInfo == null) {
            C0108c.m131a(C0107a.UNKNOWN);
            return null;
        }
        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
            C0108c.m131a(C0107a.TRACKING_DISABLED);
        } else {
            C0108c.m131a(C0107a.TRACKING_ENABLED);
        }
        try {
            UUID fromString = UUID.fromString(advertisingIdInfo.getId());
            ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            return C0105b.m127b(wrap.array());
        } catch (Throwable e5) {
            CBLogging.m102b("CBIdentityAdv", "Exception raised retrieveAdvertisingID", e5);
            return advertisingIdInfo.getId();
        }
    }
}
