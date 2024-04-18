package com.google.android.gms.maps.internal;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C1602a {
    public static Boolean m6140a(byte b) {
        switch (b) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return Boolean.FALSE;
            case DataEvent.TYPE_CHANGED /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m6141c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
