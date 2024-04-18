package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.C0801l.C0802a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.request.a */
public class C0803a extends C0802a {
    private final BleScanCallback VC;

    /* renamed from: com.google.android.gms.fitness.request.a.a */
    public static class C0800a {
        private static final C0800a VD;
        private final Map<BleScanCallback, C0803a> VE;

        static {
            VD = new C0800a();
        }

        private C0800a() {
            this.VE = new HashMap();
        }

        public static C0800a jP() {
            return VD;
        }

        public C0803a m2734a(BleScanCallback bleScanCallback) {
            C0803a c0803a;
            synchronized (this.VE) {
                c0803a = (C0803a) this.VE.get(bleScanCallback);
                if (c0803a == null) {
                    c0803a = new C0803a(null);
                    this.VE.put(bleScanCallback, c0803a);
                }
            }
            return c0803a;
        }

        public C0803a m2735b(BleScanCallback bleScanCallback) {
            C0803a c0803a;
            synchronized (this.VE) {
                c0803a = (C0803a) this.VE.get(bleScanCallback);
                if (c0803a != null) {
                } else {
                    c0803a = new C0803a(null);
                }
            }
            return c0803a;
        }
    }

    private C0803a(BleScanCallback bleScanCallback) {
        this.VC = (BleScanCallback) jx.m5223i(bleScanCallback);
    }

    public void onDeviceFound(BleDevice bleDevice) throws RemoteException {
        this.VC.onDeviceFound(bleDevice);
    }

    public void onScanStopped() throws RemoteException {
        this.VC.onScanStopped();
    }
}
