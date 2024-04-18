package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.bf.C1023a;

@ey
public final class ba extends C1023a {
    private final AppEventListener os;

    public ba(AppEventListener appEventListener) {
        this.os = appEventListener;
    }

    public final void onAppEvent(String str, String str2) {
        this.os.onAppEvent(str, str2);
    }
}
