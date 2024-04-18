package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ey
public final class bg {
    public static final String DEVICE_ID_EMULATOR;
    private final Date f1129d;
    private final Set<String> f1130f;
    private final Location f1131h;
    private final String oA;
    private final SearchAdRequest oB;
    private final int oC;
    private final Set<String> oD;
    private final String ov;
    private final int ow;
    private final boolean ox;
    private final Bundle oy;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> oz;

    /* renamed from: com.google.android.gms.internal.bg.a */
    public static final class C1030a {
        private Date f1127d;
        private Location f1128h;
        private String oA;
        private int oC;
        private final HashSet<String> oE;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> oF;
        private final HashSet<String> oG;
        private String ov;
        private int ow;
        private boolean ox;
        private final Bundle oy;

        public C1030a() {
            this.oE = new HashSet();
            this.oy = new Bundle();
            this.oF = new HashMap();
            this.oG = new HashSet();
            this.ow = -1;
            this.ox = false;
            this.oC = -1;
        }

        public final void m4237a(Location location) {
            this.f1128h = location;
        }

        @Deprecated
        public final void m4238a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m4239a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.oF.put(networkExtras.getClass(), networkExtras);
            }
        }

        public final void m4239a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.oy.putBundle(cls.getName(), bundle);
        }

        public final void m4240a(Date date) {
            this.f1127d = date;
        }

        public final void m4241b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.oy.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public final void m4242h(int i) {
            this.ow = i;
        }

        public final void m4243i(boolean z) {
            this.ox = z;
        }

        public final void m4244j(boolean z) {
            this.oC = z ? 1 : 0;
        }

        public final void m4245r(String str) {
            this.oE.add(str);
        }

        public final void m4246s(String str) {
            this.oG.add(str);
        }

        public final void m4247t(String str) {
            this.ov = str;
        }

        public final void m4248u(String str) {
            this.oA = str;
        }
    }

    static {
        DEVICE_ID_EMULATOR = gq.m4762R("emulator");
    }

    public bg(C1030a c1030a) {
        this(c1030a, null);
    }

    public bg(C1030a c1030a, SearchAdRequest searchAdRequest) {
        this.f1129d = c1030a.f1127d;
        this.ov = c1030a.ov;
        this.ow = c1030a.ow;
        this.f1130f = Collections.unmodifiableSet(c1030a.oE);
        this.f1131h = c1030a.f1128h;
        this.ox = c1030a.ox;
        this.oy = c1030a.oy;
        this.oz = Collections.unmodifiableMap(c1030a.oF);
        this.oA = c1030a.oA;
        this.oB = searchAdRequest;
        this.oC = c1030a.oC;
        this.oD = Collections.unmodifiableSet(c1030a.oG);
    }

    public final SearchAdRequest bi() {
        return this.oB;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> bj() {
        return this.oz;
    }

    public final Bundle bk() {
        return this.oy;
    }

    public final int bl() {
        return this.oC;
    }

    public final Date getBirthday() {
        return this.f1129d;
    }

    public final String getContentUrl() {
        return this.ov;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getClass().getName()) : null;
    }

    public final int getGender() {
        return this.ow;
    }

    public final Set<String> getKeywords() {
        return this.f1130f;
    }

    public final Location getLocation() {
        return this.f1131h;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.ox;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.oz.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.oy.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.oA;
    }

    public final boolean isTestDevice(Context context) {
        return this.oD.contains(gq.m4768v(context));
    }
}
