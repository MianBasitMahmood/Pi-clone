package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.C1030a;
import com.google.android.gms.internal.jx;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final bg lg;

    public static final class Builder {
        private final C1030a lh;

        public Builder() {
            this.lh = new C1030a();
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.lh.m4241b(cls, bundle);
            return this;
        }

        public final Builder addKeyword(String str) {
            this.lh.m4245r(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.lh.m4238a(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.lh.m4239a(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.lh.m4246s(str);
            return this;
        }

        public final AdRequest build() {
            return new AdRequest();
        }

        public final Builder setBirthday(Date date) {
            this.lh.m4240a(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            jx.m5219b((Object) str, (Object) "Content URL must be non-null.");
            jx.m5220b(str, (Object) "Content URL must be non-empty.");
            boolean z = str.length() <= AdRequest.MAX_CONTENT_URL_LENGTH;
            Object[] objArr = new Object[AdRequest.GENDER_FEMALE];
            objArr[AdRequest.GENDER_UNKNOWN] = Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH);
            objArr[AdRequest.GENDER_MALE] = Integer.valueOf(str.length());
            jx.m5222b(z, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
            this.lh.m4247t(str);
            return this;
        }

        public final Builder setGender(int i) {
            this.lh.m4242h(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.lh.m4237a(location);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.lh.m4244j(z);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
    }

    private AdRequest(Builder builder) {
        this.lg = new bg(builder.lh);
    }

    final bg m1437Y() {
        return this.lg;
    }

    public final Date getBirthday() {
        return this.lg.getBirthday();
    }

    public final String getContentUrl() {
        return this.lg.getContentUrl();
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.lg.getCustomEventExtrasBundle(cls);
    }

    public final int getGender() {
        return this.lg.getGender();
    }

    public final Set<String> getKeywords() {
        return this.lg.getKeywords();
    }

    public final Location getLocation() {
        return this.lg.getLocation();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.lg.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.lg.getNetworkExtrasBundle(cls);
    }

    public final boolean isTestDevice(Context context) {
        return this.lg.isTestDevice(context);
    }
}
