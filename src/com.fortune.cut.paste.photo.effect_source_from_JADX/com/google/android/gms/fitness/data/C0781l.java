package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.C0776k.C0778a;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.data.l */
public class C0781l extends C0778a {
    private final OnDataPointListener UF;

    /* renamed from: com.google.android.gms.fitness.data.l.a */
    public static class C0780a {
        private static final C0780a UG;
        private final Map<OnDataPointListener, C0781l> UH;

        static {
            UG = new C0780a();
        }

        private C0780a() {
            this.UH = new HashMap();
        }

        public static C0780a jG() {
            return UG;
        }

        public C0781l m2664a(OnDataPointListener onDataPointListener) {
            C0781l c0781l;
            synchronized (this.UH) {
                c0781l = (C0781l) this.UH.get(onDataPointListener);
                if (c0781l == null) {
                    c0781l = new C0781l(null);
                    this.UH.put(onDataPointListener, c0781l);
                }
            }
            return c0781l;
        }

        public C0781l m2665b(OnDataPointListener onDataPointListener) {
            C0781l c0781l;
            synchronized (this.UH) {
                c0781l = (C0781l) this.UH.get(onDataPointListener);
            }
            return c0781l;
        }

        public C0781l m2666c(OnDataPointListener onDataPointListener) {
            C0781l c0781l;
            synchronized (this.UH) {
                c0781l = (C0781l) this.UH.remove(onDataPointListener);
                if (c0781l != null) {
                } else {
                    c0781l = new C0781l(null);
                }
            }
            return c0781l;
        }
    }

    private C0781l(OnDataPointListener onDataPointListener) {
        this.UF = (OnDataPointListener) jx.m5223i(onDataPointListener);
    }

    public void m2667c(DataPoint dataPoint) throws RemoteException {
        this.UF.onDataPoint(dataPoint);
    }
}
