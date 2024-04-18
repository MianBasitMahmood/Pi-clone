package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0368a;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.Date;
import java.util.HashSet;

@ey
public final class dg {

    /* renamed from: com.google.android.gms.internal.dg.1 */
    static /* synthetic */ class C10821 {
        static final /* synthetic */ int[] rb;
        static final /* synthetic */ int[] rc;

        static {
            rc = new int[ErrorCode.values().length];
            try {
                rc[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rc[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rc[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rc[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            rb = new int[Gender.values().length];
            try {
                rb[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rb[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                rb[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m4417a(ErrorCode errorCode) {
        switch (C10821.rc[errorCode.ordinal()]) {
            case DataEvent.TYPE_DELETED /*2*/:
                return 1;
            case WalletFragmentState.PROCESSING /*3*/:
                return 2;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize m4418b(ay ayVar) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == ayVar.width && adSizeArr[i].getHeight() == ayVar.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(C0368a.m1438a(ayVar.width, ayVar.height, ayVar.op));
    }

    public static MediationAdRequest m4419d(av avVar) {
        return new MediationAdRequest(new Date(avVar.od), m4420l(avVar.oe), avVar.of != null ? new HashSet(avVar.of) : null, avVar.og, avVar.ol);
    }

    public static Gender m4420l(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return Gender.MALE;
            case DataEvent.TYPE_DELETED /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
