package com.google.android.gms.games.internal.constants;

import java.util.ArrayList;

public class Capability {
    public static final ArrayList<String> acg;

    static {
        ArrayList arrayList = new ArrayList();
        acg = arrayList;
        arrayList.add("ibb");
        acg.add("rtp");
        acg.add("unreliable_ping");
    }
}
