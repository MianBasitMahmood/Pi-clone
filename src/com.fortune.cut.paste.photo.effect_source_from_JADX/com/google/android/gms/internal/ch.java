package com.google.android.gms.internal;

import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;
import java.util.HashMap;
import java.util.Map;

@ey
public class ch implements cd {
    static final Map<String, Integer> qb;

    static {
        Map hashMap = new HashMap();
        qb = hashMap;
        hashMap.put("resize", Integer.valueOf(1));
        qb.put("playVideo", Integer.valueOf(2));
        qb.put("storePicture", Integer.valueOf(3));
        qb.put("createCalendarEvent", Integer.valueOf(4));
    }

    public void m4349a(gu guVar, Map<String, String> map) {
        switch (((Integer) qb.get((String) map.get("a"))).intValue()) {
            case DataEvent.TYPE_CHANGED /*1*/:
                new di(guVar, map).execute();
            case WalletFragmentState.PROCESSING /*3*/:
                new dj(guVar, map).execute();
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                new dh(guVar, map).execute();
            default:
                gr.m4771U("Unknown MRAID command called.");
        }
    }
}
