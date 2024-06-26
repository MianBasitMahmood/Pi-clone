package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.wearable.DataEvent;

public final class RequestType {
    private RequestType() {
    }

    public static String dZ(int i) {
        switch (i) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return "GIFT";
            case DataEvent.TYPE_DELETED /*2*/:
                return "WISH";
            default:
                GamesLog.m3243p("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
