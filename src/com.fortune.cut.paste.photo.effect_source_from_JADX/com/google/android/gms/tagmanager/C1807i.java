package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1022b;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1807i extends dg {
    private static final String ID;
    private static final String URL;
    private static final String aqf;
    private static final String aqg;
    static final String aqh;
    private static final Set<String> aqi;
    private final C1805a aqj;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i.a */
    public interface C1805a {
        aq pf();
    }

    /* renamed from: com.google.android.gms.tagmanager.i.1 */
    class C18061 implements C1805a {
        final /* synthetic */ Context nf;

        C18061(Context context) {
            this.nf = context;
        }

        public aq pf() {
            return C1835y.m6703X(this.nf);
        }
    }

    static {
        ID = C0997a.ARBITRARY_PIXEL.toString();
        URL = C1022b.URL.toString();
        aqf = C1022b.ADDITIONAL_PARAMS.toString();
        aqg = C1022b.UNREPEATABLE.toString();
        aqh = "gtm_" + ID + "_unrepeatable";
        aqi = new HashSet();
    }

    public C1807i(Context context) {
        this(context, new C18061(context));
    }

    C1807i(Context context, C1805a c1805a) {
        super(ID, URL);
        this.aqj = c1805a;
        this.mContext = context;
    }

    private synchronized boolean cl(String str) {
        boolean z = true;
        synchronized (this) {
            if (!cn(str)) {
                if (cm(str)) {
                    aqi.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void m6645D(Map<String, C1070a> map) {
        String j = map.get(aqg) != null ? di.m6607j((C1070a) map.get(aqg)) : null;
        if (j == null || !cl(j)) {
            Builder buildUpon = Uri.parse(di.m6607j((C1070a) map.get(URL))).buildUpon();
            C1070a c1070a = (C1070a) map.get(aqf);
            if (c1070a != null) {
                Object o = di.m6612o(c1070a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m6458T("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m6458T("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aqj.pf().cB(uri);
            bh.m6460V("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1807i.class) {
                    aqi.add(j);
                    cz.m6590a(this.mContext, aqh, j, "true");
                }
            }
        }
    }

    boolean cm(String str) {
        return this.mContext.getSharedPreferences(aqh, 0).contains(str);
    }

    boolean cn(String str) {
        return aqi.contains(str);
    }
}
