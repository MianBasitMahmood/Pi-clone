package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1048c.C1043f;
import com.google.android.gms.internal.C1048c.C1046i;
import com.google.android.gms.internal.C1048c.C1047j;
import com.google.android.gms.internal.C1071d.C1070a;
import com.google.android.gms.tagmanager.C1825s.C1738a;
import com.google.android.gms.tagmanager.ce.C1770a;
import com.google.android.gms.tagmanager.cr.C1782c;
import com.google.android.gms.tagmanager.cr.C1786g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String aqm;
    private final DataLayer aqn;
    private ct aqo;
    private Map<String, FunctionCallMacroCallback> aqp;
    private Map<String, FunctionCallTagCallback> aqq;
    private volatile long aqr;
    private volatile String aqs;
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.a */
    private class C1739a implements C1738a {
        final /* synthetic */ Container aqt;

        private C1739a(Container container) {
            this.aqt = container;
        }

        public Object m6360b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback cp = this.aqt.cp(str);
            return cp == null ? null : cp.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.b */
    private class C1740b implements C1738a {
        final /* synthetic */ Container aqt;

        private C1740b(Container container) {
            this.aqt = container;
        }

        public Object m6361b(String str, Map<String, Object> map) {
            FunctionCallTagCallback cq = this.aqt.cq(str);
            if (cq != null) {
                cq.execute(str, map);
            }
            return di.ra();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, C1047j c1047j) {
        this.aqp = new HashMap();
        this.aqq = new HashMap();
        this.aqs = "";
        this.mContext = context;
        this.aqn = dataLayer;
        this.aqm = str;
        this.aqr = j;
        m6362a(c1047j.gs);
        if (c1047j.gr != null) {
            m6365a(c1047j.gr);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, C1782c c1782c) {
        this.aqp = new HashMap();
        this.aqq = new HashMap();
        this.aqs = "";
        this.mContext = context;
        this.aqn = dataLayer;
        this.aqm = str;
        this.aqr = j;
        m6363a(c1782c);
    }

    private void m6362a(C1043f c1043f) {
        if (c1043f == null) {
            throw new NullPointerException();
        }
        try {
            m6363a(cr.m6546b(c1043f));
        } catch (C1786g e) {
            bh.m6458T("Not loading resource: " + c1043f + " because it is invalid: " + e.toString());
        }
    }

    private void m6363a(C1782c c1782c) {
        this.aqs = c1782c.getVersion();
        C1782c c1782c2 = c1782c;
        m6364a(new ct(this.mContext, c1782c2, this.aqn, new C1739a(), new C1740b(), cs(this.aqs)));
    }

    private synchronized void m6364a(ct ctVar) {
        this.aqo = ctVar;
    }

    private void m6365a(C1046i[] c1046iArr) {
        List arrayList = new ArrayList();
        for (Object add : c1046iArr) {
            arrayList.add(add);
        }
        pk().m6577l(arrayList);
    }

    private synchronized ct pk() {
        return this.aqo;
    }

    FunctionCallMacroCallback cp(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.aqp) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.aqp.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback cq(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.aqq) {
            functionCallTagCallback = (FunctionCallTagCallback) this.aqq.get(str);
        }
        return functionCallTagCallback;
    }

    void cr(String str) {
        pk().cr(str);
    }

    ag cs(String str) {
        ce.qa().qb().equals(C1770a.CONTAINER_DEBUG);
        return new br();
    }

    public boolean getBoolean(String str) {
        ct pk = pk();
        if (pk == null) {
            bh.m6458T("getBoolean called for closed container.");
            return di.qY().booleanValue();
        }
        try {
            return di.m6611n((C1070a) pk.cT(str).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m6458T("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qY().booleanValue();
        }
    }

    public String getContainerId() {
        return this.aqm;
    }

    public double getDouble(String str) {
        ct pk = pk();
        if (pk == null) {
            bh.m6458T("getDouble called for closed container.");
            return di.qX().doubleValue();
        }
        try {
            return di.m6610m((C1070a) pk.cT(str).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m6458T("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qX().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.aqr;
    }

    public long getLong(String str) {
        ct pk = pk();
        if (pk == null) {
            bh.m6458T("getLong called for closed container.");
            return di.qW().longValue();
        }
        try {
            return di.m6609l((C1070a) pk.cT(str).getObject()).longValue();
        } catch (Exception e) {
            bh.m6458T("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qW().longValue();
        }
    }

    public String getString(String str) {
        ct pk = pk();
        if (pk == null) {
            bh.m6458T("getString called for closed container.");
            return di.ra();
        }
        try {
            return di.m6607j((C1070a) pk.cT(str).getObject());
        } catch (Exception e) {
            bh.m6458T("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.ra();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String pj() {
        return this.aqs;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.aqp) {
            this.aqp.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.aqq) {
            this.aqq.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.aqo = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.aqp) {
            this.aqp.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.aqq) {
            this.aqq.remove(str);
        }
    }
}
