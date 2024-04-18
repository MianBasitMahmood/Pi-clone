package com.chartboost.sdk.Model;

import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class CBError {
    private C0142a f169a;
    private String f170b;
    private boolean f171c;

    /* renamed from: com.chartboost.sdk.Model.CBError.1 */
    static /* synthetic */ class C01411 {
        static final /* synthetic */ int[] f158a;

        static {
            f158a = new int[C0142a.values().length];
            try {
                f158a[C0142a.MISCELLANEOUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f158a[C0142a.UNEXPECTED_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f158a[C0142a.PUBLIC_KEY_MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f158a[C0142a.INTERNET_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f158a[C0142a.HTTP_NOT_FOUND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f158a[C0142a.NETWORK_FAILURE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f158a[C0142a.INVALID_RESPONSE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public enum CBClickError {
        URI_INVALID,
        URI_UNRECOGNIZED,
        AGE_GATE_FAILURE,
        NO_HOST_ACTIVITY,
        INTERNAL
    }

    public enum CBImpressionError {
        INTERNAL,
        INTERNET_UNAVAILABLE,
        TOO_MANY_CONNECTIONS,
        WRONG_ORIENTATION,
        FIRST_SESSION_INTERSTITIALS_DISABLED,
        NETWORK_FAILURE,
        NO_AD_FOUND,
        SESSION_NOT_STARTED,
        IMPRESSION_ALREADY_VISIBLE,
        NO_HOST_ACTIVITY,
        USER_CANCELLATION,
        INVALID_LOCATION,
        VIDEO_UNAVAILABLE,
        VIDEO_ID_MISSING,
        ERROR_PLAYING_VIDEO,
        INVALID_RESPONSE,
        ASSETS_DOWNLOAD_FAILURE,
        ERROR_CREATING_VIEW,
        ERROR_DISPLAYING_VIEW
    }

    /* renamed from: com.chartboost.sdk.Model.CBError.a */
    public enum C0142a {
        MISCELLANEOUS,
        INTERNET_UNAVAILABLE,
        INVALID_RESPONSE,
        UNEXPECTED_RESPONSE,
        NETWORK_FAILURE,
        PUBLIC_KEY_MISSING,
        HTTP_NOT_FOUND
    }

    public CBError(C0142a c0142a, String str) {
        this.f169a = c0142a;
        this.f170b = str;
        this.f171c = true;
    }

    public final C0142a m280a() {
        return this.f169a;
    }

    public final String m281b() {
        return this.f170b;
    }

    public final CBImpressionError m282c() {
        switch (C01411.f158a[this.f169a.ordinal()]) {
            case DataEvent.TYPE_CHANGED /*1*/:
            case DataEvent.TYPE_DELETED /*2*/:
            case WalletFragmentState.PROCESSING /*3*/:
                return CBImpressionError.INTERNAL;
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return CBImpressionError.INTERNET_UNAVAILABLE;
            case Dimension.UNIT_MM /*5*/:
                return CBImpressionError.NO_AD_FOUND;
            default:
                return CBImpressionError.NETWORK_FAILURE;
        }
    }
}
