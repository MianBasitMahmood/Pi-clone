package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@ey
public final class ae implements ag {
    private final Object mH;
    private final WeakHashMap<fy, af> mI;
    private final ArrayList<af> mJ;

    public ae() {
        this.mH = new Object();
        this.mI = new WeakHashMap();
        this.mJ = new ArrayList();
    }

    public final af m4115a(Context context, ay ayVar, fy fyVar, View view, gs gsVar) {
        af afVar;
        synchronized (this.mH) {
            if (m4118c(fyVar)) {
                afVar = (af) this.mI.get(fyVar);
            } else {
                afVar = new af(context, ayVar, fyVar, view, gsVar);
                afVar.m4129a((ag) this);
                this.mI.put(fyVar, afVar);
                this.mJ.add(afVar);
            }
        }
        return afVar;
    }

    public final af m4116a(ay ayVar, fy fyVar) {
        return m4115a(fyVar.se.getContext(), ayVar, fyVar, fyVar.se, fyVar.se.dG());
    }

    public final void m4117a(af afVar) {
        synchronized (this.mH) {
            if (!afVar.aM()) {
                this.mJ.remove(afVar);
            }
        }
    }

    public final boolean m4118c(fy fyVar) {
        boolean z;
        synchronized (this.mH) {
            af afVar = (af) this.mI.get(fyVar);
            z = afVar != null && afVar.aM();
        }
        return z;
    }

    public final void m4119d(fy fyVar) {
        synchronized (this.mH) {
            af afVar = (af) this.mI.get(fyVar);
            if (afVar != null) {
                afVar.aK();
            }
        }
    }

    public final void pause() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).pause();
            }
        }
    }

    public final void resume() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).resume();
            }
        }
    }

    public final void stop() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).stop();
            }
        }
    }
}
