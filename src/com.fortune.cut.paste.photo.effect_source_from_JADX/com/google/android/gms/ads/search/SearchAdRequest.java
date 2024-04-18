package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.C1030a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final bg lg;
    private final int xA;
    private final int xB;
    private final int xC;
    private final int xD;
    private final int xE;
    private final int xF;
    private final int xG;
    private final int xH;
    private final String xI;
    private final int xJ;
    private final String xK;
    private final int xL;
    private final int xM;
    private final String xN;

    public static final class Builder {
        private final C1030a lh;
        private int xA;
        private int xB;
        private int xC;
        private int xD;
        private int xE;
        private int xF;
        private int xG;
        private int xH;
        private String xI;
        private int xJ;
        private String xK;
        private int xL;
        private int xM;
        private String xN;

        public Builder() {
            this.lh = new C1030a();
            this.xG = SearchAdRequest.ERROR_CODE_INTERNAL_ERROR;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.lh.m4241b(cls, bundle);
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

        public final SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public final Builder setAnchorTextColor(int i) {
            this.xA = i;
            return this;
        }

        public final Builder setBackgroundColor(int i) {
            this.xB = i;
            this.xC = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.xD = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            return this;
        }

        public final Builder setBackgroundGradient(int i, int i2) {
            this.xB = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.xC = i2;
            this.xD = i;
            return this;
        }

        public final Builder setBorderColor(int i) {
            this.xE = i;
            return this;
        }

        public final Builder setBorderThickness(int i) {
            this.xF = i;
            return this;
        }

        public final Builder setBorderType(int i) {
            this.xG = i;
            return this;
        }

        public final Builder setCallButtonColor(int i) {
            this.xH = i;
            return this;
        }

        public final Builder setCustomChannels(String str) {
            this.xI = str;
            return this;
        }

        public final Builder setDescriptionTextColor(int i) {
            this.xJ = i;
            return this;
        }

        public final Builder setFontFace(String str) {
            this.xK = str;
            return this;
        }

        public final Builder setHeaderTextColor(int i) {
            this.xL = i;
            return this;
        }

        public final Builder setHeaderTextSize(int i) {
            this.xM = i;
            return this;
        }

        public final Builder setLocation(Location location) {
            this.lh.m4237a(location);
            return this;
        }

        public final Builder setQuery(String str) {
            this.xN = str;
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

    private SearchAdRequest(Builder builder) {
        this.xA = builder.xA;
        this.xB = builder.xB;
        this.xC = builder.xC;
        this.xD = builder.xD;
        this.xE = builder.xE;
        this.xF = builder.xF;
        this.xG = builder.xG;
        this.xH = builder.xH;
        this.xI = builder.xI;
        this.xJ = builder.xJ;
        this.xK = builder.xK;
        this.xL = builder.xL;
        this.xM = builder.xM;
        this.xN = builder.xN;
        this.lg = new bg(builder.lh, this);
    }

    final bg m1464Y() {
        return this.lg;
    }

    public final int getAnchorTextColor() {
        return this.xA;
    }

    public final int getBackgroundColor() {
        return this.xB;
    }

    public final int getBackgroundGradientBottom() {
        return this.xC;
    }

    public final int getBackgroundGradientTop() {
        return this.xD;
    }

    public final int getBorderColor() {
        return this.xE;
    }

    public final int getBorderThickness() {
        return this.xF;
    }

    public final int getBorderType() {
        return this.xG;
    }

    public final int getCallButtonColor() {
        return this.xH;
    }

    public final String getCustomChannels() {
        return this.xI;
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.lg.getCustomEventExtrasBundle(cls);
    }

    public final int getDescriptionTextColor() {
        return this.xJ;
    }

    public final String getFontFace() {
        return this.xK;
    }

    public final int getHeaderTextColor() {
        return this.xL;
    }

    public final int getHeaderTextSize() {
        return this.xM;
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

    public final String getQuery() {
        return this.xN;
    }

    public final boolean isTestDevice(Context context) {
        return this.lg.isTestDevice(context);
    }
}
